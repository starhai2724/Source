var app = angular.module('KhachHangForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.tenKhachHang_err = "";
	$scope.soDienThoai_err = "";
	$scope.soDiem_err = "";
	
	$scope.btnCreate = function() {
		if($scope.flagUpdate == 1){
			update($scope)
		}else{
			create($scope);
		}
	}
	
	$scope.btnGetById = function(id){
		getById($scope,$window, id);
	}
	
	$scope.btnClear = function(){
//		clear($scope);
//		angular.forEach($scope.test, function(item){
//			alert("item: " + item);
//			// item.value ? 0 : 1;
//		});
		alert($scope.test);
		
	}
	
	$scope.btnDelete = function(id){
		remove($scope, $window,  id);
	}
	
});

function create($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.tenKhachHang == "") {
		$scope.tenKhachHang_err = "Nhập tên khách hàng."
		valid = false;
	}
	if ($scope.soDienThoai == "") {
		$scope.soDienThoai_err = "Nhập giá số điện thoại."
		valid = false;
	}else if(!reg.test($scope.soDienThoai)){
		$scope.soDienThoai_err = "Số điện thoại phải là số."
		valid = false;
	}
	
	if ($scope.soDiem == "") {
		$scope.soDiem_err = "Nhập điểm tích lũy."
		valid = false;
	}else if(!reg.test($scope.soDiem)){
		$scope.soDiem_err = "Điểm tích lũy phải là số."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("KhachHangForm").action = "/storeManagerSystem/customer/insert";
			document.getElementById("KhachHangForm").method = "POST";
			document.getElementById("KhachHangForm").submit();
		}
	}
}

function update($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.tenKhachHang == "") {
		$scope.tenKhachHang_err = "Nhập tên khách hàng."
		valid = false;
	}
	if ($scope.soDienThoai == "") {
		$scope.soDienThoai_err = "Nhập giá số điện thoại."
		valid = false;
	}else if(!reg.test($scope.soDienThoai)){
		$scope.soDienThoai_err = "Số điện thoại phải là số."
		valid = false;
	}
	
	if ($scope.soDiem == "") {
		$scope.soDiem_err = "Nhập điểm tích lũy."
		valid = false;
	}else if(!reg.test($scope.soDiem)){
		$scope.soDiem_err = "Điểm tích lũy phải là số."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("KhachHangForm").action = "/storeManagerSystem/customer/update";
			document.getElementById("KhachHangForm").method = "POST";
			document.getElementById("KhachHangForm").submit();
		}
	}
}

function getById($scope, $windown, id){
		var url = "/storeManagerSystem/customer/getById/"+id;
		document.getElementById("KhachHangForm").action = url;
		document.getElementById("KhachHangForm").method = "POST";
		document.getElementById("KhachHangForm").submit();
}

function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("KhachHangForm").action = "/storeManagerSystem/customer/init";
		document.getElementById("KhachHangForm").method = "POST";
		document.getElementById("KhachHangForm").submit();
	}
}


function remove($scope, $window, id){
	if(confirm("Bạn có muốn xóa?")){
		var url = "/storeManagerSystem/customer/delete/"+id;
		document.getElementById("KhachHangForm").action = url;
		document.getElementById("KhachHangForm").method = "POST";
		document.getElementById("KhachHangForm").submit();
	}
}


