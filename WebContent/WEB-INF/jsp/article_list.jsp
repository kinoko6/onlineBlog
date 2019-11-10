<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html lang="en">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="description" content="">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	
	    <!-- Title -->
	    <title>所有文章</title>
	
	    <!-- Favicon -->
	    <link rel="icon" href="img/core-img/favicon.ico">
	
	    <!-- Stylesheet -->
	    <link rel="stylesheet" href="style.css">
	    <link rel="stylesheet" type="text/css" href="css/premium/bootstrap.min.css"/>
		<style type="text/css">
			.activeA{
				color: #20d8da;
				box-shadow: 0 0 5px  #337ab7;
				line-height:17px;
			}
			a{
				cursor:pointer;
			}
			a.dropA{
				width: 20px;
				height: 20px;
				border-radius: 50%;
				text-align: center;
				color: #000000;
				text-decoration: none;
			}
			input[type="checkbox"]{
				margin: 0 10px;	
				width: 15px;
				height: 15px;
				display: inline-block;
				vertical-align: middle;
			}
			
			.hide{
				visibility: hidden;
			}
			.show{
				visibility: visible;
				}
			div.show{
				visibility: visible;
				display:inline-block !important;
			}
			a.operA{
				text-decoration: none;
				font-size: 13px;
				font-weight: lighter;
				text-align: center;
				margin: 15px -15px 20px -15px;
			}
			@media  screen and (max-width:768px ) {
				input[type="checkbox"]{
				margin: 0 10px;	
				width: 30px;
				height: 30px;
				vertical-align: middle;
				}
				input[type="checkbox"]:checked{
					-webkit-appearance: none;
					background: url(img/core-img/selected.png) no-repeat center;
					background-size: cover;
					border: 1px solid black;
				}
			}
			ol li{
				height: 30px;
				padding-left: 20px;
			}
			ol li span{
				font-size: 13px;
			}
			.caret{
				display: none;
			}
			.btn-group{
				margin-bottom: 10px;
			}
	    </style>
	</head>
	
	<body>
	    <!-- Preloader -->
	    <div class="preloader d-flex align-items-center justify-content-center">
	        <div class="spinner">
	            <div class="bounce1"></div>
	            <div class="bounce2"></div>
	            <div class="bounce3"></div>
	        </div>
	    </div>
	
	 
	     <!-- ##### Header Area Start ##### -->
    <header class="header-area wow fadeInDown" data-wow-delay="500ms">
        <!-- Top Header Area -->
        <div class="top-header-area">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12 d-flex align-items-center justify-content-between">
                        <!-- Logo Area -->
                        <div class="logo">
                            <a href="toMain"><img src="img/core-img/logo.png" class="img-responsive" alt="Responsive image"></a>
                        </div>

                        <!-- Search & Login Area -->
                        <div class="search-login-area d-flex align-items-center">
                            <!-- Top Search Area -->
                            <div class="top-search-area">
                                <form action="#" method="post">
                                    <input type="search" name="top-search" id="topSearch" placeholder="搜索">
                                    <button type="submit" class="btn"><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                            <!-- Login Area -->
                            <div class="login-area">
                                <a href="quit"><span>注销</span> <i class="fa fa-lock" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Navbar Area -->
        <div class="egames-main-menu" id="sticker">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="egamesNav">

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                                <ul>
                                    <li><a href="toMain">主页</a>
                                    	<ul class="dropdown">
                                    		<li class="visible-xs"><a href="toMain" id="erji" style="text-indent: 15px;">主页</a></li>
                                            <li><a href="javascript:;" id="erji" style="text-indent: 15px;">二级学院</a></li>
                                            <li><a href="javascript:;" id="shiwu" style="text-indent: 15px;">失物招领</a></li>
                                             <li><a href="javascript:;" id="scence" style="text-indent: 15px;">校园美景</a></li>
                                        </ul>
                                    </li>
                                    
                                    
                                    <li><a href="loveWall">表白墙</a>
                                    </li>
                                    <li><a href="unused">闲置物品</a>
                                    </li>
                               
                                    </li>
                                    <li><a href="userPage">个人中心</a>
                                    	 <ul class="dropdown">
                                            <li><a href="articleList">所有文章</a></li>
                                            <li><a href="newArticle">写文章</a></li>
                                            <li><a href="userPage">个人信息</a></li>
                                        </ul>
                                    	
                                    </li>
                                </ul>
                            </div>
                            <!-- Nav End -->
                        </div>

                        <!-- Top Social Info -->
                        <div class="top-social-info" style="float: right;" >
                        <button class="btn btn-primary hidden-sm hidden-xs" style="background: #007bff;" type="button">
							  当前在线人数： <span class="badge badge-light">${applicationScope.onlineUserNumber}</span>
							</button>
                            <a href="#" data-toggle="tooltip" data-placement="top" title="Linkedin">${sessionScope.user.user_name}</a>
                          	<img src="${sessionScope.user.user_headphoto}" style="width: 30px;height: 30px; "/>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ##### Header Area End ##### -->

	 
	
	
	
	    <!-- ##### Breadcrumb Area Start ##### -->
	    <section class="breadcrumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/1.jpg);">
	        <div class="container h-100">
	            <div class="row h-100 align-items-center">
	                <!-- Breadcrumb Text -->
	                <div class="col-12">
	                    <div class="breadcrumb-text">
	                        <h2 style="margin-top: 0;">所有文章</h2>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
	    <!-- ##### Breadcrumb Area End ##### -->
	
	    <!-- ##### Contact Area Start ##### -->
	    <section class="contact-area section-padding-100">
	        <div class="container">
	        	
				<row>
					<div class="col-lg-2" style="padding-left: 0;">
					<div class="btn-group" >
					  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="batchOper">
					    批量操作 
					  </button>
					  <ul class="dropdown-menu">
					    <li><a href="#"  >批量操作</a></li>
					     <li role="separator" class="divider"></li>
					    <li><a href="#" >删除&nbsp;&nbsp;</a></li>
					  </ul>
					</div>
					<div class="btn-group" >
					    <button type="button" class="btn btn-default" id="batchBtn">应用</button>
					 </div>
					</div>			
					
				<div class="col-lg-4 hidden-xs" style="margin-left: -30px;">
					 <div class="btn-group">
					  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="dateBtn">
					   全部日期
					  </button>
					  <ul class="dropdown-menu">
					    <li><a href="#" >全部日期</a></li>
					     <li role="separator" class="divider"></li>
					     <c:forEach items="${sessionScope.dateSet}" var="date">
					    	<li><a href="#">${date}</a></li>
					    </c:forEach>
					  </ul>
					</div>
					<div class="btn-group">
					  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="typeBtn">
					   全部类型
					  </button>
					  <ul class="dropdown-menu">
					  	<li><a href="#" >全部类型</a></a></li>
					  	<li role="separator" class="divider"></li>
					    <li><a href="#" >普通表白</a></li>
					    <li><a href="#" >寻找失物</a></li>
					    <li><a href="#" >招领失物</a></li>
					    <li><a href="#" >闲置物品</a></li>
					  </ul>
					</div>
					<div class="btn-group">
					    <button type="button" class="btn btn-default" id="filterBtn">筛选</button>
					 </div>
				 </div>
				 
					<div class="col-lg-3 hidden-xs" style="float: right;padding-right: 0;">
						<!-- /input-group -->
						<div class="input-group" >
					      <input type="text" class="form-control" >
					      <span class="input-group-btn">
					        <button class="btn btn-default search" type="button" >搜索</button>
					      </span>
					    </div>
					</div>
					
				</row>
				
	        	<div class="table-responsive">
				     <table class="table table-hover">
						<tr> 
							 <th class=" col-lg-6 col-xs-12"><input type="checkbox" name="" id="mainCheckBox" value="" /> 标题</th>
							 <th class="hidden-xs">类型</th>
							 <th class="hidden-xs">发布时间</th>
							 <th class="hidden-xs">操作</th>
						</tr>
						
						<c:forEach items="${sessionScope.articleList}" var="article">
						<tr>
							<td class="col-lg-6 col-xs-12 titleTD" style="white-space:normal; font-size: 12px;" >
								<row>
								<input type="checkbox" name="id" id="" value="${article.id}" class="col-xs-3" />   <a href="viewArticle?articleId=${article.id}" class="col-xs-8" style="padding: 0 5px;">${article.theme}</a>	<div class="col-xs-1" id="dropDiv" ><a href="#" class="visible-xs dropA" >▼</a></div>
								</row>
								<row class="visible-xs operRow hide" >
									<a href="viewArticle?articleId=${article.id}" class="col-xs-4 operA" >查看</a> 	<a  href="editArticle?articleId=${article.id}" class="col-xs-4 operA">编辑</a>   	<a href="deleteArticle?articleIds=${article.id}" class="col-xs-4 operA" style="color: red;">删除</a>
								</row>
								<row class="visible-xs " id="metaRow">
									<ol class="col-xs-12" id="metaOl" style="display: none;">
										<li><span class="col-xs-4">类型</span>
											<c:if test="${article.type==0}">
												<span class="col-xs-8">普通表白</span>
											</c:if>
											<c:if test="${article.type==1}">
												<span class="col-xs-8">寻找失物</span>
											</c:if>
											<c:if test="${article.type==2}">
												<span class="col-xs-8">招领失物</span>
											</c:if>
											<c:if test="${article.type==3}">
												<span class="col-xs-8">闲置物品</span>
											</c:if>
										</li>
										<li><span class="col-xs-4">发布时间</span><span  class="col-xs-8">${article.publish_date}</span></li>
									</ol>
								</row>
								
							</td>
							<td  class="hidden-xs">
											<c:if test="${article.type==0}">
												普通表白
											</c:if>
											<c:if test="${article.type==1}">
												寻找失物
											</c:if>
											<c:if test="${article.type==2}">
												招领失物
											</c:if>
											<c:if test="${article.type==3}">
												闲置物品
											</c:if>							
							</td>
							<td  class="hidden-xs">${article.publish_date}</td>
							<td  class="hidden-xs">
								<ul>
									<li style="display: inline-block; color:#337ab7;"><a style="font-size: 14px;" href="editArticle?articleId=${article.id}">编辑</a></li>
									<li style="display: inline-block; " ><a style="font-size: 14px; color: red;" href="deleteArticle?articleIds=${article.id}">删除</a></li>
								</ul>
							</td>
						</tr>
						</c:forEach>
					</table>
	  			 </div>     
	      		 <row>
						<div class="col-xs-12 visible-xs" style="float: right;padding-right: 0;padding-left:0;">
							<!-- /input-group -->
							<div class="input-group" >
						      <input type="text" class="form-control" id="searchTxt">
						      <span class="input-group-btn">
						        <button class="btn btn-default search" type="button" >搜索</button>
						      </span>
						    </div>
						</div>
					</row>		
	        	</div>
	    </section>
	    <!-- ##### Contact Area End ##### -->
	
	   
	       <!-- ##### Footer Area Start ##### -->
	    <footer class="footer-area">
	        <!-- Main Footer Area -->
	        <div class="main-footer-area section-padding-100-0">
	            <div class="container">
	                <div class="row">
	                    <!-- Single Footer Widget -->
	                    <div class="col-12 col-sm-6 col-lg-3">
	                        <div class="single-footer-widget mb-70 wow fadeInUp" data-wow-delay="100ms">
	                            <div class="widget-title">
	                                <a href="toMain"><img src="img/core-img/logobk.png" alt=""></a>
	                            </div>
	                            <div class="widget-content">
	                                <p>引领校园博客潮流.</p>
	                                <p>争做校园博客弄潮儿.</p>
	                            </div>
	                        </div>
	                    </div>
	
	                    <!-- Single Footer Widget -->
	                    <div class="col-12 col-sm-6 col-lg-3">
	                        <div class="single-footer-widget mb-70 wow fadeInUp" data-wow-delay="300ms">
	                            <div class="widget-title">
	                                <h4>友情连接</h4>
	                            </div>
	                            <div class="widget-content">
	                                <nav>
	                                    <ul>
	                                        <li><a href="https://www.bilibili.com/">Bilibili</a></li>
	                                        <li><a href="https://www.baidu.com/">百度</a></li>
	                                        <li><a href="https://www.163.com/">网易</a></li>
	                                        <li><a href="https://www.tencent.com/zh-cn/index.html">腾讯</a></li>
	                                    </ul>
	                                </nav>
	                            </div>
	                        </div>
	                    </div>
	
	                    <!-- Single Footer Widget -->
	                    <div class="col-12 col-sm-6 col-lg-3">
	                        <div class="single-footer-widget mb-70 wow fadeInUp" data-wow-delay="500ms">
	                            <div class="widget-title">
	                                <h4>实用链接</h4>
	                            </div>
	                            <div class="widget-content">
	                                <nav>
	                                    <ul>
	                                        <li><a href="http://tec.suda.edu.cn/">学校官网</a></li>
	                                        <li><a href="http://210.28.65.7/">教务管理系统</a></li>
	                                        <li><a href="http://tecxsc.suda.edu.cn/">晨风学生网</a></li>
	                                        <li><a href="http://tecmy.suda.edu.cn/">信息门户</a></li>
	                                        <li><a href="http://wg.suda.edu.cn/">网关登录</a></li>
	                                    </ul>
	                                </nav>
	                            </div>
	                        </div>
	                    </div>
	
	                    <!-- Single Footer Widget -->
	                    <div class="col-12 col-sm-6 col-lg-3">
	                        <div class="single-footer-widget mb-70 wow fadeInUp" data-wow-delay="700ms">
	                            <div class="widget-title">
	                                <h4>萌新专栏</h4>
	                            </div>
	                            <div class="widget-content">
	                                <nav>
	                                    <ul>
	                                        <li><a href="http://tieba.baidu.com/f?kw=%E8%8B%8F%E5%B7%9E%E5%A4%A7%E5%AD%A6%E5%BA%94%E7%94%A8%E6%8A%80%E6%9C%AF%E5%AD%A6%E9%99%A2&ie=utf-8&tab=good&cid=0">校园贴吧</a></li>
	                                        <li><a href="http://mp.weixin.qq.com/s?__biz=MzI0MzU5NjQ3NQ==&mid=100006924&idx=1&sn=36c35e87df4cb6727575c36c1383b7e4&chksm=696bf1d85e1c78ce6867ecf353aa341d428a9f3a22cb5621964412c2035a920ebac660e185fd&mpshare=1&scene=23&srcid=1021EGZgIYIJkvuPXstJ6SbV&sharer_sharetime=1571654644918&sharer_shareid=a7618f34817ad1af216056ec9e96bd1f#rd">交通篇</a></li>
	                                        <li><a href="http://mp.weixin.qq.com/s?__biz=MzI0MzU5NjQ3NQ==&mid=2247490813&idx=1&sn=1bbc449822bc902660688716837e0573&chksm=e96bf129de1c783fb72b30e3ec1be4bd0c66521aaa92d6c97b3f42874109f411b2a46ba15778&mpshare=1&scene=23&srcid=1021XNwvnPoZqPj12PfmfMA7&sharer_sharetime=1571654847227&sharer_shareid=a7618f34817ad1af216056ec9e96bd1f#rd">美食篇</a></li>
	                                        <li><a href="http://mp.weixin.qq.com/s?__biz=MzI0MzU5NjQ3NQ==&mid=100006917&idx=1&sn=41e13e92220a94c739bda1df6262cba4&chksm=696bf1d15e1c78c7d0ca45595e40a1d6fb2ba51ac3f5fe27574a1b8440f7bbf341612d5d3f96&mpshare=1&scene=23&srcid=1021xReBeGPygtv26Aoi4lkO&sharer_sharetime=1571654914648&sharer_shareid=a7618f34817ad1af216056ec9e96bd1f#rd">快递篇</a></li>
	                                        <li><a href="http://mp.weixin.qq.com/s?__biz=MzI0MzU5NjQ3NQ==&mid=2247490806&idx=1&sn=5ca2f70100fb24085eeb714f2c91f899&chksm=e96bf122de1c78347fe52227b6bab1be417542d59640b83002dec4b45c7342514cdc23ae5066&mpshare=1&scene=23&srcid=1021XWGCd9XhDhRizfEWuqEz&sharer_sharetime=1571654966986&sharer_shareid=a7618f34817ad1af216056ec9e96bd1f#rd">生活篇</a></li>
	                                    </ul>
	                                </nav>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	
	        <!-- Copywrite Area -->
	        <div class="copywrite-content">
	            <div class="container h-100">
	                <div class="row h-100 align-items-center">
	                    <div class="col-12 col-sm-5">
	                        <!-- Copywrite Text -->
	                        <p class="copywrite-text"><a href="#">
	Copyright &copy;<script>document.write(new Date().getFullYear());</script> - Colorlib All rights reserved More Infomations <a href="#" target="_blank" title="模板之家">全映苏应校园说</a> - Designed For <a href="http://tec.suda.edu.cn/" title="target" target="_blank">Study</a>
	
	</p>
	                    </div>
	                    <div class="col-12 col-sm-7">
	                        <!-- Footer Nav -->
	                        <div class="footer-nav">
	                            <ul>
	                                <li><a href="toMain">主页</a></li>
	                                <li><a href="loveWall">表白墙</a></li>
	                                <li><a href="unused">闲置物品</a></li>
	                                <li><a href="userPage">个人中心</a></li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </footer>
	    <!-- ##### Footer Area End ##### -->
	    
	   
	   
	    
	    <!-- ##### All Javascript Script ##### -->
	    <!-- jQuery-2.2.4 js -->
	    <script src="js/jquery/jquery-2.2.4.min.js"></script>
	    <!-- Popper js -->
	    <script src="js/bootstrap/popper.min.js"></script>
	    <!-- Bootstrap js -->
	    <script src="js/bootstrap/bootstrap.min.js"></script>
	    <!-- All Plugins js -->
	    <script src="js/plugins/plugins.js"></script>
	    <!-- Active js -->
	    <script src="js/active.js"></script>
	</body>
	
	<script type="text/javascript">
		
		$.each($(".dropA"), function(index,elem) {
			$(elem).click(function(){
				if($(this).text()=="▼"){
					$(this).text("▲");
				}else{
					$(this).text("▼");
				}
				$(this).toggleClass("activeA");
				$(elem).parent().parent().parent().children("#metaRow").children("#metaOl").slideToggle(200);
			})
		});
	
	$("#mainCheckBox").click(function() { 
		if (this.checked){  
	        $("input[name='id']:checkbox").each(function(){ 
	              $(this).prop("checked", true);  
	        });
	    } else {   
	        $("input[name='id']:checkbox").each(function() {   
	              $(this).prop("checked", false);  
	        });
	    }  
	});
	
	$("ul li").click(function(){
		if(!$(this).hasClass("divider")){
			$(this).parent().prev().text( $(this).text() );
		}
	})
	
	$("#batchBtn").click(function(){
		
		var href="deleteArticle?articleIds=";
		$.each($(":checkbox"),function(index,elem){
			if($(this).prop("checked")==true && $(this).val()!='')
			{
				href+=$(this).val()+",";
			}
		});
		href=href.substring(0,href.length-1);
		location.href=href;
	});
	
	$("#filterBtn").click(function(){
		var href="filterArticle?";
		var filterDate="filterDate="+$("#dateBtn").text().trim();
		var filterType="filterType="+$("#typeBtn").text().trim();
		href=href+filterDate+"&"+filterType;
		location.href=href;
	});
	
	$.each($(".search"),function(index,elem){
		
		$(elem).click(function(){
			location.href="searchSelfArticles?keyWord="+$(this).parent().prev().val();
		});
	});
	$(".titleTD").hover(function(){
		$(this).children(".operRow").toggleClass("show");
	})
	
	</script>
	
	
	</html>