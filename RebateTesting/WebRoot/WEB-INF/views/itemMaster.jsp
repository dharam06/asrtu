 <!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
    <%@page import="org.springframework.beans.factory.annotation.Autowired"%>
        <%@ page import="java.io.*,java.util.*,java.sql.*"%>
	<%@page import="com.asrtu.model.ItemGroup"%>
<%@page import="com.asrtu.bean.ItemGroupBean"%>
<%@page import="com.asrtu.service.ItemGroupService"%>
	
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

<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">

function populateGroupCode() {
	var itemGroupNameId = document.getElementById('itemGroupNameId').value;
	window.alert("Data  "+itemGroupNameId);
	AjaxHelper.getGroupByItemDetails(itemGroupNameId, populateGroupCodeCallback);  
   
}        

function populateGroupCodeCallback( data ) {
	window.alert("Data  "+data);
	dwr.util.setValue('itemGroupCodeId',data);
	
       
}

function validateForm() {
    var x = document.forms["myForm"]["transId"].value;
    var y = document.forms["myForm"]["billNo"].value;
    var amount = document.forms["myForm"]["billAmount"].value;
    if (x == null || x == "") {
        alert("Transation Id must be filled");
        return false;
    }
	    else if (y == null || y == "") {
        alert("Bill must be filled.");
        return false;
    }
    else if(amount == null || amount == ""){
    	alert("Amount must be filled.");
    }
    
}

</script>
 <script type="text/javascript">
  
   function validateForm() {
	  
    var x = document.getElementById("itemCodeId").value;
    if (x == "") {
        alert("Please enter Item Code.");
        document.getElementById("itemCodeId").focus();
        return false;
    }
    
    var y = document.getElementById("itemNameId").value;
    if (y == "") {
        alert("Please enter Item Name.");
        document.getElementById("itemNameId").focus();
        return false;
    }
    var x = document.getElementById("specificationId").value;
    if (x == "") {
        alert("Please enter Specification.");
        document.getElementById("specificationId").focus();
        return false;
    }
    
    var y = document.getElementById("quantityId").value;
    if (y == "") {
        alert("Please enter Minimum Quantity.");
        document.getElementById("quantityId").focus();
        return false;
    }
    var x = document.getElementById("tchargeId").value;
    if (x == "") {
        alert("Please enter Testing Charge ");
        document.getElementById("tchargeId").focus();
        return false;
    }
    
    var y = document.getElementById("partNoId").value;
    if (y == "") {
        alert("Please enter Part No.");
        document.getElementById("partNoId").focus();
        return false;
    }
    
    var y = document.getElementById("itemGroupNameId").value;
    if (y == "") {
        alert("Please enter Item Group Name.");
        document.getElementById("itemGroupNameId").focus();
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
					<h3 align="center" style="color: red;"><c:out value="${message1}"/></h3>

<form action="/rebatetest/saveItmMaster.html" method="post" class="register" onsubmit="return validateForm()">
<fieldset class="row1">
                <legend>Product Master
                </legend>
              
                <p>
                    <label>Item Code
                    </label>
                   <input type="text" name="itemCode" id="itemCodeId"/>
                    <label>Item Name
                    </label>
                   <input type="text" name="itemName" id="itemNameId"/>
                   
                  </p>
                 
               <p>
                    <label>Specification
                    </label>
                <input type="text" name="specification" id="specificationId" />
                   <label>Minimum Quantity
                    </label>
                 <input type="text" name="quantity" id="quantityId" />
                  </p>
                   <p>
                    <label>Testing Charge
                    </label>
               <input type="text" name="tCharge" id="tchargeId" />
                   <label>Part No.
                    </label>
          		 <input type="text" name="partNo" id="partNoId" />
                  </p>
                  <p>
                 <label>Item Group Name 
                    </label>
         			  <select name="itemGroupCode"  id="itemGroupNameId"  onchange="populateGroupCode()">
         			  <option value="">--Please Select--</option>
					<c:forEach items="${itemGroup}"  var="itemBean">
					<option value="${itemBean.itemCode}" > <c:out value="${itemBean.itemName}" /> </option>
				</c:forEach>
				</select>
                   
             <input type="hidden" name="itemGroupName" id="itemGroupCodeId" >
</p>



                   </fieldset>
                   <div>
         <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
	<a href="listItemMaster.html" id="submit" class="btn btn-blue btn-effect">View</a>
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

