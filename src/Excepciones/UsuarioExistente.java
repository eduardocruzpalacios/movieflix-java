package Excepciones;

public class UsuarioExistente extends Exception {
	private static final long serialVersionUID = 1L;
	
	// constructor
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
