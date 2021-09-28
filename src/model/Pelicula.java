/*
 * Fecha: 22/03/2021
 * 
 * @Author Andrei
 * 
 * @version 1.0
 */

package model;

public class Pelicula {

	private String titulo;
	private Short anyoEstreno;
	private Short categoria;

	public Pelicula() {
	}

	public Pelicula(String titulo, short anyoEstreno, short categoria) {
		this.titulo = titulo;
		this.anyoEstreno = anyoEstreno;
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public short getAnyoEstreno() {
		return anyoEstreno;
	}

	public void setAnyoEstreno(short anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public short getCategoria() {
		return categoria;
	}

	public void setCategoria(short categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", anyoEstreno=" + anyoEstreno + ", categoria=" + categoria + "]";
	}

}
