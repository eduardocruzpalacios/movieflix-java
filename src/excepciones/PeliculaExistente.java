package excepciones;

public class PeliculaExistente extends Exception {

	private static final long serialVersionUID = 1L;

	public PeliculaExistente() {
		super();
	}

	public PeliculaExistente(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "PeliculaExistente []";
	}
}
