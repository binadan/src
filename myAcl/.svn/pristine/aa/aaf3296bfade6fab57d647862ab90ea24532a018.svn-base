package com.gcflower.dao;

import java.util.List;
import com.gcflower.entity.User;
import com.gcflower.entity.UsersRoles;
public class UserDao extends BaseDao{
	

	/**
	 * 查询所有
	 * @return
	 */
	public List<User> findAll(){
		
		return (List<User>)getHibernateTemplate().find("from User order by id");
		
	}


	/**
	 * 根据用户名进行查询
	 * @param userName
	 * @return
	 */
	public User findUser(String userName){
		List ul=getHibernateTemplate().find("from User where username=? ",
				new Object[]{userName});
		if(ul !=null && ul.size()>=1){
			return (User)ul.get(0);
		}
		return null;
	}
	
	
	/**
	 * 根据用户名进行查询
	 * @param userName
	 * @return
	 */
	public List<UsersRoles> findUserRole(int userId){
		List ul=getHibernateTemplate().find("select ur from UsersRoles ur where ur.user.id = ? order by ur.orderNo",
				new Object[]{userId});
		if(ul !=null && ul.size()>=1){
			return ul;
		}
		return null;
	}
	
	
}
