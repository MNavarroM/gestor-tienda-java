package tienda.funcionalidad;

import java.io.Serializable;

import tienda.funcionalidad.excepciones.InvalidNameException;
import tienda.funcionalidad.excepciones.InvalidPriceException;

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double priceSerodys;
	private double priceRamirez;
	private double priceEntrada;
	private double priceMercasur;
	@SuppressWarnings("unused")
	private double priceAux = 0;
	
	
	public Product(int id,String name, double priceSerodys, double priceRamirez, double priceEntrada, double priceMercasur) throws InvalidPriceException, InvalidNameException {		
		setName(name);
		setPriceSerodys(priceSerodys);
		setPriceRamirez(priceRamirez);
		setPriceEntrada(priceEntrada);
		setPriceMercasur(priceMercasur);
		setId(id);
	}

	public Product(int id,String nombre) throws InvalidNameException {		
		setName(nombre);
		setId(id);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	protected void setPriceSerodys(Double priceSerodys) throws InvalidPriceException {
		if(priceSerodys<0)
			throw new InvalidPriceException("Debes introducir un precio superior a 0");
		this.priceSerodys=priceSerodys;
	}
	
	public double getPriceSerodys() {
		return priceSerodys;
	}
	
	protected void setPriceRamirez(Double priceRamirez) throws InvalidPriceException {
		if(priceRamirez<0)
			throw new InvalidPriceException("Debes introducir un precio superior a 0");
		this.priceRamirez=priceRamirez;
	}
	
	public double getPriceRamirez() {
		return priceRamirez;
	}
	
	protected void setPriceEntrada(Double priceEntrada) throws InvalidPriceException {
		if(priceEntrada<0)
			throw new InvalidPriceException("Debes introducir un precio superior a 0");
		this.priceEntrada=priceEntrada;
	}
	
	public double getPriceEntrada() {
		return priceEntrada;
	}
	
	protected void setPriceMercasur(Double priceMercasur) throws InvalidPriceException {
		if(priceMercasur<0)
			throw new InvalidPriceException("Debes introducir un precio superior a 0");
		this.priceMercasur=priceMercasur;
	}

	public double getPriceMercasur() {
		return priceMercasur;
	}
	
	protected void setName(String nombre) throws InvalidNameException {
		if(nombre.equals("") || nombre==null)
			throw new InvalidNameException("Debes introducir un nombre para el producto");
		this.name=nombre;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrecio() {
		return priceSerodys;
	}
	
	@Override
	public String toString() {	
		return getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Product other = (Product) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}	
	
}
