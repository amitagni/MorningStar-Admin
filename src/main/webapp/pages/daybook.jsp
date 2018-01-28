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
      <title>DayBook</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> 
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css">
       <link rel="stylesheet" type="text/css" href="css/easy-autocomplete.min.css">
      <link href="css/jquery-ui.css" rel="Stylesheet"></link>
        <style>
      table{
      table-layout: fixed;
      }
      td,th{
      word-wrap: break-word;
          word-wrap: break-word;
    padding: 4px;
    font-size: 12px;
      }
      .dataTables_filter, .dataTables_info,.dataTables_length { display: none; }
      .paginate_button{
      cursor: pointer;
    padding: 2px;
    } 
      </style>
   <body class="dashboard-body">
      <%@ include file="../includes/header.jsp"%>
      <form:form  modelAttribute="dayBookBean"  action="daybook.do" name="dayBookBean" method="post"  class="formValidate" novalidate="novalidate">
      <form:hidden path="transactionType"/>
      <form:hidden path="paymentType"/>
      <div class="container_b">
         <div class="valign-wrapper row ">
            <div class="col s12 valign">
               <div class="card-panel search-c">
                  <!-- <h4 class="header2">Search</h4> -->
                  <div class="row">
                     <form:hidden path="userAction"/>
	                    <c:if test="${not empty message}">
	                        <span class="text-center ">${message}</span>
	                    </c:if>
                        <div class="col s12 m6">
                           <div class="row">
                              <div class="col s6 m2">
                                 <br>
                                 <h6>Account</h6>
                              </div>
                              <div class="col s6 m6 input-field" style="margin-left: 42px;">
                              <!--    
                               <i class="material-icons prefix" style="top: 11px;"> search</i>
                               <input type="text" id="autocomplete-input" class="autocomplete">
                              -->
                              <img src="img/search.png" class="serach-img">
                                <input type="text" id="basics">
                                <span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                               <%--  <form:select class="error browser-default" path="accountBean.id" id="lastClass" >
                                		<form:options items="${dayBookBean.accountList}" itemValue="id"  itemLabel="accountName" />
                          		</form:select>  --%>
                                
                              
                              </div>
                              <div class="col s6 m3">
                                 <br>
                                 <a class="modal-trigger" href="#modal" style="margin-top: 6px;" onclick="submitPopup(1)" ><i id="mdl" class="material-icons left" style="
                                    font-size: 35px;
                                    margin-left: -22px;" 
                                    onclick="setAction('1')";>add_circle_outline</i></a>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <h6>Transaction Type</h6>
                              </div>
                              <div class="col s6 m9">
                                 <input name="group1" type="radio" id="test12"  value="1" onclick="setTrType('2')" checked/>
                                 <label for="test12">Credit  </label>
                                 <input name="group1" type="radio" id="test13" value="2" onclick="setTrType('1')"  />
                                 <label for="test13">Debit</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <h6>Payment Type</h6>
                              </div>
                              <div class="col s6 m9">
                                 <input name="group2" type="radio" id="test1"   value="1" onchange="checkbox(this)" onclick="setPyType('1')" checked/>
                                 <label for="test1">Cash </label>
                                 <input name="group2" type="radio" id="test2" value="2" onchange="checkbox(this)" onclick="setPyType('2')" />
                                 <label for="test2">Cheque number</label>
                                 <input name="group2" type="radio" id="test3" value="3" onchange="checkbox(this)" onclick="setPyType('3')" />
                                 <label for="test3">Epay</label>
                              </div>
                           </div>
                           <div class="row Epay">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Epay</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                  <form:input id="chequeEpayNo" placeholder="Epay No" path="chequeEpayNo" type="text"  />
                                 <label for="chequeEpayNo">Epay No</label>
                              </div>
                           </div>
                           <div class="row Cheque">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Cheque number</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <form:input  placeholder="Cheque number"  id="chequeEpayNo" path="chequeEpayNo" type="number"   />
                                 <label for="chequeEpayNo">Cheque number</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Amount</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <form:input placeholder="Amount" id="amount" path="amount" type="number"   />
                                 <label for="amount">Amount</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="col s6 m3">
                                 <br>
                                 <h6>Comments</h6>
                              </div>
                              <div class="input-field col s6 m6">
                                 <form:textarea id="textarea1" path="comments" class="materialize-textarea"  maxlength="100"   data-length="100"></form:textarea>
                                 <label for="textarea1">Comments</label>
                              </div>
                           </div>
                           <div class="row">
                              <div class="input-field col s12 center-align ">
                                 <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action" onclick="return submitForm('dayBookBean','1')">Submit
                                 <i class="mdi-content-send right"></i>
                                 </button>
                                 <button class="btn waves-effect waves-light reset submit" type="button" name="action">Reset
                                 <i class="mdi-navigation-close right"></i>
                                 </button>
                              </div>
                           </div>
                        </div>
                       
                        <div class="col s6 m6">
						 <%-- <h5  > &nbsp;&nbsp;${dayBookBean.dayBookDate} Daybook</h5> --%>
						 <div class="input-field col s4">
						<label for="da" class="">Select Date</label>
						 <form:input path="dayBookDate" type="text" id="da"  class="datepicker" required="required" onchange="setSelectedDate(this);"/>
                             
                             
							 </div>
                           <table class="bordered responsive-table" id="main">
                              <thead>
                                 <tr>
                                    <th width="7%" class="text-center">S.No</th>
                                    <th width="20%">Account</th>
                                    <th width="8%" class="text-center">TR Type</th>
                                    <th width="15%" class="text-center">Payment Type</th>
                                    <th width="12%">Amount</th>
                                    <th width="27%">Comments</th>
                                    <th width="11%" class="text-center">Action</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 
                              <c:forEach items="${dayBookBean.dayBookDTOList}" var="dayBookDTO" varStatus="status">   
                                 <tr>
                                    <td class="text-center">${status.index +1}</td>
                                    <td>${dayBookDTO.accountName }</td>
                                    <td class="text-center">${dayBookDTO.transactionType }</td>
                                     <td class="text-center">${dayBookDTO.paymentType }</td>
                                    <td>${dayBookDTO.amount }</td>
                                    <td>${dayBookDTO.comment }</td>
                                    <td class="text-center"><a href="javascript:deleteEntry(${dayBookDTO.id})" class="text-center"><i class="material-icons ">cancel</i></a></td>
                                 </tr>
                              </c:forEach>  
                                 
                               
                              </tbody>
                           </table>
                        </div>
                     
                  </div>
               </div>
            </div>
         </div>
      </div>
      </div>
      <div id="modal" class="modal">
         <div class="modal-content">
            <h4>Account Creation(A/C)</h4>
              <form:hidden   path="accountBean.id"  id="accountId" />
            <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Account Name</h6>
               </div>
               <div class="input-field col s6 m6">
                  <form:input path="accountBean.name" id="name" type="text" class="validate" placeholder="Name" />
                  <label for="Amount">Account Name</label>
               </div>
            </div>
            <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Desc</h6>
               </div>
               <div class="input-field col s6 m6">
                  <form:input path="accountBean.description" id="description"  type="text" class="validate" placeholder="Description" />
                  <label for="Amount">Desc</label>
               </div>
            </div>
            <div class="input-field col s12 center-align " id="submit" style="display:none;">
               <button class="btn waves-effect waves-light  submit center-btn" type="button"  onclick="return submitForm('dayBookBean','2','1')">Submit
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light modal-close submit" type="button" onclick="$('#modal1').modal('close');setAction('2')">Exit
               <i class="mdi-navigation-close right"></i>
               </button>
            </div>
              <div class="input-field col s12 center-align " id="edit">
               <button class="btn waves-effect waves-light  submit center-btn" type="button"  onclick="return submitForm('dayBookBean','2','2')">edit
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light  submit center-btn" type="button"  onclick="return submitForm('dayBookBean','2','3')">Delete
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light modal-close submit" type="button" onclick="$('#modal1').modal('close');setAction('2')">Exit
               <i class="mdi-navigation-close right"></i>
               </button>
            </div>
            
         </div>
      </div>
      
       <%-- <div id="modal1" class="modal">
         <div class="modal-content">
            <h4>Account Edit</h4>
           <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Account Name</h6>
               </div>
               <div class="input-field col s6 m6">
                  <form:input path="accountBean.name"  type="text" class="validate" placeholder="Name" />
                  <label for="Amount">Account Name</label>
               </div>
            </div>
            <div class="row">
               <div class="col s6 m3">
                  <br>
                  <h6>Desc</h6>
               </div>
               <div class="input-field col s6 m6">
                  <form:input path="accountBean.description"  type="text" class="validate" placeholder="Description" />
                  <label for="Amount">Desc</label>
               </div>
            </div>
            <div class="input-field col s12 center-align ">
               <button class="btn waves-effect waves-light  submit center-btn" type="button"  onclick="#">edit
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light  submit center-btn" type="button"  onclick="#">Delete
               <i class="mdi-content-send right"></i>
               </button>
               <button class="btn waves-effect waves-light modal-close submit" type="button" onclick="#">Exit
               <i class="mdi-navigation-close right"></i>
               </button>
            </div>
         </div>
      </div> --%>
      </form:form>
      

	   
     <script type="text/javascript" src="js/jquery.min.js"></script>
     <script src="js/materialize.min.js"></script>
     <script type="text/javascript" src="js/dropify.min.js"></script>
     <script type="text/javascript" src="js/jquery.easy-autocomplete.min.js"></script>
	 <script src="js/jquery.validate.min.js"></script>
     <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" ></script>
	 <script src="js/jquery-ui.js" ></script>
     <script type="text/javascript">
       $('.datepicker').pickadate({
      	  closeOnSelect: true,
      	  onSet: function (ele) {
      		   if(ele.select){
      		          this.close();
      		   }
      		}, 
      	 selectMonths: true, 
      	 selectYears: 100 
      });
  
      function submitPopup(i,d){
    	  if(i==1){
    		  $("#submit").show();
    		  $("#edit").hide();
    	  }else{
    		  $("#submit").hide();
    		  $("#edit").show();
    		
    		 
    		var des=decodeURIComponent(d).split(":");
    		var dese=des[1];
    		var id=des[0];
    		$("#accountId").val(id);
    		$("#description").val(dese);
    		$("#name").val(decodeURIComponent(i));
    		setAction('1');
    		
    	}
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
    		  			return   item.label+"<i class=\"material-icons dp48 right modal-trigger \" href=\"#modal\" onclick=submitPopup('"+encodeURIComponent(item.label)+"','"+encodeURIComponent(item.descValue)+"')>create</i>";
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
      
      function submitForm(formId, n, actiontype){
      	
      	if(n==2){
      		var x = document.forms["dayBookBean"]["accountBean.name"].value;
      		var y = document.forms["dayBookBean"]["accountBean.description"].value;
      		if((x==null||x=="") && (y==null||y=="")){
      			
      			
      			alert("please enter the name and description");
      			document.getElementById("accountBean.name").focus();
      			return false;
      		}else{
      			document.getElementById("userAction").value  = document.getElementById("userAction").value  +":"+actiontype;
      			$("#"+formId).submit();
      			
      		}
      	}
      	if(n==1){
      		var a = document.getElementById("accountId").value;
      		var x = document.forms["dayBookBean"]["amount"].value;
      		var y = document.forms["dayBookBean"]["chequeEpayNo"].value;
      		var z = document.forms["dayBookBean"]["textarea1"].value;
      		if((a==null||a=="") ){
      			alert("please select account first. ");
      			document.getElementById("accountId").focus()
      			return false;
      			
      		}
      		if((x==null||x=="") ){
      			alert("please enter the amount. ");
      			document.getElementById("amount").focus()
      			return false;
      			
      		}
      		else if((z==null||z=="") ){
      			alert("please enter the comment. ");
      			document.getElementById("textarea1").focus()
      			return false;
      			
      		}
      		else{
      			//$("#"+formId).submit();
      			return true;
      		}	
      	}
      	
      	
      	
      	
    	}
      
      
      
         $(document).ready(function(){
        	 
        	 $('#modal').modal();
     		 

        	 $('#main').dataTable({
        		 
        		 bInfo: false,
        		 bFilter: false,
        		
        		 searching: false,
        		 columnDefs: [
        		                { orderable: false, targets: 1 },
        		                { type: 'num' },
        		                { orderable: false, targets: 2 },
        		                { orderable: false, targets: 3 },
        		                { orderable: false, targets: 4 },
        		                { orderable: false, targets: 5 },
        		              ], 
        		              aaSorting: [ 0, 'desc' ],
        		              
        		              /* ordering: false */
        	
        		 
        	 
        		});
        
           		 


        
        		 
   		
            $('select').material_select(); 
            $('.modal').modal({
                dismissible: true, // Modal can be dismissed by clicking outside of the modal
               opacity: .5,
           }); 
               
               
              
                
         
          
         $('.Epay').hide();
         $('.Cheque').hide();
         $(document).ready(function() {
        	 
        	 $(".reset").click(function() {
                 $(this).closest('form').find("input[type=text], textarea,input[type=number], textarea,input[type=email]").val("");
             });
        	 
         var t = $('#example').DataTable( {
           "columnDefs": [ {
               "searchable": false,
               "orderable": false,
               "targets": 0
           } ],
           "order": [[ 1, 'asc' ]]
         } );
         
         t.on( 'order.dt search.dt', function () {
           t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
               cell.innerHTML = i+1;
           } );
         } ).draw();
         } );
         
         });
          function checkbox(id){
             var test1= id.value;
         var test2= id.value;
         var test3=  id.value;
         
         if(test1==1){
         $('.Epay').hide();
         $('.Cheque').hide();
         }
         else if(test2==3){
         $('.Epay').show();
         $('.Cheque').hide();
         }
         
         else if(test3==2){
	         $('.Cheque').show();
	         $('.Epay').hide();
        	 }
         }
           
            
             
           function setAction(action){
           	// alert(action);
           	 document.getElementById("userAction").value = action;
           }
            
           
            
       		function deleteEntry(id){
       		 var cnf =confirm("Do you really want to delete this entry?.");
	       		 if(cnf == true){
	       			 $.ajax({
	 	                type: "get",
	 	          		url: "delete-dBookEntry.do",
	 	          		cache: false,
	 	          		data: {"daybookId":id},
	 	                dataType: "json",
	 	                success: function(data) {
	 	                	location.reload();
	 	                }
	 	            }); 
	       		 }
       		}
       		function setPyType(pyType){
       			 document.getElementById("paymentType").value = pyType;
       		}
			function setTrType(trType){
				 document.getElementById("transactionType").value = trType;
       		}
			function setSelectedDate(obj){
				//alert(obj.value)
				document.location.href = "daybook.do?dt="+encodeURIComponent(obj.value);
				
			}
			setPyType('1');
			setTrType('2')
           
      </script>
   </body>
</html>