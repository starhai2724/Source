var app = angular.module('storeOwner', []);
app.controller('ctrl', function($scope) {
	$scope.btnCreate = function() {
		if($scope.updateFlag == 1){
			update($scope);
		}else{
			create($scope);
		}
	}
	$scope.btnBack = function(){
			back();
	}
	$scope.btnClear = function(){
		clear();
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
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("storeOwnerForm").action = "/storeManagerSystem/storeOwnerInsert";
			document.getElementById("storeOwnerForm").method = "GET";
			document.getElementById("storeOwnerForm").submit();
		}
	}
}

function update($scope) {
	var valid = true;
	if ($scope.fullName == "") {
		$scope.fullname_err = "Vui lòng nhập họ tên!"
		valid = false;
	}
	if ($scope.telephone == "") {
		$scope.telephone_err = "Vui lòng nhập số điện thoại!"
		valid = false;
	}
	if ($scope.email == "") {
		$scope.email_err = "Vui lòng nhập email!"
		valid = false;
	}
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("storeOwnerForm").action = "/storeManagerSystem/updateStoreOwner";
			document.getElementById("storeOwnerForm").submit();
		}	
	}
}


function back(){
	if(confirm("Bạn có muốn quay về màn hình trước?")){
		document.getElementById("storeOwnerForm").action = "/storeManagerSystem/storeOwnerSearch";
		document.getElementById("storeOwnerForm").submit();
	}
}


function clear(){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("storeOwnerForm").action = "/storeManagerSystem/storeOwnerEnty";
		document.getElementById("storeOwnerForm").submit();
	}
}
















