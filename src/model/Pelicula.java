 //@Author Andrei

 package model;

public class Pelicula {


	private String titulo;
	private LocalDate anyoEstreno;
	private int year = -1;
	private String categoria;
	
	


	public Pelicula(String titulo, int year, String categoria) {
		
		this.titulo = titulo;
		this.year = year;
		this.categoria = categoria;
		
	}
public static PeliculacrearYRellenarPelicula() {
		
		Pelicula P = new Pelicula();
		
		Escritor.str("vamos a añadir una nueva pelicula, voy a pedirte los datos");
		p.setTitulo(Lector.str("dime el titulo"));
		p.setanyoEstreno(Lector.str("dime el año de estreno"));
		p.setCategoria(Lector.pedirInt("dime que categoria es")); 
		
		
		return p;
}



public String getTitulo() {
	return titulo;
}



public void setTitulo(String titulo) {
	this.titulo = titulo;
}



public LocalDate getAnyoEstreno() {
	return anyoEstreno;
}



public void setAnyoEstreno(LocalDate anyoEstreno) {
	this.anyoEstreno = anyoEstreno;
}



public int getYear() {
	return year;
}



public void setYear(int year) {
	this.year = year;
}



public String getCategoria() {
	return categoria;
}



public void setCategoria(String categoria) {
	this.categoria = categoria;
}


@Override
public String toString() {
	return "peliculas [titulo=" + titulo + ", year=" + year + ", categoria=" + categoria + "]";
}
}