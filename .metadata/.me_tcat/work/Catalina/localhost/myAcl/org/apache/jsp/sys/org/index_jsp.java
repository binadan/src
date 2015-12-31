package org.apache.jsp.sys.org;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fstatus;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fif_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005finclude_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fstatus = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fif_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005finclude_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fstatus.release();
    _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fs_005fif_005ftest.release();
    _005fjspx_005ftagPool_005fs_005finclude_005fvalue_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\r\n");
      out.write("<title>团队列表</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/images/skin.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/css/css.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"");
      out.print(root );
      out.write("/css/pagecss.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link media=\"screen\" rel=\"stylesheet\" href=\"");
      out.print(root);
      out.write("/css/colorbox.css\" />\r\n");
      out.write("<script src=\"");
      out.print(root);
      out.write("/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(root);
      out.write("/js/SecurityFunctions.js\"></script>\r\n");
      out.write("<script type='text/javascript' src='");
      out.print(root);
      out.write("/js/jquery.contextmenu.r2-min.js'></script>\r\n");
      out.write("<script src=\"");
      out.print(root);
      out.write("/js/jquery.colorbox.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(root);
      out.write("/js/table.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(root );
      out.write("/tree/css/demo.css\" type=\"text/css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(root );
      out.write("/tree/css/zTreeStyle/zTreeStyle.css\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(root );
      out.write("/tree/js/jquery.ztree.core-3.5.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("</head>\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("//判断当前权限\r\n");
      out.write("$(document).ready(function(){ \r\n");
      out.write("\tvar userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.sessionUser.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(";\t\t//当前用户ID\r\n");
      out.write("\tvar resourceSn=\"groupmgr\";\t\t\t\t\t\t//当前模块SN\r\n");
      out.write("\t\t\r\n");
      out.write("\thasPermission(\"add_acl\",userId,resourceSn,");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write(");\r\n");
      out.write("\thasPermission(\"update_acl\",userId,resourceSn,");
      if (_jspx_meth_s_005fproperty_005f1(_jspx_page_context))
        return;
      out.write(");\r\n");
      out.write("\thasPermission(\"delete_acl\",userId,resourceSn,");
      if (_jspx_meth_s_005fproperty_005f2(_jspx_page_context))
        return;
      out.write(");\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type='text/javascript'>\r\n");
      out.write("\t\t<!--\r\n");
      out.write("\t\tvar setting = {\r\n");
      out.write("\t\t\tview: {\r\n");
      out.write("\t\t\t\tdblClickExpand: false\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdata: {\r\n");
      out.write("\t\t\t\tsimpleData: {\r\n");
      out.write("\t\t\t\t\tenable: true\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tcallback: {\r\n");
      out.write("\t\t\t\tbeforeClick: beforeClick,\r\n");
      out.write("\t\t\t\tonClick: onClick\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\tfunction beforeClick(treeId, treeNode) {\r\n");
      out.write("\t\t\t//var check = (treeNode && !treeNode.isParent);\r\n");
      out.write("\t\t\t//if (!check) alert(\"只能选择城市...\");\r\n");
      out.write("\t\t\t//去掉上面代码，以便可先父级\r\n");
      out.write("\t\t\tvar check=true;\r\n");
      out.write("\t\t\treturn check;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction onClick(e, treeId, treeNode) {\r\n");
      out.write("\t\t\tvar zTree = $.fn.zTree.getZTreeObj(\"treeDemo\"),\r\n");
      out.write("\t\t\tnodes = zTree.getSelectedNodes(),\r\n");
      out.write("\t\t\tv = \"\";\r\n");
      out.write("\t\t\tvar code=\"\";\r\n");
      out.write("\t\t\tnodes.sort(function compare(a,b){return a.id-b.id;});\r\n");
      out.write("\t\t\tfor (var i=0, l=nodes.length; i<l; i++) {\r\n");
      out.write("\t\t\t\tv += nodes[i].name + \",\";\r\n");
      out.write("\t\t\t\tcode+=nodes[i].code+\",\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (v.length > 0 ) v = v.substring(0, v.length-1);\r\n");
      out.write("\t\t\tif (code.length > 0 ) code = code.substring(0, code.length-1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction showMenu() {\r\n");
      out.write("\t\t\tvar cityObj = $(\"#citySel\");\r\n");
      out.write("\t\t\tvar cityOffset = $(\"#citySel\").offset();\r\n");
      out.write("\t\t\t$(\"#menuContent\").css({left:cityOffset.left + \"px\", top:cityOffset.top + cityObj.outerHeight() + \"px\"}).slideDown(\"fast\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(\"body\").bind(\"mousedown\", onBodyDown);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction hideMenu() {\r\n");
      out.write("\t\t\t$(\"#menuContent\").fadeOut(\"fast\");\r\n");
      out.write("\t\t\t$(\"body\").unbind(\"mousedown\", onBodyDown);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction onBodyDown(event) {\r\n");
      out.write("\t\t\tif (!(event.target.id == \"menuBtn\" || event.target.id == \"menuContent\" || $(event.target).parents(\"#menuContent\").length>0)) {\r\n");
      out.write("\t\t\t\thideMenu();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.post(\"searchOrgJson\",null,function(resultData){\r\n");
      out.write("\t\t\t\t$.fn.zTree.init($(\"#treeDemo\"), setting, resultData);\r\n");
      out.write("\t\t\t\t//全展开\r\n");
      out.write("\t\t\t\t$.fn.zTree.getZTreeObj(\"treeDemo\").expandAll(true);\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t//删除\r\n");
      out.write("\tfunction delOrg(id){\r\n");
      out.write("\t\t if(confirm(\"是否删除?\")){\r\n");
      out.write("\t\t\t$.post(\"delOrg?id=\"+id,null,function(resultData){\r\n");
      out.write("\t\t\t\tvar result =resultData;// eval(eval(\"(\"+resultData+\")\"));\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(result==\"SUCCESS\"){\r\n");
      out.write("\t\t\t\t\twindow.location.href=\"");
      out.print(root);
      out.write("/searchOrg\";\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(result);\r\n");
      out.write("\t\t\t\t}\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//修改\r\n");
      out.write("\tfunction updateMsg(id){\r\n");
      out.write("\t\t$.colorbox({href:'");
      out.print(root );
      out.write("/loadOrg?id='+id,width:'700px',height:'400px',iframe:true});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//添加\r\n");
      out.write("\tfunction addMsg(id){\r\n");
      out.write("\t\t$.colorbox({href:'");
      out.print(root );
      out.write("/addreadOrg?id='+id,width:'700px',height:'400px',iframe:true});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("    \t<td width=\"17\" height=\"29\" valign=\"top\" background=\"");
      out.print(root );
      out.write("/images/mail_leftbg.gif\">\r\n");
      out.write("    \t\t<img src=\"");
      out.print(root );
      out.write("/images/left-top-right.gif\" width=\"17\" height=\"29\" />\r\n");
      out.write("    \t</td>\r\n");
      out.write("    \t<td width=\"935\" height=\"29\" valign=\"top\" background=\"");
      out.print(root );
      out.write("/images/content-bg.gif\">\r\n");
      out.write("    \t\t<table width=\"100%\" height=\"31\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"left_topbg\" id=\"table2\">\r\n");
      out.write("      \t\t\t<tr>\r\n");
      out.write("        \t\t\t<td height=\"31\"><div class=\"titlebt\">部门</div></td>\r\n");
      out.write("      \t\t\t</tr>\r\n");
      out.write("    \t\t</table>\r\n");
      out.write("    \t</td>\r\n");
      out.write("    \t<td width=\"16\" valign=\"top\" background=\"");
      out.print(root );
      out.write("/images/mail_rightbg.gif\">\r\n");
      out.write("    \t\t<img src=\"");
      out.print(root );
      out.write("/images/nav-right-bg.gif\" width=\"16\" height=\"29\" />\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("    \t<td height=\"71\" valign=\"middle\" background=\"");
      out.print(root );
      out.write("/images/mail_leftbg.gif\">&nbsp;</td>\r\n");
      out.write("    \t<td valign=\"top\" bgcolor=\"#F7F8F9\">\r\n");
      out.write("    \t\t<table width=\"100%\" height=\"138\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("      \t\t\t<tr>\r\n");
      out.write("        \t\t\t<td height=\"13\" valign=\"top\">&nbsp;</td>\r\n");
      out.write("      \t\t\t</tr>\r\n");
      out.write("      \t\t\t<tr>\r\n");
      out.write("        \t\t\t<td valign=\"top\">\r\n");
      out.write("        \t\t\t\t<table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("          \t\t\t\t\t<tr>\r\n");
      out.write("            \t\t\t\t\t<td class=\"left_txt\">当前位置：部门管理&nbsp;\r\n");
      out.write("            \t\t\t\t\t</td>\r\n");
      out.write("          \t\t\t\t\t</tr>\r\n");
      out.write("          \t\t\t\t\t<tr>\r\n");
      out.write("            \t\t\t\t\t<td height=\"20\">\r\n");
      out.write("            \t\t\t\t\t\t<table width=\"100%\" height=\"1\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#CCCCCC\">\r\n");
      out.write("              \t\t\t\t\t\t\t<tr>\r\n");
      out.write("                \t\t\t\t\t\t\t<td></td>\r\n");
      out.write("              \t\t\t\t\t\t\t</tr>\r\n");
      out.write("            \t\t\t\t\t\t</table>\r\n");
      out.write("            \t\t\t\t\t</td>\r\n");
      out.write("          \t\t\t\t\t</tr>\r\n");
      out.write("          \t\t\t\t\t<tr>\r\n");
      out.write("            \t\t\t\t\t<td>\r\n");
      out.write("            \t\t\t\t\t\t<table width=\"100%\" height=\"55\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("              \t\t\t\t\t\t\t<tr>\r\n");
      out.write("                \t\t\t\t\t\t\t<td width=\"10%\" height=\"55\" >\r\n");
      out.write("                \t\t\t\t\t\t\t\t<div id=\"addbuttom\">\r\n");
      out.write("\t                \t\t\t\t\t\t\t\t<img src=\"");
      out.print(root );
      out.write("/images/icon/card.jpg\" width=\"54\" height=\"55\" title=\"列表\" />\r\n");
      out.write("                \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("                \t\t\t\t\t\t\t</td>\r\n");
      out.write("                \t\t\t\t\t\t\t<td width=\"90%\" valign=\"top\">\r\n");
      out.write("                \t\t\t\t\t\t\t\t<span class=\"left_txt2\">在这里,通过左边列表进行维护部门,右边区域进行预览</span>\r\n");
      out.write("                          \t\t\t\t\t\t\r\n");
      out.write("                          \t\t\t\t\t</td>\r\n");
      out.write("              \t\t\t\t\t\t\t</tr>\r\n");
      out.write("              \t\t\t\t\t\t\t\r\n");
      out.write("            \t\t\t\t\t\t</table>\r\n");
      out.write("            \t\t\t\t\t</td>\r\n");
      out.write("          \t\t\t\t\t</tr>\r\n");
      out.write("          \t\t\t\t\t<tr>\r\n");
      out.write("            \t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("          \t\t\t\t\t</tr>\r\n");
      out.write("          \t\t\t\t\t<tr>\r\n");
      out.write("            \t\t\t\t\t<td >\r\n");
      out.write("            \t\t\t\t\t<!-- 内容区开始 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div style=\"float: left;width: 700px;\">\r\n");
      out.write("\t            \t\t\t\t\t\t<table width=\"100%\" border=\"0\"  cellpadding=\"4\" cellspacing=\"1\" bgcolor=\"#464646\" class=\"newfont03\">\r\n");
      out.write("\t            \t\t\t\t\t\t\t<thead>\r\n");
      out.write("\t            \t\t\t\t\t\t\t\t<tr  class=\"CTitle\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t      \t<td  height=\"37\" width=\"28px\"><b>序号</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <td  height=\"37\" width=\"100px\"><B>名称</B></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <td  height=\"37\" width=\"100px\" ><b>父模块名称</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <td  height=\"37\" width=\"280px\" ><b>编码</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t            <td  height=\"37\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t            \t<b>操作</b>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t            \t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t            </td>\r\n");
      out.write("\t\t\t\t\t\t\t\t          \t\t</tr>\r\n");
      out.write("\t            \t\t\t\t\t\t\t</thead>\r\n");
      out.write("\t            \t\t\t\t\t\t\t");
      //  s:iterator
      org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fstatus.get(org.apache.struts2.views.jsp.IteratorTag.class);
      _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fiterator_005f0.setParent(null);
      // /sys/org/index.jsp(235,20) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fiterator_005f0.setValue("page.datas");
      // /sys/org/index.jsp(235,20) name = status type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fiterator_005f0.setStatus("rowstatus");
      int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_s_005fiterator_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("\t            \t\t\t\t\t\t\t\t");
          if (_jspx_meth_s_005fset_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write("<!-- 定义一个变量 -->\r\n");
          out.write("\t\t            \t\t\t\t\t\t\t<tr bgcolor=\"#B0C4DE\" class=\"left_txt\">\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t<td >\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t\t");
          if (_jspx_meth_s_005fproperty_005f3(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t               \t \t\t\t\t\t\t\t<td >\r\n");
          out.write("\t\t               \t \t\t\t\t\t\t\t\t");
          if (_jspx_meth_s_005fproperty_005f4(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t               \t \t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t<td >");
          if (_jspx_meth_s_005fproperty_005f5(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write(" </td>\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t<td >");
          if (_jspx_meth_s_005fproperty_005f6(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write(" </td>\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t<td >\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t\t<a onclick='addMsg(");
          if (_jspx_meth_s_005fproperty_005f7(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write(")' class=\"add_acl\">\r\n");
          out.write("\t\t\t                \t\t\t\t\t\t\t\t<img class=\"updateimg\"  src=\"");
          out.print(root );
          out.write("/images/icon/add.png\" title=\"增加\" />&nbsp;&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t\t<a onclick='updateMsg(");
          if (_jspx_meth_s_005fproperty_005f8(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write(")'  class=\"update_acl\">\r\n");
          out.write("\t\t\t                \t\t\t\t\t\t\t\t<img class=\"updateimg\"  src=\"");
          out.print(root );
          out.write("/images/icon/edit.gif\" title=\"修改\" />&nbsp;\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a onclick='delOrg(");
          if (_jspx_meth_s_005fproperty_005f9(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write(")' class=\"delete_acl\" >\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img class=\"deleteimg\"  src=\"");
          out.print(root );
          out.write("/images/icon/dele.png\" title=\"删除\" />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
          out.write("\t\t                \t\t\t\t\t\t\t</td>\r\n");
          out.write("\t\t              \t\t\t\t\t\t\t</tr>\r\n");
          out.write("\t\t              \t\t\t\t\t\t\t");
          if (_jspx_meth_s_005fif_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t            \t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fstatus.reuse(_jspx_th_s_005fiterator_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fs_005fiterator_005fvalue_005fstatus.reuse(_jspx_th_s_005fiterator_005f0);
      out.write("\r\n");
      out.write("\t            \t\t\t\t\t\t\t\r\n");
      out.write("\t            \t\t\t\t\t\t\t");
      if (_jspx_meth_s_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t            \t\t\t\t\t\t</table>\r\n");
      out.write("            \t\t\t\t\t\t</div>\r\n");
      out.write("            \t\t\t\t\t\t\r\n");
      out.write("            \t\t\t\t\t\t<div id=\"menuContent\" class=\"menuContent\" style=\" width: 200px;float: left; margin-left: 20px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<ul id=\"treeDemo\" class=\"ztree\" style=\"margin-top:0; width:160px;\"></ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("            \t\t\t\t\t<!-- 内容区结束 -->\t\r\n");
      out.write("            \t\t\t\t\t</td>\r\n");
      out.write("          \t\t\t\t\t</tr>\r\n");
      out.write("        \t\t\t\t</table>\r\n");
      out.write("          \t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("            \t\t\t\t<tr>\r\n");
      out.write("              \t\t\t\t\t<td height=\"30\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("            \t\t\t\t</tr>\r\n");
      out.write("          \t\t\t\t</table>\r\n");
      out.write("          \t\t\t</td>\r\n");
      out.write("      \t\t\t</tr>\r\n");
      out.write("    \t\t</table>\r\n");
      out.write("    \t</td>\r\n");
      out.write("    \t<td background=\"");
      out.print(root );
      out.write("/images/mail_rightbg.gif\">&nbsp;</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("    \t<td valign=\"middle\" background=\"");
      out.print(root );
      out.write("/images/mail_leftbg.gif\">\r\n");
      out.write("    \t\t<img src=\"");
      out.print(root );
      out.write("/images/buttom_left2.gif\" width=\"17\" height=\"17\" />\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t\t<td height=\"17\" valign=\"top\" background=\"");
      out.print(root );
      out.write("/images/buttom_bgs.gif\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(root );
      out.write("/images/buttom_bgs.gif\" width=\"17\" height=\"17\" />\r\n");
      out.write("\t\t</td>\r\n");
      out.write("    \t<td background=\"");
      out.print(root );
      out.write("/images/mail_rightbg.gif\">\r\n");
      out.write("    \t\t<img src=\"");
      out.print(root );
      out.write("/images/buttom_right2.gif\" width=\"16\" height=\"17\" />\r\n");
      out.write("    \t</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            \t\t\t\t\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_s_005fproperty_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent(null);
    // /sys/org/index.jsp(35,43) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("@com.gcflower.util.Permission@CREATE");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent(null);
    // /sys/org/index.jsp(36,46) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("@com.gcflower.util.Permission@UPDATE");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f2 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f2.setParent(null);
    // /sys/org/index.jsp(37,46) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f2.setValue("@com.gcflower.util.Permission@DELETE");
    int _jspx_eval_s_005fproperty_005f2 = _jspx_th_s_005fproperty_005f2.doStartTag();
    if (_jspx_th_s_005fproperty_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005fset_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:set
    org.apache.struts2.views.jsp.SetTag _jspx_th_s_005fset_005f0 = (org.apache.struts2.views.jsp.SetTag) _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.SetTag.class);
    _jspx_th_s_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fset_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(236,21) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fset_005f0.setVar("total");
    // /sys/org/index.jsp(236,21) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fset_005f0.setValue("1");
    int _jspx_eval_s_005fset_005f0 = _jspx_th_s_005fset_005f0.doStartTag();
    if (_jspx_th_s_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f3 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(239,26) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f3.setValue("#rowstatus.count+(page.page-1)*page.maxResults");
    int _jspx_eval_s_005fproperty_005f3 = _jspx_th_s_005fproperty_005f3.doStartTag();
    if (_jspx_th_s_005fproperty_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f4 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(242,27) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f4.setValue("name");
    int _jspx_eval_s_005fproperty_005f4 = _jspx_th_s_005fproperty_005f4.doStartTag();
    if (_jspx_th_s_005fproperty_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f4);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f5 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(244,30) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f5.setValue("parent.name");
    int _jspx_eval_s_005fproperty_005f5 = _jspx_th_s_005fproperty_005f5.doStartTag();
    if (_jspx_th_s_005fproperty_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f6 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(245,30) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f6.setValue("code");
    int _jspx_eval_s_005fproperty_005f6 = _jspx_th_s_005fproperty_005f6.doStartTag();
    if (_jspx_th_s_005fproperty_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f6);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f7 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f7.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(247,45) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f7.setValue("id");
    int _jspx_eval_s_005fproperty_005f7 = _jspx_th_s_005fproperty_005f7.doStartTag();
    if (_jspx_th_s_005fproperty_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f7);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f8 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f8.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(251,48) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f8.setValue("id");
    int _jspx_eval_s_005fproperty_005f8 = _jspx_th_s_005fproperty_005f8.doStartTag();
    if (_jspx_th_s_005fproperty_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f8);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f9 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f9.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(255,33) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f9.setValue("id");
    int _jspx_eval_s_005fproperty_005f9 = _jspx_th_s_005fproperty_005f9.doStartTag();
    if (_jspx_th_s_005fproperty_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f9);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f0 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /sys/org/index.jsp(261,23) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f0.setTest("children!=null");
    int _jspx_eval_s_005fif_005f0 = _jspx_th_s_005fif_005f0.doStartTag();
    if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t              \t\t\t\t\t\t\t\t");
        if (_jspx_meth_s_005fset_005f1(_jspx_th_s_005fif_005f0, _jspx_page_context))
          return true;
        out.write("<!-- 对list的值进行求和 -->\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
        if (_jspx_meth_s_005finclude_005f0(_jspx_th_s_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fset_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:set
    org.apache.struts2.views.jsp.SetTag _jspx_th_s_005fset_005f1 = (org.apache.struts2.views.jsp.SetTag) _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.SetTag.class);
    _jspx_th_s_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fset_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fif_005f0);
    // /sys/org/index.jsp(262,24) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fset_005f1.setVar("total");
    // /sys/org/index.jsp(262,24) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fset_005f1.setValue("#total+1");
    int _jspx_eval_s_005fset_005f1 = _jspx_th_s_005fset_005f1.doStartTag();
    if (_jspx_th_s_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fset_005fvar_005fvalue_005fnobody.reuse(_jspx_th_s_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005finclude_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fif_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:include
    org.apache.struts2.views.jsp.IncludeTag _jspx_th_s_005finclude_005f0 = (org.apache.struts2.views.jsp.IncludeTag) _005fjspx_005ftagPool_005fs_005finclude_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.IncludeTag.class);
    _jspx_th_s_005finclude_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005finclude_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fif_005f0);
    // /sys/org/index.jsp(263,13) name = value type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005finclude_005f0.setValue("treetable.jsp");
    int _jspx_eval_s_005finclude_005f0 = _jspx_th_s_005finclude_005f0.doStartTag();
    if (_jspx_th_s_005finclude_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005finclude_005fvalue_005fnobody.reuse(_jspx_th_s_005finclude_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005finclude_005fvalue_005fnobody.reuse(_jspx_th_s_005finclude_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:if
    org.apache.struts2.views.jsp.IfTag _jspx_th_s_005fif_005f1 = (org.apache.struts2.views.jsp.IfTag) _005fjspx_005ftagPool_005fs_005fif_005ftest.get(org.apache.struts2.views.jsp.IfTag.class);
    _jspx_th_s_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fif_005f1.setParent(null);
    // /sys/org/index.jsp(267,20) name = test type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fif_005f1.setTest("page.datas==null || page.datas.size<1");
    int _jspx_eval_s_005fif_005f1 = _jspx_th_s_005fif_005f1.doStartTag();
    if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fif_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fif_005f1.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t            \t\t\t\t\t\t\t\t<tr>\r\n");
        out.write("\t            \t\t\t\t\t\t\t\t\t<td colspan=\"13\" bgcolor=\"#f2f2f2\">没有相关记录</td>\r\n");
        out.write("\t            \t\t\t\t\t\t\t\t</tr>\r\n");
        out.write("\t            \t\t\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fif_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fif_005ftest.reuse(_jspx_th_s_005fif_005f1);
    return false;
  }
}
