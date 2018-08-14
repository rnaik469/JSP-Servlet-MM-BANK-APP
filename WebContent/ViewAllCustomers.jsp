<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table thead tr th {
	color:rgb(30,144,255);
}
</style>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container" >
<div class="row justify-content-center" >

<jstl:if test="${requestScope.viewcust.size() != 0 }">
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h3 class="card-title mt-2" style="text-align: center; color:white;">All Available Account</h3>
</header>
<table class="table table-striped table-dark col-md-12" style="background-color: rgba(50,50,50,0.8);">
  <thead>
    <tr>
      <th scope="col">CustomerID</th>
      <th scope="col">CustomerName</th>
      <th scope="col">AccountNumber</th>
      <th scope="col">Email ID</th>
      <th scope="col">PhoneNo</th>
      <th scope="col">DateOfBirth (YYYY/MM/DD)</th>
      <th scope="col">Update</th>
      
    </tr>
  </thead>
  <tbody>
     <jstl:forEach var="viewcust" items="${requestScope.viewcust}">
    <tr>
      <td>${viewcust.accountHolder.customerId}</td>
      <td>${viewcust.accountHolder.customerName}</td>
      <td>${viewcust.accountNumber}</td>
      <td>${viewcust.accountHolder.emailId}</td> 
      <td>${viewcust.accountHolder.contactNumber}</td>
     <td>${viewcust.accountHolder.dateOfBirth}</td>
     <td><a href="updateInfo.app?accId=${viewcust.accountNumber}">Update</a></td>
      
    </tr></jstl:forEach>
  </tbody>
</table></jstl:if></div></div>
<jstl:if test="${requestScope.viewcust.size() == 0 }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:red;text-align: center;">OOPS!!! Accounts not available yet</h5>
</header></div>
</jstl:if>
 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>