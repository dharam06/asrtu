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
      $("#datepickerfrom").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerto").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  </script>
  
 <script type="text/javascript">
  
  function validateForm() {
	  
//	alert(1);
    var x = document.getElementById("datepickerfrom").value;
    if (x == "") {
        alert("Please enter From Date.");
        document.getElementById("datepickerfrom").focus();
        return false;
    }
    
    var y = document.getElementById("datepickerto").value;
    if (y == "") {
        alert("Please enter To Date.");
        document.getElementById("datepickerto").focus();
        return false;
    }
    
    var x = document.getElementById("tax1Id").value;
    if (x == "") {
        alert("Please enter Service Tax Percent.");
        document.getElementById("tax1Id").focus();
        return false;
    }
    
    var y = document.getElementById("tax2Id").value;
    if (y == "") {
        alert("Please enter Swatch Bharat.");
        document.getElementById("tax2Id").focus();
        return false;
    }	
    var x = document.getElementById("tax3Id").value;
    if (x == "") {
        alert("Please enter Krishi Kalyan Cess.");
        document.getElementById("tax3Id").focus();
        return false;
    }
    
    var y = document.getElementById("taxPercentId").value;
    if (y == "") {
        alert("Please enter Total Tax Percent.");
        document.getElementById("taxPercentId").focus();
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
														
<h3  align="center" style="color: red;"><c:out value="${message1}"/></h3>

<form action="/rebatetest/saveTax.html" method="post" class="register" onsubmit="return validateForm()">
<fieldset class="row1">
                <legend>Tax Entry Form
                </legend>
              
                <p>
                    <label>From Date
                    </label>
                   <input type="text"  name="fromDate" id="datepickerfrom"  />
                    <label>To Date
                    </label>
                   <input type="text" name="toDate" id="datepickerto"  />
                   
                  </p>
                 
               <p>
               
                    <label>CGST (%)
                    </label>
                  <input type="text" name="tax1" id="tax1Id"  />
               
                    <label>SGST (%)
                    </label>
                  <input type="text" name="tax2" id="tax2Id" />
                   
                  </p>
                  
                              <p>
               
                    <label>IGST (%)
                    </label>
                  <input type="text" name="tax3" id="tax3Id" />
               
                    <label>Total Tax Percent (%)
                    </label>
                  <input type="text" name="taxPercent" id=taxPercentId  />
                   
                  </p>
                   </fieldset>
          <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
	<a href="viewTax.html" id="submit" class="btn btn-blue btn-effect">View</a>
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
