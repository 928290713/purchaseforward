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

<!--购物车数据显示区-->
<div class="flowBox">
	<h6><span>商品列表</span></h6>
	<form id="formCart" name="formCart" method="post" action="">
		<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
			<tr>
				<th bgcolor="#ffffff">商品编号</th>
				<th bgcolor="#ffffff">商品名称</th>
				<th bgcolor="#ffffff">本店单价</th>
				<th bgcolor="#ffffff">购买数量</th>
				<th bgcolor="#ffffff">小计</th>
				<th bgcolor="#ffffff">操作</th>
			</tr>
			<tr>
				<td bgcolor="#ffffff" align="center">001</td>
				<td bgcolor="#ffffff" align="center">aaaa</td>
				<td bgcolor="#ffffff" align="center">11</td>
				<td bgcolor="#ffffff" align="center"><input type="text" value="2"/></td>
				<td bgcolor="#ffffff" align="center">123</td>
				<td bgcolor="#ffffff" align="center"><a href="##">删除</a></td>
			</tr>
		</table>
		<table width="99%" align="center" border="0" cellpadding="5" cellspacing="1" bgcolor="#dddddd">
			<tr>
				<td bgcolor="#ffffff">
					购物金额总计计 ￥0.00元
				</td>
				<td align="right" bgcolor="#ffffff">
					<input type="button" value="清空购物车" class="bnt_blue_1" onclick="" />
					<input name="submit" type="submit" class="bnt_blue_1" value="更新购物车" />
				</td>
			</tr>
		</table>
	</form>
	<table width="99%" align="center" border="0" cellpadding="5" cellspacing="0" bgcolor="#dddddd">
		<tr>
			<td bgcolor="#ffffff">
				<a href="###"><img src="images/continue.gif" alt="continue" /></a>
			</td>
			<td bgcolor="#ffffff" align="right">
				<a href="flow.php-step=checkout.htm"><img src="images/checkout.gif" alt="checkout" /></a>
			</td>
		</tr>
	</table>
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
