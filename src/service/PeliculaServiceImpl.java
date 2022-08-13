/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.PeliculaDao;
import exception.ListadoVacioException;
import exception.PeliculaExistenteException;
import exception.PeliculaNoExistenteException;
import model.Pelicula;
import utility.Lector;
import view.Escritor;
import view.Menu;

public class PeliculaServiceImpl implements PeliculaService {

	private static Logger logger = LogManager.getLogger();

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
			Escritor.string("Listado de Peliculas");
			Escritor.peliculas(peliculas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void addPeliculas() {
		Pelicula pelicula = Pelicula.crear();
		try {
			this.peliculaDao.addPelicula(pelicula);
			Escritor.string("Película creada correctamente");
		} catch (PeliculaExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void eliminarPeliculas() {
		String tituloPelicula = Lector.str("Dime el título de la película a borrar");
		try {
			this.peliculaDao.eliminarPelicula(tituloPelicula);
			Escritor.string("Película eliminada correctamente");
		} catch (PeliculaNoExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void modificarPeliculas() {
		String tituloPelicula = Lector.str("Dime el título de la película a modificar");
		try {
			Pelicula pelicula = this.peliculaDao.getPelicula(tituloPelicula);
			boolean cambiarTitulo = Lector.preguntarSiNo("¿Quieres cambiar el título? Escribe si o no", "si", "no");
			if (cambiarTitulo) {
				pelicula.setTitulo(Lector.str("¿Cual es el nuevo título?"));
			}
			boolean cambiarAnyoEstreno = Lector.preguntarSiNo("¿Quieres cambiar el año de estreno? Escribe si o no",
					"si", "no");
			if (cambiarAnyoEstreno) {
				pelicula.setAnyoEstreno((short) Lector.pedirInt("¿Cual es el nuevo año de estreno?"));
			}
			boolean cambiarCategoria = Lector.preguntarSiNo("¿Quieres cambiar la categoría? Escribe si o no", "si",
					"no");
			if (cambiarCategoria) {
				pelicula.setCategoria((short) Lector.pedirIntEntre(1, 6, "¿Cual es la nueva categoría?"));
			}
			if (cambiarTitulo || cambiarAnyoEstreno || cambiarCategoria) {
				this.peliculaDao.modificarPelicula(pelicula);
				Escritor.string("Película modificada correctamente");
			} else {
				Escritor.string("no se modificó ningún dato");
			}
		} catch (PeliculaNoExistenteException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void importarPeliculas() {
		this.peliculaDao.importarPeliculas();
	}

	@Override
	public void listarPeliculasPorCategoria() {
		Menu.categorias();
		short categoria = Lector.pedirShortEntre(1, 6, "Elige una categoría");
		try {
			List<Pelicula> peliculasCategorizadasList = this.peliculaDao.getPeliculasPorCategoria(categoria);
			Escritor.peliculas(peliculasCategorizadasList);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
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
			int cuantas = Lector.pedirIntEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasValoradas = this.peliculaDao.getPeliculasMasValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas más valoradas";
			Escritor.string(mensaje);
			Escritor.peliculas(peliculasMasValoradas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasMenosValoradas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " películas, ¿cuántas de las menos valoradas quieres ver?";
			int cuantas = Lector.pedirIntEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMenosValoradas = this.peliculaDao.getPeliculasMenosValoradas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas menos valoradas";
			Escritor.string(mensaje);
			Escritor.peliculas(peliculasMenosValoradas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasValoracionEncimaMedia() {
		try {
			List<Pelicula> peliculasValoracionEncimaMedia = this.peliculaDao.getPeliculasValoracionEncimaMedia();
			Escritor.string("Listado de peliculas cuya valoración está por encima de la media");
			Escritor.peliculas(peliculasValoracionEncimaMedia);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void listarPeliculasMasVistas() {
		try {
			int limiteSuperior = this.peliculaDao.getPeliculas().size();
			String mensaje = "Hay " + limiteSuperior + " películas, ¿cuántas de las más vistas quieres ver?";
			int cuantas = Lector.pedirIntEntre(0, limiteSuperior, mensaje);
			List<Pelicula> peliculasMasVistas = this.peliculaDao.getPeliculasMasVistas(cuantas);
			mensaje = "Listado de " + cuantas + " peliculas más vistas";
			Escritor.string(mensaje);
			Escritor.peliculas(peliculasMasVistas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

}
