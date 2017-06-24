<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Hệ thống bán hàng</title>
<%@include file="/WEB-INF/views/jsp/headerInclude.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Hệ thống bán hàng</h3>
					</div>
					<div class="panel-body" ng-app="KhachHangLogin" ng-controller="ctrl">
						<form:form id="KhachHangDangNhapForm" modelAttribute="KhachHangDangNhapForm" role="form" method="POST" >
							<fieldset>
								<div class="form-group">
								<p style="color: red;">${KhachHangDangNhapForm.messageErr}</p>
								</div>
								<div class="form-group">
<%-- 									<form:input class="form-control" type="text" path ="sdt" placeholder="Số điện thoại"  ng-model="sdt" ng-init ="sdt='${KhachHangDangNhapForm.sdt}'" autofocus/> --%>
									<form:input type="text" class="form-control" path="sdt" placeholder="Số điện thoại" ng-model="sdt" ng-init="sdt='${KhachHangDangNhapForm.sdt}'"  />
								</div>
								<div class="form-group">
									<form:input type="password" class="form-control" path="matKhau" placeholder="Mật khẩu" ng-model="matKhau" ng-init="matKhau='${KhachHangDangNhapForm.matKhau}'" />
								</div>
								<div class ="form-group">
									<a href ="#">Quên mật khẩu</a>
								</div>
								<div>
									<input type="button" id ="btnLogin" class="btn btn-lg btn-success btn-block" ng-click="btnLogin('${KhachHangDangNhapForm.pathJSP }');" value="Đăng nhập" onkeydown = "if (event.keyCode == 13)document.getElementById('btnLogin').click()">
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jsp/footerInclude.jsp"%>
	<script src="/storeManagerSystem/view/js/khachHangDangNhap.js"></script>
</body>				
</html>
