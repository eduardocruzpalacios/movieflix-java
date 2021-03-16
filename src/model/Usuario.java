/**
 * 
 * @author Raúl y Miguel
 * 
 * @version 1.0.1
 * 
 * */


/**
 * Además de los atributos especificados hemos añadido dos más(email y password) los cuales están comentados por
 * si en el futuro hubiera que descartarlos
 */


package model;

import java.time.LocalDate;

public class Usuario {

	private String nombre;
	private LocalDate fechaNacimiento;
	private int year = -1, mes = -1, dia = -1;
	private String ciudadResidencia;
	/*private String email;
	private String password;*/

	public Usuario() {
		super();
	}

	

	public Usuario(String nombre, int year, int mes, int dia, String ciudadResidencia) {
		super();
		this.nombre = nombre;
		this.year = year;
		this.mes = mes;
		this.dia = dia;
		this.ciudadResidencia = ciudadResidencia;
		this.fechaNacimiento = LocalDate.of(year, mes, dia);
	}



	/*public Usuario(String nombre, Date fechaNacimiento, String ciudadResidencia, String email, String password) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudadResidencia = ciudadResidencia;
		this.email = email;
		this.password = password;
	}*/

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

	/*public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", ciudadResidencia="
				+ ciudadResidencia + "]";
	}
	
	
	
	

}
