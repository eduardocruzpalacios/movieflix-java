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

	private ListaPeliculas peliculas = new ListaPeliculas();

	public void listarPeliculas() {
		this.peliculas.listarPeliculas();

	}

	public void addPeliculas() {
		this.peliculas.addPeliculas();

	}

	public void eliminarPeliculas() {
		this.peliculas.eliminarPeliculas();

	}

	public void modificarUsuarios() {
		this.peliculas.modificarUsuarios();

	}

	public void peliculasMasValoradas() {
		this.peliculas.peliculasMasValoradas();
	}

	public void peliculasEncimaMedia() {
		this.peliculas.peliculasEncimaMedia();

	}

	public void peliculasPeorValoradas() {
		this.peliculas.peliculasPeorValoradas();

	}

	public void peliculasMasVistas() {
		this.peliculas.peliculasMasVistas();

	}

	public void importarPeliculas() {
		this.peliculas.importarPeliculas();
	}
}
