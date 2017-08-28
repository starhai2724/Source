<!DOCTYPE html>
<html lang="en">
<head>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
    <title>Hệ thống bán hàng</title>
    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
</head>

<body>
<div id="wrapper">
<div id="page-wrapper" ng-app="RegisterProductCategory" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Đăng kí danh mục sản phẩm</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="RegisterProductCategory" role="form" modelAttribute="RegisterProductCategory" method="POST">
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên nhóm sản phẩm</label> 
					<form:input maxlength="30" class="form-control" type="text" path="nameProductCategory"  ng-model = "nameProductCategory"  ng-init ="nameProductCategory = '${RegisterProductCategory.nameProductCategory}'" />
					<form:input class="form-control" type="hidden" path="idProductCategory"  />
					<p style="color: red;">{{nameProductCategory_err}}</p>
				</div>
			</div>
			
			<c:if test="${!empty RegisterProductCategory.checkShow }">
				<div class="col-sm-4" style="margin-left: 550px;margin-top: -70px">
					<div class="form-group" >
						<label>Tên loại sản phẩm</label> 
						<form:input maxlength="50" class="form-control" type="text" path="tenLoaiSP"  ng-model = "tenLoaiSP"  ng-init ="tenLoaiSP = '${RegisterProductCategory.tenLoaiSP}'" />
						<form:input class="form-control" type="hidden" path="idLoaiSP"  />
						<p style="color: red;">{{nameProductCategory_err}}</p>
					</div>
				</div>
			</c:if>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<p style="color: blue; font-weight: bold;">${RegisterProductCategory.message }</p>
				<p style="color: red; font-weight: bold;">${RegisterProductCategory.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-5" style="margin-left: 10px">
				<button type="button" class="btn btn-info" ng-click="btnCreate()">
				  <i class="glyphicon glyphicon-plus"></i> Đăng kí SP
				</button>
<!-- 				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="Đăng kí nhóm SP"> -->
			</div>
		<c:if test="${!empty RegisterProductCategory.checkShow }">
			<div class="col-sm-5" style="margin-left: -40px">
				<button type="button" class="btn btn-info" ng-click="btnDangKyLSP()">
				  <i class="glyphicon glyphicon-plus"></i> Đăng kí SP
				</button>
<!-- 				<input type="button" name=""  class="btn btn-info " ng-click="btnDangKyLSP()" value="Đăng kí loại SP"> -->
				<!-- <input type="button" name=""  class="btn btn-info " ng-click="btnThemDong()" value="Thêm loại SP"> -->
			</div>
		</c:if>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<c:if test="${!empty RegisterProductCategory.lst }">
		<div class="panel-body">
			<div id="table-scroll" style="overflow-y : auto; height: 380px;width: 450px;">
                            <table style="width: 429px" class="table table-striped table-bordered table-hover" >
				                <thead>
									<tr>
										<th style="width: 50px">STT</th>
										<th>Tên nhóm sản phẩm</th>
										<th style="width: 150px">Thao tác</th>
									</tr>
								</thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${RegisterProductCategory.lst }">
										<tr class="gradeX">
								                   <td class="center" style="text-align: center">${items.no}</td>
								                   <td>${items.nameProductCategory}</td>
								                   <td style="text-align: center">
														<button class="btn" type="button" ng-click="btnGetById('${items.idProductCategory}');" >
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.idProductCategory}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDetail('${items.idProductCategory}');" >
															<span class="glyphicon glyphicon-list" data-toggle="tooltip" data-original-title="Chi tiết"></span>
														</button>
								                   </td>
								         </tr>
								 	</c:forEach> 
                                </tbody>
                            </table>
                     </div>
         </div>
		</c:if>
		
		<c:if test="${!empty RegisterProductCategory.lstLSP }">
		<div class="panel-body">
				<div id="table-scroll" style="overflow:auto; height: 380px;margin-top: -410px;width: 430px;margin-left: 550px;">
                            <table class="table table-striped table-bordered table-hover" >
				                <thead>
									<tr>
										<th style="width: 50px">STT</th>
										<th>Tên loại sản phẩm</th>
										<th style="width: 120px">Thao tác</th>
									</tr>
								</thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${RegisterProductCategory.lstLSP }">
										<tr class="gradeX">
								                   <td class="center" style="text-align: center">${items.no_LSP}</td>
								                   <td>${items.name_LSP}</td>
								                   <td style="text-align: center">
														<button class="btn" type="button" ng-click="btnDelete_LSP('${items.no_LSP}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnGetById_LSP('${items.idLSP}');" >
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
								                   </td>
								         </tr>
								 	</c:forEach> 
                                </tbody>
                            </table>
                  </div>
         </div>
		</c:if>
		<c:if test="${empty RegisterProductCategory.lstLSP }">
			<c:if test="${!empty RegisterProductCategory.checkShow }">
				<div class="panel-body">
					<div id="table-scroll" style="overflow:auto; height: 380px;margin-top: -410px;width: 400px;margin-left: 550px;">
                            <table class="table table-striped table-bordered table-hover" >
				                <thead>
									<tr>
										<th style="width: 50px">STT</th>
										<th>Tên loại sản phẩm</th>
										<th style="width: 80px">Thao tác</th>
									</tr>
								</thead>
                                <tbody style="overflow: auto; height:50px">
										<tr class="gradeX">
								                   <td class="center" style="text-align: center" colspan="3">Không tìm thấy dữ liệu</td>
								         </tr>
                                </tbody>
                            </table>
                  </div>
         		</div>
         	</c:if>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${RegisterProductCategory.flagUpdate}'" />
		<form:input class="form-control" type="hidden"  path="flagUpdate_LSP"  name="flagUpdate_LSP" ng-model ="flagUpdate_LSP" ng-init="flagUpdate_LSP='${RegisterProductCategory.flagUpdate_LSP}'" />
	</form:form>		
		<!-- /#page-wrapper -->
	</div>

</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
</body>
<script src="/storeManagerSystem/view/js/registerProductCategory.js"></script>
</html>