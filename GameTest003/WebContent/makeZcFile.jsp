<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,ou.gong.models.*,ou.gong.dao.*"%>
<%
	ServerInfoDao sDao = new ServerInfoDao();
	List<ServerInfo> sList = sDao.getZcServer();
	boolean chk = false;
	if (sList.size() != 0) {
		chk = true;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中彩文件生成及上传</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/laydate.js"></script>
<script type="text/javascript">
	Date.prototype.format = function(format) {
		var date = {
			"M+" : this.getMonth() + 1,
			"d+" : this.getDate(),
			"h+" : this.getHours(),
			"m+" : this.getMinutes(),
			"s+" : this.getSeconds(),
			"q+" : Math.floor((this.getMonth() + 3) / 3),
			"S+" : this.getMilliseconds()
		};
		if (/(y+)/i.test(format)) {
			format = format.replace(RegExp.$1, (this.getFullYear() + '')
					.substr(4 - RegExp.$1.length));
		}
		for ( var k in date) {
			if (new RegExp("(" + k + ")").test(format)) {
				format = format.replace(RegExp.$1,
						RegExp.$1.length == 1 ? date[k] : ("00" + date[k])
								.substr(("" + date[k]).length));
			}
		}
		return format;
	}
	function chanageInfo() {
		with (myForm) {

			var now = new Date();
			var startTime = now.format("yyyy-MM-dd hh:mm:ss");
			//                    alert(startTime) ;
			var dayNum = 2;
			now.setDate(now.getDate() + dayNum);
			var endTime = now.format("yyyy-MM-dd hh:mm:ss");
			var cashDays = 60;
			now.setDate(now.getDate() + cashDays);
			var endCashTime = now.format("yyyy-MM-dd hh:mm:ss");

			//                    alert(endTime) ;
			var gameType = game_type.value;

			if (gameType == "1") {
				myForm.reset();

			} else if (gameType == "10001") {
				document.getElementById("num7").style.display = "none";
				num1.value = "01";
				num2.value = "02";
				num3.value = "03";
				num4.value = "04";
				num5.value = "05";
				num6.value = "06";
				num7.value = "07";
				num_ts.value = "07";

				issue.value = "2017001";

				start_time.value = startTime;
				days.value = dayNum;
				end_time.value = endTime;
				end_cash_time.value = endCashTime;
				cash_days.value = cashDays;
				abandonIssue.value = "0";
				abandonNum.value = "0";

			} else if (gameType == "10003") {
				document.getElementById("num7").style.display = "block";
				num1.value = "01";
				num2.value = "02";
				num3.value = "03";
				num4.value = "04";
				num5.value = "05";
				num6.value = "06";
				num7.value = "07";
				num_ts.value = "08";

				issue.value = "2017001";
				start_time.value = startTime;
				days.value = dayNum;
				end_time.value = endTime;
				end_cash_time.value = endCashTime;
				cash_days.value = cashDays;
				abandonIssue.value = "0";
				abandonNum.value = "0";
			}

		}
	}

	function checkValue() {

	}
</script>
<script type="text/javascript" >
	function msgInfo() {
	
	}
</script>

</head>
<body>
<div id = "main">
	<form method="post" action="" name="myForm">
	<div id="server_info">
			<h2>中彩服务器信息</h2>
			<table border="1">
		
					<tr>
						<td>服务器名称</td>
						<td>服务器ip</td>
						<td>服务器端口</td>
						<td>服务器用户名</td>
						<td>服务器密码</td>
						<td>文件放置目录</td>
						<td>操作</td>
					</tr>
				
					<%
						if (chk) {

							for (ServerInfo s : sList) {
					%>
					<tr>
						<td><input type="text" name="server_name"
							value="<%=s.getServer_name()%>"></td>
						<td><input type="text" name="server_ip"
							value="<%=s.getHost_ip()%>"></td>
						<td><input type="text" name="server_port"
							value="<%=s.getPort()%>"></td>
						<td><input type="text" name="server_user"
							value="<%=s.getServer_user()%>"></td>
						<td><input type="text" name="server_pass"
							value="<%=s.getServer_pass()%>"></td>
						<td><input type="text" name="upload_path"
							value="<%=s.getUpload_path()%>"></td>
						<td><input type="radio" name="server_id"
							value="<%=s.getPro_code()%>" checked></td>
					</tr>
					<%
						}
					%>
		
			</table>

			<%
				} else {
			%>
			<p>
				服务器ip：<input type="text" name="serverIp" value="10.13.0.210">
			</p>
			<p>
				服务器端口：<input type="text" name="serverPort" value="21">
			</p>
			<p>
				服务器用户名：<input type="text" name="server_user" value="zcserver">
			</p>
			<p>
				服务器密码：<input type="password" name="server_pass" value="1qaz-pl,">
			</p>
			<p>
				文件放置路径：<input type="text" name="upload_path"
					value="/home/zcserver/zcfiles/">
			</p>
		<%
				}
		%>

			</div>	
	<div id="make_zcfile">
			<h2>中彩文件生成器</h2>
			<p>
				<input type="checkbox" name="sale" checked>SALE.DWN&nbsp;<input
					type="checkbox" name="numb" checked>NUMB.DWN&nbsp;<input
					type="checkbox" name="sale" checked>BULL.DWN
			</p>
			<p>
				游戏编号：<select name="game_type" onchange="chanageInfo()">
					<option value="1">--请选择游戏--</option>
					<option value="10001">双色球</option>
					<option value="10003">七乐彩</option>
				</select>
			</p>
			<p>
				新期期号：<input type="text" name="issue" value="" maxlength="7">
			</p>
			<p>
				开始销售时间：<input type="text" name="start_time" class="laydate-icon"
					id="start_time">
			</p>
			<p>
				销售天数：<input type="text" name="days" value="" maxlength="2">
			</p>
			<p>
				结束销售时间：<input type="text" name="end_time" class="laydate-icon"
					id="end_time">
			</p>
			<p>
				兑奖天数：<input type="text" name="cash_days" value="" maxlength="2">
			</p>
			<p>
				结束兑奖时间：<input type="text" name="end_cash_time" class="laydate-icon"
					id="end_cash_time">
			</p>

			<p>
				弃奖期数：<input type="text" name="abandonNum" value="">
			</p>
			<p>
				弃奖起始期数：<input type="text" name="abandonIssue" value="">
			</p>
			<div id="win_num">
				开奖号码
				<table>
					<tr>
						<td>基本号码：</td>
						<td><input type="text" name="num1" size="2" maxlength="2"></td>
						<td><input type="text" name="num2" size="2" maxlength="2"></td>
						<td><input type="text" name="num3" size="2" maxlength="2"></td>
						<td><input type="text" name="num4" size="2" maxlength="2"></td>
						<td><input type="text" name="num5" size="2" maxlength="2"></td>
						<td><input type="text" name="num6" size="2" maxlength="2"></td>
						<td><input type="text" name="num7" size="2" id="num7"
							maxlength="2"></td>
					</tr>
					<tr>
						<td>特别号码</td>
						<td><input type="text" name="num_ts" size="2" maxlength="2"></td>

					</tr>
				</table>

			</div>
			<div>
				<p><input type="submit" name="submit" value="上传">
				&nbsp;&nbsp;
				<input type="reset" name="res" value="重置">
				</p>
			</div>
	</form>

</div>
<div id = "message">
	<% if(session.getAttribute("err_info")!= null ) { 
		String err_info = (String)session.getAttribute("err_info") ;
	%>
		<script type="text/javascript">
			alert("提示信息：" + err_info) ;
		</script>
	<% 
	} 
	
	if(session.getAttribute("succ_msg") != null) {
	%>
		<script type="text/javascript">
		alert("提示信息：" + succ_msg) ;
		</script>
	
	<% } %>
</div>

</body>
<script>
	var start_time = {
		elem : '#start_time',
		format : 'YYYY-MM-DD hh:mm:ss',
		min : laydate.now(), //设定最小日期为当前日期
		max : '2099-06-16 23:59:59', //最大日期
		istime : true,
		istoday : false,
		choose : function(datas) {
			end.min = datas; //开始日选好后，重置结束日的最小日期
			end.start = datas //将结束日的初始值设定为开始日
		}
	};
	var end_time = {
		elem : '#end_time',
		format : 'YYYY-MM-DD hh:mm:ss',
		min : laydate.now(),
		max : '2099-06-16 23:59:59',
		istime : true,
		istoday : false,
		choose : function(datas) {
			start.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};

	var end_cash = {
		elem : '#end_cash_time',
		format : 'YYYY-MM-DD hh:mm:ss',
		min : laydate.now(),
		max : '2099-06-16 23:59:59',
		istime : true,
		istoday : false,
		choose : function(datas) {
			start.max = datas; //结束日选好后，重置开始日的最大日期
		}
	};
	laydate(start_time);
	laydate(end_time);
	laydate(end_cash);
</script>

</html>