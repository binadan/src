package com.gcflower.entity;

import java.util.HashSet;
import java.util.Set;


/**
 * Household entity. @author MyEclipse Persistence Tools
 */

public class Household  implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields    
     private Integer HId;
     private String HUsername;
     private String HUserpwd;
     private String HName;
     private String HEmail;
     private String HTel;
     private String HSex;
     private String HEmergenctel;
     private String HEmergencname;
     private String HEmergenctel1;
     private String HEmergencname1;
     private String HEmergenctel2;
     private String HEmergencname2;
     private String HNo;
  
     private Integer createTime;
     private Integer updateTime;
     private Set paymentmanagements = new HashSet(0);

     
    // Constructors



	public Integer getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}


	public Integer getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}


	/** default constructor */
    public Household() {
    }

    
    /** full constructor */
    public Household(Integer hId, String hUsername, String hUserpwd,
			String hName, String hEmail, String hTel, String hSex,
			String hEmergenctel, String hEmergencname, String hEmergenctel1,
			String hEmergencname1, String hEmergenctel2, String hEmergencname2,
			String hNo, Integer createTime,
			Integer updateTime) {
		super();
		HId = hId;
		HUsername = hUsername;
		HUserpwd = hUserpwd;
		HName = hName;
		HEmail = hEmail;
		HTel = hTel;
		HSex = hSex;
		HEmergenctel = hEmergenctel;
		HEmergencname = hEmergencname;
		HEmergenctel1 = hEmergenctel1;
		HEmergencname1 = hEmergencname1;
		HEmergenctel2 = hEmergenctel2;
		HEmergencname2 = hEmergencname2;
		HNo = hNo;
	
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
   
    // Property accessors

    public Integer getHId() {
        return this.HId;
    }
    
  


	public void setHId(Integer HId) {
        this.HId = HId;
    }

    public String getHUsername() {
        return this.HUsername;
    }

	public String getHNo() {
		return HNo;
	}


	public void setHNo(String hNo) {
		HNo = hNo;
	}


	public void setHUsername(String HUsername) {
        this.HUsername = HUsername;
    }

    public String getHUserpwd() {
        return this.HUserpwd;
    }
    
    public void setHUserpwd(String HUserpwd) {
        this.HUserpwd = HUserpwd;
    }

    public String getHName() {
        return this.HName;
    }
    
    public void setHName(String HName) {
        this.HName = HName;
    }

    public String getHEmail() {
        return this.HEmail;
    }
    
    public void setHEmail(String HEmail) {
        this.HEmail = HEmail;
    }

    public String getHTel() {
        return this.HTel;
    }
    
    public void setHTel(String HTel) {
        this.HTel = HTel;
    }

    public String getHSex() {
        return this.HSex;
    }
    
    public void setHSex(String HSex) {
        this.HSex = HSex;
    }

    public String getHEmergenctel() {
        return this.HEmergenctel;
    }
    
    public void setHEmergenctel(String HEmergenctel) {
        this.HEmergenctel = HEmergenctel;
    }

    public String getHEmergencname() {
        return this.HEmergencname;
    }
    
    public void setHEmergencname(String HEmergencname) {
        this.HEmergencname = HEmergencname;
    }

    public String getHEmergenctel1() {
        return this.HEmergenctel1;
    }
    
    public void setHEmergenctel1(String HEmergenctel1) {
        this.HEmergenctel1 = HEmergenctel1;
    }

    public String getHEmergencname1() {
        return this.HEmergencname1;
    }
    
    public void setHEmergencname1(String HEmergencname1) {
        this.HEmergencname1 = HEmergencname1;
    }

    public String getHEmergenctel2() {
        return this.HEmergenctel2;
    }
    
    public void setHEmergenctel2(String HEmergenctel2) {
        this.HEmergenctel2 = HEmergenctel2;
    }

    public String getHEmergencname2() {
        return this.HEmergencname2;
    }
    
    public void setHEmergencname2(String HEmergencname2) {
        this.HEmergencname2 = HEmergencname2;
    }

    public Set getPaymentmanagements() {
        return this.paymentmanagements;
    }
    
    public void setPaymentmanagements(Set paymentmanagements) {
        this.paymentmanagements = paymentmanagements;
    }


	@Override
	public String toString() {
		return "Household [HId=" + HId + ", HUsername=" + HUsername
				+ ", HUserpwd=" + HUserpwd + ", HName=" + HName + ", HEmail="
				+ HEmail + ", HTel=" + HTel + ", HSex=" + HSex
				+ ", HEmergenctel=" + HEmergenctel + ", HEmergencname="
				+ HEmergencname + ", HEmergenctel1=" + HEmergenctel1
				+ ", HEmergencname1=" + HEmergencname1 + ", HEmergenctel2="
				+ HEmergenctel2 + ", HEmergencname2=" + HEmergencname2
				+ ", paymentmanagements=" + paymentmanagements + "]";
	}
   








}