/*
 * Fecha: 17/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 */

package exceptions;

public class ListadoVacioException extends Exception {

	private static final long serialVersionUID = 1L;

	public ListadoVacioException() {
		super();
	}

	public ListadoVacioException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "ListadoVacioException []";
	}

}
