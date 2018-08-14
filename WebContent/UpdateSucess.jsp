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
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:green;text-align: center;">Customer Details Successfully Updated</h5>
<br/>
	<br/>
	<a href="searchCust.app?acS=${requestScope.updatesuccess.accountNumber}" style="margin-left: 38%;text-align: center;" class="btn btn-light btn-lg">Click here to view updated Details</a>
	<br/>
	<br/>
</header></div>

</div>

 <jsp:include page="footer.jsp"></jsp:include>
</body></html>