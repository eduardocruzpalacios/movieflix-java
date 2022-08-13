/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package exception;

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
