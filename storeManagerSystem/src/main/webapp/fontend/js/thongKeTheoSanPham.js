var app = angular.module('TKeForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.btnSearch = function() {
		search($scope)
	}
	$scope.btnClear = function(){
		clear($scope);
	}
	$scope.btnSearchKhachHang = function() {
		searchKhachHang($scope)
	}
	$scope.btnClearKhachHang = function(){
		clearKhachHang($scope);
	}
});

function search($scope) {
	document.getElementById("TKeForm").action = "/storeManagerSystem/thongKe/sanPham/timKiem";
	document.getElementById("TKeForm").method = "POST";
	document.getElementById("TKeForm").submit();
}


function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("TKeForm").action = "/storeManagerSystem/thongKe/sanPham/init";
		document.getElementById("TKeForm").method = "GET";
		document.getElementById("TKeForm").submit();
	}
}

function searchKhachHang($scope) {
	document.getElementById("TKeForm").action = "/storeManagerSystem/thongKe/khachHang/timKiem";
	document.getElementById("TKeForm").method = "POST";
	document.getElementById("TKeForm").submit();
}


function btnClearKhachHang($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("TKeForm").action = "/storeManagerSystem/thongKe/khachHang/init";
		document.getElementById("TKeForm").method = "GET";
		document.getElementById("TKeForm").submit();
	}
}




