package com.zime.toup.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zime.toup.dao.OrderMapper;
import com.zime.toup.entity.Order;
import com.zime.toup.entity.OrderExample;
import com.zime.toup.entity.OrderExample.Criteria;

@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	/**
	 * 增加order
	 * @param order
	 */
	public void saveOrder(Order order) {
		 orderMapper.insertSelective(order);
	}
	
	/**
	 * 删除指定id的order
	 * @param id
	 */
	public void deleteOrder(Integer id) {
		orderMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 批量删除order
	 * @param ids
	 */
	public void deleteOrderBatch(List<Integer> ids) {
		OrderExample orderExample = new OrderExample();
		Criteria criteria = orderExample.createCriteria();
		criteria.andIdIn(ids);
		orderMapper.deleteByExample(orderExample);
	}
	
	/**
	 * 修改order
	 * @param order
	 */
	public void updateOrder(Order order) {
		orderMapper.updateByPrimaryKey(order);
	}
	
	/**
	 * 查询所有的order
	 * @return order集合
	 */
	public List<Order> getAllOrder() {
		OrderExample orderExample = new OrderExample();
		orderExample.setOrderByClause("id asc");
		return orderMapper.selectByExample(orderExample);
	}
	
	/**
	 * 查询指定id的order
	 * @param id
	 * @return
	 */
	public Order getOrder(Integer id) {
		return orderMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 查询指定时间段的order(yyyy-MM-dd hh:mm:ss)
	 * @param beginTime 起始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public List<Order> SelectByDate(Date beginTime, Date endTime) {
		OrderExample orderExample = new OrderExample();
		Criteria criteria = orderExample.createCriteria();
		criteria.andOrdertimeBetween(beginTime, endTime);
		return orderMapper.selectByExample(orderExample);
	}
}
