package control;

import gui.Menu;
import servicios.Gestor;
import servicios.GestorUsuarios;
import utilidades.Lector;

public class Movieflix {
	private Gestor gestor = new GestorUsuarios();

	public void abrirMovieflix() {
		boolean seguir = true;
		int opcion = 0;
		do {
			Menu.principal();
			opcion = Lector.pedirIntEntre(1, 3);
			if (opcion == 3) {
				seguir = false;
			} else {
				seleccionarOpciones(opcion);
			}
		} while (seguir);
		System.out.println(" --- Fin de la sesion ---");
	}

	public void seleccionarOpciones(int opcion) {

		switch (opcion) {

		case 1:
			// Gestionar usuarios

			boolean seguir = true;
			int opcionUser = 0;
			do {
				gui.Menu.usuarios();
				opcionUser = Lector.pedirIntEntre(1, 5);
				if (opcionUser == 5) {
					seguir = false;
				} else {
					gestionarUsuarios(opcionUser);
				}
			} while (seguir);

			// case 2: //Hay que hacer la parte de películas
			// Gestionar películas
			// gui.Menu.

		}

	}

	// Switch para elegir opciones dentro de la gestión de usuarios
	public void gestionarUsuarios(int opcionUser) {

		switch (opcionUser) {

		case 1:
			// Listar todos los usuarios

			gestor.listarUsuarios();
			break;

		case 2:
			// Añadir usuario

			gestor.addUsuarios();
			break;

		case 3:
			// Eliminar usuario
			gestor.eliminarUsuarios();
			break;

		case 4:
			// Modificar usuario

			gestor.modificarUsuarios();
			break;

		}

	}
}
