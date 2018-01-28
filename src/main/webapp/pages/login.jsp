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
  <title> Login page</title>
  <!-- CORE CSS-->
  <link rel="shortcut icon" type="image/png" href="img/login.png"/>
   <link rel="stylesheet" href="css/materialize.min.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">

<body class="body">


  <div id="login-page" class="row">
    <div class="col s12 z-depth-6 card-panel">
     <form:form  modelAttribute="login"  action="login.do" method="post"  class="login-form">
        <div class="row">
          <div class="input-field col s12 center">
            <img src="img/login.png" alt="" class="responsive-img valign profile-image-login size-logo">
          </div>
        </div>
         <c:if test="${not empty message}">
                <span class="text-center redcolor">${message}</span>
         </c:if>
        <div class="row margin">
          <div class="input-field col s12">
            <img src="img/user.png" class="prefix icon-img">
             <form:input path="email"  type="text" class="validate" placeholder="Email"/>
            <label for="email" data-error="wrong" >Email</label>
          </div>
        </div>
        <div class="row margin">
          <div class="input-field col s12">
             <img src="img/password.png" class="prefix icon-img">
            <form:input path="password" id="password" placeholder="password" type="password"  />
            <label for="password">Password</label>
          </div>
        </div>
        <div class="row">          
          <div class="input-field col s12 m12 l12  login-text">
              <input type="checkbox" id="remember-me" />
              <label for="remember-me">Remember me</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s12">
            <a href="javascript:submitForm('login')" class="btn waves-effect waves-light col s12">Login</a>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 m6 l6">
              <p class="margin right-align medium-small"><a href="#">Forgot password?</a></p>
          </div>          
        </div>

      </form:form>
    </div>
  </div>

 <script type="text/javascript" src="js/jquery.min.js"></script>
  <!--materialize js-->
  <script src="js/materialize.min.js"></script>
      
  <script type="text/javascript">
    	function submitForm(formId){
       		 $("#"+formId).submit();
       	}
    	
    	
      </script>
 

  
</body>

</html>