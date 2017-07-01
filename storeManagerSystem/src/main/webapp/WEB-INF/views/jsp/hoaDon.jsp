<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="page-wrapper" ng-app="HoaDonForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản trị hóa đơn</h1>
			</div>
			<i style="font-size:24px;margin-left: 1500px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
		<form:form id="HoaDonForm" modelAttribute="HoaDonForm" role="form" method="POST" >
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label >Mã khách hàng</label> 
					<form:input class="form-control" disabled="true" type="text" path="idKhachHang"  name="idKhachHang" ng-model = "idKhachHang"  ng-init ="idKhachHang = '${HoaDonForm.idKhachHang}'"/>
				</div>
				<div class="form-group">
					<label >Mã hóa đơn</label> 
					<form:input class="form-control" disabled="true"  type="text" path="idHoaDon"  name="idHoaDon" ng-model = "idHoaDon"  ng-init ="idHoaDon = '${HoaDonForm.idHoaDon}'"/>
				</div>
			</div>
		</div>
		<c:if test="${!empty HoaDonForm.chiTietHoaDonRowForms }">
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
								<th style="width: 120px; text-align: center">Thành tiền</th>
                           </tr>
                       </thead>
                       <tbody style="overflow: auto; height:50px">
                       <c:forEach var="items" items="${HoaDonForm.chiTietHoaDonRowForms }" varStatus="status">
                         <tr class="odd gradeX">
                                <td class="center" style="text-align: center">${items.no }</td>
                                <td class="form-inline">${items.idSanPham }</td>
			                    <td>${items.tenSanPham }</td>
			                    <td>${items.loaiSanPham }</td>
		                        <td class="center" style="text-align: right">${items.soLuongSP }</td>
		                		<td class="center">${items.giaMua }</td>
		                		<td class="center">${items.thanhTien }</td>
                        </tr>
                       </c:forEach>
                       </tbody>
                   </table>
        </div>
        </c:if>
        <c:if test="${empty HoaDonForm.chiTietHoaDonRowForms }">
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
								<th style="width: 120px; text-align: center">Thành tiền</th>
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
				<!-- <input type="button" name="" class="btn btn-info "  value="Đăng ký"> -->
				<input type="button" name="" class="btn btn-info "  value="In">
				<input type="button" name="" class="btn btn-info "  value="Hủy">
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
										<th style="width: 50px;  text-align: center">Điểm</th>
										<th style="width: 70px;  text-align: center">Tổng điểm</th>
										<th style="width: 80px;  text-align: center">Ngày lập</th>
										<th style="width: 110px; text-align: center">Thao tác</th>
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
		                                         <td style="text-align: right">${items.diemTichLuy}</td>
		                                         <td style="text-align: right">${items.tongDiemTichLuy}</td>
		                                         <td class="center" style="text-align: center">${items.ngayLap}</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" >
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa" ng-click="btnGetById('${items.idHoaDon}');"></span>
														</button>
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
          <!-- Detail (E) -->
	</div>