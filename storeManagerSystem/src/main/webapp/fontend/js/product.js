var app = angular.module('ProductForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.tenSP_err = "";
	$scope.giaMua_err = "";
	$scope.giaBan_err = "";
	$scope.moTa_err = "";
	$scope.listCheckBox = "";
	 $scope.checkboxModel = {
		       value1 : true,
		       value2 : false
		     };
	 
	$scope.btnCreate = function() {
		if($scope.flagUpdate == 1){
			update($scope)
		}else{
			create($scope);
		}
	}
	
	$scope.btnGetProductById = function(id){
		getProductById($scope,$window, id);
	}
	
	$scope.btnClear = function(){
		clear($scope);
	}
	
	$scope.btnDelete = function(id){
		remove($scope,id);
	}
	
	$scope.btnPhanAnh = function(){
		angular.forEach($scope.selected, function(item){
			if(item == "false"){
				//Do not thing
			}else{
				$scope.listCheckBox += item;
				alert("listCheckBox: "+ $scope.listCheckBox);
			}
		    // item.value ? 0 : 1;
		});
//		phanAnh($scope);
	}
	
	
});

function create($scope) {
	
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

function phanAnh($scope){
		var url = "/storeManagerSystem/product/phanAnh";
		document.getElementById("ProductForm").action = url;
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
}

function getProductById($scope, $windown, id){
	var url = "/storeManagerSystem/product/getProductById/"+id;
	document.getElementById("ProductForm").action = url;
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
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


