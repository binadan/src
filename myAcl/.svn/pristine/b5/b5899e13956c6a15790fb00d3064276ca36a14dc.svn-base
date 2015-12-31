package com.gcflower.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.dao.DataAccessException;

import com.gcflower.entity.Module;
import com.gcflower.entity.Payinfo;
import com.gcflower.entity.Paymentmanagement;
import com.gcflower.util.PageManager;

public class PayDao extends BaseDao{
	
	private Paymentmanagement paymentmanagement ;
	
	public Paymentmanagement getPaymentmanagement() {
		return paymentmanagement;
	}
	public void setPaymentmanagement(Paymentmanagement paymentmanagement) {
		this.paymentmanagement = paymentmanagement;
	}
	/**
	 * 增加
	 * 
	 * @param payinfo
	 */
	public void addPayinfo(Payinfo payinfo) {
		try {
			getHibernateTemplate().save(payinfo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据id查询
	 * @param 
	 * @return
	 */
	
	
	public List selPay(Payinfo payinfo, PageManager page) {

		String sql = "select PAY_ID,PAY_MONEY,PAY_DATE,PAY_NO from Payinfo where pay_no =?";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0, payinfo.getPAY_NO());
		int total = query.list().size();
		query.setFirstResult((page.getPage() - 1) * page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		// 结果数据
		List list = query.addEntity(Payinfo.class).list();
		// 获取记录总数
		// 把查询结果赋于分页类
		page.setDatas(list);
		page.setRecordTotal(total);
		return list;
	}
}
