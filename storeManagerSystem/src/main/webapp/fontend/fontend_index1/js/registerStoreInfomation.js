var app = angular.module('registerStoreInfomation', []);
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
	if ($scope.storeName_err == "") {
		$scope.storeName_err = "Vui lòng nhập họ tên!"
		valid = false;
	}
	if ($scope.address_err == "") {
		$scope.address_err = "Vui lòng nhập số điện thoại!"
		valid = false;
	}
	if ($scope.telephone_err == "") {
		$scope.telephone_err = "Vui lòng nhập tên đăng nhập!"
		valid = false;
	}
	if ($scope.email == "") {
		$scope.email_err = "Vui lòng nhập email!"
		valid = false;
	}

	if ($scope.email_err == "") {
		$scope.email_err = "Vui lòng nhập mật khẩu!"
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("registerStoreInfomation").action = "/storeManagerSystem/RegisterStoreInfomation/insert";
			document.getElementById("registerStoreInfomation").method = "POST";
			document.getElementById("registerStoreInfomation").submit();
		}
	}
}


function back(){
	if(confirm("Bạn có muốn quay về màn hình trước?")){
		document.getElementById("registerStoreInfomation").action = "/storeManagerSystem/registerUser/init";
		document.getElementById("registerStoreInfomation").submit();
	}
}


















