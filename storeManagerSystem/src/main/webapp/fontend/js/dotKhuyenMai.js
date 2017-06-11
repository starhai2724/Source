var app = angular.module('dotKhuyenMai', []);
app.controller('ctrl', function($scope, $window) {
	document.getElementById("dotKhuyenMai").action = "/storeManagerSystem/dotKhuyenMai";
	document.getElementById("dotKhuyenMai").submit();
});