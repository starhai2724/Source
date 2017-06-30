<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>

<title>Cửa hàng thời trang</title>
<link href="/storeManagerSystem/view/fontend_index2/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/storeManagerSystem/view/fontend_index2/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="/storeManagerSystem/view/fontend_index2/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<!-- for bootstrap working -->
	<script type="text/javascript" src="/storeManagerSystem/view/fontend_index2/js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->
<!-- cart -->
	<script src="/storeManagerSystem/view/fontend_index2/js/simpleCart.min.js"> </script>
<!-- cart -->
<link rel="stylesheet" href="/storeManagerSystem/view/fontend_index2/css/flexslider.css" type="text/css" media="screen" />

<script src="/storeManagerSystem/view/js/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.19/angular-cookies.js"></script>
</head>
<body>
<div ng-app="LayoutForm" ng-controller="ctrl">
<form:form id="LayoutForm" modelAttribute="LayoutForm" role="form" method="GET" >
	<input type="hidden" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" >
	<!-- header-section-starts -->
	<div class="header">
		<div class="header-top-strip">
			<div class="container">
				<div class="header-top-left">
					<ul>
						<li><a href="account.html"><span class="glyphicon glyphicon-user"> </span>Đăng nhập</a></li>
						<li><a href="register.html"><span class="glyphicon glyphicon-lock"> </span>Tạo tài khoản</a></li>			
					</ul>
				</div>
				<div class="header-right">
						<div class="cart box_1">
							<a href="checkout2.html">
								<h3> <span ng-model = "cartPrice" >{{cartPrice}}</span>(<span ng-model = "cartQuantity"  >{{cartQuantity}}</span>)<img src="/storeManagerSystem/view/fontend_index2/images/bag.png" alt=""></h3>
							</a>	
							<p><a ng-click="btnCart();" class="simpleCart_empty">Giỏ hàng</a></p>
							<p><a ng-click="btnCart();" class="simpleCart_empty">Thanh Toán</a></p>
							<div class="clearfix"> </div>
						</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- header-section-ends -->
			<div class="banner-top">
		<div class="container">
				<nav class="navbar navbar-default" role="navigation">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
				<div class="logo">
					<h1><a href="index.html"><span>E</span> -Thời trang</a></h1>
				</div>
	    </div>
	    <!--/.navbar-header-->
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	        <ul class="nav navbar-nav">
			<li><a href="index.html">Trang chủ</a></li>
				<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
			        <li class="dropdown">
			            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${items.nameProductCategory } <b class="caret"></b></a>
			        </li>
		        </c:forEach>
					<!-- <li><a href="typography.html">TYPO</a></li> -->
					<li><a href="contact.html">Liên hệ</a></li>
	        </ul>
	    </div>
	    <!--/.navbar-collapse-->
	</nav>
	<!--/.navbar-->
</div>
</div>
		<!-- content-section-starts-here -->
		<div class="container">
			<div class="main-content">
				<!-- <div class="online-strip">
					<div class="col-md-4 follow-us">
						<h3>Liên kết  : <a class="twitter" href="#"></a><a class="facebook" href="#"></a></h3>
					</div>
					<div class="col-md-4 shipping-grid">
						<div class="shipping">
							<img src="/storeManagerSystem/view/fontend_index2/images/shipping.png" alt="" />
						</div>
						<div class="shipping-text">
							<h3>Miễn phí vận chuyển</h3>
							<p>trên hóa đơn 500.000đ</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 online-order">
						<p>Đặt hàng online</p>
						<h3>Tel:999 4567 8902</h3>
					</div>
					<div class="clearfix"></div>
				</div> -->
				<div class="products-grid">
				<header>
					<div align="left">
						<input type="button" name="" class="btn btn-info " ng-click ="btnBuyCart()" value="Thanh toán">
					</div>
				</header>
				<!--San pham (S)  ----------------------------------------------------------------------------------------------------------------------------------------------->
				<c:forEach var="items" items="${LayoutForm.products }">
					<div class="col-md-4 product simpleCart_shelfItem text-center" id="sanPham${items.SEQ }">
						<a href="single.html"><img src="/storeManagerSystem/myImage/imageDisplay/${items.SEQ}" alt="" /></a>
						<div class="mask">
							<a href="single.html">Chi tiết</a>
						</div>
						<a class="product_name" href="single.html">${items.tenSP}</a>
						<p>
						<span ng-model="soLuong[${items.SEQ }]" ng-init="soLuong[${items.SEQ }] ='${items.soLuong }'">{{soLuong[${items.SEQ }]}}</span></br>
						<span class="glyphicon glyphicon-trash" ng-click="btnRemove('${items.SEQ }', '${items.giaBan }', '${items.giaBanKM }')" data-toggle="tooltip" data-original-title="Xóa"></span>
						<c:if test="${!empty items.giaBanKM }">
							<strike class="item_price">${items.giaBan}</strike>
						</c:if>
						<c:if test="${empty items.giaBanKM }">
							<span class="item_price">${items.giaBan}</span>
						</c:if>
						<c:if test="${!empty items.giaBanKM }">
							<span class="item_price">${items.giaBanKM}</span>
						</c:if>
					</div>
				</c:forEach>
				<!--San pham (E) --------------------------------------------------------------------------------------------------------------------------------------------- -->
					<div class="clearfix"></div>
				</div>
			</div>

		</div>
		<div class="footer">
		<div class="container">
		 <div class="footer_top">
			<div class="span_of_4">
				<div class="col-md-3 span1_of_4">
					<h4>Shop</h4>
					<ul class="f_nav">
						<li><a href="#">new arrivals</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">trends</a></li>
						<li><a href="#">sale</a></li>
						<li><a href="#">style videos</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>help</h4>
					<ul class="f_nav">
						<li><a href="#">frequently asked  questions</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>account</h4>
					<ul class="f_nav">
						<li><a href="account.html">login</a></li>
						<li><a href="register.html">create an account</a></li>
						<li><a href="#">create wishlist</a></li>
						<li><a href="checkout.html">my shopping bag</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">create wishlist</a></li>
					</ul>				
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>popular</h4>
					<ul class="f_nav">
						<li><a href="#">new arrivals</a></li>
						<li><a href="#">men</a></li>
						<li><a href="#">women</a></li>
						<li><a href="#">accessories</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">trends</a></li>
						<li><a href="#">sale</a></li>
						<li><a href="#">style videos</a></li>
						<li><a href="#">login</a></li>
						<li><a href="#">brands</a></li>
					</ul>			
				</div>
				<div class="clearfix"></div>
				</div>
		  </div>
		  <div class="cards text-center">
				<img src="/storeManagerSystem/view/fontend_index2/images/cards.jpg" alt="" />
		  </div>
		  <div class="copyright text-center">
				<p>Cửa hàng thời trang</p>
		  </div>
		</div>
		</div>
</form:form>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</div>
</body>
</html>