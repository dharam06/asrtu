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

						<h2>STU Transactions List</h2>
							<div class="table-responsive">
								<table
									class="table table-condensed table-striped table-bordered table-hover no-margin"
									align="center">
									<tr>
										<th>SNo.</th>
										<th>Quarter</th>
										<th>STU Name</th>
										<th>STU Code</th>
										<th>Nodal Code</th>
										<th>Nodal Name</th>
										<th>Firm Name</th>
										<th>Firm Code</th>
										<th>Item Name</th>
										
										<th>Transaction Date</th>
										<th>Info Receipt Date</th>
										
										<th>Invoice Number</th>
										<th>Invoice Date</th>
										<th>Stu Total Amount</th>
										<th>Stu total Rebate</th>
										<th>Purchase Order Date</th>
										<th>Purchase Order No</th>
										<th>Actions</th>
									</tr>

									<c:forEach items="${stuTransactionBean.stuColl}" var="rcTrc" varStatus="status">
										<tr class="${status.count % 2 == 0 ? 'even' : 'odd'}"
											${status.count % 2 == 0 ? 'even' : 'odd'}>

											<td><c:out value="${status.count}" /></td>
											<td><c:out value="${rcTrc.quarter}" /></td>
											<td><c:out value="${rcTrc.stuName}" /></td>
											<td><c:out value="${rcTrc.stuCode}" /></td>
											<td><c:out value="${rcTrc.nodalCode}" /></td>
											<td><c:out value="${rcTrc.nodalName}" /></td>
											<td><c:out value="${rcTrc.firmName}" /></td>
											<td><c:out value="${rcTrc.vendorCode}" /></td>
											<td><c:out value="${rcTrc.itemName}" /></td>	
											
											<td><c:out value="${rcTrc.transactionDateString}" /></td>	
											<td><c:out value="${rcTrc.infoReceiptDateString}" /></td>
											
																						
											<td><c:out value="${rcTrc.invoiceNumber}" /></td>
											<td><c:out value="${rcTrc.invoiceDateString}" /></td>
											<td><c:out value="${rcTrc.stuTotalAmount}" /></td>
											<td><c:out value="${rcTrc.stuTotalRebate}" /></td>
											
											<td><c:out value="${rcTrc.purchaseOrderDateString}" /></td>
											<td><c:out value="${rcTrc.purchaseOrderNumber}" /></td>

											<td align="center"><a
												href="editstuTrn.html?stuColl[0].sno=${rcTrc.sno}"><strong>Edit</strong></a>
												| <a href="deletestuTrn.html?stuColl[0].sno=${rcTrc.sno}"><samp>Delete</samp></a></td>
										</tr>
									</c:forEach>
								</table>
					</div>
<a href="stuTransDownloadXls.html" class="btn btn-blue btn-effect">Download Excel</a>
<a href="stuTransDownloadPdf.html" class="btn btn-blue btn-effect">Download PDF</a>
<a href="adminBack.html"class="btn btn-blue btn-effect"> Back</a>
				</div>
	</main>

	<%@ include file="footer.jsp"%>

</body>

				
	

		
	</html>








