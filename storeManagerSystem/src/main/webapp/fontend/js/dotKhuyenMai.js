var app = angular.module('DotKhuyenMaiForm', []);;
app.controller('ctrl', function($scope, $window) {
	$scope.tenDKM_err = "";
	$scope.loaiKM_err = "";
	$scope.mucKM_err = "";
	$scope.ngayBD_err = "";
	$scope.ngayKT_err = "";
	$scope.dk_loaiThe_err = "";
	$scope.dk_tongHD_err = "";
	$scope.dk_tongSL_err = "";
	$scope.moTa_err = "";
	
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
	
	$scope.btnDetail = function(id){
		showDetail($scope,$window, id);
	}
	
	$scope.btnClear = function(){
		clear($scope);
	}
	
	$scope.btnDelete = function(id){
		remove($scope, $window, id);
	}
	
});

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
.controller('ctrl',function(Excel,$timeout,$scope){
 $scope.exportToExcel=function(tableId){ // ex: '#my-table'
       var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
       $timeout(function(){location.href=exportHref;},100); // trigger download
   }
});
//export Excel (S)	

function create($scope) {
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.tenDKM == "") {
		$scope.tenDKM_err = "Hãy nhập tên đợt khuyến mãi."
		valid = false;
	}
	
	if ($scope.loaiKM == "" || $scope.loaiKM == "00") {
		$scope.loaiKM_err = "Hãy chọn loại KM."
		valid = false;
	}
	
	if ($scope.ngayKT == "") {
		$scope.ngayKT_err = "Hãy nhập ngày kết thúc khuyến mãi."
		valid = false;
	}else if(!reg.test($scope.mucKM)){
		$scope.ngayKT = "Ngày kết thúc khuyến mãi phải là số."
		valid = false;
	}
	
	if ($scope.ngayBD == "") {
		$scope.ngayBD_err =  "Hãy nhập ngày bắt đầu khuyến mãi."
		valid = false;
	}else if(!reg.test($scope.mucKM)){
		$scope.ngayBD_err =  "Hãy nhập ngày bắt đầu khuyến mãi."
		valid = false;
	}
	
	if ($scope.mucKM == "" && $scope.donViKM != "00") {
		$scope.mucKM_err = "Hãy nhập mức giảm giá."
		valid = false;
	}else if($scope.mucKM != "" && $scope.donViKM == "00") {
		$scope.mucKM_err = "Hãy nhập đơn vị khuyến mãi."
			valid = false;
	}else if($scope.mucKM == "" && $scope.moTa == ""){
			$scope.mucKM_err = "Hãy nhập mức giảm giá hoặc chi tiết giảm giá."
			valid = false;
	}
	
	if($scope.mucKM != "" && !reg.test($scope.mucKM)){
		$scope.mucKM_err = "Mức giảm giá phải là số."
		valid = false;
	}
	
	
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("DotKhuyenMaiForm").action = "/storeManagerSystem/dotKhuyenMai/insert";
			document.getElementById("DotKhuyenMaiForm").method = "POST";
			document.getElementById("DotKhuyenMaiForm").submit();
		}
	}
}

function update($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.tenDKM == "") {
		$scope.tenDKM_err = "Hãy nhập tên đợt khuyến mãi."
		valid = false;
	}

	if ($scope.mucKM == "" && $scope.donViKM != "00") {
		$scope.mucKM_err = "Hãy nhập mức giảm giá."
		valid = false;
	}else if($scope.mucKM != "" && $scope.donViKM == "00") {
		$scope.mucKM_err = "Hãy nhập đơn vị khuyến mãi."
			valid = false;
	}else{
		if($scope.mucKM == "" && $scope.moTa == ""){
			$scope.mucKM_err = "Hãy nhập mức giảm giá hoặc chi tiết giảm giá."
			valid = false;
		}
	}
	
	if($scope.mucKM != "" && !reg.test($scope.mucKM)){
		$scope.mucKM_err = "Mức giảm giá phải là số."
		valid = false;
	}
	
	if ($scope.loaiKM == "" || $scope.loaiKM == "00") {
		$scope.loaiKM_err = "Hãy chọn loại KM."
		valid = false;
	}
	
	
	if ($scope.ngayKT == "") {
		$scope.ngayKT_err = "Hãy nhập ngày kết thúc khuyến mãi."
		valid = false;
	}else if(!reg.test($scope.mucKM)){
		$scope.ngayKT = "Ngày kết thúc khuyến mãi phải là số."
		valid = false;
	}
	
	if ($scope.ngayBD == "") {
		$scope.ngayBD_err =  "Hãy nhập ngày bắt đầu khuyến mãi."
		valid = false;
	}else if(!reg.test($scope.mucKM)){
		$scope.ngayBD_err =  "Hãy nhập ngày bắt đầu khuyến mãi."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("DotKhuyenMaiForm").action = "/storeManagerSystem/dotKhuyenMai/update";
			document.getElementById("DotKhuyenMaiForm").method = "POST";
			document.getElementById("DotKhuyenMaiForm").submit();
		}
	}
}

function getById($scope, $windown, id){
		var url = "/storeManagerSystem/dotKhuyenMai/getById/"+id;
		document.getElementById("DotKhuyenMaiForm").action = url;
		document.getElementById("DotKhuyenMaiForm").method = "POST";
		document.getElementById("DotKhuyenMaiForm").submit();
}

function showDetail($scope, $windown, id){
	var url = "/storeManagerSystem/dotKhuyenMai/showDetail/"+id;
	document.getElementById("DotKhuyenMaiForm").action = url;
	document.getElementById("DotKhuyenMaiForm").method = "POST";
	document.getElementById("DotKhuyenMaiForm").submit();
}

function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("DotKhuyenMaiForm").action = "/storeManagerSystem/dotKhuyenMai/init";
		document.getElementById("DotKhuyenMaiForm").method = "POST";
		document.getElementById("DotKhuyenMaiForm").submit();
	}
}


function remove($scope, $window, id){
	if(confirm("Bạn có muốn xóa?")){
		var url = "/storeManagerSystem/dotKhuyenMai/delete/" + id;
		document.getElementById("DotKhuyenMaiForm").action = url;
		document.getElementById("DotKhuyenMaiForm").method = "POST";
		document.getElementById("DotKhuyenMaiForm").submit();
	}
}


