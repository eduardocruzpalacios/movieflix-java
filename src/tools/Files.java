/*
 * Fecha: 22/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 */

package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Files {

	public static ArrayList<String> leerRutaFicheroDevolverArrayString(String filePath) {

		File file = new File(filePath);
		ArrayList<String> arrayString = new ArrayList<String>();

		try {
			BufferedReader lector = new BufferedReader(new FileReader(file));
			String linea;
			while ((linea = lector.readLine()) != null) {
				arrayString.add(linea);
			}
			lector.close();
		} catch (IOException e) {
			System.out.println("Error al leer los dao");
		}

		return arrayString;
	}

	public static void LeerArrayStringGuardarEnFichero(ArrayList<String> arrayString, String filePath) {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			for (int i = 0; i < arrayString.size(); i++) {
				writer.write(arrayString.get(i));
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
