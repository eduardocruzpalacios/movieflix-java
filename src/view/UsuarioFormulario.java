package view;

import java.time.LocalDate;

import model.Usuario;

public class UsuarioFormulario {

	public static Usuario crear() {
		Usuario usuario = new Usuario();
		MostrarDato.string("vamos a crear un nuevo usuario, voy a pedirte sus datos");
		usuario.setNombre(DatoFormulario.string("dame nombre"));
		int year = DatoFormulario.entero("dame a�o de nacimiento");
		int mes = DatoFormulario.entero("dame mes de nacimiento");
		int dia = DatoFormulario.entero("dame d�a de nacimiento");
		usuario.setFechaNacimiento(LocalDate.of(year, mes, dia));
		usuario.setCiudadResidencia(DatoFormulario.string("dame ciudad de residencia"));
		return usuario;
	}

}