# Tech Context: mpos-printer

## Technologies Used
- **Java 7** (upgrade to Java 8+ recommended)
- **Maven** for build and dependency management
- **PDFBox** for PDF creation/manipulation
- **ZXing** for barcode generation/decoding
- **Java-WebSocket** for WebSocket communication
- **Commons-Configuration** for configuration management
- **Gson** for JSON serialization/deserialization
- **SLF4J + Logback** for logging
- **Lombok** for reducing boilerplate (provided scope)
- **JUnit 3.8.1** for unit testing

## Development Setup
- Source code in `src/main/java`
- Tests in `src/test/java`
- Build with `mvn clean package`
- Configuration via `printer.properties`
- Main class: `id.modefashion.printer.App`

## Technical Constraints
- Java 7 compatibility (limits use of modern language features and libraries)
- Some dependencies are not the latest versions
- JUnit 3.x is outdated (consider upgrading to JUnit 5)

## Dependencies
- See `pom.xml` for full list and versions 