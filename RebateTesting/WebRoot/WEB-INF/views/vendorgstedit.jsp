
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
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
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Calendar"%>

<%
    	pageContext.setAttribute("contextPath", request.getContextPath()+"/");
    %>

  
<!-- meta character set -->
<meta charset="utf-8">
<!-- Always force latest IE rendering engine or request Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>ASRTU-Rebate</title>
<!-- Meta Description -->
<meta name="description" content="Blue One Page Creative HTML5 Template">
<meta name="keywords"
	content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
<meta name="author" content="Muhammad Morshed">

<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS
		================================================== -->

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700'
	rel='stylesheet' type='text/css'>

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

<style>
.datepicker {
	
}
</style>

<script>
  $(function() {
    $( ".datepicker" ).datepicker({dateFormat: 'dd/mm/yy'});
  });

  </script>


<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript"
	src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
<script type="text/javascript">


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

function populateBankCode() {
	
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {
	
	//dwr.util.setValue('bankCodeId',data);
	document.getElementById('bankCodeId').value= data;
       
}
function populateBankCode() {
	
	
	var bankNameId = document.getElementById('bankNameId').value;
	 
    AjaxHelper.getBankNameId(bankNameId, populateBankCodeCallback); 
} 
function populateBankCodeCallback( data ) {
	

	//window.alert("Data  "+data);    

	dwr.util.setValue('bankCodeId',data);
       
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
    var x = document.getElementById("datepickerto").value;
    if (x == "") {
        alert("Please enter Invoice Date.");
        document.getElementById("datepickerto").focus();
        return false;
    }
    
    var y = document.getElementById("vendorId").value;
    if (y == "") {
        alert("Please enter Vendor Name.");
        document.getElementById("vendorId").focus();
        return false;
    }
    
    var x = document.getElementById("itemGroupNameId").value;
    if (x == "") {
        alert("Please enter Item Name.");
        document.getElementById("itemGroupNameId").focus();
        return false;
    }
    
    var y = document.getElementById("quarterFromDateId").value;
    if (y == "") {
        alert("Please enter Quarter From Date.");
        document.getElementById("quarterFromDateId").focus();
        return false;
    }	
    var x = document.getElementById("quarterToDate").value;
    if (x == "") {
        alert("Please enter Quarter To Date.");
        document.getElementById("quarterToDate").focus();
        return false;
    }
    
    var y = document.getElementById("regularRebateId").value;
    if (y == "") {
        alert("Please enter Rebate Type.");
        document.getElementById("regularRebateId").focus();
        return false;
    }
    var x = document.getElementById("rebateOutstandingId").value;
    if (x == "") {
        alert("Please enter Amount.");
        document.getElementById("rebateOutstandingId").focus();
        return false;
    }
  }
  </script>



</head>

<body id="body">

	<!--
        Fixed Navigation
        ==================================== -->
	<%@ include file="header.jsp"%>
	<!--
        End Fixed Navigation
        ==================================== -->

	<main class="site-content" role="main">

	<section id="social" class="parallax">
		<div class="overlay">
			<div class="container">
				<div class="row">


					<div class="sec-title text-center white wow animated fadeInDown">
					</div>
					<%-- <form action="/rebatetest/savevendorgst.html" name="myForm" method="post"
						onsubmit="return validateform()" class="registerLarge"  autocomplete="off">
					 --%>
					 	
						<form:form method="POST" class="registerLarge" modelAttribute="VendorGst" role="form" action="/rebatetest/savevendorgst.html">
						
						
						<fieldset class="row1">
						
													<script src="resources/js/chosen/chosen.jquery.js"
								type="text/javascript"></script>
							<script src="resources/js/chosen/docsupport/prism.js"
								type="text/javascript" charset="utf-8"></script>
							
								<label>Vendor Name</label> 
							<select name="vendorId" data-placeholder="--Please select----"  class="chosen-select" 
									 id="vendorId">
									 <option value=0>--Please Select--</option>
									<c:forEach items="${vendor}" var="vendor">
										<option value="${vendor.vendorId}" <c:if test='${vendorId == vendor.vendorId}'> selected </c:if>> 
										<c:out  value="${vendor.vendorName}" ></c:out>
										
										</option>
									</c:forEach>
								</select> 
								

<c:if test="${not empty vendorGstToEdit}">


	<legend>Edit Vendor GST Number</legend>
<table class="table table-condensed   table-bordered table-hover no-margin" align="center">

<tr><td><label>GSTN No</label> <input type="text" name="gstNumber" id="gstNumberId" value="${vendorGstToEdit.gstNumber}" /> </td>
<td><label>TYPE</label> 

<select name="vendorType" data-placeholder="--Please select----"  class="chosen-select" 
									 id="vendorTypeId">
									 <option value="H" <c:if test='${"H" == vendorGstToEdit.vendorType}'> selected </c:if>>Head Office</option>
									 <option value="B" <c:if test='${"B" == vendorGstToEdit.vendorType}'> selected </c:if>>Branch Office</option>
									 <option value="A" <c:if test='${"A" == vendorGstToEdit.vendorType}'> selected </c:if>>Agent</option>
							
								</select> 

  </td>
  <td><label>Contact Person</label>  <input type="text" name="contactPerson" id="contactPersonId" value="${vendorGstToEdit.contactPerson}" /> </td>
  
<td><label>Contact No</label>  <input type="text" name="firstContact"  id="firstContactId" value="${vendorGstToEdit.firstContact}" /></td>


<td><label>Other Contacts</label>  <input type="text" name="otherContacts" id="otherContactsId" value="${vendorGstToEdit.otherContacts}" /> </td>

</tr>

<tr>
<td><label>Address1</label>  <input type="text" name="address1"  id="address1Id" value="${vendorGstToEdit.address1}" /> </td>
<td><label>Address2</label>  <input type="text" name="address2"  id="address2Id" value="${vendorGstToEdit.address2}" /> </td>
<td><label>Address3</label>  <input type="text" name="address3"  id="address3Id" value="${vendorGstToEdit.address3}" /> </td>
<td><label>Pin Code</label>  <input type="text" name="pinCode"  id="pinCodeId" value="${vendorGstToEdit.pinCode}" /> 
 
</td>


<td><label>Email</label>  <input type="text" name="email"  id="emailId" value="${vendorGstToEdit.email}" /> </td>

<input type="hidden" name="id"  id="emailId" value="${vendorGstToEdit.id}" />

</tr>
								
								</table>	
								
</c:if>	

								<button type="submit" id="submit"
									class="btn btn-blue btn-effect">Save</button>
								<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
								<a href="viewInvoiceList.html" id="submit"
									class="btn btn-blue btn-effect">View</a> <a
									href="viewVendorGstBack.html" id="submit"
									class="btn btn-blue btn-effect">Back</a>

							</div>
					</form:form>
					
					


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





	</main>

	<%@ include file="footer.jsp"%>


</body>
</html>
