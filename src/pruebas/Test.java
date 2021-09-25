/*
 * Fecha: 16/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 */

package pruebas;

import dao.MapaUsuarios;
import model.Usuario;
import servicios.GestorUsuarios;

public class Test {

	public static void _01_clase_Usuario() {

		Usuario u1 = new Usuario();
		u1.setNombre("Trump");
		u1.setCiudadResidencia("Cartagena");
		u1.setDia(1);
		u1.setMes(5);
		u1.setYear(2010);
		u1.generarFechaNac();

		Usuario u2 = new Usuario("Cardasian", 1971, 5, 1, "Elche");

		Usuario u3 = Usuario.crearYRellenarUsuario();

		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);

		System.out.println(u1.getNombre());
		System.out.println(u1.getCiudadResidencia());
		System.out.println(u1.getDia());
		System.out.println(u1.getMes());
		System.out.println(u1.getYear());
		System.out.println(u1.getFechaNacimiento());

	}

	public static void _02_clase_MapaUsuarios() {

		MapaUsuarios mu = new MapaUsuarios();
		System.out.println(mu);

		mu.listarUsuarios();

		mu.addUsuarios();
		mu.addUsuarios();

		mu.listarUsuarios();

		mu.modificarUsuarios();

		mu.eliminarUsuarios();

		mu.listarUsuarios();
	}

	public static void _03_clase_GestorUsuarios() {

		GestorUsuarios g = new GestorUsuarios();

		g.addUsuarios();
		g.addUsuarios();

		g.listarUsuarios();

		g.modificarUsuarios();

		g.eliminarUsuarios();

		g.listarUsuarios();
	}

}
