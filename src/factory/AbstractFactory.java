package factory;

import model.Usuario;

public interface AbstractFactory {

	public static Usuario crearUsuarioFactory() {
		return UsuarioFactory.crearUsuario();
	}

}
