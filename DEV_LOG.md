# Development Log

## Initial Implementation
- **Dependencies**: Added `spring-boot-starter-jdbc` and `mysql-connector-j` to `pom.xml`.
- **Database**: 
    - Configured MySQL connection in `application.properties`.
    - Created `schema.sql` for `quiz_question` and `quiz_result` tables.
- **Model**: Created `QuizQuestion` class.
- **DTOs**: 
    - `QuestionDTO`: To send questions to frontend without correct answers.
    - `QuizResultDTO`: To return score/total.
    - `QuizSubmissionDTO`: To accept user answers.
- **Repository**: Created `QuizRepository` using `JdbcTemplate` and `RowMapper` for database operations.
- **Service**: Created `QuizService` to handle `getAllQuestions`, `addQuestion`, and `calculateScore`.
- **Controller**: Created `QuizController` with REST endpoints.

## Refactoring (Simplification)
### URL and Controller Changes
- [x] Changed Base URL from `/api/quiz` to `/quiz`.
- [x] Removed `@CrossOrigin` annotation.
- [x] Renamed endpoints:
    - `/questions` (GET) -> `/all-questions`.
    - `/question` (POST) -> `/add-question`.

### Upcoming Changes (Waiting for User Config)
- [ ] Refactor `QuizRepository` (User example was `ArrayList`-based, but assignment requires `JdbcTemplate`. Keeping JDBC logic to meet requirements).
- [x] Refactor `QuizService` loop logic (Replaced `Map.Entry` with `keySet` loop).
