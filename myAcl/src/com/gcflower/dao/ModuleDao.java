package com.gcflower.dao;

import java.util.List;
import com.gcflower.entity.*;
import com.gcflower.entity.Module;
public class ModuleDao extends BaseDao{
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Module> findAll(){
		
		return (List<Module>)getHibernateTemplate().find("from Module order by id");
		
	}


	/**
	 * 查询所有一级模块
	 * @return
	 */
	public List<Module> findAllRoot(){
		
		return (List<Module>)getHibernateTemplate().find("from Module where parent is null order by orderNo");
		
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
	public int checkModuleSN(String sn){
		List ul=getHibernateTemplate().find("from Module where sn= ?",new Object[]{sn});
	    if(ul!=null && ul.size()>=1){
	    	return 1;
	    }
	    return 0;
	}
	
	
	/**
	 * 
	 * @Title: checkModuleSN
	 * @Description: TODO(查询模块排序号是否重复)
	 * @param sn
	 * @return 
	 * @return int    返回类型 重复：1 不重复：0
	 * @throws
	 */
	public int checkModuleNo(int orderNo){
		List ul=getHibernateTemplate().find("from Module where orderNo= ?",new Object[]{orderNo});
	    if(ul!=null && ul.size()>=1){
	    	return 1;
	    }
	    return 0;
	}
}
