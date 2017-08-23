<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
#table-wrapper {
  position:relative;
}
#table-scroll {
  height:450px;
  overflow:auto;  
  margin-top:20px;
}
#table-wrapper table {
  width:100%;

}
#table-wrapper table thead th .text {
  position:absolute;   
  top:-20px;
  z-index:2;
  height:20px;
  width:35%;
  border:1px solid red;
}
</style>

<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="ProductForm" ng-controller="ctrl">
	<form:form id="ProductForm" modelAttribute="ProductForm3" role="form" method="POST" >
	<!-- Danh Sach San pham (S) -->
	<div id="sanPhamPhanAnh" class="collapse" > 
	<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Danh sách sản phẩm</h1>
			</div>
			<!-- /.col-lg-12 -->
	</div>
	<div class="row">
		<input type="button" name="" class="btn btn-info " style="margin-left: 30px" ng-click ="btnPhanAnh()" value="Phản ánh">
	</div>
	<div class="panel-body">
                     <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                         <thead>
                             <tr>
                             	<th style="text-align: center; width: 5px;"></th>
                                <th style="text-align: center; width: 10px;padding-left: 5px;padding-right: 4px; ">STT</th>
								<th style="text-align: center; width: 50px;padding-left: 5px;padding-right: 4px; ">Mã SP</th>
								<th style="text-align: center; width: 150px">Tên sản phẩm</th>
								<th style="text-align: center; width: 120px">Loại SP</th>
								<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Giá mua</th>
								<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Giá bán</th>
                             </tr>
                         </thead>
                         <tbody style="overflow: auto; height:50px" ng-model = "listSanPham" ng-init ="listSanPham = '${fn:length(ProductForm3.lstSanPham)}'">
                       		  <c:forEach var="items" items="${ProductForm3.lstSanPham }">
                           <tr class="odd gradeX">
                            	   <td class="center" style="text-align: center"><input type="checkbox" ng-model="selected1[${items.no}]"  ng-init ="selected1[${items.no}]='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'"></td>
                                   <td style="text-align: center">${items.no}</td>
                                   <td>${items.idSanPham}</td>
                    			   <td>${items.tenSP}</td>
                                   <td>${items.tenLoaiSP }</td>
                                   <td style="text-align: right">${items.giaMua }</td>
                  		           <td style="text-align: right">${items.giaBan }</td>
                            </tr>
              				</c:forEach>
                         </tbody>
                     </table>
    </div>
    </div>
	<!-- Danh Sach San pham (E) -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Chi Tiết Sản Phẩm Khuyến Mãi</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row" align="right" style="width: 100%">
			<div>
				<input type="button" name="" class="btn btn-info " ng-click ="btnDangKy()" value="Đăng ký">
				<input type="button" name="" class="btn btn-info " data-toggle="collapse" data-target="#sanPhamPhanAnh" value="Chọn SP Khuyến Mãi">
				<input type="button" name="" class="btn btn-info " ng-click ="btnXoaDong()" value="Xóa dòng">
				<input type="button" name="" class="btn btn-info " ng-click ="btnQuayVe()" value="Quay về">
			</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${ProductForm3.message }</p>
					<p style="color: red; font-weight: bold;">${ProductForm3.messageErr }</p>
					<p style="color: red; font-weight: bold;">{{giaBanKM_err}}</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		
		<c:if test="${!empty ProductForm3.lst }">
		<div id="table-wrapper">
  				<div id="table-scroll">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
										<th style="width: 40px;padding-left: 2px;padding-right: 2px;font-size: 13px"></th>
										<th style="text-align:center;width: 90px;">Mã SP</th>
										<th style="width: 250px;text-align:center">Tên sản phẩm</th>
										<th style="width: 180px;text-align:center">Giá mua</th>
										<th style="text-align:center; width: 180px;">Giá bán</th>
										<th style="text-align:center; width: 220px;">Giá bán KM</th>
										<!-- <th style="text-align:center; width: 150px;">Loại SP</th> -->
                                    </tr>
                                </thead>
                                <tbody style="overflow: scroll; height:50px;">
                              		  <c:forEach var="items" items="${ProductForm3.lst }" varStatus="status">
		                                <tr class="odd gradeX" >
		                                        <td style="text-align: center">
		                                        <input type="checkbox" ng-model="selected[${items.no}]"  ng-init ="selected[${items.no}]='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'">
		                                        </td>
		                                        <td align="center">${items.idSanPham}</td>
							                     <td>${items.tenSP}</td>
		                                      	 <td style="text-align: right">${items.giaMua }</td>
					                    		 <td style="text-align: right">${items.giaBan }</td>
		                                         <td>
		                                         	<form:input  maxlength="10" class="form-control" path="lst[${status.index}].giaBanKM"   ng-model = "lst[${status.index}].giaBanKM"  ng-init ="lst[${status.index}].giaBanKM = '${items.giaBanKM}'" />	
		                                         </td>
		                                         <%-- <td>${items.tenLoaiSP }</td> --%>
		                                         <%-- <td hidden="">${items.idLoaiSP }</td> --%>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                     </div>
            </div>
            <input type="hidden" ng-model="lstSize" ng-init="lstSize= '${fn:length(ProductForm3.lst)}'">
		</c:if>
		<c:if test="${empty ProductForm3.lst }">
			<div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
										<th style="width: 40px;padding-left: 2px;padding-right: 2px;font-size: 13px"></th>
										<th style="padding-left: 5px;padding-right: 4px;width: 90px;">Mã SP</th>
										<th style="width: 250px;padding-left: 4px;padding-right: 4px;">Tên sản phẩm</th>
										<th style="padding-left: 5px;width: 180px;padding-right: 4px;">Giá mua</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 180px;">Giá bán</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 220px;">Giá bán KM</th>
										<th style="padding-left: 5px;width: 150px;padding-right: 4px;">Loại SP</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		   <tr align="center"><td style="text-align: center" colspan="7"> Không tìm thấy dữ liệu. </td></tr>
                                </tbody>
                       </table>
             </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${ProductForm.flagUpdate}'" />
		<!-- <div class="row" align="center" style="width: 100%">
			<div >
				<input type="button" name="" class="btn btn-info " ng-click ="btnDangKy()" value="Đăng ký">
			</div>
		</div> -->
		
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<script src="/storeManagerSystem/view/js/chiTietDKM.js"></script>

<!-- /#wrapper -->