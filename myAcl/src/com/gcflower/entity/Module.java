package com.gcflower.entity;

import java.util.Set;

/**
 * 模块
 * 类名称：Module   
 * 创建人：解建谋   
 * @version
 */
public class Module implements java.io.Serializable {

	// Fields

	private Integer id;

	/**
	 * 模块名称
	 */
	private String name;
	
	/**
	 * 模块URL
	 */
	private String url;
	
	/**
	 * 排序
	 */
	private Integer orderNo;
	
	/**
	 * sn
	 */
	private String sn;
	
	/**
	 * 上级
	 */
	private Module parent;
	
	/**
	 * 下级集合
	 */
	private Set children;
	
	private boolean open=true;
	// Constructors

	/** default constructor */
	public Module() {
	}

	public Module(int id){
		this.id=id;
	}
	/** full constructor */
	public Module(Module parent, String name, String url, Integer orderNo,
			String sn, Set children) {
		this.parent = parent;
		this.name = name;
		this.url = url;
		this.orderNo = orderNo;
		this.sn = sn;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}


}