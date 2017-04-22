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
<div id="page-wrapper" ng-app="RegisterProductCategory" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Đăng kí danh mục sản phẩm</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="RegisterProductCategory" role="form" modelAttribute="RegisterProductCategory" method="POST">
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên nhóm sản phẩm</label> 
					<form:input class="form-control" type="text" path="nameProductCategory" placeholder="Họ tên" ng-model = "nameProductCategory"  ng-init ="nameProductCategory = '${RegisterProductCategory.nameProductCategory}'" />
					<p style="color: red;">{{nameProductCategory_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<p style="color: blue; font-weight: bold;">${RegisterProductCategory.message }</p>
				<p style="color: red; font-weight: bold;">${RegisterProductCategory.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-3" >
				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="Đăng kí">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<c:if test="${!empty RegisterProductCategory.lst }">
		<div class ="row">
			<div class="col-lg-12">
			<table style="width: 450px" class="table table-striped table-bordered table-hover" id="">
				<thead>
					<tr>
						<th style="width: 50px">STT</th>
						<th>Tên nhóm sản phẩm</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody style="overflow: auto; height:50px">
				<c:forEach var="items" items="${RegisterProductCategory.lst }">
				<tr class="gradeX">
                     <td class="center" style="text-align: center">${items.no}</td>
                     <td>${items.nameProductCategory}</td>
                     <td style="text-align: center">
						<button class="btn" type="button" ng-click="btnDelete(${items.idProductCategory});" >
							<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
						</button>
                     </td>
                 </tr>
                </c:forEach> 
				</tbody>
			
			</table>
			
			</div>
		</div>
		</c:if>
		
	</form:form>		
		<!-- /#page-wrapper -->
	</div>

</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
</body>
<script src="/storeManagerSystem/view/js/registerProductCategory.js"></script>
</html>