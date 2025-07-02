# 🔍 Search Index Processor

A simple Java application that reads `.txt` or `.csv` files, extracts words, and applies filtering rules such as:
- Words that start with the letter **'M'**
- Words longer than a configurable minimum length

---

## ⚙️ Features

- ✅ Configurable minimum word length (`min.length` in `config.properties`)
- ✅ Supports both `.txt` and `.csv` files
- ✅ Easily extendable rule engine via `Rule` interface
- ✅ Includes full unit test coverage using **JUnit 5**
- ✅ **Dockerized** for production deployment

---

## 🛠️ Getting Started

### 🔧 Prerequisites

- Java 17+
- Maven
- IDE (optional): IntelliJ, Eclipse, VS Code

---

## 🏃‍♂️ Running the App

### ⏳ Step 1: Add input files and config

Put your input file (e.g., `sample.txt`) and `config.properties` under `src/main/resources`.

Example `config.properties`:
```properties
min.length=5
```

### ⏳ Step 2: Perform maven clean package to create the jar file

Command `Maven`:
```properties
mvn clean package
```

### ⏳ Step 3: Execute the Jar file with the filaName as Argument

Command `Jar Exection`:
```properties
java -jar target/search-index-processor-1.0-SNAPSHOT.jar input.txt
```

---

## 🐳 Running with Docker

### Build Docker image:

```bash
docker build -t search-index-processor .
```
### Run the container:

```bash
docker run search-index-processor sample.txt
```

---