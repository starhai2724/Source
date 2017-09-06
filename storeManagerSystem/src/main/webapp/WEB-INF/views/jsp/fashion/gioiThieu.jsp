<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>

<title>${LayoutForm.tenCuaHang}</title>
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
							<a href="javascript:void(0)">
								<h3> <span ng-model = "cartPrice" >{{cartPrice | number}}VNĐ</span>(<span ng-model = "cartQuantity"  >{{cartQuantity}}</span>)<img src="/storeManagerSystem/view/fontend_index2/images/bag.png" alt=""></h3>
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
					<h1><a href="/storeManagerSystem/${LayoutForm.pathJSP }"><span>E</span> -${LayoutForm.tenCuaHang}</a></h1>
				</div>
	    </div>
	</nav>
	<!--/.navbar-->
</div>
</div>
		<!-- content-section-starts-here -->
		<div class="container">
			<div class="main">
  <div class="container" style="width: 1070px">
    <div class="row">
      <div class="col-md-12">
			<div class="about-detail">
			    <div class="about-block">
			        <h1>Về chúng tôi</h1>
			        <div class="content">
			            <div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Dưới đây là nội dung mẫu của chúng tôi. Nội dung này chỉ mang tính chất minh họa:</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Royal Hotel - Khách sạn Hoàng Gia nằm giữa tuyến đường chính của khu du lịch, bên bờ vịnh Cát Bà xinh đẹp, có vị trí thuận tiện về giao thông, chỉ cách bến tàu cao tốc 50 m cách bến xe ô tô 20 m.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Khách sạn có 698 phòng nghỉ được thiết kế hài hòa trang nhã,trang thiết bị sang trọng, hiện đại đạt tiêu chuẩn Quốc tế 5 sao. Trong đó có 150 phòng đặc biệt, 200 phòng cao cấp 100 phòng hạng sang, 150 phòng tiêu chuẩn.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Hệ thống nhà hàng sang trọng, không gian thoáng đãng, tươi mới, hiện đại phục vụ được trên 10.000 thực khách. Nhà hàng nằm trên tầng 21 của khách sạn là nơi có tầm nhìn lý tưởng bao quát khu du lịch, chuyên phục các món ăn Âu, Trung Quốc và Việt nam và trên toàn thế giới với các món ăn ngon được chế biến từ các đầu bếp chuyên nghiệp cùng với phong cảnh thiên nhiên kỳ vĩ mà thiên nhiên ban tặng chắc chắn sẽ làm quý khách hài lòng. Vườn Thượng uyển trên tầng 13 là nơi tổ chức các bữa tiệc ngoài trời, các chương trình Ga la, hát karaoke theo yêu cầu của quý khách.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Khách sạn Royal Hotel có một phòng hội nghị lớn diện tích gần 200m2 ở tầng 6 với số lượng lên đến 10000 người và 98 phòng họp khác có sức chứa từ 5000 đến 8000 người có thể được bố trí và sắp xếp thành các phòng đa chức năng tuỳ theo yêu cầu của quý khách. Ngoài ra, khách sạn Royal Hotel có hội trường tầng 10 với sức chứa từ 70-100 khách. Được bố trí theo hình lớp học hoặc chữ U theo yêu cầu của quý khách, được thiết kế trang trọng với hệ thống âm thanh ánh sáng hiện đại sẽ đáp ứng hoàn hảo cho các cuộc họp ,hội nghị, tiệc hoặc sự kiện đặc biệt của quý khách.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Câu lạc bộ sức khỏe nằm trên tầng 30 của khách sạn với hệ thống các phòng massage VIP, SPA, Foot massage,... làm cho quý khách được thư giãn sau một ngày mệt mỏi. Dịch vụ giải trí và thư giãn đa dạng và phong phú đáp ứng mọi nhu cầu của mọi đối tượng khách hàng.</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				&nbsp;</div>
			<div style="margin: 0px; padding: 0px; color: rgb(55, 55, 55); line-height: 18px;">
				Với đội ngũ nhân viên nhiệt tình và hiếu khách, phong cách phục vụ chuyên nghiệp chắc chắn sẽ đem lại cho quý khách một ấn tượng tuyệt vời!</div>
			
			        </div>
			        <div class="social-group">
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
					<h4>GiỚI THIỆU</h4>
					<ul class="f_nav">
						<li> <a ng-click="btnGioiThieu()">Về chúng tôi</a></li>
                        <li>
                            <a ng-click="btnLienHe()">Hỏi đáp</a>
                        </li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>TRỢ GIÚP</h4>
					<ul class="f_nav">
						<li><a ng-click="btnHuongDan()">Hướng dẫn thanh toán</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>THÔNG TIN CỬA HÀNG</h4>
					<ul class="f_nav">
						<li><a href="account.html">${LayoutForm.tenCuaHang}</a></li>
						<li><a href="#">${LayoutForm.diaChi}</a></li>
						<li><a href="#">Số điện thoại: ${LayoutForm.soDienThoai}</a></li>
					</ul>				
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>FACEBOOK</h4>
                       <div class="fb-like-box" data-href="https://www.facebook.com/C%E1%BB%ADa-h%C3%A0ng-th%E1%BB%9Di-trang-255302581636729/" data-width="289"
                             data-height="190" data-colorscheme="dark" data-show-faces="true" data-header="false"
                             data-stream="false" data-show-border="false">
                        </div>
                        <div class="social-icon">
                            <ul>
                                <li><a target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="https://www.facebook.com/C%E1%BB%ADa-h%C3%A0ng-th%E1%BB%9Di-trang-255302581636729/" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a target="_blank"><i class="fa fa-youtube"></i></a></li>
                                <li><a target="_blank"><i class="fa fa-twitter "></i></a></li>
                            </ul>
                        </div>		
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
</form:form>
<script src="/storeManagerSystem/view/js/shoppingCart.js"></script>
</div>
</body>
</html>