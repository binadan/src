package com.gcflower.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gcflower.dao.UserDao;
import com.gcflower.entity.Role;
import com.gcflower.entity.User;
import com.gcflower.entity.UsersRoles;
import com.gcflower.util.PageManager;

@SuppressWarnings("unchecked")
public class UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	/**
	 * 增
	 * @param menu
	 */
	public void add(User user){
		this.userDao.save(user);
	}

	
	/**
	 * 改
	 * @param user
	 */
	public void merge(User user){
		this.userDao.merge(user);
	}
	
	
	/**
	 * 删除
	 * @param user
	 */
	private void delete(User user){
		this.userDao.delete(user);
	}
	
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	public String delete(int id){
		List list=searchUserRolesByUserId(id);
		if(list!=null && list.size()>0){
			return "该用户存在角色相关信息,无法删除！";
		}
		this.userDao.removeObject(User.class, id);
		return "SUCCESS";
	}
	
	/**
	 * 查所有
	 * @return
	 */
	public List<User> findAll(){
		
		return this.userDao.findAll();
	}
	
	/**
	 * 根据ID查
	 * @param id
	 * @return
	 */
	public User findById(int id){
		
		 return (User)this.userDao.getObject(User.class, id);
		
	}

//----------------------------------------------------------------------//
	
	
	/**
	 * 添加修改用户角色
	 */
	public void addOrUpdateUserRole(int userId, int roleId, int orderNo) {
		//首先根据userId和roleId，判断这两者之间是否已建立关联
		UsersRoles ur = findUsersRoles(userId, roleId);
		
		if(ur == null){
			//如果还没建立关联
			ur = new UsersRoles();
			ur.setRole(new Role(roleId));
			ur.setUser(new User(userId));
			ur.setOrderNo(orderNo);
			this.userDao.save(ur);
			return;
		}
		
		//如果已建立，则修改
		ur.setOrderNo(orderNo);
		this.userDao.update(ur);
	}
	
	
	
	/**
	 * 根据userId和roleId，判断这两者之间是否已建立关联
	 * @param userId
	 * @param roleId
	 * @return
	 */
	private UsersRoles findUsersRoles(int userId,int roleId){
		
		String hql="select ur from UsersRoles ur where ur.role.id=:roleId and ur.user.id=:userId";
		Map map=new HashMap();
		map.put("userId", userId);
		map.put("roleId", roleId);
		
		return (UsersRoles)this.userDao.executeHql(hql, map);
		
	}


	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		user.setCreateTime(new Timestamp(new java.util.Date().getTime()));
		this.add(user);
	}
	
	/**
	 * 删除用户角色
	 * @param userId
	 * @param roleId
	 */
	public void delUserRole(int userId, int roleId) {
		
		Map map=new HashMap();
		String hql="delete from UsersRoles where user.id=:userId and role.id=:roleId";
		map.put("userId", userId);
		map.put("roleId", roleId);
		this.userDao.executeUpdateHql(hql, map);
	}
	
	/**
	 * 修改用户角色的优先级
	 * @param userId
	 * @param roleId
	 * @param orderNo
	 */
	public void updateURNo(int userId,int roleId,int orderNo){
		Map map=new HashMap();
		String hql="update UsersRoles set orderNo=:orderNo where user.id=:userId and role.id=:roleId";
		map.put("userId", userId);
		map.put("roleId", roleId);
		map.put("orderNo", orderNo);
		this.userDao.executeUpdateHql(hql, map);
	}
	

	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username, String password) {
		
		User user = this.userDao.findUser(username);
		
		return user;
	}
	
	
	/**
	 * 根据用户名检查用户是否存在
	 * @param userName
	 * @return
	 */
	public User checkUser(String userName){
		return this.userDao.findUser(userName);
	}
	
	/**
	 * 获取用户所有角色
	 * @param userId
	 * @param page
	 */
	public void searchUserRoles(int userId,PageManager page) {
		
		String hql = "select ur from UsersRoles ur where ur.user.id = :userId order by ur.orderNo";
		Map map=new HashMap();
		map.put("userId", userId);
		this.userDao.searchPaginated(hql,map, page);
	}

	
	/**
	 * 根据用户ID 获取用户所拥有的角色
	 * @param userId
	 * @return
	 */
	public List<UsersRoles> searchUserRolesByUserId(int userId){
		return this.userDao.findUserRole(userId);
	}
	
	/**
	 * 用户分页
	 * @param page
	 */
	public void searchUsers(PageManager page) {
		String hql="select u from User u";
		this.userDao.searchPaginated(hql, page);
	}

}
