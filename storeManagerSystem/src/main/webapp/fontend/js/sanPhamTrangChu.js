var app = angular.module('ProductForm', []);;
app.controller('ctrl', function($scope, $window) {
	$scope.giaBanKM_err = "";
	$scope.listCheckBox = "";
	$scope.listCheckBox1 = "";
	$scope.checkboxModel = {
		       value1 : true,
		       value2 : false
		     };
	
	$scope.btnXoaDong = function(){
		xoaDong($scope);
	}
	
	$scope.btnDangKy = function(){
		dangKy($scope);
	}
	
	$scope.btnPhanAnh = function(){
		angular.forEach($scope.selected1, function(item){
			if(item == "false"){
				//Do not thing
			}else{
				$scope.listCheckBox1 = $scope.listCheckBox1 + ","+ item;
			}
		});
		phanAnh($scope);
	}
	
});

function xoaDong($scope) {
	angular.forEach($scope.selected, function(item){
		if(item == "false"){
			//Do not thing
		}else{
			$scope.listCheckBox = $scope.listCheckBox + ","+ item;
		}
	});
	if($scope.listCheckBox != ""){
		document.getElementById("ProductForm").action = "/storeManagerSystem/sanPhamTrangChu/xoaDong/"+$scope.listCheckBox;
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
	}else {
		alert("Chọn sản phẩm để xóa.")
	}
}

function dangKy($scope) {
	
	var valid = true;
	var len = $scope.lstSize;
    if($scope.lstSize > 0){
		if (true == valid) {
			if(confirm("Bạn có muốn đăng ký?")){
				document.getElementById("ProductForm").action = "/storeManagerSystem/sanPhamTrangChu/dangKy";
				document.getElementById("ProductForm").method = "POST";
				document.getElementById("ProductForm").submit();
			}
		}
    }else {
    	alert("Chọn sản phẩm để để đăng kí.")
    }
}

function phanAnh($scope){
	if($scope.listCheckBox1 != ""){
		var url = "/storeManagerSystem/sanPhamTrangChu/phanAnh/"+$scope.listCheckBox1;
	}else{
		var url = "/storeManagerSystem/sanPhamTrangChu/phanAnh/0";
	}
	document.getElementById("ProductForm").action = url;
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
}

