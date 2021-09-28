package factory;

import model.Pelicula;
import model.Usuario;

public interface AbstractFactory {

	public static Usuario crearUsuarioFactory() {
		return UsuarioFactory.crearUsuario();
	}

	public static Pelicula crearPeliculaFactory() {
		return PeliculaFactory.crearPelicula();
	}

}
