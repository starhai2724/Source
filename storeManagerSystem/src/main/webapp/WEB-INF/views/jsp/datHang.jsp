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
		<div class="row" align="right">
			<div class="col-sm-12">
				<div class="form-group">
					<input type="button" name="" class="btn btn-info " ng-click ="btnChonSP()" value="Chọn sản phẩm">
					<input type="button" name="" class="btn btn-info " ng-click = "btnXoaDong()"  value="Xóa dòng">
				</div>
			</div>
		</div>
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
                                <%-- <td  class="form-inline" style="text-align: center">${items.no } </td> --%>
                                <td  class="form-inline" >${items.tenSanPham }</td>
			                     <td style="width: 50px">
		                           <form:input type="number"  maxlength="10" class="form-control" path="chiTietDatHangRowForms[${status.index}].soLuongNhap"   
		                           ng-model = "chiTietDatHangRowForms[${status.index}].soLuongNhap"  ng-init ="chiTietDatHangRowForms[${status.index}].soLuongNhap = ${items.soLuongNhap}" />	
		                        </td>
		                         <td class="center" style="text-align: right; width: 70px">
		                        	<form:input type="number"  maxlength="10" class="form-control" path="chiTietDatHangRowForms[${status.index}].giaNhap"   
		                        	ng-model = "chiTietDatHangRowForms[${status.index}].giaNhap"  ng-init ="chiTietDatHangRowForms[${status.index}].giaNhap = ${items.giaNhap}" />
		                        </td>
		                		<td class="center" style="text-align: right">
		                			{{ (chiTietDatHangRowForms[${status.index}].soLuongNhap * chiTietDatHangRowForms[${status.index}].giaNhap) | number }}
		                		</td>
		                		<td class="center" style="text-align: right">
		                			<form:input  maxlength="10" class="form-control" path="chiTietDatHangRowForms[${status.index}].diaChi"   
		                			ng-model = "chiTietDatHangRowForms[${status.index}].diaChi"  ng-init ="chiTietDatHangRowForms[${status.index}].diaChi = '${items.diaChi}'" />
		                		</td> 
                        </tr>
                       </c:forEach>
                       </tbody>
                   </table>
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
				<input type="button" name="" class="btn btn-info " ng-click="btnDangKy();"  value="Đăng ký">
				<input type="button" name="" class="btn btn-info "  value="In">
				<input type="button" name="" class="btn btn-info " ng-click="btnClear();" value="Hủy">
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
		                                         <td style="text-align: center">${items.idDonHang}</td>
							                     <td style="text-align: right">${items.soLuong}</td>
							                     <td style="text-align: right"><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${items.thanhTien}" /></td>
					                    		 <td style="text-align: left">${items.trangThai}</td>
		                                         <td style="text-align: center">${items.ngayDatHang}</td>
		                                         <td class="center" style="text-align: center">${items.ngayNhanHang}</td>
		                                         <td class="center" style="text-align: center">
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Sửa" ng-click="btnGetById('${items.idDonHang}');"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa" ng-click="btnDelete('${items.idDonHang}');"></span>
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