# REST Service with HSQLDB

A Spring Boot REST service for managing notes with HSQLDB persistence.

## Features

- Create notes via GET or POST requests
- Retrieve all notes
- Retrieve a specific note by ID
- Notes are persisted in an in-memory HSQLDB database
- Each note contains:
  - `id`: Auto-generated unique identifier
  - `name`: The creator of the note
  - `content`: The note's text content

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Running the Application

### Using Maven

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Using the Maven Wrapper (Windows)

```bash
mvnw.cmd spring-boot:run
```

## API Endpoints

### Get Note by ID

**Endpoint:** `GET /note?id={id}`

**Description:** Retrieves a specific note by its ID.

**Example:**
```bash
curl "http://localhost:8080/note?id=1"
```

**Response:**
```json
{
  "id": 1,
  "name": "Troy",
  "content": "Hello, Troy!"
}
```

### Create a Note (POST)

**Endpoint:** `POST /note`

**Description:** Creates a new note with custom name and content via JSON body.

**Example:**
```bash
curl -X POST http://localhost:8080/note \
  -H "Content-Type: application/json" \
  -d '{"name":"Troy","content":"This is my note"}'
```

**Response:**
```json
{
  "id": 2,
  "name": "Troy",
  "content": "This is my note"
}
```

### Get All Notes

**Endpoint:** `GET /notes`

**Description:** Retrieves all notes from the database.

**Example:**
```bash
curl http://localhost:8080/notes
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Troy",
    "content": "Hello, Troy!"
  },
  {
    "id": 2,
    "name": "Jane",
    "content": "Hello, Jane!"
  }
]
```

## Running Tests

```bash
./mvnw test
```

## Project Structure

```
rest-service/
├── src/
│   ├── main/
│   │   ├── java/com/troydavidson/rest_service/
│   │   │   ├── Note.java              # Note entity
│   │   │   ├── NoteController.java    # REST controller
│   │   │   ├── NoteRepository.java    # JPA repository
│   │   │   └── RestServiceApplication.java  # Main application
│   │   └── resources/
│   │       └── application.properties  # Configuration
│   └── test/
│       └── java/com/troydavidson/rest_service/
│           ├── NoteTest.java           # Unit tests
│           ├── NoteControllerTest.java # Controller tests
│           └── NoteRepositoryTest.java # Repository tests
└── pom.xml                            # Maven configuration
```

## Database Configuration

The application uses an in-memory HSQLDB database configured in `application.properties`:

- **URL:** `jdbc:hsqldb:mem:testdb`
- **Username:** `sa`
- **Password:** (empty)
- **Dialect:** HSQLDialect
- **DDL Strategy:** create-drop (tables are created on startup and dropped on shutdown)

## Technologies Used

- Spring Boot 4.1.1
- Spring Data JPA
- HSQLDB
- Hibernate
- Maven
- JUnit 5
- AssertJ

## License

This project is licensed under the terms specified in the project configuration.
