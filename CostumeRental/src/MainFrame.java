import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.ISUB;

import dao.CustomerDao;
import model.Costume;
import model.Customer;
import model.Rent;
import net.proteanit.sql.DbUtils;
import util.CostumeRentalUtil;
import util.MySQLAccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;

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
		frame.setBounds(100, 100, 942, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tableCostume = new JTable();
		tableCostume.setBounds(43, 28, 405, 198);
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
		textFieldPrice.setBounds(461, 106, 236, 39);
		frame.getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);

		JButton btnAddPrice = new JButton("Add price");
		btnAddPrice.setBackground(SystemColor.textHighlight);
		btnAddPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddPrice.setBounds(723, 105, 171, 41);
		frame.getContentPane().add(btnAddPrice);

		textFieldCostume = new JTextField();
		textFieldCostume.setBounds(461, 40, 236, 39);
		frame.getContentPane().add(textFieldCostume);
		textFieldCostume.setColumns(10);

		JButton btnAddCostume = new JButton("Add costume");
		btnAddCostume.setBackground(new Color(135, 206, 250));
		btnAddCostume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAddCostume.setBounds(707, 39, 187, 41);
		frame.getContentPane().add(btnAddCostume);

		CustomerDao customerDao = new CustomerDao();
		comboBoxCustomer = new JComboBox<String>();
		comboBoxCustomer.setForeground(Color.BLACK);
		comboBoxCustomer.setBackground(SystemColor.text);
		comboBoxCustomer.setBounds(117, 267, 222, 39);
		frame.getContentPane().add(comboBoxCustomer);

		tableHistoryOfRents = new JTable();
		tableHistoryOfRents.setBounds(43, 336, 841, 143);
		frame.getContentPane().add(tableHistoryOfRents);

		fillTableHistoryOfRents((Customer) comboBoxCustomer.getSelectedItem());

		fillComboBoxCustomer();

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
			preparedStatement = connection.prepareStatement("select  rent.id, rent.data, costume.id, costume.name, costume.price "
					+ "from rent "
					+ "left join customer on rent.customer_id = customer.id "
					+ "left join costume on rent.costume_id = costume.id;"
//					+ "where customer_id = ?;"
					);
//			preparedStatement.setInt(1, 1);
			rs = preparedStatement.executeQuery();
			
			tableCostume.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLAccess.close(connection, rs, preparedStatement);
		}
	}

}
