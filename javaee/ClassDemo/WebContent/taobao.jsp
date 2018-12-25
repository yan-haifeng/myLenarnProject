﻿<%@page import="java.util.ArrayList"%>
<%@page import="com.yhf.dao.ItemsDao"%>
<%@ page import="com.yhf.entity.Items" %>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="css/css.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/ft-carousel.css" type="text/css">
<link href="css/commodity.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function MM_showHideLayers() { //v9.0
    var i,p,v,obj,args=MM_showHideLayers.arguments;
    for (i=0; i<(args.length-2); i+=3) 
    with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
      if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
      obj.visibility=v; }
  }
  </script>
<title>模拟淘宝</title>
</head>

<body>
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
<main>
<div id="main-head">
<div id="d1">
<div id="logo">
</div>
<div id="d2">
  <div id="search-head">
    <ul>
      <li class="default">宝贝</li>
      <li>天猫</li>
      <li>店铺</li>
    </ul>
  </div>
<div id="search">
<form action="" method="get">
  <div class="frame">
    <a href="#" class="fdj"></a>
    <input name="search-frame" type="text"  id="search-frame" placeholder="礼物">
    <a href="#" class="zxj"></a>
  </div>
<input name="search-button" type="button" class="button" id="search-button" value="搜索">
</form>
</div>
<div id="commonly">
<div id="commonly-leftbar">
  <ul>
    <li><a href="#">新款连衣裙</a></li>
    <li><a href="#">四件套</a></li>
    <li><a href="#">潮流T恤</a></li>
    <li><a href="#">时尚女鞋</a></li>
    <li><a href="#">短裤</a></li>
    <li><a href="#">半身裙</a></li>
    <li><a href="#">男士外套</a></li>
    <li><a href="#">墙纸</a></li>
    <li><a href="#">行车记录仪</a></li>
    <li><a href="#">新款男鞋</a></li>
    <li><a href="#">耳机</a></li>
  </ul>
</div>
<div id="commonly-right">
    <ul>
      <li><a href="#">更多</a></li>
    </ul>
</div>
</div>
</div>
</div>
</div>
<nav id="nav">
<div id="d1">
<div id="table-heading">
<p>
主题市场
</p>
</div>
<div id="main-nav1">
  <ul>
    <li><a href="#">天猫</a></li>
    <li><a href="#">聚划算</a></li>
    <li><a href="#">天猫超市</a></li>
  </ul>
</div>
<div id="main-nav2">
  <ul>
    <li><a href="#">丨    </a></li>
    <li><a href="#">淘抢购</a></li>
    <li><a href="#">电器城</a></li>
    <li><a href="#">司法拍卖</a></li>
    <li><a href="#">中国质造</a></li>
    <li><a href="#">兴农扶贫</a></li>
    <li><a href="#">丨      </a></li>
    <li><a href="#">飞猪旅行</a></li>
    <li><a href="#">智能生活</a></li>
    <li><a href="#">苏宁易购</a></li>
  </ul>
</div>
</div>
</nav>
<div id="mianbar">
<div id="mian-leftbar">
<div id="menu">
  <ul>
    <li><a href="#">女装</a>/<a href="#">男装</a>/<a href="#">内衣</a><span class="jt"></span></li>
    <li><a href="#">鞋靴</a>/<a href="#">箱包</a>/<a href="#">配件</a><span class="jt"></span></li>
    <li><a href="#">童装玩具</a>/<a href="#">孕产</a>/<a href="#">用品</a><span class="jt"></span></li>
    <li><a href="#">家电</a>/<a href="#">数码</a>/<a href="#">手机</a><span class="jt"></span></li>
    <li><a href="#">美妆</a>/<a href="#">洗护</a>/<a href="#">保健品</a><span class="jt"></span></li>
    <li><a href="#">珠宝</a>/<a href="#">眼镜</a>/<a href="#">手表</a><span class="jt"></span></li>
    <li><a href="#">运动</a>/<a href="#">户外</a>/<a href="#">乐器</a><span class="jt"></span></li>
    <li><a href="#">游戏</a>/<a href="#">动漫</a>/<a href="#">影视</a><span class="jt"></span></li>
    <li><a href="#">美食</a>/<a href="#">生鲜</a>/<a href="#">零食</a><span class="jt"></span></li>
    <li><a href="#">鲜花</a>/<a href="#">宠物</a>/<a href="#">农资</a><span class="jt"></span></li>
    <li><a href="#">房产</a>/<a href="#">装修</a>/<a href="#">建材</a><span class="jt"></span></li>
    <li><a href="#">家具</a>/<a href="#">家饰</a>/<a href="#">家纺</a><span class="jt"></span></li>
    <li><a href="#">汽车</a>/<a href="#">二手车</a>/<a href="#">用品</a><span class="jt"></span></li>
    <li><a href="#">办公</a>/<a href="#">DIY</a>/<a href="#">五金用品</a><span class="jt"></span></li>
    <li><a href="#">百货</a>/<a href="#">餐厨</a>/<a href="#">家庭保健</a><span class="jt"></span></li>
    <li><a href="#">学习</a>/<a href="#">卡券</a>/<a href="#">本地服务</a><span class="jt"></span></li>
  </ul>
</div>

<div id="main-lefttop-bar">
    <div class="ft-carousel" id="carousel_1">
      <ul class="carousel-inner">
        <li class="carousel-item"><img src="img/a1.jpg" /></li>
        <li class="carousel-item"><img src="img/a2.jpg" /></li>
        <li class="carousel-item"><img src="img/a3.jpg" /></li>
        <li class="carousel-item"><img src="img/a4.jpg" /></li>
        <li class="carousel-item"><img src="img/a5.jpg" /></li>
      </ul>
  </div>  
</div>
<div id="main-leftbottom-bar">
<p>
理想生活上天猫
</p>
<div class="example">
	<div class="ft-carousel" id="carousel_2">
		<ul class="carousel-inner">
			<li class="carousel-item"><img src="img/b1.jpg" /></li>
			<li class="carousel-item"><img src="img/b2.jpg" /></li>
			<li class="carousel-item"><img src="img/b3.jpg" /></li>
			<li class="carousel-item"><img src="img/b4.jpg" /></li>
			<li class="carousel-item"><img src="img/b5.jpg" /></li>
			<li class="carousel-item"><img src="img/b6.jpg" /></li>
		</ul>
	</div>
</div>
</div>
  <script src="js/jquery.min.js"></script>
  <script src="js/ft-carousel.min.js"></script>
  <script type="text/javascript">
    $("#carousel_1").FtCarousel();
  
    $("#carousel_2").FtCarousel({
      index: 1,
      buttons: true
    });
  
    $("#carousel_3").FtCarousel({
      index: 0,
      auto: true,
      time: 300000,
      indicators: false,
      buttons: true
    });
  </script>
  



<div id="main-righttop-bar">
  <img src="img/guangao3.png" width="160" height="280"> </div>
<div id="main-rightbottom-bar">
<p>
今日热卖
</p>
  <img src="img/guangao4.png" width="160" height="200"> </div>

<div id="theDayNews">
  <div id="theDayNews-bd">
    <div id="theDayNews-bd-left">
      <p>
          让你的生活更有趣
      </p>
      
    </div>
    <div id="theDayNews-bd-right">
      <div id="theDayNews-bd-right-main">
        <a href="#">
        <img src="img/tbttImg1.jpg" alt="新闻图片" class="img1">
        <h4>
            【5.19早报】小米8或将支持屏下指纹？
        </h4>
        <p>
            今日品玩早报内容包含：OPPO 将要推出 R15 星云特别版；
            荣耀畅玩 7 低调销售，仅售 599 元；
            海信发布一款价格非常便宜的 80 英寸激光电视。
        </p>
      </a>
      </div>

    </div>

  </div>
</div>


</div>
<div id="mian-rightbar">
<div id="landing-box">
<div id="touxiang">
</div>
<p>
Hi! 你好
</p>
<div id="tjb">
<a href="#">领淘金币抵钱</a>
<a href="#">会员俱乐部</a>
</div>
<div id="landing-button">
<a href="#" id="button1">登录</a>
<a href="#">注册</a>
<a href="#">开店</a>
</div>
</div>
<div id="middle">
    <a href="#">网上有害信息举报专区</a>
    <ul>
     <li>公告</li>
     <li>规则</li>
     <li>论坛</li>
     <li>安全</li>
     <li>公益</li>
    </ul>
    <div id="gonggao">
      <ul>
        <li id="li1">
          <a href="#">阿里日喜逢中国品牌日 张勇:企业品牌核心是文化</a>
      </li>
    <li><a href="#">阿里CEO致谢阿里家人</a></li>
    <li><a href="#">阿里人的“扶贫新方式”</a></li>
    </ul>
    </div>
</div>
<div id="bottom">
<ul>
  <li><span class="bj chf"></span ><p>充话费</p></li>
  <li><span class="bj lx" ></span ><p>旅行</p></li>
  <li><span class="bj cx" ></span ><p>车险</p></li>
  <li><span class="bj yx"></span ><p>游戏</p></li>
  <li><span class="bj cp"></span ><p>彩票</p></li>
  <li><span class="bj dy"></span ><p>电影</p></li>
  <li><span class="bj jd"></span ><p>酒店</p></li>
  <li><span class="bj lc"></span ><p>理财</p></li>
  <li><span class="bj cfw"></span ><p>找服务</p></li>
  <li><span class="bj yc"></span ><p>演出</p></li>
  <li><span class="bj sdm"></span ><p>水电煤</p></li>
  <li><span class="bj hcp"></span ><p>火车票</p></li>
</ul>

</div>
<div id="aliApp">
  <h3>
    
  
      阿里APP 
  
  
  </h3>
  <ul>
    <li><a href="#"><img src="img/tbAPP.jpg" alt="手机app - 淘宝"></a></li>
    <li><a href="#"><img src="img/tmApp.jpg" alt="手机app - 天猫"></a></li>
    <li><a href="#"><img src="img/jhsApp.jpg" alt="手机app - 聚划算"></a></li>
    <li><a href="#"><img src="img/zfbApp.jpg" alt="手机app - 支付宝"></a></li>
    <li><a href="#"><img src="img/wwApp.jpg" alt="手机app - 旺旺"></a></li>
    <li><a href="#"><img src="img/ykApp.jpg" alt="手机app - 优酷"></a></li>
    <li><a href="#"><img src="img/tdApp.jpg" alt="手机app - 土豆"></a></li>
    <li><a href="#"><img src="img/xmApp.jpg" alt="手机app - 虾米"></a></li>
    <li><a href="#"><img src="img/qdApp.jpg" alt="手机app - 钱盾"></a></li>
    <li><a href="#"><img src="img/tppApp.jpg" alt="手机app - 淘票票"></a></li>
  </ul>
</div>
</div>

<div class="filler clearfloat"></div>

<div class="main-commoditybar clearfloat">

<!-- 商品循环 -->
        <% 
        	ItemsDao itemsDao = new ItemsDao();
        	ArrayList<Items> li = itemsDao.getAllItems();
        	if(li != null && li.size()>0){
        		for(int i=0;i<li.size();i++){
        			Items items = li.get(i);
        %>
  <div class="commoditywarm">
    <div class="imgwarm">
    <a href="Detailid.jsp?id=<%=items.getId() %>" class="commodity_link">
    <img src="./Image/<%=items.getPicture() %>" alt="">
    </a>
    </div>
    <div class="textwarm">
      <p class="commodityname"><%=items.getName() %></p>
      <p class="icon">￥</p><p class="moneytext"><%=items.getPrice() %></p></div>
  </div>
   <%
        		}
        	}
   %>
     	<!-- 商品循环结束 -->
</div>
</div>
</main>
</body>
</html>