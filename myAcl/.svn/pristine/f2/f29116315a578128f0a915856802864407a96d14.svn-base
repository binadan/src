package com.gcflower.entity;

/**
 * 权限控制
 * 类名称：Acl   
 * 创建人：解建谋
 * @version
 */
public class Acl implements java.io.Serializable {

	private Integer id;
	
	/**
	 * 权限类别：角色、用户
	 */
	private String principalType;
	
	/**
	 * 角色ID
	 */
	private int principalId;
	
	/**
	 * 模块ID
	 */
	private int moduleId;
	
	/**
	 * 权限级别
	 */
	private int aclState;
	
	/**
	 * 有效性
	 */
	private int aclTriState;

	
	
	public static final String TYPE_ROLE = "Role";
	public static final String TYPE_USER = "User";
	
	/**
	 * ACL的状态为继承（即无效，判断的时候应该判断其所属角色的授权）
	 */
	public static final int ACL_TRI_STATE_EXTENDS = 0xFFFFFFFF;
	
	/**
	 * ACL的状态为不继承（即有效，判断的时候，直接根据aclState判断授权）
	 */
	public static final int ACL_TRI_STATE_UNEXTENDS = 0;
	
	
	/**
	 * 授权允许
	 */
	public static final int ACL_YES = 1;
	
	/**
	 * 授权不允许
	 */
	public static final int ACL_NO = 0;
	
	/**
	 * 授权不确定
	 */
	public static final int ACL_NEUTRAL = -1;
	
	
	public void setPermission(int permission,boolean yes){
	
		int temp = 1;
		temp = temp << permission;
		if(yes){
			aclState |= temp;
		}else{
			aclState &= ~temp;
		}
	
	}
	
	
	/**
	 * 判断对应的操作是否有权限
	 * @param permission
	 * @return
	 */
	public int getPermission(int permission){
		
		//如果ACL的状态为继承，则返回授权不确定
		if(aclTriState == ACL_TRI_STATE_EXTENDS){
			return ACL_NEUTRAL;
		}
		
		int temp = 1;
		
		/*移位运算
		移位运算符的面向对象也是二进制的“位”。
		左移位运算符，用符号“<<”表示。它是将运算符左边的对象向左移运动运算符右边指定的位数（在低位补0）。
		int a = 15;
     	int b = 2;
     	int x = a << b; 
		结果是60：15二进制为1111，左移2位 变成111100 =60（60的二进制为111100）
		*/

		temp = temp << permission;
		
		/*
		     位与逻辑    temp &= aclState
		  temp=temp & aclState
		     位的“与”，用符号“&”表示，它属于二元运算符。 与位运算值表：
			A	B	A&B
 			1	1	1
 			1	0	0
 			0	1	0
 			0	0	0
		 */
		temp &= aclState;
		
		if(temp != 0){
			return ACL_YES;
		}
		return ACL_NO;
	}
	
	/**
	 * 设置ACL的继承状态
	 * @param yes true标识继承，false表示不继承
	 */
	public void setExtends(boolean yes){
		if(yes){
			aclTriState = ACL_TRI_STATE_EXTENDS;
		}else{
			aclTriState = ACL_TRI_STATE_UNEXTENDS;
		}
	}
	


	
	
	
	// Constructors

	/** default constructor */
	public Acl() {
	}

	/** full constructor */
	public Acl(String principalType, Integer principalId, Integer moduleId,
			Integer aclState, Integer aclTriState) {
		this.principalType = principalType;
		this.principalId = principalId;
		this.moduleId = moduleId;
		this.aclState = aclState;
		this.aclTriState = aclTriState;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrincipalType() {
		return this.principalType;
	}

	public void setPrincipalType(String principalType) {
		this.principalType = principalType;
	}

	public Integer getPrincipalId() {
		return this.principalId;
	}

	public void setPrincipalId(Integer principalId) {
		this.principalId = principalId;
	}

	public Integer getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getAclState() {
		return this.aclState;
	}

	public void setAclState(Integer aclState) {
		this.aclState = aclState;
	}

	public Integer getAclTriState() {
		return this.aclTriState;
	}

	public void setAclTriState(Integer aclTriState) {
		this.aclTriState = aclTriState;
	}

}