<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Surau As Sakeenah - Update Donation </title>

<meta content="noindex, nofollow" name="robots">
<link rel="stylesheet" href="css/font-awesome.css"/>  
  <style>

    body {
        background-image: url("https://media.istockphoto.com/photos/top-view-of-open-hands-of-little-kids-and-their-young-parents-making-picture-id1172908218?k=20&m=1172908218&s=612x612&w=0&h=3LPildxYUg-voZFQeLUoCUHXC3uapfMYp7KHtYfjG4Q=");
    }
.main{ 
    
    margin:40px auto 20px !important; 
    width:450px;
   
}
.my_form{
    width:450px;
    padding:30px;
    margin:40px auto;
    background: #E5A186;
    border-radius: 4px;
    -webkit-border-radius:4px;
    -moz-border-radius: 4px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    -moz-box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    -webkit-box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}
.my_form .inner-wrap{
    padding: 30px;
    background: #E5A186;
    border-radius: 2px;
    margin-bottom: 15px;
}
.my_form h1{
    background: #E5A186;
    padding: 20px 30px 15px 30px;
    margin: -30px -30px 30px -30px;
    border-radius: 10px 10px 0 0;
    -webkit-border-radius: 10px 10px 0 0;
    -moz-border-radius: 10px 10px 0 0;
    color: #fff;
    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.12);
    font: normal 30px 'Bitter', serif;
    -moz-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
    -webkit-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
    box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
    border: 1px solid #E5A186;
}
.my_form h1 > span{
    display: block;
    margin-top: 2px;
    font: 13px Arial, Helvetica, sans-serif;
}
.my_form label{
    display: block;
    font: 13px Arial, Helvetica, sans-serif;
    color: #000;
    margin-bottom: 15px;
}
.my_form input[type="text"],
.my_form input[type="date"],


.my_form input[type="number"],

.my_form textarea,
.my_form select {
    display: block;
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    width: 100%;
    padding: 8px;
	margin:5px auto;
    border-radius: 2px;
    -webkit-border-radius:2px;
    -moz-border-radius:2px;
    border: 1px solid #CEF;
}

.my_form .section{
    font: normal 20px 'Bitter', serif;
    color:#000;
    margin-bottom: 5px;
}
.my_form .section span {
    background: #DB6551;
    padding: 5px 10px 5px 10px;
    position: absolute;
    border-radius: 50%;
    -webkit-border-radius: 50%;
    -moz-border-radius: 50%;
    border: 4px solid #fff;
    font-size: 14px;
    margin-left: -45px;
    color: #fff;
    margin-top: -3px;
}
.my_form input[type="button"], 
.my_form input[type="submit"]{
    background: #DB6551;
    padding: 8px 30px;
    border-radius: 2px;
	cursor:pointer;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    color: #fff;
    text-shadow: 1px 1px 3px rgba(0, 0, 0, 0.12);
    font: normal 30px 'Bitter', serif;
    -moz-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
    -webkit-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
    box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.17);
    border: 1px solid #DB6551;
    font-size: 15px;
}
.my_form input[type="button"]:hover, 
.my_form input[type="submit"]:hover{
    background: #DB6551;
    -moz-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.28);
    -webkit-box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.28);
    box-shadow: inset 0px 2px 2px 0px rgba(255, 255, 255, 0.28);
}
  </style>
</head>
<body>
<div class="main">
	
	<div class="my_form">
		<div class="section"><span> ! </span>Update Donation</div>
        <a href ="ListDonationController" style ="float:right; color: #000;" >  List Donation</a><br><br>
			<form action="UpdateDonationController" method="post">
		<div class="inner-wrap">
		<label>Donation Type:</label>
		<input type="text" name="donationtype" value="<c:out value="${d.donationtype}"/>"/><br>
		<label>Date:</label>
		<input type="date" name="donationdate" value="<c:out value="${d.donationdate}"/>"/><br>
		<label>Total:</label>
		<input type="text" name="donationtotal" value="<c:out value="${d.donationtotal}"/>"/><br>
		<input type="hidden" name="donationno" value="<c:out value="${d.donationno}"/>"/><br><br>
		</div>
		
		<div class="button-section">
		<input type="submit" value="Update">
		</div>
	</form>
	</div>
	
	</div>
</body>
</html>