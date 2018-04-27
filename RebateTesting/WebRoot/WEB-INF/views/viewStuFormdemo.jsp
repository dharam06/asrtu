


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
        <title>ASRTU-Admin</title>		
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
        

  <style >

tr.even {
    font-weight: normal;
    background: #8C7E6C;
    color: #039;
    
    
}

tr.odd {
    font-weight: normal;
    background: #6D7B8D;
    color: #039;
    
}

th {

    background: #7D0552;

}

 </style>

	
    <body id="body">

		<!-- preloader -->
		<div id="preloader">
            <div class="loder-box">
            	<div class="battery"></div>
            </div>
		</div>
		<!-- end preloader -->

        <!--
        Fixed Navigation
        ==================================== -->
        <header id="navigation" class="navbar-inverse navbar-fixed-top animated-header">
            <div class="container">
                <div class="navbar-header">
                    <!-- responsive nav button -->
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
                    </button>
					<!-- /responsive nav button -->
					
					<!-- logo -->
					<h1 class="navbar-brand">
					
						<a href="#body" style="color: white;">ASRTU</a>
				
					</h1>
						
					<h1 class="navbar-brand"  align="right">
					<c:out value="${message}" />-&nbsp;<c:out value="${userName}"/>|
					 <a href="SignOut.html" style="color: white;">Log Out</a>
				</h1>
					<!-- /logo -->
                </div>

				<!-- main nav -->
                <nav class="collapse navbar-collapse navbar-right" role="navigation">
                    <ul id="nav" class="nav navbar-nav">
                         <li><a href="#body"></a></li>
                      
                    </ul>
                </nav>
				<!-- /main nav -->
				
            </div>
        </header>
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
										
<h2 align="center" style="color: white;">List Stu Master</h2>


<c:if test="${!empty stuMasters}">
<div class="table-responsive">
  <table class="table table-condensed table-striped table-bordered table-hover no-margin" align="center">
    <thead>
      <tr>
        <th style="width:5%">S.No.</th>
        <th style="width:10%">Name</th>
        <th style="width:05%" class="hidden-phone">Code</th>
        <th style="width:5%" class="hidden-phone">Model Code</th>
         <th style="width:5%" class="hidden-phone">Model Name</th>
         <th style="width:10%" class="hidden-phone">Division</th>
        <th style="width:10%" class="hidden-phone">Address 1</th>
         <th style="width:12%" class="hidden-phone">Address 2</th>
        <th style="width:13%" class="hidden-phone">Address 3</th>
        <th style="width:5%" class="hidden-phone">Pincode</th>
         <th style="width:5%" class="hidden-phone">Phone No.</th>
          <th style="width:10%" class="hidden-phone">E-mail Id</th>
        <th style="width:15%" class="hidden-phone">Actions</th>
        
        
			
        
		
      </tr>
    </thead>
    <tbody>
   
	<c:forEach items="${stuMasters}" var="stu" varStatus="status">		
			
			
		
     <tr class="${status.count % 2 == 0 ? 'even' : 'odd'}"
                ${status.count % 2 == 0 ? 'even' : 'odd'}>
       
        <td>
          <span class="name"><c:out value="${stu.sno}"/></span>
        </td>
         <td>
          <span class="name"><c:out value="${stu.name}"/></span>
        </td>
        
        <td class="hidden-phone"><c:out value="${stu.code}"/></td>
        <td>
          <span class="name"><c:out value="${stu.modelCode}"/></span>
        </td>
        <td>
          <span class="name"><c:out value="${stu.modelName}"/></span>
        </td>
        <td>
          <span class="name"><c:out value="${stu.division}"/></span>
        </td>
        <td class="hidden-phone">
         <c:out value="${stu.add1}"/>
        </td>
        <td>
          <span class="name"><c:out value="${stu.add2}"/></span>
        </td>
        <td class="hidden-phone"><c:out value="${stu.add3}"/></td>
        <td class="hidden-phone"><c:out value="${stu.pincode}"/></td>
        <td class="hidden-phone"><c:out value="${stu.phoneNo}"/></td>
         <td class="hidden-phone"><c:out value="${stu.email}"/></td>
               
        <td class="hidden-phone">
          <div class="btn-group">
                     <a href="editStu.html?sno=${stu.sno}" style="color: white;">Edit</a> &nbsp; &nbsp;
            <a href="deleteStu.html?sno=${stu.sno}" style="color: white;">Delete</a>
             
            
          </div>
        </td>
      </tr>
         </c:forEach>    
         </tbody>
</table>
</div>
</c:if>



<div>
<p align="center">Click the download link below:<br></p>
<a href="stuDownloadXls.html" id="submit" class="btn btn-blue btn-effect">Download Excel</a>
<a href="stuDownloadPdf.html" id="submit" class="btn btn-blue btn-effect">Download PDF</a>
<a href="viewStuBack.html"  id="submit" class="btn btn-blue btn-effect">Back</a>

		</div>
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
						
					</div>   -->
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
				
				</div>	-->
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
		
		</section>-->
		
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








