package com.gcflower.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.springframework.dao.DataAccessException;
import com.gcflower.entity.Laruminfo;
import com.gcflower.util.PageManager;

/**
 * 
 *com.gcflower.daoLarumDao.java
 *
 *2015-6-11
 *
 * @author James
 *
 *
 */
public class LarumDao extends BaseDao{
	private Laruminfo1mangermentDao laruminfo1maangermentDao;

	public Laruminfo1mangermentDao getLaruminfo1maangermentDao() {
		return laruminfo1maangermentDao;
	}

	public void setLaruminfo1maangermentDao(
			Laruminfo1mangermentDao laruminfo1maangermentDao) {
		this.laruminfo1maangermentDao = laruminfo1maangermentDao;
	}
	
	/**
	 * 增加
	 * 
	 * @param laruminfo
	 */
	public void addLaruminfo(Laruminfo laruminfo) {
		try {
			getHibernateTemplate().save(laruminfo);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据id查询
	 * @param 
	 * @return
	 */
	public List selLaruminfo(Laruminfo laruminfo, PageManager page) {

		String sql = "select L_MID,L_HID,L_TYPE,L_PERSONID,L_DATE,L_PDATE,L_REMARK,L_STATE ,L_VHOEID from laruminfo where l_id =?";
		SQLQuery query = getSession().createSQLQuery(sql);
		query.setParameter(0, laruminfo.getL_hid());
		int total = query.list().size();
		query.setFirstResult((page.getPage() - 1) * page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		// 结果数据
		List list = query.addEntity(Laruminfo.class).list();
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
	public void updlar(Laruminfo laruminfo) {
		String sqlString = "update  Laruminfo set L_REMARK = L_REMARK + "+laruminfo.getL_remark()+" where L_ID = "+laruminfo.getL_id()+"";
		SQLQuery query = getSession().createSQLQuery(sqlString);
		query.executeUpdate();
	}

}
