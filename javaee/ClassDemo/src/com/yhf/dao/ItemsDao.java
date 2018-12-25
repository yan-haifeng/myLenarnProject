package com.yhf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yhf.entity.Items;
import com.yhf.entity.User;
import com.yhf.util.DBHelper;

/**
 * ��Ʒҵ���߼�������
 * @author Administrator
 *
 */
public class ItemsDao {
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * @return
	 */
	
	public ArrayList<Items> getAllItems(){
		Connection connection =null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		
		ArrayList<Items> list = new ArrayList<Items>();
		//�������ݿ�
		try {
		connection = DBHelper.getConnection();
		//��ѯ
		String sql = "select * from tb_items";
		statement = connection.prepareStatement(sql);
		rSet = statement.executeQuery();
		
		while (rSet.next()) {
			Items items = new Items();
			items.setId(rSet.getInt("id"));
			items.setName(rSet.getString("name"));
			items.setCity(rSet.getString("city"));
			items.setPrice(rSet.getDouble("price"));
			items.setNumber(rSet.getInt("number"));
			items.setPicture(rSet.getString("picture"));
			
			list.add(items);
		}
		
			return list;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if(rSet!=null) {
				try {
					rSet.close();
					rSet = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(statement!=null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}
	}

	/**
	 * ������Ʒ��Ų�ѯ������Ʒ��Ϣ
	 * @param id
	 * @return
	 */
	public Items getItemsById(int id) {
		Connection connection =null;
		PreparedStatement statement = null;
		ResultSet rSet = null;
		
		//�������ݿ�
		try {
		connection = DBHelper.getConnection();
		//��ѯ
		String sql = "select * from tb_items where id=?";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		
		rSet = statement.executeQuery();
		
		if (rSet.next()) {
			Items items = new Items();
			items.setId(rSet.getInt("id"));
			items.setName(rSet.getString("name"));
			items.setCity(rSet.getString("city"));
			items.setPrice(rSet.getDouble("price"));
			items.setNumber(rSet.getInt("number"));
			items.setPicture(rSet.getString("picture"));
			
			return items;
		}else {
			return null;
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			if(rSet!=null) {
				try {
					rSet.close();
					rSet = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(statement!=null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}
	}
	
	/**
	 * ��ȡ��ʷ��¼
	 * @param list
	 * @return
	 */
	public ArrayList<Items> getItemViewList(String list){
		ArrayList<Items> li = new ArrayList<Items>();
		int itemCount = 5;
		
		if(list!=null && list.length()>0)
		{
			String[] view = list.split("#");
			
			if(view.length>itemCount) {
				for(int i = view.length-1; i>=view.length-itemCount; i--) {
					li.add(getItemsById(Integer.parseInt(view[i])));
				}
			}else {
				for(int i=view.length-1;i>=0;i--) {
					li.add(getItemsById(Integer.parseInt(view[i])));
				}
			}
			return li;
		}else {
			return null;
		}
	}
	
	/**
	 * �����Ʒ��Ϣ
	 * @param user
	 */
	public void addItem(Items items) {
		try {
			Connection connection = DBHelper.getConnection();
			String sql = "insert into tb_items(name,city,price,number,picture) values(?,?,?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, items.getName());
			pStatement.setString(2, items.getCity());
			pStatement.setDouble(3, items.getPrice());
			pStatement.setInt(4, items.getNumber());
			pStatement.setString(5, items.getPicture());
			pStatement.executeUpdate();	
			pStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param user
	 */
	public void updateItem(Items items) {
		try {
			Connection connection = DBHelper.getConnection();
			String sql = "update tb_items set name=?,city=?,price=?,number=?,picture=? where id=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, items.getName());
			pStatement.setString(2, items.getCity());
			pStatement.setDouble(3, items.getPrice());
			pStatement.setInt(4, items.getNumber());
			pStatement.setString(5, items.getPicture());
			pStatement.setInt(6, items.getId());
			
			pStatement.executeUpdate();
			
			pStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ɾ����Ʒ��Ϣ
	 * @param id
	 */
	public void deleteItem(int id) {
		try {
			
			Connection connection = DBHelper.getConnection();
			String sql = "delete from tb_items where id=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
			
			pStatement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
