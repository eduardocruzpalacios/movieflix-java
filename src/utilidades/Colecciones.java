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

	public static ArrayList<Pelicula> leerListCadenasDevolverListObjetos(ArrayList<String> listado) {

		String cadena;
		String[] partes = new String[3];

		ArrayList<Pelicula> bbdd = new ArrayList<Pelicula>();

		for (int i = 0; i < listado.size(); i++) {
			Pelicula p = new Pelicula();
			cadena = listado.get(i);
			partes = cadena.split(",");

			p.setTitulo(partes[0]);
			p.setAnyoEstreno(Short.parseShort(partes[1]));
			p.setCategoria(Short.parseShort(partes[2]));

			bbdd.add(p);
		}
		return bbdd;
	}

}
