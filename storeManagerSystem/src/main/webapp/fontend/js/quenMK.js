var app = angular.module('QuenMatKhauForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.email_err = "";
	$scope.btnQuenMK = function() {
			quenMK($scope);
	}
	
	$scope.btnDoiMK = function() {
		doiMK($scope);
	}
});


function quenMK($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.email == "") {
		$scope.email_err = "Nhập Email."
		valid = false;
	}
	if (true == valid) {
			document.getElementById("QuenMatKhauForm").action = "/storeManagerSystem/quenMatKhau";
			document.getElementById("QuenMatKhauForm").method = "POST";
			document.getElementById("QuenMatKhauForm").submit();
	}
}

function doiMK($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	if ($scope.email == "") {
		$scope.email_err = "Nhập tên đăng nhập."
		valid = false;
	}
	if ($scope.passwordOld == "") {
		$scope.passwordOld_err = "Vui lòng nhập mật khẩu!"
		valid = false;
	}
	
	if ($scope.password == "") {
		$scope.password_err = "Vui lòng nhập mật khẩu mới!"
		valid = false;
	}else if($scope.password.length < 6){
		$scope.password_err = "Vui lòng nhập mật khẩu mới trên 6 kí tự!"; 
		valid = false;
	}
	
	if (true == valid) {
		document.getElementById("QuenMatKhauForm").action = "/storeManagerSystem/doiMatKhau";
		document.getElementById("QuenMatKhauForm").method = "POST";
		document.getElementById("QuenMatKhauForm").submit();
	}
}



