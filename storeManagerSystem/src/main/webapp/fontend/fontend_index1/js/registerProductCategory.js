var app = angular.module('RegisterProductCategory', []);
app.controller('ctrl', function($scope, $window) {
	$scope.btnCreate = function(path) {
//			create($scope);
		test($scope, path);
	}
	$scope.btnDelete = function(id){
		remove($scope,id);
	}
	
});

function create($scope) {
	var valid = true;
	if ($scope.nameProductCategory == "") {
		$scope.nameProductCategory_err = "Vui lòng nhập tên nhóm sản phẩm!"
		valid = false;
	}

	if (true == valid) {
			document.getElementById("RegisterProductCategory").action = "/storeManagerSystem/registerProductCategory/insert";
			document.getElementById("RegisterProductCategory").method = "POST";
			document.getElementById("RegisterProductCategory").submit();
	}
}


function test($scope, path) {
	var valid = true;
	if ($scope.nameProductCategory == "") {
		$scope.nameProductCategory_err = "Vui lòng nhập tên nhóm sản phẩm!"
		valid = false;
	}
//	alert("path: "+path);
	if (true == valid) {
			document.getElementById("RegisterProductCategory").action = "/storeManagerSystem/fashion";
			document.getElementById("RegisterProductCategory").method = "POST";
			document.getElementById("RegisterProductCategory").submit();
	}
}

function remove($scope, id){
	if(confirm("Bạn có muốn xóa không?")){
		var url = "/storeManagerSystem/registerProductCategory/delete/"+id;
		document.getElementById("RegisterProductCategory").action = url;
		document.getElementById("RegisterProductCategory").method = "POST";
		document.getElementById("RegisterProductCategory").submit();
	}
}



















