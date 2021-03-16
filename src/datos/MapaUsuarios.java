package datos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Usuario;

public class MapaUsuarios {
//Posteriormente implementar interfaz 

	// Código y Usuario
	private Map<Integer, Usuario> MapaUsuarios;

	public MapaUsuarios() {
		MapaUsuarios = new HashMap<>();
	}

	public Map<Integer, Usuario> getMapaUsuarios() {
		return MapaUsuarios;
	}

	public void setMapaUsuarios(Map<Integer, Usuario> MapaUsuario) {
		this.MapaUsuarios = MapaUsuarios;
	}

	// Métodos

	public void listarUsuarios() {
		Integer key;
		Iterator <Integer> usuarios = MapaUsuarios.keySet().iterator();	
		System.out.println("Listado de Usuarios");
		while(usuarios.hasNext()) {
			key = usuarios.next();
			System.out.println("[" + key + "]:" + MapaUsuarios.get(key));
		}
	
	}

}
