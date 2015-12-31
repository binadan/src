package com.gcflower.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gcflower.entity.Module;
import com.gcflower.service.ModuleService;
import com.gcflower.util.PageManager;

public class ModuleAction extends BaseAction {
	protected Log log = LogFactory.getLog(ModuleAction.class);
	private static final long serialVersionUID = 1L;

	private PageManager page=new PageManager(10);
	private ModuleService moduleService;
	private Module data;
	private Integer id;
	private int result;
	private String msg;

	
	/**
	 * 打开模块管理主界面
	 * @return
	 */
	public String searchModules(){
		
		if(id==null){
			id=0;
		}
		this.moduleService.searchModules(id, page);
		return "index";
	}
	
	/**
	 * 
	 * @Title: checkModuleSN
	 * @Description: TODO(检查SN是否重复)
	 * @return 
	 * @return String    返回类型
	 * @throws
	 */
	public String checkModuleSN(){
		result=this.moduleService.checkmoduleSN(data.getSn());
		return SUCCESS;
	}
	
	
	/**
	 * 
	 * @Title: checkModuleNum
	 * @Description: TODO(检查排序号是否重复)
	 * @return 
	 * @return String    返回类型
	 * @throws
	 */
	public String checkModuleNum(){
		result=this.moduleService.checkModuleNo(data.getOrderNo());
		return SUCCESS;
	}
	
	/**
	 * 打开模块管理录入界面
	 */
	public String addInput(){
		return "add_input";
	}

	
	/**
	 * 录入
	 * @return
	 */
	public String add(){
		try {
			if(id>0){
				data.setParent(new Module(id));
			}
			this.moduleService.merge(data);
			result=1;
		} catch (Exception e) {
			result=0;
		}
		
		return "pub_add_success";
	}
	
	
	/**
	 * 打开模块管理修改界面
	 * @return
	 */
	public String updateInput(){
		data=this.moduleService.findById(id);
		return "update_input";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		try{
			if(data.getParent().getId()==null){
				data.setParent(null);
			}
			this.moduleService.merge(data);
			result=1;
		}catch (Exception e) {
			result=0;
		}
		
		return "pub_update_success";
	}
	

	/**
	 * 删除模块信息
	 * @return
	 */
	public String del(){
		msg=this.moduleService.delModule(id);
		return "pub_del_success";
	}


	
	
	
	
	/*********************************************************************************
	 * 封装字段
	 */
	
	public ModuleService getModuleService() {
		return moduleService;
	}
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	public Module getData() {
		return data;
	}
	public void setData(Module data) {
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

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
