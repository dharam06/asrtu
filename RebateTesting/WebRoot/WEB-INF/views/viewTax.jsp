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
											
<h2>List Tax Detail</h2>


<c:if test="${!empty taxs}">
<div class="table-responsive">
								
<table class="table table-condensed table-striped table-bordered table-hover no-margin" align="center">
		<tr>
			<th>S. No.</th>
			
			<th>CGST Percent</th>
			<th>SGST Percent</th>
			<th>IGST Percent</th>
			
			<th> From Date</th>
			<th>To Date</th>
			
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${taxs}" var="tax"  varStatus="status">
			<tr class="${status.count % 2 == 0 ? 'even' : 'odd'}"
												${status.count % 2 == 0 ? 'even' : 'odd'}>
												
				<td><c:out value="${status.count}"/></td>
				
				<td><c:out value="${tax.tax1}"/></td>
				<td><c:out value="${tax.tax2}"/></td>
				<td><c:out value="${tax.tax3}"/></td>
				<td><c:out value="${tax.fromDateString}"/></td>
				<td><c:out value="${tax.toDateString}"/></td>
				<td><%-- <a href="editTax.html?sno=${tax.sno}"><strong>Edit</strong></a> | --%> <a href="deleteTax.html?sno=${tax.sno}"><samp>Delete</samp></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<a href="taxDownloadXls.html" class="btn btn-blue btn-effect">Download Excel</a>
<a href="taxDownloadPdf.html" class="btn btn-blue btn-effect">Download PDF</a>
<a href="viewTaxBack.html"  class="btn btn-blue btn-effect">Back</a>

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
