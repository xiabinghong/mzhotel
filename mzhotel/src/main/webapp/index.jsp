<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="description" content="12">
    <meta name="author" content="12">
    <meta name="keyword" content="12">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>XXXXXX</title>
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/fullcalendar.min.css"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <!-- end: Css -->
</head>
<style>
    html,body{height: 100%;}
</style>
<body id="mimin" class="dashboard">
<!-- start: Header -->
<nav class="navbar navbar-default header navbar-fixed-top">
    <div class="col-md-12 nav-wrapper">
        <div class="navbar-header" style="width:100%;">
            <div class="opener-left-menu is-open"> <span class="top"></span> <span class="middle"></span> <span class="bottom"></span> </div>
            <a href="index.html" class="navbar-brand"> <b>XXXXXX</b> </a>
            <ul class="nav navbar-nav navbar-right user-nav">
                <li class="user-name"><span>张三</span></li>
                <li class="dropdown avatar-dropdown"> <img src="${pageContext.request.contextPath}/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                    <ul class="dropdown-menu user-dropdown">
                        <li><a href="#"><span class="fa fa-power-off"></span> 退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- end: Header -->
<div class="container-fluid mimin-wrapper" ng-app="indexApp" ng-controller="indexController">
    <!-- start:Left Menu -->
    <div id="left-menu">
        <div class="sub-left-menu scroll">
            <ul class="nav nav-list">
                <li>
                    <div class="left-bg"></div>
                </li>
                <li class="active ripple"> <a class="tree-toggle nav-header" ng-click="transPage('../mzhotel/shouye.jsp')"><span class="fa-home fa"></span> 首页 <span class="fa-angle-right fa right-arrow text-right"></span> </a> </li>
                <li class="ripple"> <a class="tree-toggle nav-header"> <span class="fa-diamond fa"></span> 仓库管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree">
                        <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/jsp/storeManager/storeManagerList.jsp')">列表</a></li>
                        <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/jsp/storeManager/storeManagerEdit.jsp')">编辑</a></li>
                    </ul>
                </li>
                <li class=" ripple"> <a class="tree-toggle nav-header"><span class="fa fa-check-square-o"></span> 订台管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a> </li>
                <li class=" ripple"> <a class="tree-toggle nav-header"><span class="fa fa-calendar-o"></span> 宴会信息管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree">
                        <li><a href="javascript:void(0);">宴会信息</a></li>
                        <li><a href="javascript:void(0);">短信管理</a></li>
                    </ul>
                </li>
                <li class=" ripple"> <a class="tree-toggle nav-header"><span class="fa fa-sun-o"></span> 系统设置 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                    <ul class="nav nav-list tree">
                        <li><a href="javascript:void(0);">用户管理</a></li>
                        <li><a href="javascript:void(0);">角色管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!-- end: Left Menu -->

    <!-- start: content -->
    <div id="content">
        <div class="panel">
            <div class="panel-body">
                <div class="col-md-6 col-sm-12">
                    <h3 class="animated fadeInLeft">欢迎您：张三</h3>
                </div>
            </div>
        </div>
        <div class="col-md-12" style="position: absolute; width:88%; height:80%;padding: 20px;">
            <iframe src="../mzhotel/shouye.jsp" frameborder="0" height="100%" width="100%" scrolling="yes"></iframe>
        </div>
    </div>
    <!-- end: content -->

</div>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/js/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/js/respond.min.js"></script>
<![endif]-->
<!-- start: Javascript -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- plugins -->
<script src="${pageContext.request.contextPath}/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/tools/angularjs4.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>