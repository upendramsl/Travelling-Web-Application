<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select Type of vehicle</title>
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
<div class="container" style="width:50%">
<h1>Select the type of Vehicle</h1>
<form action="customerfillingform.jsp">

	
	<div>
		<button class="btn btn-success">Toofan</button>
	</div>
	
	</form>
	</br>
	<form action="customerfillingform.jsp">

	
	<div>
		<button class="btn btn-success">TATA sumo</button>
	</div>
	
	</form>
	</br>
	<form action="customerfillingform.jsp">

	
	<div>
		<button class="btn btn-success">Ashok Leyaland</button>
	</div>

	</form>
	</br>
	<form action="customerfillingform.jsp">

	
	<div>
		<button class="btn btn-success">Eicher Lorry</button>
	</div>
	
	</form>
	
</div>


</body>
</html>