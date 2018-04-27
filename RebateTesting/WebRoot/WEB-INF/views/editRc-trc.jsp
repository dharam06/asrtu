

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
        <meta name="keywords" content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
        <meta name="author" content="Muhammad Morshed">
		
		<!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- CSS
		================================================== -->
		
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
		
		<!-- Fontawesome Icon font -->
		<link rel="stylesheet" href="resources/css/login.css">
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
        
	<link rel="stylesheet" href="css/jquery-ui.css" />
  <script src="js/jquery-1.8.3.js"></script>
  <script src="js/jquery-ui.js"></script>
  
  
  <script>
$(function() {
    $( ".datepicker" ).datepicker();
});
</script>

<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">




function populateItemCode() {
	
	var itemNameId = document.getElementById('itemNameId').value;
	
    AjaxHelper.getItemNameId(itemNameId, populateGroupCodeCallback);       
}        


function populateGroupCodeCallback( data ) {
    

	 document.getElementById('itemCodeId').value = data;
	       
}

function populateVendorCode() {
	
	var vendorNameId = document.getElementById('vendorNameId').value;
	
	AjaxHelper.getVendorNameId(vendorNameId, populateVendorCodeCallback);
	
} 

function populateVendorCodeCallback( data ) {

	//dwr.util.setValue('vendorId',data);
	document.getElementById('vendorId').value = data;
	 
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
						<!-- 
							<div class="sec-title text-center white wow animated fadeInDown">
								<h2>FOLLOW US</h2>
								<p>Beautifully simple follow buttons to help you get followers on</p>
							</div>
						 -->
	
						</div>
					</div>
				</div>
			</section> 
		
       <!--
        Home Slider
        ==================================== 
		
		<section id="home-slider">
		
            <div id="slider" class="sl-slider-wrapper">

				<div class="sl-slider">
				
					<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">

						<div class="bg-img bg-img-1"></div>

						<div class="slide-caption">
                            <div class="caption-content">
                                <h2 class="animated fadeInDown">Association of State Road Transport Undertaking</h2>
                               <!-- 
                                <span class="animated fadeInDown">Clean and Professional </span>
                                <a href="#" class="btn btn-blue btn-effect">Join US</a>
                           
                            </div>
                        </div>
						
					</div>  -->
					<!-- 
					<div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
					
						<div class="bg-img bg-img-2"></div>
						<div class="slide-caption">
                            <div class="caption-content">
                                <h2>Asrtu</h2>
                                <span>Clean and Professional </span>
                                <a href="#" class="btn btn-blue btn-effect">Join US</a>
                            </div>
                        </div>
						
					</div>
					
					<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
						
						<div class="bg-img bg-img-3"></div>
						<div class="slide-caption">
                            <div class="caption-content">
                                <h2>Asrtu</h2>
                                <span>Clean and Professional </span>
                                <a href="#" class="btn btn-blue btn-effect">Join US</a>
                            </div>
                        </div>

					</div>
					
				</div>-->
				<!-- /sl-slider -->

                <!-- 
                <nav id="nav-arrows" class="nav-arrows">
                    <span class="nav-arrow-prev">Previous</span>
                    <span class="nav-arrow-next">Next</span>
                </nav>
                -->
              
              <!--   
                <nav id="nav-arrows" class="nav-arrows hidden-xs hidden-sm visible-md visible-lg">
                    <a href="javascript:;" class="sl-prev">
                        <i class="fa fa-angle-left fa-3x"></i>
                    </a>
                    <a href="javascript:;" class="sl-next">
                        <i class="fa fa-angle-right fa-3x"></i>
                    </a>
                </nav>
                

				<nav id="nav-dots" class="nav-dots visible-xs visible-sm hidden-md hidden-lg">
					<span class="nav-dot-current"></span>
					<span></span>
					<span></span>
				</nav>
			
			</div>
			-->
			<!-- /slider-wrapper 
		
		</section>
		-->
        <!--
        End Home SliderEnd
        ==================================== -->
			
			<!-- about section -->
			<section id="about" >
				<div class="container">
					<div class="row">
						<div class="col-md-4 wow animated fadeInLeft">
							<!-- 
								<div class="recent-works">
								<h3>Recent Works</h3>
								<div id="works">
									<div class="work-item">
										
									</div>
									<div class="work-item">
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br><br> There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p>
									</div>
									<div class="work-item">
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. <br><br> There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.</p>
									</div>
									<div class="wrapper">
    								
								</div>
							</div>
						</div> -->
						
	

<h3  align="center" style="color: red;"><c:out value="${message1}"/></h3>
<h3 align="center" style="color: white;">RC-TC Status</h3>

<form action="/rebatetest/saveRcTrc.html" method="post">
<table align="center">
	<tr>
		<td>S.No.</td>
		<td>
			<input type="text" name="sno" value="${rcTrc.sno}" style="color: black;width: 205px;height: 26px;">
		</td>
	</tr>
	
	<tr>
		<td>Vendor Name</td>
		<td>
		<select name="vendorName" id="vendorNameId"  style="color: black;width: 205px;height: 26px;" onchange="populateVendorCode()" >
		<c:forEach items="${vendors }" var="vendor">
		<option value="${vendor.vendorName }"><c:out value="${vendor.vendorName }"></c:out></option>
		</c:forEach>
		</select>
		</td>
	</tr>	
	<tr>
		<td>Vendor ID</td>
		<td>
		<input type="text" name="vendorId" id="vendorId" style="color: black;width: 205px;height: 26px;">
		</td>
	</tr>
	
	<tr>
		<td>Item Name</td>
		<td>
		<select name="itemName" id="itemNameId"  style="color: black;width: 205px;height: 26px;" onchange="populateItemCode()">
		<c:forEach items="${items }" var="item">
		<option value="${item.itemName }"><c:out value="${item.itemName }"></c:out></option>
		</c:forEach>
		</select>
	
		</td>
	</tr>
	
	<tr>
		<td>Item Code</td>
		<td>
		<input type="text" name="itemCode" id="itemCodeId" style="color: black;width: 205px;height: 26px;">
		</td>
	</tr>
	
	<tr>
	<td>Status</td>
	<td>
	<select name="status" style="color: black;width: 205px;height: 26px;">

	<option value="regular" style="color: black;">Regular</option>
	<option value="provisional" style="color: black;">Provisional</option>
	<option value="suspended" style="color: black;">Suspended</option>
	</select>
	</td>
	</tr>
<tr>
	<td>Clear Date</td>
	<td>
	<input type="text" class="datepicker"  name="clearDate" style="color: black;width: 205px;height: 26px;">
	 </td>
</tr>
<tr>
<td>From Date</td><td><input type="text" class="datepicker" name="fromDate" style="color: black;width: 205px;height: 26px;"></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td>
	<input type="submit" value="Save" style="width: 60px;height: 30px;color: orange;">
	<input type="reset" value="Reset" style="width: 60px;height: 30px;color: orange;">
	<a href="listRcTrc.html" style="text-decoration: none;color: black;background: yellow;"><input type="button"  style="background: yellow; border: none">View</a>
	<a href="adminBack.html"  style="text-decoration: none;color: black;background: yellow;"><input type="button"  style="background: yellow; border: none"> Back</a>
	</td>
</tr>
</table>
</form>
<c:if test="${!empty rcTrcs}">

	<table align="center" border="1">
		<tr>
			<th>S.No</th>
			<th>Vendor Name</th>
			<th>Vendor ID</th>
			<th>Item Name</th>
			<th>Item Code</th>
			<th>Status</th>
			<th>Clear Date</th>
			<th>From Date</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${rcTrcs}" var="rcTrc">
			<tr>
				<td><c:out value="${rcTrc.sno}"/></td>
				<td><c:out value="${rcTrc.vendorName}"/></td>
				<td><c:out value="${rcTrc.vendorId}"/></td>
				<td><c:out value="${rcTrc.itemName}"/></td>
				<td><c:out value="${rcTrc.itemCode}"/></td>
				<td><c:out value="${rcTrc.status}"/></td>
				<td><c:out value="${rcTrc.clearDate}"/></td>
				<td><c:out value="${rcTrc.fromDate}"/></td>
				
				<td align="center"><a href="editRcTrc.html?sno=${rcTrc.sno}" style="color: white;">Edit</a> | <a href="deleteRcTrc.html?sno=${rcTrc.sno}" style="color: white;">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

					</div>
					

					
				</div>
			</section>
			<!-- end about section -->
			
			
			<!-- Service section -->
			<!-- 
			<section id="service">
				<div class="container">
					<div class="row">
					
						<div class="sec-title text-center">
							<h2 class="wow animated bounceInLeft">Service</h2>
							<p class="wow animated bounceInRight">The Key Features of our Job</p>
						</div>
						
						<div class="col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-home fa-3x"></i>
								</div>
								<h3>Support</h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
							</div>
						</div>
					
						<div class="col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn" data-wow-delay="0.3s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-tasks fa-3x"></i>
								</div>
								<h3>Well Documented</h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
							</div>
						</div>
					
						<div class="col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn" data-wow-delay="0.6s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-clock-o fa-3x"></i>
								</div>
								<h3>Design UI/UX</h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>
							</div>
						</div>
					
						<div class="col-md-3 col-sm-6 col-xs-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-heart fa-3x"></i>
								</div>
								
								<h3>Web Security</h3>
								<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. </p>							
							</div>
						</div>
						
					</div>
				</div>
			</section> -->
			<!-- end Service section -->
			
			
			
		
			
			
			<!-- end Contact section -->
			<!-- 
			<section id="google-map">
				<div id="map-canvas" class="wow animated fadeInUp"></div>
			</section>
		 -->
		</main>
		
		<footer id="footer">
			<div class="container">
				<div class="row text-center">
					<div class="footer-content">
						<div class="wow animated fadeInDown">
							
						</div>
					
						
							<jsp:useBean id="date" class="java.util.GregorianCalendar"></jsp:useBean>
						<%
						
						int	day = date.get(Calendar.DAY_OF_MONTH);
					    int  month = date.get(Calendar.MONTH);
					     int year = date.get(Calendar.YEAR);	
						 
						%>
						<p>Copyright &copy; 2014-<%= year %> Design and Developed By<a href="http://"></a>Gigabit </p>
					</div>
				</div>
			</div>
		</footer>
		
		<!-- Essential jQuery Plugins
		================================================== -->
		<!-- Main jQuery -->
         <script src="resources/js/jquery-1.11.1.min.js"></script>
		<!-- Twitter Bootstrap -->
        <script src="resources/js/bootstrap.min.js"></script>
		<!-- Single Page Nav -->
        <script src="resources/js/jquery.singlePageNav.min.js"></script>
		<!-- jquery.fancybox.pack -->
        <script src="resources/js/jquery.fancybox.pack.js"></script>
		<!-- Google Map API -->
		<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
		<!-- Owl Carousel -->
        <script src="resources/js/owl.carousel.min.js"></script>
        <!-- jquery easing -->
        <script src="resources/js/jquery.easing.min.js"></script>
        <!-- Fullscreen slider -->
        <script src="resources/js/jquery.slitslider.js"></script>
        <script src="resources/js/jquery.ba-cond.min.js"></script>
		<!-- onscroll animation -->
        <script src="resources/js/wow.min.js"></script>
		<!-- Custom Functions -->
        <script src="resources/js/main.js"></script>
    </body>
</html>







