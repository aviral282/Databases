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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_Employees extends JFrame {

	private JPanel contentPane;
	private JTextField txt_fname;
	private JTextField txt_lname;
	private JTextField txt_desg;
	private JTextField txt_dept;
	private JTextField txt_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Employees frame = new Update_Employees();
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
	public Update_Employees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(136, 134, 111, 30);
		contentPane.add(label);
		
		txt_fname = new JTextField();
		txt_fname.setColumns(10);
		txt_fname.setBounds(472, 135, 96, 29);
		contentPane.add(txt_fname);
		txt_fname.setText(Report_Employees.fname);
		
		txt_lname = new JTextField();
		txt_lname.setColumns(10);
		txt_lname.setBounds(472, 198, 96, 29);
		contentPane.add(txt_lname);
		txt_lname.setText(Report_Employees.lname);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(136, 197, 111, 30);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("Designation");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(136, 249, 122, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Department");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(136, 306, 122, 30);
		contentPane.add(label_4);
		
		txt_desg = new JTextField();
		txt_desg.setColumns(10);
		txt_desg.setBounds(472, 250, 96, 29);
		contentPane.add(txt_desg);
		txt_desg.setText(Report_Employees.desg);
		
		txt_dept = new JTextField();
		txt_dept.setColumns(10);
		txt_dept.setBounds(472, 307, 96, 29);
		contentPane.add(txt_dept);
		txt_dept.setText(Report_Employees.dept);
		
		txt_ID = new JTextField();
		txt_ID.setEditable(false);
		txt_ID.setColumns(10);
		txt_ID.setText(Report_Employees.id);
		txt_ID.setBounds(472, 73, 96, 21);
		contentPane.add(txt_ID);
		
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(136, 73, 111, 19);
		contentPane.add(lblId);
		
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = txt_fname.getText();
				String lname = txt_lname.getText();
				String desg = txt_desg.getText();
				String dept = txt_dept.getText();
				int id = Integer.parseInt(txt_ID.getText());
				int num = ConnectDB.Update_Employee(fname,lname,desg,dept, id);
				if(num==1)
				{
					DialogMessage.showInfoDialog("UPDATED");
					setVisible(false);
				}
				else if(num==0)
				{
					DialogMessage.showWarningDialog("Error");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnUpdate.setBounds(249, 386, 180, 51);
		contentPane.add(btnUpdate);
		
		
	}
	
	
}
