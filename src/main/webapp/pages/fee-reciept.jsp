<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Fee Receipt</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" href="css/materialize.min.css">
<link rel="shortcut icon" type="image/png" href="images/login.png" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/print.css">
<style>
#h6 {
    display: none;
    font-size: 12px;
}
  @media print {
body{
font-size:8px !important;
}
.box-print>div>p {
    font-size: 8px!important;
    font-weight: bold;
    margin: 0px;
}
#h6 {
       display: block !important;
    font-size: 12px !important;
    margin: 0px;

}
span,h6{
font-size: 7px!important;
}
th{
font-size: 7px!important;
font-size:bold;
}
.tex-morning{
margin: 0px;
    padding: 0px;}
.card-pane{
    margin: 0px;
    padding: 0px !important;}

.navbar-fixed {
    display: none;
}
}
  
  </style>
</head>
<body class="dashboard-body">

	<%@ include file="../includes/header.jsp"%>
	<div class="container_b">
		<div class="valign-wrapper row row_form"></div>
	</div>
	<div class="row_form valign-wrapper">

		<div class="col s12 m12 recipt-width">
			<div class="card-panel card-main">
		
					<!-- <p id="bg-text">adsad</p> -->
					<div class="row">
						<div class="col s3 m3">
							<img src="img/login.png" alt=""
								class="responsive-img valign profile-image-login size-logo center ">

						</div>
						<div class="col m9 s9 tex-morning">
							<h4 class="tex-font">MORNING STAR CHILDREN'S SR. SEC.
								ACADEMY</h4>
								
						</div>
					</div>
					<h4 id="h6">Student Copy</h4>
					<div class="row box-print">
						<div class="col m4 s4 ">
							<p>
								Student ID <span>${feeFormBean.studentMSId }</span>
							</p>
							<p>
								Name :<span>${feeFormBean.studentName }</span>
							</p>
							<p>
								Class :<span>${feeFormBean.studentClass }</span>
							</p>

						</div>

						<div class="col m8 s8 ">
							<p>
							<table style="table-layout: fixed; width: 100%">
								<thead style="border: none;">
									<tr>
										<th
											style="word-wrap: break-word; border: none; font-size: 10px; font-weight: bold;">
											<span style="font-size: 14px; font-weight: bold;">Months:</span>
											${feeFormBean.months }
										</th>
									</tr>
								</thead>
							</table>
							</p>
							<p>
							<table style="table-layout: fixed; width: 100%">
								<thead style="border: none;">
									<tr>
										<th
											style="word-wrap: break-word; border: none; font-size: 10px; font-weight: 400;">
											<span style="font-size: 14px; font-weight: bold;">Receipt Date : </span>
											${feeFormBean.recieptDate }
										</th>
									</tr>
								</thead>
							</table>
							</p>

						</div>
					</div>
					<form:form class="formValidate" id="formValidate"
						modelAttribute="feeFormBean" action="fee.do"
						novalidate="novalidate">
						<div class="col m12 s12">
							<table>
								<thead>
									<tr>
										<th>Fee</th>
										<th>Amount</th>
										<th>Discount</th>
										<th>paidAmount</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${feeFormBean.monthlyFeeList}" var="feeDto"
										varStatus="status">
										<tr>
											<td>${feeDto.name}</td>
											<td>${feeDto.amount}</td>
											<td>${feeDto.discount}</td>
											<td>${feeDto.paidAmount}</td>

										</tr>
									</c:forEach>
									<c:if test="${feeFormBean.quarterlyFeeList.size() > 0  }">
										<tr>
											<td colspan="4"><h6>Exam Fee</h6></td>
										</tr>
										<c:forEach items="${feeFormBean.quarterlyFeeList}"
											var="feeDto" varStatus="status">
											<tr>
												<td>${feeDto.name}</td>
												<td>${feeDto.amount}</td>
												<td>${feeDto.discount}</td>
												<td>${feeDto.paidAmount}</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${feeFormBean.halfyearlyFeeList.size() > 0  }">
										<tr>
											<td colspan="4"><h6>Annual Function Fee</h6></td>
										</tr>
										<c:forEach items="${feeFormBean.halfyearlyFeeList}"
											var="feeDto" varStatus="status">
											<tr>
												<td>${feeDto.name}</td>
												<td>${feeDto.amount}</td>
												<td>${feeDto.discount}</td>
												<td>${feeDto.paidAmount}</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${feeFormBean.anualFeeList.size() > 0  }">
										<tr>
											<td colspan="4"><h6>Annual Fee</h6></td>
										</tr>
										<c:forEach items="${feeFormBean.anualFeeList}" var="feeDto"
											varStatus="status">
											<tr>
												<td>${feeDto.name}</td>
												<td>${feeDto.amount}</td>
												<td>${feeDto.discount}</td>
												<td>${feeDto.paidAmount}</td>
											</tr>
										</c:forEach>
									</c:if>
									<tr class="grand-t">
										<td>Grand Total</td>
										<td>${feeFormBean.totalAmt}</td>
										<td>${feeFormBean.totalDiscAmt}</td>
										<td>${feeFormBean.totalPaidAmt}</td>
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
								<div class="col s12 m12 text-center">
									<a onclick="printme()"
										class="btn waves-effect waves-light center">Print</a>
								</div>
							</div>

						</div>
					</form:form>
		
				<div id="one-r" style="margin-top: 30px;">
					<div style="border-bottom: 1px dashed; margin: 10px 0px 20px;"></div>
					<div class="col m9 s9 tex-morning">
						<h4 class="tex-font text-center">MORNING STAR CHILDREN'S SR.
							SEC. ACADEMY</h4>
							
					</div>
					<h4 id="h6">School Copy</h4>
					<div class="row box-print">
						<div class="col m4 s4 ">
							<p>
								Student ID <span>${feeFormBean.studentMSId }</span>
							</p>
							<p>
								Name :<span>${feeFormBean.studentName }</span>
							</p>
							<p>
								Class :<span>${feeFormBean.studentClass }</span>
							</p>

						</div>

						<div class="col m8 s8">
							<p>
							<table style="table-layout: fixed; width: 100%">
								<thead style="border: none;">
									<tr>
										<th
											style="word-wrap: break-word; border: none; font-size: 10px; font-weight: bold;">
											<span style="font-size: 14px; font-weight: bold; word-wrap: break-word;">Months:</span>
											${feeFormBean.months }
										</th>
									</tr>
								</thead>
							</table>
							</p>
							<p>
							<table style="table-layout: fixed; width: 100%">
								<thead style="border: none;">
									<tr>
										<th
											style="word-wrap: break-word; border: none; font-size: 10px; font-weight: 400;">
											<span style="font-size: 14px; font-weight: bold;">Receipt No. </span>
											12314
										</th>
									</tr>
								</thead>
							</table>
							</p>
							<p>
							<table style="table-layout: fixed; width: 100%">
								<thead style="border: none;">
									<tr>
										<th
											style="word-wrap: break-word; border: none; font-size: 10px; font-weight: 400;">
											<span style="font-size: 14px; font-weight: bold;">Receipt No. </span>
											12314
										</th>
									</tr>
								</thead>
							</table>
							</p>

						</div>
					</div>

					<div class="col m12 s12">
						<form:form class="formValidate" id="formValidate"
							modelAttribute="feeFormBean" action="fee.do"
							novalidate="novalidate">
							<table>
								<thead>
									<tr>
										<th>Fee</th>
										<th>Amount</th>
										<th>Discount</th>
										<th>paidAmount</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${feeFormBean.monthlyFeeList}" var="feeDto"
										varStatus="status">
										<tr>
											<td>${feeDto.name}</td>
											<td>${feeDto.amount}</td>
											<td>${feeDto.discount}</td>
											<td>${feeDto.paidAmount}</td>

										</tr>
									</c:forEach>
									<c:if test="${feeFormBean.quarterlyFeeList.size() > 0  }">
										<tr>
											<td colspan="4"><h6>Exam Fee</h6></td>
										</tr>
										<c:forEach items="${feeFormBean.quarterlyFeeList}"
											var="feeDto" varStatus="status">
											<tr>
												<td>${feeDto.name}</td>
												<td>${feeDto.amount}</td>
												<td>${feeDto.discount}</td>
												<td>${feeDto.paidAmount}</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${feeFormBean.halfyearlyFeeList.size() > 0  }">
										<tr>
											<td colspan="4"><h6>Annual Function Fee</h6></td>
										</tr>
										<c:forEach items="${feeFormBean.halfyearlyFeeList}"
											var="feeDto" varStatus="status">
											<tr>
												<td>${feeDto.name}</td>
												<td>${feeDto.amount}</td>
												<td>${feeDto.discount}</td>
												<td>${feeDto.paidAmount}</td>
											</tr>
										</c:forEach>
									</c:if>
									<c:if test="${feeFormBean.anualFeeList.size() > 0  }">
										<tr>
											<td colspan="4"><h6>Annual Fee</h6></td>
										</tr>
										<c:forEach items="${feeFormBean.anualFeeList}" var="feeDto"
											varStatus="status">
											<tr>
												<td>${feeDto.name}</td>
												<td>${feeDto.amount}</td>
												<td>${feeDto.discount}</td>
												<td>${feeDto.paidAmount}</td>
											</tr>
										</c:forEach>
									</c:if>
									<tr class="grand-t">
										<td>Grand Total</td>
										<td>${feeFormBean.totalAmt}</td>
										<td>${feeFormBean.totalDiscAmt}</td>
										<td>${feeFormBean.totalPaidAmt}</td>
									</tr>
								</tbody>
							</table>
						</form:form>
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
		function printme() {
			window.print();

		}
	</script>

</body>