<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="ThoiHanSuDungForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thông Tin Cửa Hàng</h1>
			</div>
			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
	<form:form id="DangKiWebForm" modelAttribute="DangKiWebForm" role="form" method="POST"  enctype="multipart/form-data">
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tên cửa hàng</label> 
					<form:input maxlength="20" placeholder="Tên cửa hàng"  class="form-control" type="text" path="tenWebSite"  name="tenWebSite" ng-model = "tenWebSite"  ng-init ="tenWebSite = '${DangKiWebForm.tenWebSite}'" />
					<form:input class="form-control" type="hidden" path="pathJSP"  name="pathJSP" />
					<p style="color: red;">{{tenWebSite_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Số điện thoại liên hệ</label> 
					<form:input maxlength="12" placeholder="Số điện thoại liên hệ"  class="form-control" type="text" path="sdt"  name="sdt" ng-model = "sdt"  ng-init ="sdt = '${DangKiWebForm.sdt}'" />
					<p style="color: red;">{{sdt_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Địa chỉ cửa hàng</label> 
					<form:input maxlength="30" placeholder="Địa chỉ cửa hàng"  class="form-control" type="text" path="diaChi"  name="diaChi" ng-model = "diaChi"  ng-init ="diaChi = '${DangKiWebForm.diaChi}'" />
					<p style="color: red;">{{diaChi_err}}</p>
				</div>
			</div>
		</div>
		 <div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Điều kiện giao hàng miễn phí</label> 
	                <form:input maxlength="50" placeholder="Điều kiện giao hàng miễn phí"  class="form-control" type="text" path="dkGiaoHangFree"  name="dkGiaoHangFree" ng-model = "dkGiaoHangFree"  ng-init ="dkGiaoHangFree = '${DangKiWebForm.dkGiaoHangFree}'" />
					<p style="color: red;">{{dkGiaoHangFree_err}}</p>
				</div>
			</div>
			 <div class="col-sm-3">
				<div class="form-group">
					<label>Đường dẫn Fanpage Facebook</label> 
	                <form:input  placeholder="Đường dẫn Fanpage Facebook"  class="form-control" type="text" path="linkFanpage"  name="linkFanpage" ng-model = "linkFanpage"  ng-init ="linkFanpage = '${DangKiWebForm.linkFanpage}'" />
					<p style="color: red;">{{linkFanpage_err}}</p>
				</div>
			</div> 
			<div class="col-sm-3">
				<div class="form-group">
					<label>Hình ảnh header 1</label> 
					<input type="file" name="hinh1"/>
				</div>
			</div> 
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Hình ảnh header 2</label> 
					<input type="file" name="hinh2"/>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Hình ảnh header 3</label> 
					<input type="file" name="hinh3"/>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Hình ảnh header 4</label> 
					<input type="file" name="hinh4"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Hình ảnh header 5</label> 
						<input type="file"  name="hinh5"/>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${DangKiWebForm.message }</p>
					<p style="color: red; font-weight: bold;">${DangKiWebForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 80%">
			<div>
				
				<button type="button" class="btn btn-info" ng-click ="btnUpdate()">
				  <i class="glyphicon glyphicon-pencil"></i> Cập nhật
				</button>
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnUpdate()" value="Cập nhật"> -->
			</div>
		</div>
</form:form>	
		</div>
		<!-- Detail (S) -->
	</div>
<script src="/storeManagerSystem/view/js/thongTinCH.js"></script>
<!-- /#wrapper -->
