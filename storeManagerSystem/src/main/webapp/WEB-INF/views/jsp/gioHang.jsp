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
					<h1><a href="/storeManagerSystem/${LayoutForm.pathJSP }"><span>E</span> -Trang chủ</a></h1>
				</div>
	    </div>
	</nav>
	<!--/.navbar-->
</div>
</div>
		<!-- content-section-starts-here -->
		<div class="container">
			<div class="main-content">

<div id="wrapper">	
	<div class="row">
					<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thanh toán đơn hàng</h1>
			</div>
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i>Thông tin khách hàng
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       		 <div class="row">
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <form:input style="margin-top: 5px" class="form-control" placeholder="Họ và Tên"  type="text" path="hoTenKhachHang"  ng-model = "hoTenKhachHang"  ng-init ="hoTenKhachHang = '${LayoutForm.hoTenKhachHang}'" />
												<p style="color: red;">{{hoTenKhachHang_err}}</p>
										</div>
			                        </div>
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Thành phố">
										</div>
			                        </div>
			                 </div>
			                  <div class="row">
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <form:input style="margin-top: 5px" class="form-control" maxlength="12" placeholder="Số điện thoại"  type="text" path="sdtKhachHang"  ng-model = "sdtKhachHang"  ng-init ="sdtKhachHang = '${LayoutForm.sdtKhachHang}'" />
												<p style="color: red;">{{sdtKhachHang_err}}</p>
										</div>
			                        </div>
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <input type="text" class="form-control" id="usr" placeholder="Quận huyện">
										</div>
			                        </div>
			                 </div>
			                 <div class="row">
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <form:input style="margin-top: 5px" class="form-control" placeholder="Email"  type="text" path="emailKhachHang"  ng-model = "emailKhachHang"  ng-init ="emailKhachHang = '${LayoutForm.emailKhachHang}'" />
												<p style="color: red;">{{emailKhachHang_err}}</p>
										</div>
			                        </div>
			                        <div class="col-lg-5">
			                            <div class="form-group">
											  <form:input style="margin-top: 5px" class="form-control" placeholder="Địa chỉ"  type="text" path="diaChiKhachHang"  ng-model = "diaChiKhachHang"  ng-init ="diaChiKhachHang = '${LayoutForm.diaChiKhachHang}'" />
												<p style="color: red;">{{diaChiKhachHang_err}}</p>
										</div>
			                        </div>
			                 </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <div align="left">
						<p style="color: blue; font-weight: bold;">${LayoutForm.message }</p>
						<p style="color: red; font-weight: bold;">${LayoutForm.messageErr }</p>
					</div>
                    <!-- /.panel -->
                    <div class="panel panel-default" style="padding-left: 3px">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Thông tin đơn hàng
                        </div>
                    </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body" style="margin-top: -15px">
			               <div class="row">
			               	    <div class="table-responsive">
                                	<table class="table table-bordered ">
		                                	<thead>
		                                        <tr>
		                                            <th align="center" style="widows: 80px;text-align: center">Ảnh</th>
		                                            <th align="center" style="text-align: center">Tên sản phẩm</th>
		                                            <th align="center" style="widows: 50px;text-align: center">Số lượng</th>
		                                            <th align="center" style="widows: 80px;text-align: center">Đơn giá</th>
		                                            <th align="center" style="widows: 30px;text-align: center">Xóa</th>
		                                            <th align="center" style="text-align: center">Thành tiền</th>
		                                        </tr>
		                                    </thead>
		                                    <tbody>
										      <c:forEach var="items" items="${LayoutForm.products }">
										      <tr id="sanPham${items.SEQ }">
										      		<td align="center" style="widows: 80px"><img style="height: 80px;width: 70px;" src="/storeManagerSystem/myImage/${LayoutForm.pathJSP }/imageDisplay/${items.SEQ}" alt="" /></td>
													<td>${items.tenSP}</td>
													<td style="text-align: center;"><span ng-model="soLuong[${items.SEQ }]" ng-init="soLuong[${items.SEQ }] ='${items.soLuong }'">{{soLuong[${items.SEQ }]}}</span></td>
													<td align="right">
														<c:if test="${!empty items.giaBanKM }">
														<span class="item_price" ><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBanKM}" /> VNĐ</span>
														</c:if>
														<c:if test="${empty items.giaBanKM }">
														<span class="item_price" ><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan}" /> VNĐ</span>
														</c:if>	
													</td>
													<td style="text-align: center;padding-top: 20px"  ><span style="font-size: 30px" class="glyphicon glyphicon-trash" ng-click="btnRemove('${items.SEQ }', '${items.giaBan }', '${items.giaBanKM }')" data-toggle="tooltip" data-original-title="Xóa"></span></td>
													<td style="text-align: right;" ng-model="thanhTien[${items.SEQ }]" ng-init="thanhTien[${items.SEQ }] ='${items.thanhTien }'">{{thanhTien[${items.SEQ }] | number}} VNĐ</td>		
												</tr>
											</c:forEach>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold">Tổng đơn hàng</td>
													<td style="text-align: right;" ng-model="tongDonHang" ng-init="tongDonHang = '${LayoutForm.tongDonHang}'">{{tongDonHang | number}} VNĐ</td>
												</tr>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold">Tồng tiền giảm giá</td>
													<td style="text-align: right;" ng-model="tongTienGiamGia" ng-init="tongTienGiamGia = '${LayoutForm.tongTienGiamGia}'">{{tongTienGiamGia | number}} VNĐ</td>
												</tr>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold">Tổng thành tiền</td>
													<td style="text-align: right;" ng-model="tongThanhTien" ng-init="tongThanhTien = '${LayoutForm.tongThanhTien}'">{{tongThanhTien | number}} VNĐ</td>
												</tr>
												<tr>
										      		<td colspan="5" style="text-align: right;font-weight: bold"></td>
													<td style="text-align: right;width: 300px">
														<input type="button" class="btn btn-primary active" ng-click ="btnBack()" value="Tiếp tục mua hàng">
														<input type="button" class="btn btn-danger" ng-click ="btnBuyCart()" value="Thanh toán">
													</td>
												</tr>
										</tbody>
									</table>
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
					<h4>GiỚI THIỆU</h4>
					<ul class="f_nav">
						<li><a href="#">Về chúng tôi</a></li>
						<li><a href="#">Hỏi đáp</a></li>
					</ul>	
				</div>
				<div class="col-md-3 span1_of_4">
					<h4>TRỢ GIÚP</h4>
					<ul class="f_nav">
						<li><a href="#">Hướng dẫn thanh toán</a></li>
						<li><a href="#">Hướng dẫn đặt hàng</a></li>
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