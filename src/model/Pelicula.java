/*
 * Fecha: 22/03/2021
 * 
 * @Author Andrei
 * 
 * @version 1.0
 */

package model;

import utilidades.Escritor;
import utilidades.Lector;

public class Pelicula {

	private String titulo;
	private Short anyoEstreno;
	private Short categoria;
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

	public Short getAnyoEstreno() {
		return anyoEstreno;
	}

	public void setAnyoEstreno(Short anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}

	public Short getCategoria() {
		return categoria;
	}

	public void setCategoria(Short categoria) {
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

	public static Pelicula crear() {
		Pelicula pelicula = new Pelicula();
		Escritor.str("vamos a añadir una nueva pelicula, voy a pedirte los dao");
		pelicula.setTitulo(Lector.str("dime el titulo"));
		pelicula.setAnyoEstreno((short) Lector.pedirInt("dime el año de estreno"));
		pelicula.setCategoria((short) Lector.pedirInt("dime que categoria es"));
		pelicula.setVisualizaciones(0);
		pelicula.setValoracion(-1);
		return pelicula;
	}

}
