
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


					<div class="sec-title text-center white wow animated fadeInDown">
					</div>
					<form action="/rebatetest/saveInvoice.html" name="myForm" method="post"
						onsubmit="return validateform() " class="register">
						<fieldset class="row1">
							<legend>Edit Invoice :: ${invoice.invoiceNumber} </legend>
							<input type="hidden" name="invoiceNumber" id="invoiceNumberId" value="${invoice.invoiceNumber}"/>

							<p>
								<label>Invoice Date </label> <input
									type="text" id="datepickerto" name="invoiceDate" value="${invoice.invoiceDateString}"
									class="datepicker" />

</p>
<p>

								<label>Vendor Name </label> <select name="vendorCode"
									id="vendorId" onchange="populateItemGroupName()">
									<option value=0>--Please Select--</option>
									<c:forEach items="${vendor}" var="vendor">
													<option value="${vendor.vendorId}" ${vendor.vendorId == invoice.vendorCode ? 'selected' : ' '}><c:out value="${vendor.vendorName}"></c:out></option>

									</c:forEach>
									
									
									
									
								</select> 
								<label>Item Name </label> <select name="itemCode"
									id="itemGroupNameId">
<option value=0>--Please Select--</option>
			<c:forEach items="${items}" var="item">
			<option value="${item.itemCode}" ${item.itemCode == invoice.itemCode ? 'selected' : ' '}><c:out value="${item.itemName}"></c:out></option>
			</c:forEach>
								</select> <input type="hidden" name="itemName" id="itemNameId" />

</p>
<p>

						
								<label>Quarter From Date </label> <input type="text"
									name="quarterFromDate" class="datepicker" value="${invoice.quarterFromDateString}"/> 
									
									<label>Quarter To Date </label> <input type="text" name="quarterToDate" value="${invoice.quarterToDateString}"
									class="datepicker" />
</p>
<p>

							<label>Rebate Type</label><select name="rebateType"
									id="regularRebateId">
									<option value="Regular Rebate" ${'Regular Rebate' == invoice.rebateType ? 'selected' : ' '}>Regular Rebate</option>
									<option value="Rebate Reconciliation" ${'Rebate Reconciliation' == invoice.rebateType ? 'selected' : ' '}>Rebate Reconciliation</option>
									
								</select> 

								<label>Amount</label> <input type="text"
									name="rebateOutstanding"  READONLY value="${invoice.rebateOutstanding}"/> <br />
								<br />
							</p>
							<div> 

								<p>
								<h3 align="center" style="color: red;">
									<c:out value="${successMessage}" />
								</h3>
								</p>

								<button type="submit" id="submit"
									class="btn btn-blue btn-effect">Save</button>
								<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
								<a href="viewInvoiceList.html" id="submit"
									class="btn btn-blue btn-effect">View</a> <a
									href="adminBack.html" id="submit"
									class="btn btn-blue btn-effect">Back</a>

							</div>
					</form>

					<!-- 

<tr>
	<td>Amount</td>
	<td><input type="text" name="amount" width="15" style="color: black;"></td>
	<td>Rebate Amount</td>
	<td><input type="text" name="rebAmount" width="15" style="color: black;" ></td>
</tr>

<tr>
	<td>Service Tax</td>
	<td><input type="text"  name="stAmount"  width="15" style="color: black;"></td>
	<td>Stmt Amount</td>
	<td><input type="text" name="stmtAmount" width="15" style="color: black;"></td>
</tr>
<tr>
	<td>TDS Amount</td>
	<td><input type="text" name="tdsAmount" width="15" style="color: black;"></td>
	<td>Incentive Amount</td>
	<td><input type="text" name="incAmount" width="15" style="color: black;"></td>
</tr>

<tr>
	<td>EMD Amount</td>
	<td><input type="text" name="emdAmount" width="15" style="color: black;"></td>
	<td>Rebate Paid</td>
	<td><input type="text" name="rebPaidAmount" width="15" style="color: black;"></td>
</tr>

<tr>
	<td>ST Amount</td>
	<td><input type="text" name="stPaidAmount" width="15" style="color: black;"></td>
	<td>Int on Service Tax</td>
	<td><input type="text" name="intServTaxAmount" width="15" style="color: black;"></td>
</tr>

<tr>
	<td>Balance Int on St</td>
	<td><input type="text" name="balintStAmount" width="15" style="color: black;"></td>
	<td>Balance Rebate</td>
	<td><input type="text" name="balRebateAmount" width="15" style="color: black;"></td>
</tr>

<tr>
	<td>Balance ST</td>
	<td><input type="text" name="balStAmount" width="15" style="color: black;"></td>
	<td>Total Balance Amount</td>
	<td><input type="text" name="totalBalAmount" width="15" style="color: black;"></td>
</tr>


<tr>
	<td><h4 style="color: white;">Remarks:</h4></td>
	<td><textarea rows="0" cols="20" name="remark" style="color: black;"></textarea></td>
 -->
				</div>

			</div>
		</div>
		</div>
	</section>







	</main>

	<%@ include file="footer.jsp"%>


</body>
</html>
