package com.gcflower.action;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gcflower.entity.Salesman;
import com.gcflower.service.SalesmanService;
import com.gcflower.util.PageManager;

public class SalesmanAction extends BaseAction {
	protected Log log = LogFactory.getLog(SalesmanAction.class);
	private static final long serialVersionUID = 1L;

	private PageManager page=new PageManager(10);
	private SalesmanService salesmanService;
	private Salesman data;
	private Integer id;
	private Integer result;
	private String code;
	private String msg;
	private String name="";
	private String ids;//id串
	/**
	 * 打开人员管理主界面
	 * orgId:0 查所有,机构ID
	 * @return
	 */
	public String searchPerson(){
	
		if(code==null){
			code="";
			
		}
		try {
			name=java.net.URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
		}
		this.salesmanService.searchPersons(code, page);
		return "index";
	}
	
	
	/**
	 * 打开用户管理主界面
	 * @return
	 */
	public String serarchUser(){
		
		if(code==null){
			code="";
		}
		this.salesmanService.searchPersons(code, page);
		return "index";
	}
	
	
	
	/**
	 * 打开人员管理录入界面
	 */
	public String addInput(){
		return "add_input";
	}

	
	/**
	 * 录入
	 * @return
	 */
	public String add(){
		try{
		
			this.salesmanService.merge(data);
			result=1;
		}catch (Exception e) {
			// TODO: handle exception
			result=0;
		}
		
		return "pub_add_success";
	}
	
	
	/**
	 * 打开人员管理修改界面
	 * @return
	 */
	public String updateInput(){
		try {
			data=this.salesmanService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update_input";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		try {
			this.salesmanService.merge(data);
			result=1;
		} catch (Exception e) {
			result=0;
		}
		//this.salesmanService.merge(data);
		return "pub_update_success";
	}
	

	/**
	 * 删除人员信息
	 * @return
	 */
	public String del(){
		try {
			msg=this.salesmanService.delete(id);
			result=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			result=0;
		}
		return "pub_del_success";
	}
	
	//批量删除
	public String deletePerAll(){
		System.out.println(ids);
		String str[]=ids.split(",");
		for(int i=0;i<str.length;i++){
			msg=this.salesmanService.delete(Integer.parseInt(str[i]));				
		}
		/*try{
			for(int i=0;i<str.length;i++){
				msg=this.salesmanService.delete(Integer.parseInt(str[i]));				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}*/
		return "pub_del_success";
	}


	
	
	
	/***************************************************************************************************
	 * 封装字段
	 */
	
	public SalesmanService getSalesmanService() {
		return salesmanService;
	}


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}


	public void setSalesmanService(SalesmanService salesmanService) {
		this.salesmanService = salesmanService;
	}


	public Salesman getData() {
		return data;
	}
	public void setData(Salesman data) {
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



	public Integer getResult() {
		return result;
	}



	public void setResult(Integer result) {
		this.result = result;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
