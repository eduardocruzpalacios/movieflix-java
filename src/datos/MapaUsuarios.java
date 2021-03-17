package datos;

import model.Usuario;
import utilidades.Escritor;
import utilidades.Lector;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gui.Menu;

import Excepciones.UsuarioExistente;

public class MapaUsuarios {

	// Código y Usuario
	private Map<String, Usuario> MapaUsuarios;

	public MapaUsuarios() {
		MapaUsuarios = new HashMap<>();
	}

	public Map<String, Usuario> getMapaUsuarios() {
		return MapaUsuarios;
	}

	public void setMapaUsuarios(Map<String, Usuario> MapaUsuario) {
		this.MapaUsuarios = MapaUsuarios;
	}

	// Métodos

	public void listarUsuarios() {
		String key;
		Iterator<String> usuarios = MapaUsuarios.keySet().iterator();
		System.out.println("Listado de Usuarios");
		while (usuarios.hasNext()) {
			key = usuarios.next();
			System.out.println("[" + key + "]:" + MapaUsuarios.get(key));
		}

	}

	public void addUsuarios() {
		
		try {
			Usuario u = Usuario.crearYRellenarUsuario();
			
			if (MapaUsuarios.containsValue(u)) {
				Escritor.str("Ese usuario ya existía");

				throw new Excepciones.UsuarioExistente();

			} else {
				MapaUsuarios.put(u.getNombre(), u);
				Escritor.str("Usuario creado correctamente");
			}
		}
		catch(UsuarioExistente e) {
			e.getStackTrace();
		}
		finally {
			
		}
		

	}
	
	public void eliminarUsuarios() {
		String codigo = Lector.str("dime el nombre de usuario a borrar");
		MapaUsuarios.remove(codigo);
		
	}
	
	public void modificarUsuarios() {
		
		String codigo = Lector.str("Dame el código del usuario");
		Menu.modificarUsuario();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch(opcion) {
			case 1:
				MapaUsuarios.get(codigo).setNombre(Lector.str("¿Cual es el nuevo nombre?"));
				break;
			case 2:
				MapaUsuarios.get(codigo).setCiudadResidencia(Lector.str("¿Cual es la nueva ciudad?"));
				break;
			
			case 3:
				MapaUsuarios.get(codigo).setYear(Lector.pedirInt("Digame el nuevo año"));
				MapaUsuarios.get(codigo).setMes(Lector.pedirInt("Digame el nuevo mes"));
				MapaUsuarios.get(codigo).setDia(Lector.pedirInt("Digame el nuevo dia"));
				MapaUsuarios.get(codigo).generarFechaNac();
				break;
		}
		Escritor.str("Este usuario ha sido modificado");
	}
}
