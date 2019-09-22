package tienda.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import tienda.funcionalidad.MyCustomRender;
import tienda.gui.Help;
import tienda.funcionalidad.Files;
import tienda.funcionalidad.GestionTienda;
import tienda.funcionalidad.IconUtils;
import tienda.funcionalidad.ProductTableModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	protected JFrame frame;
	protected ProductTableModel model = new ProductTableModel();
	protected static JTable table;
	private JTextField textFieldSearch;
	private JButton btnDeleteProduct;
	private JButton btnAddProduct;
	private JLabel lblSearch;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		loadFile();

		frame = new JFrame();
		frame.setTitle("Autoservicio Ana y Antonio");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("ico.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				saveExit();
			}
		});

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setMnemonic('P');
		menuBar.add(mnProductos);

		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir producto");
		mntmAadirProducto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addProducto();
			}
		});
		mnProductos.add(mntmAadirProducto);
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showHelp();
			}
		});
		mnAyuda.add(mntmAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame,
						"Aplicación de desarrollada por Mario Navarro" + "\n Version: 1.0 - 2018", "Acerca de",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		ProductTableModel model = new ProductTableModel();
		table = new JTable(model);
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);

		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Arial", Font.PLAIN, 18));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(frame.getBackground());
		DefaultTableCellRenderer pricesRender = new DefaultTableCellRenderer();
		pricesRender.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer productsRender = new DefaultTableCellRenderer();
		productsRender.setBackground(Color.getHSBColor(101, 43, 59));
		productsRender.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(String.class, productsRender);
		table.setDefaultRenderer(Double.class, pricesRender);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setBounds(35, 52, 365, 189);
		frame.getContentPane().add(scrollPane);
		JPanel panelButtons = new JPanel();
		frame.getContentPane().add(panelButtons, BorderLayout.NORTH);
		panelButtons.setLayout(new BorderLayout(0, 0));
		JPanel panelTable = new JPanel();
		panelButtons.add(panelTable, BorderLayout.CENTER);
		btnAddProduct = new JButton("A\u00F1adir Producto");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct dialogo = new AddProduct();
				dialogo.setVisible(true);
			}
		});
		btnAddProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAddProduct.setBackground(new Color(204, 230, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAddProduct.setBackground(Color.WHITE);

			}
		});
		btnAddProduct.setBackground(Color.WHITE);
		panelTable.add(btnAddProduct);
		btnDeleteProduct = new JButton("Eliminar Producto");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteProduct();
			}
		});
		btnDeleteProduct.setBackground(Color.WHITE);
		btnDeleteProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnDeleteProduct.setBackground(new Color(204, 230, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDeleteProduct.setBackground(Color.WHITE);
			}
		});
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new MyCustomRender());
		}
		panelTable.add(btnDeleteProduct);
		lblSearch = new JLabel("Buscar: ");
		panelTable.add(lblSearch);
		setIcons();
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				sortTable(sorter);
			}
		});
		panelTable.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void setIcons() {
		try {
			btnAddProduct.setIcon(IconUtils.createIcon("icons\\add-to-cart.png"));
			btnDeleteProduct.setIcon(IconUtils.createIcon("icons\\rubbish-bin.png"));
		} catch (IOException e) {
		}
	}

	protected static void fillTable() {
		table.setModel(new ProductTableModel());
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new MyCustomRender());
		}
	}

	private void addProducto() {
		AddProduct dialogo = new AddProduct();
		dialogo.setVisible(true);
	}

	private void loadFile() {
		try {
			if (new File("config/data.obj").exists())
				Files.read();
			else
				Files.write(GestionTienda.getProducts());
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "Error al cargar los datos", "Error: clase inesperada",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al cargar los datos", "Error: IO Exception",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void saveExit() {
		try {
			Files.write(GestionTienda.getProducts());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error al guardar los datos al salir", "Error: IO Exception",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			System.exit(0);
		}
	}

	private void showHelp() {
		Help.getAyuda().setVisible(true);
	}

	private void sortTable(TableRowSorter<TableModel> sorter) {
		String text = textFieldSearch.getText();
		if (text.length() == 0)
			sorter.setRowFilter(null);
		else
			sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	}

	private void deleteProduct() throws HeadlessException {
		try {
			if(JOptionPane.showConfirmDialog(frame, "¿Desea eliminar el producto \"" + table.getValueAt(table.getSelectedRow(), 1) + "\"?",
					"Eliminar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
				GestionTienda.deleteProducto((int) table.getValueAt(table.getSelectedRow(), 0));
				Main.fillTable();
			}
		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(frame, "Debes seleccionar un producto", "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
