/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package services;

import java.util.List;

import dao.PeliculaDao;
import model.Pelicula;
import tools.Escritor;

public class PeliculaServiceImpl implements PeliculaService {

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		List<Pelicula> peliculas = this.peliculaDao.getPeliculas();
		if (peliculas != null) {
			Escritor.str("Listado de Peliculas");
			Escritor.listPelicula(peliculas);
		} else {
			Escritor.str("El listado está vacío");
		}
	}

	@Override
	public void addPeliculas() {
		this.peliculaDao.addPelicula();
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
