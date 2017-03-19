<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ou.gong.tools.* ,ou.gong.models.*,java.util.*"%>
<%
	int pro_id = 62;
	int game_id = 2;
	int tsn = 0;
	String filename = "C:\\个人资料\\代码\\中奖检索用例\\test.xls";
	String sheetName = "GSB001";
	List<TestCase> tList = new ExcelToDB().toDb(pro_id, game_id, tsn, filename, sheetName);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="checkbox,html,js">
<title>复选框的测试</title>

<script type="text/javascript">
	function checkValue() {

		var checkbox = document.getElementsByName("ts");
		var checkall = document.getElementById("checkAll");
		
		if (checkbox.length == undefined) {//一个选项时
				checkbox.checked = checkall.checked ;
		} else {
			
			for (var i = 0; i < checkbox.length; i++) {//多个选项时
					checkbox[i].checked = checkall.checked ;
				}
		}
		
		}

	
</script>

</head>
<body>

	<form id="myForm" name="myForm" method="post">
		<table border="1" id="testcase">
			<tr>
				<td>用例名称</td>
				<td>用例编号</td>
				<td>投注倍数</td>
				<td>玩法编号</td>
				<td>投注金额</td>
				<td width="50">投注号码</td>
				<td>检索号码</td>
				<td width="50">预期结果</td>
				<td><input type="checkbox" value="1" checked id="checkAll" onClick="checkValue()">用例操作</td>

			</tr>
			<%
				for (TestCase tc : tList) {
			%>
			<tr>
				<td><%=tc.getComment()%></td>
				<td><%=tc.getSerialNumber()%></td>
				<td><%=tc.getBs()%></td>
				<td><%=tc.getPlay_type()%></td>
				<td><%=tc.getWager_money()%></td>
				<td width="50"><input type="text"
					value="<%=tc.getWager_num()%>"></td>
				<td><%=tc.getPre_win_nun()%></td>
				<td width="50"><input type="text"
					value="<%=tc.getPre_win_result()%>"></td>
				<td><input id="ts" type="checkbox" name="ts" value="1" checked></td>
			</tr>

			<%
				}
			%>
		</table>
	</form>

</body>
</html>