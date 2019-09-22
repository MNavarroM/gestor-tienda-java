package tienda.funcionalidad.excepciones;

public class InvalidPriceException extends Exception {

	private static final long serialVersionUID = 1L;
	public InvalidPriceException(String mensaje) {
		super(mensaje);
	}
	public InvalidPriceException() {
		super();
	}
}
