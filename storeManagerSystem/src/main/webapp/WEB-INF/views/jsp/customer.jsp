<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="KhachHangForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản lý khách hàng</h1>
			</div>
<!-- 			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i> -->
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="KhachHangForm" modelAttribute="KhachHangForm" role="form" method="GET" >
	<c:choose>
		<c:when test="${KhachHangForm.flagUpdate eq ('1')}">
		<div id="demo" class="collapse in">
		</c:when>
		<c:otherwise>
		<div id="demo" class="collapse">
		</c:otherwise>
		</c:choose>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên khách hàng</label> 
					<form:input maxlength="30" class="form-control" type="text" path="tenKhachHang"  name="tenKhachHang" ng-model = "tenKhachHang"  ng-init ="tenKhachHang = '${KhachHangForm.tenKhachHang}'" />
					<form:input class="form-control" type="hidden" path="idKhachHang"  name="idKhachHang" />
					<p style="color: red;">{{tenKhachHang_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Số điện thoại</label> 
					<form:input maxlength="12" class="form-control" type="text" path="soDienThoai"  name="soDienThoai" ng-model = "soDienThoai"  ng-init ="soDienThoai = '${KhachHangForm.soDienThoai}'" />
					<p style="color: red;">{{soDienThoai_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Giơi tính</label> 
					<form:select class="form-control" path="gioiTinh">
					    <form:options items="${KhachHangForm.lstGioiTinh}" />
					</form:select>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Loại thẻ</label> 
					<form:select class="form-control" path="loaiThe">
					    <form:options items="${KhachHangForm.lstCards}" />
					</form:select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Điểm tích lũy</label> 
					<form:input maxlength="10" class="form-control" type="text" path="soDiem"  name="soDiem" ng-model = "soDiem"  ng-init ="soDiem = '${KhachHangForm.soDiem}'" />
					<p style="color: red;">{{soDiem_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Địa chỉ</label> 
					<form:input maxlength="40" class="form-control" type="text" path="diaChi"  name="diaChi" ng-model = "diaChi"  ng-init ="diaChi = '${KhachHangForm.diaChi}'" />
					<p style="color: red;">{{diaChi_err}}</p>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Ngày sinh</label> 
					<form:input class="form-control" type="date" path="ngaySinh"  name="ngaySinh" />
					<p style="color: red;">{{ngaySinh_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<button type="button" class="btn btn-info"  ng-click ="btnCreate()">
				  <i class="glyphicon glyphicon-ok"></i> Đăng kí
				</button>
			</div>
		</div>
		</div>
		<!--Message (S)-->
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<p style="color: blue; font-weight: bold;">${KhachHangForm.message }</p>
					<p style="color: red; font-weight: bold;">${KhachHangForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div>
				<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">
				  <i class="glyphicon glyphicon-plus"></i> Thêm
				</button>
				<button type="button" class="btn btn-info" onclick="testExcel()">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<!-- <button type="button" class="btn btn-info" ng-click="exportToExcel('#dataTables-example')">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<button type="button" class="btn btn-info" onclick="exportPDF();">
				  <i class="glyphicon glyphicon-print"></i> Export Pdf
				</button> -->
				<button type="button" class="btn btn-info" ng-click ="btnClear()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
			
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Đăng kí"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="Export Excel"> -->
<!-- 				<input type="button" name="" class="btn btn-info " onclick="exportPDF();" value="Export PDF"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Refesh"> -->
			</div>
		</div>
		
		<!-- <div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div -->	
		
		<c:if test="${!empty KhachHangForm.lst }">
		<div class="panel-body" id ="tableToExport">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="padding-left: 5px;padding-right: 4px; width: 20px;">STT</th>
										<th style="text-align: center; width: 100px;">Tên khách hàng</th>
										<th style="text-align: center; width: 50px">SĐT</th>
										<th style="padding-left: 5px;padding-right: 4px; width: 50px">Giới tính</th>
										<th style="padding-left: 5px;padding-right: 4px;text-align: center; width: 60px">Ngày sinh</th>
										<th style="padding-left: -5px; width: 80px">Địa chỉ</th>
										<th style="text-align: center; width: 50px">Loại thẻ</th>
										<th style="padding-left: 5px;padding-right: 1px;width: 20px;text-align: center;">Điểm</th>
										<th style="text-align: center; width: 80px">Ngày tạo</th>
										<th style="text-align: center;	width: 60px" data-tableexport-display="none" >Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
                              		  <c:forEach var="items" items="${KhachHangForm.lst }">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">${items.no}</td>
		                                        <td>${items.tenKhachHang}</td>
							                     <td>${items.soDienThoai}</td>
							                     <td>${items.gioiTinh }</td>
		                                      	 <td style="text-align: center">${items.ngaySinh }</td>
					                    		 <td>${items.diaChi }</td>
		                                       	<td>${items.loaiThe}</td>
		                                        <td  style="text-align: right">${items.soDiem }</td>
		                                         <td style="text-align: center">${items.ngayTao }</td>
		                                        <td class="center" style="text-align: center" data-tableexport-display="none"  >
		                                        		<button class="btn" type="button" ng-click="btnGetById('${items.idKhachHang}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.idKhachHang}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${KhachHangForm.flagUpdate}'" />
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>
<!-- Export (S) -->
<script>
// function exportPDF(){
// 	//PDF export using jsPDF only
// 	$('#dataTables-example').tableExport({
// 		fileName:'sanPham',
// 		type:'pdf',
// 		jspdf: {
// 	          orientation:  'p',
// 	          unit:         'pt',
// 	          format:       'a3',             // jspdf page format or 'bestfit' for autmatic paper format selection
// 	          margins:      {left: 20, right: 10, top: 10, bottom: 10},
// 	          onDocCreated: null,
// 	          autotable: {
// 	            styles: {
// 	              cellPadding: 2,
// 	              rowHeight:   12,
// 	              fontSize:    8,
// 	              fillColor:   [94, 157, 200],           // color value or 'inherit' to use css background-color from html table
// 	              textColor:   50,            // color value or 'inherit' to use css color from html table
// 	              fontStyle:   'normal',      // normal, bold, italic, bolditalic or 'inherit' to use css font-weight and fonst-style from html table
// 	              overflow:    'ellipsize',   // visible, hidden, ellipsize or linebreak
// 	              halign:      'left',        // left, center, right
// 	              valign:      'middle'       // top, middle, bottom
// 	            },
// 	            headerStyles: {
// 	              fillColor: [94, 157, 200],
// 	              textColor: 255,
// 	              fontStyle: 'bold',
// 	              halign:    'center'
// 	            },
// 	            alternateRowStyles: {
// 	              fillColor: 245
// 	            },
// 	            autotable: false,
// 	            tableExport: {
// 	              doc:               null,    // jsPDF doc object. If set, an already created doc will be used to export to
// 	              onAfterAutotable:  null,
// 	              onBeforeAutotable: null,
// 	              onAutotableText:   null,
// 	              onTable:           null,
// 	              outputImages:      true
// 	            }
// 	          }
// 	        }
//    });
// } 


function testExcel(){
	$('#dataTables-example').tableExport({
		fileName:'khachHang',
		type:'excel',
	    excelFileFormat:'xmlss',
	    worksheetName: ['Table 1','Table 2', 'Table 3']});
	}
</script>

<script type="text/javascript" src="/storeManagerSystem/view/export/FileSaver/FileSaver.min.js"></script>  
<script type="text/javascript" src="/storeManagerSystem/view/export/jsPDF/jspdf.min.js"></script>
<script type="text/javascript" src="/storeManagerSystem/view/export/jsPDF-AutoTable/jspdf.plugin.autotable.js"></script>      
<script type="text/javascript" src="/storeManagerSystem/view/export/html2canvas/html2canvas.min.js"></script>
<script type="text/javascript" src="/storeManagerSystem/view/export/tableExport.js"></script>
<script src="/storeManagerSystem/view/export/app/jquery.base64.js"></script>
<script src="/storeManagerSystem/view/export/app/sprintf.js"></script>
<script src="/storeManagerSystem/view/export/app/base64.js"></script>
	

<!-- Export (E) -->
<script src="/storeManagerSystem/view/js/customer.js"></script>

<!-- /#wrapper -->