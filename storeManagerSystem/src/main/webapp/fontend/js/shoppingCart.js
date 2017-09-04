var app = angular.module('LayoutForm', []);
app.controller('ctrl', function($scope, $window) {
	listProduct = "";
	$scope.cartPrice = 0;
	$scope.cartQuantity = 0;
	$scope.pathJSP = "";
	$scope.InputQuantity = "";
	
	// lien he (S)
	$scope.LH_Name_err           = "";
	$scope.LH_Address_err        = "";
	$scope.LH_Email_err          = "";
	$scope.LH_Phone_err          = "";
	$scope.LH_Title_err          = "";
	$scope.LH_noiDungNhan_err    = "";
	// lien he (E)
	
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	if(session_price != null && (session_listProduct != null && session_listProduct != "") ){
		$scope.cartPrice = session_price;
		$scope.cartQuantity = session_quantity;
		listProduct = "";
	}
	
	$scope.btnTimKiem = function(){
		timKiem($scope);
	}
	
	$scope.btnPurchase = function(price, priceSaleOff, idSanPham){
		purchase($scope, $window , price, priceSaleOff, idSanPham);
	}
	
	$scope.chiTiet = function(idSanPham){
		chiTiet($scope, $window ,idSanPham);
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
	
	$scope.btnLienHe = function(){
		lienHe($scope);
	}
	
	$scope.btnTinTuc = function(){
		tinTuc($scope);
	}
	
	$scope.btnGioiThieu = function(){
		gioiThieu($scope);
	}
	
	$scope.btnHuongDan = function(){
		huongDan($scope);
	}
	
	$scope.btnSearchByMenu = function(idLoaiSp){
		searchByMenu($scope,idLoaiSp);
	}
	
	$scope.btnBack = function(){
		back($scope);
		
	}	
	$scope.btnTimKiemMenu = function(id){
		timKiemMenu($scope, $window ,id);
	}
	
	//Lien he (S)
	$scope.btnDangKiLienHe = function(){
		dangKiLienHe($scope);
	}
	
	//Lien he (E)
	
	//Phan trang(S)
	
	$scope.btnPhanTrang = function(id){
		phanTrang($scope, $window ,id);
	}
	
	//Phan trang(E)
	
});


function purchase($scope,$window ,price, priceSaleOff, idSanPham){
	var session_price = $window.sessionStorage.getItem('session_price');
	var session_listProduct = $window.sessionStorage.getItem('session_listProduct');
	var session_quantity = $window.sessionStorage.getItem('session_quantity');
	
	var listProductTMP = "";
	
	if(session_price != null && session_price != "0"){
		if($scope.InputQuantity != null && $scope.InputQuantity != ""){
			if(priceSaleOff != ""){
				$scope.cartPrice = parseFloat(session_price) + parseFloat(priceSaleOff)*parseInt($scope.InputQuantity);
			}else{
				$scope.cartPrice = parseFloat(session_price) + parseFloat(price)*parseInt($scope.InputQuantity);
			}
		}else{
			if(priceSaleOff != ""){
				$scope.cartPrice = parseFloat(session_price) + parseFloat(priceSaleOff);
			}else{
				$scope.cartPrice = parseFloat(session_price) + parseFloat(price);
			}
		}	
	}else{
		if($scope.InputQuantity != null && $scope.InputQuantity != ""){
			if(priceSaleOff != ""){
				$scope.cartPrice = parseFloat(priceSaleOff)*parseInt($scope.InputQuantity);
			}else{
				$scope.cartPrice = parseFloat(price)*parseInt($scope.InputQuantity);
			}
		}else{
			if(priceSaleOff != ""){
				$scope.cartPrice = parseFloat(priceSaleOff);
			}else{
				$scope.cartPrice = parseFloat(price);
			}
		}
	}
	
	// T/h khi da co gio hang
	if(session_listProduct != null && session_listProduct != ""){
		if($scope.InputQuantity != null && $scope.InputQuantity != ""){
			for(var i = 1; i <= $scope.InputQuantity; i++){
				session_listProduct += "," +  idSanPham.replace(/^\s+|\s+$/g, '');
			}
			listProduct = session_listProduct;
			$scope.cartQuantity = parseInt(session_quantity) + parseInt($scope.InputQuantity);
		}else {
			listProduct = session_listProduct +"," +  idSanPham.replace(/^\s+|\s+$/g, '');
			$scope.cartQuantity = parseInt(session_quantity) + 1;
		}
	// T/h khi chua co gio hang
	}else{
		if($scope.InputQuantity != null && $scope.InputQuantity != ""){
			for(var i = 1; i <= $scope.InputQuantity; i++){
				listProductTMP += "," +  idSanPham.replace(/^\s+|\s+$/g, '');
			}
			listProduct = listProductTMP;
			$scope.cartQuantity = parseInt($scope.InputQuantity);
		}else {
			listProduct = ","+ idSanPham;
			$scope.cartQuantity =  1;
		}
		
	}
	
	$window.sessionStorage.setItem('session_price', $scope.cartPrice);
	$window.sessionStorage.setItem('session_listProduct', listProduct);
	$window.sessionStorage.setItem('session_quantity', $scope.cartQuantity);
}

function searchByMenu($scope, idLoaiSp){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/searchByMenu/" + idLoaiSp;
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function back($scope){
	var url = "/storeManagerSystem/" + $scope.pathJSP ;
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function chiTiet($scope, $window, idSanPham){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/chiTietSP/" + idSanPham;
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function timKiemMenu($scope, $window, idLSP){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/timKiemSanPham/" + idLSP;
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "GET";
	document.getElementById("LayoutForm").submit();
}

function timKiem($scope, $window, idSanPham){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/timKiem";
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function gioiThieu($scope, $window, idSanPham){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/gioiThieu";
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function huongDan($scope, $window, idSanPham){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/huongDan";
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function phanTrang($scope, $window, id){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/phanTrang/"+id;
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function lienHe($scope){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/lienHe";
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
}

function dangKiLienHe($scope){
	var valid = true;
	$scope.LH_Name_err           = "";
	$scope.LH_Address_err        = "";
	$scope.LH_Email_err          = "";
	$scope.LH_Phone_err          = "";
	$scope.LH_Title_err          = "";
	$scope.LH_noiDungNhan_err    = "";
	
	if ($scope.LH_Name == "") {
		$scope.LH_Name_err = "Nhập Tên."
		valid = false;
	}
	
	if ($scope.LH_Address == "") {
		$scope.LH_Address_err = "Nhập địa chỉ."
		valid = false;
	}
	
	if ($scope.LH_Email == "") {
		$scope.LH_Email_err = "Nhập email."
		valid = false;
	}
	
	if ($scope.LH_Phone == "") {
		$scope.LH_Phone_err = "Nhập số điện thoại."
		valid = false;
	}
	
	if ($scope.LH_Title == "") {
		$scope.LH_Title_err = "Nhập tiêu đề."
		valid = false;
	}
	
	if ($scope.LH_noiDungNhan == "") {
		$scope.LH_noiDungNhan_err = "Nhập nội dung."
		valid = false;
	}
	
	if (true == valid) {
		if(confirm("Bạn có muốn đăng ký?")){
		var url = "/storeManagerSystem/" + $scope.pathJSP +"/lienHe/insert";
		document.getElementById("LayoutForm").action = url;
		document.getElementById("LayoutForm").method = "POST";
		document.getElementById("LayoutForm").submit();
	}
  }
}

function tinTuc($scope){
	var url = "/storeManagerSystem/" + $scope.pathJSP +"/tinTuc";
	document.getElementById("LayoutForm").action = url;
	document.getElementById("LayoutForm").method = "POST";
	document.getElementById("LayoutForm").submit();
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
		$scope.cartPrice =  parseFloat(session_price) - parseFloat(priceSaleOff);
		$scope.thanhTien[id] = parseFloat($scope.thanhTien[id]) - parseFloat(priceSaleOff);
		$scope.tongThanhTien = parseFloat($scope.tongThanhTien) - parseFloat(priceSaleOff);
	}else{
		$scope.cartPrice =  parseFloat(session_price) - parseFloat(price);
		$scope.tongThanhTien = parseFloat($scope.tongThanhTien) - parseFloat(price);
	}
	//tong tien don hang
	$scope.tongDonHang = parseFloat($scope.tongDonHang) - parseFloat(price);
	//tong tien giam gia
	$scope.tongTienGiamGia = parseFloat($scope.tongDonHang) - parseFloat($scope.tongThanhTien);
	
	$scope.cartQuantity= parseInt(session_quantity) - 1;
	listProduct = session_listProduct.replace("," + id,"");
	
	$window.sessionStorage.setItem('session_price', $scope.cartPrice);
	$window.sessionStorage.setItem('session_listProduct', listProduct);
	$window.sessionStorage.setItem('session_quantity', $scope.cartQuantity);
}

function buyCart($scope, $window){
	$scope.sdtKhachHang_err = "";
	$scope.hoTenKhachHang_err = "";
	$scope.diaChiKhachHang_err = "";
	
	var valid = true;
	var reg = new RegExp('^[0-9]+$');
	if ($scope.sdtKhachHang == "") {
		$scope.sdtKhachHang_err = "Nhập số điện thoại."
			valid = false;
	}else if(!reg.test($scope.sdtKhachHang)){
		$scope.sdtKhachHang_err = "Số điện thoại phải là số."
		valid = false;
	}else if( parseInt($scope.sdtKhachHang) < 10 || parseInt($scope.sdtKhachHang > 12) ){
		$scope.sdtKhachHang_err = "Số điện thoại không đúng."
		valid = false;
	}
	
	if ($scope.hoTenKhachHang == "") {
		$scope.hoTenKhachHang_err = "Nhập họ tên."
		valid = false;
	}
	
	if ($scope.diaChiKhachHang == "") {
		$scope.diaChiKhachHang_err = "Nhập địa chỉ."
		valid = false;
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




