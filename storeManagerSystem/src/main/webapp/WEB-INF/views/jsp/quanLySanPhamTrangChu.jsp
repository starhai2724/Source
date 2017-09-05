<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="ProductForm" ng-controller="ctrl">
	
		<div class="row">
			<div class="col-lg-12">
			<h1 class="page-header">Quản lý sản phẩm</h1>
			</div>
		</div>
		<!-- /.row -->
	<form:form id="ProductForm" modelAttribute="ProductForm" role="form" method="POST" >
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
				<button type="button" class="btn btn-info" onclick="testExcel()">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<button type="button" class="btn btn-info" ng-click ="btnClear()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
			</div>
		</div>
		<c:if test="${!empty ProductForm.lst }">
		<div class="panel-body">
                            <table  width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead >
                                    <tr >
                                        <th style="text-align: center; width: 35px;padding-left: 0px;padding-right: 0px; ">STT</th>
										<th style="text-align: center; width: 150px">Cửa hàng</th>
										<th style="text-align: center; width: 150px">Tên sản phẩm</th>
										<th style="text-align: center; width: 120px">Loại SP</th>
										<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Giá bán</th>
										<th style="text-align: center;	width: 40px" data-tableexport-display="none">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px" >
                              		  <c:forEach var="items" items="${ProductForm.lst }">
		                                <tr class="odd gradeX" >
		                                        <td style="text-align: center">${items.no}</td>
		                                        <td >${items.idLoaiSP}</td>
							                    <td data-tableexport-value="${items.tenSP}" >${items.tenSP}</td>
							                    <td>${items.tenLoaiSP }</td>
					                    		<td style="text-align: right">${items.giaBan }</td>
		                                        <td class="center" style="text-align: center" data-tableexport-display="none" >
														<button class="btn" type="button" ng-click="btnDelete('${items.SEQ}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
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



<script src="/storeManagerSystem/view/exportPDF_2/Blob.js/Blob.js"></script>
<script src="/storeManagerSystem/view/exportPDF_2/FileSaver.js/FileSaver.js"></script>
<script src="/storeManagerSystem/view/exportPDF_2/jquery.tableexport.js"></script>

<script>
function testExcel(){
$('#dataTables-example').tableExport({
	fileName:'sanPham',
	type:'excel',
    excelFileFormat:'xmlss',
    worksheetName: ['Table 1','Table 2', 'Table 3']});
}
</script>

<script src="/storeManagerSystem/view/js/quanLySanPhamTrangChu.js"></script>
<!-- /#wrapper -->
