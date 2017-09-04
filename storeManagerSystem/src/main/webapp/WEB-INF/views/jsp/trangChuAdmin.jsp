<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0018)http://runtime.vn/ -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="vi" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style type="text/css">
@charset "UTF-8"; 

[ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak,
	.x-ng-cloak, .ng-hide:not (.ng-hide-animate ){
	display: none !important;
}

.ng-animate-shim {
	visibility: hidden;
}

.ng-anchor {
	position: absolute;
}
</style>
	<meta http-equiv="content-type" content="text/html;charset=utf-8" />
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<title>Tạo web nhanh, Thiết kế web bán hàng, thiết kế website
		giá rẻ, tạo web miễn phí</title>
	<meta
		content="RUNTIME.VN cung cấp dịch vụ thiết kế web bán hàng chuyên nghiệp, thiết kế website giá rẻ, chuẩn SEO, tạo web tự động trong 30s, trải nghiệm miễn phí với thiết kế chất lượng cao, chuyên nghiệp và uy tín"
		name="description">
		<meta name="keywords">
			<link href="#"
				rel="shortcut icon" type="image/x-icon">
				<meta name="viewport" content="width=device-width, initial-scale=1">
					<meta content="vi_VN" property="og:locale">
						<meta content="website" property="og:type">
							<meta
								content="Tạo web nhanh, Thiết kế web bán hàng, thiết kế website giá rẻ, tạo web miễn phí"
								property="og:title">
								<meta
									content="RUNTIME.VN cung cấp dịch vụ thiết kế web bán hàng chuyên nghiệp, thiết kế website giá rẻ, chuẩn SEO, tạo web tự động trong 30s, trải nghiệm miễn phí với thiết kế chất lượng cao, chuyên nghiệp và uy tín"
									property="og:description">
									<meta content="#" property="og:image">
										<meta content="#" property="og:url">
											<meta content="CÔNG TY TNHH PHÁT TRIỂN CÔNG NGHỆ RUNTIME"
												property="og:site_name">

												<link
													href="/storeManagerSystem/view/trangChuAdmin_files/bootstrap.min.css"
													rel="stylesheet">
<link
	href="/storeManagerSystem/view/trangChuAdmin_files/simple-line-icons.css"
	rel="stylesheet">
	<link href="/storeManagerSystem/view/trangChuAdmin_files/animate.css"
		rel="stylesheet">
		<link href="/storeManagerSystem/view/trangChuAdmin_files/toTop.css"
			rel="stylesheet">
			<link
				href="/storeManagerSystem/view/trangChuAdmin_files/owl.carousel.css"
				rel="stylesheet">
				<link
					href="/storeManagerSystem/view/trangChuAdmin_files/owl.theme.css"
					rel="stylesheet">
					<link
						href="/storeManagerSystem/view/trangChuAdmin_files/overwrite.css"
						rel="stylesheet">
						<link
							href="/storeManagerSystem/view/trangChuAdmin_files/styles.css"
							rel="stylesheet">
							<link
								href="/storeManagerSystem/view/trangChuAdmin_files/responsive.css"
								rel="stylesheet">

								<script async="" charset="utf-8"
									src="/storeManagerSystem/view/trangChuAdmin_files/saved_resource"
									type="text/javascript"></script>
								<script async=""
									src="/storeManagerSystem/view/trangChuAdmin_files/analytics.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/jquery-2.1.0.min.js.tải xuống"
									type="text/javascript"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/jquery-migrate-1.2.1.min.js.tải xuống"
									type="text/javascript"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/bootstrap.min.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/common.js.tải xuống"
									type="text/javascript"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/wow.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/jquery.lazyload.min.js.tải xuống"
									type="text/javascript"></script>


								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/angular.min.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/angular-sanitize.min.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/appMain.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/directive.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/angular-summernote.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/paging.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/ajaxServices.js.tải xuống"></script>
								<script
									src="/storeManagerSystem/view/trangChuAdmin_files/alertsServices.js.tải xuống"></script>

								<script>
									(function(i, s, o, g, r, a, m) {
										i['GoogleAnalyticsObject'] = r;
										i[r] = i[r]
												|| function() {
													(i[r].q = i[r].q || [])
															.push(arguments)
												}, i[r].l = 1 * new Date();
										a = s.createElement(o), m = s
												.getElementsByTagName(o)[0];
										a.async = 1;
										a.src = g;
										m.parentNode.insertBefore(a, m)
									})
											(
													window,
													document,
													'script',
													'//www.google-analytics.com/analytics.js',
													'ga');

									ga('create', 'UA-58781921-1', 'auto');
									ga('send', 'pageview');
								</script>

								<!-- AddThis Smart Layers BEGIN -->
								<!-- Go to http://www.addthis.com/get/smart-layers to customize -->

								<!-- AddThis Smart Layers END -->
								<!--Start of Zopim Live Chat Script-->
								<script type="text/javascript">
									window.$zopim
											|| (function(d, s) {
												var z = $zopim = function(c) {
													z._.push(c)
												}, $ = z.s = d.createElement(s), e = d
														.getElementsByTagName(s)[0];
												z.set = function(o) {
													z.set._.push(o)
												};
												z._ = [];
												z.set._ = [];
												$.async = !0;
												$.setAttribute('charset',
														'utf-8');
												$.src = '//v2.zopim.com/?3pP8pVV1WLgGjqTb48HsSqXiEJ33t8Nx';
												z.t = +new Date;
												$.type = 'text/javascript';
												e.parentNode.insertBefore($, e)
											})(document, 'script');
								</script>
								<!--End of Zopim Live Chat Script-->
								<style media="print" class="jx_ui_StyleSheet" __jx__id="___$_2"
									type="text/css">
.zopim {
	display: none !important
}
</style>
</head>
<body ng-app="appMain" class="ng-scope" style="font-size: 16px">
	<div class="vegas-loading" style="opacity: 0.975528;"></div>
<img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg02.jpg" style="position: fixed; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg03.jpg" style="position: fixed; opacity: 0.999701; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg01.jpg" style="position: fixed; opacity: 0.999904; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg02.jpg" style="position: fixed; opacity: 0.99999; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg03.jpg" style="position: fixed; opacity: 0.999992; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg01.jpg" style="position: fixed; opacity: 0.999999; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg02.jpg" style="position: fixed; width: 1707px; height: 926.397px; top: -95.1984px; bottom: auto; left: 0px; right: auto; opacity: 0.999999;"><img class="vegas-background" src="/storeManagerSystem/view/trangChuAdmin_files/slide-bg03.jpg" style="position: fixed; width: 1707px; height: 915.26px; top: -89.6299px; bottom: auto; left: 0px; right: auto; opacity: 0.9998;"><div class="vegas-overlay" style="margin: 0px; padding: 0px; position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; background-image: url(&quot;/storeManagerSystem/view/trangChuAdmin_files/bg-overlay.png&quot;);"></div>
						<!-- START HEADER --> <header class="clearfix">
						<div class="container clearfix">
							<!-- Start navbar -->
							<nav
								class="navbar navbar-default navbar-fixed-top top-nav-collapse">
							<div class="container">
								<div class="navbar-header">
									<a class="navbar-brand hidden-xs hidden-sm"
										href="#"> <img
										style="width: 350px; height: 40px" alt="runtime"
										class="scroller-logo"
										src="/storeManagerSystem/view/layoutHeader/img/logo.png">
											<img src="/storeManagerSystem/view/layoutHeader/img/logo.png"
											class="default-logo img-responsive" alt="runtime"></a> <a
										class="navbar-brand logo-mobile hidden-md hidden-lg"
										href="#"> <img alt="runtime"
										class="scroller-logo"
										src="/storeManagerSystem/view/trangChuAdmin_files/logo-runtime.png">
											<img
											src="/storeManagerSystem/view/trangChuAdmin_files/logo-runtime.png"
											class="default-logo img-responsive" alt="runtime"></a>
									<ul
										class="create-menu navbar-right pull-right hidden-md hidden-sm hidden-lg">
										<li><a class="btn btn-default"
											href="/storeManagerSystem/buoc1">Tạo web</a></li>
									</ul>
									<button type="button"
										class="navbar-toggle collapsed pull-right "
										data-toggle="collapse" data-target="#menu"
										aria-expanded="false">
										<span class="icon-bar"></span> <span class="icon-bar"></span>
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

										<li><a href="http://localhost:8080/storeManagerSystem/adminGioiThieu" id=""
											class="" style="font-size: 16px">Giới thiệu</a></li>
										<li><a style="font-size: 16px" href="http://localhost:8080/storeManagerSystem/admin_khoGiaoDien" id="">Kho
												giao diện</a></li>
										<li><a style="font-size: 16px" href="http://localhost:8080/storeManagerSystem/adminTinhNang" id="">Tính
												năng</a></li>
									</ul>
								</div>
								<!--/.nav-collapse -->
							</div>
							</nav>
							<!-- End navbar -->
						</div>
						</header> <!-- END HEADER --> <script type="text/javascript">
							$(document)
									.ready(
											function() {
												var loc = window.location.href;
												$('header .menu-top a')
														.each(
																function() {
																	if (loc
																			.indexOf(this.href) !== -1) {
																		$(
																				"header .menu-top li a")
																				.removeClass(
																						"selected");
																		$(this)
																				.addClass(
																						'selected');
																	}
																});
												$(".menu-nav").click(
														function() {
															$(".nav-mean")
																	.toggle();
														});

												$("#menu .dropdown")
														.hover(
																function() {
																	$(
																			'.submenu',
																			this)
																			.stop()
																			.fadeIn(
																					"800");
																},
																function() {
																	$(
																			'.submenu',
																			this)
																			.stop()
																			.fadeOut(
																					"800");
																});
											});
							$(window).scroll(
									function() {
										var scrollTop = $(window).scrollTop();
										if (scrollTop != 0) {
											$(".navbar-default").addClass(
													"top-nav-collapse");
											return false;
										} else {
											$(".navbar-default").removeClass(
													"top-nav-collapse");
											return false;
										}
									});
						</script> <script
							src="/storeManagerSystem/view/trangChuAdmin_files/parallax.min.js.tải xuống"></script>
						<script
							src="/storeManagerSystem/view/trangChuAdmin_files/setting.js.tải xuống"></script>
						<script
							src="/storeManagerSystem/view/trangChuAdmin_files/owl.carousel.js.tải xuống"></script>


						<link
							href="/storeManagerSystem/view/trangChuAdmin_files/vegas.min.css"
							rel="stylesheet">
							<script
								src="/storeManagerSystem/view/trangChuAdmin_files/jquery.vegas.min.js.tải xuống"></script>
							<script
								src="/storeManagerSystem/view/trangChuAdmin_files/registerServices.js.tải xuống"></script>
							<script
								src="/storeManagerSystem/view/trangChuAdmin_files/registerController.js.tải xuống"></script>
							<section class="home-section default-bg parallax-bg ng-scope" 
								ng-controller="startRegisterController"
								ng-init="initController()" >
							<div class="container" style="height: 780px">
								<div class="text-center" style="font-size: 17px">
									<h1 class="wow bounceInDown" data-wow-delay="1s" 
										data-wow-duration="1s"
										style="visibility: visible; animation-duration: 1s; animation-delay: 1s; animation-name: bounceInDown;">
										<span class="sologan-1">Tạo web kinh doanh chuyên
											nghiệp</span><br><span class="sologan-2"> chưa bao giờ
												dễ đến thế!</span>
									</h1>
							<h2 class="wow bounceInUp sologan-3" data-wow-delay="1s" data-wow-duration="1.2s" style="visibility: visible; animation-duration: 1.2s; animation-delay: 1s; animation-name: bounceInUp;">Trải nghiệm 30 ngày miễn phí sau 15 giây khởi tạo</h2>
									<div class="col-md-7 col-md-offset-1 wow bounceInLeft"
										data-wow-delay="1.2s" data-wow-duration="1.5s"
										style="visibility: visible; animation-duration: 1.5s; animation-delay: 1.2s; animation-name: bounceInLeft;">
										<figure> <img style="width: 600px;margin-left: -300px"
											src="/storeManagerSystem/view/trangChuAdmin_files/responsive.png"
											class="img-responsive" alt="runtime"></figure>
									</div>
									<div class="col-md-2 wow bounceInDown" data-wow-delay="1.3s"
										style="visibility: visible; animation-delay: 1.3s; animation-name: bounceInDown;">
										<figure> <img
											src="/storeManagerSystem/view/trangChuAdmin_files/arrow.png"
											class="img-responsive" alt="runtime"></figure>
									</div>
									<div class="col-md-3 wow bounceInRight" style="margin-left: 50px">
										<div class="form-action">
											<form class="ng-pristine ng-valid ng-valid-email">
												<a href="/storeManagerSystem/buoc1">
												<button class="btn btn-default full-width" type="button">
													<i></i> <strong>Thử ngay</strong>
												</button>
												</a>
											</form>

										</div>
										<p class="text-left" style="width: 300px">
											Hãy gọi cho chúng tôi <span class="color3">0908 77 00 95
												</span> để được tư vấn
										</p>
									</div>
								</div>
							</div>
							</section>
							<script type="text/javascript">
    $(document).ready(function () {
        var slides = new Array();
        var arr = [{"Id":1,"Name":"main","Title":"Chỉ mất 30S để có 1 website chuyên nghiệp nhất hiện nay","TitleSub":"Miễn phí 100% giao diện","Summary":null,"Embed":null,"Image":"/storeManagerSystem/view/trangChuAdmin_files/slide-bg01.jpg","Image1":"/storeManagerSystem/view/trangChuAdmin_files/slide01-left.png","Image2":"/storeManagerSystem/view/trangChuAdmin_files/slide01-right.png","Link":"#","TransitionType":"fade","Image1_X":0,"Image1_Y":40,"Image1_Easing":"easeOutExpo","Image1_Animation":"lft","Image1_Style":"small_text","Image2_X":671,"Image2_Y":330,"Image2_Easing":"easeOutBack","Image2_Animation":"lft","Image2_Style":"small_text","Title_X":450,"Title_Y":40,"Title_Easing":"easeOutExpo","Title_Animation":"lft","Title_Style":"title1","TitleSub_X":450,"TitleSub_Y":90,"TitleSub_Easing":"easeOutBack","TitleSub_Animation":"lft","TitleSub_Style":"title2","Summary_X":450,"Summary_Y":150,"Summary_Easing":"easeOutExpo","Summary_Animation":"lfr","Summary_Style":"title3","Embed_X":500,"Embed_Y":240,"Embed_Easing":"easeOutExpo","Embed_Animation":"lfr","Embed_Style":"small_text","Index":1,"Inactive":false,"Timestamp":"AAAAAAAWYzk="},{"Id":3,"Name":"2","Title":"2","TitleSub":null,"Summary":null,"Embed":null,"Image":"/storeManagerSystem/view/trangChuAdmin_files/slide-bg02.jpg","Image1":null,"Image2":null,"Link":"#","TransitionType":"boxfade","Image1_X":0,"Image1_Y":0,"Image1_Easing":"easeInQuad","Image1_Animation":"sft","Image1_Style":"title1","Image2_X":0,"Image2_Y":0,"Image2_Easing":"easeInQuad","Image2_Animation":"sft","Image2_Style":"title1","Title_X":0,"Title_Y":0,"Title_Easing":"easeInQuad","Title_Animation":"sft","Title_Style":"title1","TitleSub_X":0,"TitleSub_Y":0,"TitleSub_Easing":"easeInQuad","TitleSub_Animation":"sft","TitleSub_Style":"title1","Summary_X":0,"Summary_Y":0,"Summary_Easing":"easeInQuad","Summary_Animation":"sft","Summary_Style":"title1","Embed_X":0,"Embed_Y":0,"Embed_Easing":"easeInQuad","Embed_Animation":"sft","Embed_Style":"title1","Index":2,"Inactive":false,"Timestamp":"AAAAAAAWYzQ="},{"Id":4,"Name":"3","Title":"3","TitleSub":null,"Summary":null,"Embed":null,"Image":"/storeManagerSystem/view/trangChuAdmin_files/slide-bg03.jpg","Image1":null,"Image2":null,"Link":"#","TransitionType":"boxfade","Image1_X":0,"Image1_Y":0,"Image1_Easing":"easeInQuad","Image1_Animation":"sft","Image1_Style":"title1","Image2_X":0,"Image2_Y":0,"Image2_Easing":"easeInQuad","Image2_Animation":"sft","Image2_Style":"title1","Title_X":0,"Title_Y":0,"Title_Easing":"easeInQuad","Title_Animation":"sft","Title_Style":"title1","TitleSub_X":0,"TitleSub_Y":0,"TitleSub_Easing":"easeInQuad","TitleSub_Animation":"sft","TitleSub_Style":"title1","Summary_X":0,"Summary_Y":0,"Summary_Easing":"easeInQuad","Summary_Animation":"sft","Summary_Style":"title1","Embed_X":0,"Embed_Y":0,"Embed_Easing":"easeInQuad","Embed_Animation":"sft","Embed_Style":"title1","Index":3,"Inactive":false,"Timestamp":"AAAAAAAWYzI="}];
        $.each(arr, function (index, it) {
            var obj = {
                src: it.Image,
                fade: 5000
            };
            slides.push(obj);
        });
        if (arr.length <= 0) {
            slides =[
             { src: '/storeManagerSystem/view/trangChuAdmin_files/slide-bg01.jpg', fade: 4000 },
             { src: '/storeManagerSystem/view/trangChuAdmin_files/slide-bg02.jpg', fade: 4000 },
             { src: '/storeManagerSystem/view/trangChuAdmin_files/slide-bg03.jpg', fade: 4000 }
            ]
        }

        $.vegas('slideshow', {
            delay: 4000,
            backgrounds: slides
        })('overlay', {
            src: '/storeManagerSystem/view/trangChuAdmin_files/bg-overlay.png'
        });
        if ($.fn.cssOriginal != undefined)
            $.fn.css = $.fn.cssOriginal;
        var wow = new WOW(
        {
            boxClass: 'wow',      // default
            animateClass: 'animated', // default
            offset: 0,          // default
            mobile: true,       // default
            live: true        // default
        });
        wow.init();
    });
</script>

							<section class="feature-video clearfix">
							<div class="container">
								<h3 class="text-center text-uppercase">Tự thiết kế website</h3>
								<p class="text-center">
									Bạn có thể tự tạo cho mình một website đầy đủ tính năng <span
										class="text-uppercase color3">hoàn toàn miễn phí</span> bằng
									cách <span class="text-uppercase color3">KÉO THẢ</span> giao
									diện đơn giản,dễ sử dụng
								</p>

							</div>
							</section>

							<section class="no-margin hotline no-padding" id="hotline">
							<div class="parallax">
								<div class="container">
									<div class="row">
										<h3 class="text-center text-uppercase">chúng tôi luôn sẵn
											sàng hỗ trợ khi bạn cần</h3>
										<div
											class="col-lg-4 col-md-4 col-sm-12 col-xs-12 contact-info text-center">
											<span><i class="glyphicon glyphicon-envelope"></i></span> <a
												href="mailto:runtimevn@gmail.com">Email us</a>
										</div>
										<div
											class="col-lg-4 col-md-4 col-sm-12 col-xs-12 contact-info text-center">
											<span><i class="glyphicon glyphicon-envelope"></i></span> <a
												href="tel:0908 77 00 95">0908 77 00 95</a>
										</div>
										<div
											class="col-lg-4 col-md-4 col-sm-12 col-xs-12 contact-info text-center">
											<span><i class="glyphicon glyphicon-envelope"></i></span> <a
												href="tel:0908 77 00 95"> Live chat with us</a>
										</div>

									</div>
								</div>
							</div>
							</section>
							
							<section class="feature dark-bg no-margin">
							<div class="container">
								<h3 class="animate fadeInDown text-center text-uppercase">Tại
									sao bạn nên chọn AGB.VN?</h3>
									<table>
									<tr>
											<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/ktnc.png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/ktnc.png"
																alt="Khởi tạo nhanh chóng">
														</div>
														<h3>Khởi tạo nhanh chóng</h3>
														<p style="text-align: justify;">
															Không cần phải thuê người lập trình website.<br>
																Không cần thuê hosting mỗi tháng.<br> Chỉ cần mua 1
																	tên miền và sử dụng RUNTIME.VN<br> Bạn sẽ có ngay
																		1 website đẹp và nhiều tính năng sau 15s khởi tạo.
														</p>
														<p style="text-align: justify;">&nbsp;</p>
														<p style="text-align: justify;">&nbsp;</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
												</td>
												<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img style="width: 450px"
																src="/storeManagerSystem/view/trangChuAdmin_files/thu hut khac hang (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/thu%20hut%20khac%20hang%20(FILEminimizer).png"
																alt="Thu hút khách hàng">
														</div>
														<h3>Thu hút khách hàng</h3>
														<p style="text-align: justify;">
															Càng ngày càng có nhiều khách hàng sử dụng thiết bị di
															động để truy cập website.<br> Trong hệ thống
																RUNTIME.VN, trang quản lý Website cũng như chính Website
																của bạn đều được thể hiện tốt trên mọi thiết bị di động.<br>
																	Điều này giúp khách hàng dễ dàng tìm đến bạn, giúp bạn
																	có thể quản lý website, quản lý việc kinh doanh của bạn
																	mọi lúc mọi nơi.
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
												</td>
												<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/thiet ket linh hoat (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/thiet%20ket%20linh%20hoat%20(FILEminimizer).png"
																alt="Thiết kế linh hoạt" >
														</div>
														<h3>Thiết kế linh hoạt</h3>
														<p style="text-align: justify;">
															Bạn có thể thay đổi thiết kế website của mình một cách
															nhanh chóng...<br> Ngay khi có một mẫu giao diện mới
																từ RUNTIME.VN bạn có thể chuyển đổi website của mình để
																sở hữu ngay mà không cần nhập lại dữ liệu.<br> Bạn
																	có thể tự thiết kế theo phong cách của mình ngay chính
																	trong trang quản lý website của bạn.
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
												</td>
										</tr>
										<tr>
										<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/ung dung pp (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/ung%20dung%20pp%20(FILEminimizer).png"
																alt="Ứng dụng phong phú" >
														</div>
														<h3>Ứng dụng phong phú</h3>
														<p style="text-align: justify;">
															Rất nhiều tính năng được xây dựng xung quanh vấn đề hỗ
															trợ việc kinh doanh của người chủ website.<br> Hệ
																thống RUNTIME.VN luôn nỗ lực xây dựng môi trường vững
																mạnh để các nhà phát triển giải pháp CNTT cùng chung tay
																hỗ trợ tất cả khách hàng.<br> &nbsp;
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
										</td>
										<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/Mar bat ngo (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/Mar%20bat%20ngo%20(FILEminimizer).png"
																alt="Marketing bất ngờ" >
														</div>
														<h3>Marketing bất ngờ</h3>
														<p style="text-align: justify;">
															Sẽ rất bất ngờ và thú vị cho những người hoạt động
															Marketing.<br> Hệ thống RUNTIME.VN hỗ trợ các
																website của mình có thể tự thiết kế mẫu Email Maketing,
																Landing Page, Pop up để tối ưu các kế hoạch của
																Marketer.<br> Xu hướng Marketing đỉnh cao -
																	Marketing Digital.
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
										</td>
										<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/hotro thanh toan (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/hotro%20thanh%20toan%20(FILEminimizer).png"
																alt="Hỗ trợ thanh toán">
														</div>
														<h3>Hỗ trợ thanh toán</h3>
														<p style="text-align: justify;">
															Thanh toán quốc tế, thanh toán nội địa, thanh toán trực
															tiếp... đều dễ dàng khai báo, tích hợp trong tính năng
															quản lý website.<br> Chủ website có thể an tâm kinh
																doanh online đúng nghĩa với các cổng thanh toán hoàn
																toàn an toàn trong hệ thống RUNTIME.VN
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
										</td>
										</tr>
										<tr>
										<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/ho tro van chuyen (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/ho%20tro%20van%20chuyen%20(FILEminimizer).png"
																alt="Hỗ trợ vận chuyển" >
														</div>
														<h3>Hỗ trợ vận chuyển</h3>
														<p style="text-align: justify;">
															Bạn muốn mở rộng khu vực bán hàng nhưng không đủ kinh phí
															để phát triển đại lý. Chúng tôi vẫn có thể giúp bạn kết
															nối với nhiều đơn vị vận chuyển uy tín và chất
															lượng.&nbsp;<br> Bạn muốn trao đổi thông tin với
																khách hàng không giới hạn không gian và thời gian. Chúng
																tôi sử dụng các giải pháp kết nối trực tuyến - thời gian
																thật với âm thanh và hình ảnh trung thực đi kèm.
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
										</td>
										<td style="height: 436px;">
										<div class="owl-item" style="width: 380px;padding-top: -50px">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/qlsp (FILEminimizer).png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/qlsp%20(FILEminimizer).png"
																alt="Quản lý sản phẩm" >
														</div>
														<h3>Quản lý sản phẩm</h3>
														<p>
															Sản phẩm của các website bán hàng sẽ dễ dàng nhập liệu,
															sao lưu, quản lý về số lượng và tính năng kỹ thuật.<br>
																Bạn có thể bán hàng ở bất kỳ hệ thống nào và dễ dàng
																quản lý hàng hóa của mình một cách rõ ràng, khoa học.
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
										</td>
										<td style="height: 436px">
										<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/qbsr.png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/qbsr.png"
																alt="Quảng bá sâu rộng">
														</div>
														<h3>Quảng bá sâu rộng</h3>
														<p style="text-align: justify;">
															Thương hiệu về dịch vụ hay sản phẩm của bạn sẽ được nhiều
															người biết đến.<br> Thông qua các kênh liên kết và
																các cấu trúc website chuẩn SEO&nbsp;của hệ thống AGB.VN,
																bạn có thể tin tưởng vào việc quảng bá website của mình
																đến mọi người.
														</p>

														<a class="pull-right"
															href="#"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div>
										</td>
										</tr>
										</table>
												<!-- 
												<div class="owl-item" style="width: 420px;">
													<div class="feature-item text-center wow fadeInLeft"
														style="visibility: visible; animation-name: fadeInLeft;">
														<div class="bgicons">
															<img
																src="/storeManagerSystem/view/trangChuAdmin_files/cskh.png"
																class="img-responsive lazy-img"
																data-original="/storeManagerSystem/view/trangChuAdmin_files/cskh.png"
																alt="Chăm sóc khách hàng">
														</div>
														<h3>Chăm sóc khách hàng</h3>

														<a class="pull-right"
															href="http://runtime.vn/tinh-nang.html#feature05"><i
															class="fa fa-angle-double-right"></i> Xem thêm</a>
													</div>
												</div> -->
							</div>
							</section>
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
									<nav class="text-center"> <paging
										class="small ng-isolate-scope" page="currentPage"
										page-size="pageSize" total="total" adjacent="2" dots="..."
										scroll-top="false" hide-if-empty="false" ul-class="pagination"
										active-class="active" disabled-class="disabled"
										show-prev-next="true"
										paging-action="DoCtrlPagingAct(&#39;Paging Clicked&#39;, page, pageSize, total)">
									<ul ng-hide="Hide" ng-class="ulClass" class="pagination">
										<!-- ngRepeat: Item in List -->
										<li title="First Page" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope disabled"><span ng-bind="Item.value"
											class="ng-binding">&lt;&lt;</span></li>
										<!-- end ngRepeat: Item in List -->
										<li title="Previous Page" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope disabled"><span ng-bind="Item.value"
											class="ng-binding">&lt;</span></li>
										<!-- end ngRepeat: Item in List -->
										<li title="Page 1" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope active"><span ng-bind="Item.value"
											class="ng-binding">1</span></li>
										<!-- end ngRepeat: Item in List -->
										<li title="Page 2" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope"><span ng-bind="Item.value"
											class="ng-binding">2</span></li>
										<!-- end ngRepeat: Item in List -->
										<li title="Page 3" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope"><span ng-bind="Item.value"
											class="ng-binding">3</span></li>
										<!-- end ngRepeat: Item in List -->
										<li title="Next Page" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope"><span ng-bind="Item.value"
											class="ng-binding">&gt;</span></li>
										<!-- end ngRepeat: Item in List -->
										<li title="Last Page" ng-class="Item.liClass"
											ng-click="Item.action()" ng-repeat="Item in List"
											class="ng-scope"><span ng-bind="Item.value"
											class="ng-binding">&gt;&gt;</span></li>
										<!-- end ngRepeat: Item in List -->
									</ul>
									</paging> </nav>
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