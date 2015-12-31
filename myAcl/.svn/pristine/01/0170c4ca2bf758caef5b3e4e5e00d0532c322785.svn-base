package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.gcflower.dao.PayDao;
import com.gcflower.entity.Payinfo;
import com.gcflower.entity.Paymentmanagement;
import com.gcflower.util.PageManager;

public class PayService {
	private PayDao payDao;
	
	
	public PayDao getPayDao() {
		return payDao;
	}


	public void setPayDao(PayDao payDao) {
		this.payDao = payDao;
	}

	/**
	 * 增加
	 * @param Payinfo
	 */
	public void addPayinfo (Payinfo payinfo){
		try {
			this.payDao.addPayinfo(payinfo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	public List<Payinfo> findByIds(Payinfo payinfo,PageManager page){
		// return this.payDao.findIds(page,page);
		 return this.payDao.selPay(payinfo, page);
	}
	
}
