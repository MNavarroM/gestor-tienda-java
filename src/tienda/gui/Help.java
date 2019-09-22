package tienda.gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class Help extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static Help help;

	private Help() {
		setTitle("Ayuda");
		setResizable(false);
		setBounds(100, 100, 694, 236);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 688, 380);
		contentPanel.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		editorPane.setContentType("text/html"); 
		editorPane.setText(
				"<head><b>Ayuda</b></head></br>" + 
				"<p>Este programa permite la gestión de productos de una tienda.</p>" + 
				"<ul>"
				+ "<li>Productoss: Permite añadir productos</li><ul>"
					+ "<li>Añadir producto: Permite añadir un producto a la tienda, con sus respectivos precios de los almacenes</li>" 
				+ "</ul>"				
				+ "<li>Ayuda</li><ul>"
					+ "<li>Ver ayuda: Muestra la ayuda del programa</li>"
					+ "<li>Acerca de: Muestra información del programa</li>"
				+ "</ul>"
				+ "</ul>"									
				);		
	}
	

	public static Help getAyuda(){
		if(help==null)
			help = new Help();
		return help;
	}
}