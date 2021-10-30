/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package dao;

import java.util.ArrayList;
import java.util.List;

import exceptions.ListadoVacioException;
import exceptions.PeliculaExistenteException;
import exceptions.PeliculaNoExistenteException;
import model.Pelicula;
import tools.Colecciones;
import tools.Files;

public class PeliculaDao {

	private List<Pelicula> peliculaDao = new ArrayList<Pelicula>();
	private String filePath = "peliculas.txt";

	public List<Pelicula> getPeliculas() throws ListadoVacioException {
		if (peliculaDao.size() == 0) {
			throw new ListadoVacioException();
		}
		return peliculaDao;
	}

	public boolean addPelicula(Pelicula pelicula) throws PeliculaExistenteException {
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (peliculaDao.get(i).getTitulo().toLowerCase().equals(pelicula.getTitulo().toLowerCase())) {
				throw new PeliculaExistenteException();
			}
		}
		peliculaDao.add(pelicula);
		return true;
	}

	public boolean eliminarPelicula(String tituloPelicula) throws PeliculaNoExistenteException {
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (tituloPelicula.toLowerCase().equals(peliculaDao.get(i).getTitulo().toLowerCase())) {
				peliculaDao.remove(peliculaDao.get(i));
				return true;
			}
		}
		throw new PeliculaNoExistenteException();
	}

	public Pelicula getPelicula(String tituloPelicula) throws PeliculaNoExistenteException {
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (tituloPelicula.toLowerCase().equals(peliculaDao.get(i).getTitulo().toLowerCase())) {
				return peliculaDao.get(i);
			}
		}
		throw new PeliculaNoExistenteException();
	}

	public void modificarPelicula(Pelicula pelicula) {
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (pelicula.getTitulo().toLowerCase().equals(peliculaDao.get(i).getTitulo().toLowerCase())) {
				peliculaDao.get(i).setTitulo(pelicula.getTitulo());
				peliculaDao.get(i).setAnyoEstreno(pelicula.getAnyoEstreno());
				peliculaDao.get(i).setCategoria(pelicula.getCategoria());
			}
		}
	}

	public void importarPeliculas() {
		ArrayList<String> arrayString = Files.leerRutaFicheroDevolverArrayString(filePath);
		ArrayList<Pelicula> arrayPeliculas = Colecciones.leerArrayStringDevolverArrayPelicula(arrayString);
		peliculaDao = arrayPeliculas;
	}

	public List<Pelicula> getPeliculasPorCategoria(short categoria) throws ListadoVacioException {
		if (peliculaDao.size() == 0) {
			throw new ListadoVacioException();
		}
		List<Pelicula> peliculasCategoria = new ArrayList<Pelicula>();
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (peliculaDao.get(i).getCategoria() == categoria) {
				peliculasCategoria.add(peliculaDao.get(i));
			}
		}
		return peliculasCategoria;
	}

	public void guardarPeliculas() {
		List<String> listString = Colecciones.leerListPeliculaDevolverListString(this.peliculaDao);
		Files.LeerListStringGuardarEnFichero(listString, filePath);
	}

	public void listarPeliculasMasValoradas(int cuantas) {

		int numeroMaximos = cuantas;

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

	public void listarPeliculasMenosValoradas(int cuantas) {

		int numeroMinimos = cuantas;

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

	public List<Pelicula> getPeliculasValoracionEncimaMedia() throws ListadoVacioException {
		if (peliculaDao.size() == 0) {
			throw new ListadoVacioException();
		}
		float sumatorio = 0f;
		for (int i = 0; i < peliculaDao.size(); i++) {
			sumatorio += peliculaDao.get(i).getValoracion();
		}
		float media = sumatorio / peliculaDao.size();
		List<Pelicula> peliculasValoracionEncimaMedia = new ArrayList<Pelicula>();
		for (int i = 0; i < peliculaDao.size(); i++) {
			if (peliculaDao.get(i).getValoracion() > media) {
				peliculasValoracionEncimaMedia.add(peliculaDao.get(i));
			}
		}
		return peliculasValoracionEncimaMedia;
	}

	public void listarPeliculasMasVistas() {

		int numeroMaximos = 5;

		int[] indicesMaximos = new int[numeroMaximos];

		float visualizacionesMaximas;

		for (int i = 0; i < indicesMaximos.length; i++) {
			visualizacionesMaximas = 0f;

			for (int j = 0; j < peliculaDao.size(); j++) {

				if (peliculaDao.get(j).getVisualizaciones() >= visualizacionesMaximas) {

					int cuenta = 0;

					for (int k = 0; k < indicesMaximos.length; k++) {

						if (!peliculaDao.get(indicesMaximos[k]).getTitulo().equals(peliculaDao.get(j).getTitulo())) {
							cuenta++;
						}

					}

					if (cuenta == indicesMaximos.length) {
						visualizacionesMaximas = peliculaDao.get(j).getVisualizaciones();
						indicesMaximos[i] = j;
					}

				}

			}
		}

		System.out.println("Listado de " + numeroMaximos + " peliculas más vistas");
		for (int i = 0; i < indicesMaximos.length; i++) {
			System.out.println(peliculaDao.get(indicesMaximos[i]));
		}

	}

}
