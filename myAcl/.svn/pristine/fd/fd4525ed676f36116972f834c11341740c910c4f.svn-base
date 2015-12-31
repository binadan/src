package com.gcflower.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 帐号
 * 类名称：User   
 * 创建人：解建谋   
 * @version
 */
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	
	/**
	 * 用户
	 */
	private Salesman person;
	
	/**
	 * 帐号 唯一
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 过期时间
	 */
	private Timestamp expireTime;


	// Constructors

	/** default constructor */
	public User() {
	}

	public User(int id){
		this.id=id;
	}
	
	/** minimal constructor */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public User(Salesman person, String username, String password,
			Timestamp createTime, Timestamp expireTime) {
		this.person = person;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.expireTime = expireTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Salesman getPerson() {
		return this.person;
	}

	public void setPerson(Salesman person) {
		this.person = person;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}

}