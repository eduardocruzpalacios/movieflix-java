/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fichero {

	public static ArrayList<String> leerFicheroDevolverArrayString(String filePath) {
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
			Log.error(e);
		}
		return arrayString;
	}

	public static void LeerListStringGuardarEnFichero(List<String> listString, String filePath) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			for (int i = 0; i < listString.size(); i++) {
				writer.write(listString.get(i));
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			Log.error(e);
		}
	}

}
