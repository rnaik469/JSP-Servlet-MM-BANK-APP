<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>

<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jq1.js"></script>
<style>


</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<br/>
<br/>
<br/>
<br/>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-10">
				<div class="card shadow p-3 mb-5 rounded"
					style="background-color: rgba(50, 50, 50, 0.8);">
					<article class="card-body">
					
					<div class="form-row">
								
							<div class="col form-group">	<a href="AddNewAccount.jsp" class="btn btn-block btn-lg  " style="background-color: rgba(30, 144, 255, 0.5);color:white;">
							 <span class="texto_grande" >Open New Account</span></a></div>
							<div class="col form-group"><a href="viewaccount.app"  class="btn btn-block btn-lg  " style="background-color: rgba(30, 144, 255, 0.5);color:white;">
							 <span class="texto_grande">View All Accounts</span></a></div>
							<div class="col form-group"><a href="viewcust.app" class="btn btn-block btn-lg  "style="background-color: rgba(30, 144, 255, 0.5);color:white;" >
							 <span class="texto_grande">View All Customers</span></a></div>
						</div><div class="form-row">
							<div class="col form-group">	<a href="WithdrawForm.jsp" class="btn btn-block btn-lg  " style="background-color: rgba(30, 144, 255, 0.5);color:white;">
							 <span class="texto_grande">Withdraw</span></a></div>
							<div class="col form-group"><a href="DepositForm.jsp" class="btn btn-block btn-lg  "style="background-color: rgba(30, 144, 255, 0.5); color:white;" >
							 <span class="texto_grande">Deposit</span></a></div>
							<div class="col form-group">
							<a href="FundTransfer.jsp" class="btn btn-block btn-lg  " style="background-color: rgba(30, 144, 255, 0.5); color:white;"> 
							<span class="texto_grande">Fund Transfer</span></a></div>
						<div class="col form-group">
							<a href="searchAccount.jsp" class="btn btn-block btn-lg  " style="background-color: rgba(30, 144, 255, 0.5); color:white;"> 
							<span class="texto_grande">Search by Account No</span></a></div>
						

						</div>
			</article>

				</div>
			</div>

		</div>


	</div>
							
						


 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>