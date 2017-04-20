<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ou.gong.dao.*,java.util.*,ou.gong.models.*"%>
<%
	ServerInfoDao sfd = new ServerInfoDao();
	List<ServerInfo> sList = sfd.getServerHT() ;
	request.setCharacterEncoding("utf-8") ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投注机模拟功能</title>
<script type="text/javascript">
	function changeInfo() {
		with (myForm) {
			var serverNames = new Array() ;
			
			serverNames["0"] = ["--请选择游戏--"] ;
			serverNames["SC"] = ["B001","QL730","3D","K512"]
			serverNames["GS"] = ["B001","QL730","3D","K3"]
			var value = server_name.value ;
			
			var proCode = "0" ;
			if(isContains(value,"四川")) {
				proCode = "SC" ;
			} else if (isContains(value,"甘肃")) {
				proCode = "GS" ;
			}
			var option;
			
			game.options.length = 0;  //这个代码是很关键的代码，代码将select 的option个数为0个 
			for (i = 0; i < serverNames[proCode].length; i++) {

				option = new Option(getGameName(serverNames[proCode][i]),
						serverNames[proCode][i]);
				game.options.add(option);
			}
			setStationID(proCode) ;
			
			if (proCode == "0") {
				game.disabled = true;
				document.getElementById("station_id").value = "" ;

			} else {
				game.disabled = false;
			}
			
		
		}
	}
	
	
	function isContains(str, substr) {
	    return str.indexOf(substr) >= 0;
	}
	
	
	function getGameName(game) {
		if (game == "B001") {
			return ("双色球");
		} else if (game == "QL730") {
			return ("七乐彩");
		} else if (game == "3D") {
			return ("3D");
		} else if (game == "K3") {
			
			return ("快三");
		} else if (game == "K512") {
			return ("快乐十二");
		} else if (game == "SSC") {
			return ("时时彩");
		} else {
			return ("--请选择游戏--");
		}
	}
	
	function setStationID(proCode) {
		
		switch (proCode) {
		case "SC":
			document.getElementById("station_id").value = "51010005" ;
			break;
		case "GS":
			document.getElementById("station_id").value = "62011005" ;
			break;
		case "XJ":
			document.getElementById("station_id").value = "64010005" ;
			break;
		default:
			return ("");
		}
	}
	
	function changeStat() {
		with(myForm) {
			var statValue = stat.value  ;
			if(statValue == "7") {
				document.getElementById("tsn_p").style="display:none" ;
				document.getElementById("issue_p").style="display:none" ;
				document.getElementById("money_p").style="display:block"
				
			} else {
				document.getElementById("tsn_p").style="display:block" ;
				document.getElementById("issue_p").style="display:block" ;
				document.getElementById("money_p").style="display:none"
			}
			
		}
	}
</script>
</head>
<body>
	<div id="left">
		<form method="post" action="tcAction.action" name="myForm">
			<p>
				服务后台：<select name="server_name" onchange="changeInfo()">
					<option value="0">--请选择服务器--</option>
				<%
						if (sList.size() > 0) {

							for (ServerInfo s : sList) {
				%>
					<option value="<%=s.getServer_name()%>"><%=s.getServer_name()%></option>
				<%
						}
					}
				%>
				</select>
			</p>
			<p>
			游戏名称：<select name="game">
				<option>--请选择游戏--</option>
			</select>
			</p>
			
			<p>
			投注站点：<input type="text" name="station_id" id = "station_id" value="">
			</p>
			
			<p>
			操作：<select name = "stat" onChange="changeStat()">
				<option value = "1" selected>投注</option>
				<option value = "2">注销</option>
				<option value = "3">冲正</option>
				<option value = "4">兑奖</option>
				<option value = "5">多期兑奖</option>
				<option value = "6">多期退票</option>
				<option value = "7">银行缴款</option>
				<option value = "8">投注检索</option>
			</select>
			</p>
			<p id ="type_p" style="display:none">
			<input type="radio" name="type" value="0" checked>EXCEL&nbsp;<input type="radio" name="type" value="1">
			</p>
			<p id = "issue_p" style="display:block">
			投注期号：<input type="text" name="issue" id="issue" value = "2017001">
			</p>
			<p id ="tsn_p" style="display:block">
			投注起始流水号：<input type="text" name="tsn" id = "tsn" value = "1" >
			<p>
			<p id = "money_p" style="display:none">
			缴款金额：<input type="text" name="money" id = "money" value="0">
			</p>
			<p>
			站点认证码：<input type="text" name="station_cert" id = "station_cert" value = "0">
			</p>
			<p>
				<input type="submit" value="操作" name="sub">&nbsp;&nbsp;
				<input type="reset" value = "重置" name="rs">
			</p>
		</form>
	</div>


</body>
<%
	if(request.getAttribute("msg") != null) {
		String msg =(String)request.getAttribute("msg") ;
		System.out.println("msg:" + msg) ;
%>  
<script type="text/javascript">
	var msg = "<%=msg%>" ;
	alert(msg) ;

	window.navigate("callTZ.jsp") ;
</script>
<% 
	} %>
</html>