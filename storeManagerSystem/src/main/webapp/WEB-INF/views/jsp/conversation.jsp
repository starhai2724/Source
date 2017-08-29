<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="/storeManagerSystem/view/js/angular.min.js"></script>

	<div ng-app="myApp" ng-controller="myCtrl">

		
		<input class="form-control"  type="text"  name="question" ng-model = "question"/>
		<button type="button" class="btn btn-info" ng-click ="btn()">
			<i class="glyphicon glyphicon-refresh"></i> Submit
		</button>
		<p>Today's welcome message is:</p>
		<h1>{{myWelcome}}</h1>

	</div>

<script>
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.question  ="";
	$scope.btn = function(){
		$http({
			method : 'POST',
			url : 'http://localhost:3000/systembackend/converastion/v1',
			data : { 'message' : 'bye' }
		}).then(function successCallback(response) {
			$scope.myWelcome = response.data.success;
			console.log("res: " + response.data);
		}, function errorCallback(response) {
			$scope.myWelcome = "i don't understand";
		});
	}
	

// 	var config = {
//                headers : {
//                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
//                }
//            }
// 	var url = 'http://localhost:3000/systembackend/converastion/v1'
// 	var data  = 'Hello';
// 	$http.post(url, data, config)
//     .success(function (data, status, headers, config) {
//     	console.log("data.d: " + data.d);
//         $scope.myWelcome =  JSON.parse(data.d).toString();
//     })
//     .error(function (data, status, header, config) {
//         console.log('error');
//     });
	
});
</script>

</body>
</html>