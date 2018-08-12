<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	window.history.forward(1);
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" >
<jstl:if test="${sessionScope.transfer == true}">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8); ">
	<br/>
	<br/>
	<br/>
	<br/>
	<h5 class="card-title mt-2" style="margin-left: 35%;color:lawngreen; ">Successfully transfered... </h5>
	<h3><span style="color:white;margin-left: 20%;text-align: center;"><b style="color:lightgreen;">Rs. ${sessionScope.amount}</b>  from Account Number  <b style="color:red;">${sessionScope.sender}</b> to <b style="color:palegreen;">${sessionScope.reciever}</b> </span> </h3>
	<br/>
	<h5 class="card-title mt-2" style="margin-left:20%;color:white; ">Remarks: ${sessionScope.remarks} </h5>
	<br/>
	<a href="index.jsp" style="margin-left: 38%;text-align: center;" class="btn btn-light btn-sm	">Click here to go home</a>
	<br/>
	<br/>
	<br/>
	<br/>
</header>
</div></jstl:if>
<jstl:if test="${sessionScope.transfer == false }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:red;text-align: center;">Customer Not Found</h5>
	<a href="WithdrawForm.jsp" style="margin-left: 38%;text-align: center;" class="btn btn-light btn-lg">Click here to go back</a>
</header></div>
</jstl:if>
</div>
 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>