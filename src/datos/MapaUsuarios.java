/**
* Fecha: 17/03/2021
* 
* @author Miguel, Raúl y Edu
* 
* @version 1.0
* 
* Clase MapaUsuarios
* 
* Clase que recoge todos los métodos para la gestión de los usuarios(añadir usuarios, listado, eliminar y modificar)
*/

// hay que hacer loggin de los métodos

package datos;

import model.Usuario;
import utilidades.Escritor;
import utilidades.Lector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import excepciones.ListadoVacio;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gui.Menu;

import excepciones.UsuarioExistente;

public class MapaUsuarios {

	private static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(MapaUsuarios.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

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
		try {
			if (MapaUsuarios.size() == 0) {
				Escritor.str("El listado está vacío");

				throw new excepciones.ListadoVacio();

			} else {
				String key;
				Iterator<String> usuarios = MapaUsuarios.keySet().iterator();
				System.out.println("Listado de Usuarios");
				while (usuarios.hasNext()) {
					key = usuarios.next();
					System.out.println("[" + key + "]:" + MapaUsuarios.get(key));
				}
			}

		} catch (ListadoVacio e) {
			logger.error(e.toString());
		} finally {

		}

	}

	public void addUsuarios() {

		try {
			Usuario u = Usuario.crearYRellenarUsuario();

			if (MapaUsuarios.containsKey(u.getNombre())) {
				Escritor.str("Ese usuario ya existía");

				throw new excepciones.UsuarioExistente();

			} else {
				MapaUsuarios.put(u.getNombre(), u);
				Escritor.str("Usuario creado correctamente");
			}
		} catch (UsuarioExistente e) {
			logger.error(e.toString());
		} finally {

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
		switch (opcion) {
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
