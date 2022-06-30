<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

<h1>hello world</h1>
	Donation No: <c:out value="${param.donationNo}"/><br>
	Donation Type: <c:out value="${param.donationType}"/><br>
	Date: <c:out value="${param.donationDate}"/><br>
	Total: <c:out value="${param.donationTotal}"/><br>
</body>
</html>