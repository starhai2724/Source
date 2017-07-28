var app = angular.module('KhachHangForm', []);
//app.controller('ctrl', function($scope, $window) {
//	$scope.tenKhachHang_err = "";
//	$scope.soDienThoai_err = "";
//	$scope.soDiem_err = "";
//	
//	$scope.btnCreate = function() {
//		if($scope.flagUpdate == 1){
//			update($scope)
//		}else{
//			create($scope);
//		}
//	}
//	
//	$scope.btnGetById = function(id){
//		getById($scope,$window, id);
//	}
//	
//	$scope.btnClear = function(){
//		clear($scope);
//		
//	}
//	$scope.btnDelete = function(id){
//		remove($scope, $window,  id);
//	}
//});

//export Excel (S)
// Code goes here
app.factory('Excel',function($window){
        var uri='data:application/vnd.ms-excel;base64,',
            template='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
            base64=function(s){return $window.btoa(unescape(encodeURIComponent(s)));},
            format=function(s,c){return s.replace(/{(\w+)}/g,function(m,p){return c[p];})};
        return {
            tableToExcel:function(tableId,worksheetName){
                var table=$(tableId),
                    ctx={worksheet:worksheetName,table:table.html()},
                    href=uri+base64(format(template,ctx));
                return href;
            }
        };
    })
    .controller('ctrl',function(Excel,$timeout,$scope,$window){
    	
    	// function export excel (S)
      $scope.exportToExcel=function(tableId){ // ex: '#my-table'
            var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
            $timeout(function(){location.href=exportHref;},100); // trigger download
        }
      	// function export excel (E)
      
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
			clear($scope);
			
		}
		
		$scope.btnDelete = function(id){
			remove($scope, $window,  id);
		}
      
    });
//export Excel (S)	

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


