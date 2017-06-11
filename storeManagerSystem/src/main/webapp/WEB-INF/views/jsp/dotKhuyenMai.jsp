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
				<h1 class="page-header">Đợt Khuyến Mãi</h1>
			</div>
			<i style="font-size:24px;margin-left: 1500px;margin-top: -10px" data-toggle="collapse" data-target="#demo" class="fa">&#xf106;</i>
			<!-- /.col-lg-12 -->
		</div>
		<div id="demo" class="collapse in">
		<!-- /.row -->
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Mã đợt KM</label> 
						<input class="form-control" type="text" placeholder="Mã đợt KM"/>	
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Loại KM</label> 
					<select name="loaiKM" class="form-control">
						  <option value="volvo" >--- Chọn loại khuyến mãi ---</option>
						  <option value="volvo">Theo phần trăm sản hẩm</option>
						  <option value="saab">Theo phần trăm hóa đơn</option>
						  <option value="fiat">Tặng kèm sản phầm</option>
						  <option value="audi">Tặng phiếu giảm giá</option>
						  <option value="audi">Tặng phiếu quà tặng</option>
						  <option value="audi">Miễn phí ship hàng</option>
					</select>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label>Mức giảm giá</label> 
					<input class="form-control" type="text" placeholder="Mức" style="width: 100px"/>	
					<select name="mucGiamGiaKb" class="form-control" style="margin-left: 105px;width: 180px;margin-top: -35px">
						  <option value="volvo" >--- Chọn ---</option>
						  <option value="volvo"> % Hóa đơn</option>
						  <option value="saab"> % Sản phẩm</option>
						  <option value="fiat"> VNĐ</option>
						  <option value="audi"> Cái</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Tên đợt KM</label> 
						<input class="form-control" type="text" placeholder="Tên đợt KM" />	
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<label>-----------------------------</label> 
					<label>-----------------------------</label> 
					<label>-----------------------------</label> 
					<h4>Điều kiện để được nhận khuyến mãi</h4> 		
				</div>
			</div>
		</div>
		 <div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày bắt đầu KM</label> 
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
					<label style="margin-left: 50px">Loại Thẻ</label> 
					<select name="loaiThe" class="form-control" style="margin-left: 50px;width: 305px">
						  <option value="volvo" >--- Chọn loại thẻ ---</option>
						  <option value="volvo">Thẻ khách hàng</option>
						  <option value="saab">Thẻ thành viên</option>
						  <option value="fiat">Thẻ vàng</option>
						  <option value="audi">Thẻ VIP</option>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Ngày kết thúc KM</label> 
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
					<label style="margin-left: 50px">Tổng số lượng sản phẩm</label> 
					<input class="form-control" style="margin-left: 50px;width: 305px" placeholder="Tổng số lượng sản phẩm" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="form-group">
					<label>Trạng thái</label> 
					<select name="status" class="form-control">
						  <option value="volvo">--- Chọn loại trạng thái ---</option>
						  <option value="volvo">Hoạt động</option>
						  <option value="saab">Không họat động</option>
					</select>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="form-group">
					<label style="margin-left: 50px">Tổng hóa đơn</label> 
					<input class="form-control" style="margin-left: 50px;width: 305px" placeholder="Tổng hóa đơn" />
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
										<th style="width: 100px;">Mã đợt KM</th>
										<th style="width: 200px;padding-left: 4px;padding-right: 4px;">Tên đợt KM</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 80px;">Ngày bắt đầu</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 80px;">Ngày kết thúc</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 120px;">Loại khuyến mãi</th>
										<th style="padding-left: 5px;padding-right: 4px;width: 100px;">Mức giảm giá</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">ĐK_Loại thẻ</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">ĐK_Tổng HĐ</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">ĐK_Tổng SLSP</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">Trạng thái</th>
										<th style="padding-left: 10px;padding-right: 4px;width: 120px;">Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody style="overflow: auto; height:50px">
		                                <tr class="odd gradeX">
		                                        <td class="center" style="text-align: center">1</td>
		                                        <td>AHFGZ12093</td>
							                     <td>Khuyến mãi cuối năm</td>
							                     <td>2017/12/01 8.00-22.00</td>
		                                      	 <td class="center" style="text-align: center">2017/12/29 8.00-22.00</td>
					                    		 <td class="center">% Hóa đơn</td>
		                                       		<td>50%</td>
		                                        <td style="text-align: center">Thẻ VIP</td>
		                                         <td></td>
		                                        <td class="center" style="text-align: center"></td>
		                                        <td class="center" style="text-align: center">Không hoạt động</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" >
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
														</button>
		                                        </td>
		                                 </tr>
		                                 		<tr class="odd gradeX">
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
		                                        <td class="center" style="text-align: center">Hoạt động</td>
		                                        <td class="center" style="text-align: center">
		                                        		<button class="btn" type="button" >
														<span class="glyphicon glyphicon-pencil" data-toggle="tooltip" data-original-title="Sửa"></span>
														</button>
														<button class="btn" type="button" >
															<span class="glyphicon glyphicon-trash" data-toggle="tooltip" data-original-title="Xóa"></span>
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
