/*
 * Fecha: 16/03/2021
 * 
 * @author Andrei y María
 * 
 * @version 1.0
 */

package services;

import dao.UsuarioDao;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDao usuarioDao = new UsuarioDao();

	@Override
	public void findAll() {
		this.usuarioDao.listarUsuarios();
	}

	@Override
	public void add() {
		this.usuarioDao.addUsuarios();
	}

	@Override
	public void delete() {
		this.usuarioDao.eliminarUsuarios();
	}

	@Override
	public void update() {
		this.usuarioDao.modificarUsuarios();
	}

}
