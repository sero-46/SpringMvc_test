<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!Doctype html>
<html>

<head>

<title>  Add Page</title>
<link  type="text/css"
	   rel="stylesheet"
	   href="${pageContext.request.contextPath}/resources/css/style.css"/>

<link type="text.css"
	  rel="stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/> 
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2> Customer Add Form   </h2>
	</div>
</div>

<div id="container">
	<div id="content">

	 <form:form action="saveCustomer" modelAttribute="customermodels" method="POST">
			
				<table>
					<tbody>
						<tr>
							 <td><label>First Name: </label></td>
							 <td><form:input path="firstname" /></td> 
							
						</tr>
						
						<tr>	
							<td><label>Last Name: </label></td>
							<td><form:input path="lastname" /></td>
						</tr>
						
						<tr>	
							<td><label>Email: </label></td>
							<td><form:input path="email" /></td>
						</tr>
						
						<tr>	
							<td><label></label></td>
							<td><form type="submit" value="submit" class="save" /></td>
						</tr>	
							
						
					</tbody>
				</table> 
				
				<input type="submit" value="submit"/>
			</form:form>	 
								
			<div style="clear; both;"></div>
			
			<p>
			<a href="${pageContext.request.contextPath}/customer/list" >Back to Customer Main Page</a>
			</p>

			</div>
</div>
</body>
</html>	

		