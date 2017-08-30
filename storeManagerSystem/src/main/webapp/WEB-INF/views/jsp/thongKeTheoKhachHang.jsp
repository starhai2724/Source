<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 

<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="TKeForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thống kế theo khách hàng</h1>
			</div>
		</div>
		<!-- /.row -->
	<form:form id="TKeForm" modelAttribute="TKeForm" role="form" method="GET" >
		<div id="demo" class="collapse in">
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày bắt đầu</label> 
					<form:input class="form-control" type="date" path="ngayBatDau"  name="ngayBatDau" ng-model = "ngayBatDau"  ng-init ="ngayBatDau = '${TKeForm.ngayBatDau}'" />
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày kết thúc</label> 
					<form:input class="form-control" type="date" path="ngayKetThuc"  name="ngayKetThuc" ng-model = "ngayKetThuc"  ng-init ="ngayKetThuc = '${TKeForm.ngayKetThuc}'" />
				</div>
			</div>
		</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${TKeForm.message }</p>
					<p style="color: red; font-weight: bold;">${TKeForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div>
				<button type="button" class="btn btn-info" ng-click="btnSearchKhachHang()">
				  <i class="glyphicon glyphicon-plus"></i> Tìm kiếm
				</button>
				<button type="button" class="btn btn-info" onclick="testExcel()">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<button type="button" class="btn btn-info" ng-click ="btnClearKhachHang()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
			</div>
		</div>
		<c:if test="${!empty TKeForm.khachHangRowForms }">
		<div class="panel-body" id ="tableToExport">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="padding-left: 5px;padding-right: 4px; width: 20px;">STT</th>
										<th style="text-align: center; width: 100px;">Khách hàng</th>
										<th style="padding-left: 5px;padding-right: 4px; width: 50px">SĐT</th>
										<th style="padding-left: 5px;padding-right: 4px;text-align: center; width: 100px">Địa chỉ</th>
										<th style="padding-left: -5px; width: 80px; text-align: center">Điểm tích lũy</th>
										<th style="padding-left: 5px;padding-right: 1px;width: 20px;text-align: center;">Số lượng</th>
										<th style="text-align: center; width: 80px">Tổng tiền</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${TKeForm.khachHangRowForms }" varStatus="status">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">${status.index + 1 }</td>
		                                        <td>${items.idKhachHang}${items.tenKhachHang}</td>
							                    <td>${items.SDT}</td>
							                    <td>${items.diaChi }</td>
		                                      	<td style="text-align: right;">${items.diemTichLuy }</td>
		                                      	<td style="text-align: right;">${items.SL }</td>
					                    		<td style="text-align: right">
					                    		 	<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.tongTien }" />
					                    		</td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<!-- Export (S) -->
<script>

function testExcel(){
	$('#dataTables-example').tableExport({
		fileName:'ThongKeTheoKhachHang',
		type:'excel',
	    excelFileFormat:'xmlss',
	    worksheetName: ['Table 1','Table 2', 'Table 3']});
	}
</script>

<!-- Export (E) -->
<script src="/storeManagerSystem/view/js/thongKeTheoSanPham.js"></script>

<!-- /#wrapper -->