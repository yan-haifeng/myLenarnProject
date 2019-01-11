package com.zime.toup.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zime.toup.entity.Order;
import com.zime.toup.service.OrderService;
import com.zime.toup.service.UserService;
import com.zime.toup.util.JsonUtil;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public JsonUtil<Order> addOrder(@RequestParam(value = "username") String username,@RequestParam(value = "goodsid") Integer goodsid,@RequestParam(value = "goodsnums") Integer goodsnums) {
		System.out.println(username+"-------"+goodsid+"-------"+goodsnums);
		Date date = new Date();
		int userid = userService.SelectByUsername(username).get(0).getId();
		System.out.println(userid);
		Order order = new Order(null, goodsid, userid, date, goodsnums);
		orderService.saveOrder(order);
		return JsonUtil.success();
	}
	
	/*
	 * 批量修改订单
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderEdit1", method = RequestMethod.POST)
	public JsonUtil<String> orderEdit1(Integer[] id, String[] goodsName, BigDecimal[] goodsPrice,
			Integer[] buyquantity, BigDecimal[] totalprice, String[] name, String[] phone,
			String[] ordertime, Integer[] goodsId, Integer[] userId) throws ParseException{
		System.out.println(Arrays.toString(goodsId)+"  "+Arrays.toString(buyquantity));
		for(int i=0; i<goodsId.length; i++){
			if(id[i]==null || id[i]==0 || userId[i]==null || userId[i]==0 || goodsId[i]==null || goodsId[i]==0){
				continue;
			}
			Order order = new Order();
			order.setId(id[i]);
			order.setGoodsId(goodsId[i]);
			order.setUserId(userId[i]);
			order.setOrdertime(new SimpleDateFormat("yyyy-MM-dd").parse(ordertime[i]));
			order.setBuyquantity(buyquantity[i]);
			System.out.println(order);
			orderService.updateOrder(order);
		}
		//List<Orderview> list = orderviewService.getAllOrderview();
		return JsonUtil.success();
	}
	
	/*
	 * 批量添加订单
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/orderAdd1", method = RequestMethod.POST)
	public JsonUtil<String> orderAdd1(String[] goodsName, BigDecimal[] goodsPrice,
			Integer[] buyquantity, String[] name, String[] phone,
			String[] ordertime, Integer[] goodsId, Integer[] userId) throws ParseException{
		System.out.println(Arrays.toString(goodsId)+"  "+Arrays.toString(buyquantity));
		for(int i=0; i<goodsId.length; i++){
			if(userId[i]==null || userId[i]==0 || goodsId[i]==null || goodsId[i]==0){
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
