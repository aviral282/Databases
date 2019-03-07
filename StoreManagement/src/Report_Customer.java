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

public class Report_Customer extends JPanel {
	static String id;
	static String fname;
	static String lname;
	static String desg;
	static String dept;
	
	public Report_Customer() {
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(539, 279));
        setLayout(null);

        JTable table = new JTable(25,15);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 85, 539, 187);
        
        JButton btnGenerate = new JButton("Generate Customer");
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getCustomerReport();
					table.setModel(tableModel);
				
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        btnGenerate.setBounds(124, 40, 149, 21);
        add(btnGenerate);
        add(pane);
        
        JButton button = new JButton("Back");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JComponent comp = (JComponent) e.getSource();
      		  Window win = SwingUtilities.getWindowAncestor(comp);
      		  win.dispose();
      		  Main_Frame m = new Main_Frame();
      		  m.setVisible(true);
        	}
        });
        button.setBounds(10, 10, 85, 21);
        add(button);
        
        JButton btnExport = new JButton("Export Customer");
        btnExport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					int n = ConnectDB.exportCustomer();
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
        btnExport.setBounds(124, 10, 149, 21);
        add(btnExport);
        
        JButton btnGenerateOrder = new JButton("Generate Order");
        btnGenerateOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getOrderReport();
					table.setModel(tableModel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnGenerateOrder.setBounds(340, 40, 144, 21);
        add(btnGenerateOrder);
        
        JButton btnExportOrder = new JButton("Export Order");
        btnExportOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					int n = ConnectDB.exportOrder();
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
        btnExportOrder.setBounds(340, 10, 144, 21);
        add(btnExportOrder);
        
    }

    public static void showFrame() {
        JPanel panel = new Report_Customer();
        panel.setOpaque(true);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Employees Report");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Report_Customer.showFrame();
            }
        });
    }
}