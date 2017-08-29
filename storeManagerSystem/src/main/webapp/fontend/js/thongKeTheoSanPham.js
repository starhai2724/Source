var app = angular.module('ThongkeTheoSanPhamForm', []);
app.controller('ctrl', function($scope, $window) {
	
	$scope.btnSearch = function() {
		search($scope)
	}
	
	$scope.btnClear = function(){
		clear($scope);
		
	}
});


function search($scope) {
	document.getElementById("ThongkeTheoSanPhamForm").action = "/storeManagerSystem/thongKe/sanPham/timKiem";
	document.getElementById("ThongkeTheoSanPhamForm").method = "POST";
	document.getElementById("ThongkeTheoSanPhamForm").submit();
}


function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("ThongkeTheoSanPhamForm").action = "/storeManagerSystem/thongKe/sanPham/init";
		document.getElementById("ThongkeTheoSanPhamForm").method = "GET";
		document.getElementById("ThongkeTheoSanPhamForm").submit();
	}
}




