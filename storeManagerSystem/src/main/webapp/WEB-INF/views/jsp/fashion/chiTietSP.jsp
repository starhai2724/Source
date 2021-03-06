<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<title>${LayoutForm.tenCuaHang }</title>
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
	<form:input type="hidden" path="pathJSP" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" />
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
							<a href="javascript:void(0)">
								<h3> <span ng-model = "cartPrice" >{{cartPrice | number}} VNĐ</span>(<span ng-model = "cartQuantity"  >{{cartQuantity}}</span>)<img src="/storeManagerSystem/view/fontend_index2/images/bag.png" alt=""></h3>
							</a>	
							<p><a href="javascript:void(0)" ng-click="btnCart();" class="simpleCart_empty">Giỏ hàng</a></p>
							<p style="color: red" class="simpleCart_empty">${LayoutForm.tenKhachHang}</p>
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
					<h1><a href="/storeManagerSystem/${LayoutForm.pathJSP }"><span>E</span> -${LayoutForm.tenCuaHang}</a></h1>
				</div>
	    </div>
	    <!--/.navbar-header-->
				<div class="container">
				<div class="join">
					<div class="sub-left-right">
						<form>
							<input style="width: 400px" type="text" value="Nhập sản phẩm muốn tìm kiếm" path="timKiem_TenSP"  name="timKiem_TenSP" ng-model = "timKiem_TenSP"  ng-init ="timKiem_TenSP = '${LayoutForm.timKiem_TenSP}'" />
							<input style="width: 150px" type="submit" value="Tìm Kiếm" ng-click ="btnTimKiem()"/>
						</form>
					</div>
					<div class="clearfix"> </div>
				</div>
			</div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	        <ul class="nav navbar-nav">
			<li><a href="/storeManagerSystem/${LayoutForm.pathJSP }">Trang chủ</a></li>
				<c:forEach var="items" items="${LayoutForm.loaiSanPham }">
			        <li class="dropdown">
			            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${items.nameProductCategory } <b class="caret"></b></a>
			            <c:if test="${!empty items.menuRowForms }">
				            <ul class="dropdown-menu multi-column " style="margin-left: 10px;">
								<ul class="multi-column-dropdown">
							      <c:forEach var="menus" items="${items.menuRowForms }">
							            			<li style="padding-left: 20px"><a href="/storeManagerSystem/${LayoutForm.pathJSP }/searchByMenu/${menus.idLoaiSp}/${items.nameProductCategory}">${menus.tenLoaiSp }</a></li>
							            			<%-- <li style="padding-left: 20px"><a ng-click="btnTimKiemMenu('${menus.idLoaiSp }')" href="javascript:void(0)">${menus.tenLoaiSp }</a></li> --%>
							       </c:forEach>
							    </ul>
				            </ul>
			            </c:if>
			        </li>
		        </c:forEach>
		        	<li><a ng-click="btnTinTuc()">Tin tức</a></li>
					<!-- <li><a href="typography.html">TYPO</a></li> -->
					<li><a ng-click="btnLienHe()">Liên hệ</a></li>
	        </ul>
	    </div>
	    <!--/.navbar-collapse-->
	</nav>
	<!--/.navbar-->
</div>
</div>
		<!-- content-section-starts -->
	<div class="container">
	   <div class="products-page" >
				<div class="col-md-6 zoom-grid">
					<div style="margin-left: 150px;width: 350px;">
						<c:forEach var="items" items="${LayoutForm.products }">
							<ul >
								<li data-thumb="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}">
									<div> <img style="width: 350px;height: 450px" src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}" alt=""  /> </div>
								</li>
							</ul>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-5 dress-info">
					<c:forEach var="items" items="${LayoutForm.products }">
						<div class="dress-name">
							<h3>${items.tenSP }</h3>
							<c:if test="${!empty items.giaBanKM }">
								<strike class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
							</c:if>
							<c:if test="${empty items.giaBanKM }">
								<span class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
							</c:if>
							<c:if test="${!empty items.giaBanKM }">
								<span class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
							</c:if>
							<div class="clearfix"></div>
							<p>${items.moTa }</p>
						</div>
						<div class="purchase">
						<div >
						    <a  class="btn btn-primary" href="javascript:void(0)" ng-click="btnPurchase('${items.giaBan}','${items.giaBanKM }' ,'${items.SEQ} ')"><i class="glyphicon glyphicon-shopping-cart"></i>Thêm giỏ hàng</a>
						   <br>
						</div>
						<div class="social-icons">
						</div>
						<div class="clearfix"></div>
					</div>
		        	</c:forEach>
					
				<script src="/storeManagerSystem/view/fontend_index2/js/imagezoom.js"></script>
					<!-- FlexSlider -->
					<script defer src="/storeManagerSystem/view/fontend_index2/js/jquery.flexslider.js"></script>
					<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
					</script>
				</div>
				<div class="clearfix"></div>
					<div class="reviews-tabs">
      <!-- Main component for a primary marketing message or call to action -->

		<div class="footer">
		<div class="container">
		 <div class="footer_top">
			<div class="span_of_4">
				<div class="col-md-3 span1_of_4">
					<h4>Giới thiệu</h4>
					<ul class="f_nav">
						<li> <a ng-click="btnGioiThieu()">Về chúng tôi</a></li>
                        <li>
                            <a ng-click="btnLienHe()">Hỏi đáp</a>
                        </li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>Trợ giúp</h4>
					<ul class="f_nav">
						<li><a ng-click="btnHuongDan()">Hướng dẫn thanh toán</a></li>
					</ul>	
				</div>
				<div class="col-md-5 span1_of_4">
					<h4>Thông tin cửa hàng</h4>
					<ul class="f_nav" style="width: 400px">
                        <div class="box-address-content" style="width: 400px">
                            <b>${LayoutForm.tenCuaHang}</b>
                            <p><i class="fa fa-map-marker"></i> ${LayoutForm.diaChi}</p>
                            <p>
                                <i class="fa fa-phone"></i>
                                Số điện thoại: ${LayoutForm.soDienThoai}
                            </p>
                        </div>
					</ul>				
				</div>
				<div class="clearfix"></div>
				</div>
		  </div>
		  <div class="cards text-center">
				<img src="/storeManagerSystem/view/fontend_index2/images/cards.jpg" alt="" />
		  </div>
		  <div class="copyright text-center">
				<p>${LayoutForm.tenCuaHang}</p>
		  </div>
		</div>
		</div>	
 <script src="/storeManagerSystem/view/fontend_index2/js/responsive-tabs.js"></script>
    <script type="text/javascript">
      $( '#myTab a' ).click( function ( e ) {
        e.preventDefault();
        $( this ).tab( 'show' );
      } );

      $( '#moreTabs a' ).click( function ( e ) {
        e.preventDefault();
        $( this ).tab( 'show' );
      } );

      ( function( $ ) {
          // Test for making sure event are maintained
          $( '.js-alert-test' ).click( function () {
            alert( 'Button Clicked: Event was maintained' );
          } );
          fakewaffle.responsiveTabs( [ 'xs', 'sm' ] );
      } )( jQuery );

    </script>
</div>
<div id="fb-root"></div>
</form:form>
</body>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</html>