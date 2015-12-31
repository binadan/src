package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gcflower.dao.TearmDao;
import com.gcflower.entity.Tearm;
import com.gcflower.util.PageManager;

public class TearmService {
	
	private TearmDao tearmDao;

	
	public void setTearmDao(TearmDao tearmDao) {
		this.tearmDao = tearmDao;
	}


	/**
	 * 增
	 * @param menu
	 */
	public void add(Tearm tearm){
		
		
		
		this.tearmDao.save(tearm);
	}

	
	//根据父ID获取最大的编码
	private String searchMaxCode(int pid){
		String hql = "";
		Map map=new HashMap();
		if(pid==0){
			hql = "select Max(code) from Tearm p where p.parent is null";
		}else{
			hql = "select Max(code) from Tearm p where p.parent.id = :pid ";
			map.put("pid", pid);
		}
		String maxCode = (String)this.tearmDao.executeHql(hql,map);
		
		if(maxCode==null){
			hql = "select code from Tearm p where p.id = :pid ";
			maxCode = (String)this.tearmDao.executeHql(hql,map)+"001";
		}else{
			maxCode=ChangeNum(maxCode);
		}
		
		
		
		return maxCode;
	}
	
	/**
	 * 获取编码+1并返回,截取后三位出来+1，再和前段数字组合
	 * 
	 * @param date
	 * @return
	 */
	public  String ChangeNum(String num) {
		
		if (num == null) {
			return "001";
		}

		String lastNum = num.substring(num.length() - 3, num.length()); // 后段
		String frist=num.substring(0,num.length()-3);
		// 把后段转成数字类型
		int temp = Integer.parseInt(lastNum);
		temp = temp + 1;

		// 补0
		if (temp < 10) {
			// 一位
			return frist+"00" + temp;
		} else if (temp < 100) {
			// 两位位
			return frist+"0" + temp;
		} else {
			// 三位
			return frist+ + temp;
		}

	}
	
	
	/**
	 * 改
	 * @param tearm
	 */
	public void merge(Tearm tearm){
		
		if(tearm.getId()!=null && tearm.getId()!=0){
			//修改
		
		}else{
			//新增
			if(tearm.getParent()==null || tearm.getParent().getId()==null){
				tearm.setCode(this.searchMaxCode(0));
			}else{
				tearm.setCode(this.searchMaxCode(tearm.getParent().getId()));
			}
		}
		this.tearmDao.merge(tearm);
	}
	
	
	/**
	 * 删除
	 * @param tearm
	 */
	public void delete(Tearm tearm){
		this.tearmDao.delete(tearm);
	}
	
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	public void delete(int id){
		this.tearmDao.removeObject(Tearm.class, id);
	}
	
	/**
	 * 查所有
	 * @return
	 */
	public List<Tearm> findAll(){
		
		return this.tearmDao.findAll();
	}
	
	/**
	 * 根据ID查
	 * @param id
	 * @return
	 */
	public Tearm findById(int id){
		
		 return (Tearm)this.tearmDao.getObject(Tearm.class, id);
		
	}

	/**
	 * 删除组织
	 * @param orgId
	 * @return
	 */
	public String delOrg(int orgId) {
		Tearm org =this.findById(orgId);
		
		//判断是否存在下级组织
		if(org.getChildren().size() > 0){
			return "机构【"+org.getName()+"】下面存在子机构信息，不允许删除！";
		}
		
		String hql = "select count(*) from Salesman p where p.tearm.id = :orgId ";
		Map map=new HashMap();
		map.put("orgId", orgId);
	
		Long size = (Long)this.tearmDao.executeHql(hql,map);
			
		//判断组织下面是否存在人员
		if(size > 0){
			return "机构【"+org.getName()+"】下面存在人员信息，不允许删除！";
		}
		
		
		
		this.delete(orgId);
		
		return "SUCCESS";
	}


	/**
	 * 根据上级ID查询所以下级组织
	 * @param parentId
	 * @param page
	 */
	public void searchOrgs(int parentId,PageManager page) {
		
		String selectHql = "select o from Tearm o where o.parent is null";
		if(parentId != 0){
			selectHql = "select o from Tearm o where o.parent.id = "+parentId;
		}
		this.tearmDao.searchPaginated(selectHql,page);
	}
	
	
	/**
	 * 查询所有根目录
	 * @return
	 */
	public List<Tearm> findRootOrg(){
		return this.tearmDao.findRootOrg();
	}

}
