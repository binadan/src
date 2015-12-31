package com.gcflower.action;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gcflower.entity.Role;
import com.gcflower.service.RoleService;
import com.gcflower.util.PageManager;

public class RoleAction extends BaseAction {
	protected Log log = LogFactory.getLog(RoleAction.class);
	private static final long serialVersionUID = 1L;
	private PageManager page=new PageManager(5);
	private RoleService roleService;
	private Role data;
	private Integer id;
	private String name;
	private Integer result;
	private String msg;
	
	//默认访问
	public String searchRole(){
	
		this.roleService.searchRoles(page);
	
		return "index";
	}
	
	//打开添加界面
	public String addInput(){
		return "add_input";
	}

	//增加
	public String add(){
		try {
			roleService.add(data);
			result=1;
		} catch (Exception e) {
			result=0;
		}
		
		return "pub_add_success";
	}
	


	//删除
	public String del(){
		//roleService.delete(data);
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		msg= roleService.delete(id);
		return "pub_del_success";
	}

	
	/**
	 * 打开模块管理修改界面
	 * @return
	 */
	public String updateInput(){
		data=this.roleService.findById(id);
		return "update_input";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		try{
			this.roleService.merge(data);
			result=1;
		}catch (Exception e) {
			result=0;
		}
		
		return "pub_update_success";
	}
	
	
	//查询角色名
	public String checkRoleName(){
		
		try {
			name = java.net.URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
		}
		
		data=this.roleService.findByName(name);
		return SUCCESS;
	}
	

	/****************************************************************************************
	 *封装字段
	 */
	
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getData() {
		return data;
	}

	public void setData(Role data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PageManager getPage() {
		return page;
	}

	public void setPage(PageManager page) {
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
