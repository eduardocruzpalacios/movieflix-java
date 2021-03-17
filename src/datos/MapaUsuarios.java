package datos;

import model.Usuario;
import utilidades.Escritor;
import utilidades.Lector;

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
		Iterator<Integer> usuarios = MapaUsuarios.keySet().iterator();
		System.out.println("Listado de Usuarios");
		while (usuarios.hasNext()) {
			key = usuarios.next();
			System.out.println("[" + key + "]:" + MapaUsuarios.get(key));
		}

	}

	public boolean addUsuarios(int codigo, Usuario u) {
		if (MapaUsuarios.containsKey(codigo)) {
			System.out.println("u1");

			return false;

		} else {
			MapaUsuarios.put(codigo, u);
			return true;
		}

	}
	public void eliminarUsuarios(int codigo) {
		MapaUsuarios.remove(codigo);
		
	}
	public void modificarUsuarios(Map<Integer,Usuario>MapaUsuarios) {
		
		int codigo = Lector.pedirInt("Dame el código del usuario");
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
