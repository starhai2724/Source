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
				<h1 class="page-header">Đăng kí sản phẩm</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="RegisterProductCategory"  method="POST">
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại xử lý</label> 
					<input class="form-control" type="text"  placeholder="Họ tên" ng-model = "nameProductCategory"  ng-init ="nameProductCategory = ''" />
					<p style="color: red;"></p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại xử lý</label> 
					<input class="form-control" type="text"  placeholder="Họ tên" ng-model = "nameProductCategory"  ng-init ="nameProductCategory = ''" />
					<p style="color: red;"></p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại xử lý</label> 
					<input class="form-control" type="text"  placeholder="Họ tên" ng-model = "nameProductCategory"  ng-init ="nameProductCategory = ''" />
					<p style="color: red;"></p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại xử lý</label> 
					<input class="form-control" type="text"  placeholder="Họ tên" ng-model = "nameProductCategory"  ng-init ="nameProductCategory = ''" />
					<p style="color: red;"></p>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
				<p style="color: blue; font-weight: bold;"></p>
				<p style="color: red; font-weight: bold;"></p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row">
			<div class="col-sm-3" >
				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="Tìm kiếm">
				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="In">
				<input type="button" name=""  class="btn btn-info " ng-click="btnCreate()" value="Hủy">
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<div class="row">
			<div class="col-sm-3">&nbsp</div>
		</div>
		<%-- <c:if test="${!empty RegisterProductCategory.lst }"> --%>
		<div class ="row">
			<div class="col-lg-12">
			<table style="width: 100%" class="table table-striped table-bordered table-hover" id="">
				<thead>
					<tr>
						<th style="width: 50xp">STT</th>
						<th>Tên sản phẩm</th>
						<th>Loại sản phẩm</th>
						<th>Giá mua</th>
						<th>Giá bán</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody style="overflow: auto; height:50px">
				<%-- <c:forEach var="items" > --%>
				<tr class="gradeX">
                     <td class="center" style="text-align: center"></td>
                     <td>
                     <input class="form-control" type="text"  ng-model = "nameProductCategory"  ng-init ="nameProductCategory = ''" />
                     </td>
                     <td></td>
                     <td style="width:100px">
                     <input style="width:100px" class="form-control" type="text"  ng-model = "nameProductCategory"  ng-init ="nameProductCategory = ''" />
                     </td>
                     <td></td>
                     <td style="text-align: center">
						<button class="btn" type="button" ng-click="btnDelete();" >
							<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
						</button>
                     </td>
                 </tr>
				<tr class="gradeX">
                     <td class="center" style="text-align: center"></td>
                     <td></td>
                     <td></td>
                     <td></td>
                     <td></td>
                     <td style="text-align: center">
						<button class="btn" type="button" ng-click="btnDelete();" >
							<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
						</button>
                     </td>
                 </tr>
                 <tr class="gradeX">
                     <td class="center" style="text-align: center"></td>
                     <td></td>
                     <td></td>
                     <td></td>
                     <td></td>
                     <td style="text-align: center">
						<button class="btn" type="button" ng-click="btnDelete();" >
							<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
						</button>
                     </td>
                 </tr>
               <%--  </c:forEach>  --%>
				</tbody>
			
			</table>
			
			</div>
		</div>
		<%-- </c:if> --%>
		
	</form:form>		
		<!-- /#page-wrapper -->
	</div>

</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
</body>
<script src="/storeManagerSystem/view/js/registerProductCategory.js"></script>
</html>