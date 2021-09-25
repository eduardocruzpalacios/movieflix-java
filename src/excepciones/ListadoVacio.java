/*
 * 
 * Fecha: 17/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 * 
 *          Clase ListadoVacío
 * 
 * 			No está actualmente en uso
 * 
 */

package excepciones;

public class ListadoVacio extends Exception {

	private static final long serialVersionUID = 1L;

	public ListadoVacio() {
		super();
	}

	public ListadoVacio(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "ListadoVacio []";
	}

}
