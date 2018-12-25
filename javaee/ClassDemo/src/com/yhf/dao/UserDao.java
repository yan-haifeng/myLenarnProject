package com.yhf.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.yhf.entity.User;
import com.yhf.util.DBHelper;

public class UserDao {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
		public boolean saveUser(User user) {
			try {
				Connection connection = DBHelper.getConnection();
				
				String sql = "insert into tb_user(username,password) values(?,?)";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, user.getUsername());
				pStatement.setString(2, user.getPassword());
				
				pStatement.executeUpdate();
				
				pStatement.close();
				
				return true;
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
		
	/**
	 * 用户登录	
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
		public User Login (String username,String password) {

			PreparedStatement pStatement = null;
			ResultSet rSet = null;
			
			User user = new User();
			
			try {
				Connection connection = DBHelper.getConnection();	
				
				String sql = "select username,password from tb_user where username=? and password=?";
				pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, username);
				pStatement.setString(2, password);
				
				rSet = pStatement.executeQuery();
				
				if (rSet.next()) {
					user.setUsername(rSet.getString("username"));
					user.setPassword(rSet.getString("password"));
				}
				
				rSet.close();
				pStatement.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return user;
		}

		/**
		 * 添加用户信息
		 * @param user
		 */
		public void addUser(User user) {
			try {
				Connection connection = DBHelper.getConnection();
				String sql = "insert into tb_user(username,password,sex,question,answer,email) values(?,?,?,?,?,?)";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, user.getUsername());
				pStatement.setString(2, user.getPassword());
				pStatement.setString(3, user.getSex());
				pStatement.setString(4, user.getQuestion());
				pStatement.setString(5, user.getAnswer());
				pStatement.setString(6, user.getEmail());
				
				pStatement.executeUpdate();
				
				pStatement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * 修改用户信息
		 * @param user
		 */
		public void updateUser(User user) {
			try {
				
				Connection connection = DBHelper.getConnection();
				String sql = "update tb_user set username=?,password=?,sex=?,question=?,answer=?,email=? where id=?";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				pStatement.setString(1, user.getUsername());
				pStatement.setString(2, user.getPassword());
				pStatement.setString(3, user.getSex());
				pStatement.setString(4, user.getQuestion());
				pStatement.setString(5, user.getAnswer());
				pStatement.setString(6, user.getEmail());
				pStatement.setInt(7, user.getId());
				
				pStatement.executeUpdate();
				
				pStatement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * 删除用户信息
		 * @param id
		 */
		public void deleteUser(int id) {
			try {
				
				Connection connection = DBHelper.getConnection();
				String sql = "delete from tb_user where id=?";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				pStatement.setInt(1, id);
				pStatement.executeUpdate();
				
				pStatement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * 查询所有用户信息
		 * @return
		 */
		public List<User> getAllUsers() {
			List<User> list = new ArrayList<User>();
			Connection connection;
			try {
				connection = DBHelper.getConnection();
				String sql = "select * from tb_user";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet rSet = pStatement.executeQuery();
				while(rSet.next()) {
					User users = new User();
					users.setUsername(rSet.getString("username"));
					users.setPassword(rSet.getString("password"));
					users.setSex(rSet.getString("sex"));
					users.setQuestion(rSet.getString("question"));
					users.setAnswer(rSet.getString("answer"));
					users.setEmail(rSet.getString("email"));
					list.add(users);
				}
				rSet.close();
				pStatement.close();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		/**
		 * 查询单个用户信息
		 * @param id
		 * @return
		 */
		public User getUser(int id) {
			Connection connection;
			User user = new User();
			try {
				connection = DBHelper.getConnection();
				String sql = "select * from tb_user where id=?";
				PreparedStatement pStatement = connection.prepareStatement(sql);
				ResultSet rSet = pStatement.executeQuery();
					if(rSet.next()) {
					user.setUsername(rSet.getString("username"));
					user.setPassword(rSet.getString("password"));
					user.setSex(rSet.getString("sex"));
					user.setQuestion(rSet.getString("question"));
					user.setAnswer(rSet.getString("answer"));
					user.setEmail(rSet.getString("email"));
				}
				rSet.close();
				pStatement.close();
				return user;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
}
