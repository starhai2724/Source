<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<!-- Navigation -->
	<div id="page-wrapper" ng-app="DotKhuyenMaiForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Đợt Khuyến Mãi</h1>
			</div>
			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<h4>THÔNG TIN ĐỢT KHUYẾN MÃI</h4> 		
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<h4>LOẠI KHUYẾN MÃI</h4> 		
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<h4>ĐIỀU KIỆN ÁP DỤNG</h4> 		
				</div>
			</div>
		</div>
		<form:form id="DotKhuyenMaiForm" modelAttribute="DotKhuyenMaiForm" role="form" method="POST" >
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tên đợt KM</label> 
					<form:input placeholder="Tên đợt KM"  class="form-control" type="text" path="tenDKM"  name="tenDKM" ng-model = "tenDKM"  ng-init ="tenDKM = '${DotKhuyenMaiForm.tenDKM}'" />
					<form:input class="form-control" type="hidden" path="maDKM"  name="maDKM" />
					<p style="color: red;">{{tenDKM_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại KM</label> 
					<!-- <select name="loaiKM" class="form-control">
						  <option value="volvo" >--- Chọn loại khuyến mãi ---</option>
						  <option value="volvo">Theo phần trăm sản hẩm</option>
						  <option value="saab">Theo phần trăm hóa đơn</option>
						  <option value="fiat">Tặng kèm sản phầm</option>
						  <option value="audi">Tặng phiếu giảm giá</option>
						  <option value="audi">Tặng phiếu quà tặng</option>
						  <option value="audi">Miễn phí ship hàng</option>
					</select> -->
					<form:select class="form-control" path="loaiKM">
					    <form:options items="${DotKhuyenMaiForm.lst_loaiKM}" />
					</form:select>
					<p style="color: red;">{{loaiKM_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại Thẻ</label> 
					<!-- <select name="loaiThe" class="form-control" >
						  <option value="volvo" >--- Chọn loại thẻ ---</option>
						  <option value="volvo">Thẻ khách hàng</option>
						  <option value="saab">Thẻ thành viên</option>
						  <option value="fiat">Thẻ vàng</option>
						  <option value="audi">Thẻ VIP</option>
					</select> -->
					<form:select class="form-control" path="dk_loaiThe">
					    <form:options items="${DotKhuyenMaiForm.lst_dk_loaiThe}" />
					</form:select>
					<p style="color: red;">{{dk_loaiThe_err}}</p>
				</div>
			</div>
		</div>
		 <div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày bắt đầu KM</label> 
							<!-- <div class='input-group date' id='datetimepicker1'>
	                   				 <input type='text' class="form-control" />
	                    			<span class="input-group-addon">
	                       			 <span class="glyphicon glyphicon-calendar"></span>
	                   				 </span>
	                		</div> -->
	                <form:input placeholder="Ngày bắt đầu KM"  class="form-control" type="text" path="ngayBD"  name="ngayBD" ng-model = "ngayBD"  ng-init ="ngayBD = '${DotKhuyenMaiForm.ngayBD}'" />
					<p style="color: red;">{{ngayBD_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Mức giảm giá</label> 
					<form:input style="width: 150px" placeholder="Mức"  class="form-control" type="text" path="mucKM"  name="mucKM" ng-model = "mucKM"  ng-init ="mucKM = '${DotKhuyenMaiForm.mucKM}'" />
					<!-- <select name="mucGiamGiaKb" class="form-control" style="margin-left: 155px;width: 180px;margin-top: -35px">
						  <option value="volvo" >--- Chọn đơn vị ---</option>
						  <option value="volvo"> % Hóa đơn</option>
						  <option value="saab"> % Sản phẩm</option>
						  <option value="fiat"> VNĐ</option>
						  <option value="audi"> Cái</option>
					</select> -->
					<form:select style="margin-left: 155px;width: 180px;margin-top: -35px" class="form-control" path="donViKM">
					    <form:options items="${DotKhuyenMaiForm.lst_donViKM}" />
					</form:select>
					<p style="color: red;">{{mucKM_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tổng số lượng sản phẩm</label> 
					<form:input placeholder="Tổng số lượng sản phẩm"  class="form-control" type="text" path="dk_tongSL"  name="dk_tongSL" ng-model = "dk_tongSL"  ng-init ="dk_tongSL = '${DotKhuyenMaiForm.dk_tongSL}'" />
					<p style="color: red;">{{dk_tongSL_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày kết thúc KM</label> 
							<!-- <div class='input-group date' id='datetimepicker1'>
	                   				 <input type='text' class="form-control" />
	                    			<span class="input-group-addon">
	                       			 <span class="glyphicon glyphicon-calendar"></span>
	                   				 </span>
	                		</div> -->
	               <form:input placeholder="Ngày két thúc KM"  class="form-control" type="text" path="ngayKT"  name="ngayKT" ng-model = "ngayKT"  ng-init ="ngayKT = '${DotKhuyenMaiForm.ngayKT}'" />
					<p style="color: red;">{{ngayKT_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tổng hóa đơn</label> 
					 <form:input placeholder="Tổng hóa đơn"  class="form-control" type="text" path="dk_tongHD"  name="dk_tongHD" ng-model = "dk_tongHD"  ng-init ="dk_tongHD = '${DotKhuyenMaiForm.dk_tongHD}'" />	
					<p style="color: red;">{{dk_tongHD_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${DotKhuyenMaiForm.message }</p>
					<p style="color: red; font-weight: bold;">${DotKhuyenMaiForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div >
				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Đăng kí">
				<input type="button" name="" class="btn btn-info " ng-click="btnIn()" value="In">
				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Hủy">
			</div>
		</div>
		</div>
		<!-- Detail (S) -->
		<c:if test="${!empty DotKhuyenMaiForm.lst }">
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="width: 40px;padding-left: 2px;padding-right: 2px;font-size: 13px">STT</th>
										<th style="width: 100px;">Mã đợt KM</th>
										<th style="width: 200px;padding-left: 4px;padding-right: 4px;">Tên đợt KM</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 100px;">Ngày bắt đầu</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 110px;">Ngày kết thúc</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 120px;">Loại khuyến mãi</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 100px;">Mức giảm giá</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">ĐK_Loại thẻ</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">ĐK_Tổng HĐ</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">ĐK_Tổng SLSP</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 100px;">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                                <c:forEach var="items" items="${DotKhuyenMaiForm.lst }">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">${items.no}</td>
		                                        <td>${items.maDKM}</td>
							                     <td>${items.tenDKM}</td>
							                     <td>${items.ngayBD}</td>
		                                      	 <td class="center" style="text-align: center">${items.ngayKT}</td>
					                    		 <td class="center">${items.loaiKM}</td>
		                                       	<td>${items.mucGiamGia}</td>
		                                        <td style="text-align: center">${items.dk_loaiThe}</td>
		                                        <td>${items.dk_tongHD}</td>
		                                        <td class="center" style="text-align: center">${items.dk_tongSL}</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" ng-click="btnGetById1('${items.maDKM}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.maDKM}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr>
		                                <!--  <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">2</td>
		                                        <td>AHFGZ120785</td>
							                     <td>Khuyến mãi sinh nhật</td>
							                     <td>2017/10/01 8.00-22.00</td>
		                                      	 <td class="center" style="text-align: center">2017/10/05 8.00-22.00</td>
					                    		 <td class="center">Tặng kèm SP</td>
		                                       		<td>Tặng gấu bông</td>
		                                        <td style="text-align: center">Thẻ VIP</td>
		                                        <td>1,000,000 VNĐ</td>
		                                        <td class="center" style="text-align: center">2</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" >
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr> -->
		                        </c:forEach>
                                </tbody>
                            </table>
                        </div>
              		</c:if>          
          <!-- Detail (E) -->
    	</form:form>	
	</div>
<script src="/storeManagerSystem/view/js/dotKhuyenMai.js"></script>
<!-- /#wrapper -->
