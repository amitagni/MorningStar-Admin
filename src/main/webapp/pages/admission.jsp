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
      <title>Admission</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> -->
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" href="css/materialize.min.css">
      <link href="css/jquery-ui.css" rel="Stylesheet"></link>
   	  <body class="dashboard-body">
        <%@ include file="../includes/header.jsp"%>
      <form:form  modelAttribute="admissionFormBean"  action="admission.do" method="post" enctype="multipart/form-data" class="formValidate" novalidate="novalidate">
     <form:hidden path="studentDetails.id"/>
      <form:hidden path="studentDetails.regId"/>
      <form:hidden path="contactDetails.id"/>
      <form:hidden path="studentPhotoPath"/>
      <form:hidden path="studentTcPath"/>
      <div class="container_b">
	      <div class="valign-wrapper row row_form">
	         <div class="col s12 m12 card-margin card-panel valign">
	            <ul class="breadcrumb">
	               <li class="active_list"><a href="javascript:void();">Enrollment</a>
	               </li>
	               <li ><a href="javascript:void();">Fee Details</a>
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
            <div class="row">
            <div class="col s4 m3 input-field">
               <h4 class="header2">Student Details</h4>
               </div>
               <div class="col s8 m4 input-field searchtop">
          <i class="material-icons prefix">search</i>
          <form:input type="number" path="regNum" id="autocomplete-input" class="autocomplete" onchange="getRegistrationId(this);" />
          <label for="autocomplete-input">Registration no</label>
          <span id="regId" style="color:red;display:none; text-align: -webkit-center;">Registration number not found</span>
        </div>
        
        </div>
               <div class="row">
                     <div class="row">
                        <div class="col s9 m9">
                           <div class="input-field col s12 m4">
                              <label for="fname" class="">First Name of Student*</label>
                              <form:input path="studentDetails.firstName" type="text" id="fname"  required="required" onkeypress="return onlyAlphabets(event,this);"/>
                             
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lname" class="">Last Name Student</label>
                              <form:input path="studentDetails.lastName" type="text" id="lname" onkeypress="return onlyAlphabets(event,this);"/>
                             
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="da" class="">Date of Application*</label>
                               <form:input path="applicationDate" type="text" id="da" class="datepicker" required="required" />
                              
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="mn" class="">Mother's Name*</label>
                              <form:input path="studentDetails.motherName" id="mn" type="text" required="required" onkeypress="return onlyAlphabets(event,this);"/>
                              
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="ffname" class="">Father's Name *</label>
                              <form:input path="studentDetails.fatherName" id="ffname" type="text" required="required" onkeypress="return onlyAlphabets(event,this);"/>
                            
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="fatho" class="">Father's Occupation </label>
                               <form:input path="studentDetails.fatherOccupation"  id="fatho" type="text" onkeypress="return onlyAlphabets(event,this);"/>
                             
                           </div>
                           <div class="col s12 m4">
                              <label for="classto">Class to which Admission is sought*</label>
                               <form:select  class="error browser-default" path="studentDetails.studentAdmissionClass"  id="classto">
                                <form:options items="${admissionFormBean.studentClassList}" itemValue="code"  itemLabel="name"  />
                               </form:select>
                              
                                 
                              
                           </div>
                           <div class="col s12 m4">
                              <label for="section">Section </label>
                               <form:select class="error browser-default" path="studentDetails.section" id="section">
                                <form:options items="${admissionFormBean.sectionList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                             
                           </div>
                           <div class="col s12 m4">
                          		 <label for="house">House </label>
                               <form:select class="error browser-default" path="studentDetails.house" id="house">
                                <form:options items="${admissionFormBean.houseList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                            <label></label>
                          </div>
                          
                           <div class="input-field col s12 m4">
                              <label for="dob" class="">Date Of Birth</label>
                              <form:input path="studentDetails.dob" type="text" id="dob" class="datepicker"  />
                              
                           </div>
                           <div class="input-field col s12 m4">
                              <label for=up class=""> Since how long residing Uttar Pradesh</label>
                              <form:input path="timeOfResiding" type="text" id="up" class="datepicker" />
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="lasts" class="">Last School Attended</label>
                              <form:input path="lastSchool" type="text" id="lasts"/>
                            
                           </div>
                           <%-- <div class="input-field col s12 m4">
                              <label for="nati" class="">Nationality*</label>
                               <form:input path="studentDetails.nationality" id="nati" type="text" />
                              <div class="errorTxt2"></div>
                           </div> --%>
                          <div class="col s12 m4">
                              <%-- <label for="lastClass" class="">Last Class Attended</label>
                              <form:input path="lastClass" type="text" id="lastClass"/>
                              <div class="errorTxt1"></div> --%>
                              <label for="lastClass">Last Class Attended</label>
	                          <%-- <form:select class="error browser-default" path="lastClass" id="lastClass" >
	                              <option value="" >Choose  Last Class</option>
	                              <option value="1">P.G</option>
	                              <option value="2">L.K.G</option>
	                              <option value="3">U.K.G</option>
	                              <option value="4">1st</option>
	                              <option value="5">2nd</option>
	                              <option value="6">3rd</option>
	                              <option value="7">4th</option>
	                              <option value="8">5th</option>
	                              <option value="9">6th</option>
	                              <option value="10">7th</option>
	                              <option value="11">8th</option>
	                              <option value="12">9th</option>
	                              <option value="13">10th</option>
	                              <option value="14">11th </option>
	                          </form:select> --%>
	                          
	                           <form:select class="error browser-default" path="lastClass" id="lastClass" >
                                 <form:options items="${admissionFormBean.studentClassList}" itemValue="code" id="crole" itemLabel="name"  />
                          	  </form:select>
                           </div>
                          
                           <div class=" col s12 m4">
                             <%--  <label for="resullast" class="">Result of the last class</label>
                               <form:input path="lastClassResult" id="resullast" type="text" />
                              <div class="errorTxt1"></div> --%>
                               <label for="lastClassResult">Result of the last class *</label>
		                          <form:select class="error browser-default" path="lastClassResult" id="lastClassResult"  selected="1" name="crole">
		                               <form:options items="${admissionFormBean.resultList}" itemValue="code"  itemLabel="name"  />
		                           </form:select>
                           </div>
                            <div class="col s12 m4">
                              <label for="section">Nationality </label>
                               <form:select class="error browser-default" path="studentDetails.nationality" id="section">
                                <form:options items="${admissionFormBean.nationalityList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                           </div>
                           
                            <div class="col s12 m4">
                               <label for="reli" class="">Religion</label>
                               <%--<form:input path="studentDetails.religion" id="reli" type="text" />
                              <div class="errorTxt2"></div> --%>
                              <form:select class="error browser-default" path="studentDetails.religion" id="reli" name="crole">
                               <form:options items="${admissionFormBean.religionList}" itemValue="code"  itemLabel="name"  />
                           </form:select>
                           </div>
                           <div class="col s12 m4">
                              <label for="categ">Category *</label>
                              <form:select class="error browser-default" path="studentDetails.category" id="categ">
                                <form:options items="${admissionFormBean.categoryList}" itemValue="code"  itemLabel="name"  />
                              </form:select>
                           </div>
                           <div class="input-field col s12 m4">
                              <label for="caste" class="">Caste</label>
                               <form:input path="studentDetails.caste" id="caste" type="text" onkeypress="return onlyAlphabets(event,this);"/>
                              
                           </div>
                           
                            
                           
                          
                           
                           
                           <div class="col s12 m4" style="display:none;">
                           <label>Subject Offered</label>
                               <form:select multiple="multiple" path="studentDetails.subjects" >
                                <option value="" disabled selected> choose subject</option>
                                 <option value="1">Science</option>
                                 <option value="2">Math's</option>
                                 <option value="3">Biology</option>
                              </form:select>
                              
                           </div>
                            <div class="col s12 m4 radio-add">
                              <label for="genter_select">Gender *</label>
                              <p>
                              	 <form:radiobutton path="studentDetails.gender" id="gender_male"  value="M" />
                                 <label for="gender_male">Male</label>
                              </p>
                              <p>
                                 <form:radiobutton path="studentDetails.gender" id="gender_female" value="F" />
                                 <label for="gender_female">Female</label>
                              </p>
                              <div class="input-field">
                                 <div class="errorTxt8"></div>
                              </div>
                           </div>
                            
                           
                          
                        </div>
                        <div class="col s12 m3">
                           <label for="att" class="">Attach Photo</label>
                           <div class="input-field">
                           		 <form:input type="file" path="studentPhoto"  class="dropify" data-default-file="${admissionFormBean.studentPhotoPath }"  />
                             	 <!-- <input type="file" class="dropify" data-default-file="img/u.png" /> -->
                           </div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="doc" class="">Attach Transfer/ proof of Date of Birth</label>
                           <div class="input-field">
                           		<form:input type="file" path="studentTc" class="dropify" data-default-file="${admissionFormBean.studentTcPath }"  />
                               <!--  <input type="file" class="dropify" data-default-file="img/f.png" /> -->
                           </div>
                        </div>
                        <div class="col s12">
                           <h4 class="header2">Contact Details</h4>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address1" class="">Address Line1*</label>
                            <form:input path="contactDetails.address1" id="address1" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="address2" class="">Address Line2</label>
                           <form:input path="contactDetails.address2" id="address2" type="text" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="area" class="">Area/Locality/Landmark*</label>
                            <form:input path="contactDetails.area" id="area" type="text" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="city" class="">City*</label>
                           <form:input path="contactDetails.city" type="text" id="city" required="required" onkeypress="return onlyAlphabets(event,this);"/>
                           <div class="errorTxt1"></div>
                        </div>
                        <div class=" col s12 m3">
                           <label for="state">States*</label>
                            <form:select class="error browser-default" path="contactDetails.state" id="crole" required="required" >
                                <form:options items="${admissionFormBean.stateList}" itemValue="code"  itemLabel="name"  />
                           </form:select>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="pin" class="">Pin Code *</label>
                            <form:input path="contactDetails.pincode" id="pin" type="number" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="phone" class="">Father's Mobile No.*</label>
                            <form:input path="contactDetails.phone" id="phone" type="number" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="mob" class="">Mother's Mobile No.</label>
                           <form:input path="contactDetails.mobile" id="mob" type="number" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="input-field col s12 m3">
                           <label for="email" class="">Email*</label>
                            <form:input path="contactDetails.email" id="email" type="email" required="required" />
                           <div class="errorTxt1"></div>
                        </div>
                        <div class="col s12 m4 ">
                          <%--  <p>
                              <input type="checkbox" id="transportReq" name="transportReq" value="${admissionFormBean.transportReq}" />
                              <label for="transportReq">Do you want School vehicle for 12 months</label>
                           </p> --%>
                          <%--   <p>
                              <form:radiobutton path="transportReq" />
                              <label for="transportReq1">Do you want School vehicle for 12 months</label>
                           </p> --%>
                           <label for="genter_select"><b>Transport Required ?</b></label>
                              <p>
                              	 <form:radiobutton path="transportReq" id="transportReq_yes"  value="1" />
                                 <label for="transportReq_yes">Yes</label>
                              </p>
                              <p>
                                 <form:radiobutton path="transportReq" id="transportReq_no" value="0" />
                                 <label for="transportReq_no">NO</label>
                              </p>
                              <div class="input-field">
                                 <div class="errorTxt8"></div>
                              </div>
                        </div>
                        <div class="col s12 m4">
                           <%-- <p>
                              <input type="checkbox" id="siblingStudy" name="siblingStudy" value="${admissionFormBean.siblingStudy}" />
                              <label for="siblingStudy">Brother/Sister Studying in Morning Star</label>
                           </p> --%>
                           
                            <label for="genter_select"><b>Brother / Sister Already studying in School ?</b></label>
                              <p>
                              	 <form:radiobutton path="siblingStudy" id="siblingStudy_yes"  value="1" />
                                 <label for="siblingStudy_yes">Yes</label>
                              </p>
                              <p>
                                 <form:radiobutton path="siblingStudy" id="siblingStudy_no" value="0" />
                                 <label for="siblingStudy_no">NO</label>
                              </p>
                              <div class="input-field">
                                 <div class="errorTxt8"></div>
                              </div>
                        </div>
                         <div class="col s12 m4">
                          		 <label for="house">Discount </label>
                               <form:select class="error browser-default" path="discountId" >
                                <form:options items="${admissionFormBean.discountList}" itemValue="id"  itemLabel="abbriviation"  />
                              </form:select>
                            <label></label>
                          </div>
                       <!--  <div class="col s12 m12">
                           <p class="p_check_mar">
                              <input type="checkbox" id="test7" />
                              <label for="test7">I have carefully read all the detalis of school, and i agree to pay all fees as may be prescribed by the institution form time to time</label>
                           </p>
                        </div> -->
                        
                         <div class="input-field col s12 m12 center-align button-margin">
                           		<button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action" onclick = "submitForm('admissionFormBean')" >Submit
                          			<img src="img/save.png" class="button-img">
                          		 </button>
                          		 <a class="btn waves-effect waves-light  submit  reset" type="submit" name="action">Reset
                           			<img src="img/cancel.png" class="button-img">
                           		</a>
                          </div>
                        <!-- <div class="input-field col s12 center-align button-margin">
                           <button class="btn waves-effect waves-light  submit left"  onclick = "submitForm('admissionFormBean')" >Save For Letter
                           <i class="mdi-content-save right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit center-btn"  onclick = "submitForm('admissionFormBean')" >Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light right submit" type="submit" name="action">Cancel
                           <i class="mdi-navigation-close right"></i>
                           </button>
                        </div> -->
                        
                     </div>
                 
               </div>
               
            </div>
         </div>
      </div>
      </div>
       </form:form>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
	  <script src="js/jquery-ui.js" ></script>
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
             // Basic
             var drEvent = $('.dropify').dropify();

			drEvent.on('dropify.afterClear', function(event, element){
				//alert('File deleted'+element.element.id);
				var id = element.element.id;
				if(id == 'studentPhoto'){
					 $("#studentPhotoPath").val('');
				}else if(id == 'studentTc'){
					 $("#studentTcPath").val('');
				}
			});
             
             
             // Translated
         
         });
         	
         
         function getRegistrationId(obj){
        	 var regNum = obj.value;
	         if(regNum !=''){
	         	jQuery.ajax({
	         		  	type: "get",
	         	  	  	 url: "fetch-regid.do",
	         	  	  	 cache: false,
	         	  		data: {"regId":regNum},
		        	 	success:function(msg) {
				         if(msg.actionErrors != null){
				         	alert("error");
				         }
				         else{
				         	var regId = msg;
				         	if(regId != -1){
				         		//alert(regId)
				         		window.location = "admission.do?regId="+regId
				         	}else{
				         		document.getElementById("regId").style.display = "block";
				         	}
				         	
				         	
		        	 	}
				     }
	         });
          }
        }
         
         
         
         function submitForm(formId){
       		 $("#"+formId).submit();
       	 }
          $(document).ready(function() {
         $('select').material_select();
         });
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
        function onlyAlphabets(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
        }
        $('input[type=text], textarea,input[type=number], textarea,input[type=email]').bind("cut copy paste",function(e) {
            e.preventDefault();
        });
        $(".reset").click(function() {
            $(this).closest('form').find("input[type=text], textarea,input[type=number], textarea,input[type=email]").val("");
        });
      </script>
      <!--materialize js-->
   </body>
</html>