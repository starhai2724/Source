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
    <link href="/storeManagerSystem/view/templateDK/logo-AGB.png" rel="shortcut icon" type="image/x-icon" />
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
<body>
    
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

										<li><a href="http://localhost:8080/storeManagerSystem/adminGioiThieu" id=""
											class="" style="font-size: 16px">Giới thiệu</a></li>
										<li><a style="font-size: 16px" href="http://localhost:8080/storeManagerSystem/admin_khoGiaoDien" id="">Kho
												giao diện</a></li>
										<li><a style="font-size: 16px" href="http://localhost:8080/storeManagerSystem/adminTinhNang" id="">Tính
												năng</a></li>
									</ul>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
        <!-- End navbar -->
    </div>
</header>
<div class="inner-heading intro-page">
    <div class="overlay-bg"></div>
    <div class="container">
        <div class="row ">
        </div>
    </div>
</div>
<section class="text-center intro-page-bg no-margin-top no-padding-top">
	<div class="container-fluid review">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h1 style="text-align: justify;">
						AGB.VN</h1>
					<h2 style="text-align: justify;">
						Giải pháp hỗ trợ Bán hàng trực tuyến cho mọi người</h2>
				</div>
			</div>
		</div>
	</div>
	<div class="container text-left" style="font-size: 16px;font-family: 'Times New Roman';">
		<div class="row">
			<div class="col-md-12">
				<h6>
					<span>Môi trường website RTC</span></h6>
			</div>
			<article class="clearfix">
				<div class="col-md-5">
					<div class="box-img">
						<img class="img-responsive" src="/storeManagerSystem/view/templateDK/7_150.jpg"></div>
				</div>
				<div class="col-md-7">
					<p style="text-align: justify;">
						<strong>ABG.VN</strong>&nbsp;là một thương hiệu Việt, được xây dựng từ một tập thể nhiều kinh nghiệm và đầy nhiệt huyết trong lĩnh vực cung cấp giải pháp công nghệ số. Với tiêu chí hỗ trợ xây dựng và phát triển&nbsp;thị trường thương mại diện tử Việt Nam, <strong>AGB.vn</strong> luôn tập trung phát triển những sản phẩm chủ lực cho việc quản trị doanh nghiệp, hỗ trợ bán hàng dễ dàng &amp; hiệu quả.</p>
					<br>
					<p style="text-align: justify;">
						<strong>ABG.VN</strong> là một môi trường website. Trên môi trường website này, người sử dụng có thể tự khởi tạo cho riêng mình một website mang phong cách của chính mình. Với các tính năng hỗ trợ được xây dựng từ các nhà cung cấp giải pháp có uy tín như Thanh toán online; Theo dõi lịch trình giao nhận đơn hàng trực tuyến; Chat với khách hàng..v.v... người sử dụng web từ hệ thống <u>AGB.VN</u> để bán hàng sẽ luôn dễ dàng chăm sóc và quản lý việc kinh doanh của mình một cách tốt nhất.&nbsp;</p>
				</div>
			</article>
			<div class="col-md-12 margin-top">
				<h6>
					&nbsp;</h6>
				<h6>
					<span>"Bán hàng online dễ đến bất ngờ...!"</span></h6>
			</div>
			<article class="clearfix">
				<div class="col-md-7 ">
					<p style="text-align: justify;">
						Website được tạo ra từ môi trường <strong>AGB.VN</strong>&nbsp;vô cùng thân thiện với người dùng. Ngay cả khi bạn không có kỹ năng về Internet hay phần mềm bạn vẫn có thể dễ dàng quản lý kho hàng, sản phẩm, khách hàng và viết bài quảng cáo sản phẩm của mình vào bất cứ lúc nào, ở bất kỳ nơi đâu, trên mọi thiết bị di động.</p>
					<p style="text-align: justify;">
						ABG.VN chúng tôi luôn hướng đến mục tiêu mang lại giá trị đích thực cho khách hàng với sản phẩm chất lượng ổn định, tối ưu hóa việc kinh doanh qua mạng, giúp khách hàng dễ dàng nắm bắt các cơ hội thành công mới trong kinh doanh. Thành công của khách hàng cũng chính là thành công của chúng tôi.</p>
				</div>
				<div class="col-md-5 ">
					<div class="box-img">
						<img class="img-responsive" src="/storeManagerSystem/view/templateDK/img2.jpg"></div>
				</div>
			</article>
			<article class="clearfix list-content">
				<div class="col-md-12">
					<h6>
						&nbsp;</h6>
					<h6>
						&nbsp;</h6>
					<h6>
						<span>"Điểm sáng công nghệ số"</span></h6>
					<ul class="list-unstyled">
						<li class="col-md-6">
							<h5 class="text-uppercase">
								Tiết kiệm chi phí</h5>
							<div style="text-align: justify;">
								<span>Chi phí là yếu tố sống còn của người kinh doanh. Khi lựa chọn AGB.VN, bạn đã tiết kiệm đáng kể một khoản chi phí cho việc kinh doanh trên Internet vì tất cả các dịch vụ, sản phẩm của AGB.VN đều có giá cả hợp lý hơn so với thị trường.</span></div>
						</li>
						<li class="col-md-6">
							<h5 class="text-uppercase">
								Tiết kiệm thời gian</h5>
							<div style="text-align: justify;">
								<span>Chỉ sau 30 giây bắt tay vào thiết kế web cho chính mình, bạn đã có thể bắt đầu kinh doanh qua website đó. Nếu bạn là người không chuyên về internet, phần mềm, bạn cũng không phải mất nhiều thời gian tìm hiểu, nghiên cứu vì việc thiết kế web theo ý của bạn trên AGB.VN vô cùng đơn giản.</span></div>
						</li>
						<li class="col-md-6">
							<h5 class="text-uppercase">
								Thiết kế tùy chỉnh, chuyên nghiệp</h5>
							<div style="text-align: justify;">
								<span>Kho giao diện của AGB.VN đa dạng với nhiều thiết kế đẹp, chuyên nghiệp. Đặc biệt khách hàng còn có thể tự thiết kế theme riêng cho website của mình.</span></div>
							<div style="text-align: justify;">
								&nbsp;</div>
							<ul>
								<li style="text-align: justify;">
									Phù hợp cho Marketer, người luôn quan tâm đến sự kiện mới.</li>
								<li style="text-align: justify;">
									Hấp dẫn với Designer, với những người làm Branding, các bạn luôn quan tâm đến những xu hướng mỹ thuật mới.</li>
								<li style="text-align: justify;">
									Tiện lợi cho khách hàng là người quản lý các website, là chủ của những shop online, người luôn cần trang trí website mỗi dịp Lễ, Event...</li>
							</ul>
							<div style="text-align: justify;">
								Bởi vì... sau khi đã hoàn thành trang web trên môi trường AGB.VN và đưa vào sử dụng, bạn có thể sử dụng tên miền riêng, thay đổi thông tin, hình ảnh cũng như giao diện trên đó bất kỳ lúc nào một cách dễ dàng. Đây là ưu điểm mà không phải hệ thống thiết kế website nào cũng có.&nbsp;</div>
						</li>
						<li class="col-md-6">
							<h5 class="text-uppercase">
								Quảng bá hiệu quả</h5>
							<div style="text-align: justify;">
								Với cấu trúc thiết kế website phù hợp với các thuật toán tìm kiếm của Google, cùng với việc hỗ trợ hướng dẫn khách hàng trình bày nội dung các bài viết đạt chuẩn SEO, các dịch vụ, sản phẩm của bạn sẽ luôn được quảng bá một cách hiệu quả.</div>
							<div style="text-align: justify;">
								Chúng tôi sẽ tiếp tục cố gắng xây dựng những liên kết - kết nối với các trang mạng xã hội, thương mại điện tử uy tín để những sản phẩm của các bạn cùng với website của hệ thống AGB.VN chúng tôi thật dễ dàng đến với mọi người.</div>
						</li>
						<li class="col-md-6">
							<h5 class="text-uppercase">
								Giải pháp thương mại điện tử toàn diện</h5>
							<div style="text-align: justify;">
								AGB.VN chúng tôi cam kết sẽ luôn phấn đấu xây dựng một môi trường website toàn diện. Chúng tôi sẽ đồng hành cùng những nhà cung cấp giải pháp, dịch vụ tốt nhất để luôn tạo cho khách hàng một môi trường tối ưu thực hiện các dự án thương mại điện tử của mình.</div>
							<div>
								&nbsp;</div>
						</li>
					</ul>
				</div>
			</article>
			<article>
				<div class="col-md-12">
					<p style="text-align: justify;">
						Hãy <a href="http://AGB.vn/dang-ky.html">tạo ngay</a> website trên hệ thống AGB.VN để trải nghiệm cảm giác bán hàng online - hoàn toàn miễn phí trong vòng 15 ngày sau khi khởi tạo &amp; thiết kế. Bạn có thể bán hàng thời vụ và khi cảm thấy hài lòng, hãy liên hệ với chúng tôi để đưa trang web của bạn vào hoạt động lâu dài.</p>
					<section class="text-center no-margin-top no-padding-top">
						<div class="quote-footer text-right">
							<strong>Luy Xiêng</strong><br>
							<a href="http://AGB.vn/gioi-thieu.html#">CEO AGB.VN</a></div>
					</section>
				</div>
			</article>
		</div>
	</div>
</section>
<p>
	&nbsp;</p>
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
