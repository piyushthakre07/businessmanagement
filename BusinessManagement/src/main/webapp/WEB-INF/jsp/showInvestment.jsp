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


<script>
$(document).ready(function () {
	var	investmentTable;
	investmentDatatableTable();
	function investmentDatatableTable(){
		investmentTable = $('#investmentTable').DataTable({
	"ajax": {
	"url": "/investment/investmentdetails/displayAllInvestmentDetails",
	"type": "GET",
	async:false,
	"contentType": "application/json; charset=utf-8",
	},
	"columns": [             
	{ "data": "businessUnit.unitName","bSortable":true, "class":"text-wrap"},
	{ "data": "totalInvestAmount", "width": "350px", "class":"text-wrap"},
	{ "data": "amountInvest","className":'',"bSortable":true},
	{ "data": "percentage","bSortable":true, "class":"text-wrap"},
	{ "data": "duration", "width": "350px", "class":"text-wrap"},
	{ "data": "description","bSortable":true, "class":"text-wrap"},
	{ "data": "active", "width": "350px", "class":"text-wrap"},
	{ "data": "remark","bSortable":true, "class":"text-wrap"},
	],
	dom: 'Bfrtip',
    buttons: [
    	  {
    	        extend: 'copyHtml5',
    	        title: 'Investment Details'
    	    },
    	    {
    	        extend: 'excelHtml5',
    	        title: 'Investment Details'
    	    },
    	    {
    	        extend: 'csvHtml5',
    	        title: 'Investment Details'
    	    },
    	    {
    	        extend: 'pdfHtml5',
    	        title: 'Investment Details'
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
                    <h2> Show Investment Details</h2>
                    <div class="clearfix"></div>
                  </div>
                  
                  <a href="/investment/investmentdetails/addInvestmentDetails"><div class="btn btn-round btn-success">Add Investment Details</div></a>
                 
                  <table id="investmentTable"  class="table table-striped jambo_table bulk_action"> 
		           <thead>
		            <tr>
		                <th>Business Unit</th>
		                <th>Total Amount</th>
		                <th>Amount Investment By Us</th>
		                <th>Our Percentage</th>
		                <th>Duration In Month</th>
		                <th>Description</th>
		                <th>Remark</th>
		                <th>Active</th>
		            </tr>
		          </thead>
                  </table>
                  <div class="x_content">
                    <div class="table-responsive">
					<div id="investmentTableContainer"></div>
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
   <script src="../../vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FastClick -->
    <script src="../../../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="..//vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../../vendors/iCheck/icheck.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../../build/js/custom.min.js"></script>

  </body>
</html>
