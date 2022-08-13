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

	static Scanner sn = new Scanner(System.in, "ISO-8859-1");

	@SuppressWarnings("resource")
	public static String str(String msg) {
		MostrarDato.string(msg);
		return new Scanner(System.in).nextLine();
	}

	public static int pedirInt() {
		while (sn.hasNextInt() == false) {
			MostrarDato.string("debes introducir un entero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextInt();
	}

	public static double pedirDouble() {
		while (sn.hasNextDouble() == false) {
			MostrarDato.string("debes introducir un número, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextDouble();
	}

	public static int pedirInt(String msg) {
		MostrarDato.string(msg);
		while (sn.hasNextInt() == false) {
			MostrarDato.string(msg);
			sn.next();
		}
		return sn.nextInt();
	}

	public static double pedirDouble(String msg) {
		MostrarDato.string(msg);
		while (sn.hasNextDouble() == false) {
			MostrarDato.string(msg);
			sn.next();
		}
		return sn.nextDouble();
	}

	public static int pedirIntEntre(int a, int b) {
		boolean salir = false;
		int x = 0;
		while (!salir) {
			System.out.println("Dame un entero entre " + a + " y " + b);
			x = DatoFormulario.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static int pedirIntEntre(int a, int b, String msg) {
		boolean salir = false;
		int x = 0;
		while (!salir) {
			MostrarDato.string(msg);
			x = DatoFormulario.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static double pedirDoubleEntre(int a, int b) {
		boolean salir = false;
		double x = 0;
		while (!salir) {
			System.out.println("Dame un número entre " + a + " y " + b);
			x = DatoFormulario.pedirDouble();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static short pedirShortEntre(int a, int b, String msg) {
		boolean salir = false;
		short x = 0;
		while (!salir) {
			MostrarDato.string(msg);
			x = (short) DatoFormulario.pedirInt();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static boolean preguntarSiNo(String pregunta, String respuestaSi, String respuestaNo) {
		String respuesta = DatoFormulario.str(pregunta);
		return respuesta.equals(respuestaSi) ? true : false;
	}

}
