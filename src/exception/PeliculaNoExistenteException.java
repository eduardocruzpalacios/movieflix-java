/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package exception;

public class PeliculaNoExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public PeliculaNoExistenteException() {
		super();
	}

	public PeliculaNoExistenteException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "PeliculaNoExistenteException []";
	}

}
