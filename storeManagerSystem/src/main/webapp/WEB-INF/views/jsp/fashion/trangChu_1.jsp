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
<div class="slideshow" >
<div class="col-md-12">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh1" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh2" alt="Los Angeles" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh3" alt="Los Angeles" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh4" alt="Los Angeles" style="width:100%;">
      </div>
      
      <div class="item">
        <img src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplayHeader/hinh5" alt="Los Angeles" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
   </div>    
  </div>
</div>
		<div class="container" style="width: 1370px">
			<div class="main-content">
				<div class="online-strip" >
					<div class="col-md-4 follow-us" style="margin-top: 20px">
						<h3>Liên kết  : <a class="twitter" href="#"></a> 
						<div class="fb-like" data-href="https://developers.facebook.com/docs/plugins/" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="true"></div>
						</h3>
					</div>
					<div class="col-md-4 shipping-grid" style="margin-top: 20px">
						<div class="shipping">
							<img src="/storeManagerSystem/view/fontend_index2/images/shipping.png" alt="" />
						</div>
						<div class="shipping-text">
							<h3>Miễn phí vận chuyển</h3>
							<p>${LayoutForm.dkGiaoHangFree}</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-4 online-order" style="margin-top: 20px">
						<p>Đặt hàng online</p>
						<h3>Tel: ${LayoutForm.soDienThoai}</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="products-grid">
				<header>
				</header>
				<!--San pham (S)  ----------------------------------------------------------------------------------------------------------------------------------------------->
				<c:forEach var="items" items="${LayoutForm.products_SearchByMenu }">
					<div class="col-md-3 product simpleCart_shelfItem text-center">
						<a  href="<c:url value="/${LayoutForm.pathJSP }/chiTietSP/${items.SEQ}" />">
						<img style="height: 400px;width: 300px;" src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}" alt="" /></a>
						<div class="mask">
							<a href="<c:url value="/${LayoutForm.pathJSP }/chiTietSP/${items.SEQ}" />">Chi tiết</a>
						</div>
						<a class="product_name" href="javascript:void(0);">${items.tenSP}</a>
						<p>
						<a class="item_add" href="javascript:void(0);" ng-click="btnPurchase('${items.giaBan}','${items.giaBanKM }' ,'${items.SEQ} ')"><i></i>
						<c:if test="${!empty items.giaBanKM }">
							<strike class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
						</c:if>
						<c:if test="${empty items.giaBanKM }">
							<span class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
						</c:if>
						<c:if test="${!empty items.giaBanKM }">
							<span class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
						</c:if>
						</a>
						</p>
					</div>
				</c:forEach>
				<!--San pham (E) --------------------------------------------------------------------------------------------------------------------------------------------- -->
					<div class="clearfix"></div>
				</div>
				<!-- Page (S)  -->
				<div class="navigation" style="text-align: center;">
                <ul class="pagination">
                    <li>
                        <a href="javascript:void(0)" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                            <li><a href="javascript:void(0)" ng-click= "btnPhanTrang('1')">1</a></li>
                            <li><a href="javascript:void(0)" ng-click= "btnPhanTrang('2')">2</a></li>
                            <li><a href="javascript:void(0)" ng-click= "btnPhanTrang('3')">3</a></li>
                    <li>
                        <a href="javascript:void(0)" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            	</div>
            <!-- Page (E)  -->
			</div>

		</div>
		<!-- San pham khuyen mai (S)  -->	
		 <div class="other-products">
		<div class="container">
			<h3 class="like text-center">Sản phẩm khác</h3>        			
				     <ul id="flexiselDemo3">
							<c:forEach var="items" items="${LayoutForm.products }">
								<li>
									<a  href="<c:url value="/${LayoutForm.pathJSP }/chiTietSP/${items.SEQ}" />"><img style="height: 320px" src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}" class="img-responsive" alt="" /></a>
									<div class="product liked-product simpleCart_shelfItem">
									<a class="like_name" href="single.html">${items.tenSP}</a>
									<p><a class="item_add" href="#"><i></i> 
										<span class=" item_price">
											<c:if test="${!empty items.giaBanKM }">
												<strike class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</strike>
											</c:if>
											<c:if test="${empty items.giaBanKM }">
												<span class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
											</c:if>
											<c:if test="${!empty items.giaBanKM }">
												<span class="item_price"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
											</c:if>
										</span></a></p>
									</div>
								</li>
							</c:forEach>
				     </ul>
				    <script type="text/javascript">
					 $(window).load(function() {
						$("#flexiselDemo3").flexisel({
							visibleItems: 4,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
					    	responsiveBreakpoints: { 
					    		portrait: { 
					    			changePoint:480,
					    			visibleItems: 1
					    		}, 
					    		landscape: { 
					    			changePoint:640,
					    			visibleItems: 2
					    		},
					    		tablet: { 
					    			changePoint:768,
					    			visibleItems: 3
					    		}
					    	}
					    });
					    
					});
				   </script>
				   <script type="text/javascript" src="/storeManagerSystem/view/fontend_index2/js/jquery.flexisel.js"></script>
				   </div>
				   </div> -->
			<!-- San pham khuyen mai (E)  -->	   
		<!-- content-section-ends-here -->
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
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/nl_NL/sdk.js#xfbml=1&version=v2.10";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
</form:form>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</div>
</body>
</html>