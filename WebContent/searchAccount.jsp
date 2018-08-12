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

<jstl:if test="${sessionScope.viewcust.size() != 0 }">
<header class="card-header col-md-5" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:white;">Enter Account Number</h5>
	<form action="searchCust.app"><div class="input-group mb-3">
   <input type="search" id="amt"  class="form-control" placeholder="Enter Amount" required  name="acS">
  <div class="input-group-append">
    <span class="input-group-text" id="basic-addon2"><input type="submit" value="Search" style="border-style: none;"></span>
  </div>
</div></form>
</header></jstl:if>
<jstl:if test="${sessionScope.viewcust.size() == 0 }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:red;text-align: center;">OOPS!!! Accounts not available yet</h5>
</header></div>
</jstl:if>

</div>
<br/>
</div>

 <jsp:include page="footer.jsp"></jsp:include>
</body></html>