package com.zx.tianjing.dao.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
public class JxSqlServer2008DbConnection {
	private static JxSqlServer2008DbConnection instance;
	public  Connection connection;
	public  Statement stmt;
	public  PreparedStatement ps;
	public  ResultSet rs;

	public JxSqlServer2008DbConnection() {
		this.conn();
	}

	public static JxSqlServer2008DbConnection getInstance() {
		if (instance == null) {
			return new JxSqlServer2008DbConnection();
		} else
			return instance;
	}

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("--------Driver load ok !!----------");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public   Connection conn() {

		if (connection == null) {
			try {
				// 密码 ：cc506and508
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/znaf?useUnicode=true&characterEncoding=utf-8", "root", "cc506and508");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("------connnection load ok !!----------");
		}
		return connection;
		/*try {
			String JDriver = "com.mysql.jdbc.Driver";// SQL数据库引擎
			String connectDB = "jdbc:mysql://"
					+ "192.168.1.107"
					+ ":3306;DatabaseName="
					+ "znaf" + ";";// 数据源重视IP地址和端标语，数据库名字！！！
			Class.forName(JDriver);
			String user = "root";
			String password = "root";
			this.connection = DriverManager.getConnection(connectDB, user,
					password);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;

		try {
			if (connection == null) {
				this.conn();
			}
			this.stmt = this.connection.createStatement();// 创建SQL号令对象
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		int i = 0;

		try {
			
			if (connection == null) {
				this.conn();
			}
			Statement stmt = this.connection.createStatement();// 创建SQL号令对象
			i = stmt.executeUpdate(sql);

			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean close() {
		try {
			stmt.close();// 封闭号令对象连接
			connection.close();// 封闭数据库连接
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
