<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="images/favicon.ico" type="image/ico" />

<title>Dashboard! |</title>
<script src="/js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap -->
<link href="/vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/daterangepicker.css"
	rel="stylesheet">
<!-- Custom Theme Style -->
<link href="/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<!-- Header File -->
			<jsp:include page="header.jsp" />
			<!-- End Header File -->

			<!-- page content -->
			<div class="right_col" role="main">
				<!-- top tiles -->
				<div class="">
					<div class="tile_count">
						<div class="col-md-3 col-sm-4  tile_stats_count">
							<span class="count_top"><i class=""></i> Total Contractor</span>
							<div class="count">
								<a href="/contractor/showContractor"></a>
							</div>
						</div>
						<div class="col-md-3 col-sm-4  tile_stats_count">
							<span class="count_top"><i class=""></i> Total Vendor</span>
							<div class="count">
								<a href="/vendor/showVendor"></a>
							</div>


						</div>
						<div class="col-md-3 col-sm-4  tile_stats_count">
							<span class="count_top"><i class=""></i> Total Users</span>
							<div class="count green">
								<a href="/user/showUser"></a>
							</div>

						</div>
						<div class="col-md-3 col-sm-4  tile_stats_count">
							<span class="count_top"><i class=""></i> Total Sites</span>
							<div class="count">
								<a href="/sites/showSite"></a>
							</div>
						</div>
					</div>
				</div>
				<!-- /top tiles -->
				<br />
				<!-- footer content -->
				<footer>
					<div class="pull-right"></div>
					<div class="clearfix"></div>
				</footer>
				<!-- /footer content -->
			</div>
		</div>
	</div>
		<!-- Custom Theme Scripts -->
	
	<script src="/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	
	<!-- Chart.js -->
	<script src="/build/js/Chart.min.js"></script>
	<!-- gauge.js -->
	<script src="/build/js/gauge.min.js"></script>
	<!-- ECharts -->
	<script src="/build/js/echarts.min.js"></script>
	<script src="/vendors/echarts/map/js/world.js"></script>
	<script src="/js/moment.js"></script>
	<script src="/build/js/custom.js"></script>
    <script src="/js/daterangepicker.js"></script>
</body>
</html>