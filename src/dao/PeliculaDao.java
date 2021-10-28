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

		int indexMaxValoracion1 = 0;
		int indexMaxValoracion2 = -1;
		int indexMaxValoracion3 = -1;
		int indexMaxValoracion4 = -1;
		int indexMaxValoracion5 = -1;

		for (int i = 1; i < peliculaDao.size(); i++) {
			if (peliculaDao.get(i).getValoracion() > peliculaDao.get(indexMaxValoracion1).getValoracion()) {
				indexMaxValoracion1 = i;
			} else if (peliculaDao.get(i).getValoracion() > peliculaDao.get(indexMaxValoracion2).getValoracion()) {
				indexMaxValoracion2 = i;
			} else if (peliculaDao.get(i).getValoracion() > peliculaDao.get(indexMaxValoracion3).getValoracion()) {
				indexMaxValoracion3 = i;
			} else if (peliculaDao.get(i).getValoracion() > peliculaDao.get(indexMaxValoracion4).getValoracion()) {
				indexMaxValoracion4 = i;
			} else if (peliculaDao.get(i).getValoracion() > peliculaDao.get(indexMaxValoracion5).getValoracion()) {
				indexMaxValoracion5 = i;
			}
		}

		System.out.println("Listado de 5 peliculas más valoradas");
		System.out.println(peliculaDao.get(indexMaxValoracion1));
		System.out.println(peliculaDao.get(indexMaxValoracion2));
		System.out.println(peliculaDao.get(indexMaxValoracion3));
		System.out.println(peliculaDao.get(indexMaxValoracion4));
		System.out.println(peliculaDao.get(indexMaxValoracion5));
	}

}
