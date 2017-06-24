var app = angular.module('KhachHangLogin', []);
app.controller('ctrl', function($scope) {
	$scope.btnLogin = function(pathJSP) {
		checkLogin($scope, pathJSP);
	}
});

function checkLogin($scope, pathJSP) {
	var valid = true;
	var url = "/storeManagerSystem/"+pathJSP+"/dangNhap/kiemTra";
	document.getElementById("KhachHangDangNhapForm").action = url;
	document.getElementById("KhachHangDangNhapForm").submit();
}

