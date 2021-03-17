/*
 * @author Edu
 * 
 * @version 1.0
 */

package Excepciones;

public class ListadoVacio extends Exception {
	private static final long serialVersionUID = 1L;
	
	// constructor
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
