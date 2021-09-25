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

	private UsuarioDao usuarios = new UsuarioDao();

	@Override
	public void findAll() {
		this.usuarios.listarUsuarios();
	}

	@Override
	public void add() {
		this.usuarios.addUsuarios();
	}

	@Override
	public void delete() {
		this.usuarios.eliminarUsuarios();
	}

	@Override
	public void update() {
		this.usuarios.modificarUsuarios();
	}

}
