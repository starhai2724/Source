<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="ProductForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Sản phẩm khuyến mãi</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="ProductForm" modelAttribute="ProductForm" role="form" method="POST" >
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên sản phẩm</label> 
					<form:input maxlength="30" class="form-control" type="text" path="tenSP"  name="tenSP" ng-model = "tenSP"  ng-init ="tenSP = '${ProductForm.tenSP}'" />
					<form:input class="form-control" type="hidden" path="idSanPham"  name="idSanPham" />
					<p style="color: red;">{{tenSP_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Loại sản phẩm</label> 
					<form:select class="form-control" path="idLoaiSP">
					    <form:options items="${ProductForm.lstCategory}" />
					</form:select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Giá mua</label> 
					<form:input maxlength="10" class="form-control" type="text"  path="giaMua"  name="giaMua" ng-model ="giaMua" ng-init="giaMua='${ProductForm.giaMua}'"  />
					<p style="color: red;">{{giaMua_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Giá bán</label> 
					<form:input maxlength="10" class="form-control" type="text"  path="giaBan"  name="giaBan" ng-model ="giaBan" ng-init="giaBan='${ProductForm.giaBan}'" />
					<p style="color: red;">{{giaBan_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
			        <label>File input</label>
			        <div class="form-group">
                        <form:input type="file" path="hinh" />
                    </div>
    			</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Mô tả </label> 
					<form:textarea  class="form-control"  rows="5"	 path="moTa"  name="moTa" ng-model ="moTa" ng-init="moTa='${ProductForm.moTa}'"  />
					<p style="color: red;">{{moTa_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${ProductForm.message }</p>
					<p style="color: red; font-weight: bold;">${ProductForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div >
				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Đăng kí">
				<input type="button" name="" class="btn btn-info " ng-click="btnIn()" value="In">
				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Hủy">
			</div>
		</div>
		
		<!-- <div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div -->
		
		<c:if test="${!empty ProductForm.lst }">
		<div class="panel-body">
                            <table width="1578px" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="text-align: center; width: 40px;">STT</th>
										<th style="text-align: center; width: 80px">Mã SP</th>
										<th style="text-align: center; width: 250px">Tên sản phẩm</th>
										<th style="text-align: center; width: 80px">Loại SP</th>
										<th style="text-align: center; width: 80px">Giá mua</th>
										<th style="text-align: center; width: 80px">Giá bán</th>
										<th style="text-align: center; width: 80px">Ngày tạo</th>
										<th style="text-align: center; width: 80px">Ngày chỉnh sửa</th>
										<th style="text-align: center; width: 250px">Mô tả</th>
										<th style="text-align: center;	width: 60px">Thao tác</th>
										<th style="text-align: center;	width: 60px"></th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${ProductForm.lst }">
		                                <tr class="odd gradeX">
		                                        <td style="text-align: center">${items.no}</td>
		                                        <td>${items.idSanPham}</td>
							                     <td>${items.tenSP}</td>
							                     <td>${items.tenLoaiSP }</td>
		                                      	 <td style="text-align: right">${items.giaMua }</td>
					                    		 <td style="text-align: right">${items.giaBan }</td>
		                                       	<td  style="text-align: center">${items.ngayTao}</td>
		                                        <td  style="text-align: center">${items.ngayChinhSua }</td>
		                                         <td>${items.moTa }</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" ng-click="btnGetProductById('${items.idSanPham}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.idSanPham}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                        <td class="center" style="text-align: center">
		                                        </td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${ProductForm.flagUpdate}'" />
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script src="/storeManagerSystem/view/js/product.js"></script>

<!-- /#wrapper -->