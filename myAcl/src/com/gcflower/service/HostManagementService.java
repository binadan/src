package com.gcflower.service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SQLQuery;

import com.gcflower.dao.HostManagementDao;
import com.gcflower.entity.HostManagement;
import com.gcflower.entity.HostManagement1;
import com.gcflower.entity.Household;
import com.gcflower.entity.LarumSearchForm;
import com.gcflower.entity.Module;
import com.gcflower.util.PageManager;

@SuppressWarnings("unchecked")
public class HostManagementService {

	private HostManagementDao hostManagementDao;

	public HostManagementDao getHostManagementDao() {
		return hostManagementDao;
	}

	public void setHostManagementDao(HostManagementDao hostManagementDao) {
		this.hostManagementDao = hostManagementDao;
	}

	/**
	 * 增加
	 * 
	 */
	public void add(HostManagement hostManagement) {
		this.hostManagementDao.save(hostManagement);
	}

	/**
	 * 查所有
	 * 
	 * @return
	 */
	public List<HostManagement> findAll() {

		return this.hostManagementDao.findAll();
	}

	/**
	 * 分页查询
	 * 
	 * @param parentId
	 * @param page
	 */
	public void searchHostManagement(int parentId, PageManager page) {
		String hql = "from HostManagement ORDER BY M_id DESC";
		Map map = new HashMap();

		this.hostManagementDao.searchPaginated(hql, map, page);
	}

	/**
	 * 根据ID查
	 * 
	 * @param id
	 * @return
	 */
	public HostManagement findById(int id) {

		return (HostManagement) this.hostManagementDao.getObject(
				HostManagement.class, id);
		
	
	}

	/**
	 * 删除
	 * 
	 */
	private void delete(HostManagement hostManagement) {
		this.hostManagementDao.delete(hostManagement);
	}

	/**
	 * 通过id删除
	 * 
	 * @param id
	 */
	private void del(int id) {
		this.hostManagementDao.removeObject(HostManagement.class, id);
	}

	/**
	 * 删除
	 * 
	 * @param HostManagement
	 * @return
	 */
	public String delHostManagement(int HostManagementId) {
		HostManagement hostManagement = this.findById(HostManagementId);

		this.delete(hostManagement);
		return "SUCCESS";

	}

	/**
	 * 修改
	 */

	public void updateHostManagement(HostManagement hostManagement) {

		this.hostManagementDao.update(hostManagement);

	}
  /*  public void updateHostManage(Household household){
		String sql = "update hostmanagement set M_HOUSEID ='"+household.getHNo()+"' where M_HOUSEID ='"+household+"'";
		
	}*/
	
	public List selectHostManagement(HostManagement1 hostManagement1 ,PageManager page) {
		return this.hostManagementDao.selectHostManagement(hostManagement1,page);
	}
	public List<HostManagement> hh(HostManagement hostManagement) {
		return this.hostManagementDao.findHost(hostManagement);
	
	}
	public List<HostManagement> hhh(HostManagement hostManagement) {
		return this.hostManagementDao.findHosts(hostManagement);
	
	}

}
