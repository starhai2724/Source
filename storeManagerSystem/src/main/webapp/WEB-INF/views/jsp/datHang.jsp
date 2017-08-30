<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="wrapper">
<div id="page-wrapper" ng-app="DatHangForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản trị đặt hàng</h1>
			</div>
		</div>
		<!-- /.row -->
		<form:form id="DatHangForm" modelAttribute="DatHangForm" role="form" method="GET" >
<!-- Danh Sach San pham (S) -->
	<c:choose>
	<c:when test="${DatHangForm.flagNew eq ('1')}">
	<div id="demo" class="collapse in">
	</c:when>
	<c:otherwise>
	<div id="demo" class="collapse">
	</c:otherwise>
	</c:choose>
	<c:if test="${DatHangForm.flagUpdate ne ('1')}">
	<div id="sanPhamPhanAnh" class="collapse in" > 
		<div class="row">
				<div class="col-lg-12">
					<span style="font-weight: bold;">Danh sách sản phẩm</span>
				</div>
		</div>
		<div class="panel-body">
	                     <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example1">
	                         <thead>
	                             <tr>
	                             	<th style="text-align: center; width: 5px;"></th>
	                                <th style="text-align: center; width: 10px;padding-left: 5px;padding-right: 4px; ">STT</th>
									<th style="text-align: center; width: 50px;padding-left: 5px;padding-right: 4px; ">Mã SP</th>
									<th style="text-align: center; width: 150px">Tên sản phẩm</th>
									<th style="text-align: center; width: 120px">Loại SP</th>
									<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Giá</th>
	                             </tr>
	                         </thead>
	                         <tbody style="overflow: auto; height:50px" ng-model = "listSanPham" ng-init ="listSanPham = '${fn:length(DatHangForm.lstSanPham)}'">
	                       		  <c:forEach var="items" items="${DatHangForm.lstSanPham }">
	                           <tr class="odd gradeX">
	                            	   <td class="center" style="text-align: center"><input type="checkbox" ng-model="selected1[${items.no}]"  ng-init ="selected1[${items.no}]='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'"></td>
	                                   <td style="text-align: center">${items.no}</td>
	                                   <td>${items.idSanPham}</td>
	                    			   <td>${items.tenSP}</td>
	                                   <td>${items.tenLoaiSP }</td>
	                  		           <td style="text-align: right">
	                  		           		<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaMua }" />
	                  		           </td>
	                            </tr>
	              				</c:forEach>
	                         </tbody>
	                     </table>
	    </div>
	    <div class="row">
			<input type="button" name="" class="btn btn-info " style="margin-left: 30px" ng-click ="btnPhanAnh()" value="Phản ánh">
		</div>
	    <div class="row">
				<div class="col-lg-12">
						<hr>
				</div>
		</div>
	    </div>
    </c:if>
	<!-- Danh Sach San pham (E) -->
		<%-- <div class="row" align="right">
			<div class="col-sm-12">
				<div class="form-group">
					<c:choose>
					<c:when test="${DatHangForm.flagXacNhan eq ('1')}">
						<input type="button" name="" disabled="disabled" class="btn btn-info " ng-click = "btnXoaDong()"  value="Xóa dòng">
					</c:when>
					<c:otherwise>
					<input type="button" name="" class="btn btn-info " ng-click = "btnXoaDong()"  value="Xóa dòng">
					</c:otherwise>
					</c:choose>
					<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#tableExport')" value="In">
				</div>
			</div>
		</div> --%>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${DatHangForm.message }</p>
					<p style="color: red; font-weight: bold;">${DatHangForm.messageErr }</p>
					<p style="color: red; font-weight: bold;">{{diaChi_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<c:if test="${!empty DatHangForm.chiTietDatHangRowForms }">
		<div class="panel-body">
                   <table width="100%" class="table table-striped table-bordered table-hover" id="tableExport">
                       <thead>
                           <tr>
                           		<th style="width: 20px;  text-align: center">Chọn</th>
                               <!-- 	<th style="width: 30px;  text-align: center">STT</th> -->
								<th style="width: 200px; text-align: center">Mã/Tên sản phẩm</th>
								<th style="width: 50px; text-align: center">Số lượng</th>
								<th style="width: 70px; text-align: center">Giá nhập</th>
								<th style="width: 100px; text-align: center">Thành tiền</th>
								<th style="width: 220px; text-align: center">Địa chỉ</th>
                           </tr>
                       </thead>
                       <tbody style="overflow: auto; height:50px">
                       <input type="hidden" ng-model="lstSize" ng-init="lstSize= '${fn:length(DatHangForm.chiTietDatHangRowForms)}'">
                       <form:input class="form-control" type="hidden"  path="idDatHang"  name="idDatHang" ng-model ="idDatHang" ng-init="idDatHang ='${DatHangForm.idDatHang}'" />
                       
                       <c:forEach var="items" items="${DatHangForm.chiTietDatHangRowForms }" varStatus="status">
                         <tr class="odd gradeX">
                                <td style="text-align: center">
		                             <input type="checkbox" ng-model="selected['${items.no}']"  ng-init ="selected['${items.no}']='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'">
		                        </td>
                                <%-- <td  class="form-inline" style="text-align: center">${items.no } </td> --%>
                                <td  class="form-inline" >${items.tenSanPham }</td>
			                     <td style="width: 50px">
		                           <form:input type="number"  maxlength="10" class="form-control" path="chiTietDatHangRowForms[${status.index}].soLuongNhap"   
		                           ng-model = "chiTietDatHangRowForms[${status.index}].soLuongNhap"  ng-init ="chiTietDatHangRowForms[${status.index}].soLuongNhap = ${items.soLuongNhap}" />	
		                        </td>
		                         <td class="center" style="text-align: right; width: 70px">
		                        	<form:input type="hidden"  maxlength="10" class="form-control" path="chiTietDatHangRowForms[${status.index}].giaNhap"   
		                        	ng-model = "chiTietDatHangRowForms[${status.index}].giaNhap"  ng-init ="chiTietDatHangRowForms[${status.index}].giaNhap = ${items.giaNhap}" />
		                        	<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaNhap}" />
		                        </td>
		                		<td class="center" style="text-align: right">
		                			{{ (chiTietDatHangRowForms[${status.index}].soLuongNhap * chiTietDatHangRowForms[${status.index}].giaNhap) | number }}
		                		</td>
		                		<td class="center" style="text-align: right">
		                			<form:input  class="form-control" path="chiTietDatHangRowForms[${status.index}].diaChi"   
		                			ng-model = "chiTietDatHangRowForms[${status.index}].diaChi"  ng-init ="chiTietDatHangRowForms[${status.index}].diaChi = '${items.diaChi}'" />
		                		</td> 
                        </tr>
                       </c:forEach>
                       </tbody>
                   </table>
        </div>
	         <div class="row" style="margin-left: 0px">
        <c:if test="${DatHangForm.flagUpdate ne ('1')}">
						<button type="button" class="btn btn-info"  ng-click ="btnDangKy();" >
					  		<i class="glyphicon glyphicon-ok"></i> Đăng kí
						</button>
						<button  type="button" class="btn btn-info" ng-click ="btnXoaDong()">
					  		<i class="glyphicon glyphicon-trash"></i> Xóa dòng
						</button>
		</c:if>
						<button type="button" class="btn btn-info" onclick="testExcel_2();">
					  		<i class="glyphicon glyphicon-save-file"></i> Export Excel
						</button>
			</div>
	    <div class="row">
				<div class="col-lg-12">
						<hr>
				</div>
		</div>
        </c:if>
        <c:if test="${empty DatHangForm.chiTietDatHangRowForms }">
		<div class="panel-body">
                   <table width="100%" class="table table-striped table-bordered table-hover" >
                       <thead>
                           <tr>
                           		<th style="width: 20px;  text-align: center">Chọn</th>
                               <!-- 	<th style="width: 30px;  text-align: center">STT</th> -->
								<th style="width: 200px; text-align: center">Mã/Tên sản phẩm</th>
								<th style="width: 50px; text-align: center">Số lượng</th>
								<th style="width: 70px; text-align: center">Giá nhập</th>
								<th style="width: 100px; text-align: center">Thành tiền</th>
								<th style="width: 220px; text-align: center">Địa chỉ</th>
                           </tr>
                       </thead>
                   </table>
        </div>
        </c:if>
        </div>
        <!--Message (S)-->
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;"></p>
					<p style="color: red; font-weight: bold;"></p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div>
				<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">
				  <i class="glyphicon glyphicon-plus"></i> Thêm
				</button>
				<button type="button" class="btn btn-info" onclick="testExcel();">
				 		<i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<button type="button" class="btn btn-info" ng-click="btnClear();">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
			</div>
		</div>
		<!-- Detail (S) -->
		<c:if test="${!empty DatHangForm.datHangRowForms }">
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="width: 40px;  text-align: center">STT</th>
										<th style="width: 100px; text-align: center">Mã đơn hàng</th>
										<th style="width: 70px; text-align: center">Số lượng</th>
										<th style="width: 200px;  text-align: center">Thành tiền</th>
<!-- 										<th style="width: 80px;  text-align: center">Trạng thái</th> -->
										<th style="width: 120px; text-align: center">Ngày tạo</th>
<!-- 										<th style="width: 120px; text-align: center">Ngày nhận hàng</th> -->
										<th style="width: 50px; text-align: center" data-tableexport-display="none">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                                	<c:forEach var="items" items="${DatHangForm.datHangRowForms }">
		                                <tr class="odd gradeX">
		                                         <td class="center" style="text-align: center">${items.no}</td>
		                                         <td style="text-align: center">${items.idDonHang}</td>
							                     <td style="text-align: right">${items.soLuong}</td>
							                     <td style="text-align: right"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.thanhTien}" /></td>
<%-- 					                    		 <td style="text-align: left">${items.trangThai}</td> --%>
		                                         <td style="text-align: center">${items.ngayDatHang}</td>
<%-- 		                                         <td class="center" style="text-align: center">${items.ngayNhanHang}</td> --%>
		                                         <td class="center" style="text-align: center" data-tableexport-display="none">
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Sửa" ng-click="btnGetById('${items.idDonHang}', '${items.idTrangThai}');"></span>
														</button>
		                                        </td>
		                                 </tr>
		                             </c:forEach>    
                                </tbody>
                            </table>
                        </div>
               </c:if>         
           <form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${DatHangForm.flagUpdate}'" />             
		</form:form>
		<script src="/storeManagerSystem/view/js/datHang.js"></script>
          <!-- Detail (E) -->
	</div>
	</div>
	<script>
    $(document).ready(function() {
        $('#dataTables-example1').DataTable({
            responsive: true
        });
    });
    
    function testExcel(){
    	$('#dataTables-example').tableExport({
    		fileName:'datHang',
    		type:'excel',
    	    excelFileFormat:'xmlss',
    	    worksheetName: ['Table 1','Table 2', 'Table 3']});
    	}
    function testExcel_2(){
    	$('#tableExport').tableExport({
    		fileName:'chiTietDatHang',
    		type:'excel',
    	    excelFileFormat:'xmlss',
    	    worksheetName: ['Table 1','Table 2', 'Table 3']});
    	}
    	</script>