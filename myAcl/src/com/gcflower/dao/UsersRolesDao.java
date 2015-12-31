package com.gcflower.dao;

import java.util.List;
import com.gcflower.entity.User;

public class UsersRolesDao extends BaseDao{
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<User> findAll(){
		
		return (List<User>)getHibernateTemplate().find("from User order by id");
		
	}

}
