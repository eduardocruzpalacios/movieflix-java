/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package service;

import java.util.Map;

import dao.UsuarioDao;
import model.Usuario;
import view.MostrarDato;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDao usuarioDao = new UsuarioDao();

	@Override
	public void findAll() {
		Map<String, Usuario> usuarios = this.usuarioDao.getAll();
		MostrarDato.usuarios(usuarios);

	}

}
