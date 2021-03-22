package utilidades;

import java.util.ArrayList;
import java.util.List;
import model.Pelicula;

public class List {

	public static List<Pelicula> leerListCadenasDevolverListObjetos (List<String> listado) {
		
		// guardar cada String del List
		String cadena;
		// guardar cada partición de cada String
		String[] partes;
		
		// objeto al que hacer setter con particiones
		Pelicula p = new Pelicula();
		
		// List donde guardar instancias y que devuelve la función
		List<Pelicula> bbdd = new ArrayList<Pelicula>();
		
		for(int i=0; i<listado.size() ; i++) {
			
			cadena = listado.get(i);
			partes = cadena.split(",");
			
			p.setTitulo(partes[0]);
			p.setAnyo(Short.parseShort(partes[1]));
			p.setCategoria(Short.parseShort(partes[2]));
			
			bbdd.add(p);
		}
		
		return bbdd;
	}
}
