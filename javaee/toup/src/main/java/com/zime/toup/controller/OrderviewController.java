package com.zime.toup.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.zime.toup.entity.Goods;
import com.zime.toup.entity.Order;
import com.zime.toup.entity.Orderview;
import com.zime.toup.service.OrderService;
import com.zime.toup.service.OrderviewService;
import com.zime.toup.util.JsonUtil;

@Controller
public class OrderviewController {
	@Autowired
	private OrderviewService orderviewService;
	@Autowired
	private OrderService orderService;

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderview", method = RequestMethod.GET)
	public JsonUtil<Orderview> getOrder() {
		return JsonUtil.success().addData(orderviewService.getAllOrderview())
				.addCount(orderviewService.getAllOrderview().size());
	}
	
	/**
	 * 返回所有订单信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderViewAllList", method = RequestMethod.GET)
	public JsonUtil<Goods> orderViewAllList(){
		List<Orderview> list = orderviewService.getAllOrderview();
		return JsonUtil.success().addData(list).addCount(list.size());
	}
	
	/**
	 * 返回订单信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderViewList", method = RequestMethod.GET)
	public JsonUtil<Goods> orderViewList(@RequestParam(value="page", defaultValue="1") Integer page, @RequestParam(value="limit", defaultValue="10")Integer limit){
		int count = orderviewService.getAllOrderview().size();
		//System.out.println(page+"   "+limit);
		PageHelper.startPage(page, limit);
		List<Orderview> list = orderviewService.getAllOrderview();
		return JsonUtil.success().addData(list).addCount(count);
	}
	
	/*
	 * 批量修改订单
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderEdit", method = RequestMethod.POST)
	public JsonUtil<String> orderEdit(Integer[] id, String[] goodsName, BigDecimal[] goodsPrice,
			Integer[] buyquantity, BigDecimal[] totalprice, String[] name, String[] phone,
			String[] ordertime, Integer[] goodsId, Integer[] userId) throws ParseException{
		for(int i=0; i<id.length; i++){
//			Orderview orderview = new Orderview();
//			orderview.setId(id[i]);
//			orderview.setGoodsName(goodsName[i]);
//			orderview.setGoodsPrice(goodsPrice[i]);
//			orderview.setBuyquantity(buyquantity[i]);
//			orderview.setTotalprice(totalprice[i]);
//			orderview.setPhone(phone[i]);
//			orderview.setOrdertime(new SimpleDateFormat("yyyy-MM-dd").parse(ordertime[i]));
//			orderview.setGoodsId(goodsId[i]);
//			orderview.setUserId(userId[i]);
//			orderviewService.updateOrderview(orderview);
			Order order = new Order();
			order.setId(id[i]);
			order.setGoodsId(goodsId[i]);
			order.setUserId(userId[i]);
			order.setOrdertime(new SimpleDateFormat("yyyy-MM-dd").parse(ordertime[i]));
			order.setBuyquantity(buyquantity[i]);
			orderService.updateOrder(order);
			System.out.println(order);
		}
		//List<Orderview> list = orderviewService.getAllOrderview();
		return JsonUtil.success();
	}
	
	/*
	 * 批量添加订单
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderAdd", method = RequestMethod.POST)
	public JsonUtil<String> orderAdd(String[] goodsName, BigDecimal[] goodsPrice,
			Integer[] buyquantity, String[] name, String[] phone,
			String[] ordertime, Integer[] goodsId, Integer[] userId) throws ParseException{
		System.out.println(goodsId.length);
		for(int i=0; i<goodsId.length; i++){
//			Orderview orderview = new Orderview();
//			orderview.setId(id[i]);
//			orderview.setGoodsName(goodsName[i]);
//			orderview.setGoodsPrice(goodsPrice[i]);
//			orderview.setBuyquantity(buyquantity[i]);
//			orderview.setTotalprice(totalprice[i]);
//			orderview.setPhone(phone[i]);
//			orderview.setOrdertime(new SimpleDateFormat("yyyy-MM-dd").parse(ordertime[i]));
//			orderview.setGoodsId(goodsId[i]);
//			orderview.setUserId(userId[i]);
//			orderviewService.updateOrderview(orderview);
			if(goodsId[i]==null || userId[i]==null || buyquantity[i]==null){
				continue;
			}
			Order order = new Order();
			order.setGoodsId(goodsId[i]);
			order.setUserId(userId[i]);
			order.setOrdertime(new SimpleDateFormat("yyyy-MM-dd").parse(ordertime[i]));
			order.setBuyquantity(buyquantity[i]);
			orderService.saveOrder(order);
			System.out.println(order);
		}
		//List<Orderview> list = orderviewService.getAllOrderview();
		return JsonUtil.success();
	}
}
