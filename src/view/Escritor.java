/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package view;

import java.util.List;

import model.Pelicula;

public class Escritor {

	public static void string(String string) {
		System.out.println(string);
	}

	public static void peliculas(List<Pelicula> peliculas) {
		peliculas.forEach(pelicula -> System.out.println(pelicula));
	}

}
