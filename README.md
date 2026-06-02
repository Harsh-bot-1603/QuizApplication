
# Quiz App REST API

A Spring Boot backend application for managing questions and playing quizzes. It exposes RESTful APIs to add questions, fetch them by category, generate random quizzes, and submit answers to calculate scores.

## Tech Stack
* **Language:** Java
* **Framework:** Spring Boot
* **Database Access:** Spring Data JPA / Hibernate
* **Utilities:** Lombok

## Features
* **Question Management:** Retrieve all questions, fetch by category, and add new questions.
* **Quiz Generation:** Create custom quizzes by specifying a category and the number of questions. Questions are randomly selected from the database.
* **Quiz Execution:** Fetch questions for a specific quiz (returns options while hiding correct answers using a Data Transfer Object) and submit responses to get a final score.

## API Endpoints

### Question APIs (`/question`)
| Method | Endpoint | Request Body | Description |
| :--- | :--- | :--- | :--- |
| `GET` | `/question/allQuestions` | None | Retrieves a list of all questions. |
| `GET` | `/question/category/{category}` | None | Retrieves questions filtered by a specific category. |
| `POST` | `/question/add` | JSON (Question) | Adds a new question to the database. |

### Quiz APIs (`/quiz`)
| Method | Endpoint | Request Params / Body | Description |
| :--- | :--- | :--- | :--- |
| `POST` | `/quiz/create` | Params: `category`, `numQ` | Creates a new quiz with `{numQ}` random questions from `{category}`. |
| `GET` | `/quiz/get/{id}` | None | Fetches the questions for quiz `{id}` (hides correct answers). |
| `POST` | `/quiz/submit/{id}` | JSON (List of Responses) | Submits answers for quiz `{id}` and returns the total score. |

## Project Structure
* `controller/`: REST controllers (`QuestionController`, `QuizController`) handling incoming HTTP requests.
* `model/`: Entity classes representing database tables (`Questions`, `Quiz`) and DTOs for client communication (`QuestionWrapper`, `Response`).
* `service/`: Business logic layer (`QuestionService`, `QuizService`) handling database interactions and calculations.
* `dao/`: Data Access Object interfaces extending `JpaRepository` for seamless database operations.

## Setup and Run
1. Clone the repository to your local machine.
2. Configure your database connection details (URL, username, password) in `application.properties` or `application.yml`.
3. Ensure you have Java (JDK 17+) and Maven installed.
4. Run the application using your preferred IDE or via the command line using `mvn spring-boot:run`.
README.md
Displaying README.md.
