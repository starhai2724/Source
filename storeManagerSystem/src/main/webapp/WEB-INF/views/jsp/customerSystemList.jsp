<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


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
	<form:form id="storeOwnerList" modelAttribute="storeOwnerListForm" role="form" method="POST" >
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Họ tên</label> 
					<form:input class="form-control" type="text" path="fullName" placeholder="Họ tên" name="fullName" ng-model = "fullName"  ng-init ="fullName = '${storeOwnerListForm.fullName}'" />
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên đăng nhập</label> 
					<form:input class="form-control" type="text" path="username" placeholder="Tên đăng nhập" name="username" ng-model ="username" ng-init="username='${storeOwnerListForm.username }'" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<form:input class="form-control" type="text"  path="telephone" placeholder="Số điện thoại" name="telephone" ng-model ="telephone" ng-init="telephone='${storeOwnerListForm.telephone }'"  />
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Địa chỉ email</label> 
					<form:input class="form-control" type="email"  path="email" placeholder="Địa chỉ email" name="email" ng-model ="email" ng-init="email='${storeOwnerListForm.email }'" />
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${storeOwnerListForm.message }</p>
					<p style="color: red; font-weight: bold;">${storeOwnerListForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-3">
				<input type="button" name="" class="btn btn-info " ng-click ="btnAppend()" value="Mới">
				<input type="button" name="" class="btn btn-info " ng-click="btnSearch()" value="Tìm kiếm">
				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Hủy">
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		
		
		<c:if test="${!empty storeOwners }">
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
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody style="overflow: auto; height:50px">
				<c:forEach var="items" items="${storeOwners }">
				<tr class="gradeX">
                     <td class="center" style="text-align: center">${items.no}</td>
                     <td>${items.fullName}</td>
                     <td>${items.username}</td>
                     <td>${items.address }</td>
                     <td class="center" style="text-align: center">${items.telephone }</td>
                     <td class="center">${items.email }</td>
                     <td>${items.userInsert}</td>
                     <td style="text-align: center">${items.dateInsert }</td>
                     <td>${items.userUpdate }</td>
                     <td class="center" style="text-align: center">${items.dateUpdate}</td>
                     <td style="text-align: center">
						<button class="btn" type="button" ng-click="btnUpdate(${items.idStoreOwner });">
							<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
						</button>
						<button class="btn" type="button" ng-click="btnDelete(${items.idStoreOwner});" >
							<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
						</button>
                     </td>
                 </tr>
                </c:forEach> 
				</tbody>
			
			</table>
			
			</div>
		</div>
		</c:if>
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script src="${pageContext.request.contextPath}/view/js/storeOwnerList.js"></script>

<!-- /#wrapper -->
