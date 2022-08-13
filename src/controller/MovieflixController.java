/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package controller;

import service.PeliculaServiceImpl;
import service.UsuarioServiceImpl;
import view.DatoFormulario;
import view.Menu;

public class MovieflixController {

	private UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	private PeliculaServiceImpl peliculaServiceImpl = new PeliculaServiceImpl();

	public void ejecutar() {
		peliculaServiceImpl.importarPeliculas();
		view.Ventana.presentacion();
		boolean seguir = true;
		int opcion = 0;
		do {
			Menu.principal();
			opcion = DatoFormulario.enteroEntre(1, 3, "Elije una opción del menú");
			if (opcion == 3) {
				seguir = false;
			} else {
				seleccionarOpciones(opcion);
			}
		} while (seguir);
		peliculaServiceImpl.guardarPeliculas();
		DatoFormulario.cerrarScanner();
		view.Ventana.salir();
	}

	public void seleccionarOpciones(int opcion) {
		boolean seguir = true;
		int opcion2 = 0;
		switch (opcion) {
		case 1:
			do {
				view.Menu.usuarios();
				opcion2 = DatoFormulario.enteroEntre(1, 5, "Elije una opción del menú");
				if (opcion2 == 5) {
					seguir = false;
				} else {
					gestionarUsuarios(opcion2);
				}
			} while (seguir);
			break;
		case 2:
			do {
				view.Menu.peliculas();
				opcion2 = DatoFormulario.enteroEntre(1, 10, "Elije una opción del menú");
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
		case 7:
			peliculaServiceImpl.listarPeliculasValoracionEncimaMedia();
			break;
		case 8:
			peliculaServiceImpl.listarPeliculasMenosValoradas();
			break;
		case 9:
			peliculaServiceImpl.listarPeliculasMasVistas();
			break;
		}

	}
}
