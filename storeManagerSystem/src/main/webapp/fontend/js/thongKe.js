var app = angular.module('ThongKeForm', []);;
app.controller('ctrl', function($scope, $window) {

	$scope.btnNgay = function(){
		ngay($scope);
	}
	
	$scope.btnThang = function(){
		thang($scope);
	}
	
	$scope.btnNam = function(){
		nam($scope);
	}
	
});


function ngay($scope, $windown, id){
	var url = "/storeManagerSystem/thongKe/init";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}
function thang($scope, $windown, id){
	var url = "/storeManagerSystem/thongKe/thang";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}
function nam($scope, $windown, id){
	var url = "/storeManagerSystem/thongKe/nam";
	document.getElementById("ThongKeForm").action = url;
	document.getElementById("ThongKeForm").method = "POST";
	document.getElementById("ThongKeForm").submit();
}
