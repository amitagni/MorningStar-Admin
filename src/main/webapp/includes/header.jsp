   <div style="display:none">
   <input type=text id="refreshed" value="no">
   </div>
   <ul id="dropdown1" class="dropdown-content">
         <li><a href="javascript:alert('Not implemented yet')">Change Password</a>
         </li>
         <li><a href="javascript:alert('Not implemented yet')">Profile</a>
         </li>
         <li><a href="dashboard.do">Dashboard</a>
         </li>
         <li class="divider"></li>
         <li><a href="javascript:logout()">Logout</a>
         </li>
      </ul>
      <div class="navbar-fixed">
         <nav>
            <div class="nav-wrapper">
               <a href="javascript:void();" class="brand-logo img-logo"><img src="img/add.png">
               </a><span class="text-logo">
                  <span class="text-center greencolor">${page}</span>
               </span>
               <ul class="right hide-on-med-and-down">
                  <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Welcome  ${sessionScope.userDTO.name}<img src="img/d.png" class="dropimg"></a>
                  </li>
               </ul>
            </div>
         </nav>
      </div>
     <script type="text/javascript" src="js/jquery.min.js"></script>
  <!--   <script src='js/jquery.backDetect.min.js'></script> -->
	<script type="text/javascript">
		/* $(window).load(function(){
			//alert("load");
			
			
			$('body').backDetect(function(){
				alert("Back not allowed ");
				//window.location = "logout.do";
				window.history.forward();
				
			});
		});
		 */
		 

	        onload=function(){
	            var e=document.getElementById("refreshed");
	            //alert(e.value);
	            if(e.value=="no"){
	            	e.value="yes";
	               console.log("no")
	            }
	            else{
	            	console.log("yes");
	           		 e.value="no";
	           		 location.reload();
	            }
	     }

 
		 function logout() {
		   	var r = confirm("Are you sure to Exit?");
		   	if (r == true) {
		   		window.location = "logout.do";
		   		alert("logout")
		   	} else {
		   
		   	}
		 }
	
   </script>