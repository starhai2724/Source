var app = angular.module('dangKyTaiKhoanForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.tenKhachHang_err = "";
	$scope.sdt_err = "";
	$scope.password_err = "";
	$scope.rePassword_err = "";
	$scope.ngaySinh_err = "";
	
	$scope.btnCreate = function(pathJSP) {
			create($scope, pathJSP);
	}
	
//	$scope.btnBack= function(pathJSP) {
//		back($scope, pathJSP);
//	}
	
});

function create($scope, pathJSP) {
	$scope.tenKhachHang_err = "";
	$scope.sdt_err = "";
	$scope.password_err = "";
	$scope.rePassword_err = "";
	$scope.ngaySinh_err = "";
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	if ($scope.tenKhachHang == "") {
		$scope.tenKhachHang_err = "Nhập tên"
		valid = false;
	}
	
	if ($scope.sdt == "") {
		$scope.sdt_err = "Nhập giá số điện thoại."
		valid = false;
	}else if($scope.sdt.length < 10){
		$scope.sdt_err = "Số điện thoại không chính xác."
	}else if(!reg.test($scope.sdt)){
		$scope.sdt_err = "Số điện thoại phải là số."
		valid = false;
	}
	
	if ($scope.ngaySinh == "") {
		$scope.ngaySinh_err = "Nhập ngày sinh"
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
		var url = "/storeManagerSystem/"+ pathJSP+ "/dangkitaikhoan/dangki"
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("dangKyTaiKhoanForm").action = url;
			document.getElementById("dangKyTaiKhoanForm").method = "POST";
			document.getElementById("dangKyTaiKhoanForm").submit();
		}
	}
}

//function back($scope, pathJSP) {
//	if (true == valid) {
//		var url = "/storeManagerSystem/"+ pathJSP
//		if(confirm("Bạn có muốn đăng ký?")){
//			document.getElementById("dangKyTaiKhoanForm").action = url;
//			document.getElementById("dangKyTaiKhoanForm").method = "POST";
//			document.getElementById("dangKyTaiKhoanForm").submit();
//		}
//	}
//}


