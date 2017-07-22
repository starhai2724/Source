var app = angular.module('DatHangForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.giaNhap_err ="";
	$scope.diaChi_err =""; 
	$scope.listCheckBox = "";
	$scope.checkboxModel = {
		       value1 : true,
		       value2 : false
		     };
	
	$scope.btnGetById = function(id){
		getById($scope,$window, id);
	}
	// sd cho he thong quan ly dat hang (S)
	$scope.btnGetByIdQLDT = function(id){
		getByIdQLDT($scope,$window, id);
	}
	
	$scope.btnXacNhan = function(id){
		xacNhan($scope,$window, id);
	}
	
	$scope.btnTimKiem = function(){
		timKiem($scope);
	}
	$scope.btnHuyQLDT = function(){
		clearQLDT($scope);
	}
	// sd cho he thong quan ly dat hang (E)	
	$scope.btnClear = function(){
		clear($scope);
	}
	
	$scope.btnDelete = function(id){
		remove($scope, $window, id);
	}
	
	$scope.btnChonSP = function(){
		chonSanPham($scope);
	}
	
	
	$scope.btnXoaDong = function(){
		xoaDong($scope);
	}
	
	$scope.btnDangKy = function() {
		if($scope.flagUpdate == 1){
			update($scope);
		}else{
			dangKy($scope);
		}
	}
	
	
	
});

function getById($scope, $window, id){
	var url = "/storeManagerSystem/datHang/getById/"+id;
	document.getElementById("DatHangForm").action = url;
	document.getElementById("DatHangForm").method = "POST";
	document.getElementById("DatHangForm").submit();
}
// sd cho he thong dat hang 
function getByIdQLDT($scope, $window, id){
	var url = "/storeManagerSystem/quanLyDatHang/getById/"+id;
	document.getElementById("DatHangForm").action = url;
	document.getElementById("DatHangForm").method = "POST";
	document.getElementById("DatHangForm").submit();
}

function xacNhan($scope, $window, id){
	var url = "/storeManagerSystem/quanLyDatHang/xacNhan/"+id;
	document.getElementById("DatHangForm").action = url;
	document.getElementById("DatHangForm").method = "POST";
	document.getElementById("DatHangForm").submit();
}

function timKiem($scope){
	var url = "/storeManagerSystem/quanLyDatHang/timkiem";
	document.getElementById("DatHangForm").action = url;
	document.getElementById("DatHangForm").method = "POST";
	document.getElementById("DatHangForm").submit();
}

function clearQLDT($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("DatHangForm").action = "/storeManagerSystem//quanLyDatHang/init";
		document.getElementById("DatHangForm").method = "GET";
		document.getElementById("DatHangForm").submit();
	}
}

function chonSanPham($scope){
		var url = "/storeManagerSystem/datHang/chonSanPham";
		document.getElementById("DatHangForm").action = url;
		document.getElementById("DatHangForm").method = "POST";
		document.getElementById("DatHangForm").submit();
}


function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("DatHangForm").action = "/storeManagerSystem/datHang/init";
		document.getElementById("DatHangForm").method = "GET";
		document.getElementById("DatHangForm").submit();
	}
}

function remove($scope, $window, id){
	if(confirm("Bạn có muốn xóa?")){
		document.getElementById("DatHangForm").action = "/storeManagerSystem/datHang/xoa/"+id;
		document.getElementById("DatHangForm").method = "POST";
		document.getElementById("DatHangForm").submit();
	}
}

function xoaDong($scope) {
	angular.forEach($scope.selected, function(item){
		if(item == "false"){
			//Do not thing
		}else{
			$scope.listCheckBox = $scope.listCheckBox + ","+ item;
		}
	});
	document.getElementById("DatHangForm").action = "/storeManagerSystem/datHang/xoaDong/"+$scope.listCheckBox;
	document.getElementById("DatHangForm").method = "POST";
	document.getElementById("DatHangForm").submit();
}

function dangKy($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	var len = $scope.lstSize;
	 
	 
    for (var i=0; i< len; i++) {
    	  if($scope.chiTietDatHangRowForms[i].diaChi == "") {
    		  $scope.diaChi_err = "Hãy nhập địa chỉ lấy hàng."
    		  valid = false;
    		  break;
          }
      }
    
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("DatHangForm").action = "/storeManagerSystem/datHang/dangKy";
			document.getElementById("DatHangForm").method = "POST";
			document.getElementById("DatHangForm").submit();
		}
	}

}


function update($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	var len = $scope.lstSize;
	 
    for (var i=0; i< len; i++) {
    	  if($scope.chiTietDatHangRowForms[i].diaChi == "") {
    		  $scope.diaChi_err = "Hãy nhập địa chỉ lấy hàng."
    		  valid = false;
    		  break;
          }
      }
    
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("DatHangForm").action = "/storeManagerSystem/datHang/update";
			document.getElementById("DatHangForm").method = "POST";
			document.getElementById("DatHangForm").submit();
		}
	}

}
