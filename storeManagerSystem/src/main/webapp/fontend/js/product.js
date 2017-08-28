var app = angular.module('ProductForm', []);
//app.controller('ctrl', function($scope, $window) {
//	$scope.idSanPham_err = "";
//	$scope.tenSP_err = "";
//	$scope.giaMua_err = "";
//	$scope.giaBan_err = "";
//	$scope.moTa_err = "";
//	$scope.listCheckBox = "";
//	$scope.checkboxModel = {
//		       value1 : true,
//		       value2 : false
//		     };
//	 
//	$scope.btnCreate = function() {
//		if($scope.flagUpdate == 1){
//			update($scope)
//		}else{
//			create($scope);
//		}
//	}
//	
//	$scope.btnGetProductById = function(id){
//		getProductById($scope,$window, id);
//	}
//	
//	$scope.btnClear = function(){
//		clear($scope);
//	}
//	
//	$scope.btnDelete = function(id){
//		remove($scope, $window, id);
//	}
//	
//	$scope.btnPhanAnh = function(){
//		angular.forEach($scope.selected, function(item){
//			if(item == "false"){
//				//Do not thing
//			}else{
//				$scope.listCheckBox = $scope.listCheckBox + ","+ item;
//			}
//		});
//		phanAnh($scope);
//	}
//	
//});


//export Excel (S)
//Code goes here
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
 .controller('ctrl',function(Excel,$timeout,$scope,$window ){
	 	$scope.idSanPham_err = "";
		$scope.tenSP_err = "";
		$scope.giaMua_err = "";
		$scope.giaBan_err = "";
		$scope.moTa_err = "";
		$scope.listCheckBox = "";
		$scope.checkboxModel = {
			       value1 : true,
			       value2 : false
			     };
		
   $scope.exportToExcel=function(tableId){ // ex: '#my-table'
         var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
         $timeout(function(){location.href=exportHref;},100); // trigger download
     }
   
	 
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
		remove($scope, $window, id);
	}
	
	$scope.btnPhanAnh = function(){
		angular.forEach($scope.selected, function(item){
			if(item == "false"){
				//Do not thing
			}else{
				$scope.listCheckBox = $scope.listCheckBox + ","+ item;
			}
		});
		phanAnh($scope);
	}
   
   
 });
//export Excel (E)	

function create($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	
	var reg_IdSanPham = new RegExp('^[a-zA-Z0-9_]*$');
	
	if ($scope.idSanPham == "") {
		$scope.idSanPham_err = "Nhập Mã sản phẩm."
		valid = false;
	}else if($scope.idSanPham.length < 6){
		$scope.idSanPham_err = "Mã sản phẩm phải từ 6 kí tự trở lên."
		valid = false;
	}else if(!reg_IdSanPham.test($scope.idSanPham)){
		$scope.idSanPham_err = "Mã sản phẩm phải là kí tự 1 byte"
		valid = false;
	}
	
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
	if($scope.listCheckBox != ""){
		var url = "/storeManagerSystem/product/phanAnh/"+$scope.listCheckBox;
	}else{
		var url = "/storeManagerSystem/product/phanAnh/0";
	}
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


function remove($scope, $window, id){
	if(confirm("Bạn có muốn xóa?")){
		var url = "/storeManagerSystem/product/delete/"+id;
		document.getElementById("ProductForm").action = url;
		document.getElementById("ProductForm").method = "POST";
		document.getElementById("ProductForm").submit();
	}
}




