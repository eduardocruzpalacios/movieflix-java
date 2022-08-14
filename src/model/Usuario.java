/*
 * Fecha: 17/03/2021
 *
 * @author Raúl y Miguel
 *
 * @version 1.0
 */

package model;

import java.time.LocalDate;

public class Usuario {

	private String nombre;
	private LocalDate fechaNacimiento;
	private String ciudadResidencia;

	public Usuario() {
	}

	public Usuario(String nombre, LocalDate fechaNacimiento, String ciudadResidencia) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
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

}
