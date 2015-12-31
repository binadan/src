package com.gcflower.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gcflower.entity.Tearm;
import com.gcflower.service.TearmService;
import com.gcflower.util.PageManager;

public class TearmAction extends BaseAction {
	protected Log log = LogFactory.getLog(TearmAction.class);
	private static final long serialVersionUID = 1L;

	private PageManager page=new PageManager(5);
	private TearmService tearmService;
	private Tearm data;
	private Integer id;
	private List<Tearm> list;
	private String msg;
	private int result;
	
	//默认访问
	public String searchOrg(){
		if(id==null){
			id=0;
		}
		this.tearmService.searchOrgs(id, page);
		return "index";
	}
	
	
	//获取所有组织机构JSON
	public String searchOrgJson(){
		list=this.tearmService.findRootOrg();
		
		return SUCCESS;
	}
	
	

	//到添加页
	public String addInput(){
		list=this.tearmService.findAll();
		return "add_input";
	}
	
	//添加
	public String add(){
		
		this.tearmService.merge(data);
		return "add_success";
	}

	//根据ID删除
	public String del(){
		try{
			msg=this.tearmService.delOrg(id);
		}catch (Exception e) {
			
		}
		
		return "pub_del_success";
	}

	
	//到修改页
	public String updateInput(){
		list=this.tearmService.findAll();
		data=this.tearmService.findById(id);
		return "update_input";
	}
	

	//修改
	public String update(){
		try{
			
			if(data.getParent().getId()==null || data.getParent().getId()==0){
				data.setParent(null);
			}
			this.tearmService.merge(data);
			result=1;
		}catch (Exception e) {
			result=0;
		}
		
		return "pub_update_success";
	}
	

	

	/***************************************************************************************
	 * 封装字段
	 */

	public TearmService getTearmService() {
		return tearmService;
	}


	public void setTearmService(TearmService tearmService) {
		this.tearmService = tearmService;
	}


	public Tearm getData() {
		return data;
	}

	public void setData(Tearm data) {
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




	public List<Tearm> getList() {
		return list;
	}


	public void setList(List<Tearm> list) {
		this.list = list;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}



}
