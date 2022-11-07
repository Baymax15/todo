# TODO
A Todo Application made using Spring Boot

Project created using [Spring Initializr](https://start.spring.io/) with configuration: 
- Maven
- Spring Boot 2.7.5
- Jar packaging
- Java 8
- Dependencies:
  -   Spring Web WEB
  -   Spring Data JPA SQL
  -   MySQL Driver SQL
  -   Spring Boot DevTools

## Endpoints
### `/todos`
- POST: 
  - To create a new todo item 
  - Request Body: { title: String, description: String }
  - Response: { id: number, title: string, description: string }
- GET: 
  - To get a list of todo items
  - Response: [{ id: number, title: string },...]

### `/todos/:id`
- GET:
  - To get a detailed todo item, given path variable id
  - Response: { id: number, title: string, description: string }
- PUT:
  - To update a todo item
  - Possible fields:
    - title: string
    - description: string
  - Response: { id: number, title: string, description: string }
- DELETE:
  - To delete a todo item
  - Response: "Deleted Todo with id: {id}"
