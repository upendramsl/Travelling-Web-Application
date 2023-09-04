<%@page import="com.techpalle.Dao.Travelling"%>
<%@page import="com.techpalle.controller.My"%>
<%@page import="com.techpalle.model.Employee"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.model.Customer" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees list</title>
<!-- CDN > Content Delivery Network -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<header style="color:white">

	<nav class="navbar navbar navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><h1>MSL Travels</h1></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
        </li>
      </ul>
 
    </div>
  </div>
</nav>

</header>
<br/>
<br/>

<div class="container">

	<h2 align="center">Employees List</h2>
	<hr>
	
		<form action="employeereg.jsp">
	
		<button>Add Employee</button>
	</form>
	
	

	<table class="table">
	  <thead>
	    <tr>
	      	<th scope="col">Id</th>
			<th scope="col">Name</th>
			<th scope="col">Email</th>
			<th scope="col">Mobile</th>
			<th scope="col">Password</th>
			<th scope="col">Actions</th>
	    </tr>
	  </thead>
	  
	  <tbody>
	  <%ArrayList<Employee> c = Travelling.getAllEmployee(); 
	  for(Employee e:c)
	  {
	  %>
			<tr>
				<td><%=e.getId()%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getEmail()%></td>
				<td><%=e.getMobile()%></td>
				<td><%=e.getPassword() %></td>
				
									<!-- Query String  -->
				<td> 
					<a href="editForm?id=<c:out value="<%=e.getId() %>"></c:out>">Edit</a> 
					&nbsp;&nbsp; 
					<a href="deleteEmp?id=<c:out value="<%=e.getId() %>"></c:out>">Delete</a> 
				</td>
			</tr>
		<%
		}
		%>
	  
	  		
	  </tbody>
	  
	  </table>
	
</div>




</body>
</html>