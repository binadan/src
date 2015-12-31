package com.gcflower.entity;


/**
 * 角色
 * 类名称：Role   
 * 创建人：解建谋
 * @version
 */
public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	
	/**
	 * 角色名
	 */
	private String name;

	// Constructors

	/** default constructor */
	public Role() {
	}

	public Role(int id){
		this.id=id;
	}
	
	/** full constructor */
	public Role(String name) {
		this.name = name;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}