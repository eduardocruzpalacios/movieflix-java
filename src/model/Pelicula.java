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
	private short anyoEstreno;
	private short categoria;
	private long visualizaciones;
	private float valoracion;

	public Pelicula() {
	}

	public Pelicula(String titulo, short anyoEstreno, short categoria, long visualizaciones, float valoracion) {
		this.titulo = titulo;
		this.anyoEstreno = anyoEstreno;
		this.categoria = categoria;
		this.visualizaciones = visualizaciones;
		this.valoracion = valoracion;
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

	public long getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(long visualizaciones) {
		this.visualizaciones = visualizaciones;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", anyoEstreno=" + anyoEstreno + ", categoria=" + categoria
				+ ", visualizaciones=" + visualizaciones + ", valoracion=" + valoracion + "]";
	}

}
