package com.zime.toup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.zime.toup.entity.Goods;
import com.zime.toup.entity.User;
import com.zime.toup.service.UserService;
import com.zime.toup.util.JsonUtil;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public JsonUtil<User> RegisterUser(User user) {
		System.out.println(user.toString());
		userService.saveUser(user);
		return JsonUtil.success();
	}
	
	/**
	 * 用户名是否重复
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/repetition", method = RequestMethod.GET)
	public Boolean UserIsRepetition(String username) {
		System.out.println(username);
		 List<User> list =  userService.SelectByUsername(username);
		if(list.size()==0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public JsonUtil<User> LoginUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request) {
		System.out.println(username + "+" + password);
		List<User> list =  userService.SelectByUsername(username);
		if(list.size() != 0) {
			if(list.get(0).getPassword().equals(password)) {
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("userid", list.get(0).getId());
				//LoginUtil.putLoginUser(username, username);
				return JsonUtil.success().addCount(1).addData(list);
			}else {
				return JsonUtil.fail("密码错误");
			}
		}else {
			return JsonUtil.fail("用户名不存在");
		}
	}
	
	/**
	 * 用户名是否登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/islogin", method = RequestMethod.GET)
	public JsonUtil<User> UserIsLogin(HttpServletRequest request) {
		if (request.getSession().getAttribute("username")!=null) {
			List<HashMap<String, String>> list = new ArrayList<>();
			HashMap<String, String> map = new HashMap<String, String>();
			String username = (String)request.getSession().getAttribute("username");
			map.put("username", username);
			map.put("Administrator", userService.SelectByUsername(username).get(0).getAdministrator().toString());
			list.add(map);
			return JsonUtil.success().addCount(1).addData(list);
		}else {
			return JsonUtil.fail("无用户登录");
		}	
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/exitlogin", method = RequestMethod.GET)
	public boolean ExitLogin(HttpServletRequest request) {
		if (request.getSession().getAttribute("username")!=null) {
			request.getSession().removeAttribute("username");
			request.getSession().invalidate();
			return true;
		}else {
			return false;
		}	
	}
	
	/**
	 * 返回所有用户信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/userAllList", method = RequestMethod.GET)
	public JsonUtil<Goods> userAllList(){
		List<User> list = userService.getAllUser();
		return JsonUtil.success().addData(list).addCount(list.size());
	}
	
	/**
	 * 返回用户信息-分页
	 * @param page
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public JsonUtil<Goods> goodsList(@RequestParam(value="page", defaultValue="1") Integer page, @RequestParam(value="limit", defaultValue="1")Integer limit){
		int count = userService.getAllUser().size();
		//System.out.println(page+"   "+limit);
		PageHelper.startPage(page, limit);
		List<User> list = userService.getAllUser();
		return JsonUtil.success().addData(list).addCount(count);
	}
	
	/*
	 * 模糊查询用户名
	 */
	@ResponseBody
	@RequestMapping(value = "/searchUserData", method = RequestMethod.GET)
	public JsonUtil<Goods> searchGoodsData(@RequestParam(value="page", defaultValue="1") Integer page,
											@RequestParam(value="limit", defaultValue="1")Integer limit,
											@RequestParam(value="searchUser", defaultValue="")String searchUser){
		int count = userService.SelectByUserName(searchUser).size();
		System.out.println(page+"   "+limit);
		PageHelper.startPage(page, limit);
		List<User> list = userService.SelectByUserName(searchUser);
		return JsonUtil.success().addData(list).addCount(count);
	}
	
	/*
	 * 删除用户
	 */
	@ResponseBody
	@RequestMapping(value = "/delUser", method = RequestMethod.GET)
	public JsonUtil<String> delUser(Integer id) {
		System.out.println(id);
		JsonUtil<String> jsonUtil = JsonUtil.fail("删除失败!!!");
		try {
			//goodsService.deleteGoods(id);
			jsonUtil = jsonUtil.success().addMsg("删除成功!!!");
		} catch (Exception e) {
			jsonUtil = jsonUtil.fail("删除失败!!!");
			e.printStackTrace();
		}
		return jsonUtil;
	}
}
