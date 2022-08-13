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

	static Scanner scanner = new Scanner(System.in, "ISO-8859-1");

	@SuppressWarnings("resource")
	public static String string(String msg) {
		MostrarDato.string(msg);
		return new Scanner(System.in).nextLine();
	}

	public static int entero() {
		while (scanner.hasNextInt() == false) {
			MostrarDato.string("debes introducir un entero, vuelve a intentarlo");
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static int entero(String msg) {
		MostrarDato.string(msg);
		while (scanner.hasNextInt() == false) {
			MostrarDato.string(msg);
			scanner.next();
		}
		return scanner.nextInt();
	}

	public static int enteroEntre(int a, int b) {
		boolean salir = false;
		int x = 0;
		while (!salir) {
			MostrarDato.string("Dame un entero entre " + a + " y " + b);
			x = DatoFormulario.entero();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static int enteroEntre(int a, int b, String msg) {
		boolean salir = false;
		int x = 0;
		while (!salir) {
			MostrarDato.string(msg);
			x = DatoFormulario.entero();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static short shortEntre(int a, int b, String msg) {
		boolean salir = false;
		short x = 0;
		while (!salir) {
			MostrarDato.string(msg);
			x = (short) DatoFormulario.entero();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static boolean booleanPreguntando(String pregunta, String respuestaCorrecta) {
		String respuestaUsuario = DatoFormulario.string(pregunta);
		return respuestaUsuario.equals(respuestaCorrecta) ? true : false;
	}

}
