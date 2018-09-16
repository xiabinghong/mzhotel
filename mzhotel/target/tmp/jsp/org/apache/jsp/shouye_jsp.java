package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shouye_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"description\" content=\"12\">\r\n");
      out.write("    <meta name=\"author\" content=\"12\">\r\n");
      out.write("    <meta name=\"keyword\" content=\"12\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>明珠酒店仓库管理</title>\r\n");
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
      out.write("<body>\r\n");
      out.write("<div class=\"col-md-12 padding-0\">\r\n");
      out.write("    <div class=\"col-md-4\">\r\n");
      out.write("        <div class=\"col-md-12 padding-0\">\r\n");
      out.write("            <div class=\"panel box-v2\">\r\n");
      out.write("                <div class=\"panel-heading padding-0\"> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/bg2.jpg\" class=\"box-v2-cover img-responsive\"/>\r\n");
      out.write("                    <div class=\"box-v2-detail\"> <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/img/avatar.jpg\" class=\"img-responsive\"/>\r\n");
      out.write("                        <h4>xxxxx</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel-body\">\r\n");
      out.write("                    <div class=\"col-md-12 padding-0 text-center\">\r\n");
      out.write("                        <div class=\"col-md-4 col-sm-4 col-xs-6 padding-0\">\r\n");
      out.write("                            <h3>2000</h3>\r\n");
      out.write("                            <p>待处理</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-4 col-sm-4 col-xs-6 padding-0\">\r\n");
      out.write("                            <h3>1000</h3>\r\n");
      out.write("                            <p>已处理</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-4 col-sm-4 col-xs-6 padding-0\">\r\n");
      out.write("                            <h3>1000</h3>\r\n");
      out.write("                            <p>已过期</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"col-md-8 padding-0\">\r\n");
      out.write("        <div class=\"col-md-12 padding-0\">\r\n");
      out.write("            <div class=\"col-md-6\">\r\n");
      out.write("                <div class=\"panel box-v1\">\r\n");
      out.write("                    <div class=\"panel-heading bg-white border-none\">\r\n");
      out.write("                        <div class=\"col-md-6 col-sm-6 col-xs-6 text-left padding-0\">\r\n");
      out.write("                            <h4 class=\"text-left\">待办事项</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"col-md-6 col-sm-6 col-xs-6 text-right\">\r\n");
      out.write("                            <h4> <span class=\"icon-user icons icon text-right\"></span> </h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"panel-body text-center\">\r\n");
      out.write("                        <ul class=\"normal-list\">\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                            <li class=\"text-left\"><span class=\"right\">2017-11-18</span><a href=\"#\"><span class=\"fa fa-angle-right\"></span> 通知公告列表文字</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <p><a href=\"#\">更多信息</a></p>\r\n");
      out.write("                        <hr/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
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
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
