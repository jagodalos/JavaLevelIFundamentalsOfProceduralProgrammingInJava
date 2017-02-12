import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.CostumeDao;
import dao.CustomerDao;
import model.Costume;
import model.Customer;
import net.proteanit.sql.DbUtils;
import util.CostumeRentalUtil;
import util.MySQLAccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Array;
import javax.swing.ListSelectionModel;

public class MainFrame {

	private JFrame frame;
	private JTable tableCostume;
	private JTextField textFieldCustomerName;
	private JTextField textFieldPrice;
	private JTextField textFieldCostume;
	private JComboBox<String> comboBoxCustomer;
	private JTable tableHistoryOfRents;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 245, 245));
		frame.setBackground(SystemColor.info);
		frame.setBounds(100, 100, 1769, 1016);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tableCostume = new JTable();
		tableCostume.setBounds(43, 35, 825, 191);
		tableCostume.setCellSelectionEnabled(false);

		frame.getContentPane().add(tableCostume);

		JButton btnAddCustomerName = new JButton("Add customer");
		btnAddCustomerName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnAddCustomerName.setBackground(SystemColor.textHighlight);
		btnAddCustomerName.setForeground(Color.BLACK);
		btnAddCustomerName.setBounds(686, 266, 208, 41);
		frame.getContentPane().add(btnAddCustomerName);

		textFieldCustomerName = new JTextField();
		textFieldCustomerName.setBounds(424, 267, 236, 39);
		frame.getContentPane().add(textFieldCustomerName);
		textFieldCustomerName.setColumns(10);

		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(914, 130, 420, 96);
		frame.getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);

		textFieldCostume = new JTextField();
		textFieldCostume.setBounds(914, 35, 420, 75);
		frame.getContentPane().add(textFieldCostume);
		textFieldCostume.setColumns(10);

		JButton btnAddCostume = new JButton("Add costume");
		btnAddCostume.setBackground(new Color(135, 206, 250));
		btnAddCostume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String costumeName = textFieldCostume.getText();
				String priceValue = textFieldPrice.getText();
				if (!CostumeRentalUtil.isBlankOrNull(costumeName) && !CostumeRentalUtil.isBlankOrNull(priceValue)) {
					Costume costume = new Costume();
					costume.setName(costumeName);
					costume.setPrice(Integer.valueOf(priceValue));
					costume.setAvailable("T");
					CostumeDao costumeDao = new CostumeDao();
					costumeDao.addCostume(costume);
					textFieldCostume.setText("");
					textFieldPrice.setText("");
					refreshCostumeTable();
				}

			}
		});
		btnAddCostume.setBounds(1399, 28, 282, 82);
		frame.getContentPane().add(btnAddCostume);

		CustomerDao customerDao = new CustomerDao();
		comboBoxCustomer = new JComboBox<String>();
		comboBoxCustomer.setForeground(Color.BLACK);
		comboBoxCustomer.setBackground(SystemColor.text);
		comboBoxCustomer.setBounds(117, 267, 222, 39);
		frame.getContentPane().add(comboBoxCustomer);

		tableHistoryOfRents = new JTable();
		tableHistoryOfRents.setFont(new Font("Tahoma", Font.PLAIN, 50));
		tableHistoryOfRents.setBounds(43, 336, 1668, 564);
		tableHistoryOfRents.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableHistoryOfRents.setRowHeight(80);
		frame.getContentPane().add(tableHistoryOfRents);
		
		JButton btnRent = new JButton("Rent");
		btnRent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int [] selectedRows = tableCostume.getSelectedRows();
				List<Costume> costumeList = new ArrayList<Costume>();
				for(int i = 0; i < selectedRows.length; i++){
					Costume costume = new Costume();
					costume.setName((String) tableCostume.getValueAt(i, 2));
					costume.setPrice((int) tableCostume.getValueAt(i, 3));
					costume.setAvailable((String) tableCostume.getValueAt(i, 4));
					costumeList.add(costume);
				}
				System.out.println(costumeList);
				
			}
		});
		btnRent.setBounds(1506, 266, 171, 41);
		frame.getContentPane().add(btnRent);

		// fillTableHistoryOfRents((Customer)
		// comboBoxCustomer.getSelectedItem());

		fillComboBoxCustomer();
		fillCostumeTable();

	}

	public void fillComboBoxCustomer() {
		CustomerDao customerDao = new CustomerDao();
		for (String customerName : customerDao.getAllCustomersNames()) {
			comboBoxCustomer.addItem(customerName);
		}
	}

	public void refreshComboBoxCustomer() {
		CustomerDao customerDao = new CustomerDao();
		comboBoxCustomer.removeAllItems();
		for (String customerName : customerDao.getAllCustomersNames()) {
			comboBoxCustomer.addItem(customerName);
		}
	}

	public void fillTableHistoryOfRents(Customer customer) {
		Connection connection = MySQLAccess.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection
					.prepareStatement("select  rent.id, rent.data, costume.id, costume.name, costume.price "
							+ "from rent " + "left join customer on rent.customer_id = customer.id "
							+ "left join costume on rent.costume_id = costume.id;"
			// + "where customer_id = ?;"
			);
			// preparedStatement.setInt(1, 1);
			rs = preparedStatement.executeQuery();

			tableHistoryOfRents.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, rs, preparedStatement);
		}
	}
	
	public void fillCostumeTable(){
		CostumeDao costumeDao = new CostumeDao();
		
		tableCostume.setModel(DbUtils.resultSetToTableModel(costumeDao.getAllCostume()));
	}

	public void refreshCostumeTable(){
		CostumeDao costumeDao = new CostumeDao();
		tableCostume.removeAll();
		tableCostume.setModel(DbUtils.resultSetToTableModel(costumeDao.getAllCostume()));
	}
}
