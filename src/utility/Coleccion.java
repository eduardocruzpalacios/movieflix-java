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

	public static ArrayList<Pelicula> arrayStringToArrayPelicula(ArrayList<String> arrayString) {

		String linea;
		String[] partes = new String[5];
		ArrayList<Pelicula> arrayPelicula = new ArrayList<Pelicula>();

		for (int i = 0; i < arrayString.size(); i++) {
			linea = arrayString.get(i);
			partes = linea.split(",");
			String titulo = partes[0];
			short anyoEstreno = Short.parseShort(partes[1]);
			short categoria = Short.parseShort(partes[2]);
			long visualizaciones = Long.parseLong(partes[3]);
			float valoracion = Float.parseFloat(partes[4]);
			Pelicula pelicula = new Pelicula(titulo, anyoEstreno, categoria, visualizaciones, valoracion);
			arrayPelicula.add(pelicula);
		}

		return arrayPelicula;
	}

	public static List<String> listPeliculaToListString(List<Pelicula> listPelicula) {
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
