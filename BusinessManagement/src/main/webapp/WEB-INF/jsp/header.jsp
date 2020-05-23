<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>Business Management! | </title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
      <link href="/../css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/css/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/css/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="/css/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="/css/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
     <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="/build/css/custom.css" rel="stylesheet">
    	<link rel="stylesheet" type="text/css" href="/jsgrid/demos/demos.css" />

	<link rel="stylesheet" type="text/css" href="/jsgrid/css/jsgrid.css" />
	<link rel="stylesheet" type="text/css" href="/jsgrid/css/theme.css" />
	<!-- GOOGLE FONTS-->
	<link href='/jsgrid/jquery-ui.css' rel='stylesheet'
		type='text/css' />
		<!-- Added for fond display -->
		 <link href="../../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    
    <link href="../../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../../build/css/custom.min.css" rel="stylesheet">
  <!--   End added for font -->
		
    <!-- <script src="/js/jquery-3.3.1.min.js"></script> -->
<script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>

      <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="#" class="site_title"><span>Business Management!</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>Rahul</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
               
                <ul class="nav side-menu">
                  <li><a  href="/home/dashboard"><i class="fa fa-home"></i> Home <span ></span></a>
                   
                  </li>
                  
                   <li><a><i class=""></i>Purchase<span class="fa fa-chevron-down"></span> <span class=""></span></a>
                    <ul class="nav child_menu">
                    <li><a href="/purchase/addPurchaseItem">Add Purchase Item</a></li>
                    <li><a href="/purchase/viewPurchaseItem">Show Purchase Item</a></li>
                    </ul>
                  </li>
                   <li><a> Account <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                       <li><a>Ledger <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                            <li><a href="/master/ledger/addLedger">Add Ledger Details</a></li>
                            <li><a href="/master/ledger/displayAllLedgers">Ledger Details</a></li>
                          </ul>
                        </li>
                   
                       <li><a>Investment Source <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                              <li><a href="/investment/investmentdetails/addInvestmentSource">Add Investment Source</a></li>
                              <li><a href="/investment/investmentdetails/showInvestmentSource">Show Investment Source</a></li>
                          </ul>
                        </li>
                   
                       <li><a>Manage Investments Amount <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                              <li><a href="/investment/investmentdetails/addInvestmentSource">Add Investment Source</a></li>
                              <li><a href="/investment/investmentdetails/showInvestmentSource">Show Investment Source</a></li>
                          </ul>
                        </li>
                    </ul>
                  </li>
                  
                   <li><a>Loan Management <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                       <li><a>Loan Details <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                            <li><a href="/loan/loanDetails/addLoneDetails">Add Loan Details</a></li>
                            <li><a href="/loan/loanDetails/showLoanDetails">Show Loan Details</a></li>
                          </ul>
                        </li>
                   
                  
                    </ul>
                  </li> 
                  <li><a>Investment Management <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                       <li><a>Investment Details <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                            <li><a href="/investment/investmentdetails/addInvestmentDetails">Add Investment Details</a></li>
                            <li><a href="/investment/investmentdetails/showInvestmentDetails">Show Investment Details</a></li>
                          </ul>
                        </li>
                   
                       <li><a>Investment Source <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                              <li><a href="/investment/investmentdetails/addInvestmentSource">Add Investment Source</a></li>
                              <li><a href="/investment/investmentdetails/showInvestmentSource">Show Investment Source</a></li>
                          </ul>
                        </li>
                   
                       <li><a>Manage Investments Amount <span class="fa fa-chevron-down"></span></a>
                          <ul class="nav child_menu">
                              <li><a href="/investment/investmentdetails/addInvestmentSource">Add Investment Source</a></li>
                              <li><a href="/investment/investmentdetails/showInvestmentSource">Show Investment Source</a></li>
                          </ul>
                        </li>
                    </ul>
                  </li>
                  <li><a><i class=""></i> Masters <span class="fa fa-chevron-down"></span><span class=""></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/master/owner/showOwner">Owner Master</a></li>
                      <li><a href="/master/businessCatagory/showBusinessCatagory">BusinessCatagory Master</a></li>
                       <li><a href="/master/bankDetails/showBankDetails">Bank Master</a></li>
                      <li><a href="/master/businessUnit/showBusinessUnit">Business Unit Master</a></li>
                      <li><a href="/master/ledger/showLedger">Ledger Master</a></li>
                      <li><a href="/master/partnerDetailsController/showPartners">Partner Master</a></li>
                      <li><a href="/master/paymentController/showPayment">Payment Master</a></li>
                      <!-- <li><a href="/user/showUser">User Master</a></li> -->
                      <li><a href="/master/receiptController/showReceipt">Receipt Master</a></li>

                    </ul>
                  </li>
                <!--   <li><a><i class=""></i>Ghaphical Reports <span class=""></span></a>
                    <ul class="nav child_menu">
                    <li><a href="#">Stock Reports</a></li>
                     <li><a href="#">Item  Reports</a></li>
                     <li><a href="#">Purchase  Reports</a></li>
                    </ul>
                  </li> -->
 
                </ul>
              </div>
            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>
        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
              <nav class="nav navbar-nav">
              <ul class=" navbar-right">
                <li class="nav-item dropdown open" style="padding-left: 15px;">
                  <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                    <img src="/images/img.jpg" alt="">Rahul
                  </a>
                  <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item"  href="javascript:;"> Profile</a>
                      <a class="dropdown-item"  href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                  <a class="dropdown-item"  href="javascript:;">Help</a>
                    <a class="dropdown-item"  href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                  </div>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        
        