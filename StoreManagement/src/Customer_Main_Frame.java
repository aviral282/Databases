import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Customer_Main_Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Main_Frame frame = new Customer_Main_Frame();
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
	public Customer_Main_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCustomers = new JButton("CUSTOMERS");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Customer c = new Customer();
			c.setVisible(true);
			setVisible(false);
			}
		});
		btnCustomers.setForeground(Color.GRAY);
		btnCustomers.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnCustomers.setBackground(Color.LIGHT_GRAY);
		btnCustomers.setBounds(82, 172, 175, 154);
		contentPane.add(btnCustomers);
		
		JButton btnOrders = new JButton("ORDERS");
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Order o;
			try {
				o = new Order();

				o.setVisible(true);
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnOrders.setForeground(Color.GRAY);
		btnOrders.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnOrders.setBackground(new Color(135, 206, 250));
		btnOrders.setBounds(454, 172, 184, 154);
		contentPane.add(btnOrders);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame l = new LoginFrame();
				l.setVisible(true);
				setVisible(false);
			}
		});
		button.setForeground(new Color(255, 102, 0));
		button.setFont(new Font("Arial Black", Font.BOLD, 18));
		button.setBackground(new Color(135, 206, 250));
		button.setBounds(259, 454, 159, 35);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Welcome To Stock Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(92, 28, 514, 80);
		contentPane.add(lblNewLabel);
	}
}
