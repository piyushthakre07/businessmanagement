<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Ledger Details</title>

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
    $("#ledgerFormId").on("submit", function(e) {
		e.preventDefault();
		var formData = $('#ledgerFormId').serializeArray();
		var s = '';
		var data = {};
		for (s in formData) {
			var fieldName=formData[s]['name'];
			if(fieldName.indexOf(".") != -1){
			var innerObjectJson={};
			innerObjectJson[fieldName.split(".")[1]]=formData[s]['value'];
				data[fieldName.split(".")[0]]=innerObjectJson;
		}else{
			 data[formData[s]['name']] = formData[s]['value']
		}
		}
		$.ajax({
			type : 'POST',
			url : '/master/ledger/addLedger',
			data : JSON.stringify(data),
			contentType : "application/json",
			
			success : function(result) {
				var resultSting = JSON.stringify(result);
				var jsonResult = JSON.parse(resultSting);
				if(jsonResult.status){
				alert(jsonResult.message);
				//window.location.href = "/ledger/ledgerdetails/showLedgerDetails";
				}
			},
			error : function(result) {
				var resultSting = JSON.stringify(result);
				var jsonResult = JSON.parse(resultSting);
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
			<!-- End Header File -->

			<!-- page content -->
			<div class="right_col" role="main">
				<br />
				<div class="row">
					<div class="col-md-12 ">
						<div class="x_panel">
							<div class="x_title">
								<h2>
									Add Ledger
								</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<br />
								<form id="ledgerFormId"
									class="form-horizontal form-label-left">
								
								<div class="form-group row">
										<label class="control-label col-md-3 col-sm-3 ">Select
											Business Unit</label>
										<div class="col-md-6 col-sm-9 ">

											<select name="businessUnit.businessUnitID" id="businessUnitID"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<c:forEach items="${businessUnits}" var="businessUnit">
													<option value="${businessUnit.businessUnitID}">${businessUnit.unitName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Ledger Name</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="text" name="ledgerName"
												class="form-control" placeholder="Ledger Name">
										</div>
									</div>
									
									<div class="form-group row">
										<label class="control-label col-md-3 col-sm-3 ">Select
											Ledger Type</label>
										<div class="col-md-6 col-sm-9 ">

											<select name="ledgerType" id="active"
												class="select2_single form-control" tabindex="-1">
												<option value="-1">Select</option>
												<option value="INCOME">Income</option>
												<option value="EXPENSE">Expense</option>
												<option value="INVESTMENT">Investment</option>
												<option value="OTHER">Other</option>
											</select>
										</div>
									</div>
				
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Contact Number</label>
										<div class="col-md-6 col-sm-9 ">
											<input type="text" name="contactNumber"
												class="form-control" placeholder="Contact Number">
										</div>
									</div>
									<div class="form-group row ">
										<label class="control-label col-md-3 col-sm-3 ">Address</label>
										<div class="col-md-6 col-sm-9 ">
										<textarea name="address"></textarea>
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
											<button type="button" class="btn btn-primary">Cancel</button>
											<button type="reset" class="btn btn-primary">Reset</button>
											<button type="submit" class="btn btn-success">Submit</button>
										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
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