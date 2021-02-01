<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Seznam tankování</title>
</head>
<body>
	<p>
		Seznam tankování pro <strong>${car.model} (${car.regNum})</strong>
	</p>
	
	<c:if test="${not empty refuelings}">
		<table>
			<thead>
				<tr>
					<td>Datum tankování</td>
					<td>Jednotková cena</td>
					<td>Množství</td>
					<td>Celkem</td>
					<td>Stav km</td>
					<td>Benz. stanice</td>
					<td>Druh paliva</td>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${refuelings}" var="refueling">
					<tr>
						<td><fmt:formatDate value="${refueling.refDate}" type="date"
								pattern="dd. MM. yyyy" /></td>
						<td>${refueling.price}</td>
						<td>${refueling.amount}</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="2" value="${refueling.amount.multiply(refueling.price)}" /></td>
						<td>${refueling.km}</td>
						<td>${refueling.location}</td>
						<td>${refueling.fuel}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	
	<a href="?form">Přidat</a> 
	
</body>
</html>