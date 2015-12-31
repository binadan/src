package com.gcflower.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.dao.DataAccessException;

import com.gcflower.entity.HostManagement;
import com.gcflower.entity.HostManagement1;
import com.gcflower.entity.Household;
import com.gcflower.entity.LarumSearchForm;
import com.gcflower.entity.Laruminfo;
import com.gcflower.entity.Salesman;
import com.gcflower.entity.User;
import com.gcflower.util.PageManager;

/**
 * 住户信息dao
 * 
 * Description:com.gcflower.dao.HouseholdDao.java
 *
 * @author 屈碧勃
 *
 */
@SuppressWarnings("unchecked")
public class HouseholdDao extends BaseDao{
	/**
	 * 查询所有
	 * @return
	 */
	public List<Household> findAll(){
		return (List<Household>)getHibernateTemplate().find("from Household ");
	}
	/**
	 * 增加
	 * @param household
	 */
	public void addHouser(Household household){
		try {
			getHibernateTemplate().save(household);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除
	 * @param household
	 */
	public void delHouser(Household household){
		this.getHibernateTemplate().delete(household);
	}

	/**
	 * 修改
	 * @param household
	 */
	public void updHouser(Household household){
		this.getHibernateTemplate().update(household);
		
	}
    public List<Household> findHouse(Household household){
		
		return (List<Household>)getHibernateTemplate().find("from Household where H_USERNAME = '"+household.getHUsername()+"'");
	}
	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	public Household findById(int id){
		List listH =getHibernateTemplate().find("from Household where HId=? ",
				new Object[]{id});
		if(listH !=null && listH.size()>=1){
			return (Household)listH.get(0);
		}
		return null;
	}
	public Household findId(Household household){
		 return (Household)getHibernateTemplate().find("from Household where HId = ? ");
	}
	/**
	 * 根据条件检索报警信息
	 * @param formBean 查询条件
	 *  @param page 分页
	 * @return
	 */
 public List selectHouse(Household household,PageManager page){
		
		StringBuffer sql=new StringBuffer("SELECT * FROM household h where 1=1");
	    if(household!=null ){
	    	//住户姓名
	    	if(household.getHName()!=null && !("".equals(household.getHName().trim()))){
	    		sql.append(" and h_name like '%"+household.getHName().trim()+"%'");	    		
	    	}//household.getHName()
	   
	
	    }
		SQLQuery query =getSession().createSQLQuery(sql.toString());
	    int total = query.list().size();
	    
		query.setFirstResult((page.getPage()-1)*page.getMaxResults());
		query.setMaxResults(page.getMaxResults());
		//结果数据
		List list =  query.addEntity("h", Household.class).list();
		//获取记录总数
		//把查询结果赋于分页类
		page.setDatas(list);
		page.setRecordTotal(total); 
        return list;
	   
	}

}
