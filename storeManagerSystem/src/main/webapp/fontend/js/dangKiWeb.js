var app = angular.module('DangKiWebForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.tenWebSite_err = "";
	$scope.email_err = "";
	$scope.matKhau_err = "";
	$scope.nhapMatKhau_err = "";
	
	$scope.pathJSP_err = "";
	$scope.diaChi_err = "";
	$scope.sdt_err = "";
	$scope.maXacNhan_err = "";
	
//	$scope.btnCreate = function(pathJSP) {
//			create($scope, pathJSP);
//	}
	
	$scope.btnOpenStep2 = function(){
		openStep2($scope);
	}
	
	$scope.btnOpenStep3 = function(idTemplate){
		openStep3($scope, $window, idTemplate);
	}
	
	$scope.btnTaoWeb = function(){
		taoWeb($scope);
	}
	
	
	
});


function openStep2($scope){
	$scope.tenWebSite_err = "";
	$scope.email_err = "";
	$scope.matKhau_err = "";
	$scope.nhapMatKhau_err = "";
	
	var valid = true;
	
	if ($scope.tenWebSite == "") {
		$scope.tenWebSite_err = "Nhập Tên Website."
		valid = false;
	}
	
	if ($scope.email == "") {
		$scope.email_err = "Nhập Email."
			valid = false;
	}
	
	if ($scope.matKhau == "") {
		$scope.matKhau_err = "Vui lòng nhập mật khẩu!"
		valid = false;
	}else if($scope.matKhau.length < 6){
		$scope.matKhau_err = "Vui lòng nhập mật khẩu trên 6 kí tự!"; 
		valid = false;
	}else if ($scope.matKhau != $scope.nhapMatKhau) {
		$scope.nhapMatKhau_err = "Vui lòng nhập lại mật khẩu xác nhận!";
		$scope.matKhau_err = "";
		valid = false;
	}
	
	if (true == valid) {
		var url = "/storeManagerSystem/buoc2"
		document.getElementById("DangKiWebForm").action = url;
		document.getElementById("DangKiWebForm").method = "POST";
		document.getElementById("DangKiWebForm").submit();
	}
	
}

function openStep3($scope, $window, idTemplate){
	var url = "/storeManagerSystem/buoc3/"+idTemplate;
	document.getElementById("DangKiWebForm").action = url;
	document.getElementById("DangKiWebForm").method = "POST";
	document.getElementById("DangKiWebForm").submit();
}

function taoWeb($scope){
	
	var valid = true;
	var reg_IdSanPham = new RegExp('^[a-zA-Z0-9_]*$');
	if ($scope.pathJSP == ""){
		$scope.pathJSP_err = "Nhập địa chỉ website."
		valid = false;
	}else if(!reg_IdSanPham.test($scope.pathJSP)){
		$scope.pathJSP_err = "Địa chỉ website chỉ chứa kí tự 1 byte."
		valid = false;
	}
	
	if ($scope.diaChi == "") {
		$scope.diaChi_err = "Nhập địa chỉ."
		valid = false;
	}
	if ($scope.sdt == "") {
		$scope.sdt_err = "Nhập số điện thoại đăng kí."
		valid = false;
	}
	if ($scope.maXacNhan == "") {
		$scope.maXacNhan_err = "Nhập mã xác nhận."
		valid = false;
	}else if($scope.maXacNhan != '4R3A'){
		$scope.maXacNhan_err = "Nhập lại mã xác nhận."
		valid = false;
	}
	
	if (true == valid) {
		var url = "/storeManagerSystem/taoWeb";
		document.getElementById("DangKiWebForm").action = url;
		document.getElementById("DangKiWebForm").method = "POST";
		document.getElementById("DangKiWebForm").submit();
	}
	
}



