<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="LienHeForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản lý liên hệ</h1>
			</div>
<!-- 			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i> -->
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="LienHeForm" modelAttribute="LienHeForm" role="form" method="POST" >
	<c:choose>
		<c:when test="${LienHeForm.flagUpdate eq ('1')}">
		<div id="demo" class="collapse in">
		</c:when>
		<c:otherwise>
		<div id="demo" class="collapse">
		</c:otherwise>
		</c:choose>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Họ tên</label>
						<form:input class="form-control" disabled="true" type="text" path="tenKH" />
					<!--set so id khi chinh sua  -->
					<form:input maxlength="30" class="form-control" type="hidden" path="idLienHe"   />
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Địa chỉ</label> 
					<form:input maxlength="50" class="form-control" disabled="true" type="text" path="diaChi" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Email</label>
						<form:input maxlength="20" class="form-control" disabled="true" type="text" path="email" />
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Điện thoại</label> 
					<form:input maxlength="12" class="form-control" disabled="true" type="text" path="sdt" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tiêu đề</label>
						<form:input maxlength="30" class="form-control" disabled="true" type="text" path="tieuDe" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Nội dung nhận </label> 
					<form:textarea  class="form-control"  rows="5"	 path="noiDungNhan"  disabled="true"  />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Nội dung trả lời </label>
					<div class="input-group">
						<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span><form:textarea  class="form-control"  rows="5"	 path="noiDungTraLoi"  name="noiDungTraLoi" ng-model ="noiDungTraLoi" ng-init="moTa='${LienHeForm.noiDungTraLoi}'"  />
					</div>
					<p style="color: red;">{{noiDungTraLoi_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<button type="button" class="btn btn-info" ng-click ="btnCreate()" >
				  <i class="glyphicon glyphicon-ok"></i> Đăng kí
				</button>
			</div>
		</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${LienHeForm.message }</p>
					<p style="color: red; font-weight: bold;">${LienHeForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div>
				<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">
				  <i class="glyphicon glyphicon-plus"></i> Thêm
				</button>
				<button type="button" class="btn btn-info" onclick="testExcel()">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<!-- <button type="button" class="btn btn-info" onclick="exportPDF();">
				  <i class="glyphicon glyphicon-print"></i> Export Pdf
				</button> -->
				<button type="button" class="btn btn-info" ng-click ="btnClear()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
				
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Đăng kí"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="In"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Hủy"> -->
			</div>
		</div>
		
		<!-- <div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div -->
		
		<c:if test="${!empty LienHeForm.lst }">
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="text-align: center; width: 40px;padding-left: 5px;padding-right: 4px; ">STT</th>
										<th style="text-align: center; width: 100px;padding-left: 5px;padding-right: 4px; ">Mã liên hệ</th>
										<th style="text-align: center; width: 150px">Tên khách hàng</th>
										<th style="text-align: center; width: 180px">Tiêu đề</th>
										<th style="text-align: center; width: 120px">Địa chỉ</th>
										<th style="text-align: center; width: 90px;padding-left: 5px;padding-right: 4px; ">Email</th>
										<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">SĐT</th>
										<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Trạng thái</th>
										<th style="text-align: center; width: 65px">Ngày nhận</th>
										<th style="text-align: center;	width: 65px">Ngày TL</th>
										<th style="text-align: center;	width: 50px" data-tableexport-display="none">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${LienHeForm.lst }">
		                                <tr class="odd gradeX">
		                                        <td style="text-align: center">${items.no}</td>
		                                        <td style="text-align: center">${items.idLienHe}</td>
							                    <td>${items.tenKH}</td>
							                    <td>${items.tieuDe}</td>
							                    <td>${items.diaChi }</td>
		                                      	<td style="text-align: left">${items.email }</td>
					                    		<td style="text-align: left">${items.sdt }</td>
		                                       	<td  style="text-align: center">${items.trangThai}</td>
		                                       	<td  style="text-align: center">${items.ngayNhan}</td>
		                                       	<td  style="text-align: center">${items.ngayTraLoi}</td>
		                                        <td class="center" style="text-align: center" data-tableexport-display="none">
	                                        		<button class="btn" type="button" ng-click="btnGetById('${items.idLienHe}');">
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
													</button>
		                                        </td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${LienHeForm.flagUpdate}'" />
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script>
function testExcel(){
	$('#dataTables-example').tableExport({
		fileName:'lienHe',
		type:'excel',
	    excelFileFormat:'xmlss',
	    worksheetName: ['Table 1','Table 2', 'Table 3']});
	}
</script>
<script src="/storeManagerSystem/view/js/khachHangLienHe.js"></script>
<!-- /#wrapper -->