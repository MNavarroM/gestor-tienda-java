package tienda.funcionalidad.excepciones;

public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidNameException(String mensaje) {
		super(mensaje);
	}
}
