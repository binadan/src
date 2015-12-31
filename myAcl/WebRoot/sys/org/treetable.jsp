<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%String root=request.getContextPath();%>


<s:iterator value="children" status="rowstatus">
	<tr bgcolor="#f2f2f2">
		<td style="padding: 0;height: 32px;width: 32px;">
			<s:if test="#total==2 && children!=null && children.size()>0">
				<img alt="" src="<%=root%>/images/icon/line5.png">
			</s:if>
			<s:elseif test="#rowstatus.last==true && #total==2">
				<img alt="" src="<%=root%>/images/icon/line1.png">
			</s:elseif>
			
			<s:elseif test="#total==2">
				<img alt="" src="<%=root%>/images/icon/line2.png">
			</s:elseif>
			<s:elseif test="#rowstatus.last ">
				<img alt="" src="<%=root%>/images/icon/line3.png">
			</s:elseif>
			<s:else>
				<img alt="" src="<%=root%>/images/icon/line4.png">
			</s:else>
		</td>
		<td   >
			<s:property value="name"/>
		</td>
		<td ><s:property value="parent.name"/> </td>
		<td ><s:property value="code"/> </td>
		<td >
			<a onclick='addMsg(<s:property value="id"/>)'  class="add_acl">
				<img class="updateimg"  src="<%=root %>/images/icon/add.png" title="增加" />&nbsp;
			</a>
															
			<a onclick='updateMsg(<s:property value="id"/>)'  class="update_acl">
				<img class="updateimg"  src="<%=root %>/images/icon/edit.gif" title="修改" />&nbsp;
			</a>
												
			<a onclick='delOrg(<s:property value="id"/>)' class="delete_acl" >
				<img class="deleteimg"  src="<%=root %>/images/icon/dele.png" title="删除" />
		    </a>
		</td>
	</tr>
	<s:if test="children!=null">
		<s:set var ="total" value="#total+1"/><!-- 对list的值进行求和 -->
		<s:include value="treetable.jsp"></s:include>
	</s:if>
	<s:set var ="total" value="#total-1"/><!-- 对list的值进行求和 -->
</s:iterator>
