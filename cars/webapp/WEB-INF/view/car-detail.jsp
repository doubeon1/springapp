<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Detail automobilu</title>
</head>
<body>
	<p><strong>Detail automobilu</strong></p>
	<table>
		<tr>
			<td>VIN</td>
			<td>${car.vin}</td>
		</tr>

		<tr>
			<td>Model</td>
			<td>${car.model}</td>
		</tr>
		<tr>
			<td>Registrační značka</td>
			<td>${car.regNum}</td>
		</tr>
		<tr>
			<td>Nakoupeno</td>
			<td><fmt:formatDate value="${car.purchased}" type="date"
					pattern="dd. MM. yyyy" /></td>
		</tr>
		<tr></table>
</body>
</html>