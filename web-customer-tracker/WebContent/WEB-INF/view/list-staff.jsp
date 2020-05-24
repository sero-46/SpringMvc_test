<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!Doctype html>
<html>


<head>

<title>
Welcome Page
</title>

<link  type="text/css"
	   rel="stylesheet"
	   href="${pageContext.request.contextPath}/resources/css/style.css"
	   />

</head>


<body>

<div id="wrapper">
	<div id="header">
	<h2>  Staff Background Information </h2>
	
	</div>
</div>

<div id="container">
	<div id="content">
	
	<table>
	 	<tr>
	 	
	 	    <th>StaffId</th> 
	 		<th>Staff Name </th>	 		
	 		<th>City</th>
	 		<th>State </th>	 		
	 		
	 	</tr>
	 	
	 	<c:forEach var="temp" items="${staff}">
	 	
	 	
	 	<tr>
	 		<td>${temp.stfIid} </td>
	 		<td>${temp.staff_name}</td>
	 		<td>${temp.city}</td>
	 		<td>${temp.state} </td>
	 			 		
	 	</tr>
	 	
	 	</c:forEach>
	</table>
	
	</div>
	
	<div style="clear; both;"></div>
			
			<p>
			<a href="${pageContext.request.contextPath}/customer/list" >Back to Customer Main Page</a>
			</p>

	</div>
	
</div>


</body>


</html>