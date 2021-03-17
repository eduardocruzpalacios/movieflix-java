/*
 * @author Andrei y Maria
 * 
 * @version 1.0
 */

package servicios;
import datos.MapaUsuarios;

public class GestorUsuarios implements Gestor {
	
	private MapaUsuarios usuarios = new MapaUsuarios();
	
	public void listarUsuarios() {
		this.usuarios.listarUsuarios();
	}
	
	public void addUsuarios() {
		
		this.usuarios.addUsuarios();
	}
	
	public void eliminarUsuarios() {
		this.usuarios.eliminarUsuarios();
	}
	
	public void modificarUsuarios() {
		this.usuarios.modificarUsuarios();
	}
	
	
}
