package com.gcflower.dao;

import java.util.List;
import com.gcflower.entity.*;
import com.gcflower.entity.Role;
public class RoleDao extends BaseDao{
	

	/**
	 * 查询所有
	 * @return
	 */
	public List<Role> findAll(){
		
		return (List<Role>)getHibernateTemplate().find("from Role order by id");
		
	}


	/**
	 * 根据名称查找是否存在
	 * @param roleName
	 * @param companyId
	 * @return
	 */
	public Role findByName(String roleName){
		List ul = getHibernateTemplate().find("from Role  where name = ? " , 
			    new Object[]{roleName});
	        if (ul != null && ul.size() >= 1){
	            return (Role)ul.get(0);
	        }
	        return null;
	}
	
	
}
