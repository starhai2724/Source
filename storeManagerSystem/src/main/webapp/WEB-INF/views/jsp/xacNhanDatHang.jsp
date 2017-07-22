<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="page-wrapper" ng-app="DatHangForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản trị đặt hàng</h1>
			</div>
			<i style="font-size:24px;margin-left: 1500px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
		<form:form id="DatHangForm" modelAttribute="DatHangForm" role="form" method="GET" >
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Cửa hàng</label> 
					<form:select class="form-control" path="cuaHang">
					    <form:options items="${DatHangForm.danhSachCuaHang}" />
					</form:select>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Trạng thái</label> 
					<form:select class="form-control" path="trangThai">
					    <form:options items="${DatHangForm.loaiTrangThai}" />
					</form:select>
				</div>
			</div>
		</div>
		<div class="row" align="right">
			<div class="col-sm-12">
				<div class="form-group">
					<input type="button" name="" class="btn btn-info " ng-click ="btnTimKiem();" value="Tìm kiếm">
					<input type="button" name="" class="btn btn-info " ng-click = "btnHuyQLDT()"  value="Hủy">
				</div>
			</div>
		</div>
		 <c:if test="${!empty DatHangForm.chiTietDatHangRowForms }">
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
                       <tbody style="overflow: auto; height:50px">
                       <input type="hidden" ng-model="lstSize" ng-init="lstSize= '${fn:length(DatHangForm.chiTietDatHangRowForms)}'">
                       <form:input class="form-control" type="hidden"  path="idDatHang"  name="idDatHang" ng-model ="idDatHang" ng-init="idDatHang ='${DatHangForm.idDatHang}'" />
                       
                       <c:forEach var="items" items="${DatHangForm.chiTietDatHangRowForms }" varStatus="status">
                         <tr class="odd gradeX">
                                <td style="text-align: center">
		                             <input type="checkbox" ng-model="selected['${items.no}']"  ng-init ="selected['${items.no}']='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'">
		                        </td>
                                <td  class="form-inline" >${items.tenSanPham }</td>
			                     <td style="width: 50px">${items.soLuongNhap}</td>
		                         <td class="center" style="text-align: right; width: 70px">
		                         	<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.giaNhap}" />
		                        </td>
		                		<td class="center" style="text-align: right">
		                			<fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.thanhTien}" />
		                		</td>
		                		<td class="center" style="text-align: left">
		                			${items.diaChi}
		                		</td> 
                        </tr>
                       </c:forEach>
                       </tbody>
                   </table>
        </div>
        </c:if>
        <!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${DatHangForm.message }</p>
					<p style="color: red; font-weight: bold;">${DatHangForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
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
		<!-- Detail (S) -->
		<c:if test="${!empty DatHangForm.datHangRowForms }">
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="width: 40px;  text-align: center">STT</th>
										<th style="width: 100px; text-align: center">Cửa hàng</th>
										<th style="width: 100px; text-align: center">Địa chỉ CH</th>
										<th style="width: 100px; text-align: center">Mã đơn hàng</th>
										<th style="width: 70px; text-align: center">Số lượng</th>
										<th style="width: 200px;  text-align: center">Thành tiền</th>
										<th style="width: 80px;  text-align: center">Trạng thái</th>
										<th style="width: 120px; text-align: center">Ngày đặt hàng</th>
										<th style="width: 120px; text-align: center">Ngày nhận hàng</th>
										<th style="width: 110px; text-align: center">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                                	<c:forEach var="items" items="${DatHangForm.datHangRowForms }">
		                                <tr class="odd gradeX">
		                                         <td class="center" style="text-align: center">${items.no}</td>
		                                         <td style="text-align: center">${items.tenCuaHang}</td>
		                                         <td style="text-align: center">${items.diaChiCuaHang}</td>
		                                         <td style="text-align: center">${items.idDonHang}</td>
							                     <td style="text-align: right">${items.soLuong}</td>
							                     <td style="text-align: right"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.thanhTien}" /></td>
					                    		 <td style="text-align: left">${items.trangThai}</td>
		                                         <td style="text-align: center">${items.ngayDatHang}</td>
		                                         <td class="center" style="text-align: center">${items.ngayNhanHang}</td>
		                                         <td class="center" style="text-align: center">
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Sửa" ng-click="btnGetByIdQLDT('${items.idDonHang}');"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xác nhận" ng-click="btnXacNhan('${items.idDonHang}');"></span>
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