# MovieFlix
Movies management application built with Java 11.

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|model for objects (attributes, constructors, getters, setters & .toString()) and create() method|
|dao|guarantees the data persistence|
|services|interfaces with business-logic-oriented methods along with the classes implementing them|
|control|flow of the application and the execution class|
|gui|graphics|
|tools|static methods for frequently needs|
|exceptions|personalized exceptions|

## Functions
### Map of users
 - Create one
 - Read and print all
 - Delete one
 - Update one

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
|PeliculaDao|List<Pelicula>|

## Libs
 - Log4j-api-2.7.jar
 - Log4j-core-2.7.jar
