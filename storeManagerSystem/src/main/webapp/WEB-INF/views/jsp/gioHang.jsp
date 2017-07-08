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
						<li><a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangNhap"><span class="glyphicon glyphicon-user"> </span>Đăng nhập</a></li>
						<li><a href="/storeManagerSystem/${LayoutForm.pathJSP }/dangkitaikhoan"><span class="glyphicon glyphicon-lock"> </span>Tạo tài khoản</a></li>		
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
					<h1><a href="/storeManagerSystem/${LayoutForm.pathJSP }"><span>E</span> -Thời trang</a></h1>
				</div>
	    </div>
	    <!--/.navbar-header-->
     
            
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	        <ul class="nav navbar-nav">
			<li><a href="/storeManagerSystem/${LayoutForm.pathJSP }">Trang chủ</a></li>
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

<div id="wrapper">	
	<div class="row">
					<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thanh toán đơn hàng</h1>
			</div>
			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i>Thông tin khách hàng
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       		 <div class="row">
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Họ và Tên">
										</div>
			                        </div>
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Thành phố">
										</div>
			                        </div>
			                 </div>
			                  <div class="row">
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Điện thoại">
										</div>
			                        </div>
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Quận huyện">
										</div>
			                        </div>
			                 </div>
			                 <div class="row">
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Email">
										</div>
			                        </div>
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Địa chỉ">
										</div>
			                        </div>
			                 </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <div align="left">
						<p style="color: blue; font-weight: bold;">${LayoutForm.message }</p>
						<p style="color: red; font-weight: bold;">${LayoutForm.messageErr }</p>
					</div>
                    <!-- /.panel -->
                    <div class="panel panel-default" style="padding-left: 3px">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Thông tin đơn hàng
                        </div>
                    </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="margin-top: -15px">
			               <div class="row">
			               	    <div class="table-responsive">
                                	<table class="table table-bordered ">
		                                	<thead>
		                                        <tr>
		                                            <th align="center" style="widows: 80px;text-align: center">Ảnh</th>
		                                            <th align="center" style="text-align: center">Tên sản phẩm</th>
		                                            <th align="center" style="widows: 50px;text-align: center">Số lượng</th>
		                                            <th align="center" style="widows: 80px;text-align: center">Đơn giá</th>
		                                            <th align="center" style="widows: 30px;text-align: center">Xóa</th>
		                                            <th align="center" style="text-align: center">Thành tiền</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
										      <c:forEach var="items" items="${LayoutForm.products }">
										      <tr>
										      		<td align="center" style="widows: 80px"><img style="height: 80px;width: 70px;" src="/storeManagerSystem/myImage/imageDisplay/${items.SEQ}" alt="" /></td>
													<td>${items.tenSP}</td>
													<td style="text-align: center;"><span ng-model="soLuong[${items.SEQ }]" ng-init="soLuong[${items.SEQ }] ='${items.soLuong }'">{{soLuong[${items.SEQ }]}}</span></td>
													<td>
														<c:if test="${!empty items.giaBanKM }">
														<strike class="item_price">${items.giaBan}</strike>
														</c:if>	</td>
													<td style="text-align: center;padding-top: 20px"  ><span style="font-size: 30px" class="glyphicon glyphicon-trash" ng-click="btnRemove('${items.SEQ }', '${items.giaBan }', '${items.giaBanKM }')" data-toggle="tooltip" data-original-title="Xóa"></span></td>
													<td style="text-align: right;">12,000,000</td>		
												</tr>
											</c:forEach>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold">Tổng đơn hàng</td>
													<td style="text-align: right;">3000,000,000</td>
												</tr>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold">Giảm giá</td>
													<td style="text-align: right;">80,000</td>
												</tr>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold">Tổng tiền</td>
													<td style="text-align: right;">50,000,000,000</td>
												</tr>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold"></td>
													<td style="text-align: right;"><input name="" class="btn btn-primary active" ng-click ="btnBuyCart()" value="Thanh toán"></td>
												</tr>
										</tbody>
									</table>
								</div>
			               </div>
                        </div>
                </div>
            </div>
</div> 
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
						<li><a href="#">sale</a></li>
						<li><a href="#">style videos</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>help</h4>
					<ul class="f_nav">
						<li><a href="#">frequently asked  questions</a></li>
						<li><a href="#">kids</a></li>
						<li><a href="#">brands</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>account</h4>
					<ul class="f_nav">
						<li><a href="account.html">login</a></li>
						<li><a href="#">brands</a></li>
						<li><a href="#">create wishlist</a></li>
					</ul>				
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>popular</h4>
					<ul class="f_nav">
						<li><a href="#">new arrivals</a></li>
						<li><a href="#">men</a></li>
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