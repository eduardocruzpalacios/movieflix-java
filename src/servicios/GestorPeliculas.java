/**
 * 
 * Fecha: 22/03/2021
* 
* @author Miguel
* 
* @version 1.0
* 
* Clase GestoPeliculas
* 
* Se implementan los métodos del gestor
* 
*/

package servicios;

import datos.ListaPeliculas;

public class GestorPeliculas implements GestorP {

	private ListaPeliculas p = new ListaPeliculas();

	public void listarPeliculas() {
		this.p.listarPeliculas();

	}

	public void addPeliculas() {
		this.p.addPeliculas();

	}

	public void eliminarPeliculas() {
		this.p.eliminarPeliculas();

	}

	public void modificarPeliculas() {
		this.p.modificarPeliculas();

	}

	/*public void peliculasMasValoradas() {
		this.p.peliculasMasValoradas();
	}

	public void peliculasEncimaMedia() {
		this.p.peliculasEncimaMedia();

	}

	public void peliculasPeorValoradas() {
		this.p.peliculasPeorValoradas();

	}

	public void peliculasMasVistas() {
		this.p.peliculasMasVistas();

	}*/

	public void importarPeliculas() {
		this.p.importarPeliculas();
	}
}
