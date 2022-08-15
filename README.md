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
|exception|personalized exceptions|

## Functions
### Users
 - Read and print all

### Movies
 - Import all when starting the application
 - Export all when exiting the application
 - Create one
 - Read and print all
 - Delete one
 - Update one
 - Filter by category and print them
 - Filter the most valued and print them
 - Filter the least valued and them
 - Filter those whose value is above average and print them
 - Filter the most watched and print them

## Data Source
A .txt file.

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
