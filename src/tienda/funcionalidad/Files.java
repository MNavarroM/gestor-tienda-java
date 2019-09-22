package tienda.funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase para la lectura y escritura de archivos
 * @author Mario
 *
 */
public class Files {
		
	public static void write(ArrayList<Product> product) throws IOException {
		try(ObjectOutputStream salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(GestionTienda.file)))) {
			salida.writeObject(product);
			salida.writeInt(GestionTienda.getIdProducts());
		} 
	}
	
	@SuppressWarnings("unchecked")
	public static void read() throws ClassNotFoundException, IOException {
		try(ObjectInputStream entrada= new ObjectInputStream(new BufferedInputStream(new FileInputStream(GestionTienda.file)))) {			
			GestionTienda.setProducts((ArrayList<Product>) entrada.readObject());
			GestionTienda.setIdProducts(entrada.readInt());
		}
	}

}
