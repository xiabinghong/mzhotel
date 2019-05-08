
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/sm/assets/css/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/sm/assets/css/supersized.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/sm/assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="page-container" ng-controller="loginEditController">
    <h1>Login</h1>
    <form>
        <input type="text"  name="userId" ng-model="user.userId" class="username" placeholder="Username" >
        <input input type="password" name="password" ng-model="user.password" class="password" placeholder="Password">
        <button type="text" ng-click="loging();">Sign me in</button>
        <div class="error"><span>+</span></div>
    </form>

</div>

<!-- Javascript -->
<script src="<%=request.getContextPath()%>/sm/assets/js/jquery-1.8.2.min.js"></script>
<script src="<%=request.getContextPath()%>/sm/assets/js/supersized.3.2.7.min.js"></script>
<script src="<%=request.getContextPath()%>/sm/assets/js/supersized-init.js"></script>
<script src="<%=request.getContextPath()%>/sm/assets/js/scripts.js"></script>

</body>

</html>

<%@include file="sm/jsp/common/common.jsp" %>
<script type="text/javascript">
    seajs.use('/mzhotel/sm/js/login');
</script>