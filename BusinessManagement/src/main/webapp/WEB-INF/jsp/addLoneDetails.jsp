<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Lone Details</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.ico" type="image/ico" />
<script src="/js/jquery-3.3.1.min.js"></script>
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link href="/css/nprogress.css" rel="stylesheet">
<link href="/css/green.css" rel="stylesheet">
<link href="/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
<link href="/css/daterangepicker.css" rel="stylesheet">
<link href="/build/css/custom.min.css" rel="stylesheet">
<script>
    $(document).ready(function() {
    	
    	$( "#tenure" ).change(function() {
    		 $("#tenureYear").html("");
    		var year=calculateYear();
    		 $("#tenureYear").html(year.toFixed(2)+" years");
    		 calculateTotalInterest();
    		});
    	
    	
	$("#loanAmount").change(function() {
		calculateTotalInterest();
	});
	
	$("#rateOfInterest").change(function() {
		calculateTotalInterest();
	});
	
	$("#installmentFrquency").change(function() {
		calculateTotalLoanAmount();
	});

						function calculateTotalInterest() {
							
							 $('#totalInterestPaid').val("");
							var principal = parseFloat($("#loanAmount").val());
							var year = calculateYear();
							var rateOfInterest = parseFloat($("#rateOfInterest").val());
							if (principal != "" && year!="" && rateOfInterest!="") {
							var interest = (principal * year * rateOfInterest) / 100;
							 $('#totalInterestPaid').val(interest);
							 calculateTotalLoanAmount();
							
							}
						}

						function calculateTotalLoanAmount() {
							
							$("totalLoanAmount").html("");
							$("emiAmountPerMonth").val("");
							var totalInterestPaid=parseFloat($('#totalInterestPaid').val());
							var principal = parseFloat($("#loanAmount").val());
							var totalLoanAmount=parseFloat(totalInterestPaid+principal);
							var installmentFrquency=$("#installmentFrquency").val();
							var tenure = parseFloat($("#tenure").val());
							var emiAmount="";
							
							if(installmentFrquency!="-1"){
							if(installmentFrquency=="MONTHLY")
								emiAmount=parseFloat(totalLoanAmount/tenure);
							if(installmentFrquency=="QUARTERLY")
								emiAmount=parseFloat((totalLoanAmount/tenure)*3);	
							if(installmentFrquency=="YEARLY")
								emiAmount=parseFloat((totalLoanAmount/tenure)*12);	
							$("#totalLoanAmount").html(totalLoanAmount);
							$("#emiAmountPerMonth").val(emiAmount);
							}
						}
						
						function calculateYear() {

							if ($("#tenure").val() != "") {
								var year = $("#tenure").val() / 12;
								return parseFloat(year);
							}
						}

						$("#loneDetailsFormId")
								.on(
										"submit",
										function(e) {
											e.preventDefault();
											var formData = $(
													'#loneDetailsFormId')
													.serializeArray();
											var s = '';
											var data = {};
											for (s in formData) {
												var fieldName = formData[s]['name'];
												if (fieldName.indexOf(".") != -1) {
													var innerObjectJson = {};
													innerObjectJson[fieldName
															.split(".")[1]] = formData[s]['value'];
													data[fieldName.split(".")[0]] = innerObjectJson;
												} else {
													data[formData[s]['name']] = formData[s]['value']
												}
											}
											$
													.ajax({
														type : 'POST',
														url : '/lone/loneDetails/insertLoneDetails',
														data : JSON
																.stringify(data),
														contentType : "application/json",

														success : function(
																result) {
															var resultSting = JSON
																	.stringify(result);
															var jsonResult = JSON
																	.parse(resultSting);
															if (jsonResult.status) {
																alert(jsonResult.message);
																window.location.href = "/lone/loneDetails/showLoneDetails";
															}
														},
														error : function(result) {
															var resultSting = JSON
																	.stringify(result);
															var jsonResult = JSON
																	.parse(resultSting);
															alert(jsonResult.message);

														}
													});

										});

					});
</script>
    
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- Header File -->
			<jsp:include page="header.jsp" />
			<div class="right_col" role="main">
				<br />
				<div class="row">
					<div class="col-md-12 ">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									Add Lone <small>Details</small>
								</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form id="loneDetailsFormId"
									class="form-horizontal form-label-left">
								<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Lone Title<span class="required">*</span></label>
										<div class="col-md-6 col-sm-9 ">
											<input type="text" name="loneTitle"
												class="form-control" placeholder="lone Title">
										</div>
									</div>

									<div class="form-group row">
										<label class="control-label col-md-3 col-sm-3 ">Select
											Ledger </label>
										<div class="col-md-6 col-sm-9 ">
											<select name="loanFromLeadger.ledgerId" id="ledgerId"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<c:forEach items="${ledgers}" var="ledger">
													<option value="${ledger.ledgerId}">${ledger.ledgerName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group row">
										<label class="control-label col-md-3 col-sm-3 ">Select
											Bank Account </label>
										<div class="col-md-6 col-sm-9 ">
											<select name="loanReceiveIntoBank.bankId" id="bankId"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<c:forEach items="${bankDetails}"  var="bankDetail">
													<option value="${bankDetail.bankId}">${bankDetail.bankAccountTitle}</option>
												</c:forEach>
											</select>
										</div>
									</div>
							
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Loan Amount</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="number" name="loanAmount" id="loanAmount"
												class="form-control" placeholder="Enter Loan Amount">
										</div>
									</div>
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Tenure in month</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="number" name="tenure" id="tenure"
												class="form-control" placeholder="Enter Tenure in month">
										</div><div id="tenureYear"></div>
									</div>
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Installment Frequency</label>
										<div class="col-md-6 col-sm-9 ">
											<select name="installmentFrequency" id="installmentFrquency"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<option value="MONTHLY">Monthly</option>
												<option value="QUARTERLY">Quarterly</option>
												<option value="YEARLY">Yearly</option>
												
											</select>
										</div>
									</div>
										<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Rate Of Interest</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="number" name="rateOfInterest" id="rateOfInterest"
												class="form-control" placeholder="Rate Of Interest">
										</div>
									</div>
										<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Total Interest Paid</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="text" name="totalInterestPaid" id="totalInterestPaid"
												class="form-control" placeholder="Total Interest Paid">
										</div>
									</div>
									<div class="form-group row " >
										<label class="control-label col-md-3 col-sm-3 ">Total Loan Amount</label>
										<div class="col-md-6 col-sm-9 ">
											<label id="totalLoanAmount" class="control-label col-md-3 col-sm-3 "></label>
										</div>
									</div>
										<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">EMI Amount</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="number" name="emiAmountPerMonth" id="emiAmountPerMonth"
												class="form-control" placeholder="EMI Amount">
										</div>
									</div>
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Payment Mode</label>
										<div class="col-md-6 col-sm-9 ">
											<select name="paymentMode" id="paymentMode"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<option value="CASH">Cash</option>
												<option value="CHEQUE">Cheque</option>
												<option value="ONLINE">Online</option>
												<option value="OTHER">Other</option>
											</select>
										</div>
									</div>
										<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">EMI Start Date</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="date" name="emiStartDate" id="emiStartDate"
												class="form-control">
										</div>
									</div>
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Due on</label>
											<div class="col-md-6 col-sm-9 ">
											<select name="dueOn" id="dueOn"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<c:forEach var="i" begin="1" end="28">
													<option value="${i}">${i}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Description</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="text" name="description" id="description"
												class="form-control">
										</div>
									</div>

									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Remark</label>
										<div class="col-md-6 col-sm-9 ">
											<textarea name="remark"></textarea>
										</div>
									</div>
									<div class="form-group row">
										<label class="control-label col-md-3 col-sm-3 ">Select
											Active</label>
										<div class="col-md-6 col-sm-9 ">

											<select name="active" id="active"
												class="select2_single form-control" tabindex="-1">
													<option value="Y">Active</option>
													<option value="N">Inactive</option>
									
											</select>
										</div>
									</div>
									<div class="ln_solid"></div>
									<div class="form-group">
										<div class="col-md-6 col-sm-9  offset-md-3">
										<button type="reset" class="btn btn-primary">Reset</button>
											<button type="submit" class="btn btn-success">Submit</button>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>


				</div>

				<!-- footer content -->
				<footer>
					<div class="pull-right"></div>
					<div class="clearfix"></div>
				</footer>
				<!-- /footer content -->
			</div>
		</div>
	</div>

	<!-- Bootstrap -->
	<script src="/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
	<script src="/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
	<script src="/build/js/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="/build/js/gauge.min.js"></script>
	<!-- ECharts -->
	<script src="/build/js/echarts.min.js"></script>
	<script src="/vendors/echarts/map/js/world.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="/build/js/custom.js"></script>


</body>
</html>