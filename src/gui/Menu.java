/*
 * @author Edu
 * 
 * @version 1.0
 */
package gui;

public class Menu {

	public static void principal() {
		System.out.println("\n********** MENÚ PRINCIPAL **********\n");
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Gestionar Usuarios");
		System.out.println("2. Gestionar Películas");
		System.out.println("3. Salir del programa");
	}
	
	public static void usuarios() {
		System.out.println("\n********** GESTIÓN DE USUARIOS **********\n");
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Listar todos los usuarios");
		System.out.println("2. Añadir un usuario");
		System.out.println("3. Eliminar un usuario");
		System.out.println("4. Modificar un usuario");
		System.out.println("5. Volver al menú principal");
	}
	
	public static void modificarUsuario() {
		System.out.println("\n********** MODIFICAR USUARIO **********\n");
		System.out.println("¿Qué quieres modificar del usuario?");
		System.out.println("1. Nombre");
		System.out.println("2. Ciudad de residencia");
		System.out.println("3. Fecha de nacimiento");
	}
	
}
