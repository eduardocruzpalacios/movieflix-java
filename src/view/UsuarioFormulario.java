package view;

import java.time.LocalDate;

import model.Usuario;

public class UsuarioFormulario {

	public static Usuario crear() {
		Usuario usuario = new Usuario();
		MostrarDato.string("vamos a crear un nuevo usuario, voy a pedirte sus datos");
		usuario.setNombre(Lector.str("dame nombre"));
		int year = Lector.pedirInt("dame año de nacimiento");
		int mes = Lector.pedirInt("dame mes de nacimiento");
		int dia = Lector.pedirInt("dame día de nacimiento");
		usuario.setFechaNacimiento(LocalDate.of(year, mes, dia));
		usuario.setCiudadResidencia(Lector.str("dame ciudad de residencia"));
		return usuario;
	}

}
