package com.gcflower.action;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gcflower.entity.Module;
import com.gcflower.entity.Role;
import com.gcflower.service.AclService;
import com.gcflower.service.ModuleService;
import com.gcflower.service.RoleService;

public class AclAction extends BaseAction {
	protected Log log = LogFactory.getLog(AclAction.class);
	private static final long serialVersionUID = 1L;

	private AclService aclService;
	private RoleService roleService;
	private ModuleService moduleService;
	
	private Role role;
	private Integer id;
	private Integer principalId;
	private String principalType;
	
	private int userId;
	private String resourceSn;
	private int permission;
	private boolean result;
	private boolean ischeck;
	private int moduleId;
	
	private List<Module> modulelist;
	private List list;
	
	
	public String serachAcl(){
		
		/*
		if(Acl.TYPE_ROLE.equals(principalId)){
			role=roleService.findById(principalId);
		}else if(Acl.TYPE_USER.equals(principalType)){
			user=userService.findById(principalId);
		}else{
			//throw new SystemException("无效的主体类型！！");
			return ERROR;
		}
		*/
		//System.out.println("开始分配权限");	
		role=roleService.findById(principalId);
		modulelist=moduleService.searchRootModules();
		
		return "index";
	}

	
	/**
	 * @Title: addOrUpdatePermission
	 * @Description: TODO(修改/增加权限)
	 * @return 
	 * @return String    返回类型
	 * @throws
	 */
	public String addOrUpdatePermission(){
		try{
			this.aclService.addOrUpdatePermission(principalType, principalId, moduleId, permission, ischeck);
			result=true;
		}catch (Exception e) {
			result=false;
		}
		return "pub_per_AD";	
	}
	
	/**
	 * 获取当前权限
	 * @return
	 */
	public String searchAclRecord(){
		list=this.aclService.searchAclRecord(principalType, principalId);
		return SUCCESS;
	}
	
	
	/**
	 * 判断权限
	 * @return
	 */
	public String hasPermission(){
		result= aclService.hasPermissionByResourceSn(userId, resourceSn, permission);
		return SUCCESS;
	}
	
	
	//清除权限
	public String delPermission(){
		
		try{
			aclService.delPermission(principalType, principalId, moduleId);
			result=true;
		}catch (Exception e) {
			result=false;
		}
		
		return SUCCESS;
	}
	

	/******************************************************************************************************
	 * 封装字段
	 */
	
	public AclService getAclService() {
		return aclService;
	}
	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Integer principalId) {
		this.principalId = principalId;
	}

	public String getPrincipalType() {
		return principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}


	public String getResourceSn() {
		return resourceSn;
	}


	public void setResourceSn(String resourceSn) {
		this.resourceSn = resourceSn;
	}


	public boolean isResult() {
		return result;
	}


	public void setResult(boolean result) {
		this.result = result;
	}


	public List<Module> getModulelist() {
		return modulelist;
	}


	public void setModulelist(List<Module> modulelist) {
		this.modulelist = modulelist;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public boolean isIscheck() {
		return ischeck;
	}


	public void setIscheck(boolean ischeck) {
		this.ischeck = ischeck;
	}


	public int getModuleId() {
		return moduleId;
	}


	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	
}
