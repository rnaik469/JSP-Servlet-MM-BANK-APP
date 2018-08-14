<!DOCTYPE html>
<html>
   <head>
      <title>Open New Account</title>
   </head>
   <style>
      label {
      color: white;
      }
      #current, #saving, #amount {
      display: none;
      }
   </style>
   <script>
	window.history.forward(1);
</script>
   <script type="text/javascript">
      function show(aval) {
    
      	if (aval == "sav") {
      		saving.style.display = 'inline-block';
      		amount.style.display = 'none';
      		current.style.display = 'none';
      	} else if (aval == "cur") {
      		saving.style.display = 'none';
      		amount.style.display = 'inline-block';
      		current.style.display = 'inline-block';
      	} else {
      		saving.style.display = 'none';
      		amount.style.display = 'none';
      		current.style.display = 'none';
      	}
      }
      function ShowHideDiv() {
          var chkYes = document.getElementById("nosal");
          var dvPassport = document.getElementById("amouunt");
          amount.style.display = chkYes.checked ? "block" : "none";
      }
      
   
      function check() {
    	    var Bdate = document.getElementById('dob').value;
    	      var amount= document.getElementById('amt').value;
    	      var ODL= document.getElementById('od').value;
    	      var chkYes = document.getElementById("nosal");
    	      var Yes = document.getElementById("sal");
    	      var dd = document.getElementById("type");
    	      var selectedItem = dd.options[dd.selectedIndex].value;
    	      
    	      var theBday = document.getElementById('resultBday');
    	     var ret=true;
    	      
    	     if(Math.floor((Date.now() - new Date(Bdate)) / (31557600000))<18){
    	      		alert("Age Must be 18 or greater");
    	      		ret= false;
    	      	} 
    	     else if(selectedItem=="ch"){
    	    	 alert("Select Account Type");
 	      		ret= false;
    	     }else if(selectedItem=="sav"){
    	    	 if(acc_add.c_salary.value == '') {
        	    	 alert("Error: Please select a radio button!");
        	    	 ret=false;
        	    	 }
    	    	 else if(chkYes.checked){
       	    	  if(amount<5000){
       	    		  alert("Amount Must be 5000 or greater");
       	      		ret= false;
       	    	  }
       	      	}  
    	     }
    	      	
    	      	else if(selectedItem=="cur"){
    	      		if(amount<1){
      				  alert("Amount Must be greater then 0");
      				  ret=false;
      			  }
    	      		else if(ODL<10000){
    				  alert("ODLimit Must be 10000 or greater");
    				  ret=false;
    			  }
    	      	}else{
    	      		ret=true;
    	      	}
    	      	
    	  	  return ret;
    		    	
    	      }
    
   </script>
   <body>
      <jsp:include page="header.jsp"></jsp:include>
      <div class="container">
         <div class="row justify-content-center">
            <div class="col-md-10">
               <div class="card shadow p-3 mb-5 rounded"
                  style="background-color: rgba(50, 50, 50, 0.8);">
                  <header class="card-header"
                     style="background-color: rgba(30, 144, 255, 0.1);">
                     <h3 class="card-title mt-2"
                        style="text-align: center; color: white;">Open New Account</h3>
                  </header>
                  <article class="card-body">
                     <form onsubmit="return check()" id="add" action="updateSuccess.app" name="acc_add" method="post">
                        <div class="form-row">
                       		<div class="col form-group">
                              <label>Customer ID</label> <input type="number" class="form-control" readonly="readonly"
                                required name="c_ID" value="${requestScope.updateCust.accountHolder.customerId}">
                           </div>
                              <div class="col form-group">
                              <label>Customer Name</label> <input type="text" class="form-control"
                                 placeholder="Enter Your Full Name"required name="c_Name" value="${requestScope.updateCust.accountHolder.customerName}">
                           </div> 
                           <div class="col form-group">
                              <label>AccountNumber</label>
                               <input type="number" class="form-control" readonly="readonly"  required name="accId" value="${requestScope.updateCust.accountNumber}" />
                           </div>  
                           </div>
              			      <div class="form-row">

                           <div class="col form-group">
                              <label>Email</label> <input type="email" class="form-control"
                                 placeholder="Enter Your Email" required name="c_Email" value=" ${requestScope.updateCust.accountHolder.emailId}">
                           </div>
                           <div class="col form-group">
                              <label>Contact Number</label> <input type="tel"
                                 pattern="[2-9]{1}[0-9]{9}" class="form-control"
                                 placeholder="Enter Contact Number" required name="c_contact" value="${requestScope.updateCust.accountHolder.contactNumber}">
                           </div>
                           <div class="col form-group">
                              <label>Date of Birth</label> <input type="date"
                                 class="form-control" required name="c_dob" id="dob" value="${requestScope.updateCust.accountHolder.dateOfBirth}">
                           </div>
                        </div>
                        
                      
                        <div class=" col form-row">
                           <div class="col form-group col-sm-6"> 
						     <input type="submit"  value="Update Information" class="btn btn-primary">
                              <input type="reset" value="clear" class="btn btn-light">
                           </div>
                        </div>
                     </form>
                  </article>
               </div>
            </div>
         </div>
      </div>
 <br/>
 <br/>
 <br/>
 <br/>
 <br/>
 <br/>
 
    <jsp:include page="footer.jsp"></jsp:include>
</body></html>