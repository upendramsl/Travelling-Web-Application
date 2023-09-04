package com.techpalle.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Customer;
import com.techpalle.model.Employee;
import com.techpalle.model.Traveller;

public class Travelling 
{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/msltravels";
	private static final String dbUsername = "root";
	private static final String dbPassword = "upendra";
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static Statement stm = null;
	private static ResultSet rs = null;
	
	
	private static final String customersListQuery = "select email,password from customer where email=?,password=?";
	private static final String employeeInsert = "insert into employee(name, email, mobile,password) values(?,?,?,?)";
	private static final String employeeEditQuery = "select * from employee where id = ?";
	private static final String employeeUpdateQuery = "update employee set name=?, email=?, mobile=?,password=? where id=?";
	private static final String employeeDeleteQuery = "delete from employee where id=?";

	private static final String customerDeleteQuery = "delete from customertravelingdetails where id=?";
	private static final String customerFormUpdateQuery = "update customertravelingdetails set name=?, email=?, mobile=?,adress=?,dateoftraveling=?,pickup=?,dtpoint=? where id=?";

	
	public static void insert(Customer c)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			ps=con.prepareStatement("insert into customer(name,email,mobile,password) values(?,?,?,?)");
			ps.setString(1,c.getName());
			ps.setString(2,c.getEmail());
			ps.setLong(3,c.getMobile());
			ps.setString(4,c.getPassword());
			ps.executeUpdate();
			
			
			
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
				{
				con.close();
			    }
				if(ps!=null)
				{
					ps.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

}
	public static void insertemp(Employee e)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			ps=con.prepareStatement(employeeInsert);
			ps.setString(1,e.getName());
			ps.setString(2,e.getEmail());
			ps.setLong(3,e.getMobile());
			ps.setString(4,e.getPassword());
			ps.executeUpdate();
			
			
			
		} 
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
		} 
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
				{
				con.close();
			    }
				if(ps!=null)
				{
					ps.close();
				}
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}

	}


public static boolean login(String email, String pass)
	{
	boolean ispresent =true;
		
        try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			ps=con.prepareStatement(customersListQuery);
			ps.setString(1,email);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			ispresent=rs.next();
		
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(con!=null)
				{
				con.close();
			    }
				if(ps!=null)
				{
					ps.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
       return ispresent;
		
		
	}


public static void insertPD(Traveller t) 
{

	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps=con.prepareStatement("insert into customertravelingdetails(name,email,mobile,adress,dateoftraveling,pickup,dtpoint) values(?,?,?,?,?,?,?)");
		ps.setString(1,t.getName());
		ps.setString(2, t.getEmail());
		ps.setLong(3,t.getMobile());
		ps.setString(4,t.getAddress());
		
		ps.setString(5,t.getDate());
		ps.setString(6,t.getFrom());
		ps.setString(7,t.getTo());
		ps.executeUpdate();
	
	} 
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		try {
			if(con!=null)
			{
			con.close();
		    }
			if(ps!=null)
			{
				ps.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
public static boolean empLog(String email,String pass) 
{
	boolean ispresent =true;
	
    try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps=con.prepareStatement("select email,password from employee where email=?,password=?");
		ps.setString(1,email);
		ps.setString(2,pass);
		rs=ps.executeQuery();
	    ispresent = rs.next();

	} 
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		try {
			if(con!=null)
			{
			con.close();
		    }
			if(ps!=null)
			{
				ps.close();
			}
			if(rs!=null)
			{
				rs.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	return ispresent;
}
public static boolean managementLogin(String email, String pass)
{
boolean ispresent =true;
	
    try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps=con.prepareStatement("select email,password from management where email=?,password=?");
		ps.setString(1,email);
		ps.setString(2,pass);
		rs=ps.executeQuery();
		ispresent=rs.next();
	
	} 
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		try {
			if(con!=null)
			{
			con.close();
		    }
			if(ps!=null)
			{
				ps.close();
			}
			if(rs!=null)
			{
				rs.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
   return ispresent;
}
public static void deleteCustomer(int id)
{
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps = con.prepareStatement(customerDeleteQuery);
		ps.setInt(1, id);
		
		ps.executeUpdate();
		
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally 
	{
		if(ps != null) {
			try 
			{
				ps.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

public static void editEmployee(Employee c) 
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps = con.prepareStatement(employeeUpdateQuery);
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setLong(3, c.getMobile());
		ps.setString(4,c.getPassword());
		ps.setInt(5, c.getId());
		
		ps.executeUpdate();
		
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally 
	{
		if(ps != null) {
			try 
			{
				ps.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

public static Employee getOneEmployee(int id) 
{
	Employee c = null;
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps = con.prepareStatement(employeeEditQuery);
		ps.setInt(1,id);
		
		rs = ps.executeQuery();
		
		rs.next();
		
		int i = rs.getInt("id");
		String n = rs.getString("name");
		String e = rs.getString("email");
		long m = rs.getLong("mobile");
		String p=rs.getString("password");
		
	  c=new Employee(i, n, e, m, p);
		
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	finally 
	{
		if(rs != null) {
			try 
			{
				rs.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try 
			{
				ps.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return c;
}
public static ArrayList<Employee> getAllEmployee() 
{
	ArrayList<Employee> al = new ArrayList<Employee>();
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		stm = con.createStatement();
		
		rs = stm.executeQuery("select * from employee");
		
		while(rs.next())
		{
			int i = rs.getInt("id");
			String n = rs.getString("name");
			String e = rs.getString("email");
			long m = rs.getLong("mobile");
			String p=rs.getString("password");
			
			Employee em=new Employee(i, n, e, m, p);
			
			al.add(em);
		}
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	finally 
	{
		if(rs != null) {
			try 
			{
				rs.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stm != null) {
			try 
			{
				stm.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return al;
}
public static void editCustomer(Traveller c) 
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps = con.prepareStatement(customerFormUpdateQuery);
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setLong(3, c.getMobile());
		ps.setString(4,c.getAddress());
		ps.setString(5, c.getDate());
		ps.setString(6, c.getFrom());
		ps.setString(7, c.getTo());
		ps.setInt(8,c.getGetid());
		
		ps.executeUpdate();
		
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally 
	{
		if(ps != null) {
			try 
			{
				ps.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
public static void deleteEmployee(int i) {
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		ps = con.prepareStatement(employeeDeleteQuery);
		ps.setInt(1, i);
		
		ps.executeUpdate();
		
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally 
	{
		if(ps != null) {
			try 
			{
				ps.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
public static Traveller getOneCustomer(int i)
{
	Traveller c = null;
try 
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
	ps = con.prepareStatement("select * from customertravelingdetails where id=?");
	ps.setInt(1,i);
	
	rs = ps.executeQuery();
	
	rs.next();
	
	int i1 = rs.getInt("id");
	String n = rs.getString("name");
	String e = rs.getString("email");
	long m = rs.getLong("mobile");
	String a=rs.getString("adress");
	String d=rs.getString("dateoftraveling");
	String p=rs.getString("pickup");
	String dp=rs.getString("dtpoint");
    c=new Traveller(n, e, m, a, d, p, dp,i1);	
} 
catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
finally 
{
	if(rs != null) {
		try 
		{
			rs.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(ps != null) {
		try 
		{
			ps.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	if(con != null) {
		try 
		{
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
return c;
	
}
public static ArrayList<Traveller> getAllCustomerDetails() {
	ArrayList<Traveller> al = new ArrayList<Traveller>();
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		stm = con.createStatement();
		
		rs = stm.executeQuery("select * from customertravelingdetails");
		
		while(rs.next())
		{
			int i = rs.getInt("id");
			String n = rs.getString("name");
			String e = rs.getString("email");
			long m = rs.getLong("mobile");
			String a=rs.getString("adress");
			String d=rs.getString("dateoftraveling");
			String p=rs.getString("pickup");
			String dp=rs.getString("dtpoint");



			
         Traveller em=new Traveller(n, e, m, a, d, p, dp,i);			
			al.add(em);
		}
	} 
	catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	finally 
	{
		if(rs != null) {
			try 
			{
				rs.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stm != null) {
			try 
			{
				stm.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try 
			{
				con.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return al;
}
}
