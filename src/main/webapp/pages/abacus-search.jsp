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
      <title>Search Page</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css">
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
#multiple>div>ul {
    max-height: 200px !important;
    overflow-y: auto !important;
    top: 0px !important;
}      </style>
   <body class="dashboard-body">
   	 <%@ include file="../includes/header.jsp"%>
	<div class="container_b">
	      <div class="valign-wrapper row row_form">
	         <div class="col s12 m12 card-margin card-panel valign" style="
    width: 98%;
    margin-left: 11px;
">
	            <ul class="breadcrumb">
	               <li ><a href="javascript:void();">Enrollment</a>
	               </li>
	               <li class="active_list"><a href="javascript:void();">Fee Details</a>
	               </li>
	               <li><a href="javascript:void();">Receipt</a>
	               </li>
	            </ul>
	         </div>
      	</div>
      </div>
     <div class="container_b serach-top">
      <div class="valign-wrapper row ">
         <div class="col s12 valign">
         
	         
      
            <div class="card-panel search-c">
               <!-- <h4 class="header2">Search</h4> -->
               <div class="row">
                 <form:form modelAttribute="abacusSearchBean"  action="abacus-fee.do" method="post" novalidate="novalidate" >
					<form:hidden path="id" />
					<form:hidden path="regFee" />
					<form:hidden path="name" />
                    <div class="col s12 m12 l12">
                        <div class="col s12 m4 input-field" style="margin-left: 50px;">
          <img src="img/search.png" class="serach-img">
          <input type="text" id="autocomplete-input" class="autocomplete">
          <label for="autocomplete-input">Search Student</label>
        </div>
                           
                           <div class="col s12 m12" id="stDetails" >
                              
                                 <div class="col s12 m6">
                                    <h4> Student Details</h4>
                                 	   <div class=" col s12 m6">
                                           <p>UID</p>
                                           <p>Name</p>
                                          
                                           <p>Father's Name </p>
                                       </div>
                                       <div class=" col s12 m6">
                                          <p id="uid">${abacusSearchBean.id}</p>
                                          <p id="stname">${abacusSearchBean.name}</p>
                                          <p id="fname">${abacusSearchBean.fatherName}</p>
                                       </div>
                                    
                                 </div>
                                   
                                 <div class="col s12 m3" id="multiple">
                                 <label >Select Months</label>
		            				<%--  <form:select class="error browser-default" path="selMonth" multiple="multiple" >
		                             <form:options items="${feeFormBean.monthList}" itemValue="code" id="month" itemLabel="name"  />
		                           </form:select> --%>
		                           
		                           <form:select  path="selMonth" multiple="multiple">
		                           	 <!-- <option value="-1">Select Months</option> -->
		                           	 <c:forEach items="${abacusSearchBean.monthList}" var="feeMonthDto" varStatus="status">
		                           		 <c:choose>
				                         	<c:when test="${feeMonthDto.paid}">
		                           	 			 <option value="${feeMonthDto.code }" disabled selected>${feeMonthDto.name }</option>
		                           	 		</c:when>
				                         	<c:otherwise>
				                         	    <option value="${feeMonthDto.code }">${feeMonthDto.name }</option>
				                         	</c:otherwise>
				                         </c:choose>
		                           	 </c:forEach>
		                            <%--  <form:options items="${feeFormBean.monthList}" itemValue="code" id="month" itemLabel="name"  /> --%>
		                           </form:select> 
		                         
                        	  </div>
                        	  <c:if test="${abacusSearchBean.regFee == 1 }">
	                        	  <div class="input-field col s6">
		          					<form:input path="regAmt" placeholder="Reg Fee" type="number"  class="validate"   />
		          					<label for="Registration_Fee">Registration Fee</label>
	        			 		  </div>
        			 		  </c:if>
                              <div class="input-field col s6">
	          					<form:input path="monthlyAmt" placeholder="Amount" type="number"  class="validate" readonly="true" />
	          					<label for="Fee">Monthly Fee</label>
        			 		 </div>
        			 		 <%-- <div class="input-field col s6">
	          					<form:input path="totalAmt" placeholder="Amount" type="number"  class="validate" readonly="true" />
	          					<label for="Total_Fee">Total Fee</label>
        			 		 </div> --%>
       				 		<div class="input-field col s12 m12 center-align button-margin" style="
    margin: 10px 0px 20px 0px;
">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="button" name="action" onclick = "submitForm('abacusSearchBean')" >Submit
                          			<img src="img/save.png" class="button-img">
                          		 </button>
                          		 <a class="btn waves-effect waves-light  submit  reset" type="submit" name="action">Reset
                           			<img src="img/cancel.png" class="button-img">
                           		</a>
                           </div>
                           </div>
                           
                    </div>
                    
       
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      </div>
     
      </div>
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
  <script type="text/javascript" src="js/dropify.min.js"></script>
  <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link>
 <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script> 
 <script type="text/javascript">
 var stId = -1;
	function openSelOption(obj){
	    	  if(stId == -1){
	    		  alert("Please Choose Student First");
	    	  }else{
	    		 // alert(obj.value);
	    		  if(obj.value == 1){
	    			  var url = "fee.do?id="+stId;
	    			  window.open(url, '_blank');
	    		  }else if(obj.value == 2){
	    			  var url = "reg-payment.do?id="+stId;
	    			  window.open(url, '_blank');
	    		  }
	    		  
	    	  }
	   }
	      
</script>
      <script type="text/javascript">
      
      	// var kitAmount = document.getElementById('totalAmt').value;
         $('.datepicker').pickadate({
             selectMonths: true, // Creates a dropdown to control month
             selectYears: 15 // Creates a dropdown of 15 years to control year
         });
         $(document).ready(function() {
             // Basic
             $('.dropify').dropify();
             
             // Translated
         
         });
        
          $(document).ready(function() {
        	$('select').material_select();
         
            var fakedata = ['test1','test2','test3','test4','ietsanders'];
			$("input.autocomplete").autocomplete({source:function(request, response) {
	            $.ajax({
	                type: "get",
	          		url: "fetch-abacus-studentlist.do",
	          		cache: false,
	          		data: {"studentName":request.term},
	                dataType: "json",
	                success: function(data) {
	                    response(data);
	                }
	            });
	        },
	        select: function( event, ui ) {
	           console.log(ui.item.value)
	           this.value = ui.item.label;
	           document.location.href = "abacus-search.do?id="+ui.item.value
	           
	 /*            $.ajax({
		                type: "get",
		          		url: "fetch-abacus-studentDetail.do",
		          		cache: false,
		          		data: {"studentId":ui.item.value},
		                dataType: "json",
		                success: function(data) {
		                    console.log(data);
		                    stId = data.id;
		                    document.getElementById('uid').innerHTML = data.id;
		                    document.getElementById('stname').innerHTML = data.name;
		                    document.getElementById('stClass').innerHTML = data.studentClass;
		                    if(data.section != null)
		                    	document.getElementById('section').innerHTML = data.section;
		                    else
		                    	document.getElementById('section').innerHTML = "N/A";
		                    if(data.house != null)
		                   	  document.getElementById('house').innerHTML = data.house;
		                    else
		                    	 document.getElementById('house').innerHTML = "N/A"; 
		                    if(data.fatherName != null)
		                    	document.getElementById('fname').innerHTML = data.fatherName;
		                    else
		                    	document.getElementById('fname').innerHTML = "N/A";
		                   // document.getElementById('stImage').src = data.photoPath;
		                }
		            }); */
		       return false;
	          }, 
	        min_length: 3,
			autoFocus: true,
			cacheLength: 1,
			scroll: true,
			highlight: false,
	        delay: 300});
         });
          
          function submitForm(formId){
        	  
        	  var id = $('#id').val();
        	  if(id == 0){
        		  alert("Please select Student First");
        	  }else{
        	  var selMonth = $('#selMonth').val();
         		if(selMonth ==  null){
         			alert("Please select Months First");
         		}else{
         		 	$("#"+formId).submit();
         		}
          }
         }
         		// $("#"+formId).submit();
   	    $('select').change(function(){
   	        var newValuesArr = [],
   	            select = $(this),
   	            ul = select.prev();
   	        ul.children('li').toArray().forEach(function (li, i) {
   	            if ($(li).hasClass('active')) {
   	                newValuesArr.push(select.children('option').toArray()[i].value);
   	            }
   	        });
   	        select.val(newValuesArr);
   	        console.log(newValuesArr)
   	        setTotalAmount(newValuesArr);
   	    });
   	    
   	/*  function updateTotalAmount(){
	        var newValuesArr = [],
	            select = $(this),
	            ul = select.prev();
	        ul.children('li').toArray().forEach(function (li, i) {
	            if ($(li).hasClass('active')) {
	                newValuesArr.push(select.children('option').toArray()[i].value);
	            }
	        });
	        select.val(newValuesArr);
	        console.log(newValuesArr)
	        setTotalAmount(newValuesArr);
	    } */
   	    
   	    function setTotalAmount(months){
   	    	var regAmt = 0;
   	    	var amt =  0;
   	    	if(document.getElementById('regAmt')!= null){
   	    		regAmt = parseInt(document.getElementById('regAmt').value);
   	    	} 
   	    	if(months.length > 0){
   	    	 amt =  parseInt(500*months.length);
   	    	}
   	    	document.getElementById('monthlyAmt').value = amt;
   	    	//document.getElementById('totalAmt').value = parseInt(regAmt) + parseInt(amt);
   	    }
   	    
   	  /*  if(document.getElementById('regAmt')!= null){
    		 document.getElementById('totalAmt').value = document.getElementById('regAmt').value;
    	}  */
    	
    	
    	$(".reset").click(function() {
            $(this).closest('form').find("input[type=text], textarea,input[type=number], textarea,input[type=email]").val("");
        });
   	 
   	 
        
      </script>
      <!--materialize js-->
   </body>
</html>