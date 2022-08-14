package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class UsuarioTest {

	@Test
	void testConstructorAndGetters() {
		// given
		String nombre = "Javier";
		LocalDate fechaNacimiento = LocalDate.now();
		String ciudadResidencia = "Granada";

		// when
		Usuario usuario = new Usuario(nombre, fechaNacimiento, ciudadResidencia);

		// then
		assertAll("usuario", () -> assertEquals(nombre, usuario.getNombre()),
				() -> assertEquals(fechaNacimiento, usuario.getFechaNacimiento()),
				() -> assertEquals(ciudadResidencia, usuario.getCiudadResidencia()));
	}

	@Test
	void testSetters() {
		// given
		String nombre = "Javier";
		LocalDate fechaNacimiento = LocalDate.now();
		String ciudadResidencia = "Granada";

		// when
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setCiudadResidencia(ciudadResidencia);

		// then
		assertAll("usuario", () -> assertEquals(nombre, usuario.getNombre()),
				() -> assertEquals(fechaNacimiento, usuario.getFechaNacimiento()),
				() -> assertEquals(ciudadResidencia, usuario.getCiudadResidencia()));
	}

	@Test
	void shouldHaveToStringMethodOverride() {
		// given
		Usuario usuario = new Usuario();

		// when
		String toString = usuario.toString();

		// then
		assertNotEquals(usuario.hashCode(), toString);
	}

}
