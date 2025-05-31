package id.modefashion.printer;

import java.lang.reflect.Type;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import id.modefashion.printer.dto.ReceiptLineData;
import id.modefashion.printer.worker.ReceiptWorker;
import id.modefashion.printer.worker.ReceiptWorkerString;

public class PrintServer extends WebSocketServer {
  private Set<WebSocket> connections;
  private PropertiesConfiguration config;
  private static final Logger logger = LoggerFactory.getLogger(PrintServer.class);

  public PrintServer(PropertiesConfiguration config) {
    super(new InetSocketAddress(config.getInt("printer.port")));
    this.connections = Collections.synchronizedSet(new HashSet<WebSocket>());
    this.config = config;
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    logger.info("Connection open");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    logger.info("Connection close");
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    logger.debug("================== NEW RECEIPT MESSAGE ==================");
    Type listType = new TypeToken<List<ReceiptLineData>>() {
    }.getType();
    if (message.contains("type")) {
      List<ReceiptLineData> data = new Gson().fromJson(message, listType);
      ReceiptWorker worker = new ReceiptWorker(data, this.config);
      worker.proceed();
    } else {
      String data_string = message;
      ReceiptWorkerString worker = new ReceiptWorkerString(data_string, this.config);
      worker.proceed();
    }
    logger.debug("================== END RECEIPT MESSAGE ==================");
    // sendResponse("Success");
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {
    logger.error(ex.getMessage(), ex);
  }

  @Override
  public void onStart() {
    logger.info("================== PRINTER IS READY FOR PRINTING ===================");
  }
}
