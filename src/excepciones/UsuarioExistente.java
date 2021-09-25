/**
 * Fecha: 17/03/2021
 * 
 * @author Edu
 * 
 * @version 1.0
 * 
 *          Clase UsuarioExistente
 * 
 *          Clase que recoge excepción de duplicidad de usuario
 * 
 */

package excepciones;

public class UsuarioExistente extends Exception {

	private static final long serialVersionUID = 1L;

	public UsuarioExistente() {
		super();
	}

	public UsuarioExistente(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "UsuarioExistente []";
	}

}
