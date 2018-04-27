 <!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
    
  <link rel="stylesheet" href="resources/js/chosen/docsupport/style.css">
  <link rel="stylesheet" href="resources/js/chosen/docsupport/prism.css">
  <link rel="stylesheet" href="resources/js/chosen/chosen.css">
    
    
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
    .datepicker{
     
    }
  </style>
 
  <script>
  $(function() {
    $( ".datepicker" ).datepicker({dateFormat: 'dd/mm/yy'});
  });

  </script>


<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/engine.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/util.js"></script>
<script type="text/javascript" src="<c:out value='${contextPath }'/>dwr/interface/AjaxHelper.js"></script>
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
    
	//window.alert("Data  "+data);
	 document.getElementById('itemNameId').value = data;
	       
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

function submitForm(){
	//alert(1);
  //this.selectInsuranceForm.submit

  var pageAction = document.getElementById("pageActionID");
  pageAction.value="refreshPage";
  // alert(pageAction.value);
  document.forms.rebateForm.submit();
}

</script>
<script type="text/javascript">
  
  function validateForm() {
	  
//	alert(1);
    var x = document.getElementById("vendorId").value;
    if (x == "") {
        alert("Please enter Vendor Name.");
        document.getElementById("vendorId").focus();
        return false;
    }
    
    var y = document.getElementById("itemGroupNameId").value;
    if (y == "") {
        alert("Please enter Item Name.");
        document.getElementById("itemGroupNameId").focus();
        return false;
    }
    
    var x = document.getElementById("transactionDateID").value;
    if (x == "") {
        alert("Please enter Transaction Date.");
        document.getElementById("transactionDateID").focus();
        return false;
    }
    
    var y = document.getElementById("receiptDateID").value;
    if (y == "") {
        alert("Please enter Receipt Date.");
        document.getElementById("receiptDateID").focus();
        return false;
    }	
    var x = document.getElementById("bankNameId").value;
    if (x == "") {
        alert("Please enter Issuing Bank.");
        document.getElementById("bankNameId").focus();
        return false;
    }
    
    var y = document.getElementById("chequeNoId").value;
    if (y == "") {
        alert("Please enter DD/Cheque No.");
        document.getElementById("chequeNoId").focus();
        return false;
    }
    var x = document.getElementById("chequeDateId").value;
    if (x == "") {
        alert("Please enter DD/Cheque Date.");
        document.getElementById("chequeDateId").focus();
        return false;
    }
    
    var y = document.getElementById("ddchequeAmountId").value;
    if (y == "") {
        alert("Please enter DD/Cheque Amount.");
        document.getElementById("ddchequeAmountId").focus();
        return false;
    }
    var x = document.getElementById("interestOnRebateId").value;
    if (x == "") {
        alert("Please enter Interest on Rebate.");
        document.getElementById("interestOnRebateId").focus();
        return false;
    }
    
    var y = document.getElementById("interestOnServiceTaxId").value;
    if (y == "") {
        alert("Please enter Interest on Service Tax.");
        document.getElementById("interestOnServiceTaxId").focus();
        return false;
    }
    var x = document.getElementById("tdsAmountId").value;
    if (x == "") {
        alert("Please enter TDS Deducted.");
        document.getElementById("tdsAmountId").focus();
        return false;
    }
    
    var y = document.getElementById("incAmountId").value;
    if (y == "") {
        alert("Please enter Incentive Adjusted.");
        document.getElementById("incAmountId").focus();
        return false;
    }
    var x = document.getElementById("emdAmountId").value;
    if (x == "") {
        alert("Please enter EMD Adjusted.");
        document.getElementById("emdAmountId").focus();
        return false;
    }
    
    var y = document.getElementById("bankchargeId").value;
    if (y == "") {
        alert("Please enter Others/Bank Charge.");
        document.getElementById("bankchargeId").focus();
        return false;
    }
    var x = document.getElementById("remarksId").value;
    if (x == "") {
        alert("Please enter Remarks.");
        document.getElementById("remarksId").focus();
        return false;
    }
    
    var y = document.getElementById("commentsId").value;
    if (y == "") {
        alert("Please enter Comments.");
        document.getElementById("commentsId").focus();
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
										</div>
				
<form action="/rebatetest/saveRebate.html" name="rebateForm" method="post" onsubmit="return validateform()" class="registerLarge"  autocomplete="off">
<fieldset class="row1">
                <legend>Receipt Entry
                </legend>

  <script src="resources/js/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="resources/js/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>

           
           <p>
                    <label>Vendor Name
                    </label>
               <select name="vendorCode" id="vendorId" onchange="populateItemGroupName()" data-placeholder="--Please select----"  class="chosen-select">
               <option value="">--Please Select--</option>
			<c:forEach items="${vendors}" var="vendor">
			<option value="${vendor.vendorId}" ${vendor.vendorId == rebateBean.vendorCode ? 'selected' : ' '}><c:out value="${vendor.vendorName}"></c:out></option>
			</c:forEach>
			</select>
                   
    </p><p>             
                   <label>Item Name 
                    </label>
         			    <select name="itemCode" id="itemGroupNameId" onchange="submitForm();" >
               <option value=0>--Please Select--</option>
			<c:forEach items="${items}" var="item">
			<option value="${item.itemCode}" ${item.itemCode == rebateBean.itemCode ? 'selected' : ' '}><c:out value="${item.itemName}"></c:out></option>
			</c:forEach>
			</select>
             
       
				</select>
             	</p>
		   
                <p>
                                             <label>Transaction Date
                    </label>
                 <input type="text" id="transactionDateID" name="transactionDate" class="datepicker" />
                    <label>Receipt Date
                    </label>
                 <input type="text" id="receiptDateID" name="receiptDate"  class="datepicker"/>
                   
                  </p>
                             
           		    <p>
                    
                    				     <label>Issuing Bank
                    </label>
            		<select name="astruBankID" id="bankNameId"  onchange="populateBankCode()" typehead="true">
				<option>--Please Select--</option>
				<c:forEach items="${bankNames}" var="bank">
			<option value="${bank.bankCode}"><c:out value="${bank.bankName}"/></option>
			</c:forEach>
			</select>
                    <label>DD/Cheque No
                    </label>
                 <input type="text" name="chequeNo" id="chequeNoId"/>
                    
                   
                  </p>
                  <P>

                   <label>DD/Cheque Date
                    </label>
                <input type="text" name="chequeDate" class="datepicker" id="chequeDateId"/>
                    <label>DD/Cheque Amount
                    </label>
                 <input type="text" name="ddChequeAmount" id="ddchequeAmountId" />
                   
                  </p>
                  
                                  <legend>Details of Payment
                </legend>
                     <p>               
                     <label>Interest on Rebate </label>
                    <input type="text" name="interestOnRebate" id="interestOnRebateId" />
                    <label>Interest on Service Tax</label>
                    <input type="text" name="interestOnServiceTax" id="interestOnServiceTaxId"/>
                    </p>
                    <p>               
                     <label>TDS Deducted</label>
                    <input type="text" name="tdsAmount" id="tdsAmountId"/>
                    <label>Incentive Adjusted</label>
                    <input type="text" name="incAmount" id="incAmountId"/>
                    </p>
                     <p>               
                     <label>EMD Adjusted</label>
                    <input type="text" name="emdAmount" id="emdAmountId"/>

                    </p>
                    
                                    <c:forEach items="${rebateBean.invoiceList}" var="invoice" varStatus="status">
                 <p class="fullLabel">
                <label style="width: 250px;">Invoice - ${invoice.asrtuInvoiceNumber} - ${invoice.quarter} - ${invoice.rebateRemainingOutstanding}
                    </label>
 					<input type="hidden"  name="invoiceList[${status.index}].invoiceNumber" value="${invoice.invoiceNumber}">
 					<input type="hidden"  name="invoiceList[${status.index}].rebateType" value="${invoice.rebateType}">
 					<input type="hidden"  name="invoiceList[${status.index}].totalTaxPercentage" value="${invoice.totalTaxPercentage}">
                    <input type="hidden"  name="invoiceList[${status.index}].rebateOutstanding" value="${invoice.rebateOutstanding}">
                     <input type="hidden"  name="invoiceList[${status.index}].rebateRemainingOutstanding" value="${invoice.rebateRemainingOutstanding}">
                     
                     <input type="hidden"  name="invoiceList[${status.index}].rebatePrRemainingOutstanding" value="${invoice.rebatePrRemainingOutstanding}">
                     <input type="hidden"  name="invoiceList[${status.index}].rebateTaxRemainingOutstanding" value="${invoice.rebateTaxRemainingOutstanding}">
                     
                    <input type="text" name="invoiceList[${status.index}].invoicePayment">
                    
                    
                    
					
                    </p>
                    </c:forEach>
                    
                    
                                    
                     <p>               
                     <label>Others/Bank Charge</label>
                    <input type="text" name="bankcharge" id="bankchargeId" />
                    <label>Remarks</label>
                    <input type="text" name="remarks" id="remarksId" />
                    </p>
                    
                    <p>               
                     <label>Comments</label>
                    <input type="text" name="comments" id="commentsId" />
                    <input type="hidden" name="pageAction" value="" id="pageActionID">
<br/><br/>
                    </p>

							<p>
								<h3 align="center" style="color: red;">
									<c:out value="${successMessage}" />
								</h3>
								</p>
  		<div>
         <button type="submit"  id="submitID" class="btn btn-blue btn-effect">Save</button>
			<button type="reset" id="submitID" class="btn btn-blue btn-effect">Reset</button>
		<a href="viewRebate.html" id="submitID" class="btn btn-blue btn-effect">View</a>
			<a href="adminBack.html"  id="submit" class="btn btn-blue btn-effect">Back</a>
	
		   </div>
   
</form>	

							</div>
	
						</div>
					</div>
				</div>
			</section> 
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
		
		        <%@ include file="footer.jsp" %>
		
   
    </body>
</html>
