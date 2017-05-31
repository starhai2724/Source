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
		remove($scope,id);
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


//function test($scope, path) {
//	var valid = true;
//	if ($scope.nameProductCategory == "") {
//		$scope.nameProductCategory_err = "Vui lòng nhập tên nhóm sản phẩm!"
//		valid = false;
//	}
//	if (true == valid) {
//			document.getElementById("RegisterProductCategory").action = "/storeManagerSystem/fashion";
//			document.getElementById("RegisterProductCategory").method = "POST";
//			document.getElementById("RegisterProductCategory").submit();
//	}
//}

function remove($scope, id){
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



















