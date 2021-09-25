/*
 * 
 * Fecha: 22/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 * 
 * Clase Colecciones
 * 
 * Clase para transformar un ArrayList de String en un ArrayList de objeto Pelicula
 * Cada String es partido en 3 partes (Regex , ), se instancia Pelicula y se la pasa setters con valores de partes String
 * Se mete instancia en ArrayList Pelicula
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
