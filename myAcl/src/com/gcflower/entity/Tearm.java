package com.gcflower.entity;

import java.util.Set;

/**
 * 部门
 * 类名称：Tearm   
 * 创建人：解建谋
 * @version
 */
public class Tearm implements java.io.Serializable {

	// Fields
	
	/**
	 * Id
	 */
	private Integer id;
	
	
	/**
	 * 部门名称
	 */
	private String name;
	
	/**
	 * sn
	 */
	private String sn;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 上级部门
	 */
	private Tearm parent;
	
	private int parentid;
	
	/**
	 * 编码
	 */
	private String code;
	
	
	/**
	 * 下级部门
	 */
	private Set children;


	
	//构造方法
	
	/** default constructor */
	public Tearm() {
	}

	/** full constructor */
	public Tearm(String name, String sn,
			String description, Tearm parent, Set children) {
		this.name = name;
		this.sn = sn;
		this.description = description;
		this.parent = parent;
		this.children = children;
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

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tearm getParent() {
		return parent;
	}

	public void setParent(Tearm parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	
	public int getParentid() {
		
		if(parent!=null){
			return parent.getId();
		}
		return 0;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



}