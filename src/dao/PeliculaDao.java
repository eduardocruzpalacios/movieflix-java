/*
 * Fecha: 22/03/2021
 *
 * @author Raúl y María
 *
 * @version: 1.0
 */

package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.ListadoVacioException;
import exceptions.PeliculaExistenteException;
import gui.Menu;
import model.Pelicula;
import tools.Colecciones;
import tools.Escritor;
import tools.Files;
import tools.Lector;

public class PeliculaDao {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(UsuarioDao.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private List<Pelicula> peliculaDao = new ArrayList<Pelicula>();
	private String filePath = "peliculas.txt";

	public void listarPeliculas() {
		try {
			if (peliculaDao.size() == 0) {
				Escritor.str("El listado está vacío");
				throw new exceptions.ListadoVacioException();
			} else {
				System.out.println("Listado de Peliculas");
				peliculaDao.forEach(pelicula -> System.out.println(pelicula));
			}
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	public void addPelicula() {
		try {
			Pelicula pelicula = Pelicula.crear();
			for (int i = 0; i < peliculaDao.size(); i++) {
				if (peliculaDao.get(i).getTitulo().equals(pelicula.getTitulo())) {
					throw new exceptions.PeliculaExistenteException();
				}
			}
			peliculaDao.add(pelicula);
			Escritor.str("Película creada correctamente");
		} catch (PeliculaExistenteException e) {
			logger.error(e.toString());
		}
	}

	public void eliminarPelicula() {
		String tituloPelicula = Lector.str("Dime el título de la película a borrar");
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (tituloPelicula.equals(peliculaDao.get(i).getTitulo())) {
				peliculaDao.remove(peliculaDao.get(i));
			}
		}
	}

	public void modificarPelicula() {
		String tituloPelicula = Lector.str("Dime el título de la película a modificar");
		Menu.modificarPelicula();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch (opcion) {
		case 1:
			for (int i = 0; i < peliculaDao.size(); i++) {
				if (tituloPelicula.equals(peliculaDao.get(i).getTitulo())) {
					peliculaDao.get(i).setTitulo(Lector.str("¿Cual es el nuevo título?"));
				}
			}
			break;
		case 2:
			for (int i = 0; i < peliculaDao.size(); i++) {
				if (tituloPelicula.equals(peliculaDao.get(i).getTitulo())) {
					peliculaDao.get(i).setAnyoEstreno((short) Lector.pedirInt("¿Cual es el nuevo año de estreno?"));
				}
			}
			break;
		case 3:
			for (int i = 0; i < peliculaDao.size(); i++) {
				if (tituloPelicula.equals(peliculaDao.get(i).getTitulo())) {
					peliculaDao.get(i).setCategoria((short) Lector.pedirInt("Digame la nueva categoría"));
				}
			}
			break;
		}
		Escritor.str("Esta película ha sido modificada");
	}

	public void importarPeliculas() {
		ArrayList<String> arrayString = Files.leerRutaFicheroDevolverArrayString(filePath);
		ArrayList<Pelicula> arrayPeliculas = Colecciones.leerArrayStringDevolverArrayPelicula(arrayString);
		peliculaDao = arrayPeliculas;
	}

	public void listarPeliculasPorCategoria() {
		Menu.categorias();
		short opcion = Lector.pedirShortEntre(1, 6, "Elige una categoría");
		try {
			if (peliculaDao.size() == 0) {
				Escritor.str("El listado está vacío");
				throw new exceptions.ListadoVacioException();
			} else {
				System.out.println("Listado de Peliculas");
				peliculaDao.forEach(pelicula -> {
					if (pelicula.getCategoria() == opcion) {
						System.out.println(pelicula);
					}
				});
			}
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	public void guardarPeliculas() {
		List<String> listString = Colecciones.leerListPeliculaDevolverListString(this.peliculaDao);
		Files.LeerListStringGuardarEnFichero(listString, filePath);
	}

	public void listarPeliculasMasValoradas() {

		int numeroMaximos = 5;

		int[] indicesMaximos = new int[numeroMaximos];

		float valoracionMaxima;
		float valoracionLimite = 5f;
		int indiceAuxiliar = 0;

		for (int i = 0; i < indicesMaximos.length; i++) {
			valoracionMaxima = 0f;

			for (int j = 0; j < peliculaDao.size(); j++) {

				if (peliculaDao.get(j).getValoracion() >= valoracionMaxima
						&& peliculaDao.get(j).getValoracion() <= valoracionLimite) {

					int cuenta = 0;

					for (int k = 0; k < indicesMaximos.length; k++) {

						if (!peliculaDao.get(indicesMaximos[k]).getTitulo().equals(peliculaDao.get(j).getTitulo())) {
							cuenta++;
						}

					}

					if (cuenta == indicesMaximos.length) {
						valoracionMaxima = peliculaDao.get(j).getValoracion();
						indicesMaximos[i] = j;
						indiceAuxiliar = j;
					}

				}

			}
			valoracionLimite = peliculaDao.get(indiceAuxiliar).getValoracion();
		}

		System.out.println("Listado de " + numeroMaximos + " peliculas más valoradas");
		for (int i = 0; i < indicesMaximos.length; i++) {
			System.out.println(peliculaDao.get(indicesMaximos[i]));
		}

	}

	public void listarPeliculasMenosValoradas() {

		int numeroMinimos = 5;

		int[] indicesMinimos = new int[numeroMinimos];

		float valoracionMinima;
		float valoracionLimite = 0f;
		int indiceAuxiliar = 0;

		for (int i = 0; i < indicesMinimos.length; i++) {
			valoracionMinima = 5f;

			for (int j = 0; j < peliculaDao.size(); j++) {

				if (peliculaDao.get(j).getValoracion() <= valoracionMinima
						&& peliculaDao.get(j).getValoracion() >= valoracionLimite) {

					int cuenta = 0;

					for (int k = 0; k < indicesMinimos.length; k++) {

						if (!peliculaDao.get(indicesMinimos[k]).getTitulo().equals(peliculaDao.get(j).getTitulo())) {
							cuenta++;
						}

					}

					if (cuenta == indicesMinimos.length) {
						valoracionMinima = peliculaDao.get(j).getValoracion();
						indicesMinimos[i] = j;
						indiceAuxiliar = j;
					}

				}

			}
			valoracionLimite = peliculaDao.get(indiceAuxiliar).getValoracion();
		}

		System.out.println("Listado de " + numeroMinimos + " peliculas menos valoradas");
		for (int i = 0; i < indicesMinimos.length; i++) {
			System.out.println(peliculaDao.get(indicesMinimos[i]));
		}

	}
}
