var app = angular.module('ProductForm', []);;
app.controller('ctrl', function($scope, $window) {
	$scope.giaBanKM_err = "";
	
	$scope.btnChonSPKM = function() {
		chonSPKM();
	}
	$scope.btnThemDong = function(){
		themDong();
	}
	
	$scope.btnXoaDong = function(){
		xoaDong();
	}
	
	$scope.btnDangKy = function(){
			dangKy($scope);
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

function dangKy($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	 var len = $scope.lst.lenght;
	 
    for (var i=0; i< len; i++) {
    	  if($scope.lst[i].giaBanKM == "") {
    		  $scope.giaBanKM_err = "Hãy nhập giá bán khuyến mãi."
    		  valid = false;
    		  break;
          }
    	  if(!reg.test($scope.lst[i].giaBanKM)){
    			$scope.ngayKT = "Giá bán khuyến mãi phải là số."
    			valid = false;
    			break;
    	  }
      }
    
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/dangKy";
			document.getElementById("ProductForm").method = "POST";
			document.getElementById("ProductForm").submit();
		}
	}

}

