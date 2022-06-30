<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donation Details</title>
<style>
	h1{text-align: center;}
	h3{text-align: center;}
	.input {
  		width: 320px;
  		padding: 10px;
  		border: 5px solid gray;
  		margin: auto;
  		color: gray;
  		font-size: 16px;
	}


	.wrapper{ float: left; 
		width: 100%; 
		text-align: center; 
		position: relative; 
		top: 50%; left: 50%;
		 transform: translate(-50%, -50%); 
		 
		}

	
	.b1{
	
	display: inline-block;
	background-color: #4679A6;
  		border: none;
  		color: white;
  		padding: 16px 32px;
  		text-decoration: none;
  		margin: 4px 2px;
  		cursor: pointer;
  		font: 20px;
  		border-radius: 4px;
	}

</style>
</head>
<body>
	<h1>Donation Details</h1>
	
	<h3>Donation No </h3>
	<div class="input"><c:out value="${d.donationNo}"/></div>
	<h3>Donation Type</h3>
	<div class="input"><c:out value="${d.donationType}"/></div>
	<h3>Date</h3>
	<div class="input"><c:out value="${d.donationDate}"/></div>
	<h3>Total</h3>
	<div class="input">RM <c:out value="${d.donationTotal}"/> </div>
	
	<br><br>
	<div class="wrapper">
	<input type="button" class="b1" value="Back" onclick="location.href='ListDonationController';">
	<input type="button" class="b1" value="Home" onclick="location.href= 'donationHome.html';">
</div>
</body>
</html>