<%--
  Created by IntelliJ IDEA.
  User: wlgo2108
  Date: 2017/2/20
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>中彩文件生成器</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/laydate.js"></script>
    <script type="text/javascript">

            Date.prototype.format = function (format) {
                var date = {
                    "M+": this.getMonth() + 1,
                    "d+": this.getDate(),
                    "h+": this.getHours(),
                    "m+": this.getMinutes(),
                    "s+": this.getSeconds(),
                    "q+": Math.floor((this.getMonth() + 3) / 3),
                    "S+": this.getMilliseconds()
                };
                if (/(y+)/i.test(format)) {
                    format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
                }
                for (var k in date) {
                    if (new RegExp("(" + k + ")").test(format)) {
                        format = format.replace(RegExp.$1, RegExp.$1.length == 1
                                ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
                    }
                }
                return format;
            }
            function chanageInfo() {
                with(myForm) {

                    var now = new Date() ;
                    var startTime = now.format("yyyy-MM-dd hh:mm:ss") ;
//                    alert(startTime) ;
                    var dayNum = 2 ;
                    now.setDate(now.getDate() + dayNum) ;
                    var endTime = now.format("yyyy-MM-dd hh:mm:ss") ;
                    var cashDays = 60 ;
                    now.setDate(now.getDate() + cashDays) ;
                    var endCashTime = now.format("yyyy-MM-dd hh:mm:ss") ;

//                    alert(endTime) ;
                    var gameType = game_type.value ;

                    if(gameType == "1") {
                        myForm.reset() ;

                    } else if(gameType== "10001") {
                        document.getElementById("num7").style.display = "none" ;
                        num1.value = "01" ;
                        num2.value = "02" ;
                        num3.value = "03" ;
                        num4.value = "04" ;
                        num5.value = "05" ;
                        num6.value = "06" ;
                        num7.value = "07" ;
                        num_ts.value = "07" ;

                        issue.value = "2017001" ;

                        start_time.value = startTime ;
                        days.value = dayNum ;
                        end_time.value = endTime ;
                        end_cash_time.value = endCashTime ;
                        cash_days.value = cashDays ;
                        abandonIssue.value = "0" ;
                        abandonNum.value = "0" ;


                    } else if(gameType == "10003") {
                        document.getElementById("num7").style.display = "block" ;
                        num1.value = "01" ;
                        num2.value = "02" ;
                        num3.value = "03" ;
                        num4.value = "04" ;
                        num5.value = "05" ;
                        num6.value = "06" ;
                        num7.value = "07" ;
                        num_ts.value = "08" ;

                        issue.value = "2017001" ;
                        start_time.value = startTime ;
                        days.value = dayNum ;
                        end_time.value = endTime ;
                        end_cash_time.value = endCashTime ;
                        cash_days.value = cashDays ;
                        abandonIssue.value = "0" ;
                        abandonNum.value = "0" ;
                    }


                }
            }

            function checkValue() {

            }
    </script>

	<style type="text/css">
		.serverinfo {
			float:left;
		}
		.makeFile {
			float:left;
		}
	</style>
</head>
<body>
<div>
    <form action="makeZcAction.action" method="post" name="myForm">
       <div id="serverInfo">
           <h2>中彩服务器信息</h2>
           <p>服务器ip：<input type="text" name="serverIp" value="10.62.201.31"></p>
           <p>服务器端口：<input type="text" name="serverPort" value="21"> </p>
           <p>服务器用户名：<input type="text" name="username" value="zcserver"></p>
           <p>服务器密码：<input type="password" name="password" value="zcserver"></p>
           <p>文件放置路径：<input type="text" name="filePath" value="/home/zcserver/"></p>
       </div>

        <div id = "makeFile">
            <h2>中彩文件生成器</h2>
            <p><input type="checkbox" name="sale" checked value = "1">SALE.DWN&nbsp;
            <input type="checkbox" name="numb" value = "1" checked>NUMB.DWN&nbsp;
            <input type="checkbox" name="bull" value = "1" checked>BULL.DWN</p>
            <p>游戏编号：<select name="game_type" onchange="chanageInfo()">
                <option value="1">--请选择游戏--</option>
                <option value="10001">双色球</option>
                <option value="10003">七乐彩</option>
            </select></p>
            <p>新期期号：<input type="text" name="issue" value="" maxlength="7"> </p>
            <p>开始销售时间：<input type="text" name="start_time"  class = "laydate-icon" id="start_time" ></p>
            <p>销售天数：<input type="text" name="days" value="" maxlength="2"></p>
            <p>结束销售时间：<input type="text" name="end_time" class= "laydate-icon" id="end_time" ></p>
            <p>兑奖天数：<input type="text" name="cash_days" value="" maxlength="2"></p>
            <p>结束兑奖时间：<input type="text" name="end_cash_time" class = "laydate-icon" id = "end_cash_time" ></p>

            <p>弃奖期数：<input type="text" name="abandonNum" value=""></p>
            <p>弃奖起始期数：<input type="text" name="abandonIssue" value=""></p>
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
                            <td><input type="text" name="num7" size="2" id = "num7" maxlength="2"></td>
                        </tr>
                        <tr>
                            <td>特别号码</td>
                            <td><input type="text" name="num_ts" size="2" maxlength="2"></td>

                        </tr>
                    </table>
            </div>


        </div>
        <div>
            <table>
                <tr>
                    <td><input type="submit" name="sub" value="上传"></td>
                    <td><input type="reset" name="reS" value="重置"> </td>
                </tr>
            </table>

        </div>
    </form>

</div>
</body>

<script>
    var start_time = {
        elem: '#start_time',
        format: 'YYYY-MM-DD hh:mm:ss',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16 23:59:59', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end_time = {
        elem: '#end_time',
        format: 'YYYY-MM-DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };

    var end_cash = {
        elem: '#end_cash_time',
        format: 'YYYY-MM-DD hh:mm:ss',
        min: laydate.now(),
        max: '2099-06-16 23:59:59',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start_time);
    laydate(end_time);
    laydate(end_cash) ;
</script>
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
