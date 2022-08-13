/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ListadoVacioException;
import exception.UsuarioExistenteException;
import model.Usuario;
import view.Lector;
import view.Menu;
import view.MostrarDato;
import view.UsuarioFormulario;

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
				MostrarDato.string("El listado está vacío");
				throw new exception.ListadoVacioException();
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

	public void addUsuario() {
		try {
			Usuario usuario = UsuarioFormulario.crear();
			if (usuarioDao.containsKey(usuario.getNombre())) {
				MostrarDato.string("Ese usuario ya existía");
				throw new exception.UsuarioExistenteException();
			} else {
				usuarioDao.put(usuario.getNombre(), usuario);
				MostrarDato.string("Usuario creado correctamente");
			}
		} catch (UsuarioExistenteException e) {
			logger.error(e.toString());
		}
	}

	public void eliminarUsuario() {
		String nombreUsuario = Lector.str("dime el nombre de usuario a borrar");
		usuarioDao.remove(nombreUsuario);
	}

	public void modificarUsuario() {
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
		MostrarDato.string("Este usuario ha sido modificado");
	}

}
