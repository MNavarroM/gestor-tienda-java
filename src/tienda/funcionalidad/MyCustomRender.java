package tienda.funcionalidad;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyCustomRender extends DefaultTableCellRenderer{

	private static final long serialVersionUID = 1L;
	
	@Override
	public Component getTableCellRendererComponent(JTable jtable, Object object, boolean hasSelected, boolean hasFocus, int row,
			int column) {
		super.getTableCellRendererComponent(jtable, object, hasSelected, hasFocus, row, column);
		this.setHorizontalAlignment(JLabel.CENTER);
		jtable.getTableHeader().setBackground(new Color(191, 191, 191));
					
		if(row % 2==0) {
			this.setBackground(Color.WHITE);
		}else {
			this.setBackground(new Color(204, 230, 255));
		}
		return this;
			
			
		
	}

}
