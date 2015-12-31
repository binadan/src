package org.apache.jsp.sys.hostmanagement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
String root=request.getContextPath();
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("<title>添加主机信息</title>\r\n");
      out.write("<script src=\"");
      out.print(root);
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(root);
      out.write("/js/check.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/css/css.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t//增加\r\n");
      out.write("\tfunction addHostManagement(){\r\n");
      out.write("\t\tif (!isNumber($('#M_MANUAL').val())) {\r\n");
      out.write("\t\t\talert(\"主机编号必须是数字！\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($.trim($(\"#M_KEFUZHANGHAO\").val())==\"\"){\r\n");
      out.write("\t\t\talert(\"客服账号不能为空\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($.trim($(\"#M_KEFUNAME\").val())==\"\"){\r\n");
      out.write("\t\t\talert(\"客服姓名不能为空\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($.trim($(\"#M_KEFUTEL\").val())==\"\"){\r\n");
      out.write("\t\t\talert(\"客服电话不能为空\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif($.trim($(\"#M_MANUAL\").val())==\"\"){\r\n");
      out.write("\t\t\talert(\"主机编号不能为空\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif($.trim($(\"#houseId\").val())==\"\"){\r\n");
      out.write("\t\t\talert(\"房屋编号不能为空\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else {\r\n");
      out.write("\r\n");
      out.write("\t\t} \r\n");
      out.write("/* \t\telse{\r\n");
      out.write("\t\t\tif($.trim($(\"#houseId\").val()).length != 10){\r\n");
      out.write("\t\t\talert(\"请正确填写房屋编号\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\r\n");
      out.write("\t\tif($(\"#ipAddress\").val()==\"\"){\r\n");
      out.write("\t\t\talert(\"IP地址不能为空\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tvar re =/^(\\d{1,2}|1\\d\\d|2[1-4]\\d|25[1-5])\\.(\\d{1,2}|1\\d\\d|2[1-4]\\d|25[1-5])\\.(\\d{1,2}|1\\d\\d|2[1-4]\\d|25[1-5])\\.(\\d{1,2}|1\\d\\d|2[1-4]\\d|25[1-5])$/;\r\n");
      out.write("\t\t\t//alert(re.test($(\"#ipAddress\").val()));\r\n");
      out.write("\t\t\tif(re.test($(\"#ipAddress\").val())){\r\n");
      out.write("\t\t\t\t//alert(\"进来了\");\r\n");
      out.write("\t\t\t\t//return true;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"请输入正确的IP地址\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t}\r\n");
      out.write("        \r\n");
      out.write("\t\tvar id=parent.jQuery(\"#hid\").val();\r\n");
      out.write("\t\tvar data= $(\"#editForm\").serialize();\r\n");
      out.write("\t\t$.post(\"add?id=\"+id,data,function(resultData){\r\n");
      out.write("\t\t\tvar result =eval(eval(\"(\"+resultData+\")\"));\r\n");
      out.write("\t\t\t//alert(\"*****\");\r\n");
      out.write("\t\t\tif(result==1){\t\t\t\t\r\n");
      out.write("\t\t\t\twindow.parent.$.colorbox.close();\r\n");
      out.write("\t\t\t\tparent.location.reload();\r\n");
      out.write("\t\t\t}else if(result == 2){\r\n");
      out.write("\t\t\t alert(\"主机编号已存在\");\r\n");
      out.write("\t\t\t}/* else if(result == 3){\r\n");
      out.write("\t\t\t alert(\"客户账号已存在\");\r\n");
      out.write("\t\t\t} */\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\talert(\"添加失败，请重新添加或与管理员联系\");\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body >\r\n");
      out.write("\r\n");
      out.write("<form action=\"\" id=\"editForm\">\r\n");
      out.write("<!-- 这里加内容 start-->\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\" >\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"3\" style=\"text-align: center; height: 30px; background-color: #C9C9C9; font-size: 18px;\">添加主机信息</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t客服账号：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <input name=\"hostManagement.M_KEFUZHANGHAO\"   type=\"text\" id=\"M_KEFUZHANGHAO\" size=\"30\"  onBlur=\"M_KEFUZHANGHAOBlur()\"/>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"><font class=\"ERROR_No\" style=\"color: red;\"></font></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     \t<tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t客服姓名：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <input name=\"hostManagement.M_KEFUNAME\"   type=\"text\" id=\"M_KEFUNAME\" size=\"30\"  onBlur=\"M_KEFUNAMEBlur()\"/>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"><font class=\"ERROR_No\" style=\"color: red;\"></font></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     \t<tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t客服电话：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <input name=\"hostManagement.M_KEFUTEL\"   type=\"text\" id=\"M_KEFUTEL\" size=\"30\"  onBlur=\"M_KEFUTELBlur()\"/>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"><font class=\"ERROR_No\" style=\"color: red;\"></font></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t主机编号：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <input name=\"hostManagement.M_MANUAL\"   type=\"text\" id=\"M_MANUAL\" size=\"30\"  onBlur=\"M_MANUALBlur()\"/>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"><font class=\"ERROR_No\" style=\"color: red;\">*必须唯一</font></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t房屋编号：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <input name=\"hostManagement.M_HOUSEID\"   type=\"text\" id=\"houseId\" size=\"30\" />\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"><font class=\"ERROR_No\" style=\"color: red;\">*此为必填项</font></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t当前IP：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <input name=\"hostManagement.M_IP\" type=\"text\" id=\"ipAddress\" size=\"30\" />\r\n");
      out.write("            \r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"><font class=\"ERROR_No\" style=\"color: red;\">*此为必填项</font></td>\r\n");
      out.write("     </tr>\r\n");
      out.write("  <!--    <tr>\r\n");
      out.write("    \t<td width=\"20%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\" class=\"left_txt2\">\r\n");
      out.write("\t\t\t主机状态：\r\n");
      out.write("       \t</td>\r\n");
      out.write("        <td width=\"32%\" height=\"30\" bgcolor=\"#f2f2f2\">\r\n");
      out.write("            <select name=\"hostManagement.M_STATE\"  id=\"title\" />\r\n");
      out.write("            <option value=\"0\">&ndash; 选择状态 &ndash;</option>\r\n");
      out.write("            <option value=\"1\">布放</option>\r\n");
      out.write("            <option value=\"2\">撤防</option>\r\n");
      out.write("            \r\n");
      out.write("            </select>\r\n");
      out.write("        </td>\r\n");
      out.write("        <td width=\"45%\" height=\"30\" bgcolor=\"#f2f2f2\" class=\"left_txt\"></td>\r\n");
      out.write("     </tr>  -->\r\n");
      out.write("    \r\n");
      out.write("     <tr >\r\n");
      out.write("     \t<td colspan=\"3\" align=\"center\" style=\"padding-top:  50px;\">\r\n");
      out.write("     \t\t<input type=\"button\" value=\" 添 加 \"  onclick=\"addHostManagement()\"/>\r\n");
      out.write("     \t\t<input type=\"reset\" value=\" 重 置 \"/>\r\n");
      out.write("     \t</td>\r\n");
      out.write("     </tr>  \r\n");
      out.write("</table>   \r\n");
      out.write("</form>  \r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
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
