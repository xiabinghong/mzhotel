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
<%@include file="/sm/jsp/common/header_inner.jsp"%>
<style>
    html,body{height: 100%;}
</style>
<body id="mimin" class="dashboard">
<!-- start: Header -->
<nav class="navbar navbar-default header navbar-fixed-top">
    <div class="col-md-12 nav-wrapper">
        <div class="navbar-header" style="width:100%;">
            <div class="opener-left-menu is-open"> <span class="top"></span> <span class="middle"></span> <span class="bottom"></span> </div>
            <a href="index.html" class="navbar-brand"> <b>明珠酒店后台管理</b> </a>
            <ul class="nav navbar-nav navbar-right user-nav">
                <li class="user-name"><span><%=request.getSession().getAttribute("username")%> </span></li>
                <li class="dropdown avatar-dropdown"> <img src="${pageContext.request.contextPath}/sm/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
                    <ul class="dropdown-menu user-dropdown">
                        <li><a href="<%=request.getContextPath()%>/login.jsp"><span class="fa fa-power-off"></span> 退出登录</a></li>
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
                <shiro:hasPermission name="USER_MANAGER:ENUM:VIEW">
                    <li class="active ripple"> <a class="tree-toggle nav-header" ng-click="transPage('/mzhotel/sm/jsp/user/userList.jsp')"><span class="fa-home fa"></span> 用户管理 </a> </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="STORE_MANAGER:ENUM:VIEW">
                    <li class="ripple"> <a class="tree-toggle nav-header"> <span class="fa-diamond fa"></span> 仓库管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                        <ul class="nav nav-list tree">
                            <shiro:hasPermission name="STORE_INFO:ENUM:VIEW">
                                <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/sm/jsp/storeManager/storeManagerList.jsp')">仓库信息</a></li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="DINNER_MANAGER:ENUM:VIEW">
                    <li class=" ripple"> <a class="tree-toggle nav-header"><span class="fa fa-check-square-o"></span> 订台管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                        <ul class="nav nav-list tree">
                            <shiro:hasPermission name="DINNER_INFO:ENUM:VIEW">
                                <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/sm/jsp/personalReservation/personalManagerList.jsp')">订台信息</a></li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="PARTY_MANAGER:ENUM:VIEW">
                    <li class=" ripple"> <a class="tree-toggle nav-header"><span class="fa fa-calendar-o"></span> 宴会信息管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                        <ul class="nav nav-list tree">
                            <shiro:hasPermission name="PARTY_INFO:ENUM:VIEW">
                                <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/sm/jsp/dinnerParty/dinnerManagerList.jsp')">宴会信息</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="MESSAGE_MANAGER:ENUM:VIEW">
                                <li><a href="javascript:void(0);">短信管理 </a> </li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasPermission>
                <shiro:hasPermission name="SYSTEM_MANAGER:ENUM:VIEW">
                    <li class=" ripple"> <a class="tree-toggle nav-header"><span class="fa fa-gears"></span> 系统管理 <span class="fa-angle-right fa right-arrow text-right"></span> </a>
                        <ul class="nav nav-list tree">
                            <shiro:hasPermission name="ROLE_MANAGER:ENUM:VIEW">
                                <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/sm/jsp/role/roleList.jsp')">角色管理</a></li>
                            </shiro:hasPermission>
                            <shiro:hasPermission name="RSOURCE_MANAGER:ENUM:VIEW">
                                <li><a href="javascript:void(0);" ng-click="transPage('/mzhotel/sm/jsp/resource/resourceList.jsp')">资源管理</a></li>
                            </shiro:hasPermission>
                        </ul>
                    </li>
                </shiro:hasPermission>
            </ul>
        </div>
    </div>
    <!-- end: Left Menu -->

    <!-- start: content -->
    <div id="content">
        <%--<div class="panel">
            <div class="panel-body">
                <div class="col-md-6 col-sm-12">
                    <h3 class="animated fadeInLeft">欢迎您：张三</h3>
                </div>
            </div>
        </div>--%>
        <div class="col-md-12" style="position: absolute; width:88%; height:80%;padding: 20px;">
            <iframe src="/mzhotel/sm/jsp/user/userList.jsp" frameborder="0" height="100%" width="100%" scrolling="yes"></iframe>
        </div>
    </div>
    <!-- end: content -->

</div>
<%@include file="sm/jsp/common/common.jsp"%>
<script src="${pageContext.request.contextPath}/sm/js/index.js"></script>
</body>
</html>