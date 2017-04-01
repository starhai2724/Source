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

    <%@include file="/WEB-INF/views/jsp/headerInclude.jsp" %>
    <title>SB Admin 2 - Bootstrap Admin Theme</title>


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
            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Người dùng</a>
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

  <div id="page-wrapper">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="page-header">Thông tin hệ thống</h1>
      </div>
      <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
      <div class="col-lg-12">
        <div class="panel panel-default">
          <div class="panel-heading">
            <i class="fa fa-bar-chart-o fa-fw"></i> Thông báo
            <div class="pull-right">
              <div class="btn-group">
                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                  Actions
                  <span class="caret"></span>
                </button>
                <ul class="dropdown-menu pull-right" role="menu">
                  <li><a href="#">Action</a>
                  </li>
                  <li><a href="#">Another action</a>
                  </li>
                  <li><a href="#">Something else here</a>
                  </li>
                  <li class="divider"></li>
                  <li><a href="#">Separated link</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <!-- /.panel-heading -->
          <div class="panel-body">
            <div class="row">
              <div class="col-lg-12">
                <div class="table-responsive">
                  <table class="table table-bordered table-hover table-striped">
                    <thead>
                    <tr>
                      <th>#</th>
                      <th>Date</th>
                      <th>Time</th>
                      <th>Amount</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                      <td>3326</td>
                      <td>10/21/2013</td>
                      <td>3:29 PM</td>
                      <td>$321.33</td>
                    </tr>
                    <tr>
                      <td>3325</td>
                      <td>10/21/2013</td>
                      <td>3:20 PM</td>
                      <td>$234.34</td>
                    </tr>
                    <tr>
                      <td>3324</td>
                      <td>10/21/2013</td>
                      <td>3:03 PM</td>
                      <td>$724.17</td>
                    </tr>
                    <tr>
                      <td>3323</td>
                      <td>10/21/2013</td>
                      <td>3:00 PM</td>
                      <td>$23.71</td>
                    </tr>
                    <tr>
                      <td>3322</td>
                      <td>10/21/2013</td>
                      <td>2:49 PM</td>
                      <td>$8345.23</td>
                    </tr>
                    <tr>
                      <td>3321</td>
                      <td>10/21/2013</td>
                      <td>2:23 PM</td>
                      <td>$245.12</td>
                    </tr>
                    <tr>
                      <td>3320</td>
                      <td>10/21/2013</td>
                      <td>2:15 PM</td>
                      <td>$5663.54</td>
                    </tr>
                    <tr>
                      <td>3319</td>
                      <td>10/21/2013</td>
                      <td>2:13 PM</td>
                      <td>$943.45</td>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <!-- /.table-responsive -->
              </div>
              <!-- /.col-lg-4 (nested) -->
            </div>
          </div>
        </div>
      </div>
  </div>
  <!-- /#page-wrapper -->

</div>
</div>
<!-- /#wrapper -->

	
    
    <%@include file="/WEB-INF/views/jsp/footerInclude.jsp" %>
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>

</body>

</html>
