package com.gcflower.action;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gcflower.entity.HostManagement;
import com.gcflower.entity.Household;
import com.gcflower.entity.Module;
import com.gcflower.service.HostManagementService;
import com.gcflower.service.HouseholdService;
import com.gcflower.util.PageManager;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 住户信息action
 * 
 * Description:com.gcflower.action.HouseholdAction.java
 *
 * @author 屈碧勃
 *
 */
public class HouseholdAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 自定义log
	 */
	protected Log log = LogFactory.getLog(HouseholdAction.class);

	private Household household;//住户信息实体类
	
	private HostManagement hostManagement;

	private HostManagementService hostManagementService;
	
	private HouseholdService householdService;//住户信息service

	private List<Household> listH;//住户信息集合list

	private PageManager page = new PageManager(10);//分页
	
	private String msg;//接收
	
	private Integer HId;//住户id
	
	private Integer id;//住户id
	private String HNo;//房屋编号

	public String getHNo() {
		return HNo;
	}
	public void setHNo(String hNo) {
		HNo = hNo;
	}
	private int result;	
	
	private String ids;//id串
	
	private String condition;
	
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public HostManagement getHostManagement() {
		return hostManagement;
	}
	public void setHostManagement(HostManagement hostManagement) {
		this.hostManagement = hostManagement;
	}
	public void setHostManagementService(HostManagementService hostManagementService) {
		this.hostManagementService = hostManagementService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getHId() {
		return HId;
	}
	public void setHId(Integer hId) {
		HId = hId;
	}

	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	

	/**
	 * 接收
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 接收
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 住户信息实体类
	 * @return
	 */
	public Household getHousehold() {
		return household;
	}
	/**
	 * 住户信息实体类
	 * @param household
	 */
	public void setHousehold(Household household) {
		this.household = household;
	}
	/**
	 * 住户信息集合list
	 * @return
	 */
	public List<Household> getListH() {
		return listH;
	}
	/**
	 * 住户信息集合list
	 * @param listH
	 */
	public void setListH(List<Household> listH) {
		this.listH = listH;
	}
	/**
	 * 分页
	 * @return
	 */
	public PageManager getPage() {
		return page;
	}
	/**
	 * 分页set注入
	 * @param page
	 */
	public void setPage(PageManager page) {
		this.page = page;
	}
	/**
	 * 用户信息service set注入
	 * @param householdService
	 */
	public void setHouseholdService(HouseholdService householdService) {
		this.householdService = householdService;
	}
	/**
	 * 添加
	 * @return
	 */
	
	public String addHouser(){
		try {
			
			listH = householdService.findHouse(household);
			if(listH.size()==0){
				System.out.println("**********************");
				System.out.println(household.getHNo());
				
				this.householdService.addHouser(household);
				result=1;
			}else if(listH.size() != 0){
				result = 2;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=0;
			return ERROR;
		}
		return "addHouser";
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delHouser(){
		try {
			msg=this.householdService.delHouser(HId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "delHouser";
	}
	/**
	 * 修改
	 * @return
	 */
	public String updHouser(){
		try {
			//System.out.println("1111111111111111");
			this.householdService.updHouser(household);
			
			//hostManagementService.updateHostManagement(hostManagement);
			result=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=0;
			return ERROR;
		}
		return "updHouser";
	}
	/**
	 * 查询单个
	 * @return
	 */
	public String findById(){
		try {
			System.out.println("===========");
			household= this.householdService.findById(HId);
			System.out.println("完毕");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "findById";
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public String findAll(){
		try {
		  	listH = this.householdService.findAll();
			System.out.println(listH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "findAll";
	}
	/**
	 * 分页查询所有
	 * @return
	 */
	public String searchHousehold(){
		
		try {
			if(id==null){
				id=0;
			}
			this.householdService.searchHousehold(id, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	/**
	 * 条件检索住户信息
	 * @return
	 */
	public String selectHouse(){
		try{
			if (condition != null && !"".equals(condition)) {
				household= new Household();
				household.setHName(condition);
			}
			/*System.out.println("ppppp");*/
			System.out.println("212");
			listH=this.householdService.selectHouse(household, page);
			System.out.println(page.getPage());
			
			System.out.println(listH);
		    result = 0;
			
		}catch (Exception e) {
		    result=1;
			return "error";
		}
		return "selectHouse";
	}
	//批量删除
	public String delHouses(){
		System.out.println(ids);
		String str[]=ids.split("/");
		try{			
			for(int i=0;i<str.length;i++){
				this.householdService.delHouser(Integer.parseInt(str[i]));				
			}			
		}catch (Exception e) {		
			return "error";
		}
		
		return "delHouser";
	}
	
}
