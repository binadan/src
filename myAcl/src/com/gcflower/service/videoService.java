package com.gcflower.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.gcflower.dao.videoDao;
import com.gcflower.entity.Videosave;
import com.gcflower.util.PageManager;
/**
 * service层
 * @author 田凯
 *
 */
public class videoService {
	
    /**
     * 注入dao
     */
	private videoDao videodao;
	
	public videoDao getVideodao() {
		return videodao;
	}
	public void setVideodao(videoDao videodao) {
		this.videodao = videodao;
	}
	/*
	 * 查询所有方法
	 */
	public void searchVideosave(int parentId, PageManager page) {
		String hql = "from Videosave";
		Map map = new HashMap();

		this.videodao.searchPaginated(hql, map, page);
	}

	
	public List<Videosave>findAll(){
		
		return videodao.findAll();
		
	}
	
	/**
	 * 根據ID刪除
	 */
	public String delete(int id){
		Videosave vide=this.findByIdVideo(id);
		this.delete(vide);
		return "SUCCESS";
		
	}
	/**
	 * 删除
	 * @param vide
	 */
	public void delete(Videosave vide){
		videodao.delete(vide);
	}
	
	/**
	 * 查詢单个方法
	 */
	public Videosave findByIdVideo(int id) {
		 return (Videosave)this.videodao.getObject(Videosave.class, id);
	}

	/**
	 * 添加方法
	 */
    public void addvideo(Videosave vide){
		try {
			this.videodao.addvideo(vide);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
