/*
 * Fecha: 22/03/2021
 *
 * @author Edu y María
 *
 * @version: 1.0
 */

package control;

import gui.Menu;
import services.PeliculaServiceImpl;
import services.UsuarioServiceImpl;
import utilidades.Lector;

public class Movieflix {

	private UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	private PeliculaServiceImpl peliculaServiceImpl = new PeliculaServiceImpl();

	public void abrirMovieflix() {
		peliculaServiceImpl.importarPeliculas();
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

	public void gestionarUsuarios(int opcionUser) {
		switch (opcionUser) {
		case 1:
			usuarioServiceImpl.findAll();
			break;
		case 2:
			usuarioServiceImpl.add();
			break;
		case 3:
			usuarioServiceImpl.delete();
			break;
		case 4:
			usuarioServiceImpl.update();
			break;
		}
	}

	public void gestionarPeliculas(int opcionUser2) {
		switch (opcionUser2) {
		case 1:
			peliculaServiceImpl.listarPeliculas();
			break;
		case 2:
			peliculaServiceImpl.addPeliculas();
			break;
		case 3:
			peliculaServiceImpl.eliminarPeliculas();
			break;
		case 4:
			peliculaServiceImpl.modificarPeliculas();
			break;
		}
	}

}
