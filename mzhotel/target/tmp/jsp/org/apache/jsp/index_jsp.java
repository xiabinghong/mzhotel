package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"description\" content=\"12\">\r\n");
      out.write("    <meta name=\"author\" content=\"12\">\r\n");
      out.write("    <meta name=\"keyword\" content=\"12\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>XXXXXX</title>\r\n");
      out.write("    <!-- start: Css -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/bootstrap.min.css\">\r\n");
      out.write("    <!-- plugins -->\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/font-awesome.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/simple-line-icons.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/animate.min.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/plugins/fullcalendar.min.css\"/>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- end: Css -->\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("    html,body{height: 100%;}\r\n");
      out.write("</style>\r\n");
      out.write("<body id=\"mimin\" class=\"dashboard\">\r\n");
      out.write("<!-- start: Header -->\r\n");
      out.write("<nav class=\"navbar navbar-default header navbar-fixed-top\">\r\n");
      out.write("    <div class=\"col-md-12 nav-wrapper\">\r\n");
      out.write("        <div class=\"navbar-header\" style=\"width:100%;\">\r\n");
      out.write("            <div class=\"opener-left-menu is-open\"> <span class=\"top\"></span> <span class=\"middle\"></span> <span class=\"bottom\"></span> </div>\r\n");
      out.write("            <a href=\"index.html\" class=\"navbar-brand\"> <b>XXXXXX</b> </a>\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right user-nav\">\r\n");
      out.write("                <li class=\"user-name\"><span>张三</span></li>\r\n");
      out.write("                <li class=\"dropdown avatar-dropdown\"> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/avatar.jpg\" class=\"img-circle avatar\" alt=\"user name\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"true\"/>\r\n");
      out.write("                    <ul class=\"dropdown-menu user-dropdown\">\r\n");
      out.write("                        <li><a href=\"#\"><span class=\"fa fa-power-off\"></span> 退出登录</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("<!-- end: Header -->\r\n");
      out.write("<div class=\"container-fluid mimin-wrapper\" ng-app=\"indexApp\" ng-controller=\"indexController\">\r\n");
      out.write("    <!-- start:Left Menu -->\r\n");
      out.write("    <div id=\"left-menu\">\r\n");
      out.write("        <div class=\"sub-left-menu scroll\">\r\n");
      out.write("            <ul class=\"nav nav-list\">\r\n");
      out.write("                <li>\r\n");
      out.write("                    <div class=\"left-bg\"></div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"active ripple\"> <a class=\"tree-toggle nav-header\" ng-click=\"transPage('../mzhotel/shouye.jsp')\"><span class=\"fa-home fa\"></span> 首页 <span class=\"fa-angle-right fa right-arrow text-right\"></span> </a> </li>\r\n");
      out.write("                <li class=\"ripple\"> <a class=\"tree-toggle nav-header\"> <span class=\"fa-diamond fa\"></span> 仓库管理 <span class=\"fa-angle-right fa right-arrow text-right\"></span> </a>\r\n");
      out.write("                    <ul class=\"nav nav-list tree\">\r\n");
      out.write("                        <li><a href=\"javascript:void(0);\" ng-click=\"transPage('/mzhotel/jsp/storeManager/storeManagerList.jsp')\">列表</a></li>\r\n");
      out.write("                        <li><a href=\"javascript:void(0);\" ng-click=\"transPage('/mzhotel/jsp/storeManager/storeManagerEdit.jsp')\">编辑</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\" ripple\"> <a class=\"tree-toggle nav-header\"><span class=\"fa fa-check-square-o\"></span> 订台管理 <span class=\"fa-angle-right fa right-arrow text-right\"></span> </a> </li>\r\n");
      out.write("                <li class=\" ripple\"> <a class=\"tree-toggle nav-header\"><span class=\"fa fa-calendar-o\"></span> 宴会信息管理 <span class=\"fa-angle-right fa right-arrow text-right\"></span> </a>\r\n");
      out.write("                    <ul class=\"nav nav-list tree\">\r\n");
      out.write("                        <li><a href=\"javascript:void(0);\">宴会信息</a></li>\r\n");
      out.write("                        <li><a href=\"javascript:void(0);\">短信管理</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\" ripple\"> <a class=\"tree-toggle nav-header\"><span class=\"fa fa-sun-o\"></span> 系统设置 <span class=\"fa-angle-right fa right-arrow text-right\"></span> </a>\r\n");
      out.write("                    <ul class=\"nav nav-list tree\">\r\n");
      out.write("                        <li><a href=\"javascript:void(0);\">用户管理</a></li>\r\n");
      out.write("                        <li><a href=\"javascript:void(0);\">角色管理</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- end: Left Menu -->\r\n");
      out.write("\r\n");
      out.write("    <!-- start: content -->\r\n");
      out.write("    <div id=\"content\">\r\n");
      out.write("        <div class=\"panel\">\r\n");
      out.write("            <div class=\"panel-body\">\r\n");
      out.write("                <div class=\"col-md-6 col-sm-12\">\r\n");
      out.write("                    <h3 class=\"animated fadeInLeft\">欢迎您：张三</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-12\" style=\"position: absolute; width:88%; height:80%;padding: 20px;\">\r\n");
      out.write("            <iframe src=\"../mzhotel/shouye.jsp\" frameborder=\"0\" height=\"100%\" width=\"100%\" scrolling=\"yes\"></iframe>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- end: content -->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/html5shiv.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/respond.min.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<!-- start: Javascript -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/jquery.ui.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!-- plugins -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/plugins/jquery.nicescroll.js\"></script>\r\n");
      out.write("<!-- custom -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/main.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/tools/angularjs4.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/js/index.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
