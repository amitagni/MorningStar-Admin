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
      <title>Registration Form</title>
     
   <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
   <link rel="stylesheet" type="text/css" href="css/style.css">
   <link rel="shortcut icon" type="image/png" href="img/login.png" />
   <link rel="stylesheet" href="css/materialize.min.css">
   <body class="dashboard-body">
     
     <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         <div class="col s12 m12 card-margin card-panel valign">
            <ul class="breadcrumb">
            <li class="active_list"><a href="javascript:void();">Registration</a>
               </li>
               <li ><a href="javascript:void();">Payment</a>
               </li>
               <li><a href="javascript:void();">Receipt</a>
               </li>
            </ul>
         </div>
      </div>
      </div>
      <div class="row_form valign-wrapper">
         <div class="col s12 offset-s1 valign">
            <div class="card-panel card-main">
               <h4 class="header2">Student Details</h4>
               <div class="row">
                  <form:form  modelAttribute="registrationFormBean"  action="registration.do" method="post"   class="formValidate" novalidate="novalidate">
                     <div class="row">
                        
                           <div class="input-field col s12 m3">
                              <label for="fname" class="">Form No</label>
                              <form:input path="formNum" id="fname" type="number"  class="paste" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="lname" class="">Date of Issue</label>
                              <form:input path="dateOfIssue" id="lname" class="datepicker" />
                              <div class="errorTxt2"></div>
                           </div>
                          <%--  <div class="input-field col s12 m3">
                              <label for="regnno" class="">Registration No.</label>
                              <form:input path="regNum"  type="text"  id="regnno" />
                              <div class="errorTxt2"></div>
                           </div> --%>
                           <div class="input-field col s12 m3">
                              <label for="sfn" class=""> Student First Name</label>
                              <form:input path="studentDetails.firstName" id="sfn" type="text" onkeypress="return onlyAlphabets(event,this);" class="validate" required="required"  />
                              <div class="errorTxt3"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="sln" class="">Student Last Name</label>
                              <form:input path="studentDetails.lastName" id="sln"  type="text" onkeypress="return onlyAlphabets(event,this);" required="required" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="dob" class="">Date of Birth</label>
                              <form:input path="studentDetails.dob" id="dob" class="datepicker" />
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="ffname" class="">Father’s Name</label>
                              <form:input path="studentDetails.fatherName" id="ffname" onkeypress="return onlyAlphabets(event,this);" type="text" required="required"/>
                              <div class="errorTxt2"></div>
                           </div>
                           <div class="input-field col s12 m3">
                              <label for="mn" class="">Mother’s Name</label>
                              <form:input path="studentDetails.motherName" id="mn" onkeypress="return onlyAlphabets(event,this);" type="text" required="required"/>
                              <div class="errorTxt2"></div>
                           </div>
                           
                           <div class="input-field col s12 m3">
                              <label for=lastSchool class="">Last School Attended</label>
                              <form:input path="lastSchool" id="lastSchool" type="text" />
                              <div class="errorTxt1"></div>
                           </div>
                           <div class="col s12 m3">
                              <%-- <label for="lastClass" class="">Last Class Attended</label>
                              <form:input path="lastClass" type="text" id="lastClass"/>
                              <div class="errorTxt1"></div> --%>
                              <label for="lastClass">Last Class Attended</label>
                          <form:select class="error browser-default" path="lastClass" id="lastClass" >
                                <form:options items="${registrationFormBean.studentClassList}" itemValue="code" id="crole" itemLabel="name"  />
                          </form:select>
                           </div>
                           <div class=" col s12 m3">
                              <%-- <label for="lastClassResult" class="">Result of the last class</label>
                              <form:input path="lastClassResult" id="lastClassResult" type="text" />
                              <div class="errorTxt1"></div> --%>
                              <label for="lastClassResult">Result of the last class *</label>
                          <form:select class="error browser-default" path="lastClassResult" id="lastClassResult"  selected="1" name="crole">
                              
                              <option value="1">Pass</option>
                              <option value="2">Fail</option>
                              <option value="3">Awaited</option>
                           </form:select>
                           </div>
                           <%-- <div class="input-field col s12 m3">
                              <label for="lastSchooln" class="">Name Of Institution (Last Attended)</label>
                              <form:input path="lastSchool" type="text" id="lastSchooln"/>
                              <div class="errorTxt1"></div>
                           </div> --%>
                           <div class="col s12 m3">
                              <label for="category">Category *</label>
                              <form:select class="error browser-default" path="studentDetails.category" id="category">
                                <form:options items="${registrationFormBean.categoryList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                           </div>
                           <div class="col s12 m3 radioRequired">
                              <label for="genter_select">Gender *</label>
                              <p>
                              	 <form:radiobutton path="studentDetails.gender" id="gender_male" name="m"  value="M" />
                                 <label for="gender_male">Male</label>
                              </p>
                              <p>
                                 <form:radiobutton path="studentDetails.gender" id="gender_female" name="m" value="F"  />
                                 <label for="gender_female">Female</label>
                              </p>
                              
                           </div>
                        
                        <div class="col s12 m3">
                              <label for="crole">Class to which Admission is sought*</label>
                              <form:select class="error browser-default" path="studentDetails.studentAdmissionClass" onchange="showhideSubjectList(this);">
                                <form:options items="${registrationFormBean.studentClassList}" itemValue="code" id="crole" itemLabel="name"  />
                              </form:select>
                              <div class="errorTxt2"></div>
                           </div>
                           
                          
                           <div class="col s12 m3" id="subjectDiv" style="display:block;">
                            	 <label for="subjects">Subject Offered</label> 
	                              <form:select multiple="multiple" path="studentDetails.subjects" id="subjects">
	                                 <option value="" disabled selected> Choose Subject</option>
	                                 <option value="1">Science</option>
	                                 <option value="2">Math's</option>
	                                 <option value="3">Biology</option>
	                              </form:select>
                             
                           </div>
                           
                        <div class="col s12">
                           <h4 class="header2">Contact Details</h4>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line1</label>
                           <form:input path="contactDetails.address1" id="address1" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address2" class="">Address Line2</label>
                           <form:input path="contactDetails.address2" id="address2"  type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="area" class="">Area/Locality/Landmark</label>
                           <form:input path="contactDetails.area" id="area" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="city" class="">City</label>
                           <form:input path="contactDetails.city" id="city" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="crole">States *</label>
                           <form:select class="error browser-default" path="contactDetails.state" id="crole" required="required" >
                               <form:options items="${registrationFormBean.stateList}" itemValue="code"  itemLabel="name"  />
                           </form:select>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="pin" class="">Pin Code</label>
                           <form:input path="contactDetails.pincode" id="pin" type="number" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="phone" class="">Father's Mobile No.</label>
                           <form:input path="contactDetails.phone" id="phone"  type="number" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="mb" class="">Mother's Mobile No.</label>
                           <form:input path="contactDetails.mobile" id="mb" type="number"  />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="email" class="">Email</label>
                           <form:input path="contactDetails.email" id="email"  type="email" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                       
                         <div class="input-field col s12 m12 center-align button-margin">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action" onclick = "submitForm('registrationFormBean')" >Submit
                          			<img src="img/save.png" class="button-img">
                          		 </button>
                          		 <a class="btn waves-effect waves-light  submit reset" type="submit" name="action">Reset
                           			<img src="img/cancel.png" class="button-img">
                           		</a>
                          </div>
                        
                     <!--    <div class="input-field col s12 center-align button-margin">
                           <button class="btn waves-effect waves-light  submit left" onclick = "submitForm('registrationFormBean')" >Save For Letter
                           <i class="mdi-content-save right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit center-btn" onclick = "submitForm('registrationFormBean')" >Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light right submit" onclick = "" >Cancel
                           <i class="mdi-navigation-close right"></i>
                           </button>
                        </div> -->
                     </div>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      </div>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      <script src="js/jquery.validate.min.js"></script>
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
         
          $(document).ready(function() {
         $('select').material_select();
         });
          
         function submitForm(formId){
       		 $("#"+formId).submit();
       	}
         $('.paste').bind("cut copy paste",function(e) {
             e.preventDefault();
         });
         function onlyAlphabets(e, t) {
             try {
                 if (window.event) {
                     var charCode = window.event.keyCode;
                 }
                 else if (e) {
                     var charCode = e.which;
                 }
                 else { return true; }
                 if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123) || charCode == 32)
                     return true;
                 else
                     return false;
             }
             catch (err) {
                 alert(err.Description);
             }
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
        	$('input[type=text], textarea,input[type=number], textarea,input[type=email]').bind("cut copy paste",function(e) {
                e.preventDefault();
            });
        	 $(".reset").click(function() {
                 $(this).closest('form').find("input[type=text], textarea,input[type=number], textarea,input[type=email]").val("");
             });
        	 
        	 function showhideSubjectList(obj){
        		 if(obj.value == 14){
        			 $("#subjectDiv").removeAttr("style").show(); 
        		 }else{
        			 $("#subjectDiv").removeAttr("style").hide(); 
        		 }
        	 }
        	
      </script>
      <!--materialize js-->
   </body>
</html>