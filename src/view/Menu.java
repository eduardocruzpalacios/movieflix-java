/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package view;

public class Menu {

	public static void principal() {
		Escritor.string("\n********** MENÚ PRINCIPAL **********\n");
		Escritor.string("1. Gestionar Usuarios");
		Escritor.string("2. Gestionar Películas");
		Escritor.string("3. Salir del programa");
	}

	public static void usuarios() {
		Escritor.string("\n********** GESTIÓN DE USUARIOS **********\n");
		Escritor.string("1. Listar todos los usuarios");
		Escritor.string("2. Añadir un usuario");
		Escritor.string("3. Eliminar un usuario");
		Escritor.string("4. Modificar un usuario");
		Escritor.string("5. Volver al menú principal");
	}

	public static void modificarUsuario() {
		Escritor.string("\n********** MODIFICAR USUARIO **********\n");
		Escritor.string("1. Nombre");
		Escritor.string("2. Ciudad de residencia");
		Escritor.string("3. Fecha de nacimiento");
	}

	public static void peliculas() {
		Escritor.string("\n********** GESTIÓN DE PELÍCULAS **********\n");
		Escritor.string("1. Listar todas las películas");
		Escritor.string("2. Añadir una película");
		Escritor.string("3. Eliminar una película");
		Escritor.string("4. Modificar una película");
		Escritor.string("5. Filtrar películas por categoría");
		Escritor.string("6. Mostrar las películas más valoradas");
		Escritor.string("7. Mostrar las películas cuya valoración está por encima de la media");
		Escritor.string("8. Mostrar las películas peor valoradas");
		Escritor.string("9. Mostrar las películas más vistas");
		Escritor.string("10. Volver al menú principal");
	}

	public static void modificarPelicula() {
		Escritor.string("\n********** MODIFICAR PELÍCULA **********\n");
		Escritor.string("1. Título");
		Escritor.string("2. Año");
		Escritor.string("3. Categoría");
	}

	public static void categorias() {
		Escritor.string("\n********** CATEGORÍAS **********\n");
		Escritor.string("1. Policiaca");
		Escritor.string("2. Romántica");
		Escritor.string("3. Aventuras");
		Escritor.string("4. Comedia");
		Escritor.string("5. Animación");
		Escritor.string("6. Thriller");
	}

}
