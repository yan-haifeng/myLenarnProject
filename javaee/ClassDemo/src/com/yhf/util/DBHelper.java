package com.yhf.util;

import java.sql.*;

public class DBHelper {
	private static final String 
			driver="com.mysql.jdbc.Driver",
			url="jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8",
			username = "root",
			password = "haifeng";
	private static Connection connection = null;
	//��̬����飬�����������
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����ģʽ�������ݿ����Ӷ���
	public static Connection getConnection() throws Exception {
		if(connection==null){
			connection=DriverManager.getConnection(url, username, password);
			return connection;
		}
		return connection;
	}
}
