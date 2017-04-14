<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
					<div class="panel-body" ng-app="login" ng-controller="ctrllogin">
						<form id="loginform" role="form" method="POST" >
							<fieldset>
								<div class="form-group">
								<p style="color: red;">${message}</p>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Tên đăng nhập" name="username"  ng-model="username" type="text"
									ng-init =" username = '${username}'" autofocus>
									<p style="color: red;">{{username_err}}</p>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Mật khẩu" name="password" ng-model="password" 
									ng-init =" password = '${password}'" type="password">
									<p style="color: red;">{{password_err}}</p>
								</div>
								<div class ="form-group">
									<a ng-click="btnRegister();">Đăng kí</a>
									</br>
									<a href ="#">Quên mật khẩu</a>
									
								</div>
								<div>
									<input type="button" class="btn btn-lg btn-success btn-block" ng-click="btnLogin();" value="Đăng nhập">
									<input type="button"  class="btn btn-lg btn-success btn-block" value="Hủy">
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/jsp/footerInclude.jsp"%>
	<script src="view/js/controllerLogin.js"></script>
</body>				
</html>
