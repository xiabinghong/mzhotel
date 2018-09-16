<%--
  Created by IntelliJ IDEA.
  User: In The Future
  Date: 2018/6/5
  Time: 18:23
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- plugins -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/simple-line-icons.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins/fullcalendar.min.css"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <!-- end: Css -->
</head>
<body>
    <div ng-app="storehouseEditApp" ng-controller="storehouseEditController" style="align-content: left;">
        <div class="form-element">
            <div class="col-md-12 padding-0">
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>基本表单</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">区域</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.ng-disabled" ng-model="storehouse.area">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">房间</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.ng-disabled" ng-model="storehouse.room">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">物品类型</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.ng-disabled" ng-model="storehouse.goodsType">
                                    </div>
                                    <%--<div class="col-sm-4">
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">物品类型</button>
                                    </div>--%>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">物品名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-ng-disabled="pageSetting.ng-disabled" ng-model="storehouse.goodsName">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">数量</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.ng-disabled" ng-model="storehouse.amount">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">描述</label>
                                    <div class="col-sm-11">
                                        <input type="text" maxlength="300" class="form-control" ng-disabled="pageSetting.ng-disabled" ng-model="storehouse.remark">
                                    </div>
                                </div>
                                <%--<div class="form-group">
                                    <label class="col-sm-1 control-label text-right">名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-model="storehouse.area">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-model="storehouse.area">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">名称</label>
                                    <div class="col-sm-3">
                                        <select class="form-control">
                                            <option>option one</option>
                                            <option>option two</option>
                                            <option>option three</option>
                                            <option>option four</option>
                                        </select>
                                    </div>
                                </div>--%>
                                <%--<div class="form-group">
                                    <label class="col-sm-1 control-label text-right">名称</label>
                                    <div class="col-sm-11">
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">单选</label>
                                    <div class="col-sm-11">
                                        <div class="col-sm-1 padding-0">
                                            <input type="radio" name="option">
                                            条件一 </div>
                                        <div class="col-sm-1 padding-0">
                                            <input type="radio" name="option">
                                            条件二 </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">复选</label>
                                    <div class="col-sm-11">
                                        <div class="col-sm-1 padding-0">
                                            <input type="checkbox" name="option">
                                            条件一 </div>
                                        <div class="col-sm-1 padding-0">
                                            <input type="checkbox" name="option">
                                            条件二 </div>
                                    </div>
                                </div>--%>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center" style="margin:20px;">
                        <input ng-click="save();" class="btn btn-success" type="button" value="保存">
                        <input ng-click="cancel();" class="btn btn-danger" type="button" value="取消">
                        <input ng-click="close();" class="btn btn-warning" type="button" value="关闭">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end: content -->

    <!--弹出复选-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog form-element">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">选择商品类型</h4>
                </div>
                <div class="modal-body form-element-padding">
                    <div class="form-group">
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件二 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件二 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件二 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                        <div class="col-sm-3 padding-0">
                            <input type="checkbox" name="option">
                            条件一 </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">提交更改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
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
<script src="${pageContext.request.contextPath}/js/storeManager/storeManagerEdit.js"></script>
</body>
</html>
