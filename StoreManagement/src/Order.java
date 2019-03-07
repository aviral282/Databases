import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Order extends JFrame {

	private JPanel contentPane;
	private JTextField txt_quantity;
	static String[] type = {"Hello","World"};
	static String[] type1 = {"Hello","World"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Order() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustmoreName = new JLabel("Customer Name");
		lblCustmoreName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustmoreName.setBounds(100, 114, 189, 39);
		contentPane.add(lblCustmoreName);
		
		type = ConnectDB.getCustomerName();
		type1 = ConnectDB.getItemName();
		
		
		JComboBox combo_Name = new JComboBox();
		combo_Name.setBounds(425, 115, 127, 43);
		contentPane.add(combo_Name);
		combo_Name.setModel(new DefaultComboBoxModel<>(type));
		
		
		
		JLabel lblNewLabel = new JLabel("Item Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 202, 127, 30);
		contentPane.add(lblNewLabel);
		
		JComboBox combo_Item_Name = new JComboBox();
		combo_Item_Name.setBounds(425, 203, 127, 34);
		combo_Item_Name.setModel(new DefaultComboBoxModel<>(type1));
		contentPane.add(combo_Item_Name);
		
		JLabel lblNewLabel_1 = new JLabel("Item Quantity");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(100, 274, 158, 25);
		contentPane.add(lblNewLabel_1);
		
		txt_quantity = new JTextField();
		txt_quantity.setBounds(425, 270, 127, 29);
		contentPane.add(txt_quantity);
		txt_quantity.setColumns(10);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				int a = ConnectDB.getItemPrice(combo_Item_Name.getSelectedItem().toString());
				int q = Integer.parseInt(txt_quantity.getText().trim());
				int price = a*q;
				String name = combo_Name.getSelectedItem().toString().trim();
				String item_name = combo_Item_Name.getSelectedItem().toString().trim();
				int num = ConnectDB.Insert_order(name,item_name,q,price);
				DialogMessage.showInfoDialog("Order Placed Succesfully \nPrice: "+price);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(425, 368, 127, 62);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Customer_Main_Frame c = new Customer_Main_Frame();

			setVisible(false);
			c.setVisible(true);
			}
		});
		button.setBounds(100, 368, 116, 62);
		contentPane.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("Order");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(250, 37, 158, 39);
		contentPane.add(lblNewLabel_2);
	}
}
