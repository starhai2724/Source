<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/../static.runtime.vn/App_Themes/RUN022/style.css" rel="stylesheet" type="text/css" />
    <link href="/storeManagerSystem/view/template_2/runecom22.runtime.vn/../static.runtime.vn/App_Themes/RUN022/responsive.css" rel="stylesheet" type="text/css" />
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
<div class="container" style="width: 1370px">
<div class="main-content">
<div class="main">
  <div class="container" style="width: 1370px">
     <div class="row">
         <div class="col-md-3">
				<div class="box-news" >
				    <h3 style="background-color: #816263">
				        <span >
				            Tin tức nổi bật
				        </span>
				    </h3>
				    <div class="news-content">
				        <div class=" news-block clearfix">
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/nhung-phong-cach-dinh-chat-vao-sao-viet-1427861847_180x108.jpg" alt="Những phong cách &#39;đóng khung&#39; của sao Việt" title="Những phong cách &#39;đóng khung&#39; của sao Việt"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html">Những phong cách 'đóng khung' của sao Việt</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/3-cach-mac-vay-duoc-lang-xe-manh-he-2015-1427882991_180x108.jpg" alt="3 cách mặc váy được lăng xê mạnh hè 2015" title="3 cách mặc váy được lăng xê mạnh hè 2015"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html">3 cách mặc váy được lăng xê mạnh hè 2015</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/minh-hang-khoe-vong-mot-goiwjc-am-1427944534_180x108.jpg" alt="Minh Hằng gợi cảm trong váy khoét ngực" title="Minh Hằng gợi cảm trong váy khoét ngực"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html">Minh Hằng gợi cảm trong váy khoét ngực</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/MG-2204-1427902264_180x108.jpg" alt="Diễm My 9X gợi ý váy áo cho mùa hè" title="Diễm My 9X gợi ý váy áo cho mùa hè"></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html">Diễm My 9X gợi ý váy áo cho mùa hè</a></h2>
				                        
				                    </div>
				                </div>
				                <div class="news-item clearfix">
				                    <div class="col-md-4 col-sm-4 col-xs-4 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html"><img class="img-responsive" src="/storeManagerSystem/view/template_2/image/t-1428032524_490x294.jpg" alt="Những góc khuất của nghề stylist cho sao Hollywood " title="Những góc khuất của nghề stylist cho sao Hollywood "></a></div>
				                    <div class="col-md-8 col-sm-8 col-xs-8 news-info ">
				                        <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html">Những góc khuất của nghề stylist cho sao Hollywood </a></h2>
				                        
				                    </div>
				                </div>
				        </div>
				    </div>
				</div>
        </div>
      <div class="col-md-9">
				<script type="text/javascript">
				    $(".link-site-more").hover(function () { $(this).find(".s-c-n").show(); }, function () { $(this).find(".s-c-n").hide(); });
				</script>
				<div class="news-content">
					    <div class="news-block clearfix">
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html">
					                	<img src="/storeManagerSystem/view/template_2/image/nhung-phong-cach-dinh-chat-vao-sao-viet-1427861847_180x108.jpg" class="img-responsive" alt="Những phong cách &#39;đóng khung&#39; của sao Việt"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-phong-cach-dong-khung-cua-sao-viet.html">Những phong cách 'đóng khung' của sao Việt</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Lý Nhã Kỳ, Ngọc Trinh, Sơn Tùng M-TP, Mai Phương Thúy... thường xuyên xuất hiện với một kiểu phong cách quen thuộc.</span></p>
										</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html">
					                	<img src="/storeManagerSystem/view/template_2/image/3-cach-mac-vay-duoc-lang-xe-manh-he-2015-1427882991_180x108.jpg" class="img-responsive" alt="3 cách mặc váy được lăng xê mạnh hè 2015"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/3-cach-mac-vay-duoc-lang-xe-manh-he-2015.html">3 cách mặc váy được lăng xê mạnh hè 2015</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
										<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Cách diện váy trơn, giản dị sẽ ít xuất hiện trong mùa hè năm nay, thay vào đó là cách phối nhiều lớp độc lạ và cá tính.</span></p>
									</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html">
					                	<img src="/storeManagerSystem/view/template_2/image/minh-hang-khoe-vong-mot-goiwjc-am-1427944534_180x108.jpg" class="img-responsive" alt="Minh Hằng gợi cảm trong váy khoét ngực"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/minh-hang-goi-cam-trong-vay-khoet-nguc.html">Minh Hằng gợi cảm trong váy khoét ngực</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Nữ diễn viên diện ba bộ váy đen trong bộ hình mới nhất do nhiếp ảnh gia Lê Thiện Viễn thực hiện.</span></p>
										</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html">
					                	<img src="/storeManagerSystem/view/template_2/image/MG-2204-1427902264_180x108.jpg" class="img-responsive" alt="Diễm My 9X gợi ý váy áo cho mùa hè"></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/die%CC%83m-my-9x-go%CC%A3i-y%CC%81-vay-ao-cho-mu%CC%80a-he%CC%80.html">Diễm My 9X gợi ý váy áo cho mùa hè</a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Người đẹp chọn những bộ váy có gam màu trắng, với chất liệu mềm, thoáng mát.</span></p>
										</div>
					                </div>
					            </div>
					            <div class="news-item clearfix">
					                <div class="col-md-3 col-sm-4 col-xs-12 image"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html">
					                	<img src="/storeManagerSystem/view/template_2/image/t-1428032524_490x294.jpg" class="img-responsive" alt="Những góc khuất của nghề stylist cho sao Hollywood "></a></div>
					                <div class="col-md-9 col-sm-8 col-xs-12 news-info ">
					                    <h2 class="name"><a href="http://runecom22.runtime.vn/tin-tuc/nhung-goc-khuat-cua-nghe-stylist-cho-sao-hollywood.html">Những góc khuất của nghề stylist cho sao Hollywood </a></h2>
					                    <p class="date">03/04/2015</p>
					                    <div class="desc"><p>
											<span style="color: rgb(51, 51, 51); font-family: arial; font-size: 13px; line-height: 16px;">Stylist của Cate Blanchett, Julia Roberts, Sandra Bullock... cho biết, nghề này không dễ làm và chẳng hề có cuộc sống xa hoa như mọi người vẫn tưởng.</span></p>
										</div>
					                </div>
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
    <a class="back-to-top" href="#" style="display: inline;">
        <i class="fa fa-angle-up">
        </i>
    </a>
</form:form>    
</body>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</html>

