<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>图书管理系统</title>
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/common.js"></script>
		<script type="text/javascript" src="js/layui/lay/dest/layui.all.js"></script>
		<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
		<style>
			body{
				padding-top: 20px;
				background: url("09.jpg") no-repeat;
				background-size: 100% 100%;
				background-attachment: fixed;
			}
			h3{
				color: aliceblue;
				font-family: "宋体";
			}
			form{
				border: 0.8px solid rgba(170, 255, 255, 0.2);
				border-radius: 25px;
				background-color: rgba(170, 149, 137, 0.2);
			}
			div{
				margin-top: 20px;
				margin-left: 20%;
				margin-right: 20%;
			}
			.in{
				width: 275px;
				margin-left: 20%;
				margin-right: 20%;
				height: 30px;
				border: 0.5px solid rgba(255, 255, 255, 0.8);
				border-radius: 5px;
				background-color: rgba(150, 184, 154, 0.7);
				color: azure;
				font-family: "黑体";
				font-size: 16px;
				text-align-last: center;
			}
			.img-circle{
				border-radius: 50% ;
				border: 1px solid rgb(170, 171, 168);
			}
			input[type="radio"] {
			    width: 14px;
				height: 14px;
			    text-align: center;
				cursor: pointer;
			    margin-right: 10px;
			    background-image: url(images/inputradio.gif);
			    background-repeat: no-repeat;
			    background-position: -24px 0;
			}
			label{
				color: aliceblue;
				font-family: "宋体";
			}
		</style>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#register').click(function(){
					window.location.href="register_page.jsp";
				});
			});
		</script>
	</head>
	<body>
		<!--<form action="" method="post">-->
			<center>
				<div class="div1">
					<img src="10.jpg" class="img-circle" style="width: 80px; height: 80px; align-items: center;">
					<h3>用户登录</h3>
				</div>
				<div style="padding: 10px 20px 20px;">
					<form class="bs-example bs-example-form" id="f" role="form" style="width: 450px; height: 280px;">
						<div class="input-group" style="width: 100%;">
							<span class="input-group-addon">用户名：</span>
							<input type="text" class="form-control" placeholder="用户名/手机号码" style="width: 200px;">
						</div>
						<div class="input-group" style="width: 100%; align-content: center;">
							<span class="input-group-addon">密&nbsp; &nbsp;码：</span>
							<input type="password" class="form-control" placeholder="密码" style="width: 200px;">
						</div>
						<div class="radios">
							<input type="radio" name="user" class="user" value="普通用户" title="普通用户">
							<label style="font-size: 15px;">普通用户</label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="dbauser" class="user" value="管理员" title="管理员">
							<label style="font-size: 15px;">管理员</label>
						</div><br/>
						<input type="submit" value="登&nbsp;&nbsp;&nbsp;录" class="in" /><br /><br />
						<input type="button" value="注&nbsp;&nbsp;&nbsp;册" class="in" id="register" />
					</form>
				</div>
			</center>
		<!--</form>-->
	</body>
</html>
