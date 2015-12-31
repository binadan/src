package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gcflower.dao.ModuleDao;
import com.gcflower.entity.Module;
import com.gcflower.util.PageManager;

@SuppressWarnings("unchecked")
public class ModuleService {
	
	private ModuleDao moduleDao;

	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}
	
	
	/**
	 * 增
	 * @param menu
	 */
	public void add(Module module){
		this.moduleDao.save(module);
	}

	
	/**
	 * 改
	 * @param module
	 */
	public void merge(Module module){
		this.moduleDao.merge(module);
	}
	
	
	/**
	 * 删除
	 * @param module
	 */
	private void delete(Module module){
		this.moduleDao.delete(module);
	}
	
	
	/**
	 * 根据ID删除
	 * @param id
	 */
	private void delete(int id){
		this.moduleDao.removeObject(Module.class, id);
	}
	
	/**
	 * 查所有
	 * @return
	 */
	public List<Module> findAll(){
		
		return this.moduleDao.findAll();
	}
	
	/**
	 * 根据ID查
	 * @param id
	 * @return
	 */
	public Module findById(int id){
		
		 return (Module)this.moduleDao.getObject(Module.class, id);
		
	}

	/**
	 * 删除
	 * @param moduleId
	 * @return
	 */
	public String delModule(int moduleId){
		Module module=this.findById(moduleId);
		if(module.getChildren().size()>0){
			return "模块【"+module.getName()+"】存在有子模块，不允许删除！";
		}
		
		this.delete(module);
		return "SUCCESS";
		
	}


	/**
	 * 分页查询
	 * @param parentId
	 * @param page
	 */
	public void searchModules(int parentId,PageManager page){
		String hql="select m from Module m";
		Map map=new HashMap();
		if(parentId==0){
			hql+=" where m.parent is null order by orderNo";
		}else{
			hql+=" where m.parent.id = :parentId order by orderNo";
			map.put("parentId", parentId);
		}
		
		
		this.moduleDao.searchPaginated(hql,map, page);
	}
	
	
	/**
	 * 获取所有模块一级模块
	 * @return
	 */
	public List<Module> searchRootModules(){
		return this.moduleDao.findAllRoot();
	}


	/**
	 * 
	 * @Title: checkModuleSN
	 * @Description: TODO(查询模块SN标识码是否重复)
	 * @param sn
	 * @return 
	 * @return int    返回类型 重复：1 不重复：0
	 * @throws
	 */
	public int checkmoduleSN(String sn){
		return this.moduleDao.checkModuleSN(sn);
	}
	
	/**
	 * 
	 * @Title: checkModuleNo
	 * @Description: TODO(检查模块排序号是否重复)
	 * @param orderNo
	 * @return 
	 * @return int    返回类型
	 * @throws
	 */
	public int checkModuleNo(int orderNo){
		return this.moduleDao.checkModuleNo(orderNo);
	}
	
}
