<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="KhachHangForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Khách hàng</h1>
			</div>
			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="KhachHangForm" modelAttribute="KhachHangForm" role="form" method="GET" >
	<c:choose>
		<c:when test="${KhachHangForm.flagUpdate eq ('1')}">
		<div id="demo" class="collapse in">
		</c:when>
		<c:otherwise>
		<div id="demo" class="collapse">
		</c:otherwise>
		</c:choose>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên khách hàng</label> 
					<form:input maxlength="30" class="form-control" type="text" path="tenKhachHang"  name="tenKhachHang" ng-model = "tenKhachHang"  ng-init ="tenKhachHang = '${KhachHangForm.tenKhachHang}'" />
					<form:input class="form-control" type="hidden" path="idKhachHang"  name="idKhachHang" />
					<p style="color: red;">{{tenKhachHang_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<form:input maxlength="12" class="form-control" type="text" path="soDienThoai"  name="soDienThoai" ng-model = "soDienThoai"  ng-init ="soDienThoai = '${KhachHangForm.soDienThoai}'" />
					<p style="color: red;">{{soDienThoai_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Giơi tính</label> 
					<form:select class="form-control" path="gioiTinh">
					    <form:options items="${KhachHangForm.lstGioiTinh}" />
					</form:select>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Loại thẻ</label> 
					<form:select class="form-control" path="loaiThe">
					    <form:options items="${KhachHangForm.lstCards}" />
					</form:select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Điểm tích lũy</label> 
					<form:input maxlength="10" class="form-control" type="text" path="soDiem"  name="soDiem" ng-model = "soDiem"  ng-init ="soDiem = '${KhachHangForm.soDiem}'" />
					<p style="color: red;">{{soDiem_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Địa chỉ</label> 
					<form:input maxlength="40" class="form-control" type="text" path="diaChi"  name="diaChi" ng-model = "diaChi"  ng-init ="diaChi = '${KhachHangForm.diaChi}'" />
					<p style="color: red;">{{diaChi_err}}</p>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Ngày sinh</label> 
					<form:input class="form-control" type="date" path="ngaySinh"  name="ngaySinh" />
					<p style="color: red;">{{ngaySinh_err}}</p>
				</div>
			</div>
		</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${KhachHangForm.message }</p>
					<p style="color: red; font-weight: bold;">${KhachHangForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div >
				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Đăng kí">
				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="Export Excel">
				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Refesh">
			</div>
		</div>
		
		<!-- <div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div -->	
		
		<c:if test="${!empty KhachHangForm.lst }">
		<div class="panel-body" id ="tableToExport">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="padding-left: 5px;padding-right: 4px; width: 20px;">STT</th>
										<th style="text-align: center; width: 100px;">Tên khách hàng</th>
										<th style="text-align: center; width: 50px">SĐT</th>
										<th style="padding-left: 5px;padding-right: 4px; width: 50px">Giới tính</th>
										<th style="padding-left: 5px;padding-right: 4px;text-align: center; width: 60px">Ngày sinh</th>
										<th style="padding-left: -5px; width: 80px">Địa chỉ</th>
										<th style="text-align: center; width: 50px">Loại thẻ</th>
										<th style="padding-left: 5px;padding-right: 1px;width: 20px;text-align: center;">Điểm</th>
										<th style="text-align: center; width: 80px">Ngày tạo</th>
										<th style="text-align: center;	width: 60px">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${KhachHangForm.lst }">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">${items.no}</td>
		                                        <td>${items.tenKhachHang}</td>
							                     <td>${items.soDienThoai}</td>
							                     <td>${items.gioiTinh }</td>
		                                      	 <td style="text-align: center">${items.ngaySinh }</td>
					                    		 <td>${items.diaChi }</td>
		                                       	<td>${items.loaiThe}</td>
		                                        <td  style="text-align: right">${items.soDiem }</td>
		                                         <td style="text-align: center">${items.ngayTao }</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" ng-click="btnGetById('${items.idKhachHang}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.idKhachHang}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${KhachHangForm.flagUpdate}'" />
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script src="/storeManagerSystem/view/js/customer.js"></script>

<!-- /#wrapper -->