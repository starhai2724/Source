<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
    <title>Hệ thống bán hàng</title>
    <meta name="keywords" />
    <link href="/storeManagerSystem/view/layoutHeader/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta content="vi_VN" property="og:locale" />
    <meta content="website" property="og:type" />
    <meta property="og:image" />
    <meta property="og:url" />
    
    <link href="/storeManagerSystem/view/templateDK/bootstrap.min.css" rel="stylesheet" />
<!--     <link href="/storeManagerSystem/view/templateDK/font-awesome.min.css" rel="stylesheet" /> -->
    <link href="/storeManagerSystem/view/templateDK/simple-line-icons.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/animate.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/toTop.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/owl.carousel.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/owl.theme.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/overwrite.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/styles.css" rel="stylesheet" />
    <link href="/storeManagerSystem/view/templateDK/responsive.css" rel="stylesheet" />

    <script src="/storeManagerSystem/view/templateDK/jquery-2.1.0.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/templateDK/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
    <script src="/storeManagerSystem/view/templateDK/bootstrap.min.js"></script>
    <script src="/storeManagerSystem/view/js/angular.min.js"></script>
    <!--End of Zopim Live Chat Script-->
</head>
<body ng-app="appMain" class="ng-scope" style="font-size: 16px">
<!-- START HEADER -->
<header class="clearfix">
    <div class="container clearfix">
        <!-- Start navbar -->
        <nav class="navbar navbar-default navbar-fixed-top top-nav-collapse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand hidden-xs hidden-sm" href="index.html">
                        <img alt="AGB" class="scroller-logo" src="/storeManagerSystem/view/templateDK/logoHeader.jpg">
                        <img src="/storeManagerSystem/view/templateDK/logoHeader.jpg" class="default-logo img-responsive" alt="AGB">
                    </a>
                    <button type="button" class="navbar-toggle collapsed pull-right " data-toggle="collapse" data-target="#menu" aria-expanded="false">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                								<div class="">
									<ul class="create-menu navbar-right hidden-xs">
										<li><a class="btn btn-primary"
											href="/storeManagerSystem/buoc1">Tạo web</a></li>
									</ul>
									<ul
										class="nav navbar-nav navbar-right menu-top collapse navbar-collapse"
										id="menu" aria-expanded="false">
										<li><a href="http://localhost:8080/storeManagerSystem/trangChuAdmin" id=""
											class="" style="font-size: 16px">Trang chủ</a></li>
										<li><a href="http://localhost:8080/storeManagerSystem/adminGioiThieu" id=""
											class="" style="font-size: 16px">Giới thiệu</a></li>
										<li><a style="font-size: 16px" href="http://localhost:8080/storeManagerSystem/admin_khoGiaoDien" id="">Kho
												giao diện</a></li>
										<li><a style="font-size: 16px" href="http://localhost:8080/storeManagerSystem/adminTinhNang" id="">Tính
												năng</a></li>
									</ul>
								</div>
            </div>
        </nav>
        <!-- End navbar -->
    </div>
</header>
<div class="inner-heading paying-page-bg">
    <div class="overlay-bg"></div>
    <div class="container">
        <div class="row ">

        </div>
    </div>
</div>

							<section class="text-center theme-list ng-scope"
								ng-controller="templateController" ng-init="initController()">
							<div class="container">
								<div class="row">
									<h2 class="title text-uppercase clearfix color2">1000+
										giao diện miễn phí</h2>
									<h2 class="title-small">Template website bán hàng chuyên
										nghiệp, cực đẹp, hãy chọn cho cửa hàng online của bạn 1 theme
										đẹp để thu hút người mua hàng.</h2>
									<div class="product-template clearfix">
										<!-- end ngRepeat: item in Templates -->
										<div class="col-md-4 col-sm-6 col-sm-12 ng-scope">
											<div class="product-item wow animated"
												style="visibility: visible;">
												<div class="product-img">
													<a href="#"><img
														ng-src="/Images/blank.gif"
														data-original="/storeManagerSystem/view/trangChuAdmin_files/runecom02.jpg"
														class="img-responsive lazy" alt="Bán hàng RUNECOM01"
														src="/storeManagerSystem/view/trangChuAdmin_files/runecom02.jpg"
														></a>
												</div>
												<!-- ngIf: item.IsNew==true -->
												<span class="circle-new ng-scope" ng-if="item.IsNew==true">Mới</span>
												<!-- end ngIf: item.IsNew==true -->
												<div class="product-info">
													<h2 class="name">
														<a href="#"
															class="ng-binding">Bán hàng RUNECOM01</a>
													</h2>
													<!-- ngIf: item.IsFree==false -->
													<!-- ngIf: item.IsFree==true -->
													<div class="price ng-scope" ng-if="item.IsFree==true">Miễn
														phí</div>
													<!-- end ngIf: item.IsFree==true -->
												</div>
												<a class="mask-brg"
													href="#"></a>
												<div class="actions">
													<a class="view-all" target="_blank"
														href="#">CHI
														TIẾT</a> <a class="view-demo" name="add"
														href="#">XEM
														THỰC TẾ</a>
												</div>

											</div>
										</div>
										<!-- end ngRepeat: item in Templates -->
										<div class="col-md-4 col-sm-6 col-sm-12 ng-scope">
											<div class="product-item wow animated"
												style="visibility: visible;">
												<div class="product-img">
													<a href="#"><img
														ng-src="/Images/blank.gif"
														data-original="/storeManagerSystem/view/trangChuAdmin_files/runecom04.jpg"
														class="img-responsive lazy" alt="Bán hàng RUNECOM02"
														src="/storeManagerSystem/view/trangChuAdmin_files/runecom04.jpg"
														></a>
												</div>
												<!-- ngIf: item.IsNew==true -->
												<span class="circle-new ng-scope" ng-if="item.IsNew==true">Mới</span>
												<!-- end ngIf: item.IsNew==true -->
												<div class="product-info">
													<h2 class="name">
														<a href="#"
															class="ng-binding">Bán hàng RUNECOM02</a>
													</h2>
													<!-- ngIf: item.IsFree==false -->
													<!-- ngIf: item.IsFree==true -->
													<div class="price ng-scope" ng-if="item.IsFree==true">Miễn
														phí</div>
													<!-- end ngIf: item.IsFree==true -->
												</div>
												<a class="mask-brg"
													href="#"></a>
												<div class="actions">
													<a class="view-all" target="_blank"
														href="#">CHI
														TIẾT</a> <a class="view-demo" name="add"
														href="#" target="_blank">XEM
														THỰC TẾ</a>
												</div>

											</div>
										</div>
										<!-- end ngRepeat: item in Templates -->
										<div class="col-md-4 col-sm-6 col-sm-12 ng-scope">
											<div class="product-item wow animated"
												style="visibility: visible;">
												<div class="product-img">
													<a href="#"><img
														ng-src="/Images/blank.gif"
														data-original="/storeManagerSystem/view/trangChuAdmin_files/runecom48.jpg"
														class="img-responsive lazy" alt="Bán hàng RUNECOM03"
														src="/storeManagerSystem/view/trangChuAdmin_files/runecom48.jpg"
														></a>
												</div>
												<!-- ngIf: item.IsNew==true -->
												<span class="circle-new ng-scope" ng-if="item.IsNew==true">Mới</span>
												<!-- end ngIf: item.IsNew==true -->
												<div class="product-info">
													<h2 class="name">
														<a href="#"
															class="ng-binding">Bán hàng RUNECOM03</a>
													</h2>
													<!-- ngIf: item.IsFree==false -->
													<!-- ngIf: item.IsFree==true -->
													<div class="price ng-scope" ng-if="item.IsFree==true">Miễn
														phí</div>
													<!-- end ngIf: item.IsFree==true -->
												</div>
												<a class="mask-brg"
													href="#"></a>
												<div class="actions">
													<a class="view-all" target="_blank"
														href="#">CHI
														TIẾT</a> <a class="view-demo" name="add"
														href="#" target="_blank">XEM
														THỰC TẾ</a>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
							</section>
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
  <div class="fb-page" data-tabs="messages" data-href="https://www.facebook.com/C%E1%BB%ADa-h%C3%A0ng-th%E1%BB%9Di-trang-255302581636729/" data-width="250" data-height="400" data-small-header="false" data-adapt-container-width="true" data-hide-cover="false" data-show-facepile="true" data-show-posts="false"></div>
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
		<footer class="no-margin footer">
	<div class="footer-left-bg"></div>
	<div class="footer-right-bg"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-12 col-xs-12">
				<h2>
					AGB<span class="line"></span>
				</h2>
				<ul>
					<li><a href="http://localhost:8080/storeManagerSystem/admin_khoGiaoDien">Kho
							giao diện</a></li>
					<li><a href="http://localhost:8080/storeManagerSystem/adminTinhNang">Tính năng</a></li>

				</ul>
			</div>
			<div class="col-md-3 col-sm-12 col-xs-12">
				<h2>
					Giới thiệu<span class="line"></span>
				</h2>
				<ul>
					<li><a href="http://localhost:8080/storeManagerSystem/adminGioiThieu">Về chúng
							tôi</a></li>
					<li><a href="http://localhost:8080/storeManagerSystem/adminThanhToan">Hình thức
							thanh toán</a></li>
				</ul>
			</div>
			<div class="col-md-3 col-sm-12 col-xs-12 social-icon">
				<h2>
					<span class="line"></span>Kết nối với chúng tôi
				</h2>
				<p class="text-uppercase color1">CÔNG TY TNHH PHÁT TRIỂN CÔNG
					NGHỆ AGB</p>
				<p>
					<i class="fa fa-envelope-o"></i> agbvn@gmail.com
				</p>
				<p>
					<i class="fa fa-phone"></i> 0908 77 00 95
				</p>
				<p>
					<i class="fa fa-home"></i> 36Bis Hoàng Sa, Phường Tân Định, Quận 1,
					Tp.Hồ Chí Minh
				</p>
				<ul class="">
					<li><a target="_blank"><i class="fa fa-facebook fa-2"></i></a></li>
					<li><a target="_blank"><i class="fa fa-google-plus fa-2"></i></a></li>
					<li><a target="_blank"><i class="fa fa-twitter fa-2"></i></a></li>
					<li><a target="_blank"><i class="fa fa-youtube fa-2"></i></a></li>
				</ul>
			</div>

		</div>
	</div>
	<div class="reserved">
		<div class="container">
			<p class="text-left col-md-12">© Copyright 2014. All rights
				reserved. Runtime.vn - Giải pháp thương mại điện tử hàng đầu Việt
				nam</p>
		</div>
	</div>
	</footer>

	<div class="zopim" __jx__id="___$_1"
		style="position: absolute; visibility: hidden; margin: 0px; padding: 0px; border: 0px; height: 0px; width: 0px;"></div>
</body>
</html>