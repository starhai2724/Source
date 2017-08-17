var app = angular.module('ThongKeForm', []);;
app.controller('ctrl', function($scope, $window) {

	$scope.btnNgay = function(){
		ngay($scope, $window);
	}
	
	$scope.btnThang = function(){
		thang($scope, $window);
	}
	
	$scope.btnNam = function(){
		nam($scope, $window);
	}
	
	$scope.btnThongKeBieuDo = function(){
		thongKeBieuDo($scope, $window);
	}
	
});


function ngay($scope, $window){
	var url = "/storeManagerSystem/thongKe/ngay";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}

function thang($scope, $window){
	var url = "/storeManagerSystem/thongKe/thang";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}

function nam($scope, $window){
	var url = "/storeManagerSystem/thongKe/nam";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}

function thongKeBieuDo($scope, $window){
	var valid = true;
	var pattern = new RegExp('^[0-9]+$');
	
//	if ($scope.quyBD == "") {
//		alert("Nhập Quý bắt đầu.");
//		return false;
//	}else if($scope.quyBD != "1" && $scope.quyBD != "2" && $scope.quyBD != "3" && $scope.quyBD != "4" ){
//		alert("Quý bắt đầu không hợp lệ.");
//		return false;
//	}
	if ($scope.namBD == "") {
		alert("Nhập Năm bắt đầu.");
		return false;
	}else if(!pattern.test($scope.namBD)){
		alert("Năm bắt đầu không hợp lệ.");
		return false;
	}else if(parseInt($scope.namBD) < 2017 ){
		alert("Năm bắt đầu phải từ 2017.");
		return false;
	}
	
//	if ($scope.quyKT == "") {
//		alert("Nhập Quý kết thúc.");
//		return false;
//	}else if($scope.quyKT != "1" && $scope.quyKT != "2" && $scope.quyKT != "3" && $scope.quyKT != "4" ){
//		alert("Quý kết thúc không hợp lệ.");
//		return false;
//	}
	if ($scope.namKT == "") {
		alert("Nhập Năm kết thúc.");
		return false;
	}else if(!pattern.test($scope.namKT)){
		alert("Năm kết thúc không hợp lệ.");
		return false;
	}else if(parseInt($scope.namKT) < 2017 ){
		alert("Nhập Năm kết thúc phải từ 2017.");
		return false;
	}
//	else if($scope.namKT > year ){
//		alert("Năm kết thúc đang lớn hơn năm hiện tại.");
//		return false;
//	}
	
	if(parseInt($scope.namBD) > parseInt($scope.namKT)){
		alert("Năm bắt đầu đang lớn hơn Năm kết thúc.");
		return false;
	}
//	else if($scope.namBD = $scope.namKT){
//		if($scope.quyBD > $scope.quyKT){
//			alert("Quý bắt đầu đang lớn hơn Quý kết thúc.");
//			return false;
//		}
//	}
	var url = "/storeManagerSystem/thongKe/thongKeBieuDo";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}

