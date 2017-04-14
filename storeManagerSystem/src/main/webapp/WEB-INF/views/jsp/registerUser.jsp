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
    <title>Đăng kí tài khoản</title>
    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
</head>
<body>
<div id="wrapper">
<div id="wrapper">
<div id="page-wrapper" ng-app="registerUser" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Đăng kí người dùng</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="registerUser" role="form" modelAttribute="registerUserForm" method="POST">
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Họ tên</label> 
					<form:input class="form-control" type="text" path="fullName" placeholder="Họ tên" name="fullName" ng-model = "fullName"  ng-init ="fullName = '${registerUserForm.fullName}'" />
					<p style="color: red;">{{fullname_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ</label> 
					<form:input class="form-control" type="text" path="address" placeholder="Địa chỉ" name="address" ng-model ="address" ng-init="address='${registerUserForm.address }'"  />
					<p style="color: red;">{{address_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<form:input class="form-control" type="text" path="telephone" placeholder="Số điện thoại" name="telephone" ng-model ="telephone" ng-init="telephone='${registerUserForm.telephone }'"  />
					<p style="color: red;">{{telephone_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Tên đăng nhập</label> 
					<form:input class="form-control" type="text" path="username" placeholder="Tên đăng nhập" name="username" ng-model ="username" ng-init="username='${registerUserForm.username }'" ng-disabled="mySwitch" />
					<p style="color: red;">{{username_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ email</label> 
					<form:input class="form-control" path="email" type="email" placeholder="Địa chỉ email" name="email" ng-model ="email" ng-init="email='${registerUserForm.email }'" />
					<p style="color: red;">{{email_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Mật khẩu</label> 
					<form:input class="form-control" type="password" path="password" placeholder="Mật khẩu" name="password" ng-model ="password" ng-init="password='${registerUserForm.password }'" ng-disabled="mySwitch" />
					<p style="color: red;">{{password_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Xác nhận mật khẩu</label> 
					<input class="form-control" type="password"  placeholder="Xác nhận mật khẩu" name="repassword" ng-model ="repassword" ng-init="repassword=''" ng-disabled="mySwitch" >
					<p style="color: red;">{{repassword_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<p style="color: blue; font-weight: bold;">${registerUserForm.message }</p>
				<p style="color: red; font-weight: bold;">${registerUserForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-3" >
				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="Tiếp tục">
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
		<form:input class="form-control" path="idStoreOwner" type="hidden" ng-model="idStoreOwner"  />
		<form:input class="form-control" path="disabledFlag" type="hidden" ng-model="mySwitch" ng-init="mySwitch='${registerUserForm.disabledFlag}'" />
		<form:input class="form-control" path="updateFlag" type="hidden" ng-model="updateFlag" ng-init="updateFlag='${registerUserForm.updateFlag}'" />
		
	</form:form>		
		<!-- /#page-wrapper -->
	</div>

</div>
</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
</body>
<script src="${pageContext.request.contextPath}/view/js/registerUser.js"></script>
</html>