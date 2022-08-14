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

import exception.ListadoVacioException;
import exception.PeliculaExistenteException;
import exception.PeliculaNoExistenteException;
import model.Pelicula;
import utility.Coleccion;
import utility.Fichero;

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
		ArrayList<String> arrayString = Fichero.leerFicheroDevolverArrayString(filePath);
		ArrayList<Pelicula> arrayPeliculas = Coleccion.arrayStringToArrayPelicula(arrayString);
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
		List<String> listString = Coleccion.listPeliculaToListString(this.peliculaDao);
		Fichero.LeerListStringGuardarEnFichero(listString, filePath);
	}

	public List<Pelicula> getPeliculasMasValoradas(int cuantas) {

		int[] indicesMaximos = new int[cuantas];

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

		List<Pelicula> peliculasMasValoradas = new ArrayList<Pelicula>();
		for (int i = 0; i < indicesMaximos.length; i++) {
			peliculasMasValoradas.add(peliculaDao.get(indicesMaximos[i]));
		}
		return peliculasMasValoradas;

	}

	public List<Pelicula> getPeliculasMenosValoradas(int cuantas) {
		int[] indicesMinimos = new int[cuantas];

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

		List<Pelicula> peliculasMenosValoradas = new ArrayList<Pelicula>();
		for (int i = 0; i < indicesMinimos.length; i++) {
			peliculasMenosValoradas.add(peliculaDao.get(indicesMinimos[i]));
		}
		return peliculasMenosValoradas;

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

	public List<Pelicula> getPeliculasMasVistas(int cuantas) {

		int numeroMaximos = cuantas;

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

		List<Pelicula> peliculasMasVistas = new ArrayList<Pelicula>();
		for (int i = 0; i < indicesMaximos.length; i++) {
			peliculasMasVistas.add(peliculaDao.get(indicesMaximos[i]));
		}
		return peliculasMasVistas;

	}

}
