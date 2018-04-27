

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


<script type="text/javascript">
  
  function validateForm() {
	  
//	alert(1);
    var x = document.getElementById("subGroupNameId").value;
    if (x == "") {
        alert("Please enter Sub Group Name.");
        document.getElementById("subGroupNameId").focus();
        return false;
    }
    
    var y = document.getElementById("subGroupCodeId").value;
    if (y == "") {
        alert("Please enter Sub Group Code.");
        document.getElementById("subGroupCodeId").focus();
        return false;
    }
    
    var x = document.getElementById("itemGroupNameId").value;
    if (x == "") {
        alert("Please enter Item Group Name.");
        document.getElementById("itemGroupNameId").focus();
        return false;
    }
  }
  </script>


</head>

<body id="body">

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

						<form action="/rebatetest/saveProdSubGroup.html" method="post"
							class="register" onsubmit="return validateform()">
							<fieldset class="row1">
								<legend>Product Sub Group Manager </legend>

								<p>
									

									<label>Sub Group Name </label> <input type="text"
										name="subGroupName" id="subGroupNameId"/>

								</p>
								<p>
									<label>Sub Group Code </label> <input type="text"
										name="subGroupCode" id="subGroupCodeId" />
								

                 <label>Item Group Name 
                    </label>
         			  <select name="itemGroupCode"  id="itemGroupNameId"  onchange="populateGroupCode()">
         			  <option>--Please Select--</option>
					<c:forEach items="${itemGroup}"  var="itemBean">
					<option value="${itemBean.itemCode}" > <c:out value="${itemBean.itemName}" /> </option>
				</c:forEach>
				</select>
				</p>

							</fieldset>

							<button type="submit" id="submit" class="btn btn-blue btn-effect">Save</button>
							<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
							<a href="viewSubGroup.html" id="submit"
								class="btn btn-blue btn-effect">View</a> <a
								href="adminBack.html" id="submit"
								class="btn btn-blue btn-effect"> Back</a>
					</div>

					</form>

				</div>

			</div>
		</div>
		</div>
	</section>


	</main>

	<%@ include file="footer.jsp"%>

</body>
</html>






