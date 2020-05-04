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
	<h2>  Customer Background Information </h2>
	
	</div>
</div>

<div id="container">
	<div id="content">
	
	<input type="button" value="Add Customer"
		   onclick="window.location.href='showAddForm';return false;"
		   class="add-button"
	/>
	<br><br>
	
	<form:form action="search" method="GET">
                Search customer: <input type="number" name="theSearchId" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
	
	<table>
	 	<tr>
	 		<th>First Name </th>
	 		<th>Last Name </th>
	 		<th>Email </th>	 
	 		<th>Action</th>		
	 	</tr>
	 	
	 	<c:forEach var="temp" items="${customers_message}">
	 	
	 	<c:url  var="updateLink" value="/customer/showUpdateForm">
	 		<c:param name="customerId" value="${temp.id}"/>
	 	</c:url>
	 	
	 	<c:url  var="deleteLink" value="/customer/delete">
	 		<c:param name="customerId" value="${temp.id}"/>
	 	</c:url> 
	 	
	 	<tr>
	 		<td>${temp.firstname}</td>
	 		<td>${temp.lastname}</td>
	 		<td>${temp.email} </td>
	 		<td> <a href="${updateLink}">UPDATE</a>|
	 		<a href="${deleteLink}"
	 		  onclick="if(!(confirm('Are you sure you want to delet this customer>'))) return false"
	 		>DELETE</a>
	 		
	 		</td>
	 	</tr>
	 	
	 	</c:forEach>
	</table>
	
	</div>
</div>


</body>


</html>