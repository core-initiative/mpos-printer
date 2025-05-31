# System Patterns: mpos-printer

## System Architecture
- **Layered Structure:**
  - Entry point: `id.modefashion.printer.App`
  - Core logic: `id.modefashion.printer` and subpackages (`worker`, `dto`, `util`, `paper`)
  - Data transfer: DTOs in `dto` package
  - Utilities: Helper classes in `util`
  - Printing logic: `worker` and `paper` packages

## Key Technical Decisions
- **Maven** for build and dependency management
- **Java 7** compatibility (upgrade recommended)
- **PDFBox** for PDF generation
- **ZXing** for barcode support
- **Java-WebSocket** for real-time communication
- **Commons-Configuration** for flexible configuration
- **SLF4J + Logback** for logging
- **Lombok** to reduce boilerplate (provided scope)

## Design Patterns
- **DTO Pattern:** For passing structured data (e.g., `ReceiptData`, `ReceiptLineData`)
- **Worker Pattern:** For handling print jobs (`ReceiptWorker`, `ReceiptWorkerString`)
- **Observer Pattern:** (Inferred from `BarcodeObserver`)
- **Utility Pattern:** For shared helpers (`Helper`)

## Component Relationships
- `App` initializes and coordinates the system
- Print jobs are processed by workers, using DTOs for data
- Utilities and configuration are used throughout
- Logging is integrated at all levels 