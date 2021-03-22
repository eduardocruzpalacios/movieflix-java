/**
 * 
 * Fecha: 17/03/2021
 * 
 * @author Raúl y Miguel
 * 
 * @version 1.0
 * 
 * Clase Usuario
 * Clase con atributos y métodos principales de la clase Usuario.
 * 
 * Además de los atributos especificados hemos añadido dos más(email y password) los cuales están comentados por
 * si en el futuro hubiera que descartarlos
 * 
 * */

package model;

import java.time.LocalDate;

import utilidades.Escritor;
import utilidades.Lector;

public class Usuario {

	private String nombre;
	private LocalDate fechaNacimiento;
	private int year = -1, mes = -1, dia = -1;
	private String ciudadResidencia;
	/*
	 * private String email; private String password;
	 */

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
		this.generarFechaNac();
	}

	/*
	 * public Usuario(String nombre, Date fechaNacimiento, String ciudadResidencia,
	 * String email, String password) { super(); this.nombre = nombre;
	 * this.fechaNacimiento = fechaNacimiento; this.ciudadResidencia =
	 * ciudadResidencia; this.email = email; this.password = password; }
	 */

	// arreglar crearYRellenarUsuario()

	public static Usuario crearYRellenarUsuario() {

		Usuario u = new Usuario();

		Escritor.str("vamos a crear un nuevo usuario, voy a pedirte sus datos");
		u.setNombre(Lector.str("dame nombre"));
		u.setCiudadResidencia(Lector.str("dame ciudad de residencia"));
		u.setYear(Lector.pedirInt("dame año de nacimiento")); // hay que controlar lo que mete el usuario
		u.setMes(Lector.pedirInt("dame mes de nacimiento")); // hay que controlar lo que mete el usuario
		u.setDia(Lector.pedirInt("dame día de nacimiento")); // hay que controlar lo que mete el usuario
		u.generarFechaNac();

		return u;
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

	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void generarFechaNac() {
		this.fechaNacimiento = LocalDate.of(this.year, this.mes, this.dia);
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", year=" + year + ", mes=" + mes
				+ ", dia=" + dia + ", ciudadResidencia=" + ciudadResidencia + "]";
	}

}
