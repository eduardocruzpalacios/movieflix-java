/*
 * Fecha: 22/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 */

package utilidades;

import java.util.ArrayList;

import model.Pelicula;

public class Colecciones {

	public static ArrayList<Pelicula> leerArrayStringDevolverArrayPelicula(ArrayList<String> arrayString) {

		String linea;
		String[] partes = new String[5];
		ArrayList<Pelicula> arrayPelicula = new ArrayList<Pelicula>();

		for (int i = 0; i < arrayString.size(); i++) {
			Pelicula pelicula = new Pelicula();
			linea = arrayString.get(i);
			partes = linea.split(",");
			pelicula.setTitulo(partes[0]);
			pelicula.setAnyoEstreno(Short.parseShort(partes[1]));
			pelicula.setCategoria(Short.parseShort(partes[2]));
			pelicula.setVisualizaciones(Long.parseLong(partes[3]));
			pelicula.setValoracion(Float.parseFloat(partes[4]));
			arrayPelicula.add(pelicula);
		}

		return arrayPelicula;
	}

}
