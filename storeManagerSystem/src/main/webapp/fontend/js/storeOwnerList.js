var app = angular.module('storeOwnerList', []);
app.controller('ctrl', function($scope, $window) {
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