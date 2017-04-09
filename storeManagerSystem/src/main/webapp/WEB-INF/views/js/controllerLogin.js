var app = angular.module('login', []);
app.controller('ctrllogin', function($scope) {
	$scope.btnLogin = function() {
		checkLogin($scope);
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
		document.getElementById("loginform").submit();
	}
}
