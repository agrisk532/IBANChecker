<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IBAN check results</title>
</head>
<body bgcolor="#ffffcc">
<h3>IBAN check results</h3>
	<c:forEach var="iban" items="${results}">
	<c:choose>
		<c:when test="${fn:contains(iban, 'ok')}">
		<font style="color: green">${iban}</font><br>
		</c:when>
		<c:otherwise>
		<font style="color: red">${iban}</font><br>
		</c:otherwise>
	</c:choose>
	</c:forEach>
	<br>
    <form action="index.jsp" method="get">
    <input type="submit" value="Return">
</form>
</body>
</html>
