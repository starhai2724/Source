var app = angular.module('ThoiHanSuDungForm', []);;
app.controller('ctrl', function($scope, $window) {
	$scope.tenWebSite_err = "";
	$scope.sdt_err = "";
	$scope.diaChi_err = "";
	$scope.dkGiaoHangFree_err = "";
	$scope.linkFanpage_err = "";
	
	$scope.btnUpdate = function(){
		update($scope);
	}
	
});

function update($scope) {
	
	var valid = true;
	if ($scope.tenWebSite == "") {
		$scope.tenWebSite_err = "Hãy nhập tên cửa hàng."
		valid = false;
	}
	
	if ($scope.sdt == "" ) {
		$scope.sdt_err = "Hãy nhập Số điện thoại liên hệ."
		valid = false;
	}
	
	if ($scope.diaChi == "") {
		$scope.diaChi_err = "Hãy nhập địa chỉ."
		valid = false;
	}
	
	if ($scope.linkFanpage == "") {
		$scope.linkFanpage_err = "Hãy nhập đường dẫn Fanpage Facebook."
		valid = false;
	}
	
	if (true == valid) {
		if(confirm("Bạn có muốn cập nhật?")){
			document.getElementById("DangKiWebForm").action = "/storeManagerSystem/thongTinCuaHang/update";
			document.getElementById("DangKiWebForm").method = "POST";
			document.getElementById("DangKiWebForm").submit();
		}
	}
}



