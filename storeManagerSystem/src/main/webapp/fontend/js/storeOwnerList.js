var app = angular.module('storeOwnerList', []);
//app.controller('ctrl', function($scope, $window) {
//	$scope.btnSearch = function() {
//		search($scope);
//	}
//	$scope.btnAppend = function() {
//		append($scope);
//	}
//	
//	$scope.btnUpdate = function(id){
//		update($scope,$window, id);
//	}
//	$scope.btnClear = function(){
//		clear($scope);
//	}
//	$scope.btnDelete = function(id){
//		remove($scope, $window, id);
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
.controller('ctrl',function(Excel,$timeout,$scope){
 
	$scope.exportToExcel=function(tableId){ // ex: '#my-table'
       var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
       $timeout(function(){location.href=exportHref;},100); // trigger download
   }
	
	$scope.btnSearch = function() {
		search($scope);
	}
	$scope.btnAppend = function() {
		append($scope);
	}
	
	$scope.btnUpdate = function(id){
		update($scope,$window, id);
	}
	$scope.btnClear = function(){
		clear($scope);
	}
	$scope.btnDelete = function(id){
		remove($scope, $window, id);
	}
	
});
//export Excel (S)	

function search($scope) {
		document.getElementById("storeOwnerList").action = "/storeManagerSystem/storeOwnerSearch";
		document.getElementById("storeOwnerList").submit();
}

function append($scope){
	document.getElementById("storeOwnerList").action = "/storeManagerSystem/storeOwnerEnty";
	document.getElementById("storeOwnerList").submit();
}


function update($scope,$window, id){
	var url = "/storeManagerSystem/getStoreOwnerListById/"+id;
	document.getElementById("storeOwnerList").action = url;
	document.getElementById("storeOwnerList").method = "POST";
	document.getElementById("storeOwnerList").submit();
	
}


function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("storeOwnerList").action = "/storeManagerSystem/storeOwnerList";
		document.getElementById("storeOwnerList").submit();
	}
}

function remove($scope, $window, id){
	if(confirm("Bạn có muốn xóa không?")){
		var url = "/storeManagerSystem/getIdStoreOwnerForDelete/"+id;
		document.getElementById("storeOwnerList").action = url;
		document.getElementById("storeOwnerList").method = "POST";
		document.getElementById("storeOwnerList").submit();
	}
}