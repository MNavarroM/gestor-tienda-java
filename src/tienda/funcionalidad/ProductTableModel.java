package tienda.funcionalidad;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import tienda.funcionalidad.excepciones.InvalidNameException;
import tienda.funcionalidad.excepciones.InvalidPriceException;

public class ProductTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String[] columns = { "ID", "Producto", "MercaSur", "Serodys", "Alsara", "Ramírez" };
	private final ArrayList<Product> rows = GestionTienda.getProducts();

	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public int getRowCount() {
		if (rows.isEmpty())
			return 0;
		return rows.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = (Product) rows.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return product.getId();
		case 1:
			return product.getName();
		case 2:
			return product.getPriceSerodys();
		case 3:
			return product.getPriceRamirez();
		case 4:
			return product.getPriceEntrada();
		case 5:
			return product.getPriceMercasur();
		}
		return null;
	}

	public boolean isCellEditable(int row, int col) {
		if(col == 0)
			return false;
		return true;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int col) {
		switch (col) {
		case 0: 
			return Integer.class;
		case 1: 
			return String.class;
		case 2: 
			return Double.class;
		case 3: 
			return Double.class;
		case 4:
			return Double.class;
		case 5:
			return Double.class;
		}
		return null;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col)  {
			try {
				Product product = (Product) rows.get(row);
				switch (col) {
				case 0:
					break;
				case 1:
					product.setName(value.toString());
					break;
				case 2:
					Double priceSerodys = (Double) value;
					product.setPriceSerodys(priceSerodys);
					break;
				case 3:
					Double priceRamirez = (Double) value;
					product.setPriceRamirez(priceRamirez);
					break;
				case 4:
					Double priceEntrada = (Double) value;
					product.setPriceEntrada(priceEntrada);
					break;
				case 5:
					Double priceMercasur = (Double) value;
					product.setPriceMercasur(priceMercasur);
					break;
				}
			} catch (InvalidNameException e) {
			} catch (InvalidPriceException e) {
			}

	}


}
