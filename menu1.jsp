<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ou.gong.dao.*,java.util.*,ou.gong.models.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta name="roots" content="" />
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<title>测试工具</title>
<style type="text/css">
body {
	font: "宋体";
	font-size: 12px;
}

a:link, a:visited {
	font-size: 12px;
	color: #666;
	text-decoration: none;
}

a:hover {
	color: #ff0000;
	text-decoration: underline;
}

#Tab {
	margin: 0 auto;
	width: 220px;
	border: 1px solid #BCE2F3;
	float:left;
	height:100%;
	
}

.Menubox {
	height: 28px;
	border-bottom: 1px solid #64B8E4;
	background: #E4F2FB;
}

.Menubox ul {
	list-style: none;
	margin: 7px 40px;
	padding: 0;
	position: absolute;
}

.Menubox ul li {
	float: left;
	background: #64B8E4;
	line-height: 20px;
	display: block;
	cursor: pointer;
	width: 65px;
	text-align: center;
	color: #fff;
	font-weight: bold;
	border-top: 1px solid #64B8E4;
	border-left: 1px solid #64B8E4;
	border-right: 1px solid #64B8E4;
}

.Menubox ul li.hover {
	background: #fff;
	border-bottom: 1px solid #fff;
	color: #147AB8;
}

.Contentbox {
	clear: both;
	margin-top: 0px;
	border-top: none;

	padding-top: 8px;
	height: 100%;
	
}

.Contentbox ul {
	list-style: none;
	margin: 7px;
	padding: 0;
}

.Contentbox ul li {
	line-height: 24px;
	border-bottom: 1px dotted #ccc;
}
</style>
<script>

	function setTab(name, cursel, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById("con_" + name + "_" + i);
			menu.className = i == cursel ? "hover" : "";
			con.style.display = i == cursel ? "block" : "none";
		}
	}

</script>
</head>
<body>


	<div id="Tab">
		<div class="Menubox">
			<ul>
				<li id="menu1" onmouseover="setTab('menu',1,2)" class="hover">投注机</li>
				<li id="menu2" onmouseover="setTab('menu',2,2)">服务器</li>
			</ul>
		</div>
		<div class="Contentbox">
			<div id="con_menu_1" class="hover">
				<ul>
					<li>·<a href="callTZ.jsp" target="myMain">投注</a></li>
					<li>·<a href="callZX.jsp" target="myMain">注销</a></li>
					<li>·<a href="callCZ.jsp" target="myMain">冲正</a></li>
					<li>·<a href="callDJ.jsp" target="myMain">兑奖</a></li>
					<li>·<a href="callDJ_D.jsp" target="myMain">多期兑奖</a></li>
					<li>·<a href="callTP.jsp" target="myMain">多期退票</a></li>
					<li>·<a href="callJK.jsp" target="myMain">银行缴款</a></li>
					
				</ul>
			</div>
			<div id="con_menu_2" style="display: none">
				<ul>
					<li>·<a href="#">中彩文件生成</a></li>
					<li>·<a href="#">服务器信息</a></li>
					<li>·<a href="#">服务器更新</a></li>
					<li>·<a href="#">游戏更新</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div id = "main">
	
	</div>
</body>
</html>
