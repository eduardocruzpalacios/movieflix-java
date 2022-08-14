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
import view.Ventana;

public class MovieflixController {

	private UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
	private PeliculaServiceImpl peliculaServiceImpl = new PeliculaServiceImpl();

	public void ejecutar() {
		peliculaServiceImpl.importarPeliculas();
		Ventana.presentacion();
		boolean seguir = true;
		int opcion = 0;
		do {
			Menu.principal();
			opcion = DatoFormulario.enteroEntre(1, 3, "Elije una opción del menú");
			if (opcion == 3) {
				seguir = false;
			} else {
				seleccionarGestion(opcion);
			}
		} while (seguir);
		peliculaServiceImpl.guardarPeliculas();
		Ventana.salir();
	}

	public void seleccionarGestion(int opcion) {
		boolean seguir = true;
		switch (opcion) {
		case 1:
			do {
				Menu.usuarios();
				int opcionGestionUsuarios = DatoFormulario.enteroEntre(1, 2, "Elije una opción del menú");
				if (opcionGestionUsuarios == 2) {
					seguir = false;
				} else {
					gestionarUsuarios(opcionGestionUsuarios);
				}
			} while (seguir);
			break;
		case 2:
			do {
				view.Menu.peliculas();
				int opcionGestionPeliculas = DatoFormulario.enteroEntre(1, 10, "Elije una opción del menú");
				if (opcionGestionPeliculas == 10) {
					seguir = false;
				} else {
					gestionarPeliculas(opcionGestionPeliculas);
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
