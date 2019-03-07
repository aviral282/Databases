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

public class Report_Employees extends JPanel {
	private JTextField txt_EmployeeID;
	static String id;
	static String fname;
	static String lname;
	static String desg;
	static String dept;
	
	public Report_Employees() {
        initializeUI();    
    }

    private void initializeUI() {
        setPreferredSize(new Dimension(752, 604));
        setLayout(null);

        JTable table = new JTable(25,15);

        // Turn off JTable's auto resize so that JScrollPane will show a
        // horizontal scroll bar.
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(33, 86, 707, 242);
        
        JButton btnGenerate = new JButton("Generate");
        btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnGenerate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					DefaultTableModel tableModel = new DefaultTableModel();
					tableModel = ConnectDB.getEmployeesReport();
					table.setModel(tableModel);
				
        		} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
        btnGenerate.setBounds(59, 364, 236, 60);
        add(btnGenerate);
        add(pane);
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
       
        btnDelete.setBounds(299, 523, 117, 33);
        add(btnDelete);
        
        txt_EmployeeID = new JTextField();
        txt_EmployeeID.setBounds(506, 450, 117, 33);
        add(txt_EmployeeID);
        txt_EmployeeID.setColumns(10);
        
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
        button.setBounds(46, 523, 117, 33);
        add(button);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ArrayList<String> a = new ArrayList<String>();
        			id = txt_EmployeeID.getText();
					a = ConnectDB.getEmployeeUpdateInfo(Integer.parseInt(txt_EmployeeID.getText()));
        			fname = a.get(0).toString();
        			lname = a.get(1).toString();
        			desg = a.get(2).toString();
        			dept = a.get(3).toString();
        			Update_Employees u = new Update_Employees();	
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
        btnUpdate.setBounds(545, 523, 117, 33);
        add(btnUpdate);
        
        JButton btnExport = new JButton("Export To Csv");
        btnExport.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnExport.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	        	try {
							int n = ConnectDB.exportEmployee();
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
        btnExport.setBounds(459, 364, 223, 60);
        add(btnExport);
        
        JLabel lblNewLabel = new JLabel("Enter ID To Perform Operation");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(56, 451, 336, 25);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Employee Report");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_1.setBounds(225, 29, 398, 33);
        add(lblNewLabel_1);
    
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
        			int id = Integer.parseInt(txt_EmployeeID.getText());
					int num  = ConnectDB.deleteEmployee(id);
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
        JPanel panel = new Report_Employees();
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
            	Report_Employees.showFrame();
            }
        });
    }
}