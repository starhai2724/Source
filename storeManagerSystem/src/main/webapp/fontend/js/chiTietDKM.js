var app = angular.module('ProductForm', []);;
app.controller('ctrl', function($scope, $window) {
	
	$scope.btnChonSPKM = function() {
		chonSPKM();
	}
	$scope.btnThemDong = function(id){
		themDong();
	}
	
	$scope.btnXoaDong = function(id){
		xoaDong();
	}
	
	$scope.btnDangKy = function(id){
		dangKy();
	}
	
});

function chonSPKM() {
		document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/chonSPKM";
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
}

function themDong() {
	document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/themDong";
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
}

function xoaDong() {
	document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/xoaDong";
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
}

function dangKy() {
	document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/dangKy";
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
}
