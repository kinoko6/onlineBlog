<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css" href="css/premium/bootstrap.min.css"/>
	<style type="text/css">
		body,html{
			height: 100%;
		}
			.bg{
				background-image: url(img/235228-1549900348f5ed.jpg) ;
				background-repeat: no-repeat;
				background-size: cover;
			}
			@media  screen and (max-width: 1100px) and (min-width: 320px){
            .login-form{
            	color: white;
            }
        }	
        #alertBox{
        	text-align:center;
        }
        
	</style>
  </head>
  <body class="bg">
  			
			<div class="container login-area" style="padding-top: 150px">
			<c:if test="${not empty sessionScope.login_message}">
			<div class="row">
				<div class="alert alert-danger col-lg-4 col-lg-offset-4   col-xs-12 " id='alertBox' role="alert">${sessionScope.login_message}</div>
			</div>
			</c:if>
			<div class="row">
				<div class="  col-sm-4 col-sm-push-4 col-lg-4 col-lg-push-4">
					<img src="img/big-logo.png"  class="img-responsive" alt="Responsive image" style="margin: 0 auto;"/>
				</div>	
			</div>
			<div class="row">
					<div class="col-sm-6 col-sm-push-3  col-md-4 col-md-push-4  ">
							<form class="login-form" action="login" method='post'>
							  <div class="form-group">
							    <label for="exampleInputEmail1">邮箱</label>
							    <input type="email" class="form-control" name="userEmail" placeholder="Email">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputPassword1">密码</label>
							    <input type="password" class="form-control" name="userPassword" placeholder="Password">
							  </div>
							  
							  			<p >
										    <label>
										    	忘记密码
										    </label>
										     <button type="button" class="btn btn-info" id="regbtn">注册</button>
										 	<button type="submit" class="btn btn-default" style="float: right;">登录</button>
							 			</p>
							</form>	
					</div>
			</div>
  </body>
  
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript">
    	$("#regbtn").click(function(){
				location.href="register.jsp"			    		
    	})
    </script>
</html>