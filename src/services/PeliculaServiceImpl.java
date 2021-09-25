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

	private PeliculaDao p = new PeliculaDao();

	@Override
	public void listarPeliculas() {
		this.p.listarPeliculas();
	}

	@Override
	public void addPeliculas() {
		this.p.addPeliculas();
	}

	@Override
	public void eliminarPeliculas() {
		this.p.eliminarPeliculas();
	}

	@Override
	public void modificarPeliculas() {
		this.p.modificarPeliculas();
	}

	@Override
	public void importarPeliculas() {
		this.p.importarPeliculas();
	}

}
