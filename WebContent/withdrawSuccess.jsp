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
<script>
	window.history.forward(1);
</script>
</style>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container" >
	<jstl:if test="${requestScope.viewcust != null }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:white;">Transaction Successful</h5>
	<b style="color:white;">Name:<b style="color:cyan;text-transform: capitalize;"> ${viewcust.accountHolder.customerName }</b></b><br/>
	<b style="color:white;">Account Number:<b style="color:cyan; "> ${viewcust.accountNumber}</b></b><br/>
	<b style="color:white;">Account Balance:<b style="color:cyan;"> ${viewcust.accountBalance}</b></b>
	
</header>
	
<table class="table table-bordered table-striped table-dark col-md-12" style="background-color: rgba(50,50,50,0.8);">
  <thead>
    <tr>
      <th scope="col">Value</th>
      <th></th>
      <th scope="col">Number of notes</th>
       <th></th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
    <jstl:forEach var="note" items="${requestScope.deno}">
    <tr>
   
    
      <td>${note.getKey()}</td>
      <td>*</td>
      <td>${note.getValue()}</td>
      <td>=</td>
      <td>${note.getKey() * note.getValue()}</td>
     
    </tr>
    </jstl:forEach>
    
    <tr>
    
    <td> Total</td>
    <td></td>
    <td><b style="color:lightgreen;">${requestScope.toatlNotes}</b></td>
    <td></td>
    <td><b style="color:lightgreen;">${requestScope.amount}</b></td> 
    </tr>
    </tbody>
</table>
</div>
<jstl:forEach var="note" items="${requestScope.deno}">
</br>
</jstl:forEach>
    
</jstl:if>
<jstl:if test="${requestScope.viewcust == null }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:red;text-align: center;">Customer Not Found or Insufficient Balance</h5>
</header></div>
</jstl:if>
</div><jsp:include page="footer.jsp"></jsp:include>
</body>

</html>