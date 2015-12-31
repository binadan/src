package com.gcflower.dao;

import java.util.List;

import com.gcflower.entity.Version;

public class VersionDao extends BaseDao {


	
	/**
	 * 添加
	 * @param version
	 */
	public void save(Version version){
		try{
			super.save(version);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 删除
	 * @param version
	 */
	public void del(Version version){
		try{
			super.delete(version);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * 修改
	 * @param version
	 */
	public void upd(Version version){
		try{
			super.update(version);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public Version findVersion(String id){
		String hql="from Version where v_id="+id;
		List listV=this.getHibernateTemplate().find(hql);
		
		if(listV!=null && listV.size()>0){
			
			return (Version)listV.get(0);
		}
		else{
			
			return null;
		}		
	}
	
}
