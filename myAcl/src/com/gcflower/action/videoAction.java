package com.gcflower.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gcflower.entity.Videosave;
import com.gcflower.service.videoService;
import com.gcflower.util.PageManager;
/**
 * ACTION 视频模块
 * @author 田凯
 *
 */
public class videoAction extends BaseAction {

	/*
	 * 自定義log
	 */
	protected Log log = LogFactory.getLog(videoAction.class);
	/*
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private int Vid;//视频ID
	private Videosave vide = new Videosave();//实例化对象
	private videoService videoService;//service注入
	private List<Videosave> list;//定义一个LIST集合
	private String ids; //id串
	

	private int result;//定义一个int类型的接收返回值的属性
	private String msg;
	private Integer id;
	private PageManager page = new PageManager(10);//分页实例化

	public int getVid() {
		return Vid;
	}

	public void setVid(int vid) {
		Vid = vid;
	}

	public PageManager getPage() {
		return page;
	}

	public void setPage(PageManager page) {
		this.page = page;
	}

	private String uploadFileName;// 上传文件名
	private String upload;// 实际上传文件
	private String uploadContentType;// 文件的内容类型

	public String getUpload() {
		return upload;
	}

	public void setUpload(String upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<Videosave> getList() {
		return list;
	}

	public void setList(List<Videosave> list) {
		this.list = list;
	}

	public Videosave getVide() {
		return vide;
	}

	public void setVide(Videosave vide) {
		this.vide = vide;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	/**
	 * 查詢所有方法带分页
	 */
	public String findAll() {
		try {
			System.out.println("1111111");
			if (id == null) {
				id = 0;
			}
			this.videoService.searchVideosave(id, page);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "index";
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String addvideo() {
		// if (uploadFileName != null && uploadFileName.trim()!="") {

		// 上传到的路径
		try {
			ServletActionContext.getRequest().getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path0 = ServletActionContext.getServletContext().getRealPath(
				"\\upvideo");
		String path00=path0+"\\"+this.getUploadFileName();
		System.out.println(path0);
		
		String comm=ServletActionContext.getRequest().getLocalAddr();
		String path="http://"+comm+":8080"+ServletActionContext.getRequest().getContextPath();
		String path1=path+"/upvideo/"+this.getUploadFileName();
		
		File newFile = new File(path00);
		InputStream in = null;
		OutputStream out = null;
		vide.setVadd(path1);
		this.videoService.addvideo(vide);

		try {
			in = new FileInputStream(this.getUpload());
			out = new FileOutputStream(newFile);
			byte b[] = new byte[in.available()];
			in.read(b);
			out.write(b);
			out.flush();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		result = 1;
		return "uploadSuccess";
	}

	/*
	 * 刪除
	 */
	public String delete() {
		try {
			msg = this.videoService.delete(Vid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		return "delete";
	}

	//批量删除
	public String delVideos(){
		System.out.println(ids);
		String str[]=ids.split("/");
		try{
			for(int i=0;i<str.length;i++){
				this.videoService.delete(Integer.parseInt(str[i]));
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		
		return "delete";
	}
	
	public String findByIdVideo() {
		
		//System.out.println("5454454");
		try {
			
			vide = this.videoService.findByIdVideo(Vid);
			System.out.println(vide);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return SUCCESS;

	}

	public videoService getVideoService() {
		return videoService;
	}

	public void setVideoService(videoService videoService) {
		this.videoService = videoService;
	}

}
