<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="storeOwner" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Đăng kí người dùng</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form id="storeOwnerForm" role="form" method="POST" action="/storeManagerSystem/storeOwnerInsert">
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Họ tên</label> 
					<input class="form-control" type="text" placeholder="Họ tên" name="fullname" ng-model = "fullname"  ng-init ="fullname = '${fullname}'" >
					<p style="color: red;">{{fullname_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ</label> 
					<input class="form-control" type="text" placeholder="Địa chỉ" name="address" ng-model ="address" ng-init="address='${address }'"  >
					<p style="color: red;">{{address_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<input class="form-control" type="text" placeholder="Số điện thoại" name="telephone" ng-model ="telephone" ng-init="telephone='${telephone }'"  >
					<p style="color: red;">{{telephone_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Tên đăng nhập</label> 
					<input class="form-control" type="text" placeholder="Tên đăng nhập" name="username" ng-model ="username" ng-init="username='${username }'" >
					<p style="color: red;">{{username_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Địa chỉ email</label> 
					<input class="form-control" type="email" placeholder="Địa chỉ email" name="email" ng-model ="email" ng-init="email='${email }'" >
					<p style="color: red;">{{email_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Mật khẩu</label> 
					<input class="form-control" type="password" placeholder="Mật khẩu" name="password" ng-model ="password" ng-init="password='${password }'" >
					<p style="color: red;">{{password_err}}</p>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Xác nhận mật khẩu</label> 
					<input class="form-control" type="password" placeholder="Xác nhận mật khẩu" name="repassword" ng-model ="repassword" ng-init="repassword='${repassword }'" >
					<p style="color: red;">{{repassword_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<input type="button" name="" ng-click="btnCreate()" class="btn btn-info " value="Đăng kí">
				<input type="button" name="" class="btn btn-info " value="Hủy">
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		
		<div class ="row">
			<div class="col-lg-12">
			<table width="100%" class="table table-striped table-bordered table-hover" id="">
				<thead>
					<tr>
						<th>STT</th>
						<th>Họ tên</th>
						<th>Địa chỉ</th>
						<th>Số điện thoại</th>
						<th>Email</th>
						<th>Người tạo</th>
						<th>Ngày Cấp</th>
						<th>Người cập nhật</th>
						<th>Ngày cập nhật</th>
					</tr>
				</thead>
				<tbody>
				<tr class="gradeX">
                     <td>Misc</td>
                     <td>Lynx</td>
                     <td>Text only</td>
                     <td class="center">-</td>
                     <td class="center">X</td>
                     <td>Misc</td>
                     <td>Lynx</td>
                     <td>Text only</td>
                     <td class="center">-</td>
                 </tr>
				<tr class="gradeX">
                     <td>Misc</td>
                     <td>Lynx</td>
                     <td>Text only</td>
                     <td class="center">-</td>
                     <td class="center">X</td>
                     <td>Misc</td>
                     <td>Lynx</td>
                     <td>Text only</td>
                     <td class="center">-</td>
                 </tr>
				<tr class="gradeX">
                     <td>Misc</td>
                     <td>Lynx</td>
                     <td>Text only</td>
                     <td class="center">-</td>
                     <td class="center">X</td>
                     <td>Misc</td>
                     <td>Lynx</td>
                     <td>Text only</td>
                     <td class="center">-</td>
                 </tr>
				</tbody>
			
			</table>
			
			</div>
		</div>
	</form>		
		<!-- /#page-wrapper -->
	</div>
	
	
	
</div>
<script src="views/js/storeOwner.js"></script>
<!-- /#wrapper -->
