<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Create Donation</title>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<style>
     *{
     font-family: Georgia, serif;
      }
      html, body {
      min-height: 100%;
      }
      header {
      background-color: #E5A186;
      color: white;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 15vh;
      box-shadow: 5px 5px 10px rgb(0,0,0,0.3);
      }
      body, div, form, input, select, textarea, label, p { 
      padding: 0;
      margin: 0;
      outline: none;
      font-size: 14px;
      color: #666;
      line-height: 22px;
      }
      body{
      background-color:#f3c3b0;
      }
      textarea {
      width: calc(100% - 12px);
      padding: 5px;
      }
      .testbox {
      display: flex;
      justify-content: center;
      align-items: center;
      height: inherit;
      padding: 20px;
      }
      form {
      width: 60%;
      padding: 60px;
      border-radius: 6px;
      background: #ebebe0;
      box-shadow: 0 0 8px  #669999; 
      }
      
      .banner {
      position: relative;
      height: 300px;
      background-image: url("https://briarpatchmagazine.com/images/made/varimages/articles/_resized/Ashjaee-web_1200_675_90_s_c1_c_c.jpg");  
      background-position: center center;
      background-repeat: no-repeat;
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      text-align: center;
      }
      .banner::after {
      content: "";
      background-color: rgba(0, 0, 0, 0.2); 
      position: absolute;
      width: 100%;
      height: 100%;
      }
      input, select, textarea {
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
      }
      input {
      width: calc(100% - 10px);
      padding: 5px;
      vertical-align: middle;
      }
      select {
      width: 100%;
      padding: 7px 0;
      border-radius: 3px;
      border: 1px solid #ccc;
      background: white;
      }
      input[type="date"] {
      padding: 4px 5px;
      }
      textarea {
      width: calc(100% - 12px);
      padding: 5px;
      }
      .item:hover p, .item:hover i, .question:hover p, .question label:hover, input:hover::placeholder {
      color:  #669999;
      }
      .item input:hover, .item select:hover, .item textarea:hover {
      border: 1px solid transparent;
      box-shadow: 0 0 3px 0  #669999;
      color: #669999;
      }
      .item {
      position: relative;
      margin: 10px 0;
      }
      .item span {
      color: red;
      }
      .colums {
      display:flex;
      justify-content:space-between;
      flex-direction:row;
      flex-wrap:wrap;
      
      }
      .colums div {
      width:100%;
      }
      input[type="date"]::-webkit-inner-spin-button {
      display: none;
      }
      .item i, input[type="date"]::-webkit-calendar-picker-indicator {
      position: absolute;
      font-size: 20px;
      color:  #a3c2c2;
      }
      .item i {
      right: 1%;
      top: 30px;
      z-index: 1;
      }
      label.radio {
      position: relative;
      display: inline-block;
      margin: 5px 20px 15px 0;
      cursor: pointer;
      }
      .question span {
      margin-left: 30px;
      }
      .question-answer label {
      display: block;
      }
      .flax {
      display:flex;
      justify-content:space-around;
      }
      .btn-block {
      margin-top: 10px;
      text-align: center;
      }
      button {
      width: 150px;
      padding: 10px;
      border: none;
      border-radius: 5px; 
      background:  #669999;
      font-size: 16px;
      color: #fff;
      cursor: pointer;
      }
      button:hover {
      background:  #a3c2c2;
      }
      @media (min-width: 568px) {
      }
      h1 {
      letter-spacing: 1.5vw;
      font-family: 'system-ui';
      text-transform: uppercase;
      text-align: center;
      }
      a {
      color: black;
      }
</style>
</head>
<body>
  <header>
        <h1>Surau As Sakeenah</h1>
  </header>
  
    <div class="testbox">
      <form action="CreateDonationController" method="post">
        <div class="banner">
          <h1>Create New Donation</h1>
        </div>
        <a href="listDonation.jsp">List Donation</a><br><br>
        <div class="colums">
          <div class="item">
          </div>
          <div class="item">
            <label for="donationType">Donation Type<span>*</span></label>
            <input type="text" id="donationtype" name="donationtype" required><br>
          </div>
          <div class="item">
            <label for="donationDate">Date<span>*</span></label>
            <input type="date" id="donationdate" name="donationdate">
          </div>
          <div class="item">
            <label for="donationTotal">Total<span>*</span></label>
            <input id="donationtotal" type="text" name="donationtotal" min="1" step="any" required/>
          </div>
          <button type="submit" value="save">Save</button>
          <button type="reset" value="reset">Reset</button>
		  <input type="button" value="Back" class="b" onclick="location.href='donationHome.html';">
        </div>
      </form>
    </div>
  </body>
</html>