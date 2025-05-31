# Active Context: mpos-printer

## Current Work Focus
- Added a Swing-based GUI as the main entry point (PrinterGuiApp)
- Integrated a Start/Stop button for the WebSocket server
- Implemented a real-time, scrollable log area in the GUI
- Added a configuration menu for editing printer.properties
- Ensured all logs from all classes are routed to the GUI log area
- Replaced all System.out.print calls with logger calls
- Registered LogbackTextAreaAppender as early as possible in App.java
- Ensured logger output from all threads and startup code appears in the GUI

## Recent Changes
- Refactored App.java to register the GUI log appender before launching the GUI
- Replaced direct console output with logger calls in PosReceipt and PosReceiptString
- Confirmed logger output is visible in the GUI log area
- Confirmed configuration changes are possible via the GUI

## Next Steps
- Further polish the GUI (e.g., log filtering, error highlighting)
- Add more configuration options if needed
- Consider removing the console appender if only GUI logging is desired
- Test on different platforms and Java versions (Java 8+ required)

## Active Decisions and Considerations
- The GUI is now the default entry point, replacing the CLI
- All logging is centralized and routed to the GUI for better user experience
- Java 8+ is now required for building and running the project 