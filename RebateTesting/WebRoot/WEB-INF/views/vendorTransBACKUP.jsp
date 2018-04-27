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
    	<!-- meta character set -->
        <meta charset="utf-8">
		<!-- Always force latest IE rendering engine or request Chrome Frame -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>ASRTU-Admin Page</title>		
		<!-- Meta Description -->
        <meta name="description" content="Blue One Page Creative HTML5 Template">
        <meta name="keywords" content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
        <meta name="author" content="">
		
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
        
		<link rel="stylesheet" href="resources/css/jquery-ui.css" />
        <script src="resources/js/jquery-1.12.4.js"></script>
        <script src="resources/js/jquery-ui.js"></script>
  
   <script>
  $(function () {
      $("#datepickerreceipt").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerqfrom").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerqto").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerdd").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerdue").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  
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
														
<h3  align="center" style="color: red;"><c:out value="${message1}"/></h3>

<form action="/rebatetest/saveVendTrans.html" method="post" class="register">
<fieldset class="row1">
                <legend>Vendor Transaction Form</legend>
		<p>
		<label>Quarter</label>
		 <select name="quarter">
										<c:forEach items="${quarter }" var="quar">
											<option value="${quar.quarter }"><c:out
													value="${quar.quarter }"></c:out></option>
										</c:forEach>
									</select>
		<label>Invoice Number</label>
		<input type="text" name="rcpInvoi">
		</p>
		 <p>
		<label>Receipt Date</label>
		 <input type="text" name="rcpInDate"  class="datepicker" id="datepickerreceipt">
 			<label>Firm Name</label>
		<input type="text" name="firmName" >
		</p>
		<p>
		<label>Item Name</label>
		<input type="text" name="itemName" >
		
		<label>Quarter From Date</label>
		 <input type="text" name="qfDate"  class="datepicker" id="datepickerqfrom">
		<p>
		<label>Quarter To Date</label>
		 <input type="text" name="qtDate"  class="datepicker" id="datepickerqto">
		
		<label>STU Amount</label>
		 <input type="text" name="stuAmt"  > 
		 </p>
		<p>
		<label>DD Amount</label>
		 <input type="text" name="dd_received_amt" > 
		<label>Entry Type </label>
		 <input type="text" name="entrType"> 
		 </p>
	<p>
		<label>DD Date</label>
	 <input type="text" name="dairy_date" class="datepicker" id="datepickerdd" > 
	 
		<label>Due Date</label>
	 <input type="text" name="due_date"  class="datepicker" id="datepickerdue"  > 
	</p>
	<table align="center" border="1" width="100%">
		<tr>
			<th align="center"><label style="color: white;">STU Name</label></th>
			<th align="center"><label style="color: white;">Vendor Total AMT</label></th>
			<th align="center"><label style="color: white;">Vendor Total Rebate Amount</label></th>
		</tr>
	
<c:forEach items="${vendorTransactions.vendorTransBeanDetail}" var="vtdb" varStatus="status">

	                <tr>
       									<td>
       									<input type="text" name="vendorTransBeanDetail[${status.index}].stuName" >
										</td>
											<td>
										<input type="text" name="vendorTransBeanDetail[${status.index}].vendor_tot_amt"
											 ></td>
										<td>
										<input type="text" name="vendorTransBeanDetail[${status.index}].reb_Tot_Amt">
										</td>
									

									</tr>
	</c:forEach>
	
</table>
                  </fieldset>
          <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
	<a href="viewVendTr.html" id="submit" class="btn btn-blue btn-effect">View</a>
	<a href="adminBack.html"  id="submit" class="btn btn-blue btn-effect">Back</a>
	
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
</html>






