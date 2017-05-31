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
		remove($scope,id);
	}
	
});

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


