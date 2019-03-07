import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Main_Frame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
					frame.setVisible(true);
					frame.setTitle("Store Management System");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Frame() {
		setTitle("Store Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(SystemColor.scrollbar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial Black", Font.BOLD, 15));
		menuBar.setForeground(new Color(255, 0, 0));
		menuBar.setBackground(new Color(135, 206, 250));
		menuBar.setBounds(0, 0, 119, 26);
		contentPane.add(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		mnOptions.setForeground(Color.BLACK);
		mnOptions.setFont(new Font("Arial Black", Font.BOLD, 18));
		menuBar.add(mnOptions);
		
		JMenuItem menu_reset = new JMenuItem("Logout");
		menu_reset.setForeground(new Color(30, 144, 255));
		menu_reset.setFont(new Font("Arial", Font.BOLD, 14));
		mnOptions.add(menu_reset);
		menu_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenuItem menu_exit = new JMenuItem("EXIT");
		menu_exit.setForeground(new Color(100, 149, 237));
		menu_exit.setFont(new Font("Arial", Font.BOLD, 14));
		mnOptions.add(menu_exit);
		menu_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		JButton btnNewButton = new JButton("PRODUCTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Products frame;
			try {
				frame = new Products();
				setVisible(false);
				frame.setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(SystemColor.menuText);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBounds(126, 65, 356, 54);
		contentPane.add(btnNewButton);
		
		JButton btnEmployees = new JButton("EMPLOYEES");
		btnEmployees.setForeground(SystemColor.menuText);
		btnEmployees.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEmployees.setBackground(new Color(135, 206, 250));
		btnEmployees.setBounds(126, 141, 356, 54);
		btnEmployees.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Employees frame;
				try {
					frame = new Employees();

					setVisible(false);
					frame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnEmployees);
		
		JButton btnReports = new JButton("Product Report");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Report_Products r = new Report_Products();
				r.showFrame();
				setVisible(false);
			}
		});
		btnReports.setForeground(SystemColor.menuText);
		btnReports.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnReports.setBackground(new Color(135, 206, 250));
		btnReports.setBounds(126, 222, 356, 61);
		contentPane.add(btnReports);
		
		JButton btnEmployeesReport = new JButton("Employees Report");
		btnEmployeesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Employees r = new Report_Employees();
				r.showFrame();
				setVisible(false);
			}
		});
		btnEmployeesReport.setForeground(SystemColor.menuText);
		btnEmployeesReport.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEmployeesReport.setBackground(new Color(135, 206, 250));
		btnEmployeesReport.setBounds(126, 306, 356, 61);
		contentPane.add(btnEmployeesReport);
		
		JButton btnCustomerReport = new JButton("Customer Report");
		btnCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Report_Customer r = new Report_Customer();
				r.showFrame();
				setVisible(false);
			}
		});
		btnCustomerReport.setForeground(SystemColor.menuText);
		btnCustomerReport.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnCustomerReport.setBackground(new Color(135, 206, 250));
		btnCustomerReport.setBounds(126, 389, 356, 61);
		contentPane.add(btnCustomerReport);
	}
}
