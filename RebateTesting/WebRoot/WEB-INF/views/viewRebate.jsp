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

</head>
<body id="body">
	<%@ include file="header.jsp"%>
	<main class="site-content" role="main">

	<section id="social" class="parallax">
		<div class="overlay">
			<div class="container">
				<div class="row">

					<div class="sec-title text-center white wow animated fadeInDown">
						<c:if test="${!empty rebates}">
							<div class="table-responsive">
								<h2>List Rebate Transaction</h2>
								<table
									class="table table-condensed table-striped table-bordered table-hover no-margin"
									align="center">
									<tr>
									<th> SNo.</th>
<th>Transaction No</th>
<th>Transaction Date</th>
<th>Rebate Outstanding</th>
<th>invoice Payment</th>
<th>Receipt Date</th>
<th>Vendor Code</th>
<th>Vendor Name</th>
<th>Item Code</th>
<th>Item Name</th>
<th>QTR From Date</th>
<th>QTR To Date</th>
<th>Bank Name</th>
<th>Cheque No</th>
<th>Cheque Date</th>
<th>DD Cheque Amount</th>
<th>Interest On Rebate</th>
<th>Interest On Service Tax</th>
<th>TDS Amount</th>
<th>INC Amount</th>
<th>EMD Amount</th>
<th>Bank Charge</th>
<th>Remarks</th>
<th>Comments</th>
										<th>Actions on Row</th>
									</tr>

									<c:forEach items="${ rebates}" var="rebate" varStatus="status">
										<tr class="${status.count % 2 == 0 ? 'even' : 'odd'}"
											${status.count % 2 == 0 ? 'even' : 'odd'}>
																						<td><c:out value="${status.count}" /></td>
											
											<td><c:out value="${rebate.receiptNo}" /></td>
<td><c:out value="${rebate.transactionDateString}" /></td>
<td><c:out value="${rebate.rebateOutstanding}" /></td>
<td><c:out value="${rebate.invoicePayment}" /></td>
<td><c:out value="${rebate.receiptDateString}" /></td>
<td><c:out value="${rebate.vendorCode}" /></td>
<td><c:out value="${rebate.vendorName}" /></td>
<td><c:out value="${rebate.itemCode}" /></td>
<td><c:out value="${rebate.itemName}" /></td>
<td><c:out value="${rebate.qfdateString}" /></td>
<td><c:out value="${rebate.qtdateString}" /></td>
<td><c:out value="${rebate.astruBankName}" /></td>
<td><c:out value="${rebate.chequeNo}" /></td>
<td><c:out value="${rebate.chequeDateString}" /></td>
<td><c:out value="${rebate.ddChequeAmount}" /></td>
<td><c:out value="${rebate.interestOnRebate}" /></td>
<td><c:out value="${rebate.interestOnServiceTax}" /></td>
<td><c:out value="${rebate.tdsAmount}" /></td>
<td><c:out value="${rebate.incAmount}" /></td>
<td><c:out value="${rebate.emdAmount}" /></td>
<td><c:out value="${rebate.bankcharge}" /></td>
<td><c:out value="${rebate.remarks}" /></td>
<td><c:out value="${rebate.comments}" /></td>
	<td><a
												href="editRebate.html?receiptNo=${rebate.receiptNo}"><strong>Edit</strong></a>
												| <a href="deleteRebate.html?receiptNo=${rebate.receiptNo}"><samp>Delete</samp></a></td>
										</tr>
									</c:forEach>
								</table>
						</c:if>

						<a href="rebateDownloadXls.html" class="btn btn-blue btn-effect">Download
							Excel</a> <a href="rebateDownloadPdf.html"
							class="btn btn-blue btn-effect">Download PDF</a> <a
							href="viewRebateBack.html" class="btn btn-blue btn-effect"> Back</a>

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
