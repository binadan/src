package com.gcflower.service;

import java.util.List;
import com.gcflower.dao.LarumDao;
import com.gcflower.entity.Laruminfo;
import com.gcflower.util.PageManager;


public class LarumService {

	private LarumDao larumDao;

	/**
	 * set注入
	 * @param larumDao
	 */
	public void setLarumDao(LarumDao larumDao) {
		this.larumDao = larumDao;
	}


	
	/**
	 * 增加
	 * @param menu
	 */
	public void add(Laruminfo laruminfo){
		try {
			this.larumDao.save(laruminfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 删除
	 * @param user
	 */
	public void delete(Laruminfo laruminfo){
		try {
			this.larumDao.delete(laruminfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 根据ID查警报信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Laruminfo> findById(Laruminfo laruminfo,PageManager page){
		
		 return this.larumDao.selLaruminfo(laruminfo, page);
		
	}

}
