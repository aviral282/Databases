import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(506, 109, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(506, 158, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(506, 210, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(506, 259, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fname = textField.getText();
				String lname = textField_1.getText();
				String address = textField_2.getText();
			    int phone = Integer.parseInt(textField_3.getText());
				int num = ConnectDB.Insert_Customer(fname,lname, address,phone);
				if(num>0)
				{
				DialogMessage.showInfoDialog("Item Inserted Succesfully");
				}
				else
				{
					DialogMessage.showWarningDialog("Error in Inserting the Item");
				}
			}
		});
		btnNewButton.setBounds(98, 365, 117, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstname.setBounds(98, 113, 96, 32);
		contentPane.add(lblFirstname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(98, 162, 96, 25);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddress.setBounds(98, 201, 96, 37);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhoneNumber.setBounds(98, 251, 128, 25);
		contentPane.add(lblPhoneNumber);
		
		JButton button = new JButton("Back");
		button.setFont(new Font("Tahoma", Font.BOLD, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer_Main_Frame c = new Customer_Main_Frame();
				setVisible(false);
				c.setVisible(true);
			}
		});
		button.setBounds(501, 365, 101, 56);
		contentPane.add(button);
		
		JLabel lblAddNewCustomer = new JLabel("Add New Customer");
		lblAddNewCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddNewCustomer.setBounds(230, 50, 193, 25);
		contentPane.add(lblAddNewCustomer);
	}
}
