package com.gcflower.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.gcflower.entity.HostManagement;
import com.gcflower.entity.Laruminfo1;
import com.gcflower.entity.Laruminfo;
import com.gcflower.entity.Salesman;
import com.gcflower.entity.User;
import com.gcflower.service.LaruminfoManagementService;
import com.gcflower.util.PageManager;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;
/**
 * 
 *com.gcflower.action.LarumAction.java
 *
 *2015-6-11
 *
 * @author James
 *
 *
 */
public class LarumAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 623685391349842753L;
	private PageManager page = new PageManager(10);
	private Laruminfo laruminfo;
	private Integer larumId;
	private List<Salesman> salesmanList;
	private List<HostManagement> hostList;
	private List<Laruminfo1> list;
	private Laruminfo1 laruminfo1;
	private LaruminfoManagementService laruminfoManagementService;
	private String dealPerson;//处理人
	private int result;
	private Integer id;//id
	private Integer l_id;//id
	private String msg;//接收
	private String ids;//id串
	
	private String startDate;
	private String endDate;
	private String houseId;
	private String baojingId;
	private String l_state;
	
	
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getBaojingId() {
		return baojingId;
	}

	public void setBaojingId(String baojingId) {
		this.baojingId = baojingId;
	}

	public String getL_state() {
		return l_state;
	}

	public void setL_state(String l_state) {
		this.l_state = l_state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public PageManager getPage() {
		return page;
	}

	public void setPage(PageManager page) {
		this.page = page;
	}

	public Laruminfo getLaruminfo() {
		return laruminfo;
	}

	public void setLaruminfo(Laruminfo laruminfo) {
		this.laruminfo = laruminfo;
	}

	public Integer getLarumId() {
		return larumId;
	}

	public void setLarumId(Integer larumId) {
		this.larumId = larumId;
	}

	public List<Salesman> getSalesmanList() {
		return salesmanList;
	}

	public void setSalesmanList(List<Salesman> salesmanList) {
		this.salesmanList = salesmanList;
	}

	public List<HostManagement> getHostList() {
		return hostList;
	}

	public void setHostList(List<HostManagement> hostList) {
		this.hostList = hostList;
	}

	public List<Laruminfo1> getList() {
		return list;
	}

	public void setList(List<Laruminfo1> list) {
		this.list = list;
	}

	public Laruminfo1 getLaruminfo1() {
		return laruminfo1;
	}

	public void setLaruminfo1(Laruminfo1 laruminfo1) {
		this.laruminfo1 = laruminfo1;
	}

	public LaruminfoManagementService getLaruminfoManagementService() {
		return laruminfoManagementService;
	}

	public void setLaruminfoManagementService(
			LaruminfoManagementService laruminfoManagementService) {
		this.laruminfoManagementService = laruminfoManagementService;
	}

	public String getDealPerson() {
		return dealPerson;
	}

	public void setDealPerson(String dealPerson) {
		this.dealPerson = dealPerson;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public Integer getId() {
		return id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}
*/
	public Integer getL_id() {
		return l_id;
	}

	public void setL_id(Integer l_id) {
		this.l_id = l_id;
	}


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * 添加警报信息
	 * 
	 * @return
	 */
	static Timer timer = new Timer();
	boolean panduan = false;
	private String pan = "";
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public void addLaruminfo() {
		if (pan.equals("1")) {
			panduan = true;
		}else if(pan.equals("0")){
			panduan = false;
			timer.cancel();
		}
		if(panduan){
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					addbaojing();
				}
			};
			timer = new Timer();
			timer.schedule(task, 1000 * 10);
		}else{
			//timer.cancel();
			System.out.println("用户已取消");
		}
		//System.out.println(panduan+"----------------"+panduan);
	}
	public String addbaojing(){
		try {
			//System.out.println("---------------------------------------------");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			laruminfo.setL_date(dateFormat.format(new Date()));
			laruminfo.setL_state("0");
			this.laruminfoManagementService.addLaruminfo(laruminfo);
			result=1;
		} catch (Exception e) {
			result=0;
			return ERROR;
		}
		return "addLaruminfo";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delLaruminfo(){
		try {
			msg = this.laruminfoManagementService.delLaruminfo(l_id);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "delLaruminfo";
	}
	//批量删除
	public String delAllLarum(){
		
		System.out.println(ids);
		String str[]=ids.split("/");
		try{
			for(int i=0;i<str.length;i++){				
				this.laruminfoManagementService.delLaruminfo(Integer.parseInt(str[i]));
			}
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return "delLaruminfo";
	}
	
	
	/**
	 * 修改
	 * @return
	 */
	public String updateLaruminfo(){
		try {
			this.laruminfoManagementService.updlar(laruminfo);
			laruminfo = laruminfoManagementService.findId(laruminfo.getL_id());
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User)session.get("sessionUser");
			laruminfo.setL_personid(user.getUsername());
			laruminfo.setL_state("1");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			laruminfo.setL_pdate(dateFormat.format(new Date()));
			this.laruminfoManagementService.updateLaruminfo(laruminfo);
			result=1;
		} catch (Exception e) {
			e.printStackTrace();
			result=0;
			return ERROR;
		}
		return "updateLaruminfo";
	}
	
	/**
	 * 查询单个
	 * @return
	 */
	public String findByl_id(){
		try {
			//System.out.println("===========");
			laruminfo = laruminfoManagementService.findId(l_id);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "findByl_id";
	}
	/**
	 * 分页查询所有
	 * @return
	 */
	public String searchLaruminfo(){
		//System.out.println("321212121");
		try {
			if(id==null){
				id=0;
			}
			this.laruminfoManagementService.searchLaruminfo1(id, page);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}
	/**
	 * 条件检索报警信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String selectLaruminfo(){
		try{
			//laruminfo1 = new Laruminfo1();
			if (startDate!=null && !"".equals(startDate)) {

				laruminfo1.setStartTime(startDate);				
			}
			
			if (endDate!=null && !"".equals(endDate)) {
				
				laruminfo1.setEndTime(endDate);				
			}
			
			if (houseId!=null && !"".equals(houseId)) {
				
				laruminfo1.setH_no(houseId);			
			}
			
			if (baojingId!=null && !"".equals(baojingId)) {
				
				laruminfo1.setL_mid(baojingId);			
			}
			
			if (l_state!=null && !"".equals(l_state)) {
				
				laruminfo1.setL_state(l_state);				
			}
			List<Laruminfo1> list=
					this.laruminfoManagementService.selectLarum(laruminfo1, page);
			System.out.println(list);
		result = 0;
			return "index";
		}catch (Exception e) {
		result = 1;
			return "error";
		}
	}
	
}
