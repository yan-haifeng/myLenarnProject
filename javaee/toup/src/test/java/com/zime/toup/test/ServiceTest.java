package com.zime.toup.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zime.toup.service.GoodsService;
import com.zime.toup.service.OrderService;
import com.zime.toup.service.OrderviewService;
import com.zime.toup.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ServiceTest {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderviewService orderviewService;
	@Test
	public void test() {
		System.out.println(orderviewService.getAllOrderview());
	}
}
