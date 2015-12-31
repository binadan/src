package com.gcflower.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gcflower.entity.Payinfo;
import com.gcflower.entity.Paymentmanagement;
import com.gcflower.service.PaymentManagementService;
import com.gcflower.service.PayService;
import com.gcflower.util.PageManager;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * @Title:缴费action
 * 
 * @ClassName:com.gcflower.action.PaymentmanagementAction.java
 *
 * @author:屈碧勃
 *
 * @date:2015-6-1
 *
 */

public class PaymentmanagementAction extends BaseAction{

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自定义log
	 */
	protected Log log = LogFactory.getLog(PaymentmanagementAction.class);
	
	private Paymentmanagement paymentmanagement;//缴费
	private PaymentManagementService paymentManagementService;//service
	private PageManager page = new PageManager(10);//分页
	private List<Paymentmanagement> listP;//缴费集合
	private String msg;//接收
	private Integer PId;//id
	private String PNo;
	private Integer id;//id
	private int result;
	private PayService payService;
	private Payinfo payinfo = new Payinfo();
	/**
	 * 添加
	 * @return
	 */
	public String addPay(){
		try {
			System.out.println("*****222222222*****");

			int Pmoney = paymentmanagement.getPMoney();
			System.out.println(Pmoney);

			paymentmanagement.setPMoney(Pmoney);
			if (Pmoney >= 0) {
				paymentmanagement.setPState("1");
			} else {
				paymentmanagement.setPState("0");
			}
			System.out.println(paymentmanagement.getPHid() + "==11=="
					+ paymentmanagement.getPId());
			// 处理缴费时间
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			paymentmanagement.setPDate(dateFormat.format(new Date()));
			System.out.println(paymentmanagement.getPDate() + "\t"
					+ paymentmanagement.getPHnamw() + "\t-->phid="
					+ paymentmanagement.getPHid());
			this.paymentManagementService.addPay(paymentmanagement);
			Payinfo payinfo1 = new Payinfo();
			payinfo1.setPAY_NO(paymentmanagement.getPNo());
			payinfo1.setPAY_DATE(paymentmanagement.getPDate());
			payinfo1.setPAY_MONEY(paymentmanagement.getPMoney());
			System.out.println(payinfo1);
			payService.addPayinfo(payinfo1);
			result = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = 0;
			return ERROR;
		}
		return "addPay";
	}
	/**
	 * 删除
	 * @return
	 */
	public String delPay(){
		try {
			msg=this.paymentManagementService.delPay(PId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "delPay";
	}
	/**
	 * 缴费
	 * @return
	 */
	public String updPay(){
		try {
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			paymentmanagement.setPDate(dateFormat.format(new Date()));
			Payinfo payinfo1 = new Payinfo();
			paymentManagementService.aaMoney(paymentmanagement);
			payinfo1.setPAY_MONEY(paymentmanagement.getPMoney());
			paymentmanagement= paymentManagementService.findById(paymentmanagement.getPId());
			int money = paymentmanagement.getPMoney();
			System.out.println(money);
			if (money>=0) {
			paymentmanagement.setPState("1");
			System.out.println(paymentmanagement.getPState());
			}
			else{
			paymentmanagement.setPState("0");
			System.out.println(paymentmanagement.getPState());
			}
			
			paymentmanagement.setPDate(dateFormat.format(new Date()));
		
			paymentManagementService.updPay(paymentmanagement);
			
			
			payinfo1.setPAY_NO(paymentmanagement.getPNo());
			payinfo1.setPAY_DATE(paymentmanagement.getPDate());
			
			System.out.println(payinfo1);
			payService.addPayinfo(payinfo1);
            result=1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("++"+e);
			result=0;
			return ERROR;
		}
		return "updPay";
	}
	/**
	 * 查询单个
	 * @return
	 */
	public String findByPId(){
		try {
			System.out.println("===========");
			paymentmanagement= this.paymentManagementService.findById(PId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "findByPId";
	}
	public String findByIds(){
		try {
			System.out.println("====pay=======");
			if(id==null){
				id=0;
			}
			//Payinfo payinfo = new Payinfo();
			//payinfo.setPAY_NO(this.PNo);
			List<Payinfo> list = this.payService.findByIds(payinfo, page);
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "index";
	}
	/**
	 * 分页查询所有
	 * @return
	 */
	public String searchPaymentManagement(){
		System.out.println("321212121");
		try {
			if(id==null){
				id=0;
			}
			this.paymentManagementService.searchPaymentManagement(id, page);
			System.out.println();
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
	public String selectPay(){
		try{
			System.out.println("ppppp");
			List<Paymentmanagement> list=
					this.paymentManagementService.selectPay(paymentmanagement, page);
			System.out.println(list);
			result = 0;
			return "selectPay";
		}catch (Exception e) {
			e.printStackTrace();
		result=1;
			return "error";
		}
	}
	
	/*********************封装***************************/
	
	public PayService getPayService() {
		return payService;
	}
	
	public String getPNo() {
		return PNo;
	}
	public void setPNo(String pNo) {
		PNo = pNo;
	}
	public Payinfo getPayinfo() {
		return payinfo;
	}
	public void setPayinfo(Payinfo payinfo) {
		this.payinfo = payinfo;
	}
	public void setPayService(PayService payService) {
		this.payService = payService;
	}
	public Paymentmanagement getPaymentmanagement() {
		return paymentmanagement;
	}
	public void setPaymentmanagement(Paymentmanagement paymentmanagement) {
		this.paymentmanagement = paymentmanagement;
	}
	public PaymentManagementService getPaymentManagementService() {
		return paymentManagementService;
	}
	public void setPaymentManagementService(
			PaymentManagementService paymentManagementService) {
		this.paymentManagementService = paymentManagementService;
	}
	public PageManager getPage() {
		return page;
	}
	public void setPage(PageManager page) {
		this.page = page;
	}
	public List<Paymentmanagement> getListP() {
		return listP;
	}
	public void setListP(List<Paymentmanagement> listP) {
		this.listP = listP;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getPId() {
		return PId;
	}
	public void setPId(Integer pId) {
		PId = pId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}	
	

}
