import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.CostumeDao;
import dao.CustomerDao;
import dao.RentDao;
import model.Costume;
import model.Customer;
import model.Rent;
import util.CostumeRentalUtil;

public class MainFrame {

	private JFrame frmCostumeRental;
	private JTable tableCostume;
	private JTextField textFieldCostume;
	private JComboBox comboBoxCustomer;
	private JTable tableHistoryOfRents;
	private JTextField textFieldPrice;
	private JTextField textFieldCustomerName;
	private JScrollPane scrollPane;
	
	private final String[] tableCostumeColumnNames = { "Id", "Name", "Price" };
	private final String[] rentColumnNames = { "Id", "Date and time", "Name", "Price" };
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmCostumeRental.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
		setUpStartData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCostumeRental = new JFrame();
		frmCostumeRental.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jagod\\Desktop\\bat3.png"));
		frmCostumeRental.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmCostumeRental.setForeground(new Color(0, 0, 0));
		frmCostumeRental.setFont(new Font("Calibri", Font.PLAIN, 12));
		frmCostumeRental.setTitle(" COSTUMES RENTAL ");
		frmCostumeRental.getContentPane().setBackground(SystemColor.menu);
		frmCostumeRental.setBackground(new Color(0, 0, 0));
		frmCostumeRental.setBounds(100, 100, 1769, 1016);
		frmCostumeRental.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCostumeRental.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 61, 825, 403);

		frmCostumeRental.getContentPane().add(scrollPane);

		tableCostume = new JTable();
		scrollPane.setViewportView(tableCostume);
		scrollPane.setColumnHeader(new JViewport() {
			@Override
			public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 40;
				return d;
			}
		});
		tableCostume.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		tableCostume.setFont(new Font("Calibri", Font.PLAIN, 40));
		tableCostume.setRowHeight(50);
		tableCostume.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 32));
		tableCostume.setRowSelectionAllowed(true);

		JButton btnAddCustomerName = new JButton("ADD CUSTOMER");
		btnAddCustomerName.setFont(new Font("Calibri", Font.BOLD, 31));
		btnAddCustomerName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});
		btnAddCustomerName.setBackground(new Color(135, 206, 235));
		btnAddCustomerName.setForeground(new Color(0, 0, 0));
		btnAddCustomerName.setBounds(960, 530, 275, 58);
		frmCostumeRental.getContentPane().add(btnAddCustomerName);

		textFieldCostume = new JTextField();
		textFieldCostume.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textFieldCostume.setBounds(971, 61, 420, 75);
		frmCostumeRental.getContentPane().add(textFieldCostume);
		textFieldCostume.setColumns(10);

		JButton btnAddCostume = new JButton("ADD COSTUME");
		btnAddCostume.setFont(new Font("Calibri", Font.BOLD, 32));
		btnAddCostume.setForeground(new Color(0, 0, 0));
		btnAddCostume.setBackground(new Color(135, 206, 235));
		btnAddCostume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCostume();
			}
		});
		btnAddCostume.setBounds(1439, 105, 282, 82);
		frmCostumeRental.getContentPane().add(btnAddCostume);

		CustomerDao customerDao = new CustomerDao();
		comboBoxCustomer = new JComboBox();
		comboBoxCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeCustomer();
			}
		});
		comboBoxCustomer.setToolTipText("");
		comboBoxCustomer.setFont(new Font("Calibri", Font.PLAIN, 30));
		comboBoxCustomer.setForeground(new Color(0, 0, 0));
		comboBoxCustomer.setBackground(new Color(255, 255, 255));
		comboBoxCustomer.setBounds(67, 519, 353, 68);
		frmCostumeRental.getContentPane().add(comboBoxCustomer);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 731, 1669, 169);
		frmCostumeRental.getContentPane().add(scrollPane_1);

		tableHistoryOfRents = new JTable();
		scrollPane_1.setViewportView(tableHistoryOfRents);
		scrollPane_1.setColumnHeader(new JViewport() {
			@Override
			public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 40;
				return d;
			}
		});
		tableHistoryOfRents.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		tableHistoryOfRents.setFont(new Font("Calibri", Font.PLAIN, 40));
		tableHistoryOfRents.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableHistoryOfRents.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 32));
		tableHistoryOfRents.setRowHeight(50);
		tableHistoryOfRents.setEnabled(false);

		JButton btnRent = new JButton("RENT");
		btnRent.setFont(new Font("Calibri", Font.BOLD, 34));
		btnRent.setBackground(new Color(135, 206, 235));
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rent();
			}
		});
		btnRent.setBounds(1474, 505, 212, 107);
		frmCostumeRental.getContentPane().add(btnRent);

		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(971, 164, 420, 75);
		frmCostumeRental.getContentPane().add(textFieldPrice);

		textFieldCustomerName = new JTextField();
		textFieldCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 40));
		textFieldCustomerName.setColumns(10);
		textFieldCustomerName.setBounds(471, 519, 420, 75);
		frmCostumeRental.getContentPane().add(textFieldCustomerName);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jagod\\Desktop\\bat2.png"));
		lblNewLabel.setBounds(90, 14, 448, 169);
		frmCostumeRental.getContentPane().add(lblNewLabel);
	}

	public void setUpStartData() {
		refreshCostumeTable();
		refreshComboBoxCustomer();
		refreshRentTable();
	}

	public void refreshComboBoxCustomer() {
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customers = customerDao.getAllCustomers();
		comboBoxCustomer.removeAllItems();
		for (int i = 0; i < customers.size(); i++) {
			comboBoxCustomer.addItem(customers.get(i));
		}
	}

	public void refreshCostumeTable() {
		CostumeDao costumeDao = new CostumeDao();
		List<Costume> costumes = costumeDao.getAllAvaiableCostume();
		DefaultTableModel model = new DefaultTableModel(tableCostumeColumnNames, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		for (int i = 0; i < costumes.size(); i++) {
			model.addRow(
					new Object[] { costumes.get(i).getId(), costumes.get(i).getName(), costumes.get(i).getPrice() });

		}
		tableCostume.setModel(model);
		tableCostume.getColumnModel().getColumn(0).setMinWidth(0);
		tableCostume.getColumnModel().getColumn(0).setMaxWidth(0);
	}

	public void refreshRentTable() {

		RentDao rentDao = new RentDao();
		Customer curentCustomer = (Customer) comboBoxCustomer.getSelectedItem();
		DefaultTableModel model = new DefaultTableModel(rentColumnNames, 0);
		
		if(curentCustomer != null) {
			List<Rent> rents = rentDao.getAllRentsByCustomer(curentCustomer.getId());
			for (int i = 0; i < rents.size(); i++) {
				model.addRow(new Object[] { rents.get(i).getId(), rents.get(i).getDateTime(),
						rents.get(i).getCostume().getName(), rents.get(i).getCostume().getPrice() });

			}
			
		}
		tableHistoryOfRents.setModel(model);
		tableHistoryOfRents.getColumnModel().getColumn(0).setMinWidth(0);
		tableHistoryOfRents.getColumnModel().getColumn(0).setMaxWidth(0);
	}

	public void addCustomer() {
		String customerName = textFieldCustomerName.getText();

		if (!CostumeRentalUtil.isBlankOrNull(customerName)) {
			Customer customer = new Customer();
			customer.setName(customerName);
			CustomerDao customerDao = new CustomerDao();
			customerDao.addCustomer(customer);
			textFieldCustomerName.setText("");
			refreshComboBoxCustomer();
		}
	}

	public void addCostume() {
		String costumeName = textFieldCostume.getText();
		String priceValue = textFieldPrice.getText();
		if (!CostumeRentalUtil.isBlankOrNull(costumeName) && !CostumeRentalUtil.isBlankOrNull(priceValue)) {
			Costume costume = new Costume();
			costume.setName(costumeName);
			costume.setPrice(Integer.valueOf(priceValue));
			costume.setAvailable(true);
			CostumeDao costumeDao = new CostumeDao();
			costumeDao.addCostume(costume);
			textFieldCostume.setText("");
			textFieldPrice.setText("");
			refreshCostumeTable();
		}
	}

	public void rent() {
		int[] selectedRows = tableCostume.getSelectedRows();
		RentDao rentDao;
		CostumeDao costumeDao;
		Customer currentCustommer = (Customer) comboBoxCustomer.getSelectedItem();
		for (int i = 0; i < selectedRows.length; i++) {
			rentDao = new RentDao();
			costumeDao = new CostumeDao();
			rentDao.rentCostume(currentCustommer.getId(), (int) tableCostume.getModel().getValueAt(selectedRows[i], 0));
			costumeDao.setCostumeAvailable(selectedRows[i], false);
		}

		refreshCostumeTable();
		refreshRentTable();
	}

	public void changeCustomer() {
		refreshRentTable();
	}

}
