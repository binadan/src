package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class admin_005ftop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("\r\n");
String root=request.getContextPath();
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title> 管理页面</title>\r\n");
      out.write("<meta http-equiv=Content-Type content=text/html;charset=gb2312>\r\n");
      out.write("<!-- 60刷新一次 -->\r\n");
      out.write("\r\n");
      out.write("<link href=\"images/skin.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<script language=JavaScript>\r\n");
      out.write("\tfunction logout(){\r\n");
      out.write("\t\tif (confirm(\"您确定要退出系统吗？\")){\r\n");
      out.write("\t\t\ttop.location = \"");
      out.print(root);
      out.write("/loginOut\";\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\twindow.parent.location.href=\"index.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<script language=JavaScript1.2>\r\n");
      out.write("function showsubmenu(sid) {\r\n");
      out.write("\tfunction showsubmenu(sid) {\r\n");
      out.write("\t\tvar whichEl = eval(\"submenu\" + sid);\r\n");
      out.write("\t\tvar menuTitle = eval(\"menuTitle\" + sid);\r\n");
      out.write("\t\tif (whichEl.style.display == \"none\"){\r\n");
      out.write("\t\t\teval(\"submenu\" + sid + \".style.display=\\\"\\\";\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\teval(\"submenu\" + sid + \".style.display=\\\"none\\\";\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<base target=\"main\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body leftmargin=\"0\" topmargin=\"0\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"panel pa-top\">\r\n");
      out.write("\t<div class=\"login_nav\" >欢迎你！<b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.sessionUser.person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</b> </div>\r\n");
      out.write("\t<ul class=\"main_menu\">\r\n");
      out.write("\t\t<li><a href=\"right.jsp\" target=\"main\"  class=\"home\">首页</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\" onclick=\"logout()\" class=\"logoout\">退出</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
