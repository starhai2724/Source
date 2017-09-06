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
<div class="inner-heading feauture-page-bg">
    <div class="overlay-bg"></div>
</div>
<section class="feature-page paying-page">
    <div class="container" style="font-size: 16px;font-family: 'Times New Roman';">
        <div class="row">
            <section class="col-md-9 col-sm-8 col-xs-12 text-left" id="section-scroll">
                <h1 class="text-uppercase clearfix title text-center">AGB.vn đầy đủ những tính năng bạn cần</h1>
                    <div class="feature-content clearfix" id="feature01">
                        <div class="feature-content clearfix">
	<div class="col-md-6" style="text-align: justify;">
		<u><strong>Khởi tạo nhanh chóng</strong></u>
		<div style="text-align: justify;">
			Thông thường bạn sẽ gặp trở ngại với việc bắt đầu tạo một website cho công việc của mình. Bạn không biết mình phải thiết kế giao diện web như thế nào? không biết sẽ chọn đơn vị nào lập trình cho mình? rồi lại phải quan tâm đến hosting, domain...? &nbsp;</div>
		<div style="text-align: justify;">
			Tất cả những gì phải chuẩn bị để có 1 website sẽ làm bạn tốn rất nhiều thời gian tìm hiểu và ảnh hưởng không nhỏ đến các kế hoạch kinh doanh của bạn.</div>
		<div style="text-align: justify;">
			AGB.vn chúng tôi hiểu những khó khăn của người cần làm website và chúng tôi hoạt động nhằm giảm bớt những việc rắc rối sẽ xảy đến với bạn.</div>
		<div style="text-align: justify;">
			&nbsp;</div>
		<div style="text-align: justify;">
			Ngay khi khởi tạo một website với AGB.vn xem như là bạn đã làm xong nhiều việc: Chọn lựa một giao diện hợp lý + Lập trình + Thuê hosting + Upload toàn bộ mã nguồn lập trình của bạn lên hosting và thực hiện hàng loạt các thao tác khởi chạy nó.</div>
		<div style="text-align: justify;">
			&nbsp;</div>
	</div>
	<div class="col-md-6" style="text-align: center;">
		<img alt="" class="img-responsive" src="/storeManagerSystem/view/templateDK/khoi tao nhanh chong (FILEminimizer).png" style="width: 80%;"></div>
</div>
<p>
	&nbsp;</p>

                    </div>
                    <div class="feature-content clearfix" id="feature02">
                        <div class="feature-content clearfix">
	<div class="col-md-6" style="text-align: center;">
		<img alt="" class="img-responsive" src="/storeManagerSystem/view/templateDK/thu hut khac hang (FILEminimizer).png" style="width: 80%;"></div>
	<div class="col-md-6" style="text-align: justify;">
		<div style="text-align: justify;">
			<u><strong>Thu hút khách hàng</strong></u></div>
		<div style="text-align: justify;">
			Thuật toán tìm kiếm và sắp xếp các website tìm kiếm được của Google luôn luôn đổi mới, chính vì vậy muốn trang web mình tạo ra được Google đánh giá cao và sắp xếp lên top đầu mỗi khi có người tìm kiếm bạn phải hiểu các thay đổi trong thuật toán của Google.</div>
		<div style="text-align: justify;">
			Năm 2015, một trong những tiêu chí website được Google ưu tiên tìm kiếm đó là website phải được thể hiện trên nền tảng di động.</div>
		<div style="text-align: justify;">
			&nbsp;</div>
		<div style="text-align: justify;">
			AGB.VN nắm được những tiêu chí đánh giá này và bằng cách nỗ lực lập trình để gửi đến khách hàng những sản phẩm website hoạt động &amp; quản lý bằng thiết bị di động.</div>
		<div style="text-align: justify;">
			Điều này giúp khách hàng dễ dàng tìm đến bạn, giúp bạn có thể quản lý website, quản lý việc kinh doanh của bạn mọi lúc mọi nơi.</div>
		<div style="text-align: justify;">
			&nbsp;</div>
		<div style="text-align: justify;">
			Nếu bạn cần một website đạt yêu cầu tìm kiếm của Google?</div>
		<div style="text-align: justify;">
			Nếu bạn cần một website giúp khách hàng tìm đến bạn cũng như giúp bạn quản lý mọi lúc mọi nơi?</div>
		<div style="text-align: justify;">
			Hãy đến với AGB.VN.</div>
	</div>
</div>
<p>
	&nbsp;</p>

                    </div>
                    <div class="feature-content clearfix" id="feature03">
                        <div class="feature-content clearfix">
	<div class="col-md-4" style="text-align: justify;">
		<p>
			<u><strong>Thiết kế linh hoạt</strong></u></p>
		<p>
			Việc dễ dàng thay đổi thiết kế giúp các nhà xây dựng thương hiệu, các hoạt động marketing dễ dàng thay đổi diện mạo website của mình theo kế hoạch một cách linh động.</p>
		<p>
			Bạn có thể chọn nhiều cấu trúc thể hiện khác nhau cho từng trang con trong website để tăng tính hấp dẫn về mỹ thuật cho website mình.</p>
		<p>
			Bạn có thể tùy biến màu sắc, cách thức thể hiện cho hình ảnh, nội dung trong các tính năng tùy chỉnh html/css của trang.</p>
	</div>
	<div class="col-md-8" style="text-align: center;">
		<img alt="" src="/storeManagerSystem/view/templateDK/thiet ket linh hoat (FILEminimizer).png" style="width: 65%;"></div>
</div>
<p>
	&nbsp;</p>

                    </div>
                    <div class="feature-content clearfix" id="feature04">
                        <div class="feature-content clearfix">
	<div class="col-md-6" style="text-align: center;">
		<img alt="" class="img-responsive" src="/storeManagerSystem/view/templateDK/ung dung pp (FILEminimizer).png" style="width: 90%;"></div>
	<div class="col-md-6" style="text-align: justify;">
		<p style="text-align: justify;">
			<u><strong>Ứng dụng phong phú</strong></u></p>
		<p style="text-align: justify;">
			Các tính năng được chọn lọc để hỗ trợ khách hàng bắt nguồn từ nhu cầu thực tế của khách hàng mong muốn về website của họ. AGB.VN cùng những nhà phát triển giải pháp CNTT Việt Nam đã xây dựng lên một môi trường ứng dụng nhằm hỗ trợ tối ưu cho khách hàng.</p>
		<p style="text-align: justify;">
			Hỗ trợ thanh toán, quản lý sản phẩm, marketing, vận chuyển, quảng bá, chăm sóc khách hàng... tất cả đều nằm trong định hướng hỗ trợ khách hàng của AGB.VN</p>
		<p style="text-align: justify;">
			Với những tính năng được xây dựng riêng cho một số ngành nghề kinh doanh đặc thù hay được phát triển bởi các nhà cung ứng giải pháp, chúng tôi tách ra thành những gói ứng dụng tính phí để khi bạn cần, bạn mới trả phí cho chúng tôi. Điều này giúp cho đội ngũ xây dựng ứng dụng, chăm sóc website của khách hàng có kinh phí để phát triển chất lượng tốt hơn, đồng thời tiết kiệm cho khách hàng những chi phí không cần thiết.</p>
	</div>
	<div class="col-md-12" style="text-align: justify;">
		<p style="text-align: justify;">
			Chúng tôi luôn bên cạnh để lắng nghe nhu cầu, tư vấn giải pháp, tích hợp các tính năng tối ưu cho website của bạn.<br>
			Thành công của các bạn là thành công của chúng tôi.</p>
	</div>
</div>

                    </div>
                    <div class="feature-content clearfix" id="feature05">
                        <div class="feature-content clearfix">
	<div class="col-md-4" style="text-align: justify;">
		<p style="text-align: justify;">
			<strong>Tính năng hỗ trợ Marketing:</strong></p>
		<ul>
			<li style="text-align: justify;">
				Phát triển các hệ thống server mail để khách hàng có thể sử dụng chính mail mang thương hiệu của họ gửi đến khách hàng.</li>
			<li style="text-align: justify;">
				Phát triển Landing Page để những người hoạt động marketing sử dụng làm tăng lượng traffic đổ về website, quảng bá hữu hiệu, tăng hiệu suất bán hàng, tổ chức events... v.v</li>
		</ul>
		<img alt="" src="/storeManagerSystem/view/templateDK/Mar bat ngo (FILEminimizer).png" style="width: 100%;"></div>
	<div class="col-md-4" style="text-align: justify;">
		<p style="text-align: justify;">
			<strong>Tính năng hỗ trợ thanh toán:</strong></p>
		<ul>
			<li style="text-align: justify;">
				Thanh toán quốc tế, thanh toán nội địa, thanh toán trực tiếp... đều dễ dàng khai báo, tích hợp trong tính năng quản lý website.&nbsp;</li>
			<li style="text-align: justify;">
				Chủ website có thể an tâm kinh doanh online đúng nghĩa với các cổng thanh toán hoàn toàn an toàn trong hệ thống AGB.VN</li>
		</ul>
		<p>
			&nbsp;</p>
		<img alt="" src="/storeManagerSystem/view/templateDK/hotro thanh toan (FILEminimizer).png" style="width: 100%;"></div>
	<div class="col-md-4" style="text-align: justify;">
		<p style="text-align: justify;">
			<strong>Tính năng hỗ trợ vận chuyển:</strong></p>
		<ul>
			<li style="text-align: justify;">
				Hàng hóa và tiền thanh toán của bạn sẽ luôn được bạn quản lý một cách an toàn suốt tiến trình giao nhận hàng hóa.</li>
			<li style="text-align: justify;">
				Chủ website có thể tự chọn dịch vụ vận chuyển,&nbsp;tự quy đinh mức giá vận chuyển để cân đối cho các hoạt động thường gặp rủi ro khi mua bán hàng hóa.</li>
		</ul>
		<img alt="" src="/storeManagerSystem/view/templateDK/ho tro van chuyen (FILEminimizer).png" style="width: 100%;"></div>
</div>
<p>
	&nbsp;</p>

                    </div>
                    <div class="feature-content clearfix" id="feature05">
                        
                    </div>
                    <div class="feature-content clearfix" id="feature05">
                        <div class="feature-content clearfix">
	<div class="col-md-4" style="text-align: justify;">
		<p style="text-align: justify;">
			<strong>Tính năng quản lý sản phẩm:</strong></p>
		<ul>
			<li style="text-align: justify;">
				Quản lý sản phẩm trên website theo số lượng, màu sắc, chất lượng... Số liệu tồn kho của mỗi sản phẩm sẽ được thay đổi theo trạng thái của các đơn hàng.</li>
			<li style="text-align: justify;">
				Báo cáo kết quả kinh doanh thông qua website một cách nhanh chóng bằng cách xuất ra các file báo cáo .xls (excel)</li>
			<li style="text-align: justify;">
				Hàng hóa sản phẩm của bạn có thể xuất ra các mã vạch, barcode để dể dàng quản lý trong của hàng. Khi hàng hóa được bán đi, bạn chỉ cần quét mã vạch, barcode kho hàng sẽ cập nhật số liệu cho bạn một cách nhanh chóng.</li>
		</ul>
		<img alt="" src="/storeManagerSystem/view/templateDK/qlsp (FILEminimizer).png" style="width: 100%;">
		<p>
			&nbsp;</p>
	</div>
	<div class="col-md-4" style="text-align: justify;">
		<p style="text-align: justify;">
			<strong>Tính năng quảng bá:</strong></p>
		<ul>
			<li style="text-align: justify;">
				Liên kết&nbsp;mạng xã hội, mạng thương mại điện tử&nbsp;sẽ giúp cho người kinh doanh có nhiều&nbsp;cầu nối quảng bá sản phẩm&nbsp;mình kinh doanh đến với người tiêu dùng.</li>
			<li style="text-align: justify;">
				Thay đổi nhận thức của khách hàng đối với&nbsp;sản phẩm của người kinh doanh thông qua các kênh truyền thông, tin tức. Hỗ trợ tối ưu cho các hoạt động xây dựng thương hiêu, tăng doanh số trong kinh doanh.</li>
			<li style="text-align: justify;">
				Dễ dàng đưa thông tin hàng hóa, dịch vụ kinh doanh đến người cần sử dụng bằng cách tối ưu hóa SEO - đáp ừng các thuật toán tìm kiếm website của Google.</li>
		</ul>
		<img alt="" src="/storeManagerSystem/view/templateDK/quan ba sau rong (FILEminimizer).png" style="width: 100%;"></div>
	<div class="col-md-4" style="text-align: justify;">
		<p style="text-align: justify;">
			<strong>Tính năng chăm sóc khách hàng:</strong></p>
		<ul>
			<li style="text-align: justify;">
				Dễ dàng chat trực tiếp với nhiều khách hàng trong cùng một thời gian, thậm chí bạn có thể sử dụng video call để tương tác với khách hàng của mình.</li>
			<li style="text-align: justify;">
				Hiểu rõ sở thích của khách hàng với sản phẩm của mình để chăm sóc việc bán hàng cũng như hậu mãi cho khách hàng một cách tốt nhất.</li>
			<li style="text-align: justify;">
				Tự động mời khách hàng của mình những sản phẩm tương tự hoặc đi kèm với sản phẩm đã chọn để giúp người bán hàng cảm thấy mình được phục vụ một cách đầy đủ và tận tình.... doanh số của bạn cũng tăng lên.</li>
		</ul>
		<p style="text-align: justify;">
			<img alt="" src="/storeManagerSystem/view/templateDK/6 (FILEminimizer).png" style="width: 100%;"></p>
	</div>
</div>
<p>
	&nbsp;</p>

                    </div>
                    <div class="feature-content clearfix" id="feature05">
                        
                    </div>
                    <div class="feature-content clearfix" id="feature05">
                        
                    </div>
                    <div class="feature-content clearfix" id="feature05">
                        
                    </div>
            </section>
        </div>
    </div>
</section>
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
