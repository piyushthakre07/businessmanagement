<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>Business Management! | </title>
<link href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css" rel="stylesheet">		
<!--  <script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script> -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>


<script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>



    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
   


<script>
$(document).ready(function () {
	var	loanTable;
	loanDatatableTable();
	function loanDatatableTable(){
		loanTable = $('#loanTable').DataTable({
	"ajax": {
	"url": "/loan/loanDetails/displayAllLoanDetails",
	"type": "GET",
	async:false,
	"contentType": "application/json; charset=utf-8",
	},
	"columns": [             
	{ "data": "loanTitle","bSortable":true, "class":"text-wrap"},
	{ "data": "loanFromLeadger.ledgerName", "class":"text-wrap"},
	{ "data": "loanReceiveIntoBank.bankAccountTitle","className":'',"bSortable":true},
	{ "data": "loanAmount","bSortable":true, "class":"text-wrap"},
	{ "data": "tenure",  "class":"text-wrap"},
	{ "data": "installmentFrequency","bSortable":true, "class":"text-wrap"},
	{ "data": "rateOfInterest",  "class":"text-wrap"},
	{ "data": "totalInterestPaid","bSortable":true, "class":"text-wrap"},
	
	{ "data": "emiAmountPerMonth","bSortable":true, "class":"text-wrap"},
	{ "data": "paymentMode",  "class":"text-wrap"},
	{ "data": "emiStartDate","bSortable":true, "class":"text-wrap"},
	{ "data": "dueOn","bSortable":true, "class":"text-wrap"},
	{ "data": "description", "class":"text-wrap"},
	{ "data": "active","bSortable":true, "class":"text-wrap"},
	{ "data": "remark","bSortable":true, "class":"text-wrap"}
	],
	dom: 'Bfrtip',
    buttons: [
    	  {
    	        extend: 'copyHtml5',
    	        title: 'Loan Details',
    	        className:'btn btn-primary pull-right'
    	    },
    	    {
    	        extend: 'excelHtml5',
    	        title: 'Loan Details',
    	        className:'btn btn-primary pull-right'
    	    },
    	    {
    	        extend: 'csvHtml5',
    	        title: 'Loan Details',
    	        className:'btn btn-primary pull-right'
    	    },
    	    {
    	        extend: 'pdfHtml5',
    	        title: 'Loan Details',
    	        className:'btn btn-primary pull-right '
    	    }
    ],
    
  
	"bAutoWidth": true,
	"bSort":true,
	"bFilter" : true,  
	"serverSide": false,
	"bLengthChange": true,
	"bProcessing": true,
	"sort": "position",
	"paging":true,
	"aaSorting": [[ 0, "desc" ]],
	"pageLength": 5,
	"bLengthChange": true,
	"ordering": true,
	"pagingType": "simple",
	"oLanguage": {
	"oPaginate": { 
	"sFirst": "First", 
	"sPrevious": "<i class='fa fa-long-arrow-left' aria-hidden='true'></i> Prev", 
	"sNext": "Next <i class='fa fa-long-arrow-right' aria-hidden='true'></i>", 
	"sLast": "Last" 
	}}});
	
	}

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
          <div class="">
            <div class="clearfix"></div>
            <div class="row" style="display: block;">
              <div class="clearfix"></div>
              <div class="clearfix"></div>
              <div class="col-md-12 col-sm-12  ">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> Show Loan Details</h2>
                    <div class="clearfix"></div>
                  </div>
                  
                  <a href="/loan/loanDetails/addLoneDetails"><div class="btn btn-round btn-success">Add Loan Details</div></a>
                 
                  <!-- <table id="loanTable"  class="table table-striped jambo_table bulk_action">  -->
                   <table  id="loanTable" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
		           <thead>
		            <tr>
		                <th>Loan Title</th>
		                <th>Leadger</th>
		                <th>Received Bank</th>
		                <th>Amount</th>
		                <th>Tenure</th>
		                <th>Installment Frequency</th>
		                <th>Interest</th>
		                <th>Total Interest</th>
		                 <th>Emi Amount</th>
		                <th>Payment Mode</th>
		                <th>Emi Start Date</th>
		                <th>Due On</th>
		                <th>Description</th>
		                <th>Active</th>
		                <th>Remark</th>
		            </tr>
		          </thead>
                  </table>
                  <div class="x_content">
                    <div class="table-responsive">
					<div id="loanTableContainer"></div>
				</div>
				</div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
          
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>
    <!-- jQuery -->

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
	
	
<script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="../../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../../vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../../vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="../../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../../vendors/jszip/dist/jszip.min.js"></script>
    <script src="../../vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../../vendors/pdfmake/build/vfs_fonts.js"></script>





  </body>
</html>
