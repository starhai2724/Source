var app = angular.module('LayoutForm', []);
app.controller('ctrl', function($scope, $window) {
	listProduct = "";
	$scope.cartPrice = 0;
	$scope.cartQuantity = 0;
	$scope.pathJSP = "";
	
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	if(session_price != null && (session_listProduct != null && session_listProduct != "") ){
		$scope.cartPrice = session_price;
		$scope.cartQuantity = session_quantity;
		listProduct = "";
	}
	
	$scope.btnPurchase = function(price, idSanPham){
		purchase($scope,$window ,price, idSanPham);
	}
	
	$scope.btnCart = function(){
		cart($scope,$window);
	}
	
	$scope.btnRemove = function(id, price){
		remove($scope, $window ,id, price);
	}
	
	$scope.btnBuyCart = function(){
		buyCart($scope);
	}
	
});


function purchase($scope,$window ,price, idSanPham){
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	if(session_price != null && session_price != "0"){
		$scope.cartPrice = parseInt(session_price) + parseInt(price);
	}else{
		$scope.cartPrice = parseInt($scope.cartPrice) + parseInt(price);
	}
	
	if(session_listProduct != null && session_listProduct != ""){
		listProduct = session_listProduct +"," +  idSanPham.replace(/^\s+|\s+$/g, '');
		$scope.cartQuantity = parseInt(session_quantity) + 1;
	}else{
		listProduct = "," + idSanPham;
		$scope.cartQuantity = 1;
	}
	
	$window.sessionStorage.setItem('session_price', $scope.cartPrice);
	$window.sessionStorage.setItem('session_listProduct', listProduct);
	$window.sessionStorage.setItem('session_quantity', $scope.cartQuantity);
}

function cart($scope, $window){
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	if(session_listProduct != null && session_listProduct != ""){
		var url = "/storeManagerSystem/" + $scope.pathJSP +"/gioHang/" + session_listProduct;
	}else{
		var url = "/storeManagerSystem/" + $scope.pathJSP +"/gioHang/0";
	}
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function remove($scope, $window, id, price){
	var idProduct = "#sanPham"+id;
	var myEl = angular.element( document.querySelector(idProduct));
	myEl.remove();
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	$scope.cartPrice =  parseInt(session_price) - parseInt(price);
	$scope.cartQuantity= parseInt(session_quantity) - 1;
	listProduct = listProduct.replace("," + id,"");
	
	$window.sessionStorage.setItem('session_price', $scope.cartPrice);
	$window.sessionStorage.setItem('session_listProduct', listProduct);
	$window.sessionStorage.setItem('session_quantity', $scope.cartQuantity);
}

function buyCart($scope, $window){
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	
	$window.sessionStorage.setItem('session_price', $scope.cartPrice);
	$window.sessionStorage.setItem('session_listProduct', listProduct);
	$window.sessionStorage.setItem('session_quantity', $scope.cartQuantity);
	
	if(session_listProduct != null && session_listProduct != ""){
		var url = "/storeManagerSystem/" + $scope.pathJSP +"/thanhToan/" + session_listProduct;
		// Dong y thanh toan
		if(confirm("Bạn đồng ý thanh toán?")){
			//reset gio hang
			$window.sessionStorage.setItem('session_price', "0");
			$window.sessionStorage.setItem('session_listProduct', "");
			$window.sessionStorage.setItem('session_quantity', "0");
			
			document.getElementById("LayoutForm").action = url;
			document.getElementById("LayoutForm").method = "POST";
			document.getElementById("LayoutForm").submit();
		}
	}else{
		alert("Chưa có sản phẩm được chọn để thanh toán.");
	}
}




