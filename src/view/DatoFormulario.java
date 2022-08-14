/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package view;

import java.util.Scanner;

public class DatoFormulario {

	private static Scanner scanner;

	public static String string(String mensajeAlUsuario) {
		MostrarDato.string(mensajeAlUsuario);
		scanner = new Scanner(System.in, "ISO-8859-1");
		String string = scanner.nextLine();
		return string;
	}

	public static int entero(String mensajeAlUsuario) {
		scanner = new Scanner(System.in, "ISO-8859-1");
		MostrarDato.string(mensajeAlUsuario);
		while (scanner.hasNextInt() == false) {
			MostrarDato.string(mensajeAlUsuario);
			scanner.next();
		}
		int entero = scanner.nextInt();
		return enter;
	}

	public static int enteroEntre(int numero1, int numero2, String mensajeAlUsuario) {
		boolean salir = false;
		if (numero1 == numero2) {
			return numero1;
		}
		if (numero1 > numero2) {
			int auxiliar = numero1;
			numero1 = numero2;
			numero2 = auxiliar;
		}
		int entero = 0;
		while (!salir) {
			entero = DatoFormulario.entero(mensajeAlUsuario);
			if (entero >= numero1 && entero <= numero2) {
				salir = true;
			}
		}
		return entero;
	}

	public static short shortEntre(int numero1, int numero2, String mensajeAlUsuario) {
		int entero = enteroEntre(numero1, numero2, mensajeAlUsuario);
		short corto = (short) entero;
		return corto;
	}

	public static boolean booleanPreguntando(String pregunta, String respuestaCorrecta) {
		String respuestaUsuario = DatoFormulario.string(pregunta);
		return respuestaUsuario.equals(respuestaCorrecta) ? true : false;
	}

	public static void cerrarScanner() {
		scanner.close();
	}

}
