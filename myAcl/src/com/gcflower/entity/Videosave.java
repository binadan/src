package com.gcflower.entity;

/**
 * 
 * 
 * 
 * 
 * 
 * Title:  Videosave.java
 * 
 * 
 * Description:com.gcflower.entity.Videosave.java
 * 
 * 
 * Copyright: Copyright (c) j2se 6.0
 * 
 * 
 * date: 2015-6-11
 * 
 * 
 * Company: 西安宇明科技
 * 
 * 
 * @author 田凯
 */

public class Videosave implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2491729598057378571L;

	// Fields

	private Integer Vid;//视频ID
	private String Vname;//视频名称
	private Integer Vmid;//报警ID
	private Integer Vlid;//报警类型ID
	private String Vadd;//视频路径
	private String Vhoeid;//监控设备id
	private String Vshebeiname;//监控名称
	private String Vvideostart;//视频开始录制时间
	
	/**
	 * 视频名称
	 * @return
	 */
	public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}
	/**
	 * 视频ID get/set 方法
	 * @return
	 */
	public Integer getVid() {
		return Vid;
	}
	public void setVid(Integer vid) {
		Vid = vid;
	}
	
	/**
	 * 报警ID get/set 方法
	 * @return
	 */
	public Integer getVmid() {
		return Vmid;
	}
	public void setVmid(Integer vmid) {
		Vmid = vmid;
	}
	
	/**
	 * 报警类型ID get/set 方法
	 * @return
	 */
	public Integer getVlid() {
		return Vlid;
	}
	public void setVlid(Integer vlid) {
		Vlid = vlid;
	}
	
	/**
	 * 视频路径 get/set 方法
	 * @return
	 */
	public String getVadd() {
		return Vadd;
	}
	public void setVadd(String vadd) {
		Vadd = vadd;
	}
	
	/**
	 * 监控设备id
	 * @return
	 */
	public String getVhoeid() {
		return Vhoeid;
	}
	public void setVhoeid(String vhoeid) {
		Vhoeid = vhoeid;
	}
	/**
	 * 监控名称
	 * @return
	 */
	public String getVshebeiname() {
		return Vshebeiname;
	}
	public void setVshebeiname(String vshebeiname) {
		Vshebeiname = vshebeiname;
	}
	/**
	 * 视频开始录制时间
	 * @return
	 */
	public String getVvideostart() {
		return Vvideostart;
	}
	public void setVvideostart(String vvideostart) {
		Vvideostart = vvideostart;
	}
	/**
	 * toString 方法
	 */
	@Override
	public String toString() {
		return "Videosave [Vid=" + Vid + ", Vname=" + Vname + ", Vmid=" + Vmid
				+ ", Vlid=" + Vlid + ", Vadd=" + Vadd + ", Vhoeid=" + Vhoeid
				+ ", Vshebeiname=" + Vshebeiname + ", Vvideostart="
				+ Vvideostart + "]";
	}
	
	/**
	 * 无参构造方法
	 */
	public Videosave() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Constructors
	
	
}
	

