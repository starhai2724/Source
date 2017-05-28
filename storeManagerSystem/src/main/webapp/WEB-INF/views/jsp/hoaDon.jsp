<!--  header (S)-->
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ page contentType="text/html; charset=UTF-8"%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
    <title>Hệ thống bán hàng</title>
    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
</head>
<body>
<div id="wrapper">
  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">Quản lý</a>
    </div>
    <!-- /.navbar-header -->
    <ul class="nav navbar-top-links navbar-right">
      <!-- /.dropdown -->
      <!-- /.dropdown -->
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
          <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="#"><i class="fa fa-gear fa-fw"></i> Cài đặt</a>
          </li>
          <li class="divider"></li>
          <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Đăng xuất</a>
          </li>
        </ul>
        <!-- /.dropdown-user -->
      </li>
      <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
      <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
          <li>
            <a href="/storeManagerSystem/storeOwnerList"><i class="fa fa-dashboard fa-fw"></i> Người dùng</a>
          </li>
          <li>
            <a href="index.html"><i class="fa fa-wrench fa-fw"></i> Cấu hình trang web</a>
          </li>
          <li>
            <a href="index.html"><i class="fa fa-bar-chart-o fa-fw"></i> Thống kế</a>
          </li>
        </ul>
      </div>
      <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
  </nav>
<!--  header (E)-->
   


	<!-- Navigation -->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Quản trị hóa đơn</h1>
			</div>
			<i style="font-size:24px;margin-left: 1500px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Mã hóa đơn</label> 
						<input class="form-control" type="text" placeholder="Mã hóa đơn"/>	
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại thanh toán</label> 
					<select name="loaiKM" class="form-control">
						  <option value="volvo" >--- Chọn loại thanh toán ---</option>
						  <option value="volvo">Thanh toán trực tiếp</option>
						  <option value="saab">Thanh toán qua ATM</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label >Tổng số lượng sản phẩm</label> 
					<input class="form-control" placeholder="Tổng số lượng sản phẩm" />
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label >Mã khách hàng</label> 
					<input class="form-control"  placeholder="Mã khách hàng" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tổng tiền khuyến mãi</label> 
					<input class="form-control" type="text"  placeholder="Tổng tiền khuyến mãi" />
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label >Điểm tích lũy lần này</label> 
					<input class="form-control"  placeholder="Điểm tích lũy lần này" />
				</div>
			</div>
		</div> 
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tổng tiền</label> 
					<input class="form-control"  placeholder="Tổng tiền" />
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label >Tổng điểm tích lũy</label> 
					<input class="form-control"  placeholder="Tổng điểm tích lũy" />
				</div>
			</div>
		</div> 
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày lập</label> 
							<div class='input-group date' id='datetimepicker1'>
	                   				 <input type='text' class="form-control" />
	                    			<span class="input-group-addon">
	                       			 <span class="glyphicon glyphicon-calendar"></span>
	                   				 </span>
	                		</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
				<div class="form-group">
					<label>Trạng thái</label> 
					<select name="status" class="form-control">
						  <option value="volvo">--- Chọn loại trạng thái ---</option>
						  <option value="volvo">Hoạt động</option>
						  <option value="saab">Không họat động</option>
					</select>
				</div>
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
		<div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th style="width: 40px;padding-left: 2px;padding-right: 2px;font-size: 13px">STT</th>
										<th style="width: 100px;">Mã hóa đon</th>
										<th style="width: 70px;padding-left: 4px;padding-right: 4px;">Tổng SLSP</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 80px;">Tổng tiền KM</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 80px;">Ngày lập</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 120px;">Tổng tiền</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">Thanh toán</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">Khách hàng</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 50px;">Điểm</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 70px;">Tổng điểm</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">Trạng thái</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 110px;">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">1</td>
		                                        <td>AHFGZ12093</td>
							                     <td>5</td>
							                     <td>200,000</td>
		                                      	 <td class="center" style="text-align: center">2017/12/29</td>
					                    		 <td class="center">1,200,000</td>
		                                       	 <td>Trực tiếp</td>
		                                         <td style="text-align: center">Ngọc Thư</td>
		                                         <td style="text-align: center">10</td>
		                                         <td style="text-align: center">420</td>
		                                        <td class="center" style="text-align: center">Không hoạt động</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" >
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Chi tiết"></span>
														</button>
		                                        </td>
		                                 </tr>
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">2</td>
		                                        <td>AHFGZ12093</td>
							                     <td>5</td>
							                     <td>200,000</td>
		                                      	 <td class="center" style="text-align: center">2017/12/29</td>
					                    		 <td class="center">1,200,000</td>
		                                       	 <td>Trực tiếp</td>
		                                         <td style="text-align: center">Ngọc Thư</td>
		                                         <td style="text-align: center">10</td>
		                                         <td style="text-align: center">420</td>
		                                        <td class="center" style="text-align: center">Không hoạt động</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" >
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="fa fa-list-alt" data-toggle="tooltip" data-original-title="Chi tiết"></span>
														</button>
		                                        </td>
		                                 </tr>
                                </tbody>
                            </table>
                        </div>
                        
          <!-- Detail (E) -->
	</div>
</div>
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
<!-- /#wrapper -->
