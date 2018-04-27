<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
    
     <link rel="stylesheet" href="resources/js/chosen/docsupport/style.css">
  <link rel="stylesheet" href="resources/js/chosen/docsupport/prism.css">
  <link rel="stylesheet" href="resources/js/chosen/chosen.css">
  <style type="text/css" media="all">
    /* fix rtl for demo */
    .chosen-rtl .chosen-drop { left: -9000px; }
  </style>
    
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
		<%
    	pageContext.setAttribute("contextPath", request.getContextPath()+"/");
    %>
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
        
	   <script src="resources/js/modernizr-2.6.2.min.js"></script>
	
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js">
        </script>
   
   <script>
  $(function () {
      $("#datepickerfrom").datepicker({dateFormat: 'dd/mm/yy'});
  });
  
  $(function () {
      $("#datepickerto").datepicker({dateFormat: 'dd/mm/yy'});
  });
  </script>

<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">

function populateItemCode() {
	
	var itemCodeId = document.getElementById('itemCodeId').value;
	  
    AjaxHelper.getItemNameId(itemCodeId, populateGroupCodeCallback);       
}        


function populateGroupCodeCallback( data ) {
    
	window.alert("Data  "+data);
	 document.getElementById('itemNameId').value = data;
	       
}

function populateVendorCode() {
	
	var vendorNameId = document.getElementById('vendorId').value;
	window.alert("Data  "+vendorNameId);
	AjaxHelper.getVendorNameById(vendorNameId, populateVendorCodeCallback);
	

} 

function populateVendorCodeCallback( data ) {

	window.alert("Data  "+data);
	dwr.util.setValue('vendorName',data);

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
	  
//	alert(1);
    var x = document.getElementById("debitIdId").value;
    if (x == "") {
        alert("Please enter Debit Entry Id.");
        document.getElementById("debitIdId").focus();
        return false;
    }
    
    var y = document.getElementById("vendorId").value;
    if (y == "") {
        alert("Please enter Vendor Name.");
        document.getElementById("vendorId").focus();
        return false;
    }
    
    var x = document.getElementById("itemCodeId").value;
    if (x == "") {
        alert("Please enter Item Name.");
        document.getElementById("itemCodeId").focus();
        return false;
    }
    
    var y = document.getElementById("debitamountId").value;
    if (y == "") {
        alert("Please enter Debit Amount.");
        document.getElementById("debitamountId").focus();
        return false;
    }	
    var x = document.getElementById("datepickerfrom").value;
    if (x == "") {
        alert("Please enter Transaction Date.");
        document.getElementById("datepickerfrom").focus();
        return false;
    }
    var y = document.getElementById("remarksId").value;
    if (y == "") {
        alert("Please enter Remarks.");
        document.getElementById("remarksId").focus();
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
 
<form action="/rebatetest/saveDabit.html" method="post" class="registerLarge" onsubmit="return validateForm()">
 <fieldset class="row1">
                <legend>Debit Entry Form
                </legend>

 <p>
                    <label>Debit Entry Id
                    </label>
                    <input type="text" name="debitId" id="debitIdId" />
                    </p>
               
                <script src="resources/js/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="resources/js/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
                    
           <p>
                    <label>Vendor Name
                    </label>
               <select name="vendorId" id="vendorId"  onchange="populateVendorCode()" 
               data-placeholder="--Please select----"  class="chosen-select" style="width: 200px;"  >
               <option value="">--Please Select--</option>
			<c:forEach items="${vendors}" var="vendor">
			<option value="${vendor.vendorId}" ><c:out value="${vendor.vendorName}"></c:out></option>
			</c:forEach>
			</select>
                   
                      
                      <input type="hidden" name="vendorName" value="" id="vendorName">
            </p>
            <p>
                 
                   <label>Item Name
                    </label>
         			 <select name="itemCode"  id="itemCodeId"  onchange="populateItemCode()">
         			  <option>--Please Select--</option>
					<c:forEach items="${items}" var="item">
					<option value="${item.itemCode }"><c:out value="${item.itemName }"></c:out></option>
				</c:forEach>
				</select>
                    
       				<input type="hidden" name="itemName" id="itemNameId"  />
				</p>
             
              <p>
                    <label>Debit Amount
                    </label>
                    <input type="text" name="debitAmount" id="debitamountId"/>
		<label>Transaction Date
                    </label>
		<input type="text" id="datepickerfrom"  name="transacDate" />
             </p>
                <p>
                    <label>Remarks
                    </label>
                    <textarea rows="4" cols="30" name="remarks" id="remarksId"></textarea>
		
             </p>
             
             
                </fieldset>
                <div>
                
      
          <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
		<a href="listDebit.html" id="submit" class="btn btn-blue btn-effect">View</a>
		<a href="adminBack.html" id="submit" class="btn btn-blue btn-effect">Back</a>
		   </div>
		</form>
		
 


	
	</div>
						</div>
					</div>
				</div>
			</section> 
		</main>
		
		<script type="text/javascript">
     var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width: "95%"}
    } 
    for (var selector in config) {
      $(selector).chosen(config[selector]);
      
     // $(".chosen").chosen({width: "inherit"});
    }
  </script>
		
		        <%@ include file="footer.jsp" %>
		
        
	
    </body>
</html>







