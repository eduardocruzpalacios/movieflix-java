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
import java.util.Map;

import model.Usuario;

public class UsuarioDao {

	private Map<String, Usuario> usuarios = new HashMap<String, Usuario>();

	public Map<String, Usuario> getAll() {
		if (usuarios.size() == 0) {
			Usuario usuarioDePrueba = new Usuario("Paco", LocalDate.now(), "Avila");
			usuarios.put(usuarioDePrueba.getNombre(), usuarioDePrueba);
		}
		return usuarios;
	}

}
