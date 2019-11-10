<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>文章浏览</title>

    <!-- Favicon -->
   <link rel="icon" href="img/core-img/favicon.png">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" type="text/css" href="css/premium/bootstrap.min.css"/>
        <style type="text/css">
        	h2 {
				margin-top: 0px;
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
    <section class="breadcrumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/23.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <!-- Breadcrumb Text -->
                <div class="col-12">
                    <div class="breadcrumb-text">
                     <h2>
                    <c:if test="${sessionScope.article.type==0}">
                     		  普通表白
                    </c:if>
                     <c:if test="${sessionScope.article.type==1}">
                     		  寻找失物
                    </c:if>
                     <c:if test="${sessionScope.article.type==2}">
                     		  招领失物
                    </c:if>
                     <c:if test="${sessionScope.article.type==3}">
                     		 闲置物品
                    </c:if>
                    </h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Post Details Area Start ##### -->
    <section class="post-news-area section-padding-0-100">
        <div class="container">
            <div class="row justify-content-center">
                <!-- Post Details Content Area -->
                <div class="col-12 col-lg-12">
                    <div class="mt-100">
                        <div class="post-details-content mb-100">
                            <div class="blog-thumbnail mb-50">
                            </div>
                            <div class="blog-content">
                                <h4 class="post-title">${sessionScope.article.theme}</h4>
                                <div class="post-meta mb-30">
                                    <a href="#"  class="post-date">${sessionScope.article.publish_date}</a>
                                    <a href="#" class="post-author">${sessionScope.article.author.user_name}</a>
                                    <a href="#" class="post-comments">${sessionScope.article.click_sum}人看过</a>
                                </div>
                                ${sessionScope.article.content}
                            </div>
                            
                        </div>

                        <!-- Comment Area Start -->
                        <div class="comment_area clearfix mb-70">
                            <h4 class="mb-50">评论</h4>

                            <ol>
                                <!-- Single Comment Area -->
                                <c:forEach items="${article.comments}" var="comment">
                                <li class="single_comment_area">
                                    <!-- Comment Content -->
                                    <div class="comment-content d-flex">
                                        <!-- Comment Author -->
                                        <div class="comment-author">
                                          	  <img src="${comment.user.user_headphoto}" alt="图片显示异常">
                                        </div>
                                        <!-- Comment Meta -->
                                        <div class="comment-meta">
                                            <a href="#" class="post-author"><span id="uname">${comment.user.user_name}</span> </a>
                                            <a href="#" class="post-date">${comment.comment_date}</a>
                                            <p>${comment.comment_content}</p>
                                            <a href="#reply" class="reply">回复</a>
                                            <span style="display: none">${comment.id}</span>
                                            <span style="display: none">${comment.user.user_id}</span>
                                        </div>
                                    </div>	

                                    <ol class="children">
                                    	 <c:forEach items="${comment.subComment}" var="subComm">
                                        <li class="single_comment_area">
                                            <!-- Comment Content -->
                                            <div class="comment-content d-flex">
                                                <!-- Comment Author -->
                                                <div class="comment-author">
			                                          	  <img src="${subComm.user.user_headphoto}" alt="图片显示异常">
                                                </div>
                                                <!-- Comment Meta -->
                                                <div class="comment-meta">
                                                    <a href="#" class="post-author"><span id="uname">${subComm.user.user_name}</span> &nbsp;<span style="font-size:12px;color:gray">回复了</span>  &nbsp;<span style="font-size:13px;color:#999"> ${subComm.reply_user_info.user_name} </span> </a>
                                                    <a href="#" class="post-date">${subComm.comment_date}</a>
                                                    <p>${subComm.comment_content}</p>
                                                    <a href="#reply" class="reply">回复</a>
                                                    <span style="display: none" >${comment.id}</span>
                                                    <span style="display: none">${subComm.user.user_id}</span>
                                                </div>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ol>
                                </li>
								</c:forEach>
                                
                            </ol>
                            <div class="col-12" style="text-align: center;margin-top: 20px">
                                        	没有更多信息
                             </div>
                        </div>

                        <div class="post-a-comment-area mb-30 clearfix" id="reply">
                            <h4 class="mb-50">留言</h4>

                            <!-- Reply Form -->
                            <div class="contact-form-area">
                                <form action="newComment" method="post">
                                    <div class="row">
                                    
                                    	<input type="hidden" value="${sessionScope.article.id}" name="article_id" >
                                    	<input type="hidden" value="${sessionScope.user.user_id}" name="user_id" >
                                    	<input type="hidden" value="0" name="reply_user_id" id="replyUserId">
                                    	<input type="hidden" value="0" name="super_id" id="superCommentId">
                                        <div class="col-12" style="display: none;cursor: pointer;" id="replydiv">
                                            <span  class="form-control" id="replyName" ></span>
                                        </div>
                                        <div class="col-12">
                                            <textarea name="comment_content" class="form-control" id="message" cols="30" rows="10" placeholder="Message"></textarea>
                                        </div>
                                        <div class="col-12">
                                            <button class="btn egames-btn w-100" type="submit">发表评论</button>
                                        </div> 
                                    </div>
                                </form>
                            </div>
                     
                     
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Post Details Area End ##### -->

   
   
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
	$(".reply").click(function(){
		$("#replyName").text("@ "+$(this).prev().prev().prev().children(":first").text());
		$("#replydiv").show(1000);
		//需要@的用户id
		$("#replyUserId").val($(this).next().next().text());
		//父评论的id   0表示评论文章   非零表示用户互评
		$("#superCommentId").val($(this).next().text())
	});
	$("#replydiv").click(function(){
		$("#replydiv").hide(1000);
		$("#replyUserId").val("0");
		$("#superCommentId").val("0");
	});
</script>

</html>