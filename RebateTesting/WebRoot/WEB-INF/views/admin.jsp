

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
					
		<section id="service">
				<div class="container">

					<div class="row">
					<div class="sec-title text-center">
					</div>
					<div>
                            <div class="caption-content">
                                <h2 class="animated fadeInDown">REBATE AND TESTING ADMINISTRATION</h2>
                                 </div>
                        </div>
					<div>&nbsp;</div>
					
										<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.3s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-tasks fa-3x"></i>
								</div>
								<h3 class="btn btn-blue">
								<a href="reports.html" class="btn btn-border btn-effect pull-right">Rebate Reports</a>
								</h3>
							</div>
						</div>
						
											<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.3s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-tasks fa-3x"></i>
								</div>
								<h3 class="btn btn-blue">
								<a href="ledgers.html" class="btn btn-border btn-effect pull-right">Rebate Ledgers</a>
								</h3>
							</div>
						</div>
					
					<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.3s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-tasks fa-3x"></i>
								</div>
								<h3 class="btn btn-blue">
								<a href="testingreports.html" class="btn btn-border btn-effect pull-right">Testing Reports</a>
								</h3>
							</div>
						</div>
						
					
						<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-arrow-down fa-3x"></i>
								</div>
								<h3 class="btn btn-blue">
								<a href="tax.html" class="btn btn-border btn-effect pull-right">Tax Entry Form</a>
								</h3>
							</div>
						</div>
					<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.3s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-tasks fa-3x"></i>
								</div>
								<h3 class="btn btn-blue">
								<a href="Quarter.html" class="btn btn-border btn-effect pull-right">Quarter Entry Form</a>
								</h3>
							</div>
						</div>
					<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.6s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-clock-o fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
								<a href="stu.html" class="btn btn-border btn-effect pull-right">STU Master Form</a>
								</h3>
							</div>
						</div>
                      	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-filter fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
								
							<a href="rctrc.html" class="btn btn-border btn-effect pull-right">RC-TRC Form</a>
								</h3>
							</div>
						</div>
							<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-flash fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
								
					<a href="itemGroup.html" class="btn btn-border btn-effect pull-right">Product Group Mgr</a>
								</h3>
							</div>
						</div>
                     	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-sort fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="itemMaster.html" class="btn btn-border btn-effect pull-right">Product Manager</a>
								</h3>
							</div>
						</div>
                     	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-link fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="debit.html" class="btn btn-border btn-effect pull-right">Debit Entry Form</a>
								</h3>
							</div>
						</div>
                       	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-home fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
															
							<a href="stoOrderForm.html" class="btn btn-border btn-effect pull-right">STO Order Form</a>

								</h3>
							</div>
						</div>
                     	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-wrench fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="testingCharge.html" class="btn btn-border btn-effect pull-right">Testing Charge Form</a>
								</h3>
							</div>
						</div>
                     	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-tasks fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="rcPeriod.html" class="btn btn-border btn-effect pull-right">Rate Contract Form</a>
								</h3>
							</div>
						</div>
                       	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-arrow-down fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
													
				<a href="rebateform.html" class="btn btn-border btn-effect pull-right">Rebate Form</a>

								</h3>
							</div>
						</div>
                      	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-heart fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="cirtBill.html" class="btn btn-border btn-effect pull-right">CIRT Bill</a>
								</h3>
							</div>
						</div>
                      	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-arrow-down fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
														
					<a href="vendTranForInvoice.html" class="btn btn-border btn-effect pull-right">Vendor Transaction</a>
								</h3>
							</div>
						</div>
                       	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-thumbs-up fa-3x"></i>
								</div>
										<h3  class="btn btn-blue">
							<a href="stuTransac.html" class="btn btn-border btn-effect pull-right">STU Transaction Form</a>
								</h3>
							</div>
						</div>
						    	<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-thumbs-up fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="prodSubGroup.html" class="btn btn-border btn-effect pull-right">Sub Prod Mgr</a>
								</h3>
							</div>
						</div>
						
				<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-thumbs-up fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="invoiceGeneration.html" class="btn btn-border btn-effect pull-right">Invoice Generation</a>
								</h3>
							</div>
						</div>
						

					</div>
				</div>
				
				<div class="col-md-3 col-sm-6 col-md-12 text-center wow animated zoomIn" data-wow-delay="0.9s">
							<div class="service-item">
								<div class="service-icon">
									<i class="fa fa-thumbs-up fa-3x"></i>
								</div>
								<h3  class="btn btn-blue">
							<a href="vendorsgst.html" class="btn btn-border btn-effect pull-right">Vendor GST Number</a>
								</h3>
							</div>
						</div>
						

					</div>
				</div>
				
			</section>
					
					
					
					<!--  
						<div class="row">
						
						
							<div class="sec-title text-center white wow animated fadeInDown">
								<h1>Rebate and Testing Administration</h1>
							<br/>

		<div float="left" class="row">								
<a href="stu.html" class="btn btn-border btn-effect pull-right">Stu Master Form</a>
<a href="Quarter.html" class="btn btn-border btn-effect pull-right">Quarter Entry Form</a>
<a href="tax.html" class="btn btn-border btn-effect pull-right">Tax Entry Form</a>

</div>

<div>&nbsp;</div>

<div class="row">



<a href="itemMaster.html" class="btn btn-border btn-effect pull-right">Product Manager Master</a>
<a href="itemGroup.html" class="btn btn-border btn-effect pull-right">Product Group Manager</a>
<a href="rctrc.html" class="btn btn-border btn-effect pull-right">RC-TRC Form</a>

</div>

<div>&nbsp;</div>
<div class="row">

<a href="testingCharge.html" class="btn btn-border btn-effect pull-right">Testing Charge Form</a>
<a href="stoOrderForm.html" class="btn btn-border btn-effect pull-right">STO Order Form</a>
<a href="debit.html" class="btn btn-border btn-effect pull-right">Debit Entry Form</a>
</div>
<div>&nbsp;</div>
<div class="row">

<a href="cirtBill.html" class="btn btn-border btn-effect pull-right">CIRT Bill</a>
<a href="rebateform.html" class="btn btn-border btn-effect pull-right">Rebate Form</a>
<a href="rcPeriod.html" class="btn btn-border btn-effect pull-right">Rate Contract Form</a>
</div>

<div>&nbsp;</div>
<div class="row">


<a href="stuTransac.html" class="btn btn-border btn-effect pull-right">Stu Transaction Form</a>
<a href="vendTran.html" class="btn btn-border btn-effect pull-right">Vendor Transaction</a>
</div>


						
	
						</div>
					</div>
					-->
				</div>
			</section> 
		
        <!--
        Home Slider
        ==================================== -->
		<!-- 
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
						
					</div> -->
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
						
						</div>
						</div>
	<!--  					
	<h2>Spring3MVC with Hibernate3 CRUD Example using Annotations</h2>
    <h2>1. <a href="employees.html">List of Employees</a></h2>
    <h3>2. <a href="add.html">Add Employee</a></h3>
       <h4>3.<a href="admin.html">Admin Page</a> </h4>
     -->
    
  <!--    
<h4><a href="stu.html" style="color: white;">Stu Master Form</a></h4>
<h4><a href="Quarter.html" style="color: white;">Quarter Entry Form</a></h4>
<h4><a href="tax.html" style="color: white;">Tax Entry Form</a></h4>
<h4><a href="itemMaster.html" style="color: white;">Item Master Form</a></h4>
<h4><a href="itemGroup.html" style="color: white;">Item Group Form</a></h4>
<h4><a href="rctrc.html" style="color: white;">RC-TRC Form</a></h4>
<h4><a href="testingCharge.html" style="color: white;">Testing Charge Form</a></h4>
<h4><a href="stoOrderForm.html" style="color: white;">STO Order Form</a></h4>
<h4><a href="debit.html" style="color: white;">Debit Entry Form</a></h4>
<h4><a href="cirtBill.html" style="color: white;">CIRT Bill</a></h4>
<h4><a href="rebateform.html" style="color: white;">Rebate Form</a></h4>
<h4><a href="rcPeriod.html" style="color: white;">Rate Contract Form</a></h4>
<h4><a href="stuTransac.html" style="color: white;">Stu Transaction Form</a></h4>
<h4><a href="vendTran.html" style="color: white;">Vendor Transaction</a></h4>

<form:form action="/rebatetest/downloadPDF" method="post" id="downloadPDF">

		<input id="submitId" type="submit" value="Downlaod PDF">
	</form:form>
					
		 -->			

					
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
						
						<p>Copyright &copy; 2014- <%= year %> Design and Developed By<a href="http://"></a>Gigabit </p>
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




