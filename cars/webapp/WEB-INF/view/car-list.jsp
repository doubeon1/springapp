<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Seznam automobilů</title>
</head>
<body>
	<p><strong>Seznam automobilů</strong></p>
	
	<c:if test="${not empty cars}">
		<table>

			<thead>
				<tr>
					<td>VIN</td>
					<td>Model</td>
					<td>Registrační značka</td>
					<td>Nakoupeno</td>
					<td>Počáteční stav km</td>
					<td />
					<td />
					<td>${pageContext.request.contextPath}<td/>
				</tr>
			</thead>


			<tbody>
				<c:forEach items="${cars}" var="car">
					<tr>
						<td>${car.vin}</td>
						<td>${car.model}</td>
						<td>${car.regNum}</td>
						<td><fmt:formatDate value="${car.purchased}" type="date"
								pattern="dd. MM. yyyy" /></td>
						<td>${car.initKm}</td>
						<td>Tankování</td>
						<td><a href="/cars/delete/${car.id}">Smazat</a></td>
						<td><a href="/cars/${car.id}?form">Upravit</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</c:if>
	
	<a href="?form">Přidat</a> 

</body>
</html>