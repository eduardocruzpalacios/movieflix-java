/*
 * Fecha: 22/03/2021
 * 
 * @author Miguel
 * 
 * @version 1.0
 */

package services;

import dao.PeliculaDao;

public class PeliculaServiceImpl implements PeliculaService {

	private PeliculaDao peliculaDao = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		this.peliculaDao.listarPeliculas();
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

}
