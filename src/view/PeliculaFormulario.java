package view;

import model.Pelicula;

public class PeliculaFormulario {

	public static Pelicula crear() {
		Pelicula pelicula = new Pelicula();
		MostrarDato.string("vamos a añadir una nueva pelicula, voy a pedirte los datos");
		pelicula.setTitulo(DatoFormulario.string("dime el titulo"));
		pelicula.setAnyoEstreno((short) DatoFormulario.entero("dime el año de estreno"));
		pelicula.setCategoria((short) DatoFormulario.enteroEntre(1, 6, "dime que categoria es"));
		pelicula.setVisualizaciones(0);
		pelicula.setValoracion(-1);
		return pelicula;
	}

}
