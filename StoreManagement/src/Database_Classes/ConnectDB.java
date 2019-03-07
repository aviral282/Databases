 package Database_Classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;

import javax.swing.table.DefaultTableModel;

public class ConnectDB {

	public static int Insert_item(String a,String b,int c,int d)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "insert into items(Item_Name,Item_Type,Item_Price,Item_Quantity) values(?,?,?,?)";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setInt(3, c);
		st.setInt(4, d);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}
	
	
	public static String[] getItemTypes() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT DISTINCT Item_Type FROM items";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	//STEP 5: Extract data from result set
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));;
	}

	// finally turn the array lists into arrays - if really needed
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}

	
	public static DefaultTableModel getItemReport() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM items";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	/*new String[]{"Class Name", "Home work", "Due Date","H"}, 0*/
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getItemHeading());
	while (rs.next()) { 
		int id = rs.getInt("Item_ID");
		 String d = rs.getString("Item_Name");
		    String e = rs.getString("Item_Type");
		    int g = rs.getInt("Item_Quantity");
		    int f = rs.getInt("Item_Price");
		    model.addRow(new Object[]{id,d,f, g,e});
	}
	return model;
	}
	
	public static String[] getItemHeading() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT column_name FROM information_schema.columns WHERE table_schema = 'assignment' AND table_name = 'items'";
	   
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));
	}
	
	String[] type = new String[types.size()];
	return type = types.toArray(type); }
	
	public static int deleteItem(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		CallableStatement st = null;
		
		
	   String sql = "{call deleteItemSP(?)}";
	st = conn.prepareCall(sql);
	st.setInt(1, id);
	int num = st.executeUpdate();
	//String[] type = new String[types.size()];
	return num;
	}
	
	public static String[] getEmployeeDepartment() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT DISTINCT Employee_Department FROM Employee";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	//STEP 5: Extract data from result set
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));;
	}

	// finally turn the array lists into arrays - if really needed
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}
	
	public static String[] getEmployeeDesignation() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT DISTINCT Employee_Designation FROM Employee";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	//STEP 5: Extract data from result set
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));;
	}

	// finally turn the array lists into arrays 
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}
	
	public static int Insert_Employee(String a,String b,String c,String d,String e)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "insert into Employee(Employee_FirstName,Employee_LastName,Employee_Gender,Employee_Designation,Employee_Department) values(?,?,?,?,?)";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setString(3, c);
		st.setString(4, d);
		st.setString(5, e);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}
	
	public static DefaultTableModel getEmployeesReport() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM employee";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	/*new String[]{"Class Name", "Home work", "Due Date","H"}, 0*/
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getEmployeesHeading());
	while (rs.next()) { 
		int id = rs.getInt("Employee_ID");
		 String d = rs.getString("Employee_FirstName");
		 String e = rs.getString("Employee_LastName");
		 String f = rs.getString("Employee_Gender");
		 String g = rs.getString("Employee_Designation");
		 String h = rs.getString("Employee_Department");
		    model.addRow(new Object[]{id,d,e, f,g,h});
	}
	return model;
	}

	

	public static String[] getEmployeesHeading() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "SHOW COLUMNS FROM assignment.employee";
		
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));
	}
	
	String[] type = new String[types.size()];
	return type = types.toArray(type); }

	
	public static int deleteEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		CallableStatement st = null;
		
		
	   String sql = "{call deleteEmployeeSP(?)}";
	st = conn.prepareCall(sql);
	st.setInt(1, id);
	int num = st.executeUpdate();
	return num;
	}
	
	
	public static int Register_user(String a,String b,int c)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "insert into login(login_username,login_password,login_type) values(?,?,?)";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setInt(3,c);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}
	
	
	public static int Login(String a,String b) throws SQLException, NoSuchAlgorithmException
	{
		
			Connection conn = MySQLAccess.getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;
			
	
		//String sql = "insert into agent(name,contact,address) values('Aviral','77','Apt no. 11')";

		   String sql = "SELECT login_username,login_password,login_type FROM login";
		st = conn.prepareStatement(sql);
		rs = st.executeQuery();
		     
		int num = 1;
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		          String id  = rs.getString("login_username");
		         String pwd = rs.getString("login_password");
		        String pwds = decodePwd(pwd);
		          int type = rs.getInt("login_type");
		          
		          if(a.equals(id)&&b.equals(pwds))
		          {
		        	  if(type==0)
		        	  {
		        	num = 0;  
		          }
		        	  else if(type==1)
		        	  {
		        		  num=2;
		        	  }
		          }
		
		      }
			return num;
		}
	
	private static String decodePwd(String value) throws NoSuchAlgorithmException {
		byte[] decodedBytes = Base64.getDecoder().decode(value);
		String decodedString = new String(decodedBytes);
		return decodedString;
	
	}
	
	public static int Insert_Customer(String a,String b,String c,int d)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "insert into customers(Customer_FirstName,Customer_LastName,Customer_Address,Customer_Number) values(?,?,?,?)";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setString(3, c);
		st.setInt(4, d);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}

	public static String[] getCustomerName() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT Customer_FirstName,Customer_LastName FROM Customers";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	//STEP 5: Extract data from result set
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    String a = rs.getString(1);
	    String b = rs.getString(2);
	    types.add(a);
	}

	// finally turn the array lists into arrays - if really needed
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}
	
	public static String[] getItemName() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT Item_Name FROM items";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	//STEP 5: Extract data from result set
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    String a = rs.getString(1);
	    types.add(a);
	}

	// finally turn the array lists into arrays - if really needed
	String[] type = new String[types.size()];
	return type = types.toArray(type); 
	}
	
	public static int getItemPrice(String x) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int a = 0;
	   String sql = "SELECT Item_Price FROM items where Item_Name =  ?";
	st = conn.prepareStatement(sql);
	st.setString(1, x);
	rs = st.executeQuery();
	//STEP 5: Extract data from result set
	while (rs.next()) { 
	  a = rs.getInt("Item_Price");
	}	

	return a;
	}
	
	public static ArrayList<String> getEmployeeUpdateInfo(int id) throws SQLException, NoSuchAlgorithmException
	{
		
			Connection conn = MySQLAccess.getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;
			
	
		//String sql = "insert into agent(name,contact,address) values('Aviral','77','Apt no. 15')";

		   String sql = "SELECT Employee_FirstName,Employee_LastName,Employee_Designation,Employee_Department FROM employee where Employee_ID = ?";
		st = conn.prepareStatement(sql);
		st.setInt(1, id);
		rs = st.executeQuery();
		     
		int num = 1;
		 ArrayList<String> alist=new ArrayList<String>();  
	     
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		          String fname = rs.getString("Employee_FirstName");
		         String lname = rs.getString("Employee_LastName");
		        String desg = rs.getString("Employee_Designation");
		        String dept = rs.getString("Employee_Department");
		        alist.add(fname);
		        alist.add(lname);
		        alist.add(desg);
		        alist.add(dept);
		      }
		     
			return alist;
		}
	
	public static int Update_Employee(String a,String b,String d, String e, int c)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "UPDATE employee SET Employee_firstname = ?,Employee_lastname = ?,Employee_designation = ?,Employee_department = ? WHERE employee_id = ? ";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setString(3, d);
		st.setString(4, e);
		st.setInt(5,c);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}
	
	
	public static ArrayList<String> getItemUpdateInfo(int id) throws SQLException, NoSuchAlgorithmException
	{
		
			Connection conn = MySQLAccess.getConnection();
			PreparedStatement st = null;
			ResultSet rs = null;
			
	
		   String sql = "SELECT Item_Name,Item_Price,Item_Quantity,Item_Type FROM items where item_ID = ?";
		st = conn.prepareStatement(sql);
		st.setInt(1, id);
		rs = st.executeQuery();
		     
		 ArrayList<String> alist=new ArrayList<String>();  
	     
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		          String fname = rs.getString("Item_Name");
		         int lnam = rs.getInt("Item_Price");
		        int dsg = rs.getInt("Item_Quantity");
		        System.out.println(lnam + dsg+fname);
		        String price = String.valueOf(lnam);
		        String quan = String.valueOf(dsg);
		        String Item_type = rs.getString("Item_Type");
		        alist.add(fname);
		        alist.add(price);
		        alist.add(quan);
		        alist.add(Item_type);
		      }
		     
			return alist;
		}
	
	
	public static int Update_Item(String a,String b,int d, int e, int c)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "UPDATE items SET item_name = ?,item_type = ?,item_price = ?,item_quantity = ? WHERE item_id = ? ";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
		st.setString(2, b);
		st.setInt(3, d);
		st.setInt(4, e);
		st.setInt(5,c);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}
	
	public static DefaultTableModel getCustomerReport() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM assignment.customer_view;";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getCustomerHeading());
	while (rs.next()) { 
		int id = rs.getInt("Customer_ID");
		 String d = rs.getString("Customer_FirstName");
		 String e = rs.getString("Customer_LastName");
		 String f = rs.getString("Customer_Address");
		 int g = rs.getInt("Customer_Number");
		 String h = String.valueOf(g);
		    model.addRow(new Object[]{id,d,e, f,h});
	}
	return model;
	}
	
	public static String[] getCustomerHeading() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "SHOW COLUMNS FROM assignment.customers";
		
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));
	}
	
	String[] type = new String[types.size()];
	return type = types.toArray(type);
	}

	public static int Insert_order(String a,String b,int c,int d)
	{
	Connection conn = MySQLAccess.getConnection();
	PreparedStatement st = null;
	ResultSet rs = null;
	int num = 0;
	try
	{
		String sql = "insert into assignment.order(customer_Name,item_Name,item_Quantity,billing_Amount) values(?,?,?,?)";
		st = conn.prepareStatement(sql);
		// index starts from 1
		st.setString(1, a);
	
		st.setString(2, b);
		st.setInt(3, c);
		st.setInt(4, d);
		// execute and return number of rows that take effect
		num = st.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		MySQLAccess.release(conn, st, rs);
	}
	return num;
	}
	
	public static int exportEmployee() throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM assignment.employee_view;";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	 ArrayList eid = new ArrayList();
	  ArrayList fname = new ArrayList();
	  ArrayList lname = new ArrayList();
	  ArrayList gender = new ArrayList();
	  ArrayList designation = new ArrayList();
	  ArrayList department = new ArrayList();
	
	while (rs.next()) { 
		int id = rs.getInt("Employee_ID");
		 String d = rs.getString("Employee_FirstName");
		 String e = rs.getString("Employee_LastName");
		 String f = rs.getString("Employee_Gender");
		 String g = rs.getString("Employee_Designation");
		 String h = rs.getString("Employee_Department");
		 eid.add(id);
		 fname.add(d);
		 lname.add(e);
		 gender.add(f);
		 designation.add(g);
		 department.add(h);
	}
	
	  BufferedWriter writer = new BufferedWriter(new FileWriter(new File("employee.csv")));
	  for(int i = 0;i<eid.size();i++) {
	     
	     writer.write("Employee ID: "+eid.get(i)); 
	     writer.newLine();
	     writer.write("First Name: "+fname.get(i)); 
	     writer.newLine();
	     writer.write("Last Name: "+lname.get(i)); 
	     writer.newLine();
	     writer.write("Gender: "+gender.get(i)); 
	     writer.newLine();
	     writer.write("Desingation: "+designation.get(i)+" "+" Department: "+department.get(i)); 
	     writer.newLine();
	     writer.newLine();
	    }
	  writer.close();
	
	return 1;
	}
	
	public static int exportProduct() throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM items;";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	 ArrayList Iid = new ArrayList();
	  ArrayList iname = new ArrayList();
	  ArrayList itype = new ArrayList();
	  ArrayList iprice = new ArrayList();
	  ArrayList iquantity = new ArrayList();
	
	while (rs.next()) { 
		int id = rs.getInt("Item_ID");
		 String d = rs.getString("Item_Name");
		 String e = rs.getString("Item_Type");
		 String f = rs.getString("Item_Price");
		 String g = rs.getString("Item_Quantity");
		 Iid.add(id);
		 iname.add(d);
		 itype.add(e);
		 iprice.add(f);
		 iquantity.add(g);
	}
	
	  BufferedWriter writer = new BufferedWriter(new FileWriter(new File("items.csv")));
	  for(int i = 0;i<Iid.size();i++) {
	     
	     writer.write("Item ID: "+Iid.get(i)); 
	     writer.newLine();
	     writer.write("Item Name: "+iname.get(i)); 
	     writer.newLine();
	     writer.write("Item Type: "+itype.get(i)); 
	     writer.newLine();
	     writer.write("Item Price: "+iprice.get(i)); 
	     writer.newLine();
	     writer.write("Item Quantity: "+iquantity.get(i)); 
	     writer.newLine();
	     writer.newLine();
	    }
	  writer.close();
	
	return 1;
	}
	
	public static DefaultTableModel getOrderReport() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM assignment.order;";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(getOrderHeading());
	while (rs.next()) { 
		int id = rs.getInt("Order_ID");
		 String d = rs.getString("customer_Name");
		 String e = rs.getString("Item_Name");
		 int f = rs.getInt("Item_Quantity");
		 int g = rs.getInt("billing_Amount");
		    model.addRow(new Object[]{id,d,e, f,g});
	}
	return model;
	}
	
	public static String[] getOrderHeading() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		String sql = "SHOW COLUMNS FROM assignment.order";
		
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	ArrayList<String> types = new ArrayList<String>();

	while (rs.next()) { 
	    types.add(rs.getString(1));
	}
	
	String[] type = new String[types.size()];
	return type = types.toArray(type);
	}
	
	
	public static int exportOrder() throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM assignment.order;";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	 ArrayList oid = new ArrayList();
	  ArrayList iname = new ArrayList();
	  ArrayList cname = new ArrayList();
	  ArrayList quantity = new ArrayList();
	  ArrayList amount = new ArrayList();
	
	while (rs.next()) { 
		int id = rs.getInt("order_Id");
		 String d = rs.getString("customer_Name");
		 String e = rs.getString("item_Name");
		 int f = rs.getInt("billing_Amount");
		 int g = rs.getInt("Item_Quantity");
		oid.add(id);
		 cname.add(d);
		 iname.add(e);
		 amount.add(f);
		 quantity.add(g);
	}
	
	  BufferedWriter writer = new BufferedWriter(new FileWriter(new File("orders.csv")));
	  for(int i = 0;i<oid.size();i++) {
	     
	     writer.write("Order ID: "+oid.get(i)); 
	     writer.newLine();
	     writer.write("Item Name: "+iname.get(i)); 
	     writer.newLine();
	     writer.write("Customer Name: "+cname.get(i)); 
	     writer.newLine();
	     writer.write("Amount: "+amount.get(i)); 
	     writer.newLine();
	     writer.write("Item Quantity: "+quantity.get(i)); 
	     writer.newLine();
	     writer.newLine();
	    }
	  writer.close();
	
	return 1;
	}
	

	public static int exportCustomer() throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MySQLAccess.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		
	   String sql = "SELECT * FROM assignment.customers;";
	st = conn.prepareStatement(sql);
	rs = st.executeQuery();
	
	 ArrayList cid = new ArrayList();
	  ArrayList cfname = new ArrayList();
	  ArrayList clname = new ArrayList();
	  ArrayList addr = new ArrayList();
	  ArrayList ph = new ArrayList();
	
	while (rs.next()) { 
		int id = rs.getInt("Customer_Id");
		 String d = rs.getString("customer_firstName");
		 String e = rs.getString("customer_lastName");
		String f = rs.getString("customer_Address");
		 int g = rs.getInt("customer_number");
		cid.add(id);
		 cfname.add(d);
		 clname.add(e);
		 addr.add(f);
		 ph.add(g);
	}
	
	  BufferedWriter writer = new BufferedWriter(new FileWriter(new File("customers.csv")));
	  for(int i = 0;i<cid.size();i++) {
	     
	     writer.write("Customer ID: "+cid.get(i)); 
	     writer.newLine();
	     writer.write("Customer First Name: "+cfname.get(i)); 
	     writer.newLine();
	     writer.write("Customer last Name: "+clname.get(i)); 
	     writer.newLine();
	     writer.write("Address: "+addr.get(i)); 
	     writer.newLine();
	     writer.write("Phone: "+ph.get(i)); 
	     writer.newLine();
	     writer.newLine();
	    }
	  writer.close();
	
	return 1;
	}
	
	}



