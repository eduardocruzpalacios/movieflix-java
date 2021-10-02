/*
 * Fecha: 22/03/2021
 *
 * @author Raúl y María
 *
 * @version: 1.0
 */

package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.ListadoVacioException;
import excepciones.PeliculaExistenteException;
import factory.AbstractFactory;
import factory.FactoryProvider;
import gui.Menu;
import model.Pelicula;
import utilidades.Colecciones;
import utilidades.Escritor;
import utilidades.Files;
import utilidades.Lector;

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

	public void listarPeliculas() {
		try {
			if (peliculaDao.size() == 0) {
				Escritor.str("El listado está vacío");
				throw new excepciones.ListadoVacioException();
			} else {
				System.out.println("Listado de Peliculas");
				peliculaDao.forEach(pelicula -> System.out.println(pelicula));
			}
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	public void addPeliculas() {
		try {
			AbstractFactory<?> abstractFactory = FactoryProvider.getFactory("pelicula");
			Pelicula pelicula = (Pelicula) abstractFactory.create("pelicula");
			for (int i = 0; i < peliculaDao.size(); i++) {
				if (peliculaDao.get(i).getTitulo().equals(pelicula.getTitulo())) {
					throw new excepciones.PeliculaExistenteException();
				}
			}
			peliculaDao.add(pelicula);
			Escritor.str("Película creada correctamente");
		} catch (PeliculaExistenteException e) {
			logger.error(e.toString());
		}
	}

	public void eliminarPeliculas() {
		String tituloPelicula = Lector.str("Dime el título de la película a borrar");
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (tituloPelicula.equals(peliculaDao.get(i).getTitulo())) {
				peliculaDao.remove(peliculaDao.get(i));
			}
		}
	}

	public void modificarPeliculas() {
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
		File file = new File("peliculas.txt");
		ArrayList<String> arrayString = Files.exportarAList(file);
		ArrayList<Pelicula> arrayPeliculas = Colecciones.leerListCadenasDevolverListObjetos(arrayString);
		peliculaDao = arrayPeliculas;
	}

}
