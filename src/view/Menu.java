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
		MostrarDato.string("\n********** MENÚ PRINCIPAL **********\n");
		MostrarDato.string("1. Gestionar Usuarios");
		MostrarDato.string("2. Gestionar Películas");
		MostrarDato.string("3. Salir del programa");
	}

	public static void usuarios() {
		MostrarDato.string("\n********** GESTIÓN DE USUARIOS **********\n");
		MostrarDato.string("1. Listar todos los usuarios");
		MostrarDato.string("2. Añadir un usuario");
		MostrarDato.string("3. Eliminar un usuario");
		MostrarDato.string("4. Modificar un usuario");
		MostrarDato.string("5. Volver al menú principal");
	}

	public static void modificarUsuario() {
		MostrarDato.string("\n********** MODIFICAR USUARIO **********\n");
		MostrarDato.string("1. Nombre");
		MostrarDato.string("2. Ciudad de residencia");
		MostrarDato.string("3. Fecha de nacimiento");
	}

	public static void peliculas() {
		MostrarDato.string("\n********** GESTIÓN DE PELÍCULAS **********\n");
		MostrarDato.string("1. Listar todas las películas");
		MostrarDato.string("2. Añadir una película");
		MostrarDato.string("3. Eliminar una película");
		MostrarDato.string("4. Modificar una película");
		MostrarDato.string("5. Filtrar películas por categoría");
		MostrarDato.string("6. Mostrar las películas más valoradas");
		MostrarDato.string("7. Mostrar las películas cuya valoración está por encima de la media");
		MostrarDato.string("8. Mostrar las películas peor valoradas");
		MostrarDato.string("9. Mostrar las películas más vistas");
		MostrarDato.string("10. Volver al menú principal");
	}

	public static void modificarPelicula() {
		MostrarDato.string("\n********** MODIFICAR PELÍCULA **********\n");
		MostrarDato.string("1. Título");
		MostrarDato.string("2. Año");
		MostrarDato.string("3. Categoría");
	}

	public static void categorias() {
		MostrarDato.string("\n********** CATEGORÍAS **********\n");
		MostrarDato.string("1. Policiaca");
		MostrarDato.string("2. Romántica");
		MostrarDato.string("3. Aventuras");
		MostrarDato.string("4. Comedia");
		MostrarDato.string("5. Animación");
		MostrarDato.string("6. Thriller");
	}

}
