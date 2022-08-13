package view;

import model.Pelicula;

public class PeliculaFormulario {

	private final static short VISUALIZACIONES_POR_DEFECTO = 0;
	private final static short VALORACION_POR_DEFECTO = -1;

	public static Pelicula crear() {
		Pelicula pelicula = new Pelicula();
		MostrarDato.string("vamos a añadir una nueva pelicula, voy a pedirte los datos");
		String titulo = DatoFormulario.string("dime el titulo");
		pelicula.setTitulo(titulo);
		short anyoEstreno = (short) DatoFormulario.entero("dime el año de estreno");
		pelicula.setAnyoEstreno(anyoEstreno);
		short categoria = (short) DatoFormulario.enteroEntre(1, 6, "dime que categoria es");
		pelicula.setCategoria(categoria);
		pelicula.setVisualizaciones(VISUALIZACIONES_POR_DEFECTO);
		pelicula.setValoracion(VALORACION_POR_DEFECTO);
		return pelicula;
	}

}
