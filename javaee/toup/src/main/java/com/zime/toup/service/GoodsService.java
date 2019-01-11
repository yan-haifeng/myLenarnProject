package com.zime.toup.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zime.toup.dao.GoodsMapper;
import com.zime.toup.entity.Goods;
import com.zime.toup.entity.GoodsExample;
import com.zime.toup.entity.GoodsExample.Criteria;



@Service
public class GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	
	/**
	 * 增加goods
	 * @param goods
	 */
	public void saveGoods(Goods goods) {
		goodsMapper.insertSelective(goods);
	}
	
	/**
	 * 删除指定id的goods
	 * @param id
	 */
	public void deleteGoods(Integer id) {
		goodsMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 批量删除goods
	 * @param ids
	 */
	public void deleteGoodsBatch(List<Integer> ids) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andIdIn(ids);
		goodsMapper.deleteByExample(goodsExample);
	}
	
	/**
	 * 修改goods
	 * @param goods
	 */
	public void updateGoods(Goods goods) {
		goodsMapper.updateByPrimaryKey(goods);
	}
	
	/**
	 * 查询所有的goods
	 * @return goods集合
	 */
	public List<Goods> getAllGoods() {
		GoodsExample goodsExample = new GoodsExample();
		goodsExample.setOrderByClause("id asc");
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * 查询指定id的goods
	 * @param id
	 * @return
	 */
	public Goods getGoods(Integer id) {
		return goodsMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * Name字段的模糊查询
	 * @param value
	 * @return
	 */
	public List<Goods> SelectByName(String value) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsNameLike("%"+value+"%");
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * City字段的模糊查询
	 * @param value
	 * @return
	 */
	public List<Goods> SelectByCity(String value) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsCityLike("%"+value+"%");
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * Manufacturer(生产厂家)字段的模糊查询
	 * @param value
	 * @return
	 */
	public List<Goods> SelectByManufacturer(String value) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsManufacturerLike("%"+value+"%");
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * Specifications(规格)字段的模糊查询
	 * @param value
	 * @return
	 */
	public List<Goods> SelectBySpecifications(String value) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsSpecificationsLike("%"+value+"%");
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * 查询指定price(价格)区间的Goods
	 * @param beginValue 起始价格
	 * @param endValue 结束价格
	 * @return
	 */
	public List<Goods> SelectByPrice(BigDecimal beginValue, BigDecimal endValue) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsPriceBetween(beginValue, endValue);
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * 查询指定Stock(库存)区间的Goods
	 * @param beginValue 起始库存
	 * @param endValue 结束库存
	 * @return
	 */
	public List<Goods> SelectByStock(Integer beginValue, Integer endValue) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsStockBetween(beginValue, endValue);
		return goodsMapper.selectByExample(goodsExample);
	}
	
	/**
	 * 查询指定时间段的Date(yyyy-MM-dd hh:mm:ss)
	 * @param beginTime 起始时间
	 * @param endTime 结束时间
	 * @return
	 */
	public List<Goods> SelectByDate(Date beginTime, Date endTime) {
		GoodsExample goodsExample = new GoodsExample();
		Criteria criteria = goodsExample.createCriteria();
		criteria.andGoodsDateBetween(beginTime, endTime);
		return goodsMapper.selectByExample(goodsExample);
	}
}
