var app = angular.module('HoaDonForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.idKhachHang_err = "";
	$scope.ngayLap_err = "";
	$scope.soLuongSP_err = "";
	$scope.diemTichLuy_err = "";
	$scope.tienKhuyenMai_err = "";
	$scope.tongDiemTichLuy_err = "";
	$scope.tongTien_err = "";
	
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
		clear($scope);
	}
	
	$scope.btnDelete = function(id){
		remove($scope,id);
	}
	
});



function create($scope) {
	
	$scope.idKhachHang_err = "";
	$scope.ngayLap_err = "";
	$scope.soLuongSP_err = "";
	$scope.diemTichLuy_err = "";
	$scope.tienKhuyenMai_err = "";
	$scope.tongDiemTichLuy_err = "";
	$scope.tongTien_err = "";
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.idKhachHang == "") {
		$scope.idKhachHang_err = "Nhập Mã khách hàng."
		valid = false;
	}
	if ($scope.ngayLap == "") {
		$scope.ngayLap_err = "Nhập Ngày lập."
		valid = false;
	}
	
	if ($scope.soLuongSP == "") {
		$scope.soLuongSP_err = "Nhập Số lượng sản phẩm."
			valid = false;
	}else if(!reg.test($scope.soLuongSP)){
		$scope.giaMua_err = "Số lượng sản phẩm phải là số."
			valid = false;
	}
	
	if ($scope.giaBan == "") {
		$scope.giaBan_err = "Nhập giá bán"
		valid = false;
	}else if(!reg.test($scope.giaBan)){
		$scope.giaBan_err = "Giá bán phải là số."
		valid = false;
	}
	
	if ($scope.moTa == "") {
		$scope.moTa_err = "Nhập mô tả sản phẩm."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("ProductForm").action = "/storeManagerSystem/product/insert";
			document.getElementById("ProductForm").method = "POST";
			document.getElementById("ProductForm").submit();
		}
	}
}

function update($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.tenSP == "") {
		$scope.tenSP_err = "Nhập tên sản phẩm."
		valid = false;
	}
	if ($scope.giaMua == "") {
		$scope.giaMua_err = "Nhập giá mua."
		valid = false;
	}else if(!reg.test($scope.giaMua)){
		$scope.giaMua_err = "Giá mua phải là số."
		valid = false;
	}
	
	if ($scope.giaBan == "") {
		$scope.giaBan_err = "Nhập giá bán"
		valid = false;
	}else if(!reg.test($scope.giaBan)){
		$scope.giaBan_err = "Giá bán phải là số."
		valid = false;
	}
	
	if ($scope.moTa == "") {
		$scope.moTa_err = "Nhập mô tả sản phẩm."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("ProductForm").action = "/storeManagerSystem/product/update";
			document.getElementById("ProductForm").method = "POST";
			document.getElementById("ProductForm").submit();
		}
	}
}

function getById($scope, $windown, id){
		var url = "/storeManagerSystem/bill/getById/"+id;
		document.getElementById("HoaDonForm").action = url;
		document.getElementById("HoaDonForm").method = "POST";
		document.getElementById("HoaDonForm").submit();
}

function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("ProductForm").action = "/storeManagerSystem/product/init";
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
	}
}


function remove($scope, $windown, id){
	if(confirm("Bạn có muốn xóa?")){
		var url = "/storeManagerSystem/product/delete/"+id;
		document.getElementById("ProductForm").action = url;
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
	}
}

