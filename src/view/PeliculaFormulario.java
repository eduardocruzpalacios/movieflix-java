package view;

import model.Pelicula;
import utility.Lector;

public class PeliculaFormulario {

	public static Pelicula crear() {
		Pelicula pelicula = new Pelicula();
		MostrarDato.string("vamos a añadir una nueva pelicula, voy a pedirte los datos");
		pelicula.setTitulo(Lector.str("dime el titulo"));
		pelicula.setAnyoEstreno((short) Lector.pedirInt("dime el año de estreno"));
		pelicula.setCategoria((short) Lector.pedirIntEntre(1, 6, "dime que categoria es"));
		pelicula.setVisualizaciones(0);
		pelicula.setValoracion(-1);
		return pelicula;
	}

}
