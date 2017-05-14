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
	//set init message
	$scope.fullname_err = "";
	$scope.telephone_err = "";
	$scope.username_err = "";
	$scope.email_err = "";
	$scope.password_err = "";
	$scope.repassword_err  = "";
	
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
	}else if(!validateEmail($scope.email)){
		$scope.email_err = "Vui lòng nhập lại email!"
		valid = false;
	}

	if ($scope.password == "") {
		$scope.password_err = "Vui lòng nhập mật khẩu!"
		valid = false;
	}else if($scope.password.length < 6){
		$scope.password_err = "Vui lòng nhập mật khẩu trên 6 kí tự!"; 
			valid = false;
	}else if ($scope.password != $scope.repassword) {
		$scope.repassword_err = "Vui lòng nhập lại mật khẩu xác nhận!";
		$scope.password_err = "";
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
		document.getElementById("registerUser").action = "/storeManagerSystem/";
		document.getElementById("registerUser").submit();
	}
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
















