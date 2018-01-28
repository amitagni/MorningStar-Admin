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
      <title>Account Inventory Item</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> 
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
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
     <%@ include file="../includes/header.jsp"%>
      <form:form  modelAttribute="inventoryCateoryBean"  action="inventorycategory.do" name="inventoryCateoryBean" method="post"  class="formValidate" novalidate="novalidate">
       <form:hidden path="userAction"/>       
     <div class="container_b">
      <div class="valign-wrapper row ">
         <div class="col s12 valign">
            <div class="card-panel search-c">
               <!-- <h4 class="header2">Search</h4> -->
               <div class="row">
                   
      			<h4>Add Inventory -New Item(s)</h4>
                    <div class="row">
                        <div class="col s6 m2">
                        <br>
                          <h6>Category</h6>
                        </div>
                        <div class="col s6 m3 input-field" style="margin-left: 72px;">
                          
                          <!-- <i class="material-icons prefix"> search</i>
                          <input type="text" id="autocomplete-input" class="autocomplete ui-autocomplete-input" autocomplete="off" required="required"><span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                           -->
                            <img src="img/search.png" class="serach-img">
                                <input type="text" id="basics">
                                <span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span>
                           <%--  <form:select class="error browser-default" path="categoryBean.id" id="lastClass" >
                                	<form:options items="${inventoryCateoryBean.categoryList}" itemValue="id"  itemLabel="categoryName" />
                             </form:select>  --%>
                          
                          <!-- <label for="autocomplete-input" class="">Search Category</label>
                         -->
                        
                        </div>
                         <div class="col s6 m3">
                        <br>

                          <a class="modal-trigger" href="#modal1" style="margin-top: 6px;"><i class="material-icons left" style="
    font-size: 35px;
    margin-left: -22px;
" onclick="setAction('1')">add_circle_outline</i></a>
                        </div>
                        </div>
					<div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Add Items</h6>
                        </div>
                        <div class="input-field col s6 m3">
             <form:input path="itemName"  type="text" class="validate" placeholder="Item Name"  />
          <label for="Items">Name</label>
        </div>
                        </div>

          <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Desc</h6>
                        </div>
                        <div class="input-field col s6 m3">
             <form:input path="itemDescription"  type="text" class="validate" placeholder="Description"  />
          <label for="Amount">Desc</label>
        </div>
                        </div>

  <div class="input-field col s12 center-align ">
       <button class="btn waves-effect waves-light  submit center-btn" type="button" name="action" onclick="return submitForm('inventoryCateoryBean','1')">Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit" type="button" name="action" onclick="$('#modal1').modal('close');">Clear
                           <i class="mdi-navigation-close right"></i>
                           </button>
                           </div>
    </div>

               </div>
            </div>
         </div>
      </div>
     
<div id="modal1" class="modal">
    <div class="modal-content">
      <h4>Add Category</h4>
       <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Category Name</h6>
                        </div>
                        <div class="input-field col s6 m6">
                          <form:input path="categoryBean.name"  type="text" class="validate" placeholder="Name" />
          <label for="Amount">Category Name</label>
        </div>
                        </div>
          <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Description</h6>
                        </div>
                        <div class="input-field col s12 m6">
            <form:input path="categoryBean.description"  type="text" class="validate" placeholder="Description"  />
          <label for="textarea1">Description</label>
        </div>
                        </div>
  <div class="input-field col s12 center-align ">
       <button class="btn waves-effect waves-light  submit center-btn" type="button" name="action" onclick="return submitForm('inventoryCateoryBean','2')">Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit" type="button" name="action" onclick="$('#modal1').modal('close');setAction('2')">Cancel
                           <i class="mdi-navigation-close right"></i>
                           </button>
                           </div>
    </div>
   
  </div>
     </form:form>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
     <!--  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.material.min.js"></script> -->
 	<script type="text/javascript" src="js/jquery.easy-autocomplete.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" ></script>
   

      


<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
<script type="text/javascript">

function setAction(action){
		//alert(action);
		 document.getElementById("userAction").value = action;
}
	
function submitForm(formId, n){
        $("#"+formId).submit();
}

$(document).ready(function(){
   // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
   $('.modal').modal({
      dismissible: true, // Modal can be dismissed by clicking outside of the modal
     opacity: .5,
   });
 });
 
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

</script>

   
   </body>
</html>