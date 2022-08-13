/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package utility;

import java.util.ArrayList;
import java.util.List;

import model.Pelicula;

public class Coleccion {

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

	public static List<String> leerListPeliculaDevolverListString(List<Pelicula> listPelicula) {
		List<String> listString = new ArrayList<String>();
		for (int i = 0; i < listPelicula.size(); i++) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(listPelicula.get(i).getTitulo()).append(",");
			stringBuilder.append(listPelicula.get(i).getAnyoEstreno()).append(",");
			stringBuilder.append(listPelicula.get(i).getCategoria()).append(",");
			stringBuilder.append(listPelicula.get(i).getVisualizaciones()).append(",");
			stringBuilder.append(listPelicula.get(i).getValoracion());
			listString.add(stringBuilder.toString());
		}
		return listString;
	}

}
