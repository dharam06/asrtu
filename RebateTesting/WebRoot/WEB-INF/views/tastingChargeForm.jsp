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
     <%@ page import="com.astru.util.DropDownUtil" %>
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
		<link rel="stylesheet" href="resources/css/formRebate.css">
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
  <script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
  <script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
  <script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
  <script type="text/javascript">
  
  function populateServiceTax() {
	//  alert(1);
		var DateFrom = document.getElementById('datepickerfrom').value;
		//window.alert("Date  "+DateFrom);
		AjaxHelper.getServiceTax(DateFrom, populateServiceTaxCallback);  
	   
	} 
function populateServiceTaxCallback( data ) {
		//window.alert("Data  "+data);
		dwr.util.setValue('serviceTaxID',data);
		
} 
 
function populateGroupCode() {
	var itemGroupNameId = document.getElementById('itemGroupNameId').value;
	//window.alert("Data  "+itemGroupNameId);
	AjaxHelper.getGroupByItemDetails(itemGroupNameId, populateGroupCodeCallback);  
   
}        

function populateGroupCodeCallback( data ) {
	//window.alert("Data  "+data);
	dwr.util.setValue('itemGroupCodeId',data);
	
	
	
       
}
function populateVendorCode() {
	
	var vendorNameId = document.getElementById('vendorId').value;
	//window.alert("Data  "+vendorNameId);
	AjaxHelper.getVendorNameById(vendorNameId, populateVendorCodeCallback);
	



	
} 

function populateVendorCodeCallback( data ) {

	//window.alert("Data  "+data);
	dwr.util.setValue('vendorName',data);

}


function populateBankCode() {
	
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {
	

	//window.alert("Data  "+data);    

	dwr.util.setValue('bankCodeId',data);
       
}


function populateServiceTaxAmount() {
	
	//alert('populateServiceTaxAmount'); 
	
	var serviceTax = document.getElementById('serviceTaxID').value;
	//alert(serviceTax); 
	var testCharge = document.getElementById('testChargeID').value;
	//alert(testCharge); 
	
	var divisor = 100 + parseInt(serviceTax);
	//alert(divisor);
	
	//document.getElementById('serviceTaxAmountID').value = serviceTax*testCharge/100;
	//document.getElementById('netTestChargeID').value = testCharge - serviceTax*testCharge/100;
	//alert(100*testCharge); 
	//alert((100+serviceTax)); 
	
	var temp = 100*testCharge/divisor;
	//var tc = Math.round(temp * 100) / 100;
	var tc = Math.round(temp);
	//alert(testCharge);
	
	document.getElementById('netTestChargeID').value = tc;
	document.getElementById('serviceTaxAmountID').value = Math.round(testCharge - tc);
     
}

 function populateItemGroupName() {
	
	//alert(1);
	
	var vendorId = document.getElementById('vendorId').value;
	
	//alert(vendorId);
	 
    AjaxHelper.getItemGroupByVendorID(vendorId, populateItemGroupNameCallback); 
}  

function populateItemGroupNameCallback( data ) {
	

	//window.alert("Data  "+data);    
	
	document.getElementById("itemGroupNameId").innerHTML = data;


}



function validateForm() {

	
	//alert(1);
    
    var vendorId = document.getElementById('vendorId').value;
	//alert(vendorId);
    if (vendorId == null || vendorId == "" ||  vendorId == 0) {
        alert("Please select Vendor Name");
        return false;
    }    
    
    var groupCodeId = document.getElementById('itemGroupNameId').value;
    if (groupCodeId == null || groupCodeId == "" ||  groupCodeId == 0) {
        alert("Please select Item Group Name");
        return false;
    } 
    
    var serviceTaxID = document.getElementById('serviceTaxID').value;
    if (serviceTaxID == null || serviceTaxID == "" ) {
        alert("Please enter Receipt Date to calculate Service Tax Applicable");
        return false; 
    } 
    
    var testChargeID = document.getElementById('testChargeID').value;
    if (testChargeID == null || testChargeID == "" ) {
        alert("Please enter Testing Charge");
        return false;
    } 
    
	
    var serviceTaxAmountID = document.getElementById('serviceTaxAmountID').value;
    if (serviceTaxAmountID == null || serviceTaxAmountID == "") {
        alert("Please enter Service Tax Amount");
        return false;
    } 
    
    var netTestChargeID = document.getElementById('netTestChargeID').value;
    
   // alert("netTestChargeID "+netTestChargeID);
    
    if (netTestChargeID == null || netTestChargeID == "") {
        alert("Please enter Net Testing Charge");
        return false;
    } 
    
    var bankNameId = document.getElementById('bankNameId').value;
    if (bankNameId == null || bankNameId == "" ||  bankNameId == 0) {
        alert("Please enter Bank Name");
        return false;
    } 
    
    var chqNoId = document.getElementById('chqNoId').value;
    if (chqNoId == null || chqNoId == "") {
        alert("Please enter Cheque No.");
        return false;
    } 
    
    var datepickerto = document.getElementById('datepickerto').value;
    if (datepickerto == null || datepickerto == "") {
        alert("Please enter Cheque Date");
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

<form action="/rebatetest/saveTestings.html" method="post" class="registerLarge" autocomplete="off" name="testchargeform" onsubmit="return validateForm()">
<fieldset class="row1">
                <legend>Testing Charge  Form
                </legend>
              
                <p>
                 
                    <label>Receipt Date
                    </label>
                  <input type="text" name="receiptDate"  id="datepickerfrom"  onchange="populateServiceTax()"/> 
                   
                  </p>
                 
   <script src="resources/js/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="resources/js/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
 
               <p>
                    <label>Vendor Name
                    </label>
               <select name="vendorId" id="vendorId" data-placeholder="--Please select----"  class="chosen-select"   onchange="populateItemGroupName()" >
               <option value=0>--Please Select--</option>
			<c:forEach items="${vendors}" var="vendor">
			<option value="${vendor.vendorId}" ><c:out value="${vendor.vendorName}"></c:out></option>
			</c:forEach>
			</select>
                   
           	</p>
				<p>
			
                 
                   <label>Item Group Name 
                    </label>
         			  <select name="itemCode"  id="itemGroupNameId">
       
				</select>
                   
       				<input type="hidden" name="itemName" id="itemGroupCodeId" >
				</p>
				<p>
				<label>Service Tax Applicable
                    </label>
				<input type="text" name="serviceTax" id="serviceTaxID" READONLY >
				     <label>Testing Charge
                    </label>
            		 <input type="text" name="testCharge" id="testChargeID" />
            		
            		 </p>
            		  <p>
            		 <label>Service Tax Amount
                    </label>
            		 <input type="text" name="serviceTaxAmount" onfocus="populateServiceTaxAmount()" id="serviceTaxAmountID" READONLY/>
            		 </p>
            		  <p>
                   <label>Net Testing Charge
                    </label>
                    <input type="text" name="netTestCharge" onfocus="populateServiceTaxAmount()" id="netTestChargeID" READONLY>
                  
                    <label>Bank Name
                    </label>
            		<select name="bankCode" id="bankNameId"  onchange="populateBankCode()" typehead="true">
				<option value="0">--Please Select--</option>
				<c:forEach items="${bankNames}" var="bank">
			<option value="${bank.bankCode}"><c:out value="${bank.bankName}"/></option>
			</c:forEach>
			</select>
                   
                    <input type="hidden" name="bankName" id="bankCodeId" />
                  </p>
				<p>
                    <label>Cheque No.
                    </label>
            		 <input type="text" name="chqNo" id="chqNoId"   />
                   <label>Cheque Date
                    </label>
                   <input type="text" name="chqDate"  id="datepickerto" />
                  </p>
                  <p>
                    <label>Remarks
                    </label>
            		 <textarea rows="3" cols="22" name="remark" ></textarea>
                   
                  </p>
				
                   </fieldset>
                <div>
                   <div>
         <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
	<a href="viewTesting.html" id="submit" class="btn btn-blue btn-effect">View</a>
	<a href="adminBack.html"  id="submit" class="btn btn-blue btn-effect"> Back</a>
		   </div>
   
</form>	

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
  
					</div>	
	
						</div>
					</div>
				</div>
			</section> 
		
 
		</main>
		
		        <%@ include file="footer.jsp" %>
		
    </body>
</html>