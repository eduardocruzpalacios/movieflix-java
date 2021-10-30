/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.PeliculaDao;
import exceptions.ListadoVacioException;
import exceptions.PeliculaExistenteException;
import model.Pelicula;
import tools.Escritor;

public class PeliculaServiceImpl implements PeliculaService {

	private static Logger logger = LogManager.getLogger();

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		try {
			List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
			Escritor.str("Listado de Peliculas");
			Escritor.listPelicula(peliculas);
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void addPeliculas() {
		Pelicula pelicula = Pelicula.crear();
		try {
			this.peliculaDao.addPelicula(pelicula);
			Escritor.str("Película creada correctamente");
		} catch (PeliculaExistenteException e) {
			logger.error(e.toString());
			Escritor.str("Película ya existente");
		}
	}

	@Override
	public void eliminarPeliculas() {
		this.peliculaDao.eliminarPelicula();
	}

	@Override
	public void modificarPeliculas() {
		this.peliculaDao.modificarPelicula();
	}

	@Override
	public void importarPeliculas() {
		this.peliculaDao.importarPeliculas();
	}

	@Override
	public void listarPeliculasPorCategoria() {
		this.peliculaDao.listarPeliculasPorCategoria();
	}

	@Override
	public void guardarPeliculas() {
		this.peliculaDao.guardarPeliculas();
	}

	@Override
	public void listarPeliculasMasValoradas() {
		this.peliculaDao.listarPeliculasMasValoradas();
	}

	@Override
	public void listarPeliculasMenosValoradas() {
		this.peliculaDao.listarPeliculasMenosValoradas();
	}

	@Override
	public void listarPeliculasValoracionEncimaMedia() {
		this.peliculaDao.listarPeliculasValoracionEncimaMedia();
	}

	@Override
	public void listarPeliculasMasVistas() {
		this.peliculaDao.listarPeliculasMasVistas();
	}

}
