package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gcflower.dao.RoleDao;
import com.gcflower.entity.Role;
import com.gcflower.util.PageManager;

public class RoleService {
	
	private RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	
	/**
	 * 增
	 * @param menu
	 */
	public void add(Role role){
		this.roleDao.save(role);
	}

	
	/**
	 * 改
	 * @param role
	 */
	public void merge(Role role){
		this.roleDao.merge(role);
	}
	
	
	/**
	 * 删除
	 * @param role
	 */
	public void delete(Role role){
		this.roleDao.delete(role);
	}
	
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	public String delete(int id){
		//先检查关连表
		
		String hql = "select count(*) from UsersRoles ur where ur.role.id = :rid ";
		Map map=new HashMap();
		map.put("rid", id);
	
		Long size = (Long)this.roleDao.executeHql(hql,map);
			
		//判断角色下面是否存在用户
		if(size > 0){
			return "该角色下面存在用户信息，不允许删除！";
		}
		
		
		hql="select count(*) from Acl a where a.principalId = :rid ";
		size = (Long)this.roleDao.executeHql(hql,map);
		//判断角色下面是否存在权限配
		if(size > 0){
			return "该角色下面存在权限菜单信息，不允许删除！";
		}
		
		this.roleDao.removeObject(Role.class, id);
		
		return "SUCCESS";
	}
	
	/**
	 * 查所有
	 * @return
	 */
	public List<Role> findAll(){
		
		return this.roleDao.findAll();
	}
	
	/**
	 * 根据ID查
	 * @param id
	 * @return
	 */
	public Role findById(int id){
		
		 return (Role)this.roleDao.getObject(Role.class, id);
		
	}



	/**
	 * 获取角色列表
	 * @param page
	 */
	public void searchRoles(PageManager page) {
		String hql="select r from Role r  ";
		Map map=new HashMap();
		this.roleDao.searchPaginated(hql,map, page);
	}
	
	/**
	 * 根据名称查询
	 * @param roleName
	 * @return
	 */
	public Role findByName(String roleName){
		return this.roleDao.findByName(roleName);
	}
	
}
