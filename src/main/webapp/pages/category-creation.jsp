<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Category Creation</title>
      <!-- CORE CSS-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css"> 
      <link rel="stylesheet" type="text/css" href="css/dropify.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="shortcut icon" type="image/png" href="img/login.png" />
      <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/material-design-lite/1.1.0/material.min.css">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.material.min.css">
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
      <ul id="dropdown1" class="dropdown-content">
         <li><a href="login.html">Login</a>
         </li>
         <li><a href="#!">Profile</a>
         </li>
         <li class="divider"></li>
         <li><a href="#!">Logout</a>
         </li>
      </ul>
      <div class="navbar-fixed">
         <nav>
            <div class="nav-wrapper">
               <a href="#!" class="brand-logo img-logo"><img src="img/add.png">
               </a><span class="text-logo">LASER</span>
               <ul class="right hide-on-med-and-down">
                  <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Welcome Alok Bajpai<i class="material-icons right">arrow_drop_down</i></a>
                  </li>
               </ul>
            </div>
         </nav>
      </div>
     <div class="container_b">
      <div class="valign-wrapper row ">
         <div class="col s12 valign">
            <div class="card-panel search-c">
               <!-- <h4 class="header2">Search</h4> -->
               <div class="row">
                  <form class="formValidate" id="formValidate" method="post" action="category-creation.do" novalidate="novalidate" name="categoryBean">
                    <input type="hidden" name="id" id="id" value=""/>
      <h4>Category Creation(A/C)</h4>
       <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Category Name</h6>
                        </div>
                        <div class="input-field col s6 m6">
          <input placeholder="Placeholder" name="name" id="autocomplete-input" class="autocomplete" type="text" class="validate">
          <label for="Amount">Category Name</label>
        </div>
                        </div>
          <div class="row">
                        <div class="col s6 m3">
                        <br>
                          <h6>Desc</h6>
                        </div>
                        <div class="input-field col s6 m6">
          <input placeholder="Placeholder" name="description" id="desc" type="text" class="validate">
          <label for="Amount">Desc</label>
        </div>
                        </div>
  <div class="input-field col s12 center-align ">
       <button class="btn waves-effect waves-light  submit center-btn" type="submit" name="action">Submit
                           <i class="mdi-content-send right"></i>
                           </button>
                           <button class="btn waves-effect waves-light  submit" type="submit" name="action" onclick="$('#modal1').modal('close');">Clear
                           <i class="mdi-navigation-close right"></i>
                           </button>
                           </div>
    </div>



                      
                     
                    
                  </form>
               </div>
            </div>
         </div>
      </div>
      </div>
     
      </div>

    
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
      <script type="text/javascript" src="js/dropify.min.js"></script>
     <!--  <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.material.min.js"></script> -->
      <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

      


<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
   
    <script type="text/javascript">
   $("input.autocomplete").autocomplete({source:function(request, response) {
	            $.ajax({
	                type: "get",
	          		url: "fetch-categorylist.do",
	          		cache: false,
	          		data: {"categoryName":request.term},
	                dataType: "json",
	                success: function(data) {
	                    response(data);
	                }
	            });
	        },
	        select: function( event, ui ) {
	           console.log(ui.item.value)
	           this.value = ui.item.label;
	           document.getElementById('id').value = ui.item.value;
	           document.getElementById('desc').value = ui.item.descValue;
		       return false;
	          }, 
	        min_length: 3,
			autoFocus: true,
			cacheLength: 1,
			scroll: true,
			highlight: false,
	        delay: 300
	        }); 
   </script>
   </body>
</html>