<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVA_Hometask</title>
</head>
<body bgcolor="#ffffcc">
<c:choose>
<c:when test="${param.selector=='single'}">
	<form action="IBANChecker">
  	<label for="iban">Enter IBAN:</label>&nbsp;
  	<input type="text" id="iban" name="iban" size="40">&nbsp;
  	<input type="submit" value="Submit">
  	<input type="button" value="Cancel" onclick="history.back()">
	</form>
</c:when>
<c:otherwise>
	<form action="IBANListChecker">
	<label for="filename">Choose file:</label>
	<input type="file" id="filename" name="filename" style="width:40em"><br>
	<input type="submit" value="Submit">
	</form>
</c:otherwise>
</c:choose>
</body>
</html>