<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<script>document.write('<base href="' + document.location + '" />');</script>
    
<div id="wrapper">
	<!-- Navigation -->
	<div id="page-wrapper" ng-app="ProductForm" ng-controller="ctrl">
	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Sản phẩm</h1>
			</div>
<!-- 				<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i> -->
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	<form:form id="ProductForm" modelAttribute="ProductForm" role="form" method="POST" enctype="multipart/form-data" >
	<c:choose>
		<c:when test="${ProductForm.flagUpdate eq ('1')}">
		<div id="demo" class="collapse in">
		</c:when>
		<c:otherwise>
		<div id="demo" class="collapse">
		</c:otherwise>
		</c:choose>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Mã sản phẩm</label>
					<c:choose>
						<c:when test="${ProductForm.flagUpdate eq ('1')}">
							<form:input class="form-control" disabled="true" type="text" path="idSanPham"  name="idSanPham" ng-model = "idSanPham"  ng-init ="idSanPham = '${ProductForm.idSanPham}'" />
	   					</c:when>
	   					 <c:otherwise>
							<form:input class="form-control"  type="text" path="idSanPham"  name="idSanPham" ng-model = "idSanPham"  ng-init ="idSanPham = '${ProductForm.idSanPham}'" />
	   					 </c:otherwise> 
   					 </c:choose>
					<!--set so SEQ khi chinh sua  -->
					<form:input class="form-control" type="hidden" path="SEQ"  name="SEQ" />
					<p style="color: red;">{{idSanPham_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Tên sản phẩm</label> 
					<form:input maxlength="30" class="form-control" type="text" path="tenSP"  name="tenSP" ng-model = "tenSP"  ng-init ="tenSP = '${ProductForm.tenSP}'" />
					<p style="color: red;">{{tenSP_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Giá mua</label> 
					<form:input maxlength="10" class="form-control" type="text"  path="giaMua"  name="giaMua" ng-model ="giaMua" ng-init="giaMua='${ProductForm.giaMua}'"  />
					<p style="color: red;">{{giaMua_err}}</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>Giá bán</label> 
					<form:input maxlength="10" class="form-control" type="text"  path="giaBan"  name="giaBan" ng-model ="giaBan" ng-init="giaBan='${ProductForm.giaBan}'" />
					<p style="color: red;">{{giaBan_err}}</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Loại sản phẩm</label> 
					<form:select class="form-control" path="idLoaiSP">
					    <form:options items="${ProductForm.lstCategory}" />
					</form:select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
			        <label>Hình ảnh Sản phẩm</label>
			        <div class="form-group" >
                        <input type="file" name="file" onchange="readURL(this);" />
                        	</br>
                    </div>
			        <div class="form-group">
                        <img id="blah" src="#" />
                        <c:if test="${ProductForm.flagUpdate eq ('1')}">
                        	<img id="blahEdit" style="height: 400px;width: 300px;" src="/storeManagerSystem/myImage/${ProductForm.pathJSP}/imageDisplay/${ProductForm.SEQ }" alt="" />
						</c:if>
                    </div>
			        <!-- <label>Chi tiết 2</label>
			        <div class="form-group">
                        <input type="file" name="file_2"/>  
                    </div>
			        <label>Chi tiết 3</label>
			        <div class="form-group">
                        <input type="file" name="file_3"/>  
                    </div> --> 
    			</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<label>Mô tả </label>
					<div class="input-group">
					<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span><form:textarea  class="form-control"  rows="5"	 path="moTa"  name="moTa" ng-model ="moTa" ng-init="moTa='${ProductForm.moTa}'"  />
					</div> 
					<p style="color: red;">{{moTa_err}}</p>
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
					<p style="color: blue; font-weight: bold;">${ProductForm.message }</p>
					<p style="color: red; font-weight: bold;">${ProductForm.messageErr }</p>
				</div>
			</div>
		</div>
		<!--Message (E)-->
		<div class="row" align="right" style="width: 100%">
			<div >
				<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">
				  <i class="glyphicon glyphicon-plus"></i> Thêm
				</button>
				<!-- <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo" ng-click ="btnCreate()">
				  <i class="glyphicon glyphicon-plus"></i> Thêm
				</button> -->
				<!-- <button type="button" class="btn btn-info" ng-click="exportToExcel('#dataTables-example')">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button> -->
				<button type="button" class="btn btn-info" onclick="testExcel()">
				  <i class="glyphicon glyphicon-save-file"></i> Export Excel
				</button>
				<!-- <button type="button" class="btn btn-info" onclick="exportPDF();">
				  <i class="glyphicon glyphicon-print"></i> Export Pdf
				</button> -->
				<button type="button" class="btn btn-info" ng-click ="btnClear()">
				  <i class="glyphicon glyphicon-refresh"></i> Refesh
				</button>
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnCreate()" value="Thêm"> -->
				<!-- <input type="button" name="" class="btn btn-info " ng-click ="btnPhanAnh()" value="Phản ánh"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click="exportToExcel('#dataTables-example')" value="Export Excel"> -->
<!-- 				<input type="button" name="" class="btn btn-info " onclick="exportPDF();"  value="Export Pdf"> -->
<!-- 				<input type="button" name="" class="btn btn-info " ng-click ="btnClear()" value="Refesh"> -->
			</div>
		</div>
		
		<!-- <div class="row">
			<div class="col-sm-3" style="text-align: center">&nbsp</div>
		</div -->
		
		<c:if test="${!empty ProductForm.lst }">
		<div class="panel-body">
                            <table  width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead >
                                    <tr >
                                    	<!-- <th style="text-align: center; width: 5px;"></th> -->
                                        <th style="text-align: center; width: 10px;padding-left: 5px;padding-right: 4px; ">STT</th>
										<th style="text-align: center; width: 50px;padding-left: 5px;padding-right: 4px; ">Mã SP</th>
										<th style="text-align: center; width: 150px">Tên sản phẩm</th>
										<th style="text-align: center; width: 120px">Loại SP</th>
										<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Giá mua</th>
										<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Giá bán</th>
										<th style="text-align: center; width: 80px;padding-left: 5px;padding-right: 4px; ">Ngày tạo</th>
										<th style="text-align: center; width: 230px" data-tableexport-display="none" >Mô tả</th>
										<th style="text-align: center;	width: 60px" data-tableexport-display="none">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px" ng-model = "listSanPham" ng-init ="listSanPham = '${fn:length(ProductForm.lst)}'">
                              		  <c:forEach var="items" items="${ProductForm.lst }">
		                                <tr class="odd gradeX" >
		                                 		<%-- <td class="center" style="text-align: center"><input type="checkbox" ng-model="selected[${items.no}]"  ng-init ="selected[${items.no}]='false'" ng-true-value="'${items.SEQ }'" ng-false-value="'NO'"></td> --%>
		                                        <td style="text-align: center">${items.no}</td>
		                                        <td >${items.idSanPham}</td>
							                    <td data-tableexport-value="${items.tenSP}" >${items.tenSP}</td>
							                    <td>${items.tenLoaiSP }</td>
		                                      	<td style="text-align: right">${items.giaMua }</td>
					                    		<td style="text-align: right">${items.giaBan }</td>
		                                       	<td  style="text-align: center">${items.ngayTao}</td>
		                                        <td data-tableexport-display="none">${items.moTa }</td>
		                                        <td class="center" style="text-align: center" data-tableexport-display="none" >
		                                        		<button class="btn" type="button" ng-click="btnGetProductById('${items.SEQ}');">
															<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" ng-click="btnDelete('${items.idSanPham}');" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr>
					                </c:forEach>
                                </tbody>
                            </table>
                        </div>
		</c:if>
		<form:input class="form-control" type="hidden"  path="flagUpdate"  name="flagUpdate" ng-model ="flagUpdate" ng-init="flagUpdate='${ProductForm.flagUpdate}'" />
<%-- 	<ckeditor:replace replace="moTa" basePath="/ckeditor/" /> --%>
	</form:form>		
		<!-- /#page-wrapper -->
	</div>
</div>



<script src="/storeManagerSystem/view/exportPDF_2/Blob.js/Blob.js"></script>
<script src="/storeManagerSystem/view/exportPDF_2/FileSaver.js/FileSaver.js"></script>
<script src="/storeManagerSystem/view/exportPDF_2/jquery.tableexport.js"></script>

<script>
function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#blah')
                        .attr('src', e.target.result)
                        .width(300)
                        .height(400);
                };
                reader.readAsDataURL(input.files[0]);
                $('#blahEdit').remove();
            }
        }
// function exportPDF(){
// 	//PDF export using jsPDF only
// 	$('#dataTables-example').tableExport({
// 		fileName:'sanPham',
// 		type:'pdf',
// 		jspdf: {
// 	          orientation:  'p',
// 	          unit:         'pt',
// 	          format:       'a4',             // jspdf page format or 'bestfit' for autmatic paper format selection
// 	          margins:      {left: 20, right: 10, top: 10, bottom: 10},
// 	          onDocCreated: null,
// 	          autotable: {
// 	            styles: {
// 	              cellPadding: 2,
// 	              rowHeight:   12,
// 	              fontSize:    8,
// 	              fillColor:   255,           // color value or 'inherit' to use css background-color from html table
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
// 	              fillColor: 255
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
	fileName:'sanPham',
	type:'excel',
    excelFileFormat:'xmlss',
    worksheetName: ['Table 1','Table 2', 'Table 3']});
}
</script>



<script src="/storeManagerSystem/view/js/product.js"></script>
<!-- /#wrapper -->