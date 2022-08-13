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
	public static String string(String msg) {
		MostrarDato.string(msg);
		return new Scanner(System.in).nextLine();
	}

	public static int entero() {
		while (sn.hasNextInt() == false) {
			MostrarDato.string("debes introducir un entero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextInt();
	}

	public static int entero(String msg) {
		MostrarDato.string(msg);
		while (sn.hasNextInt() == false) {
			MostrarDato.string(msg);
			sn.next();
		}
		return sn.nextInt();
	}

	public static double doble() {
		while (sn.hasNextDouble() == false) {
			MostrarDato.string("debes introducir un n�mero, vuelve a intentarlo");
			sn.next();
		}
		return sn.nextDouble();
	}

	public static double flotante(String msg) {
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
			x = DatoFormulario.entero();
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
			x = DatoFormulario.entero();
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
			System.out.println("Dame un n�mero entre " + a + " y " + b);
			x = DatoFormulario.doble();
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
			x = (short) DatoFormulario.entero();
			if (x >= a && x <= b) {
				salir = true;
			}
		}
		return x;
	}

	public static boolean preguntarSiNo(String pregunta, String respuestaSi, String respuestaNo) {
		String respuesta = DatoFormulario.string(pregunta);
		return respuesta.equals(respuestaSi) ? true : false;
	}

}
