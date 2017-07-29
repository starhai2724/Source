<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
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
	<!-- header-section-starts -->
<div ng-app="LayoutForm" ng-controller="ctrl">
<form:form id="LayoutForm" modelAttribute="LayoutForm" role="form" method="GET" >
	<input type="hidden" ng-model="pathJSP" ng-init="pathJSP='${LayoutForm.pathJSP}'" >
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
								<h3> <span ng-model = "cartPrice" >{{cartPrice | number}} VNĐ</span>(<span ng-model = "cartQuantity"  >{{cartQuantity}}</span>)<img src="/storeManagerSystem/view/fontend_index2/images/bag.png" alt=""></h3>
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
		<!-- content-section-starts -->
	<div class="container">
	   <div class="products-page" >
				<div class="col-md-7 zoom-grid">
					<div class="flexslider">
						<c:forEach var="items" items="${LayoutForm.products }">
							<ul class="slides" style="width: 1200px">
								<li data-thumb="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}">
									<div> <img style="widows: 850px;height: 950px" src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}" alt=""  /> </div>
								</li>
								<li data-thumb="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay_1/${items.SEQ}">
									<div> <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay_1/${items.SEQ}" data-imagezoom="true" class="img-responsive" alt="" /> </div>
								</li>
								<li data-thumb="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay_2/${items.SEQ}">
									<div > <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay_2/${items.SEQ}" data-imagezoom="true" class="img-responsive" alt="" /> </div>
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
		        	</c:forEach>
					<div class="purchase">
						<div >
						   <input type="submit" value="Đặt Hàng" class="btn btn-primary active" style="widows: 100px;margin-top: -80px">
						   <br>
						</div>
						<div class="social-icons">
							<ul>
								<li><a class="facebook1" href="#"></a></li>
								<li><a class="twitter1" href="#"></a></li>
								<li><a class="googleplus1" href="#"></a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
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

	</div>

			<div class="clearfix"></div>
			</div>
   </div>
   <div class="other-products products-grid">
		<div class="container">
			<header>
				<h3 class="like text-center">Sản phẩm mới</h3>   
			</header>			
					<div class="col-md-4 product simpleCart_shelfItem text-center">
						<a href="single.html"><img src="/storeManagerSystem/view/fontend_index2/images/p1.jpg" alt="" /></a>
						<div class="mask">
							<a href="single.html">Quick View</a>
						</div>
						<a class="product_name" href="single.html">Sed ut perspiciatis</a>
						<p><a class="item_add" href="#"><i></i> <span class="item_price">$329</span></a></p>
					</div>
					<div class="col-md-4 product simpleCart_shelfItem text-center">
						<a href="single.html"><img src="/storeManagerSystem/view/fontend_index2/images/p2.jpg" alt="" /></a>
						<div class="mask">
							<a href="single.html">Quick View</a>
						</div>
						<a class="product_name" href="single.html">great explorer</a>
						<p><a class="item_add" href="#"><i></i> <span class="item_price">$599.8</span></a></p>
					</div>
					<div class="col-md-4 product simpleCart_shelfItem text-center">
						<a href="single.html"><img src="/storeManagerSystem/view/fontend_index2/images/p3.jpg" alt="" /></a>
						<div class="mask">
							<a href="single.html">Quick View</a>
						</div>
						<a class="product_name" href="single.html">similique sunt</a>
						<p><a class="item_add" href="#"><i></i> <span class="item_price">$359.6</span></a></p>
					</div>
					<div class="clearfix"></div>
				   </div>
				   </div>
   <!-- content-section-ends -->
		<div class="news-letter">
			<div class="container">
				<div class="join">
					<h6>JOIN OUR MAILING LIST</h6>
					<div class="sub-left-right">
						<form>
							<input type="text" value="Enter Your Email Here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Your Email Here';}" />
							<input type="submit" value="SUBSCRIBE" />
						</form>
					</div>
					<div class="clearfix"> </div>
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
				<p>© 2015 Eshop. All Rights Reserved | Design by   <a href="http://w3layouts.com">  W3layouts</a></p>
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
		  <script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.5";
  fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));</script>
  <style>#cfacebook{position:fixed;bottom:0px;right:100px;z-index:999999999999999;width:250px;height:auto;box-shadow:6px 6px 6px 10px rgba(0,0,0,0.2);border-top-left-radius:5px;border-top-right-radius:5px;overflow:hidden;}#cfacebook .fchat{float:left;width:100%;height:270px;overflow:hidden;display:none;background-color:#fff;}#cfacebook .fchat .fb-page{margin-top:-130px;float:left;}#cfacebook a.chat_fb{float:left;padding:0 25px;width:250px;color:#fff;text-decoration:none;height:40px;line-height:40px;text-shadow:0 1px 0 rgba(0,0,0,0.1);background-image:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAqCAMAAABFoMFOAAAAWlBMV…8/UxBxQDQuFwlpqgBZBq6+P+unVY1GnDgwqbD2zGz5e1lBdwvGGPE6OgAAAABJRU5ErkJggg==);background-repeat:repeat-x;background-size:auto;background-position:0 0;background-color:#3a5795;border:0;border-bottom:1px solid #133783;z-index:9999999;margin-right:12px;font-size:18px;}#cfacebook a.chat_fb:hover{color:yellow;text-decoration:none;}</style>
  <script>
  jQuery(document).ready(function () {
  jQuery(".chat_fb").click(function() {
jQuery('.fchat').toggle('slow');
  });
  });
  </script>
  <div id="cfacebook">
  <a href="javascript:;" class="chat_fb" onclick="return:false;"><i class="fa fa-facebook-square"></i> Phản hồi của bạn</a>
  <div class="fchat">
  <div class="fb-page" data-tabs="messages" data-href="${LayoutForm.linkFanpage}" data-width="250" data-height="400" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="false"></div>
  </div>
  </div>
<div id="fb-root"></div>
</form:form>
</body>
</html>