package id.modefashion.printer;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.LoggerFactory;
import java.util.Iterator;

public class App {
  public static void main(String[] args) {
    // Register the GUI log appender as early as possible
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    Logger rootLogger = context.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    boolean alreadyAdded = false;
    Iterator<ch.qos.logback.core.Appender<ILoggingEvent>> it = rootLogger.iteratorForAppenders();
    while (it.hasNext()) {
      ch.qos.logback.core.Appender<ILoggingEvent> appender = it.next();
      if (appender instanceof LogbackTextAreaAppender) {
        alreadyAdded = true;
        break;
      }
    }
    if (!alreadyAdded) {
      LogbackTextAreaAppender guiAppender = new LogbackTextAreaAppender();
      guiAppender.setContext(context);
      guiAppender.start();
      rootLogger.addAppender(guiAppender);
    }
    // Launch the GUI
    javax.swing.SwingUtilities.invokeLater(() -> {
      PrinterGuiApp app = new PrinterGuiApp();
      app.setVisible(true);
    });
  }
}