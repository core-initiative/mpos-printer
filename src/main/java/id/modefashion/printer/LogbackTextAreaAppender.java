package id.modefashion.printer;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.classic.spi.ILoggingEvent;

import javax.swing.*;

public class LogbackTextAreaAppender extends AppenderBase<ILoggingEvent> {
    private static JTextArea textArea;

    public static void setTextArea(JTextArea area) {
        textArea = area;
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (textArea != null) {
            SwingUtilities.invokeLater(() -> {
                textArea.append(eventObject.getFormattedMessage() + "\n");
            });
        }
    }
} 