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
		</div>
		<form:form id="DotKhuyenMaiForm" modelAttribute="DotKhuyenMaiForm" role="form" method="POST" >
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tên đợt KM</label> 
					<form:input maxlength="30" placeholder="Tên đợt KM"  class="form-control" type="text" path="tenDKM"  name="tenDKM" ng-model = "tenDKM"  ng-init ="tenDKM = '${DotKhuyenMaiForm.tenDKM}'" />
					<form:input class="form-control" type="hidden" path="maDKM"  name="maDKM" />
					<p style="color: red;">{{tenDKM_err}}</p>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại KM</label> 
					<form:select class="form-control" path="loaiKM">
					    <form:options items="${DotKhuyenMaiForm.lst_loaiKM}" />
					</form:select>
					<p style="color: red;">{{loaiKM_err}}</p>
				</div>
			</div>
		</div>
		 <div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày bắt đầu KM</label> 
	                <form:input placeholder="Ngày bắt đầu KM"  class="form-control" type="date" path="ngayBD"  name="ngayBD"/>
<!-- 					<p style="color: red;">{{ngayBD_err}}</p> -->
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Mức giảm giá</label> 
					<form:input maxlength="10" placeholder="Mức"  class="form-control" type="text" path="mucKM"  name="mucKM" ng-model = "mucKM"  ng-init ="mucKM = '${DotKhuyenMaiForm.mucKM}'" />
					<p style="color: red;">{{mucKM_err}}</p>
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày kết thúc KM</label> 
	               		<form:input placeholder="Ngày két thúc KM"  class="form-control" type="date" path="ngayKT" />
<!-- 						<p style="color: red;">{{ngayKT_err}}</p> -->
				</div>
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-8">
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
				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="In">
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
										<th style="padding-left: 5px;padding-right: 4px;width: 90px;">Mã đợt KM</th>
										<th style="width: 200px;padding-left: 4px;padding-right: 4px;">Tên đợt KM</th>
										<th style="padding-left: 5px;width: 120px;padding-right: 4px;">Ngày bắt đầu</th>
										<th style="padding-left: 5px;width: 110px;padding-right: 4px;">Ngày kết thúc</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 150px;">Loại khuyến mãi</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 130px;">Mức giảm giá</th>
										<th style="padding-left: 17px;padding-right: 2px;width: 140px;">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                                <c:forEach var="items" items="${DotKhuyenMaiForm.lst }">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">${items.no}</td>
		                                         <td>${items.maDKM}</td>
							                     <td style="width: 200px;padding-left: 4px;padding-right: 4px;">${items.tenDKM}</td>
							                     <td>${items.ngayBD}</td>
		                                      	 <td class="center" style="text-align: center">${items.ngayKT}</td>
					                    		 <td class="center" style="padding-left: 5px;padding-right: 4px;width: 130px;">${items.loaiKM}</td>
		                                       	 <td>${items.mucGiamGia}</td>
		                                        <td class="center" style="text-align: center;width: 140px;">
		                                        		<button class="btn" type="button" ng-click="btnGetById('${items.maDKM}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.maDKM}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDetail('${items.maDKM}');" >
															<span class="glyphicon glyphicon-list" data-toggle="tooltip" data-original-title="Chi tiết"></span>
														</button>
		                                        </td>
		                                 </tr>
		                        </c:forEach>
                                </tbody>
                            </table>
                        </div>
              		</c:if>          
          <!-- Detail (E) -->
          <form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${DotKhuyenMaiForm.flagUpdate}'" />
    	</form:form>	
	</div>
<script src="/storeManagerSystem/view/js/dotKhuyenMai.js"></script>
<!-- /#wrapper -->
