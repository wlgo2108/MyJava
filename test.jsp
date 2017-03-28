<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-3.2.0.min.js"></script>
</head>
<body>

<div id = "search_div">
</div>

<div>
显示条数<select name = "pageY" id = "pageY">
		<option value = "10">10</option>
		<option value = "20">20</option>
		<option value = "30">30</option>
		<option value = "50">50</option>
		<option value = "100">100</option>
		<option value = "500">500</option>
		<option value = "1000">1000</option>
</select>
<input type=button id="btn1" value="首页" >
<input type=button id="btn2" value="上一页">
<input type=button id="btn3" value="下一页" >
<input type=button id="btn4" value="尾页" >
当前<input type="text" id = "pagenum" value = "" size = "5">页&nbsp;
跳转到<select name = "pageGoto" id = "pageGoto">
</select>页

</div>
<script type="text/javascript" charset="utf-8">
var pageSize = 10;//每页显示的记录条数
var curPage=0;
var lastPage;
var direct=0;
var len;
var page;
var pageGoto = $("#pageGoto") ;
$(document).ready(function(){ 
	
	var h= "<table id='table_search' border='1'>"; 
   // alert("加载..............");  
    var city=$("#search_div");//下拉框   

   
	h+= "<tr id ='head_tr'>"  ;
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
	
    $.getJSON("./js/GSB001.json",function(data){   
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
    	document.getElementById("search_div").innerHTML = h ;
    	
    	 len =$("#table_search tr").length - 1;
         page=(len % pageSize==0) ? (len/pageSize):((Math.floor(len/pageSize))+1);//根据记录条数，计算页数
       //  alert("page==="+page);
         
         curPage= 1;
         displayPage(1);//显示第一页
         $("#btn1").click(function(){
          curPage=1;
          displayPage();
      });
         $("#btn2").click(function(){
          direct=-1;
          displayPage();
      });
         $("#btn3").click(function(){
          direct=1;
          displayPage();
      });
         $("#btn4").click(function(){
          curPage=page;
         
          displayPage();
      });
         
       $("#pageY").change(function(){
    	   if(document.getElementById("pageY").value != null) {
    		   pageSize = parseInt(document.getElementById("pageY").value) ; 
    	   }
    	   curPage=1;
    	   page=(len % pageSize==0) ? (len/pageSize):((Math.floor(len/pageSize))+1);//根据记录条数，计算页数
    	
    	   displayPage() ;
    	   
       });
         
      $("#pageGoto").change(function(){
    	  if(document.getElementById("pageGoto").value != null) {
    		  curPage = parseInt(document.getElementById("pageGoto").value) ; 
   	   		}
    	
    	  displayPage() ;
      }) ;
         
    });  

});  
    
function displayPage(){
	  if((curPage <=1 && direct==-1) ){
	   direct=0;
	   alert("已经是第一页了");
	   return;
	  }else if (curPage >= page && direct==1){
		  direct=0;
		  alert("已经是最后一页了");
		  return;
	  }
	  lastPage = curPage;
	  
	  curPage = (curPage + direct + len) % len ;
	  document.getElementById("pagenum").value = curPage + "/"+page ;
	  document.getElementById("pageGoto").options.length=0;
      for(var i = 1 ; i <= page ; i ++) {
     	 var tempOption = document.createElement("option");     
          tempOption.value = i;  
          tempOption.innerHTML  = i;
          pageGoto.append(tempOption);  
      }
      document.getElementById("pageGoto").value = curPage
	  var begin=(curPage-1)*pageSize;//起始记录号
	  var end = begin + pageSize;
	  if(end > len ) end=len;
	     $("#table_search tr").hide();
	     $("#head_tr").show()
	     $("#table_search tr").each(function(i){
	         if(i>=begin && i<end)//显示第page页的记录
	        	 
	             $(this).show();
	         	
	     });

	 }
  </script>  
</body>
</html>