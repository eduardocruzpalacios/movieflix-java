/*
*Fecha: 22/03/2021
*
*@author Raúl y María
*
*@version: 1.0
*
*Clase ListaPeliculas
*
*Clase que recoge todos los métodos para la gestión de los películas (añadir películas, listado, eliminar y modificar)
*
*/

package datos;

import excepciones.ListadoVacio;

import java.io.File;
import java.util.ArrayList;
import model.Pelicula;
import utilidades.Escritor;
import utilidades.Files;
import utilidades.Lector;
import utilidades.Colecciones;
import gui.Menu;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListaPeliculas {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MapaUsuarios.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private List<Pelicula> ListaPeliculas = new ArrayList<Pelicula>();

	// constructores
	public ListaPeliculas() {

	}

	// getteres y setters

	public List<Pelicula> getListaPeliculas() {
		return ListaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> ListaPeliculas) {
		this.ListaPeliculas = ListaPeliculas;
	}

	// Metodos

	public void listarPeliculas() {
		try {
			if (ListaPeliculas.size() == 0) {
				Escritor.str("El listado está vacío");

				throw new excepciones.ListadoVacio();
			} else {
				System.out.println("Listado de Peliculas");
				for (int i = 0; i < ListaPeliculas.size(); i++) {
					System.out.println(ListaPeliculas.get(i));
				}

			}

		} catch (ListadoVacio e) {
			logger.error(e.toString());
		} finally {

		}

	}

	public void addPeliculas() {
		Pelicula p = Pelicula.crearYRellenarPelicula();
		ListaPeliculas.add(p);
		Escritor.str("Película creada correctamente");
	}

	public void eliminarPeliculas() {
		String s = Lector.str("Dime el título de la película a borrar");
		for (int i = 0; i < ListaPeliculas.size(); i++) {
			if (s.equals(ListaPeliculas.get(i).getTitulo())) {
				ListaPeliculas.remove(ListaPeliculas.get(i));
			}
		}

	}

	public void modificarPeliculas() {
		String s = Lector.str("Dime el título de la película a modificar");
		Menu.modificarPelicula();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch (opcion) {
		case 1:
			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (s.equals(ListaPeliculas.get(i).getTitulo())) {
					ListaPeliculas.get(i).setTitulo(Lector.str("¿Cual es el nuevo título?"));
				}
			}
			break;
		case 2:
			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (s.equals(ListaPeliculas.get(i).getTitulo())) {
					ListaPeliculas.get(i).setAnyoEstreno((short) Lector.pedirInt("¿Cual es el nuevo año de estreno?"));
				}
			}
			break;

		case 3:
			for (int i = 0; i < ListaPeliculas.size(); i++) {
				if (s.equals(ListaPeliculas.get(i).getTitulo())) {
					ListaPeliculas.get(i).setCategoria((short) Lector.pedirInt("Digame la nueva categoría"));
				}
			}
			break;
		}
		Escritor.str("Esta película ha sido modificada");
	}

	public void importarPeliculas() {

		File fichero = new File("peliculas.txt");

		ArrayList<String> pelisRaw = Files.exportarAList(fichero);

		ArrayList<Pelicula> pelisTodas = Colecciones.leerListCadenasDevolverListObjetos(pelisRaw);

		ListaPeliculas = pelisTodas;
	}
}
