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

	public static Pelicula modificar(Pelicula pelicula) {
		boolean cambiarTitulo = DatoFormulario.booleanPreguntando("¿Quieres cambiar el título?", "si");
		if (cambiarTitulo) {
			String titulo = DatoFormulario.string("¿Cual es el nuevo título?");
			pelicula.setTitulo(titulo);
		}
		boolean cambiarAnyoEstreno = DatoFormulario.booleanPreguntando("¿Quieres cambiar el año de estreno?", "si");
		if (cambiarAnyoEstreno) {
			short anyoEstreno = (short) DatoFormulario.entero("¿Cual es el nuevo año de estreno?");
			pelicula.setAnyoEstreno(anyoEstreno);
		}
		boolean cambiarCategoria = DatoFormulario.booleanPreguntando("¿Quieres cambiar la categoría?", "si");
		if (cambiarCategoria) {
			short categoria = (short) DatoFormulario.enteroEntre(1, 6, "¿Cual es la nueva categoría?");
			pelicula.setCategoria(categoria);
		}
		return pelicula;
	}

}
