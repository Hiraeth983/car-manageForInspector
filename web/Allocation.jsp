<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>机动车排放检验管理系统</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet"
    href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
  <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all">
  <style>
    /* Make the image fully responsive */
    .carousel-inner img {
      width: 100%;
      height: 100%;
    }
  </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
  <div class="wrapper">

    <!-- Preloader -->
    <div class="preloader flex-column justify-content-center align-items-center">
      <img class="animation__shake" src="dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
    </div>

    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
      <!-- Left navbar links -->
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="index.html" class="nav-link">首页</a>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="contact.html" class="nav-link">联系我们</a>
        </li>
      </ul>

      <!-- Right navbar links -->
      <ul class="navbar-nav ml-auto">
        <!-- Navbar Search -->
        <li class="nav-item">
          <a class="nav-link" data-widget="navbar-search" href="#" role="button">
            <i class="fas fa-search"></i>
          </a>
          <div class="navbar-search-block">
            <form class="form-inline">
              <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                  <button class="btn btn-navbar" type="submit">
                    <i class="fas fa-search"></i>
                  </button>
                  <button class="btn btn-navbar" type="button" data-widget="navbar-search">
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
            </form>
          </div>
        </li>

        <!-- Messages Dropdown Menu -->
        <li class="nav-item dropdown">
          <a class="nav-link" data-toggle="dropdown" href="#">
            <i class="far fa-comments"></i>
            <span class="badge badge-danger navbar-badge">3</span>
          </a>

        </li>
        <!-- Notifications Dropdown Menu -->
        <li class="nav-item dropdown">
          <a class="nav-link" data-toggle="dropdown" href="#">
            <i class="far fa-bell"></i>
            <span class="badge badge-warning navbar-badge">15</span>
          </a>

        </li>
        <li class="nav-item">
          <a class="nav-link" data-widget="fullscreen" href="#" role="button">
            <i class="fas fa-expand-arrows-alt"></i>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
            <i class="fas fa-th-large"></i>
          </a>
        </li>
      </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
      <!-- Brand Logo -->
      <a href="index3.html" class="brand-link">
        <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
          style="opacity: .8">
        <span class="brand-text font-weight-light">车辆排检管理系统</span>
      </a>

      <!-- Sidebar -->
      <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
          <div class="info">
            <a href="#" class="d-block">尊敬的<em>检测员</em>，您好！</a>
          </div>
        </div>

        <!-- SidebarSearch Form -->
        <div class="form-inline">
          <div class="input-group" data-widget="sidebar-search">
            <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
            <div class="input-group-append">
              <button class="btn btn-sidebar">
                <i class="fas fa-search fa-fw"></i>
              </button>
            </div>
          </div>
        </div>

        <!-- Sidebar Menu -->
        <nav class="mt-2">
          <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
            <li class="nav-item">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-th"></i>
                <p>
                  事务申请
                  <i class="fas fa-angle-left right"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="realTimeAlarm.html" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>申请任务调度</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="exception.html" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>更改申请信息</p>
                  </a>
                </li>
				<li class="nav-item">
				  <a href="exception.html" class="nav-link">
				    <i class="far fa-circle nav-icon"></i>
				    <p>撤销申请</p>
				  </a>
				</li>
              </ul>
            </li>
            <li class="nav-item menu-open">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-search"></i>
                <p>
                  查询信息
                  <i class="fas fa-angle-left right"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
                <li class="nav-item">
                  <a href="eventTypeSelect.html" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>查询评价</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="Allocation.jsp" class="nav-link active">
                    <i class="far fa-circle nav-icon"></i>
                    <p>任务分配</p>
                  </a>
                </li>
                <li class="nav-item">
                  <a href="dateSelect.html" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>个人检测记录</p>
                  </a>
                </li>
              </ul>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">
                <i class="nav-icon fas fa-cog"></i>
                <p>
                  信息上传
                  <i class="right fas fa-angle-left"></i>
                </p>
              </a>
              <ul class="nav nav-treeview">
				<li class="nav-item">
				  <a href="uploadresult.jsp" class="nav-link">
				    <i class="far fa-circle nav-icon"></i>
				    <p>上传检测结果</p>
				  </a>
				</li>
                <li class="nav-item">
                  <a href="uploadStaffInfo.jsp" class="nav-link">
                    <i class="far fa-circle nav-icon"></i>
                    <p>个人信息</p>
                  </a>
                </li>
              </ul>
            </li>
          </ul>
        </nav>
        <!-- /.sidebar-menu -->
      </div>
      <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <div class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-6">
              <h1 class="m-0">查询任务分配</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="#">首页</a></li>
                <li class="breadcrumb-item active">任务分配</li>
              </ol>
            </div><!-- /.col -->
          </div><!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>
      <!-- /.content-header -->





<!-- Main content -->
            <section class="content">
                <div class="container-fluid">
					<div class="col-md-6" style="margin-left: 40em;">
					    <div class="text-md-right dataTables_filter" id="dataTable_filter">
					        <form class="d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
					              action="queryStation" method="POST">
					            <div class="input-group"><input
					                    class="bg-light form-control form-control-sm border-0 small" type="text"
					                    placeholder="单号搜索" name="id">
					                <div class="input-group-append">
					                    <button class="btn btn-primary py-0" type="submit"><i
					                            class="fas fa-search"></i></button>
					                </div>
					            </div>
					        </form>
					    </div>
					</div>
					<table class="layui-hide" id="demo" lay-filter="test"></table>
                </div><!-- /.container-fluid -->
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <footer class="main-footer">
            <strong>Copyright &copy; 2021 <a href="#">ZJUT</a>.</strong>
            All rights reserved.
            <div class="float-right d-none d-sm-inline-block">
                <b>Version</b> 1.1.0
            </div>
        </footer>

        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Control sidebar content goes here -->
        </aside>
        <!-- /.control-sidebar -->
    </div>
    <!-- ./wrapper -->

    <!-- jQuery -->
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button)
    </script>
    <!-- Bootstrap 4 -->
    <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- ChartJS -->
    <script src="plugins/chart.js/Chart.min.js"></script>
    <!-- Sparkline -->
    <script src="plugins/sparklines/sparkline.js"></script>
    <!-- JQVMap -->
    <script src="plugins/jqvmap/jquery.vmap.min.js"></script>
    <script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
    <!-- jQuery Knob Chart -->
    <script src="plugins/jquery-knob/jquery.knob.min.js"></script>
    <!-- daterangepicker -->
    <script src="plugins/moment/moment.min.js"></script>
    <script src="plugins/daterangepicker/daterangepicker.js"></script>
    <!-- Tempusdominus Bootstrap 4 -->
    <script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
    <!-- Summernote -->
    <script src="plugins/summernote/summernote-bs4.min.js"></script>
    <!-- overlayScrollbars -->
    <script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/adminlte.js"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="dist/js/pages/dashboard.js"></script>
	<script src="plugins/layui/layui.js"></script>
	<script>
	layui.use('table', function(){
	  var table = layui.table;
	  
	  //第一个实例
	  table.render({
	    elem: '#demo'
	    ,height: 312
	    ,url: 'missionServlet.action' //数据接口
	    ,page: true //开启分页
	    ,cols: [[ //表头
	      {field: 'orderId', title: '单号', width:100, sort: true, fixed: 'left'}
	      ,{field: 'idcard', title: '身份证号', width:174}
	      ,{field: 'fullname', title: '姓名', width:174}
	      ,{field: 'carId', title: '车牌号', width:174}
	      ,{field: 'address', title: '站点地址', width: 174}
	      ,{field: 'orderTime', title: '预约时间', width: 174}
		  ,{
		      field: 'operation',
		      title: '操作',
		      fixed: 'right',
		      width: 80,
		      templet: '<div>' +
		          '<a class="col-2" data-toggle="modal" data-target="#C{{d.car_id}}"><i class="nav-icon far fa-edit" title="车辆详情"></i> </a>' +
		          '<div class="modal fade" id="C{{d.car_id}}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> <div class="modal-dialog"> <div class="modal-content"> <div class="modal-header"> <h4 class="modal-title text-left">车辆详情</h4> <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button> </div> <div class="modal-body"> <form class="form-horizontal" role="form" action="updateStation?id=${station.id}" method="post">  <div class="form-group row"> <label class="col-sm-4 control-label">站点编号</label> <div class="col-sm-8"> <input type="text" class="form-control" value="{{d.detection_id}}" name="detection_id" disabled=""> </div> </div> <div class="form-group row"> <label class="col-sm-4 control-label">检测线</label><div class="col-sm-8"><input type="text" class="form-control" value="{{d.test_line}}" name="test_line" disabled=""></div> </div> <div class="form-group row"> <label class="col-sm-4 control-label">图片</label><div class="col-sm-8"><input type="text" class="form-control" value="{{d.error_picture}}" name="car_color" disabled=""></div> </div> <div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">关闭</button></div></form></div></div></div>'
		  }
	    ]]
	  });
	  });
	</script>
</body>

</html>
