
<span style="font-size:18px;"><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<title>导航菜单</title>

<style type="text/css">

/*CSS全局设置*/

*{

   margin:0;

   padding:0;

   font-size:18px;

   font-family:"微软雅黑";

}

.nav{

   height:50px;

   margin-top:20px;

   margin-left:10px;

}

.nav ul{

   list-style:none;

   height:50px;

   border-bottom:10px solid #FF6600;

   padding-left:30px;

}

.nav li{

   float:left;

   margin-top:10px;

}

.nav li a{

    background-color:#EEEEEE;

    text-decoration:none;

    color:#000000;

    display:block;

    width:90px;

    height:40px;

    line-height:40px;

    text-align:center;

    margin-left:1px;

}

.nav li a:hover,.nav li a.on{

    background-color:#FF6600;

    color:#FFFFFF;

    /*伸缩变换设置高度变化*/

    height:60px;

    /*和使用负值向反方向移动*/

    margin-top:-10px;

    line-height:60px;

}

</style>

</head>

 

<body>

<div id="nav" class="nav">

     <ul>

	<li><a class="on" href="#">网站首页</a></li>

	<li><a href="#">课程大厅</a></li>

	<li><a href="#">学习中心</a></li>

	<li><a href="#">经典案例</a></li>

	<li><a href="#">关于我们</a></li>

    </ul>

</div>

</body>

</html>

</span>
