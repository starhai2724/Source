<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="LoaiTheForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Loại thẻ</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="LoaiTheForm" modelAttribute="LoaiTheForm" role="form" method="POST" >
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tên loại thẻ</label> 
					<form:input class="form-control" type="text" path="tenLoaiThe"  name="tenLoaiThe" ng-model = "tenLoaiThe"  ng-init ="tenLoaiThe = '${LoaiTheForm.tenLoaiThe}'" />
					<form:input class="form-control" type="hidden" path="idLoaiThe"  name="idLoaiThe" />
					<p style="color: red;">{{tenLoaiThe_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-sm-3">
					<label>Điểm</label> 
					<form:input class="form-control" type="text" path="diem"  name="diem" ng-model = "diem"  ng-init ="diem = '${LoaiTheForm.diem}'" />
					<p style="color: red;">{{diem_err}}</p>
				</div>	
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${LoaiTheForm.message }</p>
					<p style="color: red; font-weight: bold;">${LoaiTheForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 650px">
			<div >
				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Đăng kí">
				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="In">
				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Hủy">
			</div>
		</div>
		
		<!-- <div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div -->
		
		<c:if test="${!empty LoaiTheForm.lst }">
		<div class="panel-body" style="width: 650px">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="text-align: center; width: 40px;">STT</th>
										<th style="text-align: center; width: 250px">Tên loại thẻ</th>
										<th style="text-align: center; width: 80px">Điểm</th>
										<th style="text-align: center;	width: 60px">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${LoaiTheForm.lst }">
		                                <tr class="gradeX">
		                                        <td class="center" style="text-align: center">${items.no}</td>
		                                        <td>${items.tenLoaiThe}</td>
							                    <td>${items.diem}</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" ng-click="btnGetById('${items.idLoaiThe}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.idLoaiThe}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${LoaiTheForm.flagUpdate}'" />
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script src="/storeManagerSystem/view/js/cardType.js"></script>

<!-- /#wrapper -->