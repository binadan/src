package com.gcflower.dao;

import java.util.List;
import com.gcflower.entity.Tearm;
public class TearmDao extends BaseDao{
	

	/**
	 * 查询所有
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Tearm> findAll(){
		
		return (List<Tearm>)getHibernateTemplate().find("from Tearm order by id");
		
	}


	/**
	 * 查询所有根目录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Tearm> findRootOrg(){
		
		return (List<Tearm>)getHibernateTemplate().find("from Tearm where  parent is null order by id");
		
	}

	
	
}
