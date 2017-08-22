var app = angular.module('ProductForm', []);;
app.controller('ctrl', function($scope, $window) {
	$scope.giaBanKM_err = "";
	$scope.listCheckBox = "";
	$scope.listCheckBox1 = "";
	$scope.checkboxModel = {
		       value1 : true,
		       value2 : false
		     };
	$scope.btnChonSPKM = function() {
		chonSPKM();
	}
	$scope.btnThemDong = function(){
		themDong();
	}
	
	$scope.btnXoaDong = function(){
		xoaDong($scope);
	}
	
	$scope.btnDangKy = function(){
		dangKy($scope);
	}
	
	$scope.btnQuayVe = function(){
		quayVe($scope);
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

function chonSPKM() {
		document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/chonSPKM";
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
}

function quayVe() {
	document.getElementById("ProductForm").action = "/storeManagerSystem/dotKhuyenMai/init";
	document.getElementById("ProductForm").method = "GET";
	document.getElementById("ProductForm").submit();
}

function themDong() {
	document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/themDong";
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
}

function xoaDong($scope) {
	angular.forEach($scope.selected, function(item){
		if(item == "false"){
			//Do not thing
		}else{
			$scope.listCheckBox = $scope.listCheckBox + ","+ item;
		}
	});
	if($scope.listCheckBox != ""){
		document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/xoaDong/"+$scope.listCheckBox;
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
	}else {
		alert("Chọn sản phẩm để xóa.")
	}
}

function dangKy($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	var len = $scope.lstSize;
	 
    for (var i=0; i< len; i++) {
    	  if($scope.lst[i].giaBanKM == "") {
    		  $scope.giaBanKM_err = "Hãy nhập giá bán khuyến mãi."
    		  valid = false;
    		  break;
          }
    	  if(!reg.test($scope.lst[i].giaBanKM)){
    			$scope.giaBanKM_err = "Giá bán khuyến mãi phải là số."
    			valid = false;
    			break;
    	  }
      }
    if($scope.lstSize > 0){
		if (true == valid) {
			if(confirm("Bạn có muốn đăng ký?")){
				document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/dangKy";
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
		var url = "/storeManagerSystem/product/phanAnh/"+$scope.listCheckBox1;
	}else{
		var url = "/storeManagerSystem/product/phanAnh/0";
	}
	document.getElementById("ProductForm").action = url;
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
}

