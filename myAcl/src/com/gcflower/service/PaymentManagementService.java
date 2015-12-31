package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

import com.gcflower.dao.PaymentmanagementDao;
import com.gcflower.entity.Paymentmanagement;
import com.gcflower.util.PageManager;

/**
 * 
 * @Title:缴费功能service
 * 
 * @ClassName:com.gcflower.service.PaymentManagementService.java
 * 
 * @author:屈碧勃
 * 
 * @date:2015-6-1
 * 
 */
@SuppressWarnings("unchecked")
public class PaymentManagementService {
	private PaymentmanagementDao paymentmanagementDao;// 缴费Dao

	/**
	 * set注入
	 * 
	 * @param paymentmanagementDao
	 */

	public void setPaymentmanagementDao(
			PaymentmanagementDao paymentmanagementDao) {
		this.paymentmanagementDao = paymentmanagementDao;
	}

	/**
	 * 增加
	 * 
	 * @param Paymentmanagement
	 */
	public void addPay(Paymentmanagement paymentmanagement) {
		try {
			this.paymentmanagementDao.addPay(paymentmanagement);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改
	 * 
	 * @param paymentmanagement
	 */
	public void updPay(Paymentmanagement paymentmanagement) {
		paymentmanagementDao.updPay(paymentmanagement);
	}

	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	public Paymentmanagement findById(int id) {
		return (Paymentmanagement) this.paymentmanagementDao.getObject(
				Paymentmanagement.class, id);
	}

	/**
	 * 删除
	 * 
	 * @param paymentmanagement
	 */
	public void del(Paymentmanagement paymentmanagement) {
		paymentmanagementDao.delPay(paymentmanagement);
	}

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 */
	private void delete(int id) {
		this.paymentmanagementDao.removeObject(Paymentmanagement.class, id);
	}

	/**
	 * 删除
	 * 
	 * @param houserId
	 * @return
	 */
	public String delPay(int PayId) {
		Paymentmanagement paymentmanagement = this.findById(PayId);
		this.del(paymentmanagement);
		return "SUCCESS";

	}

	public String delPayByHostManualId(String hostManualId){
		List<Paymentmanagement> listPayment = paymentmanagementDao.findByPayNo(hostManualId);
		for (Paymentmanagement pay : listPayment){
			paymentmanagementDao.delPay(pay);
		}
				
		return "SUCCESS";
	}
	
	/**
	 * 分页查询
	 * 
	 * @param PayId
	 * @param page
	 */
	public void searchPaymentManagement(int PayId, PageManager page) {
		String hql = "from Paymentmanagement order by P_ID desc ";
		Map map = new HashMap();
		this.paymentmanagementDao.searchPaginated(hql, map, page);
	}

	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	public Paymentmanagement findId(Paymentmanagement paymentmanagement) {
		return paymentmanagementDao.findId(paymentmanagement);
	}

	/**
	 * 模糊查询
	 * 
	 * @param page
	 */
	public List selectPay(Paymentmanagement paymentmanagement, PageManager page) {
		return this.paymentmanagementDao.selectPay(paymentmanagement, page);
	}

	/**
	 * 缴费
	 * 
	 * @param paymentmanagement
	 */
	public void aaMoney(Paymentmanagement paymentmanagement) {
		this.paymentmanagementDao.aaMoney(paymentmanagement);
	}
}
