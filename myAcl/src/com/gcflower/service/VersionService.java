package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gcflower.dao.VersionDao;
import com.gcflower.entity.HostManagement;
import com.gcflower.entity.Version;
import com.gcflower.util.PageManager;


public class VersionService {

	private VersionDao versionDao;

	
	public VersionDao getVersionDao() {
		return versionDao;
	}

	public void setVersionDao(VersionDao versionDao) {
		this.versionDao = versionDao;
	}
	
	//查询所有
	public void searchVersion(int parentId,PageManager page){
		Map map=new HashMap();
		String hql="from Version order by v_time desc";
		this.versionDao.searchPaginated(hql, map, page);
		
	}
	
	//保存
	public void save(Version version){
		versionDao.save(version);
	}
	
	//删除
	private void delete(Version version) {
		this.versionDao.delete(version);
	}
	public String  del(int id){
		
		Version version=this.findById(id);		
		this.delete(version);
		return "success";
	}
	
	//修改
	public void update(Version version){
		versionDao.upd(version);
	}
	//ID查询
	public Version findById(int id){
		return (Version)versionDao.getObject(Version.class, id);
	}
}
