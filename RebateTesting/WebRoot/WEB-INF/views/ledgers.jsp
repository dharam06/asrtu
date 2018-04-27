
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Calendar"%>

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
<meta name="keywords"
	content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
<meta name="author" content="Muhammad Morshed">

<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS
		================================================== -->

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700'
	rel='stylesheet' type='text/css'>

<!-- Fontawesome Icon font -->
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/formRebate.css">
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

<link rel="stylesheet" href="resources/css/jquery-ui.css" />
<script src="resources/js/jquery-1.12.4.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<style>
.datepicker {
	
}
</style>

<script>
  $(function() {
    $( ".datepicker" ).datepicker({dateFormat: 'dd/mm/yy'});
  });

  </script>


<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
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
    
	window.alert("Data  "+data);
	 document.getElementById('itemNameId').value = data;
	       
}

function populateVendorCode() {
	
	var vendorNameId = document.getElementById('vendorId').value;
	window.alert("Data  "+vendorNameId);
	AjaxHelper.getVendorNameById(vendorNameId, populateVendorCodeCallback);
	

} 

function populateVendorCodeCallback( data ) {

	window.alert("Data  "+data);
	dwr.util.setValue('vendorName',data);

}

function populateBankCode() {
	
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {
	
	//dwr.util.setValue('bankCodeId',data);
	document.getElementById('bankCodeId').value= data;
       
}
function populateBankCode() {
	
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {
	

	//window.alert("Data  "+data);    

	dwr.util.setValue('bankCodeId',data);
       
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

</script>


</head>

<body id="body">

	<!--
        Fixed Navigation
        ==================================== -->
	<%@ include file="header.jsp"%>
	<!--
        End Fixed Navigation
        ==================================== -->

	<main class="site-content" role="main">

	<section id="social" class="parallax">
		<div class="overlay">
			<div class="container">
				<div class="row">


					<div class="sec-title text-center white wow animated fadeInDown"> Ledger Reports
					</div>
					
										<form action="#" name="myForm" method="post"
						onsubmit="return validateform() " class="register">
					
					<p>
					<a href="rebateledger.html"
							class="btn btn-blue btn-effect">Rebate Ledger</a></p>
							
							<p>
					<a href="interestrebateledger.html"
							class="btn btn-blue btn-effect">interest rebate ledger Report</a></p>
							
							<p>
					<a href="interestservicetaxledger.html"
							class="btn btn-blue btn-effect">interest service tax ledger Report</a></p>
							
							
							<p>
					<a href="incentiveledger.html"
							class="btn btn-blue btn-effect">incentive ledger</a></p>
							
											<p>
					<a href="rebatereconciliationledger.html"
							class="btn btn-blue btn-effect">rebate reconciliation ledger</a></p>
												
									<p>
					<a href="stuinformationledger.html"
							class="btn btn-blue btn-effect">stu information ledger</a></p>
												
									<p>
					<a href="nodalofficerstatement.html"
							class="btn btn-blue btn-effect">nodal officer statement</a></p>
							
							<p>
					<a href="abstractnodalofficerstatement.html"
							class="btn btn-blue btn-effect">abstract nodal officer statement</a></p>
							
							
							<p>
					<a href="vendorinformationledger.html"
							class="btn btn-blue btn-effect">vendor information ledger</a></p>
												
			
			
			
							
													<a
									href="adminBack.html" id="submit"
									class="btn btn-blue btn-effect">Back</a>

							</div>
							
							
							
							
							
							
					</form>
					
					
	</div>
	</div>
	</div>
	</section>
	</main>



	<%@ include file="footer.jsp"%>


</body>
</html>
