package tienda.gui;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tienda.funcionalidad.GestionTienda;
import tienda.funcionalidad.excepciones.InvalidNameException;
import tienda.funcionalidad.excepciones.InvalidPriceException;
import tienda.funcionalidad.excepciones.ProductExistsException;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

public class AddProduct extends JDialogFather{

	private static final long serialVersionUID = 1L;

	public AddProduct() {
		super();
		setModal(true);
		setResizable(false);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValues();
				addProducto();
				clear();
				setIdCount();
				Main.fillTable();
			}
		});
		setTitle("Añadir producto");
		setIdCount();
	}

	private void setIdCount() {
		textFieldID.setText(String.valueOf(GestionTienda.getIdProducts()));
	}

	private void addProducto() throws HeadlessException {
		try {			
			GestionTienda.addProduct(textFieldNombre.getText(), Double.valueOf(textFieldSerodys.getText()), Double.valueOf(textFieldRamirez.getText()), Double.valueOf(textFieldEntrada.getText()), Double.valueOf(textFieldMercasur.getText()));
		} catch (HeadlessException | InvalidNameException ex) {
			JOptionPane.showMessageDialog(contentPanel, ex.getMessage(), "Error al añadir producto", JOptionPane.ERROR_MESSAGE);
		}catch (ProductExistsException ex) {
			JOptionPane.showMessageDialog(contentPanel, "Ya existe ese producto","Error al añadir producto" , JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			
		} catch (InvalidPriceException e) {
			JOptionPane.showMessageDialog(contentPanel, "No puedes introducir un número negativo","Error al añadir producto" , JOptionPane.ERROR_MESSAGE);
		}
	}

	private void checkValues() {
		if(textFieldSerodys.getText().equals(""))
			textFieldSerodys.setText("0");
		if(textFieldRamirez.getText().equals(""))
			textFieldRamirez.setText("0");
		if(textFieldEntrada.getText().equals(""))
			textFieldEntrada.setText("0");
		if(textFieldMercasur.getText().equals(""))
			textFieldMercasur.setText("0");
	}
	
}
