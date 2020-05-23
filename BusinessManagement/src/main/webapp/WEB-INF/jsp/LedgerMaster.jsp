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
		
 <script src="/js/jquery-3.3.1.min.js"></script>
<script src="/js/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script>
$(document).ready(function () {
	
 var objectDataRole=[];
	 firstFunction();
	function firstFunction(){
	 $.ajax({
        type: 'GET',
        contentType: "application/json; charset=utf-8",
        url: '/master/bankDetails/displayAllBankDetails',
        dataType: "json",
	}).done(function(data) {
		 $.each(data,function(key,value){
        	 var objectData={};
    		 objectData['Name']=value.bankAccountTitle;
    		 objectData['Id']=value.bankId;
    		 objectDataRole.push(objectData);
    		
        	 });
		 secondFunction();
	});
	}
	
	var status = [
        { Name: "", Id: "" },
        { Name: "Active", Id:"Y" },
        { Name: "Inactive", Id: "N" }
    ];
	
	function secondFunction(){
	$("#ledgerDetailsTableContainer").jsGrid({
	       width: "100%",
	       filtering: true,
	       editing: true,
	       sorting: true,
	       paging: true,
	       autoload: true,
	       inserting: true,
	       deleting:false,
	       pageSize: 5,
	       pageButtonCount: 5,
	       deleteButton:false,
	       controller: {
	           loadData: function(filter) {
	           	var d = $.Deferred();
	               $.ajax({
	                   type: 'GET',
	                   contentType: "application/json; charset=utf-8",
	                   url: '/master/ledger/displayAllLedgers',
	                   dataType: "json",
	                   data:filter,
	                     success: function (data) {
	                    	
	                     	var data1 = $.grep(data, function(data) {
	                            return (!filter.ledgerName || (data.ledgerName+'').toUpperCase().indexOf(filter.ledgerName.toUpperCase()) > -1)
	                       });   
                   	d.resolve(data1);
                   
	                   },
	                   error: function(e) {
	                       alert("error: " + e.responseText);
	                   } 
	                  
	               });
	              
	                return d.promise();
	           },
	         insertItem: function(insertingClient) {
	    	       $.ajax({
	    	                   type: 'POST',
	    	                   url: '/master/ledger/insertLedger',
	    	                   dataType: "json",
	    	                   contentType: 'application/json',
	    	                   data: JSON.stringify(insertingClient),
	    	                   success: function (data) {
	    	                   	alert("Insertion done successfully");
	    	                   	window.location.reload();
	    	                   }
	    	   	});
	    	       
	    	   },

	    	   updateItem: function(updatingClient) {
	    	   	$.ajax({
	    	                   type: 'POST',
	    	                   url: '/master/ledger/insertLedger',
	    	                   dataType: "json",
	    	                   contentType: 'application/json',
	    	                   data: JSON.stringify(updatingClient),
	    	                   success: function (data) {
	    	                   	alert("Updation done successfully");
	    	                 	window.location.reload();
	    	                   }
	    	   	});  
	    	  
	    	   },

	    	   deleteItem: function(deletingClient) {
	    	   	$.ajax({
	    	                   type: 'POST',
	    	                   url: '/master/ledger/insertLedger',
	    	                   dataType: "json",
	    	                   contentType: 'application/json',
	    	                   success: function (data) {
	    	                   	alert("Deletion done successfully");
	    	                   	window.location.reload();
	    	                   }
	    	   	});  
	    	   }
	    	  
	       },
	       fields: [
	    	       { name: "ledgerId", type: "hidden",  width:75, title: "Ledger Id"},
		           { name: "ledgerName", type: "text",  width:75, title: "Ledger Name"},
		           { name: "ledgerType", type: "text",  width:75, title: "Ledger Type"},
		           { name: "contactNumber", type: "text",  width:75, title: "Contact Number"},
		           { name: "address", type: "text",  width:75, title: "Address"},
		           { name: "active", type: "select", items:status, valueField: "Id",textField: "Name",  width:75, title: "Active"},
		           { name: "bankDetails.bankId", type: "select", items:objectDataRole, valueField: "Id",textField: "Name",  width:75, title: "Bank Details"},
		           { type: "control" } 
		       ]
	       
		       });
	
	}	
	
}); 

</script>
  </head>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
    <!--   Header File Include -->
    <jsp:include page="header.jsp" />
 <!--    Header File CLose -->
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
                    <h2>Ledger <small>Master</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  
                  
                  <div class="x_content">
                    <div class="table-responsive">
					<div id="ledgerDetailsTableContainer"></div>
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
    <!-- Custom Theme Scripts -->
    <script src="../../build/js/custom.min.js"></script>

	<script src="../../jsgrid/jsgrid.core.js"></script>
<script src="../../jsgrid/jsgrid.load-indicator.js"></script>
<script src="../../jsgrid/jsgrid.load-strategies.js"></script>
<script src="../../jsgrid/jsgrid.sort-strategies.js"></script>
<script src="../../jsgrid/jsgrid.field.js"></script>
<script src="../../jsgrid/fields/jsgrid.field.text.js"></script>
<script src="../../jsgrid/fields/jsgrid.field.number.js"></script>
<script src="../../jsgrid/fields/jsgrid.field.select.js"></script>
<script src="../../jsgrid/fields/jsgrid.field.checkbox.js"></script>
<script src="../../jsgrid/fields/jsgrid.field.control.js"></script>
  </body>
</html>
