package com.zime.toup.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zime.toup.dao.OrderviewMapper;
import com.zime.toup.entity.Orderview;
import com.zime.toup.entity.OrderviewExample;
import com.zime.toup.entity.OrderviewExample.Criteria;

@Service
public class OrderviewService {
	@Autowired
	private OrderviewMapper orderviewMapper;
	
	/**
	 * 增加orderview
	 * @param orderview
	 */
	public void saveOrderview(Orderview orderview) {
		orderviewMapper.insertSelective(orderview);
	}
	
	/**
	 * 批量删除orderview
	 * @param ids
	 */
	public void deleteOrderviewBatch(List<Integer> ids) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andIdIn(ids);
		orderviewMapper.deleteByExample(orderviewExample);
	}
	
	/**
	 * 删除指定id的orderview
	 * @param id
	 */
	public void deleteOrderview(Integer id) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andIdEqualTo(id);
		orderviewMapper.deleteByExample(orderviewExample);
	}
	
	/**
	 * 修改orderview
	 * @param orderview
	 */
	public void updateOrderview(Orderview orderview) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andIdEqualTo(orderview.getId());
		orderviewMapper.updateByExampleSelective(orderview, orderviewExample);
	}
	
	/**
	 * 查询所有的orderview
	 * @return orderview集合
	 */
	public List<Orderview> getAllOrderview() {
		OrderviewExample orderviewExample = new OrderviewExample();
//		orderviewExample.setOrderByClause("id asc");
		orderviewExample.setOrderByClause("id asc");
		return orderviewMapper.selectByExample(orderviewExample);
	}
	
	/**
	 * 查询指定id的orderview
	 * @param id
	 * @return 指定id的orderview
	 */
	public Orderview getOrderview(Integer id) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andIdEqualTo(id);
		return orderviewMapper.selectByExample(orderviewExample).get(0);
	}
	
	/**
	 * GoogsName字段模糊查询
	 * @return
	 */
	public List<Orderview> SelectByGoogsName(String value) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andGoodsNameLike(value);
		return orderviewMapper.selectByExample(orderviewExample);
	}
	
	/**
	 * Name字段模糊查询
	 * @return
	 */
	public List<Orderview> SelectByName(String value) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andNameLike(value);
		return orderviewMapper.selectByExample(orderviewExample);
	}
	
	/**
	 * 查询指定Totalprice(总价)区间段的orderview
	 * @param beginValue 起始数量
	 * @param endValue 结束数量
	 * @return
	 */
	public List<Orderview> SelectByTotalprice(BigDecimal beginValue, BigDecimal endValue) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andTotalpriceBetween(beginValue, endValue);
		return orderviewMapper.selectByExample(orderviewExample);
	}
	
	/**
	 * 查询指定Buyquantity(数量)区间段的orderview
	 * @param beginValue 起始数量
	 * @param endValue 结束数量
	 * @return
	 */
	public List<Orderview> SelectByBuyquantity(Integer beginValue, Integer endValue) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andBuyquantityBetween(beginValue, endValue);
		return orderviewMapper.selectByExample(orderviewExample);
	}
	
	/**
	 * 查询指定Price(价格)区间段的orderview
	 * @param beginValue 起始价格
	 * @param endValue 结束价格
	 * @return
	 */
	public List<Orderview> SelectByPrice(BigDecimal beginValue, BigDecimal endValue) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andGoodsPriceBetween(beginValue, endValue);
		return orderviewMapper.selectByExample(orderviewExample);
	}
	
	/**
	 * 查询指定时间段的orderview(yyyy-MM-dd hh:mm:ss)
	 * @param beginTime 起始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public List<Orderview> SelectByDate(Date beginTime, Date endTime) {
		OrderviewExample orderviewExample = new OrderviewExample();
		Criteria criteria = orderviewExample.createCriteria();
		criteria.andOrdertimeBetween(beginTime, endTime);
		return orderviewMapper.selectByExample(orderviewExample);
	}
}
