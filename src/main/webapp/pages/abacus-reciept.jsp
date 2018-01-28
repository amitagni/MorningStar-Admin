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
      <title>Abacusreg Form</title>
     
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   
 <link rel="stylesheet" href="css/materialize.min.css">
  <link rel="shortcut icon" type="image/png" href="images/login.png"/>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/print.css">
  <style>
  #h6 {
    display: none;
    font-size: 12px;
}
 @media print { #h6 {
       display: block !important;
    font-size: 12px !important;
    margin: 0px;

}
}
  
  </style>
  
  </head>
   <body class="dashboard-body">
     
     <%@ include file="../includes/header.jsp"%>
      <div class="container_b">
      <div class="valign-wrapper row row_form">
         
      </div>
      </div>
       <div class="row_form valign-wrapper">
       
          <div class="col s12 m12 recipt-width">
            <div class="card-panel card-main">
           <div><!-- <p id="bg-text">adsad</p> -->
           <div class="row">
                <div class="col s3 m3">
            <img src="img/login.png" alt="" class="responsive-img valign profile-image-login size-logo center ">
            
          </div>
          <div class="col m9 s9 tex-morning">
         	 <h4 class="tex-font">MORNING STAR CHILDREN'S SR. SEC. ACADEMY</h4>
          </div>
          </div>
          <h4 id="h6">Student Copy</h4>
          <div class="row box-print">
          <div class="col m6 s6 ">
          <p>Name :<span>${abacusReceiptDTO.name}</span></p>
          <p>Father's Name :<span>${abacusReceiptDTO.fatherName}</span></p>
          
          </div>
       
          <div class="col m6 s6 ">
          <p class="right-align">Date:<span>${abacusReceiptDTO.date}</span></p>
          <p class="right-align" >Receipt Number :<span>${abacusReceiptDTO.recieptId}</span></p>
          </div>
          </div>
          <div class="col m12 s12">
           <table>
        <thead>
          <tr>
              <th>Particulars</th>
              <th>Amounts</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>Months</td>
            <td>${abacusReceiptDTO.months}</td>
            
          </tr>
          <tr>
            <td>Amount</td>
            <td>${abacusReceiptDTO.amount}</td>
          </tr>
          <c:if test="${not empty abacusReceiptDTO.regAmount}">
	          <tr>
	            <td>Registration Fee</td>
	            <td>${abacusReceiptDTO.regAmount}</td>
	          </tr>
          </c:if>
          
          <tr class="grand-t">
            <td>Grand Total</td>
            <td>${abacusReceiptDTO.totalAmount}</td>
          </tr>
    
        </tbody>
      </table>
      <br>
      
      <div class="row">
      <div class="col m6 s6">
          <h6>Checker</h6>
        
          </div>
          <div class="col m6 s6">
          <h6 class="right-align">Cashier</h6>
        
          </div>
           <div class="col s12 m12 text-center"> <a onclick="printme()" class="btn waves-effect waves-light center">Print</a></div>
      </div>
      
          </div>
         </div>
          <div id="one-r">
        <div style="border-bottom: 1px dashed;    margin: 80px 0px 20px;"></div>
        <div class="col m9 s9 tex-morning" style="margin-top: 70px;">
         	 <h4 class="tex-font text-center">MORNING STAR CHILDREN'S SR. SEC. ACADEMY</h4>
          </div>
        <h4 id="h6">School Copy</h4>
          <div class="row box-print">
          <div class="col m6 s6 ">
            <p>Name :<span>${abacusReceiptDTO.name}</span></p>
          	<p>Father's Name :<span>${abacusReceiptDTO.fatherName}</span></p>
         
          </div>
       
          <div class="col m6 s6 ">
          <p class="right-align">Date:<span>${abacusReceiptDTO.date}</span></p>
          <p class="right-align" >Receipt Number :<span>${abacusReceiptDTO.recieptId}</span></p>
          
          </div>
          </div>
          <div class="col m12 s12">
           <table>
        <thead>
          <tr>
              <th>Particulars</th>
              <th>Amounts</th>
          </tr>
        </thead>

         <tbody>
          <tr>
             <td>Months</td>
            <td>${abacusReceiptDTO.months}</td>
           
          </tr>
          <tr>
             <td>Amount</td>
            <td>${abacusReceiptDTO.amount}</td>
          </tr>
           <c:if test="${not empty abacusReceiptDTO.regAmount}">
	          <tr>
	            <td>Registration Fee</td>
	            <td>${abacusReceiptDTO.regAmount}</td>
	          </tr>
          </c:if>
          
          <tr class="grand-t">
            <td>Grand Total</td>
            <td>${abacusReceiptDTO.totalAmount}</td>
          </tr>
    
        </tbody>
      </table>
      <br>
      
      <div class="row">
      <div class="col m6 s6">
          <h6>Checker</h6>
        
          </div>
          <div class="col m6 s6">
          <h6 class="right-align">Cashier</h6>
        
          </div>
           
      </div>
      
          </div>
           </div>
          </div>
          </div>
         </div>
        
     
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script src="js/materialize.min.js"></script>
      <script src="js/jquery.validate.min.js"></script>
       <script type="text/javascript">

      function printme() { window.print();
        
      }
        
      </script>
      
   </body>
</html>