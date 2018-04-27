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
        <title>ASRTU-Rebate</title>		
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
        
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    
  <script>
$(function() {
    $( ".datepicker" ).datepicker();
});
</script>

	
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
							&nbsp;
							</div>
							<div class="sec-title text-center white wow animated fadeInDown">
							
	<h3  align="center" style="color: orange;"><c:out value="${message1}"/></h3>			
<h2 align="center" style="color: orange;">Stu Master Entry Form</h2>
<form action="/rebatetest/saveStu.html" method="POST">
<table  align="center">
<tr>
<td width="50%">S.No.</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="sno" value="${stuMaster.sno}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Name</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="name" value="${stuMaster.name}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Code</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="code" value="${stuMaster.code}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Model Code</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="modelCode" value="${stuMaster.modelCode}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Model Name</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="modelName" value="${stuMaster.modelName}"  width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Division</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="division" value="${stuMaster.division}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Address&nbsp;1</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="add1" value="${stuMaster.add1}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Address&nbsp;2</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="add2" value="${stuMaster.add2}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Address&nbsp;3</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="add3" value="${stuMaster.add3}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Pincode</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="pincode" value="${stuMaster.pincode}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">Phone No.</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="phoneNo" value="${stuMaster.phoneNo}" width="50" style="color: black;"></td>
</tr>
<tr>
<td width="50%">E-mail Id</td><td width="1%">&nbsp;</td><td width="49%"><input type="text" name="email" value="${stuMaster.email}" width="50" style="color: black;"></td>
</tr>
<tr>
<td>&nbsp;</td><td width="1%">&nbsp;</td>
<td>
<input type="submit" value="Save" style="width: 60px;height: 30px;color: orange;">
<input type="reset" value="Reset" style="width: 60px;height: 30px;color: orange;">
<a href="viewStu.html" style="text-decoration: none;color: black;background: yellow;"><input type="button"  style="background: yellow; border: none">View</a>
<a href="adminBack.html"  style="text-decoration: none;color: black;background: yellow;"><input type="button"  style="background: yellow; border: none"> Back</a>

</td>


</tr>
</table>
</form>

	<c:if test="${!empty stuMasters}">

	<table align="center" border="1">
		<tr>
			<th>S.No.</th>
			<th>Name</th>
			<th>Code</th>
			<th>Model Code</th>
			<th>Model Name</th>
			<th>Division</th>
			<th>Address 1</th>
			<th>Address 2</th>
			<th>Address 3</th>
			<th>Pincode</th>
			<th>Phone No.</th>
			<th>E-mail Id</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${stuMasters}" var="stu">
			<tr>
				<td><c:out value="${stu.sno}"/></td>
				<td><c:out value="${stu.name}"/></td>
				<td><c:out value="${stu.code}"/></td>
				<td><c:out value="${stu.modelCode}"/></td>
				<td><c:out value="${stu.modelName}"/></td>
				<td><c:out value="${stu.division}"/></td>
				<td><c:out value="${stu.add1}"/></td>
				<td><c:out value="${stu.add2}"/></td>
				<td><c:out value="${stu.add3}"/></td>
				<td><c:out value="${stu.pincode}"/></td>
				<td><c:out value="${stu.phoneNo}"/></td>
				<td><c:out value="${stu.email}"/></td>
				
				<td align="center"><a href="editStu.html?sno=${stu.sno}" style="color: white;">Edit</a> | <a href="deleteStu.html?sno=${stu.sno}" style="color: white;">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
							</div>
						
	
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
		
		</section> -->
		
        <!--
        End Home SliderEnd
        ==================================== -->
			
			<!-- about section -->
			<section id="about" >
				<div class="container">
					<div class="row">
					<!-- 
						<div class="col-md-4 wow animated fadeInLeft">
				
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
								
							</div>
						</div>
										
						</div> -->
							
						
	
		</div>
				</div>
			</section>
			<!-- end about section -->
			
			
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











