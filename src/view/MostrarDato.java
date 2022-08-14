/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package view;

import java.util.List;
import java.util.Map;

import model.Pelicula;
import model.Usuario;

public class MostrarDato {

	public static void string(String string) {
		System.out.println(string);
	}

	public static void peliculas(List<Pelicula> peliculas) {
		peliculas.forEach(pelicula -> System.out.println(pelicula));
	}

	public static void usuarios(Map<String, Usuario> usuarios) {
		for (Usuario usuario : usuarios.values()) {
			System.out.println(usuario);
		}
	}

}
