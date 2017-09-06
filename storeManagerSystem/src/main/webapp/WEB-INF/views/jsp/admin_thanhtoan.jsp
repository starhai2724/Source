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
<body>
    
<!-- START HEADER -->
<header class="clearfix">
    <div class="container clearfix">
        <!-- Start navbar -->
        <nav class="navbar navbar-default navbar-fixed-top top-nav-collapse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand hidden-xs hidden-sm" href="index.html">
                        <img alt="runtime" class="scroller-logo" src="/storeManagerSystem/view/templateDK/logoHeader.jpg">
                        <img src="/storeManagerSystem/view/templateDK/logoHeader.jpg" class="default-logo img-responsive" alt="runtime">
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
<section class="paying-page" >
    <div class="container" style="font-size: 16px;font-family: 'Times New Roman';">
        <div class="row">
            <section class="col-md-9 col-sm-8 col-xs-12 clearfix text-left" id="section-scroll">
                <h1 class="text-uppercase clearfix title text-center">Hình thức thanh toán khi sử dụng dịch vụ của agb.vn</h1>
                <h2 style="font-size: 16px;font-family: 'Times New Roman';" class="text-center description">Quý khách có thể thanh toán chi phí sử dụng dịch vụ thông qua các hình thức sau:</h2>
                <div class="paying-content">
                    <p>
	Khi Quý khách quyết định sử dụng dịch vụ của chúng tôi, Quý khách có thể lựa chọn một hình thức phù hợp nhất trong 4 hình thức dưới đây để thanh toán dịch vụ một cách đơn giản và thuận tiện. Quý khách đọc kỹ hướng dẫn sử dụng bên dưới nhằm đảm bảo tính chính xác khi thanh toán.</p>
<p>
	Trong trường hợp Quý khách yêu cầu xuất hoá đơn thì Quý khách cung cấp thông tin xuất hoá đơn bao gồm: Họ và tên, nếu là tổ chức thì tên tổ chức; Địa chỉ cá nhân hoặc tổ chức; Số điện thoại liên hệ; Nếu là tổ chức thì yêu cầu thêm mã số thuế. Trong vòng một tuần làm việc Quý khách sẽ nhận được hoá đơn qua đường bưu điện hoặc trực tiếp tại AGB.</p>
<p>
	<strong>1. Thanh toán qua chuyển khoản online thẻ nội địa hoặc thẻ quốc tế Visa, Mastercard: &nbsp;Đặc biệt sẽ được kích hoạt ngay lập tức sau khi thanh toán thành công</strong><br>
	<br>
	<a href="http:/#" target="_blank">Xem hướng dẫn thanh toán thẻ quốc tế</a><br>
	<br>
	<a href="#" target="_blank">Xem hướng dẫn thanh toán&nbsp;chuyển khoản online bằng thẻ nội địa ATM</a><br>
	<br>
	<strong>2. Thu phí tận nơi</strong></p>
<p>
	RUNTIME có một đội ngũ nhân viên kinh doanh năng động, nhiệt tình, sẽ liên lạc và hẹn Quý khách thời gian để gặp trực tiếp thu phí tận nơi khi chúng tôi nhận được yêu cầu đăng ký dịch vụ của Quý khách. Hình thức này áp dụng trong phạm vi nội thành thành phố Hồ Chí Minh.</p>
<p>
	Thời gian cung cấp dịch vụ: Ngay khi nhân viên nhận được thanh toán</p>
<p>
	<strong>3. Thanh toán trực tiếp tại ABG</strong></p>
<p>
	Văn phòng Công ty TNHH Phát triển Công nghệ AGB</p>
<p>
	Số 36 Hoàng Sa, Phường Tân Định, Quận 1, Tp. Hồ Chí Minh</p>
<p>
	Giờ làm việc: 8h – 17h 30 hàng ngày từ Thứ 2 – Thứ 7.</p>
<p>
	Thời gian cung cấp dịch vụ: Ngay lập tức.</p>
<p>
	<strong>4. Thanh toán qua chuyển khoản ngân hàng (<a href="#" target="_blank">Xem hướng dẫn chi tiết</a>)</strong></p>
<p>
	Để thuận tiện và tiết kiệm thời gian di chuyển, khách hàng có thể thanh toán qua chuyển khoản ngân hàng hoặc Internet banking.</p>
<p>
	Thời gian cung cấp dịch vụ: Trước 09h00 và 15h00 các ngày trong tuần (trừ thứ 7, chủ nhật, ngày nghỉ lễ) AGB sẽ check thông tin thanh toán qua chuyển khoản và kích hoạt dịch vụ ngay nhận được thanh toán.</p>
<p>
	Quý khách muốn dịch vụ được kích hoạt ngay mà không cần chờ đợi thêm thời gian tiền được chuyển, Quý khách chỉ cần scan biên lai hoặc giấy ủy nhiệm chi và gửi vào địa chỉ runtimevn@gmail.com chúng tôi sẽ kích hoạt dịch vụ ngay khi được email và xác nhận việc thanh toán là chính xác.</p>
<p>
	Lưu ý: Khi bạn thanh toán bằng chuyển khoản ngân hàng</p>
<p>
	Bạn vui lòng để lại những thông tin sau trong nội dung chuyển tiền để công ty kích hoạt nhanh chóng cho bạn:</p>
<p>
	Nội dung thanh toán sẽ như sau:</p>
<p>
	1. Thanh toán domain : nội dung “TTDV Domain domain.com”</p>
<p>
	2. Thanh toán chi phí thiết kế và các chi phí khác : nội dung “TTDV thietke website ten_website”</p>
<p>
	3. Thanh toán, thay đổi hoặc gia hạn gói dịch vụ : Nội dung “TTDV Mã_dịch_vụ”</p>
<p>
	Ví dụ:</p>
<p>
	- Bạn thanh toán phí gói dịch vụ cho website vuonxinh.runtime.vn có mã dịch vụ TTDV 902902161000473:</p>
<p>
	nội dung: “TTDV 902902161000473″</p>
<p>
	- Bạn thanh toán tên miền runtime.vn</p>
<p>
	nội dung “TTDV Domain runtime.vn”</p>
<p>
	Hoặc bạn ghi số điện thoại trong nội dung chuyển khoản để RUNTIME có thông tin để xác nhận</p>
<p>
	(bạn vui lòng để lại nội dung thanh toán, dịch vụ RUNTIME sẽ được kích hoạt nhanh chóng hơn)</p>
<p>
	<strong>Ngân hàng Thương Mại Cổ Phần Ngoại Thương Việt Nam - Chi nhánh bắc Sài Gòn. ( Vietcombank )&nbsp;</strong></p>
<p>
	Chủ tài khoản: Công Ty TNHH Phát Triển Công Nghệ AGB</p>
<p>
	Số tài khoản: 0501000097019.<br>
	&nbsp;</p>
<p>
	<strong>Ngân hàng Việt Nam Thịnh Vượng - Chi nhánh Gia Định (</strong>VPBank<strong>)</strong></p>
<p>
	Chủ tài khoản: Công Ty TNHH Phát Triển Công Nghệ AGB.</p>
<p>
	Số tài khoản:&nbsp;60862017. &nbsp;</p>
<p>
	Mọi thắc mắc quý khách vui lòng liên hệ với bộ phận CSKH của chúng tôi. Các nhân viên CSKH của luôn sẵn sàng hỗ trợ, giải đáp mọi thắc mắc của quý khách hàng. Hotline 0908770095.<br>
	<br>
	<strong>Rất hân hạnh được phục vụ quý khách</strong><br>
	<strong>AVG - Giải pháp thương mại điện tử hàng đầu Việt Nam</strong><br>
	&nbsp;</p>

                </div>
            </section>
        </div>
    </div>
</section>
<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebar').affix({
            offset: {
                top: 100
            }
        });

        var $body = $(document.body);
        var navHeight = $('.navbar').outerHeight(true) + 20;

        $body.scrollspy({
            target: '#leftCol',
            offset: navHeight
        });

        $('#leftCol ul li a').on('click', function () {
            var el = $(this).attr("href");
            $('html,body').animate({ scrollTop: $(el).offset().top - 60 }, 800);
            $("#mySidebar").collapse('hide');
        });
        $('#mySidebar ul li a').on('click', function () {
            $("#btnMySidebar").trigger("click");
        });
    });
</script>
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
