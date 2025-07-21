
## RUML Diagram Specifications

The RUML diagram specified a Library Management System with:

### Classes and Relationships:
- **LibraryItem** (abstract base class)
- **Book** (extends LibraryItem) ⇒ root of dependency channel
    - **TextBook** (extends Book)
    - **AudioBook** (extends Book)
- **Member** (uses LibraryItem) → LibraryItem
- **Library** (uses Member and LibraryItem) → Member, → LibraryItem

### RUML Notation Used:
- `⇒` indicates the root of a dependency channel
- `→` means "uses/depends on"
- `←` means "is used by"
- `△` indicates inheritance

## Results Summary

### ChatGPT
- **Initial Attempt**: Failed - Could not process Excel file, generated unrelated classes (Item, DVD, Librarian)
- **Manual Input**: Partial Success - Basic implementation but missing many specifications
- **Compilation**: ✅ Compiles
- **Accuracy**: ❌ Does not match RUML specifications

### Claude
- **Implementation**: Full Success - Complete and accurate implementation
- **Features**: All classes, methods, and relationships correctly implemented
- **Compilation**: ✅ Compiles and runs with demo
- **Accuracy**: ✅ Fully matches RUML specifications

### Grok
- **Implementation**: Partial Success - Most classes implemented but with variations
- **Issues**: LibraryItem as interface instead of abstract class, different data types
- **Compilation**: ✅ Compiles
- **Accuracy**: ⚠️ Partially matches RUML specifications

## How to Run

### Prerequisites
- Java JDK 8 or higher
- IntelliJ IDEA or any Java IDE

### Running the Code

1. Clone this repository:
```bash
git clone https://github.com/Fatimah1403/RUML_LibraryManagement.git
