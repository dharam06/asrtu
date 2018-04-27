
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="en" class="no-js"> <!--<![endif]-->
    <head>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<!-- meta character set -->
        <meta charset="utf-8">
     
		<!-- Always force latest IE rendering engine or request Chrome Frame -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>ASRTU</title>		
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
    	    var x = document.forms["myForm"]["name"].value;
    	    var y = document.forms["myForm"]["pass"].value;
    	    if (x == null || x == "") {
    	        alert("Please enter User ID");
    	        return false;
    	    }
    	    else if (y == null || y == "") {
    	        alert("Please enter Password");
    	        return false;
    	    }
    	}
</script> 
			
 

    </head>
	
    <body id="body">

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
                    </button>
					<!-- /responsive nav button -->
					
					<!-- logo -->
					<h1 class="navbar-brand">
					<a href="#body">ASRTU</a></h1>
					
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
														
<h3  align="center" style="color: red;"><c:out value="${message1}"/></h3>
		
							 
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
          <h1 class="text-center">Login</h1>
      </div>
      <div class="modal-body">
          <form class="form col-md-12 center-block" method="post" name="myForm"  action="/rebatetest/loginform.html" onsubmit="return validateForm()">
            <div class="form-group">
              <input type="text" class="form-control input-lg" placeholder="User ID" name="name" >
            </div>
            <div class="form-group">
              <input type="password" class="form-control input-lg" placeholder="Password" name="pass">
            </div>
            <div class="form-group">
              <button class="btn btn-primary btn-lg btn-block" type="submit">Sign In</button>
             

            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div class="col-md-12">
           
		  </div>	
      </div>
  </div>
  </div>
</div>							
	
					
										<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							<div>&nbsp;</div>
							
					
					</div>	
	
						</div>
					</div>
				</div>
			</section> 
		
 
		</main>
		
		        <%@ include file="footer.jsp" %>
		        
		        
		
    </body>
</html>
