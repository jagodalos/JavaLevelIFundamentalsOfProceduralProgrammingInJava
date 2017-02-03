import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private JTable tableCostume;
	private JTextField textFieldCustomerName;
	private JTextField textFieldPrice;
	private JTextField textFieldCostume;

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
		frame.setBounds(100, 100, 942, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tableCostume = new JTable();
		tableCostume.setBounds(43, 28, 405, 198);
		frame.getContentPane().add(tableCostume);
		
		JButton btnAddCustomerName = new JButton("New button");
		btnAddCustomerName.setBounds(649, 267, 245, 96);
		frame.getContentPane().add(btnAddCustomerName);
		
		textFieldCustomerName = new JTextField();
		textFieldCustomerName.setBounds(387, 296, 236, 39);
		frame.getContentPane().add(textFieldCustomerName);
		textFieldCustomerName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(474, 104, 236, 39);
		frame.getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JButton btnAddPrice = new JButton("New button");
		btnAddPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddPrice.setBounds(723, 105, 171, 41);
		frame.getContentPane().add(btnAddPrice);
		
		textFieldCostume = new JTextField();
		textFieldCostume.setBounds(474, 40, 236, 39);
		frame.getContentPane().add(textFieldCostume);
		textFieldCostume.setColumns(10);
		
		JButton btnAddCostume = new JButton("New button");
		btnAddCostume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddCostume.setBounds(723, 39, 171, 41);
		frame.getContentPane().add(btnAddCostume);
	}
}
