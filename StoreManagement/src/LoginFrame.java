import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txt_uname;
	private JPasswordField txt_pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_uname = new JTextField();
		txt_uname.setColumns(10);
		txt_uname.setBounds(395, 144, 197, 48);
		contentPane.add(txt_uname);
		
		JLabel label = new JLabel("USERNAME");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBackground(Color.RED);
		label.setBounds(96, 149, 121, 37);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBackground(Color.RED);
		label_1.setBounds(96, 268, 121, 37);
		contentPane.add(label_1);
		
		JButton btn_login = new JButton("LOGIN");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String uname = txt_uname.getText();
					String password = new String(txt_pwd.getPassword());
					int num = ConnectDB.Login(uname,password);
				
				if(num==0)
				{
					DialogMessage.showInfoDialog("Employee Login");
					Main_Frame m = new Main_Frame();
					m.setVisible(true);
					setVisible(false);
				}
				
				else if(num==2)
				{
					DialogMessage.showInfoDialog("Customer Login");
					Customer_Main_Frame c = new Customer_Main_Frame();
					c.setVisible(true);
					setVisible(false);
				}
				else
				{
					DialogMessage.showWarningDialog("ERROR");
				}
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_login.setForeground(SystemColor.menu);
		btn_login.setFont(new Font("Tahoma", Font.BOLD, 28));
		btn_login.setBackground(Color.GRAY);
		btn_login.setBounds(96, 374, 197, 61);
		contentPane.add(btn_login);
		
		JButton btn_hint = new JButton("Register");
		btn_hint.setFont(new Font("Tahoma", Font.BOLD, 28));
		btn_hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register_Login r = new Register_Login();
				setVisible(false);
				r.setVisible(true);
			}
		});
		btn_hint.setForeground(Color.GRAY);
		btn_hint.setBounds(435, 374, 157, 62);
		contentPane.add(btn_hint);
		
		JLabel lblInventoryManagementSystem = new JLabel("STOCKS MANAGEMENT SYSTEM");
		lblInventoryManagementSystem.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblInventoryManagementSystem.setBounds(131, 52, 461, 62);
		contentPane.add(lblInventoryManagementSystem);
		
		txt_pwd = new JPasswordField();
		txt_pwd.setBounds(395, 257, 197, 48);
		contentPane.add(txt_pwd);
}

	
}