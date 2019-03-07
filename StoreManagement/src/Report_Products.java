import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import Database_Classes.ConnectDB;
import Misc.DialogMessage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Report_Products extends JPanel {
	private JTextField txt_ItemID;
	static String item_id;
	static String item_name;
	static String item_price;
	static String item_quantity;
	static String item_type;
	
	public Report_Products() {
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(690, 550));
        setLayout(null);

        JTable table = new JTable(25,25);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(12, 70, 666, 258);
        
        JButton btnGenerate = new JButton("Generate");
        btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getItemReport();
					table.setModel(tableModel);
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        btnGenerate.setBounds(46, 362, 196, 40);
        add(btnGenerate);
        add(pane);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
       
        btnDelete.setBounds(309, 483, 117, 31);
        add(btnDelete);
        
        txt_ItemID = new JTextField();
        txt_ItemID.setBounds(465, 417, 128, 32);
        add(txt_ItemID);
        txt_ItemID.setColumns(10);
        
        JButton button = new JButton("Back");
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JComponent comp = (JComponent) e.getSource();
        		  Window win = SwingUtilities.getWindowAncestor(comp);
        		  win.dispose();
        		  Main_Frame m = new Main_Frame();
        		  m.setVisible(true);
        	}
        });
        button.setBounds(46, 482, 117, 32);
        add(button);
        
        JButton button_1 = new JButton("Update");
        button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ArrayList<String> a = new ArrayList<String>();
        			item_id = txt_ItemID.getText();
					a = ConnectDB.getItemUpdateInfo(Integer.parseInt(txt_ItemID.getText()));
        			item_name = a.get(0).toString();
        			System.out.print(item_name);
        			item_price = a.get(1).toString();
        			item_quantity = a.get(2).toString();
        			item_type = a.get(3).toString();
        			Update_Products u = new Update_Products();	
        		u.setVisible(true);
    
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        button_1.setBounds(520, 483, 105, 31);
        add(button_1);
        
        JButton button_2 = new JButton("Export");
        button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
            	try {
					int n = ConnectDB.exportProduct();
					if(n==1)
					{
						DialogMessage.showInfoDialog("EXPORTED");
					}
					else
					{
						DialogMessage.showWarningDialog("ERROR");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        button_2.setBounds(445, 362, 165, 40);
        add(button_2);
        
        JLabel lblNewLabel = new JLabel("Product Report");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel.setBounds(275, 25, 223, 32);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Enter Id To Perform Operations");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(56, 419, 331, 30);
        add(lblNewLabel_1);
    
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			int id = Integer.parseInt(txt_ItemID.getText());
					int num  = ConnectDB.deleteItem(id);
					if(num>0)
					{
						DialogMessage.showInfoDialog("DELETED");
					}
					else
					{
						DialogMessage.showWarningDialog("ERROR");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
    }

    public static void showFrame() {
        JPanel panel = new Report_Products();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Product Report");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Report_Products.showFrame();
            }
        });
    }
}