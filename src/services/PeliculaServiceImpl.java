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
		this.peliculaDao.addPeliculas();
	}

	@Override
	public void eliminarPeliculas() {
		this.peliculaDao.eliminarPeliculas();
	}

	@Override
	public void modificarPeliculas() {
		this.peliculaDao.modificarPeliculas();
	}

	@Override
	public void importarPeliculas() {
		this.peliculaDao.importarPeliculas();
	}

}
