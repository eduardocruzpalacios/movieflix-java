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
import tools.Lector;

public class Movieflix {

	private UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	private PeliculaServiceImpl peliculaServiceImpl = new PeliculaServiceImpl();

	public void ejecutar() {
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
		peliculaServiceImpl.guardarPeliculas();
		gui.Ventana.salir();
	}

	public void seleccionarOpciones(int opcion) {
		boolean seguir = true;
		int opcion2 = 0;
		switch (opcion) {
		case 1:
			do {
				gui.Menu.usuarios();
				opcion2 = Lector.pedirIntEntre(1, 5, "Elije una opción del menú");
				if (opcion2 == 5) {
					seguir = false;
				} else {
					gestionarUsuarios(opcion2);
				}
			} while (seguir);
			break;
		case 2:
			do {
				gui.Menu.peliculas();
				opcion2 = Lector.pedirIntEntre(1, 10, "Elije una opción del menú");
				if (opcion2 == 10) {
					seguir = false;
				} else {
					gestionarPeliculas(opcion2);
				}
			} while (seguir);
			break;
		}
	}

	public void gestionarUsuarios(int opcion) {
		switch (opcion) {
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

	public void gestionarPeliculas(int opcion) {
		switch (opcion) {
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
		case 5:
			peliculaServiceImpl.listarPeliculasPorCategoria();
			break;
		case 6:
			peliculaServiceImpl.listarPeliculasMasValoradas();
			break;
		case 8:
			peliculaServiceImpl.listarPeliculasMenosValoradas();
			break;
		}

	}
}
