
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>

 <link rel="stylesheet" href="resources/js/chosen/docsupport/style.css">
  <link rel="stylesheet" href="resources/js/chosen/docsupport/prism.css">
  <link rel="stylesheet" href="resources/js/chosen/chosen.css">
  <style type="text/css" media="all">
    /* fix rtl for demo */
    .chosen-rtl .chosen-drop { left: -9000px; }
  </style>

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
<script src="resources/js/modernizr-2.6.2.min.js"></script>

<link rel="stylesheet" href="resources/css/jquery-ui.css" />
<script src="resources/js/jquery-1.12.4.js"></script>
<script src="resources/js/jquery-ui.js"></script>

<script>
$(function() {
  $( ".datepicker" ).datepicker({dateFormat: 'dd/mm/yy'});
});


  
  function submitForm(){
		//alert(1);
	  //this.selectInsuranceForm.submit

	  var pageAction = document.getElementById("pageActionID");
	  pageAction.value="refreshPage";
	  // alert(pageAction.value);
	  document.forms.vendorTransactionForm.submit();
	}
  
  </script>
  <script type="text/javascript">
  
  function validateForm() {
	  
//	alert(1);
    var x = document.getElementById("invoiceId").value;
    if (x == "") {
        alert("Please enter ASRTU Invoice Number.");
        document.getElementById("invoiceId").focus();
        return false;
    }
    
    var y = document.getElementById("datepickerto").value;
    if (y == "") {
        alert("Please enter ASRTU Invoice Date.");
        document.getElementById("datepickerto").focus();
        return false;
    }
    
    var x = document.getElementById("vendorID").value;
    if (x == "") {
        alert("Please enter Vendor Name.");
        document.getElementById("vendorID").focus();
        return false;
    }
    
    var y = document.getElementById("itemGroupNameId").value;
    if (y == "") {
        alert("Please enter Item Name.");
        document.getElementById("itemGroupNameId").focus();
        return false;
    }	
    var x = document.getElementById("quarterId").value;
    if (x == "") {
        alert("Please enter Quarter.");
        document.getElementById("quarterId").focus();
        return false;
    }
    
    var y = document.getElementById("datepickerfrom").value;
    if (y == "") {
        alert("Please enter Quarter From Date.");
        document.getElementById("datepickerfrom").focus();
        return false;
    }
    var x = document.getElementById("datepickerto").value;
    if (x == "") {
        alert("Please enter Quarter To Date.");
        document.getElementById("datepickerto").focus();
        return false;
    }
    
    var y = document.getElementById("regularRebateId").value;
    if (y == "") {
        alert("Please enter DRegular Rebate.");
        document.getElementById("regularRebateId").focus();
        return false;
    }
    var x = document.getElementById("rebateOutstandingId").value;
    if (x == "") {
        alert("Please enter Rebate Outstanding.");
        document.getElementById("rebateOutstandingId").focus();
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
						<form name="vendorTransactionForm" action="/rebatetest/saveVendTrans.html" method="post"
							class="registerLarge" onsubmit="return validateform()">
							<fieldset class="row1">
								<legend>Vendor Transaction Form</legend>
								<p>
									<label>ASRTU Invoice Number</label> 
									<select name="asrtuInvoiceNumber"
										id="invoiceId" onchange="submitForm();">
										<option value=0>--Please Select--</option>
										<c:forEach items="${invoiceList}" var="invoice">
											<option value="${invoice.invoiceNumber}" ${invoiceDetail.asrtuInvoiceNumber == invoice.invoiceNumber ? 'selected' : ' '}>
											<c:out value="${invoice.invoiceNumber}"></c:out></option>
										</c:forEach>
									</select>
								</p>
								<p>
									<label>ASRTU Invoice Date </label> <input type="text"
										id="datepickerto" name="asrtuInvoiceDate" class="datepicker"
										value="${vendorTransactions.asrtuInvoiceDateString}" /> <label>Vendor
										Name </label> <select name="firmName" id="vendorID">
										<option value="${vendorTransactions.firmCode}">${vendorTransactions.firmName}</option>
									</select>

								</p>
								<p>
									<label>Item Name </label> <select name="itemCode"
										id="itemGroupNameId">
										<option value="${vendorTransactions.itemCode}">${vendorTransactions.itemName}</option>
									</select>
									
									<label>Quarter</label> <input type="text"
										name="quarter"
										value="${vendorTransactions.quarter}" id="quarterId"/>
										</p>
								<p>
									 <label>Quarter From Date </label> <input type="text"
										name="quarterFromDate" class="datepicker"
										value="${vendorTransactions.quarterFromDateString}" id="datepickerfrom"/>

									<label>Quarter To Date </label> <input type="text"
										name="quarterToDate" value="${vendorTransactions.quarterToDateString}" /> 
										
</p>
								<p>										
										<label>Regular
										Rebate </label> <input type="text" name="regularRebate"
										value="${vendorTransactions.regularRebate}" id="regularRebateId"/>
									<label>Rebate Outstanding</label> <input type="text"
										name="rebateOutstanding"
										value="${vendorTransactions.rebateOutstanding}" id="rebateOutstandingId"/> <br /> <br />
								</p>
								<table align="center" border="3" width="100%">
									<tr>
									<script src="resources/js/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="resources/js/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
										<th align="center"  width="40%"><label style="color: white;">STU
												Name</label></th>
										<th align="center" width="10%"><label style="color: white;">Vendor
												Total AMT</label></th>
										<th align="center" width="10%"><label style="color: white;">Vendor
												Total Rebate Amount</label></th>
												
										<th width="10%" style="color: white;"><tlabel style="color: white;">Invoice Number</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">Invoice Date</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">Purchase Order Date</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">Purchase Order No</tlabel></th>
												
									</tr>

									<c:forEach items="${vendorTransactions.vendorTransBeanDetail}"
										var="vtdb" varStatus="status">

										<tr>
										
											<td  width="40%"><select name="vendorTransBeanDetail[${status.index}].stuCode" id="stuID" data-placeholder="--Please select----"  class="chosen-select">
	
	<option value="">--Please select--</option>
					
		<c:forEach items="${stuMaster }" var="stu">
			<option value="${stu.code }"><c:out
					value="${stu.name } - ${stu.modelName }  - ${stu.modelCode }" /></option>
																		
		</c:forEach>

											</td>
											<td  width="10%"><input type="text"
												name="vendorTransBeanDetail[${status.index}].vendorTotalAmount"></td>
												
										<td  width="10%">
										<input type="text" name="vendorTransBeanDetail[${status.index}].vendorRebateAmount">
										</td>

										<td  width="10%">
										<input type="text" name="vendorTransBeanDetail[${status.index}].invoiceNumber">
										</td>

										<td width="10%">
										<input type="text" name="vendorTransBeanDetail[${status.index}].invoiceDate" class="datepicker">
										</td>
										
										<td width="10%">
										<input type="text" name="vendorTransBeanDetail[${status.index}].purchaseOrderDate" class="datepicker">
										</td>
										<td width="10%">
										<input type="text" name="vendorTransBeanDetail[${status.index}].purchaseOrderNumber">
										</td>

										</tr>
									</c:forEach>

	
								</table>
	
	<input type="hidden" name="pageAction" value="" id="pageActionID">
							</fieldset>
							<button type="submitBTN" id="submitBTN" class="btn btn-blue btn-effect">Save</button>
							<button type="reset" id="submitBTN" class="btn btn-blue btn-effect">Reset</button>
							<a href="viewVendTr.html" id="submitBTN"
								class="btn btn-blue btn-effect">View</a> <a
								href="adminBack.html" id="submitBTN"
								class="btn btn-blue btn-effect">Back</a>
					</div>

					</form>
<script type="text/javascript">
     var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width: "95%"}
    } 
    for (var selector in config) {
      $(selector).chosen(config[selector]);
      
     // $(".chosen").chosen({width: "inherit"});
    }
  </script>

				</div>

			</div>
		</div>
		</div>
	</section>


	</main>

	<%@ include file="footer.jsp"%>

</body>
</html>






