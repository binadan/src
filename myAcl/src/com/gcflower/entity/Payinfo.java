package com.gcflower.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.crypto.Data;

/**
 * 
 * @Title:
 * 
 * @ClassName:com.gcflower.entity.Paymentmanagement.java
 *
 * @author:屈碧勃
 *
 * @date:2015-6-1
 *
 */

public class Payinfo {
	private int PAY_ID;
	private int PAY_MONEY;
	private String PAY_DATE;
	private String PAY_NO;
	public int getPAY_ID() {
		return PAY_ID;
	}
	public void setPAY_ID(int pAY_ID) {
		PAY_ID = pAY_ID;
	}
	
	public int getPAY_MONEY() {
		return PAY_MONEY;
	}
	public void setPAY_MONEY(int pAY_MONEY) {
		PAY_MONEY = pAY_MONEY;
	}
	public String getPAY_DATE() {
		return PAY_DATE;
	}
	public void setPAY_DATE(String pAY_DATE) {
		PAY_DATE = pAY_DATE;
	}

	public String getPAY_NO() {
		return PAY_NO;
	}
	public void setPAY_NO(String pAY_NO) {
		PAY_NO = pAY_NO;
	}
	@Override
	public String toString() {
		return "Payinfo [PAY_ID=" + PAY_ID + ", PAY_MONEY=" + PAY_MONEY
				+ ", PAY_DATE=" + PAY_DATE + ", PAY_NO=" + PAY_NO + "]";
	}
	
	
	

}
