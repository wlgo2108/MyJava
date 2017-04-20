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
<link rel="stylesheet" type="text/css" href="../css/GridManager.css">
<script type="text/javascript" src="../js/GridManager.js"></script>
 <style>
		html, body{
			width: 100%;
			height: 100%;
			overflow-x:hidden;
			margin: 0px;
			padding: 0px;
		}
        .plugin-action{
            display: inline-block;
            color: steelblue;
            margin-right: 10px;
            cursor: pointer;
        }
        .plugin-action:hover{
            text-decoration:underline;
        }
		.search-area{
			padding: 10px 20px;
			border: 1px solid #ccc;
			background: #efefef;
		}
		.search-area .sa-ele{
			display: inline-block;
			margin-right: 20px;
			font-size: 12px;
		}
		.search-area .sa-ele .se-title{
			display: inline-block;
			margin-right: 10px;
		}
		.search-area .sa-ele .se-con{
			display: inline-block;
			width:180px;
			height: 24px;
			border: 1px solid #ccc;
			padding: 0px 4px;
			line-height: 24px;
		}
		.search-area .sa-ele .search-action, .search-area .sa-ele .reset-action{
			display: inline-block;
			width:80px;
			height: 26px;
			border: 1px solid #ccc;
			background: #e8e8e8;
			padding: 0px 4px;
			line-height: 26px;
			text-align: center;
			cursor: pointer;
			margin-right: 10px;
		}
		.search-area .sa-ele .search-action:hover, .search-area .sa-ele .reset-action:hover{
			opacity: 0.7;
		}
    </style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.2.0.min.js"></script>
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
<div>
	<input type="text" name="key" id="key" value=""> <button id="btn_select" onClick="selectValue()">搜索</button>
</div>
<div id = "div1"></div>
 <script type="text/javascript" charset="utf-8"> 
 
 function selectValue() {
	 	var key = "" 
		var h= "<table id='tb' border='1'>"; 
		   // alert("加载..............");  
		
		 key = document.getElementById("key").value ;
		   
			h+= "<tr>"  ;
			h+= "<td>用户名称</td>" ;
			h+= "<td>用户编号</td>" ;
			h+= "<td>投注倍数</td>" ;
			h+= "<td>投注金额</td>" ;
			h+= "<td>玩法编号</td>" ;
			h+= "<td>投注号码</td>" ;
			h+= "<td>中奖号码</td>" ;
			h+= "<td>预期结果</td>" ;
			h+= "<td>执行结果</td>" ;
			h+= "<td><input type='checkbox' id = 'checkAll' onclick='checkValue()' checked>操作</td>" ;
			h+= "</tr>" ;
			
		    $.getJSON("GSB001.json",function(data){   
		        //通过循环取出data里面的值         
		        $.each(data,function(i,value){ 
		        	if(value.play_type == key||value.serialNumber.indexOf(key)>-1 ) {
		        		
		        		if(value.result == "pass") {
			        		h+= "<tr bgcolor='14DB53'>" ;
			        	}else if(value.result == "fail"){
			        		h+= "<tr bgcolor='FA0019'>" ;
			        	} else {
			        		h+= "<tr>" ;
			        	}
			        	h+= "<td><input type='text' value = '"+value.comment+"' ></td>" ;
			            h+= "<td><input type='text' value = '"+value.serialNumber+"' ></td>" ;
			            h+= "<td>"+value.bs+"</td>" ;
			            h+= "<td>"+value.wager_money+"</td>" ;
			            h+= "<td>"+value.play_type+"</td>" ;
			            h+= "<td><input type='text' value = '"+value.wager_num+"' ></td>" ;
			            h+= "<td>"+value.pre_win_nun+"</td>" ;
			            h+= "<td><input type='text' value = '"+value.pre_win_result+"' ></td>" ;
			            h+= "<td>"+value.result+"</td>" ;
			            h+= "<td><input type='checkbox' id = 'all' name = 'ts' value='"+value.serialNumber+""' checked></td>" ;
			            h+= "</tr>" ;
		        	} else if(key == "") {
		        		if(value.result == "pass") {
			        		h+= "<tr bgcolor='14DB53'>" ;
			        	}else if(value.result == "fail"){
			        		h+= "<tr bgcolor='FA0019'>" ;
			        	} else {
			        		h+= "<tr>" ;
			        	}
			        	h+= "<td><input type='text' value = '"+value.comment+"' ></td>" ;
			            h+= "<td><input type='text' value = '"+value.serialNumber+"' ></td>" ;
			            h+= "<td>"+value.bs+"</td>" ;
			            h+= "<td>"+value.wager_money+"</td>" ;
			            h+= "<td>"+value.play_type+"</td>" ;
			            h+= "<td><input type='text' value = '"+value.wager_num+"' ></td>" ;
			            h+= "<td>"+value.pre_win_nun+"</td>" ;
			            h+= "<td><input type='text' value = '"+value.pre_win_result+"' ></td>" ;
			            h+= "<td>"+value.result+"</td>" ;
			            h+= "<td><input type='checkbox' id = 'all' name = 'ts' checked></td>" ;
			            h+= "</tr>" ;
		        	}
		        });    
		        h+="</table>" ;
		    	document.getElementById("div1").innerHTML = h ;
		    });  
 
 }
    //初始加载页面时     
      
$(document).ready(function(){ 
	
	var h= "<table id='tb' border='1'>"; 
   // alert("加载..............");  
    var city=$("#city");//下拉框   
   	
   
	h+= "<tr>"  ;
	h+= "<td>用户名称</td>" ;
	h+= "<td>用户编号</td>" ;
	h+= "<td>投注倍数</td>" ;
	h+= "<td>投注金额</td>" ;
	h+= "<td>玩法编号</td>" ;
	h+= "<td>投注号码</td>" ;
	h+= "<td>中奖号码</td>" ;
	h+= "<td>预期结果</td>" ;
	h+= "<td>执行结果</td>" ;
	h+= "<td><input type='checkbox' id = 'checkAll' onclick='checkValue()' checked>操作</td>" ;
	h+= "</tr>" ;
	
    $.getJSON("GSB001.json",function(data){   
        //通过循环取出data里面的值         
        $.each(data,function(i,value){  
        	if(value.result == "pass") {
        		h+= "<tr bgcolor='14DB53'>" ;
        	}else if(value.result == "fail"){
        		h+= "<tr bgcolor='FA0019'>" ;
        	} else {
        		h+= "<tr>" ;
        	}
        	h+= "<td><input type='text' value = '"+value.comment+"' ></td>" ;
            h+= "<td><input type='text' value = '"+value.serialNumber+"' ></td>" ;
            h+= "<td>"+value.bs+"</td>" ;
            h+= "<td>"+value.wager_money+"</td>" ;
            h+= "<td>"+value.play_type+"</td>" ;
            h+= "<td><input type='text' value = '"+value.wager_num+"' ></td>" ;
            h+= "<td>"+value.pre_win_nun+"</td>" ;
            h+= "<td><input type='text' value = '"+value.pre_win_result+"' ></td>" ;
            h+= "<td>"+value.result+"</td>" ;
            h+= "<td><input type='checkbox' id = 'all' name = 'ts' checked></td>" ;
            h+= "</tr>" ;
        });    
        h+="</table>" ;
    	document.getElementById("div1").innerHTML = h ;
    });  

});  
    
 
  </script>  
  	
</body>
</html>