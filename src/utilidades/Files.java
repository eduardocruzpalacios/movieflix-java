package utilidades;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Files {
	
	public static ArrayList<String> exportarAList(File a) {
		
		ArrayList<String> lineas = new ArrayList<String>();
		int numeroLineas = calcularNumeroLineas(a);
		try {
			BufferedReader lector = new BufferedReader(new FileReader(a));
			String linea;
			
			for (int i=0 ; i<numeroLineas; i++) {
				
				linea = lector.readLine();
				lineas.add(linea);
			}
			lector.close();
			
		}

		catch (IOException e) {
			System.out.println("Error al leer los datos");
		}
		
		return lineas;
	}
	
	public static int calcularNumeroLineas (File a) {
		int numeroLineas=0;
		try {
			BufferedReader lector = new BufferedReader(new FileReader(a));
			@SuppressWarnings("unused")
			String linea;
			
			while ((linea = lector.readLine()) != null) {
				numeroLineas++;
			}
			lector.close();
		}
		catch (IOException e) {
			System.out.println("Error al leer los datos");
		}
		return numeroLineas;
	}
}
