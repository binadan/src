package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gcflower.dao.Laruminfo1mangermentDao;
import com.gcflower.entity.Laruminfo;
import com.gcflower.entity.Laruminfo1;
import com.gcflower.entity.Paymentmanagement;
import com.gcflower.util.PageManager;
/**
 * 
 *com.gcflower.service.LaruminfoManagementService.java
 *
 *2015-6-11
 *
 * @author James
 *
 *
 */
public class LaruminfoManagementService {
	
	private Laruminfo1mangermentDao laruminfo1mangermentDao;

	/**
	 * set注入
	 * @param laruminfo1mangermentDao
	 */
	public void setLaruminfo1mangermentDao(
			Laruminfo1mangermentDao laruminfo1mangermentDao) {
		this.laruminfo1mangermentDao = laruminfo1mangermentDao;
	}

	/**
	 * 增加
	 * @param laruminfo1
	 */
	public void addLaruminfo(Laruminfo laruminfo){
		try {
			this.laruminfo1mangermentDao.addLaruminfo(laruminfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 修改
	 * @param laruminfo1
	 */
	public void updateLaruminfo(Laruminfo laruminfo){
		try {
			this.laruminfo1mangermentDao.update(laruminfo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	public Laruminfo findById(int id) {
		return (Laruminfo) this.laruminfo1mangermentDao.getObject(
				Laruminfo.class, id);
	}

	/**
	 * 删除
	 * 
	 * @param laruminfo1
	 */
	public void del(Laruminfo laruminfo) {
		try {
			laruminfo1mangermentDao.delete(laruminfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据ID删除
	 * 
	 * @param id
	 */
	@SuppressWarnings("unused")
	private void delete(int id) {
		this.laruminfo1mangermentDao.removeObject(Laruminfo.class, id);
	}
	/**
	 * 删除
	 * 
	 * @param houserId
	 * @return
	 */
	public String delLaruminfo(int l_id) {
		Laruminfo laruminfo = this.findById(l_id);
		this.del(laruminfo);
		return "SUCCESS";

	}
	/**
	 * 分页查询
	 * 
	 * @param PayId
	 * @param page
	 */
	@SuppressWarnings("rawtypes")
	public void searchLaruminfo1(int l_id, PageManager page) {
		String hql = "from Laruminfo  ";
		Map map = new HashMap();
		this.laruminfo1mangermentDao.searchPaginated(hql, map, page);
	}
	/**
	 * 按照id查询
	 * 
	 * @param id
	 * @return
	 */
	public Laruminfo findId(int id) {
		return (Laruminfo) laruminfo1mangermentDao.getObject(Laruminfo.class, id);
	}
	/**
	 * 模糊查询
	 * 
	 * @param page
	 */
	public List selectLarum(Laruminfo1 laruminfo1, PageManager page) {
		return this.laruminfo1mangermentDao.selectLarum(laruminfo1, page);
	}
	/**
	 * 缴费
	 * 
	 * @param paymentmanagement
	 */
	public void updlar(Laruminfo laruminfo) {
		this.laruminfo1mangermentDao.updlar(laruminfo);
	}
}
