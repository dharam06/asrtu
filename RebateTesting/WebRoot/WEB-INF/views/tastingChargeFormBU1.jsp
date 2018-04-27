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
        <meta name="author" content="">
		
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
  
  $(function () {
      $("#datepickerto").datepicker({dateFormat: 'dd/mm/yy'});
  });
  </script>
  <script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
  <script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
  <script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
  <script type="text/javascript">
 
  function populateServiceTax() {
		var DateFrom = document.getElementById('datepickerfrom').value;
		window.alert("Date  "+DateFrom);
		AjaxHelper.getServiceTax(DateFrom, populateServiceTaxCallback);  
	   
	} 
  function populateServiceTaxCallback( data ) {
		window.alert("Data  "+data);
		dwr.util.setValue('serviceTaxId',data);
		
	       
	}
  
function populateGroupCode() {
	var itemGroupNameId = document.getElementById('itemGroupNameId').value;
	window.alert("Data  "+itemGroupNameId);
	AjaxHelper.getGroupByItemDetails(itemGroupNameId, populateGroupCodeCallback);  
   
}        

function populateGroupCodeCallback( data ) {
	window.alert("Data  "+data);
	dwr.util.setValue('itemGroupCodeId',data);
	
       
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


function populateBankCode() {
	
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {
	

	window.alert("Data  "+data);    

	dwr.util.setValue('bankCodeId',data);
       
}


function populateServiceTaxAmount( ) {
	
	alert(1)
	
	var serviceTax = document.getElementById('serviceTaxID').value;
	var testCharge = document.getElementById('testChargeID').value;
	
	document.getElementById('serviceTaxAmountID').value = serviceTax*testCharge/100;
	document.getElementById('netTestChargeID').value = testCharge - serviceTax*testCharge/100;
      
}

function populateItemGroupName() {
	
	alert(1);
	
	var vendorId = document.getElementById('vendorId').value;
	
	alert(1);
	 
    AjaxHelper.getItemGroupByVendorID(vendorId, populateItemGroupNameCallback); 
} 

function populateItemGroupNameCallback( data ) {
	

	window.alert("Data  "+data);    

	//dwr.util.setValue('bankCodeId',data);

	//alert('onLoad');


	//productCategoryObject = eval('('+data+')');
	
	var jsonData = "'("+data+")'";
	
	alert(jsonData);
	
	
	//productCategoryObject   = eval('({\"1\":\"Hello1\",\"2\":\"Hello2\",\"3\":\"Hello3\",\"4\":\"Hello4\"})');

	
	//productCategoryObject   = eval(jsonData);
	
	
	 productCategoryObject = JSON.parse(data)
	alert(''+productCategoryObject);
	
	//addElement();
   // alert("Page is loaded");
   
      
	var productCategoryCombo = document.getElementById('itemGroupNameId');

	//alert('productCategoryCombo :'+productCategoryCombo);

	//alert('productCategoryObject :'+productCategoryObject);

	displayDropDown(productCategoryObject, productCategoryCombo, '', 'testchargeform');
}

function displayDropDown(object, comboName, selectedVal, formName){
	
	// alert('displayDropDown'); 
	
	 var combo;
        
    combo = comboName;
    combo.options[0] = new Option("--Please Select--", "0");
	
	for (var i in object){
	   combo.options[combo.options.length] = new Option( object[i],i);
	} 
    for ( var i = 0; i < combo.options.length; i++ ) {
        if ( combo.options[i].value == selectedVal ) {
            combo.options[i].selected = true;
            return;
        }
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
								
 


<form action="/rebatetest/saveTestings.html" method="post" class="register"  autocomplete="off">
<fieldset class="row1">
                <legend>Testing Charge  Form
                </legend>
              
                <p>
                 
                    <label>Receipt Date
                    </label>
                  <input type="text" name="receiptDate"  id="datepickerfrom" onchange="populateServiceTax()" /> 
                   
                  </p>
                 
               <p>
                    <label>Vendor Name
                    </label>
               <select name="vendorId" id="vendorId" onchange="populateItemGroupName()" >
               <option>--Please Select--</option>
			<c:forEach items="${vendors}" var="vendor">
			<option value="${vendor.vendorId}" ><c:out value="${vendor.vendorName}"></c:out></option>
			</c:forEach>
			</select>
                   
                      
                      <input type="hidden" name="vendorName" value="" id="vendorName">
            
                 
                   <label>Item Group Name 
                    </label>
         			  <select name="itemCode"  id="itemGroupNameId"  onchange="populateGroupCode()">
         			  <option>--Please Select--</option>
					<c:forEach items="${itemGroup}"  var="itemBean">
					<option value="${itemBean.itemGroupCode}" > <c:out value="${itemBean.itemGroupName}" /> </option>
				</c:forEach>
				</select>
                   
       				<input type="hidden" name="itemName" id="itemGroupCodeId" >
				</p>
				<p>
				<label>Service Tax Applicable
                    </label>
				<input type="text" name="serviceTax" id="serviceTaxId" READONLY >
				     <label>Testing Charge
                    </label>
            		 <input type="text" name="testCharge" id="testChargeID" />
            		
            		 </p>
            		  <p>
            		 <label>Service Tax Amount
                    </label>
            		 <input type="text" name="serviceTaxAmount" id="serviceTaxAmountID" READONLY/>
            		 </p>
            		  <p>
                   <label>Net Testing Charge
                    </label>
                    <input type="text" name="netTestCharge" onfocus="populateServiceTaxAmount()" id="netTestChargeID" READONLY>
                  
                    <label>Bank Name
                    </label>
            		<select name="bankCode" id="bankNameId"  onchange="populateBankCode()" typehead="true">
				<option>--Please Select--</option>
				<c:forEach items="${bankNames}" var="bank">
			<option value="${bank.bankCode}"><c:out value="${bank.bankName}"/></option>
			</c:forEach>
			</select>
                   
                    <input type="hidden" name="bankName" id="bankCodeId" />
                  </p>
				<p>
                    <label>Cheque No.
                    </label>
            		 <input type="text" name="chqNo" />
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

					</div>	
	
						</div>
					</div>
				</div>
			</section> 
		
 
		</main>
		
		        <%@ include file="footer.jsp" %>
		
    </body>
</html>