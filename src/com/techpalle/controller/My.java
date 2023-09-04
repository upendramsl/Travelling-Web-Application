package com.techpalle.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.Dao.Travelling;
import com.techpalle.model.Customer;
import com.techpalle.model.Employee;
import com.techpalle.model.Traveller;


@WebServlet("/")
public class My extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		
		switch(path) 
		{
		case "/reg":
			customerreg(request,response);
			break;
		case "/log":
			customerlog(request,response);
			break;
		
		case "/delete":
			deleteCustomerDetais(request, response);
			break;
		case "/edit":
			editCustomer(request, response);
			break;
		case "/cusEditForm":
			cusEditForm(request,response);
			break;
		case "/deleteEmp":
			deleteEmp(request, response);
			break;
		case "/editemp":
			editemployee(request, response);
			break;
		
		case "/editForm":
			getEmpEditForm(request, response);
			break;
		case "/Empreg":
			getInsertForm(request, response);
		break;
		case "/Emplog":
			empLogin(request,response);
			break;
		case "/Managelog":
			managementlogin(request,response);
			break;
			
		case "/fill":
			insertPoints(request,response);
			break;
		default:
			getStartUpPage(request, response);
			break;

		}
	}

	

private void cusEditForm(HttpServletRequest request, HttpServletResponse response) {
	int i = Integer.parseInt(request.getParameter("id")) ;
	
	Traveller c = Travelling.getOneCustomer(i);
	
	try
	{
		RequestDispatcher rd1 = request.getRequestDispatcher("customerfillingform.jsp");
		request.setAttribute("al",c);
		rd1.forward(request, response);
	} 
	catch (ServletException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}



private void deleteEmp(HttpServletRequest request, HttpServletResponse response) {
	// Read the id from url
			int i = Integer.parseInt( request.getParameter("id") );
			
			// call the dao method to delete the row in database
			Travelling.deleteEmployee(i);
			
			// Redirect user to customer-list page
			try
			{
				response.sendRedirect("managementhome.jsp");
			} 
			catch (IOException e1) {
				e1.printStackTrace();
			}		
	}



private void editemployee(HttpServletRequest request, HttpServletResponse response) 
{
	int i = Integer.parseInt( request.getParameter("tbId") ) ;
	String n = request.getParameter("tbName");
	String e = request.getParameter("tbEmail");
	long m = Long.parseLong( request.getParameter("tbMobile") );
	String p=request.getParameter("tbPass");

	Employee em=new Employee(i,n,e,m,p);
	Travelling.editEmployee(em);
	
	// Redirect user to customer-list page
	try
	{
		response.sendRedirect("managementhome.jsp");
	} 
	catch (IOException e1) {
		e1.printStackTrace();
	}
	
			
	}


private void managementlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	String email=request.getParameter("tbEmail");
	String pass=request.getParameter("tbPass");
	
	boolean b=Travelling.managementLogin(email,pass);
	if(b)
	{
		RequestDispatcher rd=request.getRequestDispatcher("managementhome.jsp");
		rd.forward(request, response);
	}
	else	
	{
		PrintWriter r = response.getWriter();
		r.append("ERROR");
		r.append("<marquee behavior=\"scroll\" direction=\"left\"><h1>You have entered incorrect email or password</h1>\r\n"
				+ "</marquee>");
		
	}
}


private void empLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String email=request.getParameter("tbEmail");
	String pass=request.getParameter("tbPass");
	
	boolean b=Travelling.empLog(email,pass);
	if(b)
	{
		RequestDispatcher rd=request.getRequestDispatcher("employeehome.jsp");
		rd.forward(request, response);
	}
	else
	{
		response.sendRedirect("employeelogin.jsp");
	}
		
	}


private void insertPoints(HttpServletRequest request, HttpServletResponse response) throws IOException 
{
	String name=request.getParameter("tbName");
	String Email=request.getParameter("tbEmail");
	Long mobile=Long.parseLong(request.getParameter("tbMobile"));
	String Address =request.getParameter("tbAddress");
	String date=request.getParameter("dtPicker");
	String pickup=request.getParameter("PPoint");
	String dtpoint=request.getParameter("DPoint");
	Traveller t=new Traveller(name, Email,mobile, Address, date, pickup,dtpoint);
	Travelling.insertPD(t);
	PrintWriter r = response.getWriter();
	r.append("Successfully Saved");
	r.append("<marquee behavior=\"scroll\" direction=\"left\"><h1>You can get Call back from our company kindly ThankingYou</h1>\r\n"
			+ "</marquee>");
	

	
		
	}


private void customerlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("tbEmail");
		String pass=request.getParameter("tbPass");
		
		boolean b=Travelling.login(email, pass);
		if(b)
		{
			RequestDispatcher rd=request.getRequestDispatcher("vehicletype.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		
	}


	private void customerreg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		long mobile=Long.parseLong(request.getParameter("tbMobile"));
		String pass=request.getParameter("tbPass");
		
		Customer c=new Customer(name, email,mobile, pass);
		Travelling.insert(c);
		RequestDispatcher rd=request.getRequestDispatcher("customerlogin.jsp");
		rd.forward(request, response);
	}


	private void getInsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		long mobile=Long.parseLong(request.getParameter("tbMobile"));
		String pass=request.getParameter("tbPass");
		
		Employee e=new Employee(name, email, mobile, pass);
		Travelling.insertemp(e);
		try
		{
			response.sendRedirect("managementhome.jsp");
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
	}


	private void deleteCustomerDetais(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the id from url
		int i = Integer.parseInt( request.getParameter("id") );
		
		// call the dao method to delete the row in database
		Travelling.deleteCustomer(i);
		
		// Redirect user to customer-list page
		try
		{
			response.sendRedirect("employeehome.jsp");
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void editCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		int i = Integer.parseInt( request.getParameter("tbId") ) ;
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		long m = Long.parseLong( request.getParameter("tbMobile") );
		String a=request.getParameter("tbAddress");
		String d=request.getParameter("tbDate");
		String p=request.getParameter("tbPickup");
		String dp=request.getParameter("tbDtpoint");

		
		Traveller c =new Traveller(n, e, m, a, d, p, dp);
		Travelling.editCustomer(c);
		
		// Redirect user to customer-list page
		try
		{
			response.sendRedirect("employeehome.jsp");
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

	private void getEmpEditForm(HttpServletRequest request, HttpServletResponse response) 
	{
		
		// Fetch the id from url:
		int i = Integer.parseInt(request.getParameter("id")) ;
		
		Employee c = Travelling.getOneEmployee(i);
		
		try
		{
			RequestDispatcher rd1 = request.getRequestDispatcher("employeereg.jsp");
			request.setAttribute("Employee",c);
			rd1.forward(request, response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void getAllEmpoloyeeDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		
		ArrayList<Employee> c = Travelling.getAllEmployee();
		
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("managementhome.jsp");
			request.setAttribute("em",c);
			rd.forward(request,response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getAllCustomerDetails(HttpServletRequest request, HttpServletResponse response) 
	{
		
		ArrayList<Traveller> c = Travelling.getAllCustomerDetails();
		
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("employeehome.jsp");
			request.setAttribute("em",c);
			rd.forward(request,response);
		} 
		catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
