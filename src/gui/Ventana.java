/*
 * 
 * Fecha: 16/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 * 
 *          Clase Menu
 * 
 *          Clase que establece las ventanas gráficas de la aplicación
 * 
 * 
 */
package gui;

import utilidades.Escritor;

public class Ventana {

	public static void presentacion() {
		Escritor.str("");
		Escritor.str("***************************************************");
		Escritor.str("*                                                 *");
		Escritor.str("*                    movieFlix                    *");
		Escritor.str("*                                                 *");
		Escritor.str("***************************************************");
	}
	
	public static void salir() {
		Escritor.str("");
		Escritor.str("**************************************************");
		Escritor.str("*                                                *");
		Escritor.str("*          ¡HASTA LUEGO, VUELVE PRONTO!          *");
		Escritor.str("*                                                *");
		Escritor.str("**************************************************");
	}
}
