<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="page-wrapper" ng-app="ThoiHanSuDungForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản trị thời gian sử dụng</h1>
			</div>
<!-- 			<i style="font-size:24px;margin-left: 1500px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i> -->
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
		<form:form id="ThoiHanSuDungForm" modelAttribute="ThoiHanSuDungForm" role="form" method="GET" >
		<div class="row" align="right">
			<div class="col-sm-12">
				<div class="form-group">
					<button type="button" class="btn btn-info"  ng-click="exportToExcel('#tableExport')" >
					  <i class="glyphicon glyphicon-save-file"></i> Export excel
					</button>
					<button style="margin-right: 30px" type="button" class="btn btn-info" ng-click = "btnHuyQLDT()">
					  <i class="glyphicon glyphicon-refresh"></i> Refesh
					</button>
<!-- 					<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#tableExport')" value="In"> -->
<!-- 					<input type="button" name="" class="btn btn-info " ng-click = "btnHuyQLDT()"  value="Hủy"> -->
				</div>
			</div>
		</div>
        <!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${ThoiHanSuDungForm.message }</p>
					<p style="color: red; font-weight: bold;">${ThoiHanSuDungForm.messageErr }</p>
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
		<%-- <c:if test="${!empty ThoiHanSuDungForm.lst }"> --%>
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="width: 40px;  text-align: center">STT</th>
										<th style="width: 100px; text-align: center">Tên cửa hàng</th>
										<th style="width: 100px; text-align: center">Domain</th>
										<th style="width: 100px; text-align: center">Email</th>
										<th style="width: 70px; text-align: center">Số điện thoại</th>
										<th style="width: 200px;  text-align: center">Thời gian hết hạn</th>
										<th style="width: 110px; text-align: center">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                                	<c:forEach var="items" items="${ThoiHanSuDungForm.lst }" varStatus="status">
		                                <tr class="odd gradeX">
		                                         <td class="center" style="text-align: center">${status.index + 1 }</td>
		                                         <td >${items.tenCuaHang}</td>
		                                         <td >${items.pathJSP}</td>
		                                         <td >${items.email}</td>
							                     <td >${items.sdt}</td>
					                    		 <td style="text-align: center">${items.thoiGianSuDung}</td>
		                                         <td class="center" style="text-align: center">
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Gia hạn" ng-click="btnUpdate('${items.idStoreOnwer}');"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-check" data-toggle="tooltip" data-original-title="Vô hiệu" ng-click="btnVoHieu('${items.idStoreOnwer}');"></span>
														</button>
		                                        </td>
		                                 </tr>
		                             </c:forEach>    
                                </tbody>
                            </table>
               </div>
<%--                </c:if>          --%>
		</form:form>
<!-- 		<script src="/storeManagerSystem/view/js/thoiHanSuDung.js"></script> -->
          <!-- Detail (E) -->
	</div>