<%--
  Created by IntelliJ IDEA.
  User: XBH
  Date: 2018/9/12
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="12">
    <meta name="author" content="12">
    <meta name="keyword" content="12">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>明珠酒店仓库管理</title>
    <!-- start: Css -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sm/css/bootstrap.min.css">
    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sm/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sm/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sm/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/sm/css/plugins/fullcalendar.min.css"/>
    <link href="${pageContext.request.contextPath}/sm/css/style.css" rel="stylesheet">
    <!-- end: Css -->
</head>
<body>
<div class="col-md-12 padding-0">
    <div class="col-md-4">
        <div class="col-md-12 padding-0">
            <div class="panel box-v2">
                <div class="panel-heading padding-0"> <img src="${pageContext.request.contextPath}/sm/img/bg2.jpg" class="box-v2-cover img-responsive"/>
                    <div class="box-v2-detail"> <img src="${pageContext.request.contextPath}/sm/img/avatar.jpg" class="img-responsive"/>
                        <h4>xxxxx</h4>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="col-md-12 padding-0 text-center">
                        <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                            <h3>2000</h3>
                            <p>待处理</p>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                            <h3>1000</h3>
                            <p>已处理</p>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-6 padding-0">
                            <h3>1000</h3>
                            <p>已过期</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-8 padding-0">
        <div class="col-md-12 padding-0">
            <div class="col-md-6">
                <div class="panel box-v1">
                    <div class="panel-heading bg-white border-none">
                        <div class="col-md-6 col-sm-6 col-xs-6 text-left padding-0">
                            <h4 class="text-left">待办事项</h4>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-6 text-right">
                            <h4> <span class="icon-user icons icon text-right"></span> </h4>
                        </div>
                    </div>
                    <div class="panel-body text-center">
                        <ul class="normal-list">
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                            <li class="text-left"><span class="right">2017-11-18</span><a href="#"><span class="fa fa-angle-right"></span> 通知公告列表文字</a></li>
                        </ul>
                        <p><a href="#">更多信息</a></p>
                        <hr/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="sm/jsp/common/common.jsp"%>
</body>
</html>
