/* 
 * Fecha: 17/03/2021
 * 
 * @author Raúl y Miguel
 * 
 * @version 1.0
 */

package model;

import java.time.LocalDate;

import utilidades.Escritor;
import utilidades.Lector;

public class Usuario {

	private String nombre;
	private LocalDate fechaNacimiento;
	private String ciudadResidencia;

	public Usuario() {
	}

	public Usuario(String nombre, String ciudadResidencia) {
		this.nombre = nombre;
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", ciudadResidencia="
				+ ciudadResidencia + "]";
	}

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
