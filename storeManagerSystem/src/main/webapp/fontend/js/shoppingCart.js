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
	
	$scope.btnPurchase = function(price, priceSaleOff, idSanPham){
		purchase($scope, $window , price, priceSaleOff, idSanPham);
	}
	
	$scope.btnCart = function(){
		cart($scope,$window);
	}
	
	$scope.btnRemove = function(id, price, priceSaleOff){
		remove($scope, $window ,id, price, priceSaleOff);
	}
	
	$scope.btnBuyCart = function(){
		buyCart($scope, $window);
	}
	
});


function purchase($scope,$window ,price, priceSaleOff, idSanPham){
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	
	if(session_price != null && session_price != "0"){
		if(priceSaleOff != ""){
			$scope.cartPrice = parseInt(session_price) + parseInt(priceSaleOff);
		}else{
			$scope.cartPrice = parseInt(session_price) + parseInt(price);
		}
	}else{
		if(priceSaleOff != ""){
			$scope.cartPrice = parseInt($scope.cartPrice) + parseInt(priceSaleOff);
		}else{
			$scope.cartPrice = parseInt($scope.cartPrice) + parseInt(price);
		}
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

function remove($scope, $window, id, price, priceSaleOff){
	
	$scope.soLuong[id] = parseInt($scope.soLuong[id]) - 1;
	
	if($scope.soLuong[id] == 0 || $scope.soLuong[id] < 0){
		var idProduct = "#sanPham"+id;
		var myEl = angular.element( document.querySelector(idProduct));
		myEl.remove();
	}
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	
	
	
	if(priceSaleOff != ""){
		$scope.cartPrice =  parseInt(session_price) - parseInt(priceSaleOff);
	}else{
		$scope.cartPrice =  parseInt(session_price) - parseInt(price);
	}
	$scope.cartQuantity= parseInt(session_quantity) - 1;
	listProduct = listProduct.replace("," + id,"");
	
	$window.sessionStorage.setItem('session_price', $scope.cartPrice);
	$window.sessionStorage.setItem('session_listProduct', listProduct);
	$window.sessionStorage.setItem('session_quantity', $scope.cartQuantity);
}

function buyCart($scope, $window){
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if($scope.checkDangNhap == 1){
		if ($scope.sdtKhachHang == "") {
			$scope.sdtKhachHang_err = "Nhập số điện thoại."
				valid = false;
		}else if(!reg.test($scope.sdtKhachHang)){
			$scope.sdtKhachHang_err = "Số điện thoại phải là số."
				valid = false;
		}
	}
	
	if(valid == true){
		var session_price = $window.sessionStorage.getItem('session_price');
		var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
		var session_quantity = $window.sessionStorage.getItem('session_quantity');
		
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
}




