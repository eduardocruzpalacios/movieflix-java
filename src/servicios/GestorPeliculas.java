/*
 * Fecha: 22/03/2021
 * 
 * @author Miguel
 * 
 * @version 1.0
 */

package servicios;

import datos.ListaPeliculas;

public class GestorPeliculas implements GestorP {

	private ListaPeliculas p = new ListaPeliculas();

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
