package com.gcflower.entity;

/**
 * 角色用户
 * 类名称：UsersRoles   
 * 类描述：   用户分配角色，允许用户拥有多个角色，根据UsersRoles进行优先
 * 创建人：解建谋   
 * @version
 */
public class UsersRoles implements java.io.Serializable {

	// Fields

	private Integer id;
	
	/**
	 * 角色
	 */
	private Role role;
	
	/**
	 * 用户帐号
	 */
	private User user;
	
	/**
	 * 排序
	 */
	private Integer orderNo;

	// Constructors

	/** default constructor */
	public UsersRoles() {
	}

	/** full constructor */
	public UsersRoles(Role role, User user, Integer orderNo) {
		this.role = role;
		this.user = user;
		this.orderNo = orderNo;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}