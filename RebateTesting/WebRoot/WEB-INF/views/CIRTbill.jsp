<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>

    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="java.util.*" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.Calendar" %>  
     <%
    	pageContext.setAttribute("contextPath", request.getContextPath()+"/");
    %>
      
    	<!-- meta character set -->
        <meta charset="utf-8">
		<!-- Always force latest IE rendering engine or request Chrome Frame -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>ASRTU-Rebate</title>		
		<!-- Meta Description -->
        <meta name="description" content="Blue One Page Creative HTML5 Template">
        <meta name="keywords" content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
        <meta name="author" content="Muhammad Morshed">
		
		
		<!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- CSS
		================================================== -->
		
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
		
		<!-- Fontawesome Icon font -->
		<link rel="stylesheet" href="resources/css/login.css">
		<link rel="stylesheet" href="resources/css/form.css">
        <link rel="stylesheet" href="resources/css/font-awesome.min.css">
		<!-- bootstrap.min -->
        <link rel="stylesheet" href="resources/css/jquery.fancybox.css">
		<!-- bootstrap.min -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
		<!-- bootstrap.min -->
        <link rel="stylesheet" href="resources/css/owl.carousel.css">
		<!-- bootstrap.min -->
        <link rel="stylesheet" href="resources/css/slit-slider.css">
		<!-- bootstrap.min -->
        <link rel="stylesheet" href="resources/css/animate.css">
		<!-- Main Stylesheet -->
        <link rel="stylesheet" href="resources/css/main.css">

		<!-- Modernizer Script for old Browsers -->
        <script src="resources/js/modernizr-2.6.2.min.js"></script>
        
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
 <script>
  $(function () {
      $("#datepickerfrom").datepicker({dateFormat: 'dd/mm/yy'});
  });
 </script>

<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>




<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">

 function populateItemGroupName() {
	
	//alert(1);
	
	var vendorId = document.getElementById('vendorId').value;
	
	//alert(vendorId);
	 
    AjaxHelper.getItemGroupByVendorID(vendorId, populateItemGroupNameCallback); 
}  

function populateItemGroupNameCallback( data ) {
	

	//window.alert("Data  "+data);    
	
	document.getElementById("itemGroupNameId").innerHTML = data;


}
 	function populateItemCode() {
	
	var itemCodeId = document.getElementById('itemCodeId').value;
	  
    AjaxHelper.getItemNameId(itemCodeId, populateGroupCodeCallback);       
}        


function populateGroupCodeCallback( data ) {
    
	//window.alert("Data  "+data);
	 document.getElementById('itemNameId').value = data;
	       
}

function populateVendorCode() {
	
	var vendorNameId = document.getElementById('vendorId').value;
	//window.alert("Data  "+vendorNameId);
	AjaxHelper.getVendorNameById(vendorNameId, populateVendorCodeCallback);
	

} 

function populateVendorCodeCallback( data ) {

	//window.alert("Data  "+data);
	dwr.util.setValue('vendorName',data);

}


function validateForm() {
    var x = document.forms["myForm"]["transId"].value;
    var y = document.forms["myForm"]["billNo"].value;
    var amount = document.forms["myForm"]["billAmount"].value;
    if (x == null || x == "") {
        alert("Transation Id must be filled");
        return false;
    }
    else if (y == null || y == "") {
        alert("Bill must be filled.");
        return false;
    }
    else if(amount == null || amount == ""){
    	alert("Amount must be filled.");
    }
    
}

function submitForm(){
	//alert(1);
  //this.selectInsuranceForm.submit

  var pageAction = document.getElementById("pageActionID");
  pageAction.value="refreshPage";
  // alert(pageAction.value);
  document.forms.cirtForm.submit();
}

</script>
<script type="text/javascript">
  
  function validateForm() {
	  

    var x = document.getElementById("transId").value;
    if (x == "") {
        alert("Please enter Transaction Id.");
        document.getElementById("transId").focus();
        return false;
    }
    
    var y = document.getElementById("billNoId").value;
    if (y == "") {
        alert("Please enter CIRT bill No.");
        document.getElementById("billNoId").focus();
        return false;
    }
    
    var x = document.getElementById("datepickerfrom").value;
    if (x == "") {
        alert("Please enter CIRT bill Date.");
        document.getElementById("datepickerfrom").focus();
        return false;
    }
    
    var y = document.getElementById("billAmountId").value;
    if (y == "") {
        alert("Please enter CIRT bill Amount.");
        document.getElementById("billAmountId").focus();
        return false;
    }	
    var x = document.getElementById("vendorId").value;
    if (x == "") {
        alert("Please enter Vendor Name.");
        document.getElementById("vendorId").focus();
        return false;
    }
    
    var y = document.getElementById("itemCodeId").value;
    if (y == "") {
        alert("Please enter Item Name.");
        document.getElementById("itemCodeId").focus();
        return false;
    }
    var x = document.getElementById("testChargeId").value;
    if (x == "") {
        alert("Please enter CIRT Test Charge.");
        document.getElementById("testChargeId").focus();
        return false;
    }
    
    var y = document.getElementById("stuNoId").value;
    if (y == "") {
        alert("Please enter STO No.");
        document.getElementById("stuNoId").focus();
        return false;
    }
    var x = document.getElementById("asrtRefNoId").value;
    if (x == "") {
        alert("Please enter ASRTU Reference No.");
        document.getElementById("asrtRefNoId").focus();
        return false;
    }
    
    var y = document.getElementById("remarksId").value;
    if (y == "") {
        alert("Please enter Remarks.");
        document.getElementById("remarksId").focus();
        return false;
    }
  }
  </script>

 </head>
	
    <body id="body">

        <!--
        Fixed Navigation
        ==================================== -->
        
        <%@ include file="header.jsp" %>

        <!--
        End Fixed Navigation
        ==================================== -->
		
		<main class="site-content" role="main">
		
		<section id="social" class="parallax">
				<div class="overlay">
					<div class="container">
						<div class="row">

							<div class="sec-title text-center white wow animated fadeInDown">
						
						 <h3 align="center" style="color: red;"><c:out value="${message1}"/></h3>
	<!-- 					
<h2 align="center" style="color: white;">CIRT</h2> -->
<form action="/rebatetest/saveCirt.html" method="post" class="register"  name="cirtForm" onsubmit="return validateForm()">
<fieldset class="row1">
                <legend>CIRT
                </legend>
              
                <p>
                
                              <label>STO No.
                    </label>
                   <input type="text" name="stoNo" id="stuNoId" value="${sto.stoNo}"  />
                   
                                                         <label>STO Code
                    </label>
                    <input type="text" name="stoId" id="stoId"   value="${sto.stoId}"  onchange="submitForm();"/> 
 
                  </p>
 
 <p>                   
                      <label>CIRT bill No.</label>
                      
                      <input type="text" name="billNo" id="billNoId"/>   
                      </p>             
 
                 
               <p>
                    <label>CIRT Bill Date
                    </label>
               <input type="text" name="billDate" id="datepickerfrom"/>
                   <label>CIRT Bill Amount
                    </label>
                     <input type="text" name="billAmount" id="billAmountId"/>
                  </p>
               
               <p>
                                 <label>Vendor Name
                    </label>
        <input type="text" name="vendorName" id="vendorId"  value="${sto.vendorName}" READONLY/>
                   
  <label>Item Name 
                    </label>
       				<input type="text" name="itemName" id="itemNameId" value="${sto.itemName}" READONLY />
				</p>

	 				   
                   <p>
      
                    <label>CIRT Test Charge
                    </label>
            		<input type="text" name="testCharge"  id="testChargeId" value="${sto.testCharge}" READONLY/>
                  
                  </p>
              
                  <p>
                  <label>
                  ASRTU Reference No. 
                  </label>
                  <input type="text" name="asrtRefNo" id="asrtRefNoId"/>
                    <label>Remarks
                    </label>
            		 <textarea rows="3" cols="21" id="remarksId" name="remarks" ></textarea>
                   
                  </p>
				 <input type="hidden" name="pageAction" value="" id="pageActionID">
				 <input type="hidden" name="vendorId"  value="${sto.vendorId}">
				 <input type="hidden" name="itemCode"  value="${sto.itemCode}">
	
                   </fieldset>
                <div>
   		<p>
								<h3 align="center" style="color: red;">
									<c:out value="${successMessage}" />
								</h3>
								</p>      
          <button type="submit"  id="submitID" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submitID" class="btn btn-blue btn-effect">Reset</button>

	<a href="listCirt.html" id="submitID" class="btn btn-blue btn-effect">View</a>
	<a href="adminBack.html"  id="submitID" class="btn btn-blue btn-effect">Back</a>
	
		   </div>
</form>
</div>	
	
						</div>
					</div>
				</div>
			</section> 
		
 
		</main>
		
		        <%@ include file="footer.jsp" %>
		
    </body>
		
		
    </body>
</html>



