# Text File Reader & JSON Converter

[![Java](https://img.shields.io/badge/Language-Java-blue?style=for-the-badge)](https://www.java.com/)  
[![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)](LICENSE)  

A simple Java project to read arithmetic operations from a text file, calculate results, write them to a JSON file, and parse JSON back into objects for display.

---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Example Input & Output](#example-input--output)
- [Dependencies](#dependencies)
- [Author](#author)

---

## Features

- Reads operations from a text file (format: `number operator number`).
- Supports basic arithmetic: addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
- Calculates results and writes operations with results to a JSON file.
- Parses JSON back into `Operation` objects and prints them to the console.
- Handles invalid input, malformed lines, and division by zero gracefully.

---

## Project Structure

```

text_file_reader/
│
├─ src/main/java/text_file_reader/
│   ├─ Main.java          # Entry point of the project
│   ├─ FileManager.java   # Handles file reading, writing, and JSON parsing
│   └─ Operation.java     # Represents a single arithmetic operation
│
├─ src/main/resources/
│   ├─ input.txt          # Input text file
│   └─ output.txt         # Output JSON file

````

---

## Getting Started

1. **Clone the repository:**
```bash
git clone https://github.com/your-username/text-file-reader.git
````

2. **Open in IntelliJ IDEA** (or your preferred Java IDE).

3. **Add dependencies** (Gson library for JSON parsing). If using Maven, include:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

4. **Run `Main.java`.**

---

## Usage

1. Prepare `input.txt` in `src/main/resources`:

```
5 + 3
10 / 2
7 * 8
12 - 4
```

2. Run the project.
3. `output.txt` will contain:

```json
[
  { "numOne": 5, "numTwo": 3, "operator": "+", "result": 8.0 },
  { "numOne": 10, "numTwo": 2, "operator": "/", "result": 5.0 },
  { "numOne": 7, "numTwo": 8, "operator": "*", "result": 56.0 },
  { "numOne": 12, "numTwo": 4, "operator": "-", "result": 8.0 }
]
```

4. Console output:

```
5.0 + 3.0 = 8.0
10.0 / 2.0 = 5.0
7.0 * 8.0 = 56.0
12.0 - 4.0 = 8.0
```

---

## Dependencies

* [Gson](https://github.com/google/gson) - JSON parsing library.

---

## Author

**Imrul Hasan Sifat**

* Email: [imrulhasansifat@gmail.com](mailto:imrulhasansifat@gmail.com)

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
