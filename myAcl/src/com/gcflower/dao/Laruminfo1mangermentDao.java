package com.gcflower.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.dao.DataAccessException;
import com.gcflower.entity.HostManagement;
import com.gcflower.entity.Household;
import com.gcflower.entity.Laruminfo;
import com.gcflower.entity.Laruminfo1;
import com.gcflower.util.PageManager;

/**
 * 
 *com.gcflower.daoLaruminfo1mangermentDao.java
 *
 *2015-6-11
 *
 * @author James
 *
 *
 */
public class Laruminfo1mangermentDao extends BaseDao {
	/**
	 * 增加
	 * 
	 * @param Laruminfo1
	 */
	public void addLaruminfo(Laruminfo Laruminfo) {
		try {
			getHibernateTemplate().save(Laruminfo);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param laruminfo1
	 */
	public void deleteLaruminfo(Laruminfo laruminfo) {
		this.getHibernateTemplate().delete(laruminfo);
	}

	/**
	 * 修改
	 * 
	 * @param laruminfo1
	 */
	public void updateLaruminfo(Laruminfo1 laruminfo1) {
		this.getHibernateTemplate().update(laruminfo1);
	}

	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Laruminfo1 findById(int id) {
		List<Laruminfo1> listL = getHibernateTemplate().find(
				"from Laruminfo where l_id=? ", new Object[] { id });
		if (listL != null && listL.size() >= 1) {
			return (Laruminfo1) listL.get(0);
		}
		return null;
	}

	public Laruminfo findId(int id) {
		return (Laruminfo) getHibernateTemplate().find(
				"from Laruminfo where l_id=? ");
	}

	/**
	 * 根据条件检索报警信息
	 * 
	 * @param laruminfo1
	 *            查询条件
	 * @param page
	 *            分页
	 * @return
	 */

	public List<Laruminfo1> selectLarum(Laruminfo1 laruminfo1, PageManager page) {

		StringBuffer sql = new StringBuffer(
				"select * from laruminfo l ,household h ,hostmanagement h1 where  l.L_HID = h.H_No and l.L_MID = h1.m_manual  ");
		if(laruminfo1!=null ){
			if (laruminfo1.getH_no()!=null && !laruminfo1.getH_no().equals("")) {
				sql.append(" and h.H_no like '%"+laruminfo1.getH_no()+"%'");
			}
			if (laruminfo1.getL_mid()!=null && !laruminfo1.getL_mid().equals("")) {
				sql.append(" and l.l_mid like '%"+laruminfo1.getL_mid()+ "%'");
				
			}
			if (laruminfo1.getStartTime()!=null && !laruminfo1.getStartTime().equals("")&& laruminfo1.getEndTime()!=null && !laruminfo1.getEndTime().equals("")) {
				sql.append(" and l.L_DATE BETWEEN '"+laruminfo1.getStartTime()+"' AND '"+laruminfo1.getEndTime()+"'");
							}
			if (laruminfo1.getL_state()!=null && !laruminfo1.getL_state().equals("")) {
				sql.append(" and l.l_state = '");
				sql.append(laruminfo1.getL_state().trim());
				sql.append("'");
			}
			
		}
		sql.append("order by l_id DESC");
		
		
		System.out.println(sql.toString());
		SQLQuery query = getSession().createSQLQuery(sql.toString());
		int total = query.list().size();

		query.setFirstResult((page.getPage() - 1) * page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		// 结果数据
		List list = query.addEntity(Laruminfo1.class).list();
		// 获取记录总数
		// 把查询结果赋于分页类
		page.setDatas(list);
		page.setRecordTotal(total);
		return list;

	}
	public void updlar(Laruminfo laruminfo) {
		String sqlString = "update  Laruminfo set L_REMARK = '"+laruminfo.getL_remark()+"' where L_ID = "+laruminfo.getL_id()+"";
		SQLQuery query = getSession().createSQLQuery(sqlString);
		query.executeUpdate();
	}
}
