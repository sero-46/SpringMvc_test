<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!Doctype html>
<html>

<head>

<title>  Add Page</title>

</head>
<body>


	<form:form action="saveCustomer" modelAttribute="customermodel" method="POST">
			
			First Name: <form:input path="firstname"/> 
				<br><br>
			Last Name: <form:input path="lastname"/>
				<br><br>
			Email: <form:input path="email"/>
				<br><br>
			<input type="submit" value="submit"/>
				<br><br>
			
	</form:form >


</body>


</html>	

	