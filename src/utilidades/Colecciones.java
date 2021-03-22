package utilidades;

import java.util.ArrayList;
import model.Pelicula;

public class Colecciones {

	public static ArrayList<Pelicula> leerListCadenasDevolverListObjetos (ArrayList<String> listado) {
		
		// guardar cada String del List
		String cadena;
		// guardar cada partición de cada String
		String[] partes;
		
		// objeto al que hacer setter con particiones
		Pelicula p = new Pelicula();
		
		// List donde guardar instancias y que devuelve la función
		ArrayList<Pelicula> bbdd = new ArrayList<Pelicula>();
		
		for(int i=0; i<listado.size() ; i++) {
			
			cadena = (String) listado.get(i);
			partes = cadena.split(",");
			
			p.setTitulo(partes[0]);
			p.setAnyoEstreno(Short.parseShort(partes[1]));
			p.setCategoria(Short.parseShort(partes[2]));
			
			bbdd.add(p);
		}
		
		return bbdd;
	}
}
