package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.gcflower.dao.HouseholdDao;
import com.gcflower.entity.Household;
import com.gcflower.entity.LarumSearchForm;
import com.gcflower.entity.Module;
import com.gcflower.entity.User;
import com.gcflower.util.PageManager;

/**
 * 住户信息service
 * 
 * Description:com.gcflower.service.HouseholdService.java
 *
 * @author 屈碧勃
 *
 */
@SuppressWarnings("unchecked")
public class HouseholdService {
	private HouseholdDao householdDao;//住户信息Dao

	/**
	 * houserholdDao Set注入
	 * @param householdDao
	 */
	public void setHouseholdDao(HouseholdDao householdDao) {
		this.householdDao = householdDao;
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Household> findAll(){
		return householdDao.findAll();
	}
	/**
	 * 增加
	 * @param household
	 */
	public void addHouser(Household household){
		try {
			this.householdDao.addHouser(household);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改
	 * @param household
	 */
	public void updHouser(Household household){
		householdDao.updHouser(household);
	}
	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	public Household findById(int id){
		 return (Household)this.householdDao.getObject(Household.class, id);
	}
	/**
	 * 删除
	 * @param household
	 */
	public void del(Household household){
		householdDao.delHouser(household);
	}
	/**
	 * 根据ID删除
	 * @param id
	 */
	private void delete(int id){
		this.householdDao.removeObject(Household.class, id);
	}
	/**
	 * 删除
	 * @param houserId
	 * @return
	 */
	public String delHouser(int houserId){
		Household household=this.findById(houserId);
		this.del(household);
		return "SUCCESS";
		
	}


	/**
	 * 分页查询
	 * @param houserId
	 * @param page
	 */
	public void searchHousehold(int houserId,PageManager page){
		String hql="from Household ";
		//order by h_id DESC
		Map map=new HashMap();
		/*if(houserId==0){
			hql+=" where h.h_id is null order by h_id";
		}*/
		this.householdDao.searchPaginated(hql,map, page);
	}
	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	public Household findId(Household household){
		 return householdDao.findId(household);
	}
	/**
	 * 模糊查询
	 * @param page
	 */
	public List selectHouse(Household household ,PageManager page) {
		return this.householdDao.selectHouse(household, page);
	}
	 public List<Household> findHouse(Household household){
			
			return householdDao.findHouse(household);
		}
}
