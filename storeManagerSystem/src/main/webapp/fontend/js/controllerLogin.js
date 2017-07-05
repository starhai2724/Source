var app = angular.module('login', []);
app.controller('ctrllogin', function($scope) {
	$scope.btnLogin = function() {
		checkLogin($scope);
	}
	$scope.btnRegister = function(){
		register();
	}
});

function checkLogin($scope) {
	var valid = true;
	if ($scope.username == "") {
		$scope.username_err = "Vui lòng nhập tên đăng nhập!"
		valid = false;
	}
	if ($scope.password == "") {
		$scope.password_err = "Vui lòng nhập mật khẩu!"
		valid = false;
	}
	if (true == valid) {
		document.getElementById("loginform").action = "/storeManagerSystem/login";
		document.getElementById("loginform").method = "POST";
		document.getElementById("loginform").submit();
	}
}


function register(){
	document.getElementById("loginform").action = "/storeManagerSystem/buoc1";
	document.getElementById("loginform").method = "GET";
	document.getElementById("loginform").submit();
}
