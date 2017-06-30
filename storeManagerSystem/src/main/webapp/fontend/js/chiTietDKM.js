var app = angular.module('ProductForm', []);;
app.controller('ctrl', function($scope, $window) {
	$scope.giaBanKM_err = "";
	
	$scope.listCheckBox = "";
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

function xoaDong($scope) {
	angular.forEach($scope.selected, function(item){
		if(item == "false"){
			//Do not thing
		}else{
			$scope.listCheckBox = $scope.listCheckBox + ","+ item;
			alert("listCheckBox: "+ $scope.listCheckBox);
		}
	});
	document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/xoaDong/"+$scope.listCheckBox;
	document.getElementById("ProductForm").method = "POST";
	document.getElementById("ProductForm").submit();
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
    
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("ProductForm").action = "/storeManagerSystem/chiTietDKM/dangKy";
			document.getElementById("ProductForm").method = "POST";
			document.getElementById("ProductForm").submit();
		}
	}

}

