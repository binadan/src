package com.gcflower.dao;

import java.util.List;
import com.gcflower.entity.*;
import com.gcflower.entity.Salesman;
@SuppressWarnings("unchecked")
public class SalesmanDao extends BaseDao{
	
	/**
	 * 查询所有
	 * @return
	 */
	
	public List<Salesman> findAll(){
		
		return (List<Salesman>)getHibernateTemplate().find("from Salesman order by id");
		
	}

	
}
