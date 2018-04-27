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
        <title>ASRTU-Admin </title>		
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
  
  $(function () {
      $("#datepickerto").datepicker({dateFormat: 'dd/mm/yy'});
  });
  </script>

<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">


function populateGroupCode() {
	var itemGroupNameId = document.getElementById('itemGroupNameId').value;

	AjaxHelper.getGroupByItemDetails(itemGroupNameId, populateGroupCodeCallback);  
  
}        

function populateGroupCodeCallback( data ) {
	
	

	dwr.util.setValue('itemGroupCodeId',data);
	
       
}
function populateVendorCode() {
	
	var vendorNameId = document.getElementById('vendorNameId').value;
	
	AjaxHelper.getVendorNameId(vendorNameId, populateVendorCodeCallback);
	
} 

function populateVendorCodeCallback( data ) {

	dwr.util.setValue('vendorId',data);
	 
}

function populateBankCode() {
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {

	dwr.util.setValue('bankCodeId',data);
       
}
function populateServiceTaxAmount() {
	
	//alert('populateServiceTaxAmount'); 
	
	var serviceTax = document.getElementById('serviceTaxID').value;
	//alert(serviceTax); 
	var testCharge = document.getElementById('testChargeID').value;
	//alert(testCharge); 
	
	document.getElementById('serviceTaxAmountID').value = serviceTax*testCharge/100;
	document.getElementById('netTestChargeID').value = testCharge - serviceTax*testCharge/100;
      
}
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
								&nbsp;
							</div>
							<div class="sec-title text-center white wow animated fadeInDown">
								 
<h3  align="center" style="color: red;"><c:out value="${message1}"/></h3>

<form action="/rebatetest/saveTestings.html" method="post" class="register" >
<fieldset class="row1">
                <legend>Testing Charge  Form
                </legend>
                 <p>
                 <label>Receipt No
                    </label>
                 <input type="text" name="receiptNo" value="${testingCharge.receiptNo}"  />
                    <label>Receipt Date
                    </label>
                  <input type="text" name="receiptDate" value="${testingCharge.receiptDate}"  id="datepickerfrom"  onchange="populateServiceTax()"/> 
                   
                  </p>
                       <p>
                    <label>Vendor Name <c:out value="${testingCharge.vendorId}"></c:out> 
                    </label>
               <select name="vendorId" id="vendorId" onchange="populateItemGroupName()" >
               <option value=0>--Please Select--</option>
			<c:forEach items="${vendors}" var="vendor">
			
			
			<option value="${vendor.vendorId}" ${vendor.vendorId == testingCharge.vendorId ? 'selected="selected"' : ' '}><c:out value="${vendor.vendorName}"></c:out></option>
			
			</c:forEach>
			</select>
                   <label>Item Group Name 
                    </label>
         			  <select name="itemCode"  id="itemGroupNameId">
       
				</select>
                   
       				<input type="hidden" name="itemName" id="itemGroupCodeId" >
				</p>
				<p>
				<label>Service Tax Applicable
                    </label>
				<input type="text" name="serviceTax" value="${testingCharge.serviceTax}"  id="serviceTaxID" READONLY >
				     <label>Testing Charge
                    </label>
            		 <input type="text" name="testCharge" value="${testingCharge.testCharge}"  id="testChargeID" />
            		
            		 </p>
            		   <p>
            		 <label>Service Tax Amount
                    </label>
            		 <input type="text" name="serviceTaxAmount" onfocus="populateServiceTaxAmount()"   id="serviceTaxAmountID" READONLY/>
            		 </p>
                 	  <p>
                   <label>Net Testing Charge
                    </label>
                    <input type="text" name="netTestCharge"  onfocus="populateServiceTaxAmount()" id="netTestChargeID" READONLY>
                  
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
            		 <input type="text" name="chqNo" value="${testingCharge.chqNo}" />
                   <label>Cheque Date
                    </label>
                   <input type="text" name="chqDate" value="${testingCharge.chqDate}"  id="datepickerto"  />
                  </p>
                  <p>
                    <label>Remarks
                    </label>
            		 <textarea rows="3" cols="22" name="remark" value="${testingCharge.remark}" ></textarea>
                   
                  </p>
                  
                  
               </fieldset>

 <div>
         <button type="submit"  id="submit" class="btn btn-blue btn-effect">Save</button>
		<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
	<a href="viewTesting.html" id="submit" class="btn btn-blue btn-effect">View</a>
	<a href="editTestingBack.html"  id="submit" class="btn btn-blue btn-effect"> Back</a>
</div>
</form>
<!-- 
<c:if test="${!empty testingCharges}">

	<table align="center" border="1">
		<tr>
			<th>S.No.</th>
			<th>Receipt No</th>
			<th>Vendor Code</th>
			<th>Vendor Name</th>
			<th>Item Group Code</th>
			<th>Item Group Name</th>			
			<th>Testing Charge</th>
			<th>DD No.</th>
			<th>DD Date</th>
			<th>Bank Name</th>
			<th>Bank Id.</th>
			<th>Remarks</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${testingCharges}" var="test">
			<tr>
				<td><c:out value="${test.sno}"/></td>
				<td><c:out value="${test.receiptNo}"/></td>
				<td><c:out value="${test.vendorId}"/></td>
				<td><c:out value="${test.vendorName}"/></td>
				<td><c:out value="${test.itemCode}"/></td>
				<td><c:out value="${test.itemName}"/></td>
				<td><c:out value="${test.testCharge}"/></td>
				<td><c:out value="${test.chqNo}"/></td>
				<td><c:out value="${test.chqDate}"/></td>
				<td><c:out value="${test.bankName}"/></td>
				<td><c:out value="${test.bankCode}"/></td>
				<td><c:out value="${test.remark}"/></td>
				
				<td align="center"><a href="editTestingCharge.html?sno=${test.sno}" style="color: white;">Edit</a> | <a href="deleteTestingCharge.html?sno=${test.sno}" style="color: white;">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	 -->						</div>
					
	
						</div>
					</div>
				</div>
			</section> 
		
      
			
		</main>
		
		<%@ include file="footer.jsp"%>
		
		
    </body>
</html>





