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
					<form:input class="form-control"  type="text" path="idKhachHang"  name="idKhachHang" ng-model = "idKhachHang"  ng-init ="idKhachHang = '${HoaDonForm.idKhachHang}'"/>
					<form:input class="form-control" type="hidden" path="idHoaDon"  name="idHoaDon" ng-model = "idHoaDon"  ng-init ="idHoaDon = '${HoaDonForm.idHoaDon}'" />
					<p style="color: red;">{{idKhachHang_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày lập</label> 
							<div class='input-group date' id='datetimepicker1'>
	                   				 <form:input type='text' class="form-control" path="ngayLap"  name="ngayLap" ng-model = "ngayLap"  ng-init ="ngayLap = '${HoaDonForm.ngayLap}'"/>
	                    			<span class="input-group-addon">
	                       			 <span class="glyphicon glyphicon-calendar"></span>
	                   				 </span>
	                   				 <p style="color: red;">{{ngayLap_err}}</p>
	                		</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label >Số lượng sản phẩm</label> 
					<form:input class="form-control" type='text' path="soLuongSP"  name="soLuongSP" ng-model = "soLuongSP"  ng-init ="soLuongSP = '${HoaDonForm.soLuongSP}'" />
					<p style="color: red;">{{soLuongSP_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label >Điểm tích lũy lần này</label> 
					<form:input type='text' class="form-control" path="diemTichLuy"  name="diemTichLuy" ng-model = "diemTichLuy"  ng-init ="diemTichLuy = '${HoaDonForm.diemTichLuy}'"   />
					<p style="color: red;">{{diemTichLuy_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tiền khuyến mãi</label> 
					<form:input type='text' class="form-control" path="tienKhuyenMai"  name="tienKhuyenMai" ng-model = "tienKhuyenMai"  ng-init ="tienKhuyenMai = '${HoaDonForm.tienKhuyenMai}'"  />
					<p style="color: red;">{{tienKhuyenMai_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label >Tổng điểm tích lũy</label> 
					<form:input type='text' class="form-control" path="tongDiemTichLuy"  name="tongDiemTichLuy" ng-model = "tongDiemTichLuy"  ng-init ="tongDiemTichLuy = '${HoaDonForm.tongDiemTichLuy}'" />
					<p style="color: red;">{{tongDiemTichLuy_err}}</p>
				</div>
			</div>
		</div> 
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tổng tiền</label> 
					<form:input type='text' class="form-control" path="tongTien"  name="tongTien" ng-model = "tongTien"  ng-init ="tongTien = '${HoaDonForm.tongTien}'" />
					<p style="color: red;">{{tongTien_err}}</p>
				</div>
			</div>
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
			<div >
				<input type="button" name="" class="btn btn-info "  value="Đăng ký">
				<input type="button" name="" class="btn btn-info "  value="In">
				<input type="button" name="" class="btn btn-info "  value="Hủy">
			</div>
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
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa" ng-click="btnGetProductById('${items.idHoaDon}');"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa" ng-click="btnDelete('${items.idHoaDon}');"></span>
														</button>
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Chi tiết" ng-click="btnDelete('${items.idHoaDon}');"></span>
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