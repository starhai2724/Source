var app = angular.module('layoutProcess', []);
app.controller('ctrl', function($scope, $window) {
	document.getElementById("layoutProcess").action = "/storeManagerSystem/layoutProcess";
	document.getElementById("layoutProcess").submit();
});