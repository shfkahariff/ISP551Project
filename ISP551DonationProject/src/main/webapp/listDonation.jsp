<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<th>Id</th>
			<th>Type</th>
			<th>Date</th>
			<th>Total (RM)</th>
			<th colspan="4">Action</th>
		</tr>
		<c:forEach items="${shawls}" var="s" varStatus="shawls">
		<tr>
			<td><c:out value="${s.id}"/></td>
			<td><c:out value="${s.type}"/></td>
			<td><c:out value="${s.date}"/></td>
			<td><c:out value="${s.total}"/></td>
			<td><a class="btn btn-primary" href="ViewDonationController?id=<c:out value="${s.id}"/>">View</a></td> 
			<td><a class="btn btn-primary" href="UpdateDonationController?id=<c:out value="${s.id}"/>">Update</a></td>
			<td><button class="btn btn-danger" id="<c:out value="${s.id}"/>" onclick="confirmation(this.id)">Delete</button></td>
		</tr>
		</c:forEach>
	</table>
	<script>
	function confirmation(id){
		course.log(id);
		var r = confirm("Are you sure you want to delete>");
		if (r == true){
			location.href - 'DeleteShawlController?id-' + id;
			alert("Donation successfully deleted");	
		} else{
			return false;
		}
	}
	</script>
</body>
</html>