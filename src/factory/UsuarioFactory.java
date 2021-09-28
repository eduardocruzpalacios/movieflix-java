package factory;

import java.time.LocalDate;

import model.Usuario;
import utilidades.Escritor;
import utilidades.Lector;

public class UsuarioFactory {

	public static Usuario crearUsuario() {
		Usuario usuario = new Usuario();
		Escritor.str("vamos a crear un nuevo usuario, voy a pedirte sus datos");
		usuario.setNombre(Lector.str("dame nombre"));
		int year = Lector.pedirInt("dame año de nacimiento");
		int mes = Lector.pedirInt("dame mes de nacimiento");
		int dia = Lector.pedirInt("dame día de nacimiento");
		usuario.setFechaNacimiento(LocalDate.of(year, mes, dia));
		usuario.setCiudadResidencia(Lector.str("dame ciudad de residencia"));
		return usuario;
	}

}
