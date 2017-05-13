var app = angular.module('test', []);
app.controller('ctrl', function($scope, $window) {
	
	$scope.btnUpdate = function(id){
		update($scope,$window, id);
	}
	
});




function update($scope,$window, id){
	var url = "/storeManagerSystem/"+id+"/init";
	document.getElementById("test").action = url;
	document.getElementById("test").method = "POST";
	document.getElementById("test").submit();
	
}


