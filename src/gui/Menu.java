/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package gui;

import tools.Escritor;

public class Menu {

	public static void principal() {
		Escritor.str("\n********** MENÚ PRINCIPAL **********\n");
		Escritor.str("1. Gestionar Usuarios");
		Escritor.str("2. Gestionar Películas");
		Escritor.str("3. Salir del programa");
	}

	public static void usuarios() {
		Escritor.str("\n********** GESTIÓN DE USUARIOS **********\n");
		Escritor.str("1. Listar todos los usuarios");
		Escritor.str("2. Añadir un usuario");
		Escritor.str("3. Eliminar un usuario");
		Escritor.str("4. Modificar un usuario");
		Escritor.str("5. Volver al menú principal");
	}

	public static void modificarUsuario() {
		Escritor.str("\n********** MODIFICAR USUARIO **********\n");
		Escritor.str("1. Nombre");
		Escritor.str("2. Ciudad de residencia");
		Escritor.str("3. Fecha de nacimiento");
	}

	public static void peliculas() {
		Escritor.str("\n********** GESTIÓN DE PELÍCULAS **********\n");
		Escritor.str("1. Listar todas las películas");
		Escritor.str("2. Añadir una película");
		Escritor.str("3. Eliminar una película");
		Escritor.str("4. Modificar una película");
		Escritor.str("5. Filtrar películas por categoría");
		Escritor.str("6. Mostrar las películas más valoradas");
		Escritor.str("7. Mostrar las películas cuya valoración está por encima de la media");
		Escritor.str("8. Mostrar las películas peor valoradas");
		Escritor.str("9. Mostrar las películas más vistas");
		Escritor.str("10. Volver al menú principal");
	}

	public static void modificarPelicula() {
		Escritor.str("\n********** MODIFICAR PELÍCULA **********\n");
		Escritor.str("1. Título");
		Escritor.str("2. Año");
		Escritor.str("3. Categoría");
	}

	public static void categorias() {
		Escritor.str("\n********** CATEGORÍAS **********\n");
		Escritor.str("1. Policiaca");
		Escritor.str("2. Romántica");
		Escritor.str("3. Aventuras");
		Escritor.str("4. Comedia");
		Escritor.str("5. Animación");
		Escritor.str("6. Thriller");
	}

}
