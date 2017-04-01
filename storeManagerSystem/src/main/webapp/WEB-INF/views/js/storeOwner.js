var app = angular.module('storeOwner', []);
app.controller('ctrl', function($scope) {
	$scope.btnCreate = function() {
		create($scope);
	}
});

function create($scope) {
	var valid = true;
	if ($scope.fullname == "") {
		$scope.fullname_err = "Vui lòng nhập họ tên!"
		valid = false;
	}
	if ($scope.telephone == "") {
		$scope.telephone_err = "Vui lòng nhập số điện thoại!"
		valid = false;
	}
	if ($scope.username == "") {
		$scope.username_err = "Vui lòng nhập tên đăng nhập!"
		valid = false;
	}
	if ($scope.email == "") {
		$scope.email_err = "Vui lòng nhập email!"
		valid = false;
	}

	if ($scope.password == "") {
		$scope.password_err = "Vui lòng nhập mật khẩu!"
		valid = false;
	}

	if ($scope.password != $scope.repassword) {
		$scope.repassword_err = "Vui lòng nhập mật khẩu xác nhận không đúng!"
		valid = false;
	}

	if (true == valid) {
		document.getElementById("storeOwnerForm").submit();
	}
}
