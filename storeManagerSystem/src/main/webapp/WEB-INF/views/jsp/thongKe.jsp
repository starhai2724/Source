<%@page import="java.util.List"%>
<%@page import="com.sms.form.ThongKeTheoQuyForm"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
var data_2 = [];
var a; 
<%
List<ThongKeTheoQuyForm> thongKeTheoQuyForms = (List<ThongKeTheoQuyForm>)session.getAttribute("ThongKeTheoQuyForm");
System.out.println("Size: "+thongKeTheoQuyForms.size());
for(ThongKeTheoQuyForm thongKeTheoQuyForm : thongKeTheoQuyForms){
%>
 a = new Object();
 a.period = '<%=thongKeTheoQuyForm.getNam()%>';
 a.DoanhThu = '<%=thongKeTheoQuyForm.getTongDoanhThu()%>';
 data_2.push(a);
<%}
%>


$(document).ready(function () {
	$(function() {
	    Morris.Area({
	        element: 'morris-area-chart',
	        data : data_2,
	        xkey: 'period',
	        ykeys: ['DoanhThu'],
	        labels: ['DoanhThu'],
	        pointSize: 2,
	        hideHover: 'auto',
	        resize: true
	    });
	    
// 	    {
// 	        period: '2010 Q1',
// 	        iphone: 5000000,
// 	    }, {
// 	        period: '2010 Q2',
// 	        iphone: 1500000,
// 	    }, {
// 	        period: '2010 Q3',
// 	        iphone: 2000000,
// 	    }, {
// 	        period: '2010 Q4',
// 	        iphone: 3000000,
// 	    }, {
// 	        period: '2011 Q1',
// 	        iphone: 4000000,
// 	    }, {
// 	        period: '2011 Q2',
// 	        iphone: 4500000,
// 	    }, {
// 	        period: '2011 Q3',
// 	        iphone: 4820,
// 	    }, {
// 	        period: '2011 Q4',
// 	        iphone: 15073,
// 	    }, {
// 	        period: '2012 Q1',
// 	        iphone: 10687,
// 	    }, {
// 	        period: '2012 Q2',
// 	        iphone: 1111,
// 	    }, {
// 	        period: '2012 Q3',
// 	        iphone: 1111111,
// 	    }   

// 	    Morris.Donut({
// 	        element: 'morris-donut-chart',
// 	        data: [{
// 	            label: "Thời trang Nam",
// 	            value: 12
// 	        }, {
// 	            label: "Thời trang Nữ",
// 	            value: 30
// 	        }, {
// 	            label: "Thời trang Trẻ Em",
// 	            value: 20
// 	        }],
// 	        resize: true
// 	    });

// 	    Morris.Bar({
// 	        element: 'morris-bar-chart',
// 	        data: [{
// 	            y: '2006',
// 	            a: 100,
// 	            b: 90
// 	        }, {
// 	            y: '2007',
// 	            a: 75,
// 	            b: 65
// 	        }, {
// 	            y: '2008',
// 	            a: 50,
// 	            b: 40
// 	        }, {
// 	            y: '2009',
// 	            a: 75,
// 	            b: 65
// 	        }, {
// 	            y: '2010',
// 	            a: 50,
// 	            b: 40
// 	        }, {
// 	            y: '2011',
// 	            a: 75,
// 	            b: 65
// 	        }, {
// 	            y: '2012',
// 	            a: 100,
// 	            b: 90
// 	        }],
// 	        xkey: 'y',
// 	        ykeys: ['a', 'b'],
// 	        labels: ['Series A', 'Series B'],
// 	        hideHover: 'auto',
// 	        resize: true
// 	    });
	    
	});	  
});
</script>
<div id="page-wrapper" ng-app="ThongKeForm" ng-controller="ctrl">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thống kê</h1>
			</div>
			<i style="font-size:24px;margin-left: 1400px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->	
		</div>
<form:form id="ThongKeForm" modelAttribute="ThongKeForm" role="form" method="POST" >
    <div id="wrapper">
 <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ThongKeForm.tongLuotTheoDoi_trongNgay }</div>
                                    <div>Số lượt theo dỏi trong ngày</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-tasks fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ThongKeForm.tongDoanhThu_trongNgay }</div>
                                    <div>Tổng doanh thu trong ngày</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-shopping-cart fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ThongKeForm.tongGiaoDich_trongNgay }</div>
                                    <div>Tổng số giao dịch</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-support fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${ThongKeForm.tongSoThanhVienMoi_trongNgay }</div>
                                    <div>Số thành viên mới</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Biểu đồ thống kê doanh thu theo quy
                            <div class="pull-right ">
                                <div class="form-group">
                                	<label>Bắt đầu</label>
                              		<%-- <form:input type="text" name="" placeholder="Quý" path="quyBD" ng-init="quyBD = '${ThongKeForm.quyBD }'" ng-model = "quyBD"  class="btn btn-xs" style="border-style: solid;width: 50px" /> --%>
                              		<form:input type="text" maxlength="4"  placeholder="Năm" path="namBD" ng-init="namBD = '${ThongKeForm.namBD }'" ng-model = "namBD" class="btn btn-xs" style="border-style: solid;width: 50px" />
                              		<label style="margin-left: 20px">Kết thúc</label>
                              		<%-- <form:input type="text" name="" placeholder="Quý" path="quyKT" ng-init="quyKT = '${ThongKeForm.quyKT }'" ng-model = "quyKT"  class="btn btn-xs" style="border-style: solid;width: 50px" /> --%>
                              		<form:input type="text" maxlength="4" placeholder="Năm" path="namKT" ng-init="namKT = '${ThongKeForm.namKT }'" ng-model = "namKT"  class="btn btn-xs" style="border-style: solid;width: 50px" />
                              		<input type="button"  class="btn btn-primary btn-xs" ng-click ="btnThongKeBieuDo()" value="Thống kế">
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="morris-area-chart"></div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    <!-- <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Thống kê loại sản phẩm được bán chạy
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            <div class="row">
                        <div class="panel-body">
                            <div id="morris-donut-chart"></div>
                        </div>
                            </div>
                            /.row
                        </div>
                        /.panel-body
                    </div> -->
                    <!-- /.panel -->
                    
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bell fa-fw"></i> Thống kê chi tiết
                             <div class="pull-right">
                                <div class="btn-group">
                              		<input type="button" name="" class="btn btn-primary btn-xs" ng-click ="btnNgay()" value="Ngày">
                              		<input type="button" name="" class="btn btn-primary btn-xs" ng-click ="btnThang()" value="Tháng">
                              		<input type="button" name="" class="btn btn-primary btn-xs" ng-click ="btnNam()" value="Năm">
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group">
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-comment fa-fw"></i> Tổng lượt theo dỏi
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.luotTheoDoi_chiTiet } lượt</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-envelope fa-fw"></i> Tổng doanh thu 
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.doanhThu_chiTiet } VNĐ</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-bolt fa-fw"></i> Tổng sản phẩm được bán ra
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.sanPhamDuocBanRa_chiTiet } sản phẩm</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-money fa-fw"></i> Tổng số giao dịch
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.giaoDich_chiTiet } giao dịch</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-tasks fa-fw"></i> Tổng số thành viên
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.tongThanhVien_chiTiet } thành viên</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-upload fa-fw"></i> Tổng sản phẩm mới
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.tongSPMoi_chiTiet } sản phẩm</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-warning fa-fw"></i> Tổng số nhóm sản phẩm
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.tongNhomSP_chiTiet } nhóm</em>
                                    </span>
                                </a>
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-shopping-cart fa-fw"></i> Tổng số loại sản phẩm
                                    <span class="pull-right text-muted small"><em>${ThongKeForm.tongLoaiSP_chiTiet } loại</em>
                                    </span>
                                </a>
                            </div>
                            <!-- /.list-group -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
                <!-- /.col-lg-4 -->
            </div>

    </div>
    <!-- /#wrapper -->
</form:form>	
<script src="/storeManagerSystem/view/js/thongKe.js"></script>
</div>