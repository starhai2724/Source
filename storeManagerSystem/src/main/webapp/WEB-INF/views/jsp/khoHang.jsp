<!DOCTYPE html>
<html lang="en">
<head>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
    <title>Hệ thống bán hàng</title>
    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
</head>

<body>
<div id="wrapper">
<div id="page-wrapper" ng-app="KhoHangForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Kho Hàng</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="KhoHangForm" role="form" modelAttribute="KhoHangForm" method="POST">
		<!--Message (S)-->
		<%-- <div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<p style="color: blue; font-weight: bold;">${KhoHangForm.message }</p>
				<p style="color: red; font-weight: bold;">${KhoHangForm.messageErr }</p>
				</div>
			</div>
		</div> --%>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<c:if test="${!empty KhoHangForm.lst }">
		<div class="panel-body" style="width: 650px">
                            <table width = "100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
				                <thead >
									<tr>
										<th style="width: 250px">Mã/Tên sản phẩm</th>
										<th style="width: 100px">Số lượng</th>
										<th style="width: 150px">Trạng thái</th>
									</tr>
								</thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${KhoHangForm.lst }">
										<tr class="gradeX">
												   <th class="center" style="text-align: left">${items.tenSp}</th>
								                   <td style="text-align: right">${items.soLuong}</td>
								                   <td>Còn hàng</td>
								         </tr>
								 	</c:forEach> 
                                </tbody>
                            </table>
         </div>
		</c:if>
	</form:form>		
		<!-- /#page-wrapper -->
	</div>

</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
</body>
</html>