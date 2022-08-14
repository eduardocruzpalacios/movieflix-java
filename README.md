# MovieFlix
Movies management console application built with JDK 11.0.12.

Note: code is written in Spanish language.

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|model for objects (attributes, constructors, getters, setters & .toString()) and create() method|
|dao|methods to communicate with data source and perform the tasks demanded by the business logic|
|service|interfaces with business-logic-oriented methods along with the classes implementing them|
|controller|the flow of the application|
|view|information showed to the users and requested from them|
|utility|methods for frequently needs|
|exceptions|personalized exceptions|

## Functions
### Map of users
 - Read and print all

### List of movies
 - import all from a .txt file when loading the application
 - export all to a .txt file when closing the application
 - Create one
 - Read and print all
 - Delete one
 - Update one
 - filter and print by category
 - filter and print the most valued
 - filter and print the least valued
 - filter and print those whose value is above average
 - filter and print the most watched

## Data Structure
|data|structure|
|----------------|-------------------------------|
|Usuario|String nombre, LocalDate fechaNacimiento, String ciudadResidencia|
|UsuarioDao|HashMap<String, Usuario>|
|Pelicula|String titulo, short anyoEstreno, short categoria, long visualizaciones, float valoracion|
|PeliculaDao|List\<Pelicula\>|

## Testing
- Unit tests are made with JUnit 5
- Only model classes are tested

## Libs
 - Log4j-api-2.7.jar
 - Log4j-core-2.7.jar
