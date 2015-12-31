package com.gcflower.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.SQLQuery;

import com.gcflower.entity.*;
import com.gcflower.entity.Acl;
public class AclDao extends BaseDao{
	
	/**
	 * 查询所有
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Acl> findAll(){
		
		return (List<Acl>)getHibernateTemplate().find("from Acl order by id");
		
	}

	
	/**
	 * 查找授权记录，如果找不到，返回空值
	 * @param principalType
	 * @param principalId
	 * @param moduleId
	 * @return
	 */
	public Acl findACL(String principalType,int principalId,int moduleId){
		List ul = getHibernateTemplate().find("select acl from Acl acl where acl.principalType = ? and acl.principalId=? and acl.moduleId = ?" , 
			    new Object[]{principalType,principalId,moduleId});
	        if (ul != null && ul.size() >= 1){
	            return (Acl)ul.get(0);
	        }
	        return null;
	}

	
	/**
	 * 查找分配给用户的角色，按优先级从高到低排序
	 */
	public List findUserRoleByUID(int userId){
		List ul = getHibernateTemplate().find("select r.id from UsersRoles ur join ur.role r join ur.user u where u.id = ? order by ur.orderNo" , 
			    new Object[]{userId});
	    if (ul != null && ul.size() >= 1){
	            return ul;
	    }
	    return new ArrayList();
	    
	    
	}
	
	/**
	 * 查找分配给用户的角色，按优先级从低到高排序
	 */
	public List findUserRoleByUIDDesc(int userId){
		List ul = getHibernateTemplate().find("select r.id from UsersRoles ur join ur.role r join ur.user u where u.id = ? order by ur.orderNo desc" , 
			    new Object[]{userId});
	    if (ul != null && ul.size() >= 1){
	            return ul;
	    }
	    return new ArrayList();
	    
	    
	}
	
	
	/**
	 * 查找角色的授权
	 * @param roleId
	 * @return
	 */
	public List findRoleAcls(int roleId){
		List ul = getHibernateTemplate().find("select acl from Acl acl where acl.principalType = ? and acl.principalId = ? " , 
			    new Object[]{Acl.TYPE_ROLE,roleId});
	    if (ul != null && ul.size() >= 1){
	            return ul;
	    }
	    return new ArrayList();

	}

	
	
	/**
	 * 针对用户查找有效的用户授权
	 */
	public List findUserAcls(int userId){
		
		List ul = getHibernateTemplate().find("select acl from Acl acl where acl.principalType = ? and acl.principalId = ? and acl.aclTriState = ?  " , 
			    new Object[]{Acl.TYPE_USER,userId,Acl.ACL_TRI_STATE_UNEXTENDS});
		
	    if (ul != null && ul.size() >= 1){
	            return ul;
	    }
	    return new ArrayList();
	    
	}

	
	/**
	 * 查询用户拥有读取权限的模块列表
	 * @param userId 用户标识
	 * @return 列表元素是Module对象
	 */
	public List searchModules(Set set){
		
		List ul = this.getSession().createQuery("select m from Module m where m.id in (:ids) order by orderNo ").setParameterList("ids", set).list();
		
	    if (ul != null && ul.size() >= 1){
	            return ul;
	    }
	    return new ArrayList();
	    
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List searchAclRecord(String principalType,int principalId){
		 
	    String sql="select moduleId,aclState&1,aclState&2,aclState&4,aclState&8,aclState&16,aclState&32,aclState&64,aclState&128,aclTriState from t_acl where principalType = ? and principalId = ? ";
	    SQLQuery query =getSession().createSQLQuery(sql);
        //设置查询参数
        query.setString(0,principalType);
        //设置查询参数
        query.setInteger(1,principalId);
        //结果数据
        List list =  query.list();

		return list;
	}
	


}
