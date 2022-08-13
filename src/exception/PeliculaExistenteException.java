/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package exception;

public class PeliculaExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public PeliculaExistenteException() {
		super();
	}

	public PeliculaExistenteException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "PeliculaExistenteException []";
	}

}
