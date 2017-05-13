var app = angular.module('registerUser', []);
app.controller('ctrl', function($scope) {
	$scope.btnCreate = function() {
			create($scope);
	}
	$scope.btnBack = function(){
			back();
	}
	
});

function create($scope) {
	var valid = true;
	if ($scope.fullName == "") {
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
			document.getElementById("registerUser").action = "/storeManagerSystem/registerUser/insert";
			document.getElementById("registerUser").method = "POST";
			document.getElementById("registerUser").submit();
	}
}


function back(){
	if(confirm("Bạn có muốn quay về màn hình trước?")){
		document.getElementById("registerUser").action = "/storeManagerSystem/storeOwnerSearch";
		document.getElementById("registerUser").submit();
	}
}


















