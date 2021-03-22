/*
*Fecha: 22/03/2021
*
*@author Edu y María
*
*@version: 1.0
*
*Clase Movieflix
*
*Clase que se encarga de desplegar el menú, permite seleccionar las distintas opciones y ejecutarlas.
*
*/

package control;

import gui.Menu;
import servicios.GestorPeliculas;
import servicios.GestorUsuarios;
import utilidades.Lector;

public class Movieflix {

	private GestorUsuarios gestorUsuarios = new GestorUsuarios();
	private GestorPeliculas gestorPeliculas = new GestorPeliculas();

	public void abrirMovieflix() {
		gestorPeliculas.importarPeliculas();
		gui.Ventana.presentacion();
		boolean seguir = true;
		int opcion = 0;
		do {
			Menu.principal();
			opcion = Lector.pedirIntEntre(1, 3, "Elije una opción del menú");
			if (opcion == 3) {
				seguir = false;
			} else {
				seleccionarOpciones(opcion);
			}
		} while (seguir);
		gui.Ventana.salir();
	}

	public void seleccionarOpciones(int opcion) {

		switch (opcion) {

		// Gestionar usuarios
		case 1:
			boolean seguir = true;
			int opcionUser = 0;
			do {
				gui.Menu.usuarios();
				opcionUser = Lector.pedirIntEntre(1, 5, "Elije una opción del menú");
				if (opcionUser == 5) {
					seguir = false;
				} else {
					gestionarUsuarios(opcionUser);
				}
			} while (seguir);
			break;

		// Gestionar películas
		case 2:
			boolean seguir2 = true;
			int opcionUser2 = 0;
			do {
				gui.Menu.peliculas();
				opcionUser2 = Lector.pedirIntEntre(1, 9, "Elije una opción del menú");
				if (opcionUser2 == 9) {
					seguir2 = false;
				} else {
					gestionarPeliculas(opcionUser2);
				}
			} while (seguir2);
			break;
		}

	}

	// Switch para elegir opciones dentro de la gestión de usuarios
	public void gestionarUsuarios(int opcionUser) {
		switch (opcionUser) {
		case 1:
			gestorUsuarios.listarUsuarios();
			break;
		case 2:
			gestorUsuarios.addUsuarios();
			break;
		case 3:
			gestorUsuarios.eliminarUsuarios();
			break;
		case 4:
			gestorUsuarios.modificarUsuarios();
			break;
		}
	}

	// Switch para elegir opciones dentro de la gestión de usuarios
	public void gestionarPeliculas(int opcionUser2) {
		switch (opcionUser2) {
		case 1:
			gestorPeliculas.listarPeliculas();
			break;
		case 2:
			gestorPeliculas.addPeliculas();
			break;
		case 3:
			gestorPeliculas.eliminarPeliculas();
			break;
		case 4:
			gestorPeliculas.modificarPeliculas();
			break;
		/*
		 * case 5: gestorPeliculas.peliculasMasValoradas(); break; case 6:
		 * gestorPeliculas.peliculasEncimaMedia(); break; case 7:
		 * gestorPeliculas.peliculasPeorValoradas(); break; case 8:
		 * gestorPeliculas.peliculasMasVistas(); break;
		 */
		}
	}
}
