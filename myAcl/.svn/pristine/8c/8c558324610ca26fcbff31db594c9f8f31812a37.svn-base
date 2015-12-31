package com.gcflower.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.gcflower.entity.Version;
import com.gcflower.service.VersionService;
import com.gcflower.util.PageManager;




public class VersionAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	protected Log log=LogFactory.getLog(Version.class);
	
	private PageManager page=new PageManager(10);

	//private List listV;
	private VersionService versionService;	
	private Integer id;
	

	private int v_id;
	private Version version;
	private int result;
	private String host;
	private String ids;
	
		//临时文件名。temp
		private String upload;
		//真实文件名
		private String uploadFileName;
		//文件内容类型
		private String uploadContentType;
		
		
	
	
	/**
	 * 
	 * 添加即上传
	 * @return
	 */
	public String addVersion(){
		
		System.out.println("==============================");
		System.out.println(this.getUpload());
		System.out.println(this.getUploadFileName());
		System.out.println(this.getUploadContentType());
		
		//在工程下保存的地址
		String path0=ServletActionContext.getServletContext().getRealPath("\\upload");
		String path00=path0+"\\"+this.getUploadFileName();				
		
		//在数据库中保存的地址      http://localhost:8080/myAcl/Untitled.uml
		String comm=ServletActionContext.getRequest().getLocalAddr();
		String path="http://"+comm+":8080"+ServletActionContext.getRequest().getContextPath();
		String path1=path+"/upload/"+this.getUploadFileName();
		
		version.setV_time(new Date());
		version.setV_url(path1);
		this.versionService.save(version);
		
		InputStream in=null;
		OutputStream out=null;
		//生成文件
		File newFile=new File(path00);
						 
		//读  写 操作
		 
				try {
					 in=new FileInputStream(this.getUpload());
					 out=new FileOutputStream(newFile);
					 byte b[]=new byte[1024*10];
					
					 while(in.read(b)!=-1){
						 out.write(b);
					 }
					 
					 out.flush();
					 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}finally{
					
					try {
						out.close();
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
							 
				}	
				result=1;
				return "uploadSuccess";
		
	}
	
	
	/**
	 * 查找所有记录
	 * @return
	 */
	public String findAllVervion(){
				
		if (id == null) {
			id = 0;
		}
		
		this.versionService.searchVersion(id, page);
		return "index";
	}
	/**
	 * 
	 * 单个查询
	 * @return
	 */
	public String queryById(){
		System.out.println("v_id--->"+v_id);
	
		try{
			version=(Version)this.versionService.findById(v_id);
					
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return "success";
	}
	/**
 	* 修改
 	* @return
 	*/
	public String updVersion(){
		System.out.println("*******"+version.toString());
		System.out.println(version.getV_id());
		try{
			this.versionService.update(version);
			result=1;
		}catch(Exception e){
			e.printStackTrace();
			result=0;
		}
		return "updVersion";
	}
	//删除
	public String del(){
		try{
			System.out.println("id--->>"+v_id);
			host=this.versionService.del(v_id);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	//多选
	public String delAllVersion(){
		System.out.println(ids);
		String str[]=ids.split(",");
		try{			
			for(int i=0;i<str.length;i++){
				
				this.versionService.del(Integer.parseInt(str[i]));
			}					
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
	
	public PageManager getPage() {
		return page;
	}


	public void setPage(PageManager page) {
		this.page = page;
	}


	public Version getVersion() {
		return version;
	}


	public void setVersion(Version version) {
		this.version = version;
	}


	public VersionService getVersionService() {
		return versionService;
	}


	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}
	public Log getLog() {
		return log;
	}


	public void setLog(Log log) {
		this.log = log;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}


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
	
	
}
