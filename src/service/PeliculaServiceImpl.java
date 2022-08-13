/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package service;

import java.util.List;

import dao.PeliculaDao;
import exception.ListadoVacioException;
import exception.PeliculaExistenteException;
import exception.PeliculaNoExistenteException;
import model.Pelicula;
import utility.Log;
import view.DatoFormulario;
import view.Menu;
import view.MostrarDato;
import view.PeliculaFormulario;

public class PeliculaServiceImpl implements PeliculaService {

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
			MostrarDato.string("Listado de Peliculas");
			MostrarDato.peliculas(peliculas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void addPeliculas() {
		Pelicula pelicula = PeliculaFormulario.crear();
		try {
			this.peliculaDao.addPelicula(pelicula);
			MostrarDato.string("Película creada correctamente");
		} catch (PeliculaExistenteException e) {
			Log.error(e);
		}
	}

	@Override
	public void eliminarPeliculas() {
		String tituloPelicula = DatoFormulario.string("Dime el título de la película a borrar");
		try {
			this.peliculaDao.eliminarPelicula(tituloPelicula);
			MostrarDato.string("Película eliminada correctamente");
		} catch (PeliculaNoExistenteException e) {
			Log.error(e);
		}
	}

	@Override
	public void modificarPeliculas() {
		String tituloPelicula = DatoFormulario.string("Dime el título de la película a modificar");
		try {
			Pelicula pelicula = this.peliculaDao.getPelicula(tituloPelicula);
			boolean cambiarTitulo = DatoFormulario.booleanPreguntando("¿Quieres cambiar el título?", "si");
			if (cambiarTitulo) {
				pelicula.setTitulo(DatoFormulario.string("¿Cual es el nuevo título?"));
			}
			boolean cambiarAnyoEstreno = DatoFormulario.booleanPreguntando("¿Quieres cambiar el año de estreno?", "si");
			if (cambiarAnyoEstreno) {
				pelicula.setAnyoEstreno((short) DatoFormulario.entero("¿Cual es el nuevo año de estreno?"));
			}
			boolean cambiarCategoria = DatoFormulario.booleanPreguntando("¿Quieres cambiar la categoría?", "si");
			if (cambiarCategoria) {
				pelicula.setCategoria((short) DatoFormulario.enteroEntre(1, 6, "¿Cual es la nueva categoría?"));
			}
			if (cambiarTitulo || cambiarAnyoEstreno || cambiarCategoria) {
				this.peliculaDao.modificarPelicula(pelicula);
				MostrarDato.string("Película modificada correctamente");
			} else {
				MostrarDato.string("no se modificó ningún dato");
			}
		} catch (PeliculaNoExistenteException e) {
			Log.error(e);
		}
	}

	@Override
	public void importarPeliculas() {
		this.peliculaDao.importarPeliculas();
	}

	@Override
	public void listarPeliculasPorCategoria() {
		Menu.categorias();
		short categoria = DatoFormulario.shortEntre(1, 6, "Elige una categoría");
		try {
			List<Pelicula> peliculasCategorizadasList = this.peliculaDao.getPeliculasPorCategoria(categoria);
			MostrarDato.peliculas(peliculasCategorizadasList);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void guardarPeliculas() {
		this.peliculaDao.guardarPeliculas();
	}

	@Override
	public void listarPeliculasMasValoradas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " películas, ¿cuántas de las más valoradas quieres ver?";
			int cuantas = DatoFormulario.enteroEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasValoradas = this.peliculaDao.getPeliculasMasValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas más valoradas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMasValoradas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void listarPeliculasMenosValoradas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " películas, ¿cuántas de las menos valoradas quieres ver?";
			int cuantas = DatoFormulario.enteroEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMenosValoradas = this.peliculaDao.getPeliculasMenosValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas menos valoradas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMenosValoradas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void listarPeliculasValoracionEncimaMedia() {
		try {
			List<Pelicula> peliculasValoracionEncimaMedia = this.peliculaDao.getPeliculasValoracionEncimaMedia();
			MostrarDato.string("Listado de peliculas cuya valoración está por encima de la media");
			MostrarDato.peliculas(peliculasValoracionEncimaMedia);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

	@Override
	public void listarPeliculasMasVistas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " películas, ¿cuántas de las más vistas quieres ver?";
			int cuantas = DatoFormulario.enteroEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasVistas = this.peliculaDao.getPeliculasMasVistas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas más vistas";
			MostrarDato.string(mensaje);
			MostrarDato.peliculas(peliculasMasVistas);
		} catch (ListadoVacioException e) {
			Log.error(e);
		}
	}

}
