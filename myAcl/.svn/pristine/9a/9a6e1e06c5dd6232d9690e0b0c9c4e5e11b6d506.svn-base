package com.gcflower.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.gcflower.util.Permission;
import com.gcflower.dao.AclDao;
import com.gcflower.entity.Acl;

@SuppressWarnings("unchecked")
public class AclService {
	
	private AclDao aclDao;

	
	
	
	public void setAclDao(AclDao aclDao) {
		this.aclDao = aclDao;
	}


	/**
	 * 增
	 * @param menu
	 */
	public void add(Acl acl){
		this.aclDao.save(acl);
	}

	
	/**
	 * 改
	 * @param acl
	 */
	public void merge(Acl acl){
		this.aclDao.merge(acl);
	}
	
	
	/**
	 * 删除
	 * @param acl
	 */
	private void delete(Acl acl){
		this.aclDao.delete(acl);
	}
	
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	private void delete(int id){
		this.aclDao.removeObject(Acl.class, id);
	}
	
	/**
	 * 查所有
	 * @return
	 */
	public List<Acl> findAll(){
		
		return this.aclDao.findAll();
	}
	
	/**
	 * 根据ID查
	 * @param id
	 * @return
	 */
	public Acl findById(int id){
		
		 return (Acl)this.aclDao.getObject(Acl.class, id);
		
	}


	/**
	 * 添加或更新授权
	 * @param principalType 主体类型标识：如角色或用户
	 * @param principalId 主体标识
	 * @param aclId 模块标识
	 * @param permission 操作标识（C/R/U/D）
	 * @param yes 是否允许
	 */
	public void addOrUpdatePermission(String principalType, int principalId,
			int moduleId, int permission, boolean yes) {
		
		//查找ACL对象
		Acl acl = findACL(principalType, principalId, moduleId);
		
		//能够找到ACL对象，更新permission
		if(acl != null){
			acl.setPermission(permission, yes);
			this.merge(acl);
			return;
		}
		
		//找不到ACL对象，则创建ACL对象，并更新permission
		acl = new Acl();
		acl.setPrincipalType(principalType);
		acl.setPrincipalId(principalId);
		acl.setModuleId(moduleId);
		acl.setPermission(permission, yes);
		this.add(acl);
	}
	

	/**
	 * 查找授权记录，如果找不到，返回空值
	 * @param principalType
	 * @param principalId
	 * @param aclId
	 * @return
	 */
	private Acl findACL(String principalType,int principalId,int aclId){
		return this.aclDao.findACL(principalType, principalId, aclId);
	}

	
	/**
	 * 设置aclTriState的值
	 * @param userId 用户标识
	 * @param moduleId 模块标识
	 * @param yes 是否有效
	 */
	public void addOrUpdateUserExtends(int userId, int moduleId, boolean yes) {
		Acl acl = findACL(Acl.TYPE_USER,userId,moduleId);
		if(acl != null){
			acl.setExtends(yes);
			this.merge(acl);
			return;
		}
		acl = new Acl();
		acl.setPrincipalType(Acl.TYPE_USER);
		acl.setPrincipalId(userId);
		acl.setModuleId(moduleId);
		acl.setExtends(yes);
		this.add(acl);
	}
	
	
	/**
	 * 删除授权
	 * @param principalType
	 * @param principalId
	 * @param moduleId
	 */
	public void delPermission(String principalType, int principalId,
			int moduleId) {
		
		Map map=new HashMap();
		String hql="delete from Acl where principalType=:principalType and principalId=:principalId and moduleId=:moduleId";
		map.put("principalType", principalType);
		map.put("principalId", principalId);
		map.put("moduleId", moduleId);
		this.aclDao.executeUpdateHql(hql, map);
	}

	

	public boolean hasPermission(int userId, int moduleId, int permission) {
		
		//1.先检查用户TYPE_USER
		//根据用户标识和模块标识查找授权记录
		Acl acl = findACL(Acl.TYPE_USER,userId,moduleId);
		
		//有授权记录,也就是数据库存在该条记录
		if(acl != null){
			
			//把操作标识传过去，进行判断，看是否有对应的权限
			int yesOrNo = acl.getPermission(permission);
			
			//如果是确定的授权
			if(yesOrNo != Acl.ACL_NEUTRAL){
				
				//立刻返回，无需继续查找
				return yesOrNo == Acl.ACL_YES ? true : false;
			}
		}
		
		//2.继续查找用户拥有的角色的授权
		
		//查找分配给用户的角色，按优先级从高到低排序
		
		List roleIds = this.aclDao.findUserRoleByUID(userId);
		
		//依次根据角色标识和模块标识查找授权记录
		for (Iterator iterator = roleIds.iterator(); iterator.hasNext();) {
			Integer rid = (Integer) iterator.next();
			acl = findACL(Acl.TYPE_ROLE, rid, moduleId);
			if(acl != null){
				return acl.getPermission(permission) == Acl.ACL_YES ? true : false;
			}
		}
		
		return false;
	}
	
	/**
	 * 判断用户对某模块的某操作的授权（允许或不允许）
	 * @param userId 用户ID
	 * @param reourceSn 资源唯一标识（sn）
	 * @param permission 权限（C/R/U/D）
	 * @return 允许（true）或不允许（false）
	 */
	public boolean hasPermissionByResourceSn(int userId, String resourceSn, int permission) {
		
		String hql = "select m.id from Module m where m.sn = :sn ";
		Map map=new HashMap();
		map.put("sn", resourceSn);
		
		int moduleId=(Integer)this.aclDao.executeHql(hql, map);
		return hasPermission(userId,moduleId,permission);
	}
	
	
	
	/**
	 * 查询用户拥有读取权限的模块列表
	 * @param userId 用户标识
	 * @return 列表元素是Module对象
	 */
	public List searchModules(int userId) {
		
		List roleIds =aclDao.findUserRoleByUIDDesc(userId);;
		
		Map temp = new HashMap();
		
		//依次查找角色的授权（ACL对象）
		for (Iterator iterator = roleIds.iterator(); iterator.hasNext();) {
			Integer rid = (Integer) iterator.next();
			List acls = this.aclDao.findRoleAcls(rid);
			
			//循环对应角色的授权
			for (Iterator iterator2 = acls.iterator(); iterator2.hasNext();) {
				Acl acl = (Acl) iterator2.next();
				//把对应数据放入	数组<模块ID ,权根>
				temp.put(acl.getModuleId(), acl);
			}
		}
		
		//针对用户查找有效的用户授权
		List acls =aclDao.findUserAcls(userId); 
		for (Iterator iterator = acls.iterator(); iterator.hasNext();) {
			Acl acl = (Acl) iterator.next();
			temp.put(acl.getModuleId(), acl);
		}
		
		//去除掉那些没有读取权限的授权记录
		Set entries = temp.entrySet();
		for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
			Map.Entry entry = (Map.Entry) iterator.next();
			Acl acl = (Acl)entry.getValue();
			if(acl.getPermission(Permission.READ) != Acl.ACL_YES){
				iterator.remove();
			}
		}
		
		if(temp.isEmpty()){
			return new ArrayList();
		}
		
		return this.aclDao.searchModules(temp.keySet());
		
	}
	
	
	/**
	 * 根据权限类别，查找对应用户、角色的权限
	 * @param principalType
	 * @param principalId
	 * @return
	 */
	public List searchAclRecord(String principalType,int principalId){
		return aclDao.searchAclRecord(principalType, principalId);
	}
	
	

	
}
