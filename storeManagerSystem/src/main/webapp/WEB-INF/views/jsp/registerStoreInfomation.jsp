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
    <title>Đăng kí thông tin cửa hàng</title>
    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
</head>
<body>
<div id="wrapper">
<div id="page-wrapper" ng-app="registerStoreInfomation" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thông tin của hàng</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="registerStoreInfomation" role="form" modelAttribute="registerStoreInfomation" >
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Tên cửa hàng</label> 
					<form:input maxlength="20" class="form-control" type="text" path="storeName" placeholder="Họ tên" ng-model = "storeName"  ng-init ="storeName = '${registerStoreInfomation.storeName}'" />
					<p style="color: red;">{{storeName_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ gian hàng</label> 
					<form:input maxlength="30" class="form-control" type="text" path="domain" placeholder="Địa chỉ gian hàng" ng-model ="domain" ng-init="domain='${registerStoreInfomation.domain }'"  />
					<p style="color: red;">{{domain_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<form:input maxlength="12" class="form-control" type="text" path="telephone" placeholder="Số điện thoại" name="telephone" ng-model ="telephone" ng-init="telephone='${registerStoreInfomation.telephone }'"  />
					<p style="color: red;">{{telephone_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ email</label> 
					<form:input maxlength="30" class="form-control" type="text" path="email" placeholder="Địa chỉ email" ng-model ="email" ng-init="email='${registerStoreInfomation.email }'" ng-disabled="mySwitch" />
					<p style="color: red;">{{email_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3 selectContainer">
				<div class="form-group">
					<label>Loại kinh doanh</label>
					<%-- <form:select class="form-control" path="categoryed"  >	
					   <c:forEach var="items" items="${registerStoreInfomation.lstCategory }">
					   	<option value="${items.id}" >${items.content}</option>
					   </c:forEach>
					</form:select> --%>
					<form:select class="form-control" path="categoryed">
					    <form:options items="${registerStoreInfomation.lstCategory}" />
					</form:select>
				</div>
			</div>
			<div class="col-xs-3 selectContainer">	
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ cửa hàng</label> 
					<form:input maxlength="50" class="form-control" type="text" path="address" placeholder="Địa chỉ cửa hàng" ng-model ="address" ng-init="address='${registerStoreInfomation.address }'" ng-disabled="mySwitch" />
					<p style="color: red;">{{address_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<p style="color: blue; font-weight: bold;">${registerStoreInfomation.message }</p>
				<p style="color: red; font-weight: bold;">${registerStoreInfomation.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-3" >
				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="Đăng kí">
				<input type="button" name="" class="btn btn-info " ng-click="btnBack()" value="Quay về">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		
		<!-- hidden -->
		
	</form:form>		
		<!-- /#page-wrapper -->
	</div>

</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
</body>
<script src="/storeManagerSystem/view/js/registerStoreInfomation.js"></script>
</html>