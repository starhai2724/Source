<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="storeOwnerList" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Người dùng</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form id="storeOwnerList" role="form" method="POST" action="/storeManagerSystem/storeOwnerSearch">
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Họ tên</label> 
					<input class="form-control" type="text" placeholder="Họ tên" name="fullname" ng-model = "fullname"  ng-init ="fullname = '${fullname}'" >
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên đăng nhập</label> 
					<input class="form-control" type="text" placeholder="Tên đăng nhập" name="username" ng-model ="username" ng-init="username='${username }'" >
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<input class="form-control" type="text" placeholder="Số điện thoại" name="telephone" ng-model ="telephone" ng-init="telephone='${telephone }'"  >
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Địa chỉ email</label> 
					<input class="form-control" type="email" placeholder="Địa chỉ email" name="email" ng-model ="email" ng-init="email='${email }'" >
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<input type="button" name="" class="btn btn-info " value="Mới">
				<input type="button" name="" ng-click="btnSearch()" class="btn btn-info " value="Tìm kiếm">
				<input type="button" name="" class="btn btn-info " value="Hủy">
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp ${message_err}</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		
		
<%-- 		<c:if test="${not empty storeOwners } "> --%>
		<div class ="row">
			<div class="col-lg-12">
			<table width="100%" class="table table-striped table-bordered table-hover" id="">
				<thead>
					<tr>
						<th>STT</th>
						<th>Họ tên</th>
						<th>Tên đăng nhập</th>
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
				<c:forEach var="items" items="${storeOwners }">
				<tr class="gradeX">
                     <td></td>
                     <td>${items.fullName}</td>
                     <td>${items.username}</td>
                     <td>${items.address }</td>
                     <td class="center">${items.telephone }</td>
                     <td class="center">${items.email }</td>
                     <td>${items.userInsert}</td>
                     <td>${items.dateInsert }</td>
                     <td>${items.userUpdate }</td>
                     <td class="center">${items.dateUpdate}</td>
                 </tr>
                </c:forEach> 
				</tbody>
			
			</table>
			
			</div>
		</div>
<%-- 		</c:if> --%>
	</form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script src="views/js/storeOwnerList.js"></script>
<!-- /#wrapper -->
