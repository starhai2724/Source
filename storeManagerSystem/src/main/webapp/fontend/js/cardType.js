var app = angular.module('LoaiTheForm', []);
app.controller('ctrl', function($scope, $window) {
	$scope.tenLoaiThe_err = "";
	$scope.diem_err = "";
	
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
	if ($scope.tenLoaiThe == "") {
		$scope.tenLoaiThe_err = "Nhập tên loại thẻ."
		valid = false;
	}
	if ($scope.diem == "") {
		$scope.diem_err = "Nhập điểm."
		valid = false;
	}else if(!reg.test($scope.diem)){
		$scope.diem_err = "Điểm phải là số."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("LoaiTheForm").action = "/storeManagerSystem/cardType/insert";
			document.getElementById("LoaiTheForm").method = "POST";
			document.getElementById("LoaiTheForm").submit();
		}
	}
}

function update($scope) {
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.tenLoaiThe == "") {
		$scope.tenLoaiThe_err = "Nhập tên loại thẻ."
		valid = false;
	}
	if ($scope.diem == "") {
		$scope.diem_err = "Nhập điểm."
		valid = false;
	}else if(!reg.test($scope.diem)){
		$scope.diem_err = "Điểm phải là số."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("LoaiTheForm").action = "/storeManagerSystem/cardType/update";
			document.getElementById("LoaiTheForm").method = "POST";
			document.getElementById("LoaiTheForm").submit();
		}
	}
}

function getById($scope, $windown, id){
		var url = "/storeManagerSystem/cardType/getById/"+id;
		document.getElementById("LoaiTheForm").action = url;
		document.getElementById("LoaiTheForm").method = "POST";
		document.getElementById("LoaiTheForm").submit();
}

function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("LoaiTheForm").action = "/storeManagerSystem/cardType/init";
		document.getElementById("LoaiTheForm").method = "POST";
		document.getElementById("LoaiTheForm").submit();
	}
}


function remove($scope, $windown, id){
	if(confirm("Bạn có muốn xóa?")){
		var url = "/storeManagerSystem/cardType/delete/"+id;
		document.getElementById("LoaiTheForm").action = url;
		document.getElementById("LoaiTheForm").method = "POST";
		document.getElementById("LoaiTheForm").submit();
	}
}


