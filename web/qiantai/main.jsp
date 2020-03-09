<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--LOGO欢迎信息和登陆注册功能-->
<div class="block clearfix">
	<div class="f_l">
		<a href="index.php.htm" name="top"><img src="images/logo.gif"/></a>
	</div>
 	<div class="f_r log">
		<ul>
	    	<li class="userInfo">
  				<font id="ECS_MEMBERZONE">
					<div id="append_parent"></div>
 					欢迎光临本店&nbsp;&nbsp;&nbsp;&nbsp;
 					<a href="login.jsp"><img src="images/bnt_log.gif"/></a>
 					<a href="register.jsp"><img src="images/bnt_reg.gif"/></a>
 				</font>
   			</li>
      	</ul>
 	</div>
</div>
<div  class="blank"></div>

<!--顶层功能导航栏-->
<div id="mainNav" class="clearfix">
	<a href="main.jsp" class="cur">首页<span></span></a>
	<a href="###">买家必看<span></span></a>
	<a href="###">优惠活动<span></span></a>
	<a href="flow.jsp">查看购物车<span></span></a>
	<a href="###">报价单<span></span></a>
	<a href="###">留言板<span></span></a>
	<a href="###">团购商品<span></span></a>
</div>
<div class="block">
	<div class="box">
		<div class="helpTitBg clearfix"></div>
	</div>
</div>
<div class="blank"></div>

<!--主要数据展示区，包含左边栏和右边商品展示区-->
<div class="block clearfix">
	<!--左侧栏-->
	<div class="AreaL">
		<!--左侧公告栏-->
    	<div class="box">
     		<div class="box_1">
      			<h3><span>商店公告</span></h3>
      			<div class="boxCenterList RelaArticle">
        			此处填写，商店公告的基本信息.
				</div>
     		</div>
    	</div>
    	<div class="blank5"></div>
		<!--左侧购物车-->
		<div class="cart" id="ECS_CARTINFO">
 			<a href="flow.php.htm" title="查看购物车">您的购物车中有 0 件商品，总计金额 ￥0.00元。</a>
		</div>
		<div class="blank5"></div>
		<!--左侧分类栏-->
		<div class="box">
 			<div class="box_1">
  				<div id="category_tree">
         			<dl>
     					<dt>
							<a href="category.php-id=12.htm">类别1</a>
						</dt>
	       			</dl>
					<dl>
     					<dt>
							<a href="category.php-id=12.htm">类别2</a>
						</dt>
	       			</dl>
  				</div>
 			</div>
		</div>
		<div class="blank5"></div>
	</div>
	<!--右边商品展示区-->
  	<div class="AreaR">
    	<div class="box">
			<div class="box_2 centerPadd">
  				<div class="itemTit" id="itemBest"></div>
  				<div id="show_best_area" class="clearfix goodsBox">
					<!--单个商品展示信息-->
      				<div class="goodsItem">
         				<span class="best"></span>
           				<a href="flow.jsp">
							<img src="" alt="测试商品1" class="goodsimg" /></a>
           				<p><a href="flow.jsp" title="测试商品1">测试商品1</a></p>
           				<font class="f1">￥55元</font>
        			</div>
        			<div class="goodsItem">
         				<span class="best"></span>
           				<a href="flow.jsp">
							<img src="" alt="测试商品1" class="goodsimg" /></a>
           				<p><a href="flow.jsp" title="测试商品1">测试商品1</a></p>
           				<font class="f1">￥55元</font>
        			</div>
        			<div class="goodsItem">
         				<span class="best"></span>
           				<a href="flow.jsp">
							<img src="" alt="测试商品1" class="goodsimg" /></a>
           				<p><a href="flow.jsp" title="测试商品1">测试商品1</a></p>
           				<font class="f1">￥55元</font>
        			</div>
    				<div class="more"><a href="###"><img src="images/more.gif" /></a></div>
    			</div>
			</div>
		</div>
		<div class="blank5"></div>
  	</div>
</div>
<div class="blank5"></div>

<!--友情连接区-->
<div id="bottomNav" class="box">
	<div class="box_1">
		<div class="links clearfix">
			[<a href="###" target="_blank" title="友情连接1">友情连接1</a>]
			[<a href="###" target="_blank" title="友情连接1">友情连接2</a>]
			[<a href="###" target="_blank" title="友情连接1">友情连接3</a>]
			[<a href="###" target="_blank" title="友情连接1">友情连接4</a>]
			[<a href="###" target="_blank" title="友情连接1">友情连接5</a>]
		</div>
	</div>
</div>
<div class="blank"></div>

<!--底层导航栏-->
<div id="bottomNav" class="box">
	<div class="box_1">
		<div class="bNavList clearfix">
   			<div class="f_l"></div>
   			<div class="f_r">
				<a href="#top"><img src="images/bnt_top.gif" /></a> 
				<a href="###"><img src="images/bnt_home.gif"/></a>
   			</div>
  		</div>
 	</div>
</div>
<div class="blank"></div>

<!--版权信息栏-->
<div class="text"align="center">
 &copy; 2010-2015 网上商城 版权所有，并保留所有权利。<br />
          E-mail: 123456@qq.com<br />
    ICP备案证书号:<a href="###" target="_blank">粤ICP备1234568</a><br />
          <div align="center"  id="rss"><a href="###"><img src="images/xml_rss2.gif"alt="rss" /></a></div>
</div>
</body>
</html>
