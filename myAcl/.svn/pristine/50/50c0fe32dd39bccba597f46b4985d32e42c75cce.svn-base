package com.gcflower.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gcflower.entity.User;
import com.gcflower.service.AclService;
import com.gcflower.service.RoleService;
import com.gcflower.service.UserService;
import com.gcflower.util.PageManager;

public class UserAction extends BaseAction {
	protected Log log = LogFactory.getLog(UserAction.class);
	private static final long serialVersionUID = 1L;

	private PageManager page=new PageManager(10);
	private UserService userService;
	private RoleService roleService;
	private AclService aclService;
	private User data;
	
	private Integer id;
	private int userId;
	private int roleId;
	private int orderNo;
	private String username;
	private String password;

	private List list;
	private int result; 	//返回类型
	private String msg;
	
	/**
	 * 打开用户管理主界面
	 * @return
	 */
	public String serarchUser(){
		
		this.userService.searchUsers(page);
		return "index";
	}
	
	
	
	/**
	 * 打开用户管理录入界面
	 */
	public String addInputUser(){
		
		return "add_input";
	}

	/**
	 * 检查用户名的唯 一性
	 * @return
	 */
	public String checkUserName(){
		//中文乱码处理
		try {
			username = java.net.URLDecoder.decode(username, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			
		}
		
		
		data=this.userService.checkUser(username);
		return "pub_check";
	}
	
	/**
	 * 录入
	 * @return
	 */
	public String add(){
		try {
			
			data.setCreateTime(new Timestamp(new java.util.Date().getTime()));
			this.userService.add(data);
			result=1;
		} catch (Exception e) {
			result=0;
		}
		
		return "pub_add_success";
	}
	
	
	/**
	 * 打开用户管理修改界面
	 * @return
	 */
	public String updateInput(){
		data=this.userService.findById(id);
		return "update_input";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		try{
			this.userService.merge(data);
			result=1;
		}catch (Exception e) {
			result=0;
		}
		
		return "pub_update_success";
	}
	
	
	/**
	 * 删除用户帐号
	 * @return
	 */
	public String delete(){
		msg=this.userService.delete(id);
		return "pub_delete_success";
	
	}

	
	
	/**
	 * 打开用户已有角色的列表页面，在页面上需要显示：用户的姓名、以及用户已拥有的角色列表
	 */
	public String userRoleList(){
		list = userService.searchUserRolesByUserId(id);
		return "user_role_list";
	}
	
	
	//打开给用户分配角色页面：即从角色列表中选择某个角色，并设置优先级
	public String userRoleInput(){
		list=roleService.findAll();
		data=userService.findById(id);
		
		return "user_role_input";
	}
	
	
	//给用户分配角色：页面上需要传递过来的参数包括：用户标识、角色标识、优先级
	public String addUserRole(){
		try{
			this.userService.addOrUpdateUserRole(userId, roleId, orderNo);
			result=1;
		}catch (Exception e) {
			// TODO: handle exception
			result=0;
		}
		
		return "pub_add_success";
	}
	

	//删除分配给用户的角色，页面上需要传输过来的参数包括：用户标识、角色标识
	public String deluserRole(){
		try{
			this.userService.delUserRole(userId, roleId);
			result=1;
		}catch (Exception e) {
			// TODO: handle exception
			result=0;
		}
		
		return "pub_del_success";
	}
	
	
	/**
	 * 修改用户角色的优先级
	 * @return
	 */
	public String updateUserRoleNo(){
		try{
			this.userService.updateURNo(userId, roleId,orderNo);
			result=1;
		}catch (Exception e) {
			// TODO: handle exception
			result=0;
		}
		
		return "pub_update_success";
	}
	
	//登陆
	public String login() throws Exception{
		
		data=this.userService.login(username, password);
		result=1;
		
		if(data == null){
			result=2;		//没有这个用户 
		}else if(!data.getUsername().equals(username)){
			result=3;		//账户错误
		}else if(!data.getPassword().equals(password)){
			result=4;		//密码错误
		}else if(data.getExpireTime() != null){
			//现在时间
			Calendar now = Calendar.getInstance();
			//失效时间
			Calendar expireTime = Calendar.getInstance();
			expireTime.setTime(data.getExpireTime());
			//如果现在在失效时间之后
			if(now.after(expireTime)){
				
				result= 5;	//用户帐号已失效
			}
		}
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			list=aclService.searchModules(data.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		session.put("sessionModules", list);
		session.put("sessionUser", data);
		
		return "login";
	}
		
	/**
	 * 退出
	 * @return
	 */
	public String loginOut(){
		session.clear();
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	/******************************************************************************************************
	 * 封装字段
	 */
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getData() {
		return data;
	}
	public void setData(User data) {
		this.data = data;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public AclService getAclService() {
		return aclService;
	}

	public void setAclService(AclService aclService) {
		this.aclService = aclService;
	}

	public PageManager getPage() {
		return page;
	}

	public void setPage(PageManager page) {
		this.page = page;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
