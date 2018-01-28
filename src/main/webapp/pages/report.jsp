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
      <title>Report</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css" />
      <!-- <link href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" rel="Stylesheet"> -->
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
         .tabs .tab a:hover {
         color: #000000 !important;
         }
         .tabs .indicator {
         position: absolute !important;
         bottom: 0 !important;
         height: 2px !important;
         background-color: #0b5a92 !important;
         will-change: left, right !important;
         }
         .tabs .tab a {
         color: #0b5a92 !important;
         display: block !important;
         width: 100% !important;
         height: 100% !important;
         text-overflow: ellipsis !important;
         overflow: hidden !important;
         -webkit-transition: color .28s ease !important;
         -moz-transition: color .28s ease !important;
         -o-transition: color .28s ease !important;
         -ms-transition: color .28s ease !important;
         transition: color .28s ease !important;
         }
         td, th {
         padding: 15px 5px !important;
         display: table-cell !important;
         text-align: left !important;
         vertical-align: middle !important;
         border-radius: 2px !important;
         border: 1px solid #f5f2f0 !important;
         }
         .card-header {
         padding: .75rem 1.25rem;
         margin-bottom: 0;
         background-color: #f7f7f9;
         border-bottom: 1px solid rgba(0,0,0,.125);
         }
         .card-block {
         -webkit-box-flex: 1;
         -webkit-flex: 1 1 auto;
         -ms-flex: 1 1 auto;
         flex: 1 1 auto;
         padding: 1.25rem;
         }
         .card {
         position: relative;
         display: -webkit-box;
         display: -webkit-flex;
         display: -ms-flexbox;
         display: flex;
         -webkit-box-orient: vertical;
         -webkit-box-direction: normal;
         -webkit-flex-direction: column;
         -ms-flex-direction: column;
         flex-direction: column;
         background-color: #fff;
         border: 1px solid rgba(0,0,0,.125);
         border-radius: .25rem;
         }
         #Individual>tbody>tr>td{
         border: none;
         }
         #Individual{
         /* border: 1px solid #f5f2f0; */
         }
         /*.Epay{
         display: none;
         }
         */      
         .ui-corner-all, .ui-corner-bottom, .ui-corner-right, .ui-corner-br {
    border: 4px !important;
}



      </style>
      <link href="css/jquery-ui.css" rel="Stylesheet">
      <script type="text/javascript">
      var showSummary = false;
      var pageNumberArr =  new Array();
      </script>
   <body class="dashboard-body">
      <%@ include file="../includes/header.jsp"%>
      <form:form modelAttribute="reportBean"  action="report.do" method="post" novalidate="novalidate" >
         <form:hidden path="reportType"/>
         <form:hidden path="studentId" />
         <form:input type="text" path="pageNumber" />
         <div class="container_b">
            <div class="valign-wrapper row ">
               <div class="col s12 valign">
                  <div class="card-panel search-c">
                     <div class="row">
                        <div class="row">
                           <div class="col s12 m8">
                              <ul class="tabs">
                                 <li class="tab col s3"><a href="javascript:setReportType('1')" >Individual Student</a></li>
                                 <li class="tab col s3"><a class="active" href="javascript:setReportType('2')"  >Class Wise </a></li>
                              </ul>
                           </div>
                        </div>
                           <div id="Individual" class="col s12 m12">
                              <div class="card" id="indiv" style="display:none">
                                 <div class="card-header">
                                    Individual Student Wise
                                 </div>
                                 <div class="card-block">
                                    <div class="row" id="batch1">
                                      <div class="col s3 m3 input-field" style="margin-left: 42px;">
                                          <i class="material-icons prefix" style="top: 11px;"> search</i>
                                          <input type="text" id="autocomplete-input" class="autocomplete ui-autocomplete-input" ><span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                                          <label for="autocomplete-input" class="">Search Account</label>
                                       </div> 
                                       
							       </div>
							  	 </div>
							  	   <div class="row">
							  	   <div class="col m12">
                                     <c:if test="${not empty reportBean.studentDtoList}">
                                       <table id="Individual" class="responsive-table">
                                        <c:forEach items="${reportBean.studentDtoList}" var="report" varStatus="status">
                                          <tbody>
                                          
                                             <tr>
                                                <td class="right-align" width="20%">
                                                   <h6><b>Name Of Student : </b></h6>
                                                </td>
                                                <td width="30%" class="text-center">
                                                   <h6>${report.studentName}</h6>
                                                </td>
                                                <td >
                                                  <h6><b> Name Of Parents : </b></h6>
                                                </td>
                                                <td>
                                                   <h6>${report.studentFatherName}</h6>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="right-align" >
                                                   <h6><b> Class : </b></h6>
                                                </td>
                                                <td  class="text-center">
                                                   <h6>${report.studentClass} &nbsp;${report.section}</h6>
                                                </td>
                                                <td >
                                                   <h6><b>Contact No : </b></h6>
                                                </td>
                                                <td>
                                                   <h6>${report.phone}</h6>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="right-align" >
                                                  <h6><b>Monthly : </b></h6>
                                                </td>
                                                <td  class="text-center">
                                                   <h6>${report.monthlyPaid}</h6>
                                                </td>
                                                <td >
                                                  <h6><b> Quarterly : </b></h6>
                                                </td>
                                                <td>
                                                   <h6>${report.quterlyPaid}</h6>
                                                </td>
                                             </tr>
                                              <tr>
                                                <td class="right-align" >
                                                   <h6><b>Half Yearly : </b></h6>
                                                </td>
                                                <td  class="text-center">
                                                   <h6>${report.halfyearlyPaid}</h6>
                                                </td>
                                                <td >
                                                   <h6><b>Anually : </b></h6>
                                                </td>
                                                <td>
                                                   <h6>${report.anuallyPaid}</h6>
                                                </td>
                                             </tr>
                                             <tr>
                                                <td class="right-align" >
                                                   <h6><b>Discount : </b></h6>
                                                </td>
                                                <td  class="text-center">
                                                   <h6>${report.discAmount}</h6>
                                                </td>
                                                <td >
                                                  <h6><b> Total Paid Amount : </b></h6>
                                                </td>
                                                <td>
                                                   <h6>${report.paidAmount} </h6>
                                                </td>
                                             </tr>
                                          </tbody>
                                          </c:forEach>
                                       </table>
                                       </c:if>
                                       </div>
                                    </div>
							  </div>
							</div>
							   <div id="ClassWise" class="col s12 m12">
	                              <div class="card" id="classws" style="display:none">
	                                 <div class="card-header">
	                                    Class Wise
	                                 </div>
	                                 <div class="card-block">
	                                     <div class="row" id="batch1">
			                                 <div class="col s3 m3">
			                                    <label>Select Class</label>
			                                    <form:select class="error browser-default" path="selClass"  >
			                                       <option id="crole0" value="-1">All</option>
			                                       <form:options items="${reportBean.studentClassList}" itemValue="code" id="crole" itemLabel="name"  />
			                                    </form:select>
			                                 </div>
	                                 
			                                 <div class="col s3 m3"  style="line-height: 5.6;" >
			                                    <a class="waves-effect waves-light btn" onclick="submitForm()" >Go</a>
			                                 </div>
			                                 <div id="sum1" style="display:none"> 
			                                 	<span style="color:green"><b>Total Fee Collected :</b>${reportBean.totalPaidAmount}</span> &nbsp;| &nbsp;<span style="color:red"><b> Total Discount Given :</b>${reportBean.totalDiscAmount}</span>
	                            		     </div>
	                            		      <div id="sum2"  style="display:none" > 
			                               	   <span style="color:green"><b>Students Paid :</b>${reportBean.totalPaidStudent}</span> &nbsp;| &nbsp;<span style="color:red"><b> Students Not Paid  :</b>${reportBean.totalNotPaidStudent}</span>
	                            		     </div>
	                            		      <div id="sum3"  style="display:none" >
	                            		      <b>Total Records : ${reportBean.recordCount} </b>&nbsp;&nbsp;&nbsp;
				                               	   <span style="color:green">
				                               	   		<b><a href="javascript:setPrevious();"> << </a>
				                               	   		<span id="pagesnum">
				                               	   		 <script type="text/javascript">
					                               	   		<%-- <c:forEach var="i" begin="1" end="${reportBean.totalPages}" >
					                               	   			<a href="javascript:setPageNumber(${i})">${i }</a>
					                               	   			
					                               	   			
					                               	   		         pageNumberArr[pageNumberArr.length] = ${i};
																 
					                               	   		</c:forEach> --%>
					                               	   	 </script>
				                               	   		</span>
				                               	   		<a href="javascript:setNext();"> >> </a></b>
				                               	   	</span>
	                            		     </div>
	                            		    
								  	 </div>
								  	     <div class="row">
	                                 <div class="col s12 m12">
	                                  <c:if test="${not empty reportBean.studentDtoList}">
		                                    <table class="bordered"  id="example" style="table-layout: fixed; width: 100%">
		                                       <thead>
		                                          <tr>
		                                             <th width="50px">S.No</th>
		                                             <th>Student Name</th>
		                                             <th>Father's Name</th>
		                                             <th>Class</th>
		                                             <th width="150px">Monthly</th>
		                                             <th width="150px">Exam Fees</th>
		                                             <th>Annual function fee</th>
		                                             <th>TC/Misc/Pract   </th>
		                                             <th>Discount</th>
		                                             <th>Total Paid  </th>
		                                          </tr>
		                                       </thead>
		                                      
		                                          <c:forEach items="${reportBean.studentDtoList}" var="report" varStatus="status">
		                                          	 <script type="text/javascript">
												       showSummary = true;
												      </script>
		                                          		<c:choose>
			                                               	<c:when test="${report.notPaid }">
			                                               		<tr style="color:red">
					                                                <td >${status.index +1}</td>
					                                                <td width="15%">${report.studentName}</td>
					                                                <td width="15%">${report.studentFatherName}</td>
					                                                <td width="8%">${report.studentClass} &nbsp;${report.section}</td>
					                                               
					                                                <td width="62%" colspan="6" align="right" >
					                                                	 --------------------------------------------------------------------------Not Paid--------------------------------------------------------------------------------------
					                                                </td>
					                                                
					                                                
					                                             </tr>
			                                               	</c:when>
			                                               	<c:otherwise>
			                                               	<tr>
				                                                <td >${status.index +1}</td>
				                                                <td width="15%">${report.studentName}</td>
				                                                <td width="15%">${report.studentFatherName}</td>
				                                                <td width="8%">${report.studentClass} &nbsp;${report.section}</td>
				                                               
				                                                <td style="word-wrap: break-word">${report.monthlyPaid}</td>
				                                                <td style="word-wrap: break-word">${report.quterlyPaid}</td>
				                                                <td width="6%">${report.halfyearlyPaid}</td>
				                                                <td width="6%">${report.anuallyPaid}</td>
				                                                
				                                                <td width="6%">${report.discAmount}</td>
				                                                <td width="6%">${report.paidAmount}</td>
				                                             </tr>
			                                               	</c:otherwise>
			                                             </c:choose>
		                                          
		                                          
		                                             
		                                          </c:forEach>
		                                    </table>
	                                     </c:if>
	                                 </div>
	                              </div>
								</div>
						 </div>
					 </div>
				 </div>
            </div>
          </div>
       </div>
     
 
       
</form:form>
      
      
 <!--     <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script> -->
 
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.2/js/materialize.min.js"></script>
 <script type="text/javascript" src="js/dropify.min.js"></script>
 <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script> 
     <script type="text/javascript">
         function setReportType(reportType){
        	if(reportType == 1){
        		document.getElementById("indiv").style.display = "block";
        		document.getElementById("classws").style.display = "none";
        	}else{
        		document.getElementById("indiv").style.display = "none";
        		document.getElementById("classws").style.display = "block";
        	}
          document.getElementById("reportType").value =  reportType;
         }
         

         $('.datepicker').pickadate({
             selectMonths: true, // Creates a dropdown to control month
             selectYears: 15 // Creates a dropdown of 15 years to control year
         });
         $(document).ready(function() {
             // Basic
             $('.dropify').dropify();
             
             if(showSummary){
            		document.getElementById("sum1").style.display = "block";
            		document.getElementById("sum2").style.display = "block";
            		//document.getElementById("sum3").style.display = "block";
             }
         
         });
        
          $(document).ready(function() {
        	$('select').material_select();
         
            var fakedata = ['test1','test2','test3','test4','ietsanders'];
			$("input.autocomplete").autocomplete({source:function(request, response) {
	            $.ajax({
	                type: "get",
	          		url: "fetch-studentlist.do",
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
	               var id = ui.item.value;
	               document.getElementById("studentId").value = id;
	               submitForm();
	           	return false;
	          }, 
	        min_length: 3,
			autoFocus: true,
			cacheLength: 1,
			scroll: true,
			highlight: false,
	        delay: 300});
         });
            
             var fakedata = ['test1','test2','test3','test4','ietsanders'];
        /* 	 $(".autocomplete").autocomplete({source:function(request, response) {
                $.ajax({
                    type: "get",
              		url: "fetch-studentlist.do",
              		cache: false,
              		data: {"studentName":request.term},
                    dataType: "json",
                    success: function(data) {
                    	console.log(data)
                        response(data);
                    }
                });
            },
            select: function( event, ui ) {
               console.log(ui.item.value)
               this.value = ui.item.label;
               var id = ui.item.value;
               document.getElementById("studentId").value = id;
               submitForm();
           		 return false;
              }, 
            min_length: 3,
         autoFocus: true,
         cacheLength: 1,
         scroll: true,
         highlight: false,
            delay: 300});
            }); */
           
             function submitForm(){
           	  $("#reportBean").submit();
             }
	         var reportType = document.getElementById("reportType").value ;  
	         if(reportType == 1){
	     		document.getElementById("indiv").style.display = "block";
	     		document.getElementById("classws").style.display = "none";
	     	}else{
	     		document.getElementById("indiv").style.display = "none";
	     		document.getElementById("classws").style.display = "block";
	     	}
	         
	        /*  var startCtr = 1;
             var pageCount = ${reportBean.totalPages};
             var recordPerPage = 10;
	         
	        function setPageNumber(pageNumber){
	        	alert(pageNumber)
	        	document.getElementById("pageNumber").value = pageNumber;
	        	
	        }
	        function showPages(){
	        	var str = "";
	        	for(var i=startCtr;i<(startCtr+10);i++){
	        		str = str +'<a href="javascript:setPageNumber('+i+')">'+i+'</a>&nbsp;&nbsp;';
	        	}
	        	document.getElementById("pagesnum").innerHTML = str;
	        }
	        function setPrevious(){
	        	if(startCtr > 1){
	        		startCtr--;
	        		showPages();
	        	}
	        }
			function setNext(){
				if((startCtr +recordPerPage) <= pageCount){
					 startCtr++;
					 showPages();
				}
	        }
			
			showPages(); */
	        console.log(pageNumberArr+"::"+pageCount);
      </script>
      <!--materialize js-->
   </body>
</html>