
# **Input-Output File Consolidation**

## **Description**

This repository contains a Java application that consolidates data from multiple files into a single spreadsheet based on a user-specified data range. Designed to simplify data management tasks, this application processes input files and generates a consolidated output file in CSV format.

## **Features**

- **Data Consolidation**: Merges multiple data files into a single spreadsheet.
- **Custom Data Range**: Allows users to specify the range of data to be consolidated.
- **CSV Output**: Generates output files in CSV format for easy analysis and sharing.
- **User-Friendly Execution**: Provides straightforward prompts for user input during execution.

## **Getting Started**

### Prerequisites

- Java installed on your machine.
- An integrated development environment (IDE) such as **NetBeans**.

### Steps to Use

1. Clone or download the repository to your local machine.
2. Open the project in your IDE (e.g., **NetBeans**).
3. Navigate to the **`src/`** folder for the source code.
4. Compile and run the program.
5. Follow the prompts to specify the data range and input files.

The program will process the input files in the **`data/`** folder and generate a consolidated output file.

## **Technologies Used**

- **Java**: Programming language used for implementation.
- **NetBeans**: IDE used for development.

## **File Structure**

- **`data/`**: Folder containing data files used by the program.
- **`nbproject/`**: Folder containing NetBeans project files.
- **`src/`**: Folder containing the source code files.
- **`.DS_Store`**: macOS system file (ignore).
- **`ConsolidatedStockData.csv`**: Consolidated output file containing stock data.
- **`ConsolidatedStockFile.csv`**: Consolidated output file containing stock files.
- **`build.xml`**: Ant build script for compiling and building the project.
- **`README.md`**: Documentation file with project details and instructions.

## **Usage**

1. Open the project in your IDE (e.g., **NetBeans**).
2. Navigate to the **`src/`** folder and run the main Java file.
3. Input the required data range as prompted.
4. The program will consolidate files from the **`data/`** folder into the output files:
   - **`ConsolidatedStockData.csv`**
   - **`ConsolidatedStockFile.csv`**

These output files can be found in the project directory.

## **Contributing**

Contributions are welcome! If you have suggestions for enhancements or find any issues, feel free to open an issue or submit a pull request.
