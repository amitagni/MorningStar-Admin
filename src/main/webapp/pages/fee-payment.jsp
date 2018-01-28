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
      <title>Payment</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
       <link rel="stylesheet" href="css/materialize.min.css">
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
   <body class="dashboard-body">
      <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
               <li ><a href="javascript:void();">Enrollment</a>
               </li>
               <li ><a href="javascript:void();">Fee Details</a>
               </li>
               <li class="active_list"><a href="javascript:void();">Payment</a>
               </li>
               <li><a href="javascript:void();">Receipt</a>
               </li>
            </ul>
         </div>
      </div>
      </div>
      <div class="containe-pay">
         <div class="col s12 offset-s1 valign">
            <div class="card-panel card-main">
               <div class="row">
                  <form:form class="formValidate" modelAttribute="paymentFormBean" method="post" action="fee-payment.do" novalidate="novalidate">
                  <form:hidden path="feeSlipIds"/>
                   <form:hidden path="studentId"/>
                    <form:hidden path="feeSummaryId"/>
                    <form:hidden path="monthIds"/>
                     <form:hidden path="quarterlyIds"/>
                      <form:hidden path="halsyrlyIds"/>
                       <form:hidden path="anuallyIds"/>
                       <form:hidden path="disAmount"/>
                     <div class="col s4">
                        <h4 class="header2">Payment Details</h4>
                        <div class="input-field ">
                        
                        <form:input  path="amount" type="text" readonly="true" style="
    margin-bottom: 0px;
" />
                        <div class="errorTxt1"></div>
                     </div>
                        <div class="input-field">
                           <div class="errorTxt6"></div>
                        </div>
                     </div>
					 </div>
                     <c:if test="${paymentFormBean.isAddDiscount}">
					 <div class="row">
	                     <div class="col s4">
	                        <div class="input-field ">
	                        
	                        <form:input  path="addDiscountAmt" type="text" placeholder="Discount"  onkeypress="return onlyNumbers(event,this);" />
	                        <div class="errorTxt1"></div>
	                     </div>
	                        <div class="input-field">
	                           <div class="errorTxt6"></div>
	                        </div>
	                     </div>
						 </div>
                     <div class="row">
	                     <div class="col s4">
						 <label>Discount Select</label>
	                       	<form:select class="error browser-default" path="addDiscountId"  >
	                       		 	<option value="-1">----------Discount Type-------------</option>
	                                <form:options items="${paymentFormBean.addtionalDiscountTypeList}" itemValue="id"  itemLabel="abbriviation"  />
	                         </form:select>
	                     </div>
						 </div>
                     </c:if>
                     <div class="col s12">
                        <h5 class="header2">Select Payment option</h5>

                      <!--   <p class="text-center text-light"><i>in case of DD only Following section will appear</i></p>
                     
                        -->
                        <div class="col s3"> <form:radiobutton path="paymentType" id="cash" data-error=".errorTxt8" value ="1" onclick = "showOption(1,this)"/>
                                            <label for="cash">Cash</label></div>
                        <div class="col s3"> <form:radiobutton path="paymentType" id="Cheque/dd" data-error=".errorTxt8" value ="2" onclick = "showOption(2,this)"/>
                                            <label for="Cheque/dd">Cheque/DD</label></div>
                        <div class="col s3"> <form:radiobutton path="paymentType" id="bdeposite"  data-error=".errorTxt8" value ="3" onclick = "showOption(3,this)"/>
                                            <label for="bdeposite">Bank Deposite</label></div>
                       <%--  <div class="col s3"> <form:radiobutton path="paymentType" id="d/bcard"  data-error=".errorTxt8" onclick = "showOption(4,this)"/>
                                            <label for="d/bcard">Debit/Credit Card</label></div> --%>
                     </div>
                     <div id="chkdd" style="display: none">
	                     <div class="input-field col s4">
	                        <label for="dd" class="">Cheque/DD No</label>
	                        <form:input path="" type="text" required="required"/>
	                        <div class="errorTxt1"></div>
	                     </div>
	                     <div class="input-field col s4">
	                        <label for="address1" class="">Bank Name</label>
	                        <form:input path="" type="text" required="required"/>
	                        <div class="errorTxt1"></div>
	                     </div>
	                     <div class="input-field col s4">
	                        <label for="address1" class="">Date Issued</label>
	                          <form:input path="issueDate" type="text" class="datepicker" required="required"/>
	                        <div class="errorTxt1"></div>
	                     </div>
	                 </div>
                     
                      <div id="bdep" style="display: none">
		                     <div class="input-field col s4">
		                        <label for="address1" class="">Challan Number</label>
		                        <form:input path="" type="text" required="required"/>
		                        <div class="errorTxt1"></div>
		                     </div>
		                     <div class="input-field col s4">
		                        <label for="address1" class="">Deposit By</label>
		                        <input id="fname" name="addresss1" type="text" required="required">
		                        <div class="errorTxt1"></div>
		                     </div>
		                     <div class="input-field col s4 ">
		                        <label for="address1" class="">Deposit Date</label>
		                          <form:input path="depositDate" type="text" class="datepicker" required="required"/>
		                        <div class="errorTxt1"></div>
		                     </div>
                     </div>
                     <div class="input-field col s4 m4">
          <form:textarea  path ="comment" class="materialize-textarea" style="
    width: 270px;
" />
          <label for="comment">Comment</label>
        </div>
                      <div class="input-field col s12 m12 center-align button-margin">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="button" name="action" onclick = "submitForm('paymentFormBean')">Submit
                          			<img src="img/save.png" class="button-img">
                          		 </button>
                          		 <button class="btn waves-effect waves-light" type="button" onclick="gotoback();" >Back
                           			<img src="img/cancel.png" class="button-img">
                           		</button>
                       </div>
                          
                    <!--  <div class="input-field col s12 center-align button-margin">
                        <button class="btn waves-effect waves-light  submit left" onclick = "submitForm('paymentFormBean')">Save For Letter
                        <i class="mdi-content-save right"></i>
                        </button>
                        <button class="btn waves-effect waves-light  submit center-btn" onclick = "submitForm('paymentFormBean')">Submit
                        <i class="mdi-content-send right"></i>
                        </button>
                        <button class="btn waves-effect waves-light right submit" type="submit" name="action">Cancel
                        <i class="mdi-navigation-close right"></i>
                        </button>
                     </div> -->
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <!--materialize js-->
     <script src="js/materialize.min.js"></script>
      <script src="js/jquery.validate.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
      <script type="text/javascript">
         $('.datepicker').pickadate({
             selectMonths: true, // Creates a dropdown to control month
             selectYears: 15 // Creates a dropdown of 15 years to control year
         });
         $(document).ready(function() {
             // Basic
             
             $('select').material_select();
             // Translated
          
         
         });
         function showOption(type,obj){
        	 //alert(obj.value)
        	 if(obj.value == 1){
        		 document.getElementById("chkdd").style.display = "none";
        		 document.getElementById("bdep").style.display = "none";
        	 }else if(obj.value == 2){
        		 document.getElementById("chkdd").style.display = "block";
        		 document.getElementById("bdep").style.display = "none";
        	 }else if(obj.value == 3){
        		 document.getElementById("chkdd").style.display = "none";
        		 document.getElementById("bdep").style.display = "block";
        	 }
         }
         
         function submitForm(formId){
        	 var value =  document.forms[formId]["addDiscountAmt"].value;
        	// alert("val::"+value);
        	 if(value.trim()!=""){
        		 var isnum = /^\d+$/.test(value);
        		 if(isnum){
        			var discountType =  document.forms[formId]["addDiscountId"].value;
        			if(discountType == -1){
        				alert("Please select discount type");
        				return;
        			}
        		 }else{
        			 alert("Incorrect discount value.")
        			 return;
        		 }
        		 //alert("isnum::"+isnum);
        	 }
       		 $("#"+formId).submit();
       	}
         $.validator.setDefaults({
      	    errorClass: 'invalid',
      	    validClass: "valid",
      	    errorPlacement: function (error, element) {
      	        $(element)
      	            .closest("form")
      	            .find("label[for='" + element.attr("id") + "']")
      	            .attr('data-error', error.text());
      	    },
      	   	 submitHandler: function (form) {
      	      console.log('form ok');
      	    form.submit();
      	       
      	    }
      	});

      	$(".formValidate").validate({
      	    rules: {
      	        dateField: {
      	            date: true
      	        }
      	    }
      	
      	});
      	
      	function gotoback(){
      		var studentId = document.getElementById("studentId").value;
      		document.location.href = "/admin/fee.do?id="+studentId;
      	}
      	
      	function onlyNumbers(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                console.log("charcode::"+ charCode)
                if ((charCode > 47 && charCode < 58) || charCode == 37)
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
        }
      </script>
   </body>
</html>