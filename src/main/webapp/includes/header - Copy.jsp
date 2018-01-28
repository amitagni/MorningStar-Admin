   <ul id="dropdown1" class="dropdown-content">
         <li><a href="javascript:alert('Not implemented yet')">Change Password</a>
         </li>
         <li><a href="javascript:alert('Not implemented yet')">Profile</a>
         </li>
         <li><a href="/dashboard.do">Dashboard</a>
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
    
    
    <script type="text/javascript">
	 function logout() {
	   	var r = confirm("Are you sure to Exit?");
	   	if (r == true) {
	   		window.location = "/logout.do";
	   	} else {
	   
	   	}
	 }
   </script>