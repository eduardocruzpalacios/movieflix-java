package factory;

import model.Pelicula;
import utilidades.Escritor;
import utilidades.Lector;

public class PeliculaFactory {

	public static Pelicula crearPelicula() {
		Pelicula pelicula = new Pelicula();
		Escritor.str("vamos a añadir una nueva pelicula, voy a pedirte los dao");
		pelicula.setTitulo(Lector.str("dime el titulo"));
		pelicula.setAnyoEstreno((short) Lector.pedirInt("dime el año de estreno"));
		pelicula.setCategoria((short) Lector.pedirInt("dime que categoria es"));
		return pelicula;
	}

}
