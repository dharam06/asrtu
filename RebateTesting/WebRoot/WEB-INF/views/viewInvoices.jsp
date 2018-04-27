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
<!-- meta character set -->
<meta charset="utf-8">
<!-- Always force latest IE rendering engine or request Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>ASRTU-Admin Page</title>
<!-- Meta Description -->
<meta name="description" content="Blue One Page Creative HTML5 Template">
<meta name="keywords"
	content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
<meta name="author" content="">

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
<script src="resources/js/modernizr-2.6.2.min.js">
</script>
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



</script>

</head>
<body id="body">
	<%@ include file="header.jsp"%>
	<main class="site-content" role="main">
		
		<section id="social" class="parallax">
				<div class="overlay">
					<div class="container">
						<div class="row">
				<div class="sec-title text-center white wow animated fadeInDown">
											
<h2>Invoices List</h2>


					<form action="/rebatetest/searchInvoice.html" name="myForm" method="post"
						autocomplete="off">

								<label>Invoice Date </label> <input
									type="text" id="datepickerto" name="invoiceDate"
									class="datepicker" />

</p>

  <script src="resources/js/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="resources/js/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
 
<p>
								<label>Vendor Name</label> 
								<select name="vendorCode" data-placeholder="--Please select----"  class="chosen-select" 
									 id="vendorId" onchange="populateItemGroupName()">
									 <option value=0>--Please Select--</option>
									<c:forEach items="${vendor}" var="vendor">
										<option value="${vendor.vendorId}"><c:out
												value="${vendor.vendorName}"></c:out></option>
									</c:forEach>
								</select> 


								
			</p>		
			<p>			
								<label>Item Name </label> <select name="itemCode" 
									id="itemGroupNameId">

								</select> <input type="hidden" name="itemName" id="itemNameId" />

<p>

						
								<label>Quarter From Date </label> <input type="text"
									name="quarterFromDate" class="datepicker" /> 
									
									<label>Quarter
									To Date </label> <input type="text" name="quarterToDate"
									class="datepicker" />
</p>
<p>

							<label>Rebate Type</label><select name="rebateType"
									id="regularRebateId">
									<option value="Regular Rebate">Regular Rebate</option>
									<option value="Rebate Reconciliation">Rebate Reconciliation</option>
									
								</select> 
</p>
<p>
								<label>Amount</label> <input type="text"
									name="rebateOutstanding" /> <br />
								<br />
							</p>
										<button type="submit" id="submit"
									class="btn btn-blue btn-effect">Search</button>

</form>


<c:if test="${!empty invoiceList}">
<div class="table-responsive">
								
<table class="table table-condensed table-striped table-bordered table-hover no-margin" align="center">
		<tr>
			<th>SNo.</th>
			<th>ID</th>
			<th>Invoice Number</th>
			<th>GST Number</th>
			<th>invoiceDateString</th> 
			<th>Quarter</th>
			<th>QuarterFromDateString</th> 
			<th>QuarterToDateString</th> 
			<th>VendorCode</th> 
			<th>FirmName</th> 
			<th>ItemCode </th>        
			<th>ItemName</th> 
			<th>Rebate Type</th>                    
			<th>RebateOutstanding</th> 
			<th>Principal Outstanding</th>
			<th>Tax Outstanding</th>
			<th>Principal Rem Outstanding</th>
			<th>Tax Rem Outstanding</th>
			<th>Total Tax</th>
			<th>CGST</th>
			<th>SGST</th>
			<th>IGST</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${invoiceList}" var="invoice"  varStatus="status">
			<tr class="${status.count % 2 == 0 ? 'even' : 'odd'}"
												${status.count % 2 == 0 ? 'even' : 'odd'}>
				<td><c:out value="${status.count}"/></td>
				<td><c:out value="${invoice.invoiceNumber}"/></td>
				<td><c:out value="${invoice.asrtuInvoiceNumber}"/></td>
				<td><c:out value="${invoice.gstNumber}"/></td>
				<td><c:out value="${invoice.invoiceDateString}"/></td>
				<td><c:out value="${invoice.quarter}"/></td>
				<td><c:out value="${invoice.quarterFromDateString}"/></td>
				<td><c:out value="${invoice.quarterToDateString}"/></td>
				<td><c:out value="${invoice.vendorCode}"/></td>
			<td><c:out value="${invoice.firmName}"/></td>
			<td><c:out value="${invoice.itemCode}"/></td>        
			<td><c:out value="${invoice.itemName}"/></td>
			<td><c:out value="${invoice.rebateType}"/></td>                      
			<td><c:out value="${invoice.rebateOutstanding}"/></td>
			<td><c:out value="${invoice.rebatePrOutstanding}"/></td>
			<td><c:out value="${invoice.rebateTaxOutstanding}"/></td>
			
			<td><c:out value="${invoice.rebatePrRemainingOutstanding}"/></td>
			<td><c:out value="${invoice.rebateTaxRemainingOutstanding}"/></td>
			
			<td><c:out value="${invoice.totalTax}"/></td>
			<td><c:out value="${invoice.tax1}"/></td>
			<td><c:out value="${invoice.tax2}"/></td>
			<td><c:out value="${invoice.tax3}"/></td>
				<td><a href="editInvoice.html?invoiceNumber=${invoice.invoiceNumber}"><strong>Edit</strong></a> | <a href="deleteInvoice.html?invoiceNumber=${invoice.invoiceNumber}"><samp>Delete</samp></a> | <a href="printInvoice.html?invoiceNumber=${invoice.invoiceNumber}"><strong>Print Invoice</strong></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<a href="invoiceDownloadXls.html" class="btn btn-blue btn-effect">Download Excel</a>
<a href="invoiceDownloadPdf.html" class="btn btn-blue btn-effect">Download PDF</a>
<a href="viewInvoiceBack.html"  class="btn btn-blue btn-effect">Back</a>

							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
	</main>

	<%@ include file="footer.jsp"%>

</body>
</html>
