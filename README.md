# Library-Management--Spring-Core-

This is a simple Library Management System implemented in Java using Spring Framework. The system allows you to manage books and authors in a library.

## Features

- Add a new book with multiple authors
- Display all books in the library
- Remove a book by title
- Check if a book exists by title
- Remove all books from the library
- Update the price of a book
- Get details of a book by title
- List all books by a specific author

## Getting Started

1. Clone the repository:
    ```sh
    git clone https://github.com/Prince3163/Library-Management--Spring.git
    cd LibraryManagement
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn exec:java -Dexec.mainClass="org.example.App"
    ```

## Project Structure

- `src/main/java/org/example/` - Contains the main application class `App.java`
- `src/main/java/org/example/beans/` - Contains the `Book`, `Author`, and `LibraryImpl` classes
- `src/main/java/org/example/configuration/` - Contains the Spring configuration class `AppConfig.java`

## Data Persistence

**Note:** The data in this application is unpersistent and will not be saved between runs.
