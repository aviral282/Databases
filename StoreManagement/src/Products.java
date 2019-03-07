import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Products extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Item_Name;
	private JTextField txt_Item_Price;
	private JTextField txt_Item_Quantity;
	static String[] type = {"Hello","World"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					//type = ConnectDB.getItemTypes();
					Products frame = new Products();
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
	public Products() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProducts = new JLabel("Add Products");
		lblAddProducts.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddProducts.setBounds(235, 38, 229, 47);
		contentPane.add(lblAddProducts);
		
		JLabel label_1 = new JLabel("Item Name:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(100, 137, 135, 34);
		contentPane.add(label_1);
		
		txt_Item_Name = new JTextField();
		txt_Item_Name.setColumns(10);
		txt_Item_Name.setBounds(455, 138, 111, 33);
		contentPane.add(txt_Item_Name);
		
		
		
		JLabel label_2 = new JLabel("Item Type");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(100, 204, 111, 47);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Item Price");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(100, 264, 111, 40);
		contentPane.add(label_3);
		
		txt_Item_Price = new JTextField();
		txt_Item_Price.setColumns(10);
		txt_Item_Price.setBounds(455, 273, 111, 34);
		contentPane.add(txt_Item_Price);
		
		txt_Item_Quantity = new JTextField();
		txt_Item_Quantity.setColumns(10);
		txt_Item_Quantity.setBounds(455, 327, 111, 33);
		contentPane.add(txt_Item_Quantity);
		
		JLabel label_4 = new JLabel("Item Quantity");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(100, 323, 156, 34);
		contentPane.add(label_4);
		
		JButton btnItemInsert = new JButton("INSERT");
		
		btnItemInsert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnItemInsert.setBounds(455, 396, 118, 47);
		contentPane.add(btnItemInsert);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Frame m = new Main_Frame();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(100, 396, 111, 47);
		contentPane.add(btnBack);
		type = ConnectDB.getItemTypes();
		JComboBox combo_Item_type = new JComboBox();
		combo_Item_type.setModel(new DefaultComboBoxModel<>(type));
		combo_Item_type.setBounds(455, 205, 111, 34);
		contentPane.add(combo_Item_type);
	
		btnItemInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_Item_Name.getText();
				String type = combo_Item_type.getSelectedItem().toString();
				int price = Integer.parseInt(txt_Item_Price.getText());
				int quantity = Integer.parseInt(txt_Item_Quantity.getText());
				int num = ConnectDB.Insert_item(name, type,price,quantity);
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
