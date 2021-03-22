package utilidades;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Files {
	
	public static List<String> exportarAList(File a) {
		
		List<String> lineas = new ArrayList<String>();
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(a));

			String linea;
			
			while ((linea = lector.readLine()) != null) {
				lineas.add(linea);
			}
			lector.close();
		}

		catch (IOException e) {
			System.out.println("Error al leer los datos");
		}
		
		return lineas;
	}
}
