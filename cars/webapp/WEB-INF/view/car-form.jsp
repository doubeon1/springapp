<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html> 

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Nový automobil</title>
</head>

<body>

	<form:form action="?form" modelAttribute="car" method="POST">
	
		VIN: <form:input path="vin" />

		<br />
		<br />
	
		Model: <form:input path="model" />

		<br />
		<br />
	
		Registrační značka: <form:input path="regNum" />

		<br />
		<br />
		
		Nakoupeno: <form:input path="purchased" />

		<br />
		<br />
				
		Počáteční stav kilometrů: <form:input path="initKm" />

		<br />
		<br />

		<input type="submit" value="Submit" />

	</form:form>


</body>

</html>

