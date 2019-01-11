package com.zime.toup.controller;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.zime.toup.entity.Goods;
import com.zime.toup.service.GoodsService;
import com.zime.toup.util.JsonUtil;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public JsonUtil<Goods> getGoods(@RequestParam(value = "id",defaultValue = "0") Integer id,@RequestParam(value = "getall", defaultValue = "0") Integer integer) {
		System.out.println(id+"++++"+integer);
		if(integer==1) {
			return JsonUtil.success().addData(goodsService.getAllGoods()).addCount(goodsService.getAllGoods().size());
		}else {
			List<Goods> list = new ArrayList<Goods>();
			list.add(goodsService.getGoods(id));
			return JsonUtil.success().addData(list).addCount(1);
		}
	}
	
	/**
	 * 返回所有商品信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/goodsAllList", method = RequestMethod.GET)
	public JsonUtil<Goods> goodsAllList(){
		List<Goods> listGoods = goodsService.getAllGoods();
		return JsonUtil.success().addData(listGoods).addCount(listGoods.size());
	}
	
	/**
	 * 返回商品信息-分页
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/goodsList", method = RequestMethod.GET)
	public JsonUtil<Goods> goodsList(@RequestParam(value="page", defaultValue="1") Integer page, @RequestParam(value="limit", defaultValue="1")Integer limit){
		int count = goodsService.getAllGoods().size();
		//System.out.println(page+"   "+limit);
		PageHelper.startPage(page, limit);
		List<Goods> listGoods = goodsService.getAllGoods();
		return JsonUtil.success().addData(listGoods).addCount(count);
	}
	
	/*
	 * 添加商品
	 */
	@ResponseBody
	@RequestMapping("/addGoods")
	public JsonUtil<String> addGoods(String goodsName, String goodsPrice, Integer goodsStock,
								String goodsCity, String goodsSpecifications,
								String goodsManufacturer, String goodsDate, String goodsDescribe,
								MultipartFile file, Model model, HttpServletRequest request) throws Exception {
		//System.out.println(goodsName);
		Goods goods = new Goods();
		goods.setGoodsName(goodsName);
		goods.setGoodsPrice(new BigDecimal(goodsPrice));
		goods.setGoodsStock(goodsStock);
		goods.setGoodsCity(goodsCity);
		goods.setGoodsSpecifications(goodsSpecifications);
		goods.setGoodsManufacturer(goodsManufacturer);
		goods.setGoodsDate(new SimpleDateFormat("yyyy-MM-dd").parse(goodsDate));
		goods.setGoodsDescribe(goodsDescribe);
		
		String orgName = file.getOriginalFilename();
		//System.out.println(goods.toString());
		//System.out.println(file);
		//System.out.println(orgName);
		
		if(file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0){
			//服务器所在路径
			String filePath = request.getServletContext().getRealPath("/")+"img/";
			//可自己定义路径
			String useFilePath ="D:/img/";
			System.out.println(filePath);
			//扩展名
			String extendsName = orgName.substring(orgName.lastIndexOf("."));
			//文件名
			String newFilename = new Date().getTime() + extendsName;
			goods.setGoodsImgpath(newFilename);
			//文件
			File uploadFile = new File(useFilePath + newFilename);
			System.out.println(useFilePath + newFilename);
			//上传
			file.transferTo(uploadFile);
			model.addAttribute("usefilepath", "/img/" + newFilename);
			
		}
		
		JsonUtil<String> jsonUtil = JsonUtil.fail("添加失败！");
		try {
			goodsService.saveGoods(goods);
			jsonUtil = jsonUtil.success().addMsg("添加成功！");
		} catch (Exception e) {
			jsonUtil = jsonUtil.fail("添加失败！");
			e.printStackTrace();
		}
		return jsonUtil;
	}
	
	/*
	 * 修改商品
	 */
	@ResponseBody
	@RequestMapping("/editGoods")
	public JsonUtil<String> editGoods(Integer id, String goodsName, String goodsPrice, Integer goodsStock,
								String goodsCity, String goodsSpecifications,
								String goodsManufacturer, String goodsDate, String goodsDescribe,
								MultipartFile file, Model model, HttpServletRequest request) throws Exception {
		Goods oldGoods = goodsService.getGoods(id);
		
		Goods newGoods = new Goods();
		newGoods.setId(id);
		newGoods.setGoodsName(goodsName);
		newGoods.setGoodsPrice(new BigDecimal(goodsPrice));
		newGoods.setGoodsStock(goodsStock);
		newGoods.setGoodsCity(goodsCity);
		newGoods.setGoodsSpecifications(goodsSpecifications);
		newGoods.setGoodsManufacturer(goodsManufacturer);
		newGoods.setGoodsDate(new SimpleDateFormat("yyyy-MM-dd").parse(goodsDate));
		newGoods.setGoodsDescribe(goodsDescribe);
		
		String orgName = file.getOriginalFilename();
		//System.out.println(newGoods.toString());
		//System.out.println(file);
		//System.out.println(orgName);
		
		if(file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0){
			//服务器所在路径
			String filePath = request.getServletContext().getRealPath("/")+"img/";
			//可自己定义路径
			String useFilePath ="E:/img/";
			System.out.println(filePath);
			//扩展名
			String extendsName = orgName.substring(orgName.lastIndexOf("."));
			//文件名
			String newFilename = new Date().getTime() + extendsName;
			newGoods.setGoodsImgpath(newFilename);
			//文件
			File uploadFile = new File(useFilePath + newFilename);
			System.out.println(useFilePath + newFilename);
			//上传
			file.transferTo(uploadFile);
			model.addAttribute("usefilepath", "/img/" + newFilename);
			
		} else {
			newGoods.setGoodsImgpath(oldGoods.getGoodsImgpath());
		}
		
		JsonUtil<String> jsonUtil = JsonUtil.fail("修改失败！");
		try {
			goodsService.updateGoods(newGoods);
			jsonUtil = jsonUtil.success().addMsg("修改成功！");
		} catch (Exception e) {
			jsonUtil = jsonUtil.fail("修改失败！");
			e.printStackTrace();
		}
		return jsonUtil;
		
	}
	
	/**
	 * 获取单件商品信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/editGoodsData", method = RequestMethod.GET)
	public JsonUtil<Goods> editGoodsData(Integer id){
		//System.out.println(id);
		List<Goods> list = new ArrayList<>();
		list.add(goodsService.getGoods(id));
		System.out.println(JsonUtil.success().addData(list).toString());
		return JsonUtil.success().addData(list);
	}
	
	/*
	 * 模糊查询商品名
	 */
	@ResponseBody
	@RequestMapping(value = "/searchGoodsData", method = RequestMethod.GET)
	public JsonUtil<Goods> searchGoodsData(@RequestParam(value="page", defaultValue="1") Integer page,
											@RequestParam(value="limit", defaultValue="1")Integer limit,
											@RequestParam(value="searchGoods", defaultValue="")String searchGoods){
		int count = goodsService.SelectByName(searchGoods).size();
		System.out.println(page+"   "+limit);
		PageHelper.startPage(page, limit);
		List<Goods> listGoods = goodsService.SelectByName(searchGoods);
		return JsonUtil.success().addData(listGoods).addCount(count);
	}
	
	/*
	 * 删除商品
	 */
	@ResponseBody
	@RequestMapping(value = "/delGoods", method = RequestMethod.GET)
	public JsonUtil<String> delGoods(Integer id) {
		System.out.println(id);
		JsonUtil<String> jsonUtil = JsonUtil.fail("删除失败!!!");
		try {
			goodsService.deleteGoods(id);
			jsonUtil = jsonUtil.success().addMsg("删除成功!!!");
		} catch (Exception e) {
			jsonUtil = jsonUtil.fail("删除失败!!!");
			e.printStackTrace();
		}
		return jsonUtil;
	}
	
	/*
	 * 批量删除商品
	 */
	@ResponseBody
	@RequestMapping(value = "/delAllGoods", method = RequestMethod.GET)
	public JsonUtil<String> delAllGoods(Integer[] ids) {
		//System.out.println(Arrays.toString(ids));
		List<Integer> list = Arrays.asList(ids);
		JsonUtil<String> jsonUtil = JsonUtil.fail("删除失败!!!");
		try {
			//goodsService.deleteGoodsBatch(list);
			jsonUtil = jsonUtil.success().addMsg("删除成功!!!");
		} catch (Exception e) {
			jsonUtil = jsonUtil.fail("删除失败!!!");
			e.printStackTrace();
		}
		return jsonUtil;
	}
}
