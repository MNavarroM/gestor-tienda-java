package tienda.funcionalidad;

import java.io.File;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import tienda.funcionalidad.excepciones.InvalidNameException;
import tienda.funcionalidad.excepciones.InvalidPriceException;
import tienda.funcionalidad.excepciones.ProductExistsException;
import tienda.gui.Main;

public class GestionTienda {

	private static ArrayList<Product> products = new ArrayList<Product>();
	public static final File file = new File("config/data.obj");
	public static ObjectInputStream input = (ObjectInputStream) Main.class.getClass().getResourceAsStream("data.obj");

	private static int idProducts = 1;
		
	public static void increaseIdProducts(){
		idProducts++;	
	}
	
	public static void setIdProducts(int idProducts) {
		GestionTienda.idProducts = idProducts;
	}
	
	public static int getIdProducts() {
		return idProducts;
	}
	
	public static void setProducts(ArrayList<Product> products){
		GestionTienda.products=products;
	}
	
	public static void addProduct(String name, double priceSerodys, double priceRamirez, double priceEntrada, double priceMercasur) throws ProductExistsException, InvalidNameException, InvalidPriceException{
		if(products.contains(new Product(0, name)))
			throw new ProductExistsException();
		products.add(new Product(idProducts,name, priceSerodys, priceRamirez, priceEntrada,priceMercasur));
		increaseIdProducts();
	}
	
	public static void deleteProducto(int id) {
		try {
			products.remove(new Product(id, "asd"));
		} catch (InvalidNameException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Product> getProducts() {
		return products;
	}


		
}
