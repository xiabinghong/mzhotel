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
<body>
<div ng-app="storeManagerApp" ng-controller="storeManagerController">
    <div class="col-md-12 padding-0 form-element">
        <div class="col-md-12">
            <div class="panel form-element-padding">
                <div style="padding-bottom:20px;">
                    <div class="form-group">
                        <label class="col-sm-1 control-label text-right">物品类别</label>
                        <div class="col-sm-2">
                            <select class="form-control" ng-model="query.goodsType">
                                <option>option one</option>
                                <option>option two</option>
                                <option>option three</option>
                                <option>option four</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label text-right" ng-model="query.goodsName">物品名称</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control">
                        </div>
                        <div class="col-sm-2">
                            <input class="btn btn-info" type="button" ng-click="init();" value="搜索">
                            <input class="btn btn-danger" type="button" ng-click="reset()" value="重置">
                        </div>
                    </div>
                </div>
            </div>
            <div class="panel">
                <div align="right" style="padding-top: 10px;">
                    <input class="btn btn-info" type="button" ng-click="add();" value="新增">
                    <input class="btn btn-info" type="button" ng-click="view();" value="查看">
                    <input class="btn btn-info" type="button" ng-click="delete()" value="删除">
                    <input class="btn btn-info" type="button" ng-click="export()" value="导出">
                    <input class="btn btn-info" type="button" ng-click="innerStore()" value="入库">
                    <input class="btn btn-info" type="button" ng-click="outStore()" value="出库">
                    <input class="btn btn-info" type="button" ng-click="storeLog()" value="出入库记录">
                </div>
                <div class="panel-body">
                    <div class="responsive-table">
                        <div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div>
                                <div class="col-sm-12">
                                    <table cellspacing="0" style="width: 100%;">
                                        <tr align="center">
                                            <td>序号</td>
                                            <td>所属区域</td>
                                            <td>所属房间</td>
                                            <td>物品类型</td>
                                            <td>物品名称</td>
                                            <td>图片</td>
                                            <td>数量</td>
                                            <td>创建人</td>
                                            <td>创建时间</td>
                                            <td>修改人</td>
                                            <td>修改时间</td>
                                        </tr>
                                        <tr align="center" ng-show="storehouseList" ng-repeat="list in storehouseManagerList">
                                            <td ng-bind="#index"></td>
                                            <td ng-bind="list.area"></td>
                                            <td ng-bind="list.room"></td>
                                            <td ng-bind="list.goodsType"></td>
                                            <td ng-bind="list.goodsName"></td>
                                            <td ng-bind="list.img"></td>
                                            <td ng-bind="list.amount"></td>
                                            <td ng-bind="list.createdByName"></td>
                                            <td ng-bind="list.createdDate"><td>
                                            <td ng-bind="list.updatedByName"></td>
                                            <td ng-bind="list.updateByDate"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
<script src="${pageContext.request.contextPath}/js/storeManager/storeManagerList.js"></script>
</body>
</html>
