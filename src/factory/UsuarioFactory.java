package factory;

import model.Usuario;

public class UsuarioFactory implements AbstractFactory<UsuarioProduct> {

	@Override
	public UsuarioProduct create(String type) {
		switch (type) {
		case "usuario":
			return new Usuario().crear();
		default:
			return null;
		}
	}

}
