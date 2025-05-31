# mpos-printer
MPOS Printer Implementation using Java Point of Sales

## Features
- Print receipts with text, barcodes, and images
- Generate receipts as PDFs
- Real-time print job handling via WebSocket server
- Configurable printer, paper, and font settings via `printer.properties`
- Logging with SLF4J and Logback

## Prerequisites
- Java 8 or higher (Java 8+ recommended)
- Maven (or use the included Maven Wrapper)

## Building the Project

Using Maven Wrapper (recommended):
```sh
./mvnw clean package
```
Or with Maven:
```sh
mvn clean package
```

This will generate the executable JAR with dependencies at:
```
target/printer-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Running the Project

### 1. Using Maven Exec Plugin (for development)
```sh
./mvnw exec:java
```

### 2. Running the Fat JAR (for deployment)
```sh
java -jar target/printer-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Configuration
Edit `printer.properties` to set printer name, port, paper size, font, and other options.

## Working Features
- **WebSocket Server:** Listens on the port defined in `printer.properties` (default: 20001)
- **Receipt Printing:** Supports text, barcode, and image lines
- **PDF Generation:** Uses PDFBox for PDF output
- **Barcode Support:** Uses ZXing for barcode generation
- **Configurable Paper & Font:** Paper size, margins, and font are all configurable
- **Logging:** All major actions are logged for traceability

## Usage Scenarios
- **POS Integration:** Connect your POS system to the WebSocket server and send print jobs as JSON
- **Custom Receipts:** Define receipt content (text, barcode, images) and send to the printer
- **PDF Output:** Generate and print receipts as PDFs for archiving or emailing

## Example Scenario
1. Start the application (see above)
2. POS system connects to WebSocket server on the configured port
3. POS sends a JSON message describing the receipt (lines, barcodes, etc.)
4. Application processes the message and prints the receipt
5. Logs and output are available for troubleshooting

---
For more details, see the `printer.properties` file and the source code in `src/main/java/id/modefashion/printer`.
