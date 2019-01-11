
package com.zime.toup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zime.toup.dao.UserMapper;
import com.zime.toup.entity.User;
import com.zime.toup.entity.UserExample;
import com.zime.toup.entity.UserExample.Criteria;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 增加user
	 * @param user
	 */
	public void saveUser(User user) {
		userMapper.insertSelective(user);
	}
	
	/**
	 * 删除指定id的user
	 * @param id
	 */
	public void deleteUser(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 批量删除user
	 * @param ids
	 */
	public void deleteUserBatch(List<Integer> ids) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andIdIn(ids);
		userMapper.deleteByExample(userExample);
	}
	
	/**
	 * 修改user
	 * @param user
	 */
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}
	
	/**
	 * 查询所有的user
	 * @return user集合
	 */
	public List<User> getAllUser() {
		UserExample userExample = new UserExample();
		userExample.setOrderByClause("id asc");
		return userMapper.selectByExample(userExample);
	}
	
	/**
	 * 查询指定id的user
	 * @param id
	 * @return
	 */
	public User getUser(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * Name字段模糊查询(改)
	 * @param value
	 * @return 
	 */
	public List<User> SelectByName(String value) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andNameLike(value);
		return userMapper.selectByExample(userExample);
	}
	
	/**
	 * UserName字段模糊查询
	 * @param value
	 * @return
	 */
	public List<User> SelectByUserName(String value) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameLike(value);
		return userMapper.selectByExample(userExample);
	}
	
	/**
	 * 根据username查询(新增)
	 * @param value
	 * @return
	 */
	public List<User> SelectByUsername(String value) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(value);
		return userMapper.selectByExample(userExample);
	}
}
