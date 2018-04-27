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


 function populateItemGroupName() {
	
	alert('populateItemGroupName');
	
	var vendorId = document.getElementById('vendorId').value;
	
	alert(vendorId);
	 
    AjaxHelper.getItemGroupByVendorID(vendorId, populateItemGroupNameCallback); 
}  

function populateItemGroupNameCallback( data ) {
	
	//alert(data);
	document.getElementById("groupCodeId").innerHTML = data;
} 

function populateSubGroup() {
	
	//alert('populateSubGroup');
	var groupCodeId = document.getElementById('groupCodeId').value;
	//alert(groupCodeId);
    AjaxHelper.getSubGroupByGroupID(groupCodeId, populateSubGroupCallback); 
}  

function populateSubGroupCallback( data ) {
	
	//alert(data);
	document.getElementById("subGroupId").innerHTML = data;
} 
function populateItemCode() {
	
	
	var subGroupId = document.getElementById('subGroupId').value;
	
    AjaxHelper.getItemBySubGroupID(subGroupId, populateItemCodeCallback); 
}  

function populateItemCodeCallback( data ) {
	document.getElementById("itemId").innerHTML = data;
} 
function populateTestChargeMQ() {
	
	var itemId = document.getElementById('itemId').value;
	
    AjaxHelper.getTestChargeByItemID(itemId, populateTestChargeCallback); 
}  

function populateTestChargeCallback( data ) {
	//alert(data);
	var str = data;
	//alert(str);
	var res = str.split(":");
	//var mySplitResult;
	// Use the string.split function to split the string
	//mySplitResult = myString.split();
	for(i = 0; i < res.length; i++)
	  {
	    //document.write("<br /> Element " + i + " = " + res[i]);
	    //alert("SPLIT"+res[0]);
	    
	    document.getElementById("quantityId").value= res[0];
	    document.getElementById("testChargeId").value = res[1];
	  }
	//document.getElementById("testChargeId").innerHTML = data;
	
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

<form action="/rebatetest/saveStoOrder.html" method="post" class="register" >
<fieldset class="row1">
                <legend>STO Issue Form </legend>
                
                <p>
                 <label>STO Transaction Id
                    </label>
                    <input type="text" name="stoTransId" value="${stoOrder.stoTransId}" >
                     <label>STO No.
                    </label>
                    <input type="text" name="stoNo" value="${stoOrder.stoNo}" >
                </p>
                
                 <p>
                    <label>Vendor Name
                    </label>
               <select name="vendorId" id="vendorId" value="${stoOrder.vendorId}" onchange="populateItemGroupName()" >
               <option>--Please Select--</option>
			<c:forEach items="${vendors}" var="vendor">
			<option value="${vendor.vendorId}" ><c:out value="${vendor.vendorName}"></c:out></option>
			</c:forEach>
			</select>
                   
                      
                      
            
                 
                   <label>Item Group Name
                    </label>
         			 <select name="producGroupCode"  id="groupCodeId"  onchange="populateSubGroup()">
         			 
				</select>
                    
       				
				</p>
				
				<p>
				
				    <label>Item Sub Group Name
                    </label>
         			 <select name="productSubGroupCode"  id="subGroupId"  onchange="populateItemCode()">
         			 
         			  
				
				</select>
				
				</p>
             <p>
             
                                <label>Item  Name
                    </label>
         			 <select name="itemCode"  id="itemId" onchange="populateTestChargeMQ()" >
         			
				</select>
             </p>
							   
                   <p>
                    <label>Testing Charge
                    </label>
            		 <input type="text" name="testCharge" value="${stoOrder.testCharge}"  id="testChargeId" />
                   <label>STO Date
                    </label>
                    <input type="text" name="testDate" value="${stoOrder.testDate}"   id="datepickerfrom" /> 
                  </p>
               <p>
                    <label>Minimum Quantity
                    </label>
            		<input type="text" name="quantity" value="${stoOrder.quantity}"  id="quantityId" />
                   <label>Net Available Amount
                    </label>
                  <input type="text" name="netAmount" value="${stoOrder.netAmount}"  />
                  </p>
                  <p>
                    <label>Remarks
                    </label>
            		 <textarea rows="3" cols="21" name="remarks" value="${stoOrder.remarks}" ></textarea>
                   
                  </p>
				
                   </fieldset>
                   	<div>
      <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
	<a href="viewStoForm.html" id="submit" class="btn btn-blue btn-effect">View</a>
	<a href="editStoBack.html"  id="submit" class="btn btn-blue btn-effect">Back</a>
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





