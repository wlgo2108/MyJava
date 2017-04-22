<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人测试工具---首页</title>
<style>
#header {
    background-color:#E4F2FB;
    color:white;
    text-align:center;
    padding:5px;
}
#nav {
    line-height:30px;
    background-color:#eeeeee;
    height:450px;
    width:220px;
    float:left;
    padding:5px;	      
}
#section {
    width:350px;
    float:left;
    padding:10px;	 	 
}
#footer {
    background-color:#E4F2FB;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
</style>
</head>

<body>

<div id="header">
<h1>HELLO WORLD</h1>
</div>

<div id="nav">
<jsp:include page="menu.jsp"/>
</div>

<div id="section">
<iframe src="main.jsp"  name="myMain" width="1000px" height="450px"></iframe>
</div>

<div id="footer">
Copyright ? W3Schools.com
</div>

</body>
</html>
