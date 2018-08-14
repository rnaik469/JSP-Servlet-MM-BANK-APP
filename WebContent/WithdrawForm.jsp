  
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Withdrawl</title>
<script>
	window.history.forward(1);
</script>
</head>
<style>
label {
	color: white;
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row justify-content-center">
		
<jstl:if test="${requestScope.viewcust.size() != 0 }">
			<div class="col-md-10">
				<div class="card shadow p-3 mb-5 rounded"
					style="background-color: rgba(50, 50, 50, 0.8);">
					<header class="card-header"
						style="background-color: rgba(30, 144, 255, 0.1);">
						<h3 class="card-title mt-2"
							style="text-align: center; color: white;">Withdraw</h3>
					</header>
					<article class="card-body">
						<form action="withdraw.app">
							<div class="form-row">
								<div class="col form-group">
									<label>Account Number</label> <input type="number" class="form-control"
										placeholder="Enter Account Number"required name="acNo">
								</div>
								<div class="col form-group">
									<label>Amount to be Withdrawl</label> <input type="number" class="form-control"
										placeholder="Enter Amount" required name="amt">
								</div>
								
							</div>
					
							<div class=" col form-row">

								<div class="col form-group col-sm-6">
									<input type="submit" value="Withdraw" class="btn btn-primary ">
									<input type="reset" value="clear" class="btn btn-light">
								</div>



							</div>
						</form>
					</article>
				</div>
				</div> 
		</jstl:if>
		<jstl:if test="${requestScope.viewcust.size() == 0 }">
<div class="row justify-content-center" >
<header class="card-header col-md-12" style="background-color:rgba(50,50,50,0.8);">
	<h5 class="card-title mt-2" style="color:red;text-align: center;">OOPS!!! Accounts not available yet</h5>
</header></div>
</jstl:if>

		
		</div> 
	</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>