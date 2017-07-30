var app = angular.module('LienHeForm', []);
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
      
		$scope.noiDungTraLoi_err = "";
		
		$scope.btnCreate = function() {
			if($scope.flagUpdate == 1){
				update($scope)
			}
		}
		
		$scope.btnGetById = function(id){
			getById($scope,$window, id);
		}
		
		$scope.btnClear = function(){
			clear($scope);
			
		}
      
    });
//export Excel (S)	


function update($scope) {
	var valid = true;
	if ($scope.noiDungTraLoi == "") {
		$scope.noiDungTraLoi_err = "Nhập nội dung trả lời."
		valid = false;
	}

	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
			document.getElementById("LienHeForm").action = "/storeManagerSystem/lienHe/update";
			document.getElementById("LienHeForm").method = "POST";
			document.getElementById("LienHeForm").submit();
		}
	}
}

function getById($scope, $windown, id){
		var url = "/storeManagerSystem/lienHe/getById/"+id;
		document.getElementById("LienHeForm").action = url;
		document.getElementById("LienHeForm").method = "POST";
		document.getElementById("LienHeForm").submit();
}

function clear($scope){
	if(confirm("Bạn có muốn hủy?")){
		document.getElementById("LienHeForm").action = "/storeManagerSystem/lienHe/init";
		document.getElementById("LienHeForm").method = "POST";
		document.getElementById("LienHeForm").submit();
	}
}




