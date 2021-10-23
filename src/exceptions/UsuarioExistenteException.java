/*
 * Fecha: 17/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
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
