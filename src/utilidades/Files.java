/*
 * Fecha: 22/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 */

package utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Files {

	public static ArrayList<String> exportarAList(File a) {

		ArrayList<String> lineas = new ArrayList<String>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader(a));
			String linea;
			while ((linea = lector.readLine()) != null) {
				lineas.add(linea);
			}
			lector.close();
		} catch (IOException e) {
			System.out.println("Error al leer los dao");
		}
		return lineas;
	}

}
