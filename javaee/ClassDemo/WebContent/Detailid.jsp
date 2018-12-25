﻿<%@page import="java.util.ArrayList"%>
<%@page import="com.yhf.entity.Items"%>
<%@page import="com.yhf.dao.ItemsDao"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 开始商品详情显示 -->
 <%
        	ItemsDao itemsDao = new ItemsDao();
        	Items items = itemsDao.getItemsById(Integer.parseInt(request.getParameter("id")));	
%>
<!DOCTYPE html>
<html>
  <head>
    <title><%=items.getName() %>详情</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="css/styles.css" type="text/css" rel="stylesheet"/>
    <link href="css/index/styles.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/css.css">
    <link rel="stylesheet" href="css/DetailedIformation_css.css">
    <script src="js/jquery-1.7.1.min.js"></script>
    <script src="js/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="js/prototypePre.js"></script>
    <script src="js/document.js"></script>
    <script src="js/prototypePost.js"></script>
    <script src="js/index/data.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
    <script type="text/javascript">
      function MM_showHideLayers() { //v9.0
        var i,p,v,obj,args=MM_showHideLayers.arguments;
        for (i=0; i<(args.length-2); i+=3) 
        with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
          if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
          obj.visibility=v; }
      }
      </script>
  </head>

  <body style="background-color: #fff">
      <header>
          <div id="head-leftbar">
            <ul>
              <li class="havemenu" onMouseOver="MM_showHideLayers('zgdlMenu','','show')" onMouseOut="MM_showHideLayers('zgdlMenu','','hide')">
                <a href="#" style="color:#000">中国大陆</a><span class="tb sjx"></span >
              <div id="zgdlMenu">
                <ul role="listbox">
                  <li role="option">全球</li>
                  <li role="option">中国大陆</li>
                  <li role="option">香港</li>
                  <li role="option">台湾</li>
                  <li role="option">澳门</li>
                  <li role="option">韩国</li>
                  <li role="option">马来西亚</li>
                  <li role="option">澳大利亚</li>
                  <li role="option">新加坡</li>
                  <li role="option">新西兰</li>
                  <li role="option">加拿大</li>
                  <li role="option">美国</li>
                  <li role="option">日本</li>
                </ul>
              </div>
              
          </li>
          
          <%
            if(session.getAttribute("username")!=null){
          %>  
          
              <li><a href="#" style="color:#f40"><%=(String)session.getAttribute("username") %></a></li>
              <li><a href="SessionDelete.jsp" onclick="exitlogin()">退出登录</a></li>
          <%
          }
          else
          {
          %>  
          
              <li><a href="index.jsp" style="color:#f40">亲，请登录</a></li>
              <li><a href="#">免费注册</a></li>
          
          <%
            }
          %>
          
              <li><a href="#">手机逛淘宝</a></li>
            </ul>
          </div>
          <div id="head-rightbar">
            <ul>
              <li class="havemenu"onMouseOver="MM_showHideLayers('wdtbMenu','','show')" onMouseOut="MM_showHideLayers('wdtbMenu','','hide')">
                <a href="#">我的淘宝</a><span class="tb sjx"></span >
              <div id="wdtbMenu">
                <ul>
                  <li>已买到的宝贝</li>
                  <li>我的足迹</li>
                </ul>
              </div>
              </li>
              <li><a href="mycart.jsp"><span class="tb gwc"></span >购物车</a><span class="tb sjx"></span ></li>
              <li class="havemenu" onMouseOver="MM_showHideLayers('scjMenu','','show')" onMouseOut="MM_showHideLayers('scjMenu','','hide')">
                <a href="#"><span class="tb scj"></span >收藏夹</a><span class="tb sjx"></span >
                <div id="scjMenu">
                  <ul>
                    <li>收藏的宝贝</li>
                    <li>收藏的店铺</li>
                  </ul>
                </div>
                </li>
              <li><a href="#">商品分类</a></li>
              <li class="havemenu" onMouseOver="MM_showHideLayers('mjzxMenu','','show')" onMouseOut="MM_showHideLayers('mjzxMenu','','hide')">
                <a href="#"><span class="tb sx"></span>卖家中心</a><span class="tb sjx"></span >
                  <div id="mjzxMenu">
                    <ul>
                      <li>免费开店</li>
                      <li>已卖出的宝贝</li>
                      <li>出售中的宝贝</li>
                      <li>卖家服务市场</li>
                      <li>卖家培训中心</li>
                      <li>体检中心</li>
                      <li>问商友</li>
                    </ul>
                  </div>
              
                </li>
              <li class="havemenu" class="havemenu" onMouseOver="MM_showHideLayers('lxkfMenu','','show')" onMouseOut="MM_showHideLayers('lxkfMenu','','hide')">
                <a href="#">联系客服</a><span class="tb sjx"></span >
              <div id="lxkfMenu">
                <ul>
                  <li>消费者客服</li>
                  <li>卖家客服</li>
                </ul>
              </div>
          
              </li>
              <li class="havemenu"><a href="#"><span class="tb wzdh"></span >网站导航</a><span class="tb sjx"></span ></li>
            </ul>
          </div>
          </header>


    <div id="base" class="">

      <div id="u0" class="ax_default _图片">
        <img id="u0_img" class="img " src="img/u0.png"/>
      </div>

      <div id="u1" class="ax_default box_2">
        <div id="u1_div" class=""></div>
        <div id="u1_text" class="text ">
          <p><span>更多市场</span></p>
        </div>
      </div>

      <div id="u2" class="ax_default box_1">
        <div id="u2_div" class=""></div>
      </div>

      <div id="u3" class="ax_default box_2">
        <div id="u3_div" class=""></div>
        <div id="u3_text" class="text ">
          <p><span>搜淘宝</span></p>
        </div>
      </div>

      <div id="u4" class="ax_default box_2">
        <div id="u4_div" class=""></div>
        <div id="u4_text" class="text ">
          <p><span>搜本店</span></p>
        </div>
      </div>

      <div id="u5" class="ax_default line">
        <img id="u5_img" class="img " src="img/u5.png"/>
      </div>

      <div id="u6" class="ax_default label">
        <div id="u6_div" class=""></div>
        <div id="u6_text" class="text ">
          <p><span>举报</span></p>
        </div>
      </div>

      <div id="u7" class="ax_default line">
        <img id="u7_img" class="img " src="img/u7.png"/>
      </div>

      <!-- 商品图片 -->
      <div id="u8" class="ax_default _图片">
        <img id="u8_img" class="img " src="./Image/<%=items.getPicture() %>"/>
      </div>

      <!-- 商品标题 -->
      <div id="u9" class="ax_default label" data-label="商品标题">
        <div id="u9_div" class=""></div>
        <div id="u9_text" class="text ">
          <p><span><%=items.getName() %></span></p>
        </div>
      </div>

      <div id="u10" class="ax_default box_2">
        <div id="u10_div" class=""></div>
      </div>

      <div id="u11" class="ax_default label">
        <div id="u11_div" class=""></div>
        <div id="u11_text" class="text ">
          <p><span>价格</span></p>
        </div>
      </div>

      <div id="u12" class="ax_default _一级标题">
        <div id="u12_div" class=""></div>
        <div id="u12_text" class="text ">
          <p><span>￥</span></p>
        </div>
      </div>

      <div id="u13" class="ax_default _一级标题" data-label="商品价格">
        <div id="u13_div" class=""></div>
        <div id="u13_text" class="text ">
          <p><span><%=items.getPrice() %></span></p>
        </div>
      </div>

      <div id="u14" class="ax_default _三级标题">
        <div id="u14_div" class=""></div>
        <div id="u14_text" class="text ">
          <p><span>0</span></p>
        </div>
      </div>

      <div id="u15" class="ax_default _三级标题">
        <div id="u15_div" class=""></div>
        <div id="u15_text" class="text ">
          <p><span>0</span></p>
        </div>
      </div>

      <div id="u16" class="ax_default _三级标题">
        <div id="u16_div" class=""></div>
        <div id="u16_text" class="text ">
          <p><span>累计评论</span></p>
        </div>
      </div>

      <div id="u17" class="ax_default _三级标题">
        <div id="u17_div" class=""></div>
        <div id="u17_text" class="text ">
          <p><span>交易成功</span></p>
        </div>
      </div>

      <div id="u18" class="ax_default label">
        <div id="u18_div" class=""></div>
        <div id="u18_text" class="text ">
          <p><span>优惠</span></p>
        </div>
      </div>

      <div id="u19" class="ax_default label">
        <div id="u19_div" class=""></div>
        <div id="u19_text" class="text ">
          <p><span>产地</span></p>
        </div>
      </div>

      <div id="u20" class="ax_default label">
        <div id="u20_div" class=""></div>
        <div id="u20_text" class="text ">
          <p><span>余量</span></p>
        </div>
      </div>

      <div id="u21" class="ax_default label">
        <div id="u21_div" class=""></div>
        <div id="u21_text" class="text ">
          <p><span>淘金币可抵扣1.6元</span></p>
        </div>
      </div>

      <!-- 商品产地 -->
      <div id="u22" class="ax_default label" data-label="商品产地">
        <div id="u22_div" class=""></div>
        <div id="u22_text" class="text ">
          <p><span><%=items.getCity() %></span></p>
        </div>
      </div>

      <!-- 商品余量 -->
      <div id="u23" class="ax_default label" data-label="商品余量">
        <div id="u23_div" class=""></div>
        <div id="u23_text" class="text ">
          <p><span><%=items.getNumber() %></span></p>
        </div>
      </div>

      <div id="u24" class="ax_default button">
        <div id="u24_div" class=""></div>
        <div id="u24_text" class="text ">
          <p><span>立即购买</span></p>
        </div>
      </div>

      <div id="u25" class="ax_default button">
        <img id="u25_img" class="img " src="img/u25.png"/>
        <div id="u25_text" class="text ">
          <p><span>加入购物车</span></p>
        </div>
      </div>

      <!-- 历史纪录 -->
      <%
      		String list = "";
      		//从客户端获取cookie集合
      		Cookie[] cookies = request.getCookies();
      		if(cookies != null && cookies.length>0){
      			for(Cookie c: cookies){
      				if(c.getName().equals("ItemListView")){
      					list = c.getValue();
      				}
      			}
      		}
      		
      		list += request.getParameter("id")+"#";
      		
      		String[] view = list.split("#");
      		if(view != null && view.length>0){
      			if(view.length>50){
      				list = "";
      			}
      		}
      		
      		Cookie cookie = new Cookie("ItemListView",list);
      		response.addCookie(cookie);
      %>
      <div id="u26" class="ax_default box_1" data-label="历史纪录">
        <div id="u26_div" class="">
        <p class="historytetle">看了又看</p>
    <%
    	ArrayList<Items> itemslist = itemsDao.getItemViewList(list);
    	if(itemslist!=null && itemslist.size()>0){
    		for(Items i: itemslist){
    %> 
    <div class="commoditywarm">
    <div class="imgwarm">
    <a href="Detailid.jsp?id=<%=i.getId() %>" class="commodity_link">
    <img src="./Image/<%=i.getPicture() %>" alt="">
    </a>
    </div>
    <div class="textwarm">
      <p class="commodityname"><%=i.getName() %></p>
      <p class="icon">￥</p><p class="moneytext"><%=i.getPrice() %></p></div>
  	</div>
  	<%
    		}
    	}
  	%>
        </div>
      </div>
    </div>
  </body>
</html>