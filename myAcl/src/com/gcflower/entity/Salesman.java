package com.gcflower.entity;

/**
 * 用户（员工）
 * 类名称：Salesman   
 * 类描述：   
 * 创建人：解建谋  
 * @version
 */
public class Salesman  implements java.io.Serializable {


    // Fields    

     private Integer id;
     
     /**
      * 姓名
      */
     private String name;
     
     /**
      * 性别
      */
     private String sex;
     
     /**
      * 年龄
      */
     private Integer age;
     
     /**
      * 地址
      */
     private String address;
     
     /**
      * 职务
      */
     private String duty;
     
     /**
      * 手机
      */
     private String phone;
     
     /**
      * 部门
      */
     private Tearm tearm;
     
     
     /**
      * 帐号
      */
     private User user;


    // Constructors

    /** default constructor */
    public Salesman() {
    }

    
    /** full constructor */
    public Salesman(Tearm tearm, String name, String sex, Integer age, String address, String duty, String phone, User user) {
        this.tearm = tearm;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.duty = duty;
        this.phone = phone;
        this.user = user;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }


    public Tearm getTearm() {
		return tearm;
	}


	public void setTearm(Tearm tearm) {
		this.tearm = tearm;
	}


	public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDuty() {
        return this.duty;
    }
    
    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

 


}