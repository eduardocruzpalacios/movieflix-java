/**
 * 
 * Fecha: 16/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 * 
 *          Clase Menu
 * 
 *          Clase que establece el menú gráfico de la aplicación
 * 
 * 
 */

package gui;

import utilidades.Escritor;

public class Menu {

	public static void principal() {
		Escritor.str("\n********** MENÚ PRINCIPAL **********\n");
		Escritor.str("¿Qué quieres hacer?");
		Escritor.str("1. Gestionar Usuarios");
		Escritor.str("2. Gestionar Películas");
		Escritor.str("3. Salir del programa");
	}
	
	public static void usuarios() {
		Escritor.str("\n********** GESTIÓN DE USUARIOS **********\n");
		Escritor.str("¿Qué quieres hacer?");
		Escritor.str("1. Listar todos los usuarios");
		Escritor.str("2. Añadir un usuario");
		Escritor.str("3. Eliminar un usuario");
		Escritor.str("4. Modificar un usuario");
		Escritor.str("5. Volver al menú principal");
	}
	
	public static void modificarUsuario() {
		Escritor.str("\n********** MODIFICAR USUARIO **********\n");
		Escritor.str("¿Qué quieres modificar del usuario?");
		Escritor.str("1. Nombre");
		Escritor.str("2. Ciudad de residencia");
		Escritor.str("3. Fecha de nacimiento");
	}
	
}
