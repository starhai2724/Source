<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 

<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="ThongkeTheoSanPhamForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thống kế theo sản phẩm</h1>
			</div>
		</div>
		<!-- /.row -->
	<form:form id="ThongkeTheoSanPhamForm" modelAttribute="ThongkeTheoSanPhamForm" role="form" method="GET" >
		<div id="demo" class="collapse in">
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày bắt đầu</label> 
					<form:input class="form-control" type="date" path="ngayBatDau"  name="ngayBatDau" ng-model = "ngayBatDau"  ng-init ="ngayBatDau = '${ThongkeTheoSanPhamForm.ngayBatDau}'" />
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày kết thúc</label> 
					<form:input class="form-control" type="date" path="ngayKetThuc"  name="ngayKetThuc" ng-model = "ngayKetThuc"  ng-init ="ngayKetThuc = '${ThongkeTheoSanPhamForm.ngayKetThuc}'" />
				</div>
			</div>
		</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${ThongkeTheoSanPhamForm.message }</p>
					<p style="color: red; font-weight: bold;">${ThongkeTheoSanPhamForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div>
				<button type="button" class="btn btn-info" ng-click="btnSearch()">
				  <i class="glyphicon glyphicon-plus"></i> Tìm kiếm
				</button>
				<button type="button" class="btn btn-info" onclick="testExcel()">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<button type="button" class="btn btn-info" ng-click ="btnClear()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
			</div>
		</div>
		<c:if test="${!empty ThongkeTheoSanPhamForm.lst }">
		<div class="panel-body" id ="tableToExport">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="padding-left: 5px;padding-right: 4px; width: 20px;">STT</th>
										<th style="text-align: center; width: 100px;">Mã sản phẩm</th>
										<th style="text-align: center; width: 50px">Tên sản phẩm</th>
										<th style="padding-left: 5px;padding-right: 4px; width: 50px">Loại sản phẩm</th>
										<th style="padding-left: 5px;padding-right: 4px;text-align: center; width: 60px">Số lượng</th>
										<th style="padding-left: -5px; width: 80px; text-align: center">Giá mua</th>
										<th style="padding-left: 5px;padding-right: 1px;width: 20px;text-align: center;">Tiền lãi</th>
										<th style="text-align: center; width: 80px">Tổng tiền</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${ThongkeTheoSanPhamForm.lst }" varStatus="status">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">${status.index + 1 }</td>
		                                        <td>${items.idSanPham}</td>
							                     <td>${items.tenSP}</td>
							                     <td>${items.tenLoaiSP }</td>
		                                      	 <td style="text-align: right;">${items.soLuong }</td>
					                    		 <td style="text-align: right">
					                    		 	<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaMua }" />
					                    		 </td>
		                                       	<td style="text-align: right">
		                                       		<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.tienLoi }" />
		                                       	</td>
		                                        <td  style="text-align: right">
		                                        	<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.thanhTien }" />
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
		fileName:'ThongKeTheoSanPham',
		type:'excel',
	    excelFileFormat:'xmlss',
	    worksheetName: ['Table 1','Table 2', 'Table 3']});
	}
</script>

<!-- Export (E) -->
<script src="/storeManagerSystem/view/js/thongKeTheoSanPham.js"></script>

<!-- /#wrapper -->