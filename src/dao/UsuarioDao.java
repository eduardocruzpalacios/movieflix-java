/*
 * Fecha: 17/03/2021 y 18/03/2021
 * 
 * @author Miguel, Raúl y Edu
 * 
 * @version 1.0
 */

package dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import excepciones.ListadoVacioException;
import excepciones.UsuarioExistenteException;
import gui.Menu;
import model.Usuario;
import utilidades.Escritor;
import utilidades.Lector;

public class UsuarioDao {

	private static Logger logger;

	static {
		try {
			logger = LogManager.getLogger(UsuarioDao.class);
		} catch (Throwable e) {
			System.out.println("Logger Don't work");
		}
	}

	private Map<String, Usuario> usuarioDao = new HashMap<String, Usuario>();

	public void listarUsuarios() {
		try {
			if (usuarioDao.size() == 0) {
				Escritor.str("El listado está vacío");
				throw new excepciones.ListadoVacioException();
			}
			String key;
			Iterator<String> iterator = usuarioDao.keySet().iterator();
			System.out.println("Listado de Usuarios");
			while (iterator.hasNext()) {
				key = iterator.next();
				System.out.println("[" + key + "]:" + usuarioDao.get(key));
			}
		} catch (ListadoVacioException e) {
			logger.error(e.toString());
		}
	}

	public void addUsuarios() {
		try {
			Usuario usuario = Usuario.crearUsuario();
			if (usuarioDao.containsKey(usuario.getNombre())) {
				Escritor.str("Ese usuario ya existía");
				throw new excepciones.UsuarioExistenteException();
			} else {
				usuarioDao.put(usuario.getNombre(), usuario);
				Escritor.str("Usuario creado correctamente");
			}
		} catch (UsuarioExistenteException e) {
			logger.error(e.toString());
		}
	}

	public void eliminarUsuarios() {
		String nombreUsuario = Lector.str("dime el nombre de usuario a borrar");
		usuarioDao.remove(nombreUsuario);
	}

	public void modificarUsuarios() {
		String nombreUsuario = Lector.str("Dame el nombre del usuario");
		Menu.modificarUsuario();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch (opcion) {
		case 1:
			usuarioDao.get(nombreUsuario).setNombre(Lector.str("¿Cual es el nuevo nombre?"));
			break;
		case 2:
			usuarioDao.get(nombreUsuario).setCiudadResidencia(Lector.str("¿Cual es la nueva ciudad?"));
			break;

		case 3:
			int year = Lector.pedirInt("dame nuevo año de nacimiento");
			int mes = Lector.pedirInt("dame nuevo mes de nacimiento");
			int dia = Lector.pedirInt("dame nuevo día de nacimiento");
			usuarioDao.get(nombreUsuario).setFechaNacimiento(LocalDate.of(year, mes, dia));
			break;
		}
		Escritor.str("Este usuario ha sido modificado");
	}

}
