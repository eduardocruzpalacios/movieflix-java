/*
 * Fecha: 29/10/2021
 *
 * @author Edu
 *
 * @version: 2.0
 */

package exceptions;

public class UsuarioExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioExistenteException() {
		super();
	}

	public UsuarioExistenteException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "UsuarioExistenteException []";
	}

}
