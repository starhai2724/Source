var app = angular.module('storeOwnerList', []);
app.controller('ctrl', function($scope) {
	$scope.btnSearch = function() {
		search($scope);
	}
});

function search($scope) {
		document.getElementById("storeOwnerList").submit();
}
