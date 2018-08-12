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
	<jstl:if test="${sessionScope.searchCust != null }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:white;">Account Details of</h5>
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
    <tr>
      <td>${sessionScope.searchCust.accountHolder.customerId}</td>
      <td>${sessionScope.searchCust.accountHolder.customerName}</td>
      <td>${sessionScope.searchCust.accountNumber}</td>
      <td>${sessionScope.searchCust.accountHolder.emailId}</td> 
      <td>${sessionScope.searchCust.accountHolder.contactNumber}</td>
     <td>${sessionScope.searchCust.accountHolder.dateOfBirth}</td>
     <td><a href="">Update</a></td>
    </tr></tbody>
</table>
</div></jstl:if>
<jstl:if test="${sessionScope.searchCust == null }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:red;text-align: center;">Customer Not Found</h5>
</header></div>
</jstl:if>
</div>

 <jsp:include page="footer.jsp"></jsp:include>
</body></html>