var app = angular.module('RegisterProductCategory', []);
app.controller('ctrl', function($scope, $window) {
	$scope.nameProductCategory_err = "";
	
	$scope.btnCreate = function() {
		if($scope.flagUpdate == 1){
			update($scope)	
		}else{
			create($scope);
		}
	}
	$scope.btnGetById = function(id) {
		getById($scope, id);
	}
	$scope.btnDelete = function(id){
		remove($scope, $window, id);
	}
	
	$scope.btnDetail = function(id){
		showDetail($scope, $window, id);
	}
	
	$scope.btnThemDong  = function(){
		themDong($scope);
	}
	
	$scope.btnDangKyLSP  = function(){
		dangKyLSP($scope);
	}
	
	$scope.btnDelete_LSP  = function(no){
		deleteLSP($scope, $window, no);
	}
	
	$scope.btnGetById_LSP = function(id) {
		getByIdLSP($scope, id);
	}
			
			
	
});

function create($scope) {
	var valid = true;
	if ($scope.nameProductCategory == "") {
		$scope.nameProductCategory_err = "Nhập tên nhóm sản phẩm."
		valid = false;
	}

	if (true == valid) {
			document.getElementById("RegisterProductCategory").action = "/storeManagerSystem/registerProductCategory/insert";
			document.getElementById("RegisterProductCategory").method = "POST";
			document.getElementById("RegisterProductCategory").submit();
	}
}

function showDetail($scope, $window, id){
		var url = "/storeManagerSystem/registerProductCategory/showDetail/"+id;
		document.getElementById("RegisterProductCategory").action = url;
		document.getElementById("RegisterProductCategory").method = "POST";
		document.getElementById("RegisterProductCategory").submit();
}


function deleteLSP($scope, $window, no){
	var url = "/storeManagerSystem/registerProductCategory/deleteLSP/"+no;
	document.getElementById("RegisterProductCategory").action = url;
	document.getElementById("RegisterProductCategory").method = "POST";
	document.getElementById("RegisterProductCategory").submit();
}

function themDong($scope){
	var url = "/storeManagerSystem/registerProductCategory/themDong";
	document.getElementById("RegisterProductCategory").action = url;
	document.getElementById("RegisterProductCategory").method = "POST";
	document.getElementById("RegisterProductCategory").submit();
}


function dangKyLSP($scope){
	var url = "/storeManagerSystem/registerProductCategory/dangKyLSP";
	document.getElementById("RegisterProductCategory").action = url;
	document.getElementById("RegisterProductCategory").method = "POST";
	document.getElementById("RegisterProductCategory").submit();
}

function update($scope) {
	var valid = true;
	if ($scope.nameProductCategory == "") {
		$scope.nameProductCategory_err = "Nhập tên nhóm sản phẩm."
			valid = false;
	}
	
	if (true == valid) {
		document.getElementById("RegisterProductCategory").action = "/storeManagerSystem/registerProductCategory/update";
		document.getElementById("RegisterProductCategory").method = "POST";
		document.getElementById("RegisterProductCategory").submit();
	}
}

function remove($scope, $window, id){
	if(confirm("Bạn có muốn xóa không?")){
		var url = "/storeManagerSystem/registerProductCategory/delete/"+id;
		document.getElementById("RegisterProductCategory").action = url;
		document.getElementById("RegisterProductCategory").method = "POST";
		document.getElementById("RegisterProductCategory").submit();
	}
}

function getById($scope, id){
		var url = "/storeManagerSystem/registerProductCategory/getById/"+id;
		document.getElementById("RegisterProductCategory").action = url;
		document.getElementById("RegisterProductCategory").method = "POST";
		document.getElementById("RegisterProductCategory").submit();
}

function getByIdLSP($scope, id){
	var url = "/storeManagerSystem/registerProductCategory/getByIdLSP/"+id;
	document.getElementById("RegisterProductCategory").action = url;
	document.getElementById("RegisterProductCategory").method = "POST";
	document.getElementById("RegisterProductCategory").submit();
}



















