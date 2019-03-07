import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Employees extends JFrame {

	private JPanel contentPane;
	private JTextField txt_LastName;
	private JTextField txt_FirstName;
	static String[] type = {"Hello","World"};
	static String[] type1 = {"Hello","World"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees frame = new Employees();
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
	public Employees() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		type = ConnectDB.getEmployeeDepartment();
		type1 = ConnectDB.getEmployeeDesignation();
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(12, 13, 380, 352);
		contentPane.add(panel);
		
		JLabel lblEmployee = new JLabel("Add An Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblEmployee.setBounds(71, 13, 254, 30);
		panel.add(lblEmployee);
		
		JLabel lblFirstName = new JLabel("Last Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFirstName.setBounds(73, 162, 111, 19);
		panel.add(lblFirstName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(73, 215, 111, 19);
		panel.add(lblGender);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDesignation.setBounds(73, 268, 148, 33);
		panel.add(lblDesignation);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDepartment.setBounds(73, 333, 122, 19);
		panel.add(lblDepartment);
		
		JLabel label = new JLabel("First Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(73, 91, 136, 40);
		panel.add(label);
		
		JButton button = new JButton("INSERT");
		button.setBounds(83, 411, 121, 55);
		contentPane.add(button);
		
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton button_1 = new JButton("Back");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		button_1.setBounds(441, 408, 121, 55);
		contentPane.add(button_1);
		
		txt_FirstName = new JTextField();
		txt_FirstName.setBounds(466, 95, 96, 31);
		contentPane.add(txt_FirstName);
		txt_FirstName.setColumns(10);
		
		txt_LastName = new JTextField();
		txt_LastName.setBounds(466, 150, 96, 30);
		contentPane.add(txt_LastName);
		txt_LastName.setColumns(10);
		
		JComboBox combo_Gender = new JComboBox();
		combo_Gender.setBounds(466, 204, 96, 30);
		contentPane.add(combo_Gender);
		combo_Gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		JComboBox combo_Designation = new JComboBox();
		combo_Designation.setBounds(466, 271, 96, 33);
		contentPane.add(combo_Designation);
		combo_Designation.setModel(new DefaultComboBoxModel<>(type1));
		
		JComboBox combo_Department = new JComboBox();
		combo_Department.setBounds(466, 332, 96, 33);
		contentPane.add(combo_Department);
		combo_Department.setModel(new DefaultComboBoxModel<>(type));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Main_Frame m = new Main_Frame();
			setVisible(false);
			m.setVisible(true);
			}
		});
	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String fname = txt_FirstName.getText();
				String lname = txt_LastName.getText();
				String gender = combo_Gender.getSelectedItem().toString();
				String desg = combo_Designation.getSelectedItem().toString();
				String dept = combo_Department.getSelectedItem().toString();
				int num = ConnectDB.Insert_Employee(fname,lname, gender,desg,dept);
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
	}
}
