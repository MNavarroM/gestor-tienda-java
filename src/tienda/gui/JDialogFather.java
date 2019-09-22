package tienda.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogFather extends JDialog {

	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textFieldNombre;
	protected JButton okButton;
	protected JButton cancelButton;
	protected JPanel buttonPane;
	protected JLabel lblNombre;
	protected JTextField textFieldID;
	protected JTextField textFieldSerodys;
	protected JTextField textFieldRamirez;
	protected JTextField textFieldEntrada;
	protected JTextField textFieldMercasur;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogFather dialog = new JDialogFather();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogFather() {
		setTitle("A\u00F1adir producto");
		setBounds(100, 100, 253, 243);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 46, 46, 14);
		contentPanel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(87, 43, 135, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(40, 21, 18, 14);
		contentPanel.add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(87, 18, 32, 20);
		contentPanel.add(textFieldID);
		textFieldID.setColumns(10);
		textFieldID.setEditable(false);
		
		JLabel lblPrecioSerodys = new JLabel("Precio Serodys");
		lblPrecioSerodys.setBounds(10, 71, 95, 14);
		contentPanel.add(lblPrecioSerodys);
		
		JLabel lblPrecioRamrez = new JLabel("Precio Ram\u00EDrez");
		lblPrecioRamrez.setBounds(10, 98, 95, 14);
		contentPanel.add(lblPrecioRamrez);
		
		JLabel lblPrecioEntrada = new JLabel("Precio Entrada");
		lblPrecioEntrada.setBounds(10, 123, 95, 14);
		contentPanel.add(lblPrecioEntrada);
		
		JLabel lblPrecioMercasur = new JLabel("Precio Mercasur");
		lblPrecioMercasur.setBounds(10, 148, 109, 14);
		contentPanel.add(lblPrecioMercasur);
		
		textFieldSerodys = new JTextField();
		textFieldSerodys.setBounds(157, 68, 59, 20);
		contentPanel.add(textFieldSerodys);
		textFieldSerodys.setColumns(10);
		
		textFieldRamirez = new JTextField();
		textFieldRamirez.setBounds(157, 95, 59, 20);
		contentPanel.add(textFieldRamirez);
		textFieldRamirez.setColumns(10);
		
		textFieldEntrada = new JTextField();
		textFieldEntrada.setBounds(157, 120, 59, 20);
		contentPanel.add(textFieldEntrada);
		textFieldEntrada.setColumns(10);
		
		textFieldMercasur = new JTextField();
		textFieldMercasur.setBounds(157, 145, 59, 20);
		contentPanel.add(textFieldMercasur);
		textFieldMercasur.setColumns(10);

		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("A\u00F1adir");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void clear() {
		textFieldNombre.setText("");
		textFieldSerodys.setText("");
		textFieldRamirez.setText("");
		textFieldEntrada.setText("");
		textFieldMercasur.setText("");
	}
}
