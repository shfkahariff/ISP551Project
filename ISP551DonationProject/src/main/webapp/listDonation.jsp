<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>List Donation</title>
<style>
header {
    background-color: #E5A186;
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 15vh;
    box-shadow: 5px 5px 10px rgb(0,0,0,0.3);
}
h1 {
    letter-spacing: 1.5vw;
    font-family: 'system-ui';
    text-transform: uppercase;
    text-align: center;
}
</style>
</head>
<body>
<header>
        <h1>Surau As Sakeenah</h1>
</header>
<a href="addDonation.jsp">Create Donation</a><br><br>
	
		<table border="1">
			<tr>
				<th>Donation No</th>
				<th>Donation Type</th>
				<th>Date</th>
				<th>Total</th>
				<th colspan="3">Action</th>
			</tr>
			<c:forEach  items="${donations}" var="d" varStatus="donations">
			<tr>
				<td><c:out value="${d.donationNo}" /></td>
				<td><c:out value="${d.donationType}" /></td>
				<td><c:out value="${d.donationDate}" /></td>
				<td><c:out value="${d.donationTotal}" /></td>
							
				<td><a class="btn btn-primary" href="ViewDonationController?donationNo=<c:out value="${d.donationNo}"/>">View</a></td>
				<td><a class="btn btn-primary" href="UpdateDonationController?donationNo=<c:out value="${d.donationNo}"/>">Update</a></td>
				<td><a class="btn btn-primary" href="DeleteDonationController?donationNo=<c:out value="${d.donationNo}"/>">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
		
		<input type="button" class="b" value="Back" onclick="location.href='donationHome.html';">
		<input type="button" class="b" value="Add New Donation" onclick="location.href= 'addDonation.jsp';">
	
			
</body>
</html>