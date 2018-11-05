<%--
  Created by IntelliJ IDEA.
  User: XBH
  Date: 2018/9/15
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript">
    var appname = '<%=request.getContextPath()%>';
    window.DataPermission = {
        permissions : eval('<%=request.getSession().getAttribute("UserPermissionsJSON")%>')
    }
</script>
<script src="${pageContext.request.contextPath}/sm/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/jquery.ui.min.js"></script>
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/sm/js/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/respond.min.js"></script>
<![endif]-->
<!-- start: Javascript -->
<script src="${pageContext.request.contextPath}/sm/js/tools/tether.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/tools/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/tools/sea.js"></script>
<!-- plugins -->
<script src="${pageContext.request.contextPath}/sm/js/plugins/jquery.nicescroll.js"></script>
<!-- custom -->
<script src="${pageContext.request.contextPath}/sm/js/main.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/tools/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/tools/angular-resource.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/tools/angular-animate.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/tools/ui-bootstrap-tpls.min.js"></script>
<script src="${pageContext.request.contextPath}/sm/js/app.inner.js"></script>
