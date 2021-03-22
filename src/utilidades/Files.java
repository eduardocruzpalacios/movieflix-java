/*
 * 
 * Fecha: 22/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 * 
 * Clase Files
 * 
 * Clase para transformar un fichero de texto a ArrayList
 * Cada línea de fichero sería una posición de ArrayList
 */
package utilidades;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Files {

	public static ArrayList<String> exportarAList(File a) {

		ArrayList<String> lineas = new ArrayList<String>();
		// int numeroLineas = calcularNumeroLineas(a);
		try {
			BufferedReader lector = new BufferedReader(new FileReader(a));
			String linea;

			while ((linea = lector.readLine()) != null) {
				lineas.add(linea);
			}
			lector.close();
		} catch (IOException e) {
			System.out.println("Error al leer los datos");
		}
		return lineas;
	}
}
