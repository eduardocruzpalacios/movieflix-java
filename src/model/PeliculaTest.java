package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PeliculaTest {

	@Test
	void testConstructorAndGetters() {
		// given
		String titulo = "viaje nuevo";
		short anyoEstreno = 1995;
		short categoria = 3;
		long visualizaciones = 0;
		float valoracion = 3.5f;

		// when
		Pelicula pelicula = new Pelicula(titulo, anyoEstreno, categoria, visualizaciones, valoracion);

		// then
		assertAll("pelicula", () -> assertEquals(titulo, pelicula.getTitulo()),
				() -> assertEquals(anyoEstreno, pelicula.getAnyoEstreno()),
				() -> assertEquals(categoria, pelicula.getCategoria()),
				() -> assertEquals(visualizaciones, pelicula.getVisualizaciones()),
				() -> assertEquals(valoracion, pelicula.getValoracion()));
	}

	@Test
	void testSetters() {
		// given
		String titulo = "viaje nuevo";
		short anyoEstreno = 1995;
		short categoria = 3;
		long visualizaciones = 0;
		float valoracion = 3.5f;

		// when
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setAnyoEstreno(anyoEstreno);
		pelicula.setCategoria(categoria);
		pelicula.setVisualizaciones(visualizaciones);
		pelicula.setValoracion(valoracion);

		// then
		assertAll("pelicula", () -> assertEquals(titulo, pelicula.getTitulo()),
				() -> assertEquals(anyoEstreno, pelicula.getAnyoEstreno()),
				() -> assertEquals(categoria, pelicula.getCategoria()),
				() -> assertEquals(visualizaciones, pelicula.getVisualizaciones()),
				() -> assertEquals(valoracion, pelicula.getValoracion()));
	}

	@Test
	void shouldHaveToStringMethodOverride() {
		// given
		Pelicula pelicula = new Pelicula();

		// when
		String toString = pelicula.toString();

		// then
		assertNotEquals(pelicula.hashCode(), toString);
	}

}
