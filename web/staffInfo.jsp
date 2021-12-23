<%--
  Created by IntelliJ IDEA.
  User: 李龙
  Date: 2021/12/22
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page isELIgnored="false" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>员工信息</title>

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
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
                <a class="nav-link">首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a class="nav-link">联系我们</a>
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
                            <input class="form-control form-control-navbar" type="search" placeholder="Search"
                                   aria-label="Search">
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
                    <a href="#" class="d-block">尊敬的<strong>${staff.fullName}</strong>，您好！</a>
                </div>
            </div>

            <!-- SidebarSearch Form -->
            <div class="form-inline">
                <div class="input-group" data-widget="sidebar-search">
                    <input class="form-control form-control-sidebar" type="search" placeholder="Search"
                           aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-sidebar">
                            <i class="fas fa-search fa-fw"></i>
                        </button>
                    </div>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview"
                    role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
        with font-awesome or any other icon font library -->
                    <li class="nav-item menu-open">
                        <a href="stationInfo.jsp" class="nav-link active">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                检测站信息
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="manageStaff.jsp" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                员工信息管理
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="recordInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>
                                车辆检测记录
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="manageDetectionInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                                分配员工检测任务
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="examineApplication.jsp" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>
                                审核调度申请
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="countComplaintInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-chart-pie"></i>
                            <p>
                                统计评价信息
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="countDetectionInfo.jsp" class="nav-link">
                            <i class="nav-icon fas fa-calendar-alt"></i>
                            <p>
                                统计检测记录
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="examineComplaint.jsp" class="nav-link">
                            <i class="nav-icon fas fa-columns"></i>
                            <p>
                                审批车主投诉
                            </p>
                        </a>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>员工基本信息</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">员工基本信息</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">

                        <!-- Profile Image -->
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <div class="text-center">
                                    <img class="profile-user-img img-fluid img-circle"
                                         src="dist/img/pic.jpg"
                                         alt="User profile picture">
                                </div>

                                <h3 class="profile-username text-center" id="fullName"></h3>


                                <ul class="list-group list-group-unbordered mb-3">
                                    <li class="list-group-item">
                                        <b>站点编号</b> <a class="float-right" id="stationId"></a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>员工编号</b> <a class="float-right" id="staffId"></a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>总服务数</b> <a class="float-right" id="orderSum"></a>
                                    </li>
                                </ul>

                                <a class="btn btn-primary btn-block"><b>基本信息</b></a>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                    <div class="col-md-9">
                        <div class="card">
                            <div class="card-header p-2">
                                <ul class="nav nav-pills">

                                    <li class="nav-item"><a class="nav-link active" href="#settings"
                                                            data-toggle="tab">其他信息</a></li>
                                </ul>
                            </div><!-- /.card-header -->
                            <div class="card-body">
                                <div class="tab-content">

                                    <div class="active tab-pane" id="settings">
                                        <form class="form-horizontal">
                                            <div class="form-group row">
                                                <label for="staffId2" class="col-sm-2 col-form-label">员工编号</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="staffId2"
                                                           disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="password" class="col-sm-2 col-form-label">密码</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="password"
                                                           disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="fullName" class="col-sm-2 col-form-label">姓名</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="fullName2"
                                                           disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="avgScore"
                                                       class="col-sm-2 col-form-label">平均评分</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="avgScore"
                                                           disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="orderSum2"
                                                       class="col-sm-2 col-form-label">总服务数</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="orderSum2"
                                                           disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="stationId2"
                                                       class="col-sm-2 col-form-label">归属站号</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="stationId2"
                                                           disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="isAble"
                                                       class="col-sm-2 col-form-label">资格证有无</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="isAble"
                                                           disabled>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div><!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="float-right d-none d-sm-inline-block">
            <b>Version</b> 1.1.0
        </div>
        <strong>Copyright &copy; 2021 <a href="#">ZJUT</a>.</strong>
        All rights reserved.
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
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.js"></script>
<script type="text/javascript">
    let stationId = "${sessionScope.staff.stationId}";
    let staffId = "${sessionScope.staff.staffId}";
</script>
<script src="dist/js/pages/stationInfo.js"></script>
</body>
</html>


