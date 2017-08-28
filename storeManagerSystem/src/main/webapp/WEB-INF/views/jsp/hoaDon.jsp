<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 

<div id="page-wrapper" ng-app="HoaDonForm" ng-controller="ctrl" >
		<form:form id="HoaDonForm" modelAttribute="HoaDonForm" role="form" method="POST" >
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản trị hóa đơn</h1>
<!-- 				<i style="font-size:24px;margin-top: -10px;" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i> -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- Danh Sach San pham (S) -->
	<c:choose>
	<c:when test="${HoaDonForm.flagUpdate eq ('1')}">
	<div id="demo" class="collapse in">
	</c:when>
	<c:otherwise>
	<div id="demo" class="collapse">
	</c:otherwise>
	</c:choose>
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
                         <tbody style="overflow: auto; height:50px" ng-model = "listSanPham" ng-init ="listSanPham = '${fn:length(HoaDonForm.lstSanPham)}'">
                       		  <c:forEach var="items" items="${HoaDonForm.lstSanPham }">
                           <tr class="odd gradeX">
                            	   <td class="center" style="text-align: center"><input type="checkbox" ng-model="selected1[${items.no}]"  ng-init ="selected1[${items.no}]='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'"></td>
                                   <td style="text-align: center">${items.no}</td>
                                   <td>${items.idSanPham}</td>
                    			   <td>${items.tenSP}</td>
                                   <td>${items.tenLoaiSP }</td>
                  		           <td style="text-align: right">
                  		           		<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaBan }" />
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
	<!-- Danh Sach San pham (E) -->
		<c:choose>
		<c:when test="${empty HoaDonForm.chiTietHoaDonRowForms }">
		<div class="panel-body">
                   <table width="100%" class="table table-striped table-bordered table-hover" >
                       <thead>
                           <tr>
                               	<th style="width: 40px;  text-align: center">STT</th>
								<th style="width: 120px; text-align: center">Mã sản phẩm</th>
								<th style="width: 230px; text-align: center">Tên sản phẩm</th>
								<th style="width: 120px; text-align: center">Loại sản phẩm</th>
								<th style="width: 100px; text-align: center">Số lượng</th>
								<th style="width: 120px; text-align: center">Giá</th>
								<th style="width: 195px; text-align: center">Thành tiền</th>
                           </tr>
                       </thead>
                   </table>
        </div>
        </c:when>
        <c:otherwise>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<span style="font-weight: bold;">Chi tiết hóa đơn</span>
				<br/>
				<br/>
				
			</div>
		</div>
		<c:if test="${HoaDonForm.flagUpdate eq ('1')}">
		<div class="row" style="margin-left: 0px">
			<div class="col-sm-3">
				<div class="form-group">
					<label >Mã khách hàng</label> 
					<form:input class="form-control" disabled="true" type="text" path="idKhachHang"  name="idKhachHang" ng-model = "idKhachHang"  ng-init ="idKhachHang = '${HoaDonForm.idKhachHang}'"/>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label >Mã hóa đơn</label> 
					<form:input class="form-control" disabled="true"  type="text" path="idHoaDon"  name="idHoaDon" ng-model = "idHoaDon"  ng-init ="idHoaDon = '${HoaDonForm.idHoaDon}'"/>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${HoaDonForm.flagUpdate ne ('1')}">
		<div class="row" style="margin-left: 0px">
			<div class="col-sm-3">
				<div class="form-group">
					<label >Mã khách hàng</label> 
					<form:input class="form-control"  type="text" path="idKhachHang"  name="idKhachHang" ng-model = "idKhachHang"  ng-init ="idKhachHang = '${HoaDonForm.idKhachHang}'"/>
				</div>
			</div>
			<%-- <div class="col-sm-3">
				<div class="form-group">
					<label >Mã hóa đơn</label> 
					<form:input class="form-control"   type="text" path="idHoaDon"  name="idHoaDon" ng-model = "idHoaDon"  ng-init ="idHoaDon = '${HoaDonForm.idHoaDon}'"/>
				</div>
			</div> --%>
		</div>
		</c:if>
		<div class="row">
			<p style="color: red;">{{soLuongSP_err}}</p>
		</div>
		<div class="panel-body">
                   <table width="100%" class="table table-striped table-bordered table-hover" >
                       <thead>
                           <tr>
                           		<c:if test="${HoaDonForm.flagUpdate ne ('1')}">
									<th style="width: 40px;padding-left: 2px;padding-right: 2px; text-align: center">Chọn</th>
								</c:if>
								<c:if test="${HoaDonForm.flagUpdate eq ('1')}">
                               		<th style="width: 40px;  text-align: center">STT</th>
                               	</c:if>
								<th style="width: 120px; text-align: center">Mã sản phẩm</th>
								<th style="width: 230px; text-align: center">Tên sản phẩm</th>
								<!-- <th style="width: 120px; text-align: center">Loại sản phẩm</th> -->
								<th style="width: 100px; text-align: center">Số lượng</th>
								<th style="width: 120px; text-align: center">Giá</th>
								<th style="width: 120px; text-align: center">Thành tiền</th>
                           </tr>
                       </thead>
                       <tbody style="overflow: auto; height:50px">
                       <c:forEach var="items" items="${HoaDonForm.chiTietHoaDonRowForms }" varStatus="status">
                         <tr class="odd gradeX" id="id${items.no}">
                         		<c:if test="${HoaDonForm.flagUpdate ne ('1')}">
									<td class="center" style="text-align: center">
										<input type="checkbox" ng-model="selected[${items.no}]"  ng-init ="selected[${items.no}]='false'" ng-false-value="'NO'"  ng-true-value="'${items.no }'">
<%-- 										<input type="checkbox" ng-model="selected[${items.no}]"  ng-init ="selected[${items.no}]='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'"> --%>
									</td>
								</c:if>
								<c:if test="${HoaDonForm.flagUpdate eq ('1')}">
                                	<td class="center" style="text-align: center">${status.index + 1 }</td>
                                </c:if>
                                <td  class="form-inline" style="text-align: center">${items.idSanPham }</td>
			                    <td>${items.tenSanPham }</td>
			                    <%-- <td>${items.loaiSanPham }</td> --%>
		                        <c:if test="${HoaDonForm.flagUpdate eq ('1')}">
									<td class="center" style="text-align: right">${items.soLuongSP }</td>
									<td class="center" style="text-align: right">
										<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaMua}" />
									</td>
									<td class="center" style="text-align: right">
										<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.thanhTien }" />
									</td>
	                			</c:if>
	                			<c:if test="${HoaDonForm.flagUpdate ne ('1')}">
		                			<td>
		                             	<form:input type="number" maxlength="10" class="form-control" path="chiTietHoaDonRowForms[${status.index}].soLuongSP"   ng-model = "chiTietHoaDonRowForms[${status.index}].soLuongSP"  ng-init ="chiTietHoaDonRowForms[${status.index}].soLuongSP = ${items.soLuongSP}" />	
				                    </td>
				                	<td class="center" style="text-align: right" ng-model = "chiTietHoaDonRowForms[${status.index}].giaMua"  ng-init ="chiTietHoaDonRowForms[${status.index}].giaMua = ${items.giaMua}" >
				                		<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaMua}" />
				                	</td>
				                	<td class="center" style="text-align: right">
				                			{{ (chiTietHoaDonRowForms[${status.index}].giaMua * chiTietHoaDonRowForms[${status.index}].soLuongSP) | number }}
				                	</td>	
	                			</c:if>
                        </tr>
                       </c:forEach>
                       </tbody>
                   </table>
        </div>
        <c:if test="${HoaDonForm.flagUpdate ne ('1')}">
        <div class="row" style="margin-left: 0px">
			<div class="col-sm-4">
				<button type="button" class="btn btn-info"  ng-click ="btnCreate()" >
				  <i class="glyphicon glyphicon-ok"></i> Đăng kí
				</button>
				<button style="margin-right: 30px" type="button" class="btn btn-info" ng-click ="btnXoaDong()">
				  <i class="glyphicon glyphicon-trash"></i> Xóa dòng
				</button>
			</div>
		</div>
		</c:if>
		<div class="row">
			<div class="col-lg-12">
					<hr>
			</div>
		</div>
        </c:otherwise>
        </c:choose>
        </div>
         <input type="hidden" ng-model="lstSize" ng-init="lstSize= '${fn:length(HoaDonForm.chiTietHoaDonRowForms)}'">
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
				<button type="button" class="btn btn-info" ng-click="exportToExcel('#dataTables-example')">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<button type="button" class="btn btn-info" onclick="exportPDF();">
				  <i class="glyphicon glyphicon-print"></i> Export Pdf
				</button>
				<button type="button" class="btn btn-info" ng-click ="btnClear()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
			
				<!-- <input type="button" name="" class="btn btn-info "  value="Đăng ký"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="Export Excel"> -->
<!-- 				<input type="button" name="" class="btn btn-info "  value="Hủy"> -->
			</div>
		</div>
		<!-- Detail (S) -->
		<c:if test="${!empty HoaDonForm.lst }">
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="width: 40px;  text-align: center">STT</th>
										<th style="width: 100px; text-align: center">Mã hóa đon</th>
										<th style="width: 200px; text-align: center">Khách hàng</th>
										<th style="width: 70px;  text-align: center">SLSP</th>
										<th style="width: 80px;  text-align: center">Tiền KM</th>
										<th style="width: 120px; text-align: center">Tổng tiền</th>
										<th style="width: 70px;  text-align: center">Tổng điểm</th>
										<th style="width: 80px;  text-align: center">Ngày lập</th>
										<th style="width: 105px; text-align: center">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                                	<c:forEach var="items" items="${HoaDonForm.lst }">
		                                <tr class="odd gradeX">
		                                         <td class="center" style="text-align: center">${items.no}</td>
		                                         <td style="text-align: center">${items.idHoaDon}</td>
		                                         <td>${items.idKhachHang}</td>
							                     <td style="text-align: right">${items.soLuongSP}</td>
							                     <td style="text-align: right">${items.tienKhuyenMai}</td>
					                    		 <td style="text-align: right">${items.tongTien}</td>
		                                         <td style="text-align: right">${items.tongDiemTichLuy}</td>
		                                         <td class="center" style="text-align: center">${items.ngayLap}</td>
		                                        <td class="center" style="text-align: center">
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Chi tiết" ng-click="btnGetById('${items.idHoaDon}');"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa" ng-click="btnDelete('${items.idHoaDon}');"></span>
														</button>
														
		                                        </td>
		                                 </tr>
		                             </c:forEach>    
                                </tbody>
                            </table>
           
                        </div>
               </c:if>         
           <form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${HoaDonForm.flagUpdate}'" />             
		</form:form>
		<script src="/storeManagerSystem/view/js/hoaDon.js"></script>
		 <script>
    $(document).ready(function() {
        $('#dataTables-example1').DataTable({
            responsive: true
        });
    });
    </script>
          <!-- Detail (E) -->
	</div>