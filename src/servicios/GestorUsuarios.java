/*
 * @author Andrei y Maria
 * 
 * @version 1.0
 */

import datos.MapaUsuarios;

package servicios;

public class GestorUsuarios implements Gestor {
	
	private MapaUsuarios usuarios = new MapaUsuarios();
	
	listarUsuarios() {
		this.usuarios.listarUsuarios();
	}
	
	addUsuarios() {
		this.usuarios.addUsuarios();
	}
	
	eliminarUsuarios() {
		this.usuarios.eliminarUsuarios();
	}
	
	modificarUsuarios() {
		this.usuarios.modificarUsuarios();
	}
	
	
}
