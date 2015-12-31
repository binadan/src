package com.gcflower.entity;

/**
 * 
 * @Title: 主机管理 HostManagement.java
 * @Package com.gcflower.entity
 * @Description: TODO
 * @author 田凯
 * @date 2015-5-19
 */

public class HostManagement {

	private int M_ID; // 主机ID

	private String M_HOUSEID;// 房屋ID

	private String M_IP;// 主机IP地址

	private String M_STATE;// 主机状态

	private String P_STATE;

	private String M_MANUAL;// 手动输入主机编号
	
	private String M_KEFUZHANGHAO; //客服账号
	
	private String M_KEFUNAME;//客服姓名
	
	private String M_KEFUTEL;//客服电话
	
	private String deviceName;

	private String appId;

	private String deviceDesc;

	private Integer bufanglearmed;

	private Integer chefanglearmed;

	private String createTime;

	private String updateTime;

	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getDeviceDesc() {
		return deviceDesc;
	}

	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}

	public Integer getBufanglearmed() {
		return bufanglearmed;
	}

	public void setBufanglearmed(Integer bufanglearmed) {
		this.bufanglearmed = bufanglearmed;
	}

	public Integer getChefanglearmed() {
		return chefanglearmed;
	}

	public void setChefanglearmed(Integer chefanglearmed) {
		this.chefanglearmed = chefanglearmed;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getP_STATE() {
		return P_STATE;
	}

	public void setP_STATE(String p_STATE) {
		P_STATE = p_STATE;
	}

	private int P_ID;

	public String getM_MANUAL() {
		return M_MANUAL;
	}

	public void setM_MANUAL(String m_MANUAL) {
		M_MANUAL = m_MANUAL;
	}

	public int getP_ID() {
		return P_ID;
	}

	public void setP_ID(int p_ID) {
		P_ID = p_ID;
	}

	public String getM_KEFUZHANGHAO() {
		return M_KEFUZHANGHAO;
	}

	public void setM_KEFUZHANGHAO(String m_KEFUZHANGHAO) {
		M_KEFUZHANGHAO = m_KEFUZHANGHAO;
	}



	public String getM_KEFUNAME() {
		return M_KEFUNAME;
	}

	public void setM_KEFUNAME(String m_KEFUNAME) {
		M_KEFUNAME = m_KEFUNAME;
	}

	public String getM_KEFUTEL() {
		return M_KEFUTEL;
	}

	public void setM_KEFUTEL(String m_KEFUTEL) {
		M_KEFUTEL = m_KEFUTEL;
	}

	/**
	 * 生成对应get/set方法
	 * 
	 * @return
	 */
	public int getM_ID() {
		return M_ID;
	}

	public void setM_ID(int m_ID) {
		M_ID = m_ID;
	}

	public String getM_HOUSEID() {
		return M_HOUSEID;
	}

	public void setM_HOUSEID(String m_HOUSEID) {
		M_HOUSEID = m_HOUSEID;
	}

	public String getM_IP() {
		return M_IP;
	}

	public void setM_IP(String m_IP) {
		M_IP = m_IP;
	}

	public String getM_STATE() {
		return M_STATE;
	}

	public void setM_STATE(String m_STATE) {
		M_STATE = m_STATE;
	}



	
	public HostManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 生成带参构造方法
	 * 
	 * @param m_ID
	 * @param m_HOUSEID
	 * @param m_IP
	 * @param m_STATE
	 * @param m_ARREARAGE
	 */
	/**
	 * 生成无参构造方法
	 */
	public HostManagement(int m_ID, String m_HOUSEID, String m_IP,
			String m_STATE, String p_STATE, int p_ID) {
		super();
		M_ID = m_ID;
		M_HOUSEID = m_HOUSEID;
		M_IP = m_IP;
		M_STATE = m_STATE;
		P_STATE = p_STATE;
		P_ID = p_ID;
	}
	/**
	 * 生成toString方法
	 */
	@Override
	public String toString() {
		return "HostManagement [M_ID=" + M_ID + ", M_HOUSEID=" + M_HOUSEID
				+ ", M_IP=" + M_IP + ", M_STATE=" + M_STATE + ", P_STATE="
				+ P_STATE + ", P_ID=" + P_ID + "]";
	}

}
