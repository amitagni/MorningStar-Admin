<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Ledger</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
     
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
     
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.material.min.css">
      <link rel="stylesheet" href="css/materialize.min.css">
      <link rel="stylesheet" type="text/css" href="css/easy-autocomplete.min.css">
      <style type="text/css">
         .placeholder {
    width: 175px;
    height: 150px;
    background-repeat: no-repeat;
    background-size: contain;
    border: 2px solid #aaaaaa;
}
.search-c{
    
    padding: 15px !important;
    
}

.input-field .prefix {
    position: absolute;
    width: 3rem;
    font-size: 2rem;
    -webkit-transition: color .2s;
    -moz-transition: color .2s;
    -o-transition: color .2s;
    -ms-transition: color .2s;
    transition: color .2s;
    line-height: 1.7;
      </style>
   <body class="dashboard-body">
     <!--  <ul id="dropdown1" class="dropdown-content">
         <li><a href="login.html">Login</a>
         </li>
         <li><a href="#!">Profile</a>
         </li>
         <li class="divider"></li>
         <li><a href="#!">Logout</a>
         </li>
      </ul> -->
     <%@ include file="../includes/header.jsp"%>
     <form:form  modelAttribute="ledgerBean"  action="ledger.do" name="ledger" method="post" class="formValidate" novalidate="novalidate">
     <form:hidden  path="transactionType"/>
     <form:hidden   path="id"  id="accountId" />
     <div class="container_b">
      <div class="valign-wrapper row ">
         <div class="col s12 valign">
            <div class="card-panel search-c">
               <!-- <h4 class="header2">Search</h4> -->
               <div class="row">
                  <form class="formValidate" id="formValidate"  method="get" action="" novalidate="novalidate">
                     <div class="col s12 m12">
                        <h5>Search</h5></div>
                        
                      <div class="row">
                        
                        
                          <div class="input-field col s12 m3" style="padding: 0px 72px;">
          <!-- <i class="material-icons prefix">search</i>
          <input type="text" id="autocomplete-input" class="autocomplete">
          <label for="autocomplete-input">Autocomplete</label> -->
          	<img src="img/search.png" class="serach-img" style="height: 19px;margin: 16px -23px;">
           			<input type="text" id="basics">
         			<%--  <form:select class="error browser-default" path="id"  >
                                		<form:options items="${ledgerBean.accountList}" itemValue="id"  itemLabel="accountName" />
                      </form:select>  --%>
                                
        </div>

                        
                        <div class="col s12 m4" style="line-height: 6;">Transaction Type'
                          <input name="group1" type="radio" id="test1" onclick="setTrType('1')" />
					      <label for="test1">Debit</label>
					      <input name="group1" type="radio" id="test2" onclick="setTrType('2')" />
					      <label for="test2">Credit</label>
					       <input name="group1" type="radio" id="test3" onclick="setTrType('3')" checked />
					      <label for="test3">Both</label>

                        </div>
                        <div class="col s12 m2 input-field ">
                        	<i class="material-icons prefix">perm_contact_calendar</i>
                        	 <label for="startDate" class="">From</label>
                              <form:input path="startDate" id="startDate"  class="datepicker"  required="required" />
                              <div class="errorTxt2"></div>
                        	<!-- <input type="text" class="datepicker"><label for="icon_prefix">From</label> -->
                        </div>
                        <div class="col s12 m2 input-field ">
                        	<i class="material-icons prefix">perm_contact_calendar</i>
                        	<label for="endDate" class="">To</label>
                              <form:input path="endDate"  class="datepicker" id="endDate"  required="required" />
                              <div class="errorTxt2"></div>
                        	<!-- <input type="text" class="datepicker1"><label for="icon_prefix">To</label> -->
                        </div>
                        <div class="col s12 m1" style="line-height: 5;">
                        		<a href="javascript: submitForm('ledgerBean')" class="waves-effect waves-light btn">Go</a>
                        </div>



                      </div>
                      <div class="col s12 m12">
                         <table class="bordered" id="example" class="mdl-data-table">
        <thead>
          <tr>
           	  <th>S.No</th>
              <th>Transaction Type</th>
              <th>Amount</th>
              <th>Comments</th>
              
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${ledgerBean.dayBookDTOList}" var="dayBookDTO" varStatus="status"> 
          <tr>
           <td>${status.index +1}</td>
            <td>${dayBookDTO.transactionType }</td>
            <td>${dayBookDTO.amount }</td>
            <td>${dayBookDTO.comment }</td>
          </tr>
         </c:forEach> 
        </tbody>
      </table>

                      </div>
                    
                  </form>
               </div>
            </div>
         </div>
      </div>
      </div>
     </form:form>
      </div>

    
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
     <!--  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.material.min.js"></script> -->
      <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/jquery.easy-autocomplete.min.js"></script>
      


<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
      <script type="text/javascript">
      $(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    
$('#example').DataTable( {
        bFilter: false, bInfo: false
    } );



 $('#startDate').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    today: 'Today',
    clear: 'Clear',
    close: 'Ok',
    closeOnSelect: true,
    
  });
 
 var startdate = $('#startDate').pickadate('picker');
 $('#endDate').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year,
    today: 'Today',
    clear: 'Clear',
    close: 'Ok',
    closeOnSelect: true,
  });
 var enddate = $('#endDate').pickadate('picker');
 $('#startDate').change(function() {
	  
	
	 selected_ci_date ="";
	  selected_ci_date = $('#startDate').val();
	  if (selected_ci_date != null)   {
	    var cidate = new Date(selected_ci_date);
	    /* alert(cidate); */
	    $("#endDate").val("");
	    $("#endDate").removeAttr("disabled");
	    min_codate = "";
	    min_codate = new Date();
	    min_codate.setDate(cidate.getDate()+1);
	    enddate.set('min', min_codate);
	  }
	})

  });
       
    function setTrType(trType){
		 document.getElementById("transactionType").value = trType;
	}
     
     function submitForm(formId){
  		
   	  var x = document.forms["ledger"]["startDate"].value;
   		var y = document.forms["ledger"]["endDate"].value;
   		if(x==null||x==""){
   			
   			
   			alert("Please Select The  Start Date");
   			document.getElementById("startDate").focus();
   			return false;
   		}if(y==null||y==""){
   			alert("Please Enter The End Date");
   			document.getElementById("endDate").focus();
   			}
   		else{
   		
   		return	$("#"+formId).submit();
   			
   		}
   	 
  	}     
   var seltrType =   document.getElementById("transactionType").value;
   if(seltrType != null && seltrType != ""){
   	//alert(seltrType);
   		document.getElementById("test"+seltrType).checked =  true;
   }
   
   var options = {
 		  url: function(phrase) {
 			  console.log(phrase);  
 			  return "fetch-accountlist.do?accountName="+phrase;
 			    
 			  },

 			  getValue: function(element) {
 			    return element.label;
 			  },

 			  ajaxSettings: {
 			    dataType: "json",
 			    method: "POST",
 			    data: {
 			      dataType: "json"
 			    }
 			  },

 			 preparePostData: function(data) {
 			    data.phrase = $("#basics").val();
 			    return data;
 			  },

 			  requestDelay: 400,


 		  

 		  	template: {
 		  		type: "custom",
 		  		method: function(value,item) {
 		  			return   item.label;
 		  		}
 		  	},
 		  	list: {

 				onSelectItemEvent: function() {
 					var index = $("#basics").getSelectedItemIndex();
 					var value = $("#basics").getSelectedItemData();
 					console.log(value.descValue);
 					console.log(value.label);
 					var des=decodeURIComponent(value.descValue).split(":");
 		    		var dese=des[1];
 		    		var id=des[0];
 		    		console.log(id);
 					$("#accountId").val(id);
 				} 
 			} 
 			 
 		};

 		$("#basics").easyAutocomplete(options);
         
        
      </script>
      <!--materialize js-->
   </body>
</html>