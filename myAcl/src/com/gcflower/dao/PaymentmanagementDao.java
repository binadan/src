package com.gcflower.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;

import com.gcflower.entity.HostManagement;
import com.gcflower.entity.Household;
import com.gcflower.entity.Paymentmanagement;
import com.gcflower.util.PageManager;

/**
 * 
 * @Title:缴费功能Dao
 * 
 * @ClassName:com.gcflower.dao.PaymentmanagementDao.java
 * 
 * @author:屈碧勃
 * 
 * @date:2015-6-1
 * 
 */
@SuppressWarnings("unchecked")
public class PaymentmanagementDao extends BaseDao {
	/**
	 * 增加
	 * 
	 * @param paymentmanagement
	 */
	public void addPay(Paymentmanagement paymentmanagement) {
		try {
			getHibernateTemplate().save(paymentmanagement);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param paymentmanagement
	 */
	public void delPay(Paymentmanagement paymentmanagement) {
		this.getHibernateTemplate().delete(paymentmanagement);
	}

	/**
	 * 修改
	 * 
	 * @param paymentmanagement
	 */
	public void updPay(Paymentmanagement paymentmanagement) {
		this.getHibernateTemplate().update(paymentmanagement);
	}

	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	public Paymentmanagement findById(int id) {
		List listP = getHibernateTemplate().find(
				"from Paymentmanagement where PId=? ", new Object[] { id });
		if (listP != null && listP.size() >= 1) {
			return (Paymentmanagement) listP.get(0);
		}
		return null;
	}

	public Paymentmanagement findId(Paymentmanagement paymentmanagement) {
		return (Paymentmanagement) getHibernateTemplate().find(
				"from Paymentmanagement where PId=? ");
	}
	
	public List<Paymentmanagement> findByPayNo(String payNo) {
		return (List<Paymentmanagement>) getHibernateTemplate().find(
				"from Paymentmanagement where PNo='" + payNo + "'" );
	}
	
	/**
	 * 根据条件检索缴费信息
	 * 
	 * @param formBean
	 *            查询条件
	 * @param page
	 *            分页
	 * @return
	 */
	public List selectPay(Paymentmanagement paymentmanagement, PageManager page) {

		StringBuffer sql = new StringBuffer(
				"select * from hostmanagement a ,paymentmanagement b where a.M_MANUAL = b.P_NO ");
		if (paymentmanagement != null) {
			// 住户姓名
			if (paymentmanagement.getPState() != null
					&& !(paymentmanagement.getPState().equals(""))) {
				sql.append(" and b.P_STATE = '");
				sql.append(paymentmanagement.getPState().trim());
				sql.append("'");
			}
			
		}
		sql.append(" ORDER BY p_id DESC");
		SQLQuery query = getSession().createSQLQuery(sql.toString());
		int total = query.list().size();
		query.setFirstResult((page.getPage() - 1) * page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		// 结果数据
		List list = query.addEntity("p", Paymentmanagement.class).list();
		// 获取记录总数
		// 把查询结果赋于分页类
		page.setDatas(list);
		page.setRecordTotal(total);
		return list;

	}
	/**
	 * 缴费
	 * @param paymentmanagement
	 */
	public void aaMoney(Paymentmanagement paymentmanagement) {
		String sqlString = "update  Paymentmanagement set P_MONEY = P_MONEY + "+paymentmanagement.getPMoney()+" where P_NO = "+paymentmanagement.getPNo()+"";
		SQLQuery query = getSession().createSQLQuery(sqlString);
		//query.setInteger(0, 100);
		//query.setInteger(1, 80);
		query.executeUpdate();
	}

}
