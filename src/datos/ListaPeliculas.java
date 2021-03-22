	/*
	*
	*
	*@Author Raúl y María
	*
	*/


package datos;

import java.util.ArrayList;
import java.util.Iterator;
import model.Pelicula;
import utilidades.Escritor;
import utilidades.Lector;

import java.util.List;

public class ListaPeliculas {
	
	
	private List<Pelicula> ListaPeliculas = new ArrayList<Pelicula>();
	
	//constructores
	public ListaPeliculas() {
		
	}
	
	
	public ListaPeliculas(List<Pelicula> listaPeliculas) {
		super();
		ListaPeliculas = listaPeliculas;
	}

	//getteres y setters
	public List<Pelicula> getListaPeliculas(){
		return ListaPeliculas;
	}
	
	public void setListaPeliculas (List<Pelicula> ListaPeliculas) {
		this.ListaPeliculas=ListaPeliculas;
	}
	
	
	//Metodos
	
	public void listaPeliculas () {
		System.out.println("Listado de Peliculas");
		for (int i=0;i<ListaPeliculas.size();i++) {
			System.out.println(ListaPeliculas.get(i));	
		}

	}
	
	public void addPeliculas () {
		Pelicula p = Pelicula.crearYRellenarPelicula();
		ListaPeliculas.add(p.getTitulo(), p);
		Escritor.str("Película creada correctamente");
	}
	
	public void eliminarPeliculas() {
		String p = Lector.str("Dime el título de la película a borrar");
		for (int i=0;i<ListaPeliculas.size();i++) {
			if (p.equals(ListaPeliculas(i).getTitulo())) {
				ListaPeliculas.remove(p);
			}
			
		}
		
	}
	
	public void modificarPeliculas() {
		String p = Lector.str("Dime el título de la película a modificar");
		Menu.modificarPelicula();
		int opcion = Lector.pedirIntEntre(1, 3);
		switch (opcion) {
		case 1:
			ListaPeliculas.get(titulo).setTitulo(Lector.str("¿Cual es el nuevo título?"));
			break;
		case 2:
			ListaPeliculas.get(anyoEstreno).setanyoEstreno(Lector.str("¿Cual es el nuevo año de estreno?"));
			break;

		case 3:
			ListaPeliculas.get(categoria).setCategoria(Lector.pedirInt("Digame la nueva categoría"));

			break;
		}
		Escritor.str("Esta película ha sido modificada");
	}
}
