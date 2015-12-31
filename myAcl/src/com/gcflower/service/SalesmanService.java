package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gcflower.dao.SalesmanDao;
import com.gcflower.entity.Salesman;
import com.gcflower.util.PageManager;

@SuppressWarnings("unchecked")
public class SalesmanService {
	
	private SalesmanDao salesmanDao;


	
	public void setSalesmanDao(SalesmanDao salesmanDao) {
		this.salesmanDao = salesmanDao;
	}


	/**
	 * 增
	 * @param menu
	 */
	public void add(Salesman person){
		this.salesmanDao.save(person);
	}

	
	/**
	 * 改
	 * @param person
	 */
	public void merge(Salesman person){
		this.salesmanDao.merge(person);
	}
	
	
	/**
	 * 删除
	 * @param person
	 */
	private void delete(Salesman person){
		this.salesmanDao.delete(person);
	}
	
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	public String delete(int id){
		//先检查别的表是否存在关联关系
		Salesman person=this.findById(id);
		if(person.getUser()!=null){
			return "人员【"+person.getName()+"】存在有用户帐号，不允许删除！";
		}
		
		this.delete(person);
		
		return "SUCCESS";
	}
	
	/**
	 * 查所有
	 * @return
	 */
	public List<Salesman> findAll(){
		
		return this.salesmanDao.findAll();
	}
	
	/**
	 * 根据ID查
	 * @param id
	 * @return
	 */
	public Salesman findById(int id){
		
		 return (Salesman)this.salesmanDao.getObject(Salesman.class, id);
		
	}


	/**
	 * 分页查询
	 * @param parentId
	 * @param page
	 */
	public void searchPersons(int orgId,PageManager page){
		String hql="select p from Salesman p  ";
		Map map=new HashMap();
		
		if(orgId != 0){
			hql += " where p.tearm.id =:orgId";
			map.put("orgId", orgId);
		}
		
		this.salesmanDao.searchPaginated(hql,map, page);
	}

	/**
	 * 分页查询
	 * @param parentId
	 * @param page
	 */
	public void searchPersons(String code,PageManager page){
		String hql="select p from Salesman p  ";
		Map map=new HashMap();
		
		if(code != "" || !code.equals("")){
			hql += " where p.tearm.code like :code";
			map.put("code", code+"%");
		}
		
		this.salesmanDao.searchPaginated(hql,map, page);
	}
	
}
