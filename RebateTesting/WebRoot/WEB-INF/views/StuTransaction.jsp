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
<!-- meta character set -->
<meta charset="utf-8">
<!-- Always force latest IE rendering engine or request Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>ASRTU-Admin Page</title>
<!-- Meta Description -->
<meta name="description" content="Blue One Page Creative HTML5 Template">
<meta name="keywords"
	content="one page, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
<meta name="author" content="">

<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- CSS
		================================================== -->

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700'
	rel='stylesheet' type='text/css'>

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


<SCRIPT type="text/javascript">

var vendorToItemGroupCode="";
var rebateAmountCode="";
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		//alert(rowCount);
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("SELECT");
		// element1.type = "select";
		// var x = document.createElement("SELECT");

		option = document.createElement('option');
		option.setAttribute('value', 'Hello');
		//option.appendChild(document.createTextNode('Hello'));
		element1.appendChild(option);

		element1.setAttribute("id", "mySelect");
		cell1.appendChild(element1);

		//var z = document.createElement("option");
		// z.setAttribute("value", "volvocar");
		// var t = document.createTextNode("Volvo");
		//z.appendChild(t);
		// cell1.getElementById("mySelect").appendChild(z);

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		cell2.appendChild(element2);

		var cell3 = row.insertCell(2);
		var element3 = document.createElement("SELECT");
		cell3.appendChild(element3);

		var cell4 = row.insertCell(3);
		var element4 = document.createElement("input");
		element4.type = "text";
		cell4.appendChild(element4);
		
		element4.className = "datepicker";
		cell4.appendChild(element4);
		$( ".datepicker" ).datepicker({dateFormat: 'dd/mm/yy'});
		

		var cell5 = row.insertCell(4);
		var element5 = document.createElement("input");
		element5.type = "text";
		
		cell5.appendChild(element5);

		var cell6 = row.insertCell(5);
		var element6 = document.createElement("input");
		element6.type = "text";
		
		cell6.appendChild(element6);

		

		var length = table.rows.length;
		element1.name = "operationParameterses[" + length + "].firmName"
		element2.name = "operationParameterses[" + length + "].firmCode";
		element3.name = "operationParameterses[" + length + "].itemName";
		element4.name = "operationParameterses[" + length + "].itemCode";
		element5.name = "operationParameterses[" + length + "].invoiceNo";
		element6.name = "operationParameterses[" + length + "].invoiceDate";
		

	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}
	
	function populateStuDetails() {
		
		//alert(1);
		
		var stuID = document.getElementById('stuID').value;
		
		//alert(stuID);
		 
	    AjaxHelper.getSTUBystuID(stuID, populateStuDetailsCallback); 
	}  

	function populateStuDetailsCallback( data ) {
		
// order  code, name,NODEL_CODE,NODEL_NAME
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
		  // alert("SPLIT"+res[0] );
		 //  alert("SPLIT"+res[2] );
		  // alert("SPLIT"+res[3] );
		    
		    document.getElementById("stuCode").value= res[0];
		    document.getElementById("nodalCodeID").value = res[2];
		    document.getElementById("nodalNameID").value = res[3];
		  }
		//document.getElementById("testChargeId").innerHTML = data;


	}
	
	
	function populateItemGroupName(idCount) {
		
		//alert(idCount);
		vendorToItemGroupCode=idCount;
		
		var vendorSource = "vendorID_"+idCount;
		
		//alert(" vendorSource :"+vendorSource);
		
		var vendorId = document.getElementById(vendorSource).value;
		
	//alert(vendorId);
	
	
	var callMetaData = { 
	  callback:populateItemGroupNameCallback, 
	  arg: idCount // specify an argument to pass to the callback and exceptionHandler
	};
	
		 
	    AjaxHelper.getItemGroupByVendorID(vendorId, callMetaData); 
	}  

	function populateItemGroupNameCallback( data , args1 ) {
		
		//window.alert("args1  "+args1);  
		//window.alert("Data  "+data); 
		
		//window.alert("vendorToItemGroupCode  "+vendorToItemGroupCode); 
		
		
		document.getElementById("itemName_"+vendorToItemGroupCode).innerHTML = data;
		
		vendorToItemGroupCode="";


	}
	
	
	
	function populateRebateAmount(idCount) {
		
		//alert(idCount);
		rebateAmountCode=idCount;
		
		var vendorSource = "vendorID_"+idCount;
		var itemSource = "itemName_"+idCount;
		
		//alert(" vendorSource :"+vendorSource);
		//alert(" itemSource :"+itemSource);
		
		var vendorId = document.getElementById(vendorSource).value;
		var itemId = document.getElementById(itemSource).value;
		
		//alert(" vendorId :"+vendorId);
		//alert(" itemId :"+itemId);
		
		var callMetaData = { 
				  callback:populateRebateAmountCallback, 
				  arg: idCount // specify an argument to pass to the callback and exceptionHandler
				};
		 
	    AjaxHelper.getRebatePercentByVenodorID(vendorId, itemId, callMetaData); 
	}  

	function populateRebateAmountCallback( data, args1 ) {
		
		//window.alert("args1  "+args1);  
		//window.alert("Data  "+data); 
		
		//window.alert("rebateAmountCode  "+rebateAmountCode); 
		
		var stuTotalAmount = document.getElementById("stuTotalAmount_"+rebateAmountCode).value;
		//alert("stuTotalAmount "+stuTotalAmount);
		
		var rebateAmount = stuTotalAmount*data/100;
		
		rebateAmount = Math.round(rebateAmount);
		
		//alert("rebateAmount "+rebateAmount);
		document.getElementById("stuTotalRebate_"+rebateAmountCode).value = rebateAmount;
		
		document.getElementById("stuTotalRebate_"+rebateAmountCode).focus();
		
		rebateAmountCode="";


	}
</SCRIPT>
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

						<h3 align="center" style="color: red;">
							<c:out value="${message1}" />
						</h3>
						<%-- <form action="/rebatetest/saveStuTrans.html" method="post" class="registerLarge"> --%>
						
						<form:form method="post" action="/rebatetest/saveStuTrans.html" modelAttribute="stuTransactionBean" class="registerLarge">
						
						
							<fieldset class="row1">
								<legend>STU Transaction Entry Form </legend>
								<p>
								
								
								          <label>Info Receipt Date
                    </label>
                   <input type="text"  name="infoReceiptDate" class="datepicker"  />
								
								
								
									<label>Quarter</label> <select name="quarter">
										<c:forEach items="${quarter }" var="quar">
											<option value="${quar.quarter }"><c:out
													value="${quar.quarter }"></c:out></option>
										</c:forEach>
									</select>
									</p>
									<p>
									
									
									 <label>Month</label> <select name="month">
										<option value="Jan">Jan</option>
										<option value="Feb">Feb</option>
										<option value="Mar">Mar</option>
										<option value="Apr">Apr</option>
										<option value="May">May</option>
										<option value="Jun">Jun</option>
										<option value="Jul">Jul</option>
										<option value="Aug">Aug</option>
										<option value="Sep">Sep</option>
										<option value="Oct">Oct</option>
										<option value="Nov">Nov</option>
										<option value="Dec">Dec</option>
									</select> 
							<label>Year</label> <select name="year">
										<option value="2003">2003</option>
										<option value="2004">2004</option>
									</select> 			
									
                   
                   
         
                    
                  </p>
                  
                  <script src="resources/js/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="resources/js/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
									<p>
									<label>STU Name</label>
									<select name="stuName" id="stuID" onchange="populateStuDetails()" data-placeholder="--Please select----"  class="chosen-select" style="width: 200px;">
									
									<option value="0">--Please select--</option>
													
										<c:forEach items="${stuMaster }" var="stu">
											<option value="${stu.code }"><c:out
													value="${stu.name }  - ${stu.modelName }  - ${stu.modelCode }" /></option>
																										
										</c:forEach>

									</select>
									<p/>
									<p>
								 <label>Transaction Date
                    </label>
                   <input type="text"  name="transactionDate" class="datepicker"  />
								
								
									</p>
									<p>
									<label>STU Code</label> <input type="text" name="stuCode" id="stuCode">
									<label>Nodal off Code</label> <input type="text" 	name="nodalCode" id="nodalCodeID"> 
										</p>
									<p>
										<label>Nodal Name</label> <input
										type="text" name="nodalName" id="nodalNameID">
								</p>
								<p>&nbsp;</p>
								<TABLE width="100%" border="1" id="dataTable">

									<tr >
										<th width="10%" style="color: white;"><tlabel style="color: white;" >Firm Name</tlabel></th>
										
										<th width="10%" style="color: white;"><tlabel style="color: white;">Item Name</tlabel></th>
										
										<th width="10%" style="color: white;"><tlabel style="color: white;">Invoice No</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">Invoice Date</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">STU Total Amount</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">STU Rebate Amount</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">Purchase Order Date</tlabel></th>
										<th width="10%" style="color: white;"><tlabel style="color: white;">Purchase Order No</tlabel></th>
									</tr>
									<tr>
								<c:forEach items="${stuTransactionBean.stuColl}" var="stuTB" varStatus="status">
		<td width="10%">
			<select name="stuColl[${status.index}].vendorCode" id="vendorID_${status.index}" data-placeholder="--Please select----"  class="chosen-select"
			 onchange="populateItemGroupName(${status.index})" >
               <option value=0>--Please Select--</option>
               
               	<c:forEach items="${vendor }" var="ven">
													<option value="${ven.vendorId }"><c:out
															value="${ven.vendorName }" /></option>
					</c:forEach>
			</select></td>
										
										<td width="10%">	 
										 <select name="stuColl[${status.index}].itemCode"  id="itemName_${status.index}">
       
				</select>
                   
       									<td width="10%">
       									<input type="text" name="stuColl[${status.index}].invoiceNumber" >
										</td>
										<td id="" width="10%">
										<input type="text" name="stuColl[${status.index}].invoiceDate"
											class="datepicker"></td>
										<td width="10%">
										<input type="text" name="stuColl[${status.index}].stuTotalAmount" id="stuTotalAmount_${status.index}" onchange="populateRebateAmount(${status.index})">
										</td>
										<td width="10%">
										<input type="text" name="stuColl[${status.index}].stuTotalRebate" id="stuTotalRebate_${status.index}">  

										</td>
										<td id="" width="10%">
										<input type="text" name="stuColl[${status.index}].purchaseOrderDate" 
											class="datepicker"></td>
											
										<td width="10%">
       									<input type="text" name="stuColl[${status.index}].purchaseOrderNumber" >
										</td>
											
									</tr>
	</c:forEach>
 	</TABLE>
								
							</fieldset>
							<button type="submit" id="submit" class="btn btn-blue btn-effect">Save</button>
							<button type="reset" id="submit" class="btn btn-blue btn-effect">Reset</button>
							<a href="listStuTr.html" id="submit"
								class="btn btn-blue btn-effect">View</a> <a
								href="adminBack.html" id="submit"
								class="btn btn-blue btn-effect">Back</a>
					</div>
</form:form>
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

	<%@ include file="footer.jsp"%>

</body>
</html>
