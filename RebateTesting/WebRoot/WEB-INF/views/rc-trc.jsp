
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
<title>ASRTU-Admin Page</title>
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

<link rel="stylesheet" href="resources/css/jquery-ui.css" />
<script src="resources/js/jquery-1.12.4.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<script>
  $(function () {
      $("#datepickerfrom").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerclear").datepicker({dateFormat: 'dd/mm/yy'});
  });
  </script>


<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">




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


</script>
<script type="text/javascript">
  
   function validateForm() {
	  
    var x = document.getElementById("vendorId").value;
    if (x == "") {
        alert("Please enter Vendor Name.");
        document.getElementById("vendorId").focus();
        return false;
    }
    
    var y = document.getElementById("itemGroupNameId").value;
    if (y == "") {
        alert("Please enter Item Group Name.");
        document.getElementById("itemGroupNameId").focus();
        return false;
    }
    var x = document.getElementById("statusId").value;
    if (x == "") {
        alert("Please enter Status.");
        document.getElementById("statusId").focus();
        return false;
    }
    
    var y = document.getElementById("datepickerclear").value;
    if (y == "") {
        alert("Please enter Clear Date.");
        document.getElementById("datepickerclear").focus();
        return false;
    }
    var x = document.getElementById("datepickerfrom").value;
    if (x == "") {
        alert("Please enter From Date.");
        document.getElementById("datepickerfrom").focus();
        return false;
    }
    var y = document.getElementById("remarks").value;
    if (y == "") {
        alert("Please enter Remarks.");
        document.getElementById("remarks").focus();
        return false;
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

					<div class="sec-title text-center white wow animated fadeInDown">


						<h3 align="center" style="color: red;">
							<c:out value="${message1}" />
						</h3>


						<form action="/rebatetest/saveRcTrc.html" method="post"
							class="register" onsubmit="return validateForm()">
							<fieldset class="row1">
								<legend>RC-TC Status </legend>


								<p>
									<label>Vendor Name </label>
									 <select name="vendorId" id="vendorId" onchange="populateItemGroupName()">
										<option value=0>--Please Select--</option>
										<c:forEach items="${vendors}" var="vendor">
											<option value="${vendor.vendorId}"><c:out
													value="${vendor.vendorName}"></c:out></option>
										</c:forEach>
									</select> <label>Item Group Name </label> <select name="itemCode"
										id="itemGroupNameId">

									</select> <input type="hidden" name="itemName" id="itemGroupCodeId">

								</p>


								<p>
									<label>Status </label> <select name="status" id="statusId">
										<option>--Please Select--</option>
										<option value="regular">Regular</option>
										<option value="provisional">Provisional</option>
										<option value="suspended">Suspended</option>
									</select> <label>Clear Date </label> <input type="text"
										id="datepickerclear" name="clearDate" />
								</p>
								<p>
									<label>From Date </label> <input type="text"
										id="datepickerfrom" name="fromDate" /> <label>Remarks
									</label>
									<textarea rows="3" cols="21" name="remarks" id="remarks"></textarea>

								</p>

							</fieldset>
							<div>
								<button type="submit" id="submit"
									class="btn btn-blue btn-effect">Save</button>
								<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
								<a href="listRcTrc.html" id="submit"
									class="btn btn-blue btn-effect">View</a> <a
									href="adminBack.html" id="submit"
									class="btn btn-blue btn-effect"> Back</a>

							</div>
	</main>

	<%@ include file="footer.jsp"%>

</body>
</html>







