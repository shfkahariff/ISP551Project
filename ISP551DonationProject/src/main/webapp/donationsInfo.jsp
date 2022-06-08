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
	<% 
	String donationNo = request.getParameter("donationNo");
	String donationType = request.getParameter("donationType");
	String donationDate = request.getParameter("date");
	String donationTotal= request.getParameter("donationTotal");	
	%>
	
	Donation No: <%= donationNo %><br>
	Donation Type: <%= donationType %><br>
	Date: <%= donationDate %><br>
	Total: <%= donationTotal %><br>
</body>
</html>