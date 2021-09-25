/* 
 * Fecha: 25/09/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 */

package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.Usuario;

class UsuarioTest {

	@Test
	void should_not_null() {
		Usuario usuario = new Usuario();
		assertNotNull(usuario);
	}

	@Test
	void should_getters_work() {
		Usuario usuario = new Usuario("nombre", LocalDate.of(2000, 5, 10), "ciudad");
		assertEquals("nombre", usuario.getNombre());
		assertEquals(LocalDate.of(2000, 5, 10), usuario.getFechaNacimiento());
		assertEquals("ciudad", usuario.getCiudadResidencia());
	}

	@Test
	void should_setters_work() {
		Usuario usuario = new Usuario();
		String nombre = "nombre";
		LocalDate localDate = LocalDate.of(2000, 5, 10);
		String ciudad = "ciudad";
		usuario.setNombre(nombre);
		usuario.setFechaNacimiento(localDate);
		usuario.setCiudadResidencia(ciudad);
		assertEquals("nombre", usuario.getNombre());
		assertEquals(LocalDate.of(2000, 5, 10), usuario.getFechaNacimiento());
		assertEquals("ciudad", usuario.getCiudadResidencia());
	}

	@Test
	void should_toString_instanceof_String() {
		Usuario usuario = new Usuario();
		boolean esString = usuario.toString() instanceof String;
		assertTrue(esString);
	}

	@Test
	void should_crearUsuario_method_work() {
		Usuario usuario = Usuario.crearUsuario();
		assertNotNull(usuario);
	}

}
