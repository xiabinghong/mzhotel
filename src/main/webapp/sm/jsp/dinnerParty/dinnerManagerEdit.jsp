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
    <div ng-app="dinnerPartyEditApp" ng-controller="dinnerPartyEditController" style="align-content: left;">
        <div class="form-element">
            <div class="col-md-12 padding-0">
                <form>
                <div class="col-md-12">
                    <div class="panel form-element-padding">
                        <div class="panel-heading">
                            <h4>宴会详情</h4>
                        </div>
                        <div class="panel-body" style="padding-bottom:10px;">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">类别</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.dinnerPartyType">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">用户</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.dinnerPartyUser">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">联系方式</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.tel">
                                    </div>
                                    <%--<div class="col-sm-4">
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">物品类型</button>
                                    </div>--%>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-1 control-label text-right">消费项目</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.consumptionItem">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">备注</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-disabled="pageSetting.disabled" ng-model="dinnerParty.remark">
                                    </div>
                                </div>

                                </div>
                                <%--<div class="form-group">
                                    <label class="col-sm-1 control-label text-right">名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-model="dinnerParty.area">
                                    </div>
                                    <label class="col-sm-1 control-label text-right">名称</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" ng-model="dinnerParty.area">
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
                        <input ng-show="pageSetting.disabled" ng-click="edit();" class="btn btn-success" type="button" value="修改">
                        <input ng-show="!pageSetting.disabled" ng-click="save();" class="btn btn-success" type="button" value="保存">
                        <input ng-show="!pageSetting.disabled" ng-click="cancel();" class="btn btn-danger" type="button" value="取消">
                        <input ng-click="close();" class="btn btn-warning" type="button" value="关闭">
                    </div>
                </div>
                </form>
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
<script src="${pageContext.request.contextPath}/js/tools/bootstrap.js"></script>
<!-- plugins -->
<script src="${pageContext.request.contextPath}/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${pageContext.request.contextPath}/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/js/tools/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/tools/angular-resource.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/tools/angular-animate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/tools/ui-bootstrap-tpls.min.js"></script>
<script src="${pageContext.request.contextPath}/js/storeManager/storeManagerEdit.js"></script>
</body>
</html>
