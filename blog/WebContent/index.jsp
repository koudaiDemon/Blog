<%@page import="com.softeem.dto.Manager"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SOFTEEM博客管理系统</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="apple-touch-icon-precomposed" href="images/icon/icon.png">
<link rel="shortcut icon" href="images/icon/favicon.ico">
<script src="js/jquery-2.1.4.min.js"></script>
</head>

<body class="user-select">
<section class="container-fluid">
  <header>
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
          <a class="navbar-brand" href="/">SOFTEEMCMS</a> </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="">消息 <span class="badge">1</span></a></li>
            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${manager.username} <span class="caret"></span></a>
              <ul class="dropdown-menu dropdown-menu-left">
                <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>
                <li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>
              </ul>
            </li>
            <li><a href="quit" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
            <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>
          </ul>
          <form action="" method="post" class="navbar-form navbar-right" role="search">
            <div class="input-group">
              <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索" maxlength="15">
              <span class="input-group-btn">
              <button class="btn btn-default" type="submit">搜索</button>
              </span> </div>
          </form>
        </div>
      </div>
    </nav>
  </header>
  <div class="row">
    <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="index.jsp">报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="article.jsp">文章</a></li>
        <li><a href="notice.jsp">公告</a></li>
        <li><a href="comment.jsp">评论</a></li>
        <li><a data-toggle="tooltip" data-placement="bottom" title="网站暂无留言功能">留言</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="category.jsp">栏目</a></li>
        <li><a class="dropdown-toggle" id="otherMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">其他</a>
          <ul class="dropdown-menu" aria-labelledby="otherMenu">
            <li><a href="flink.jsp">友情链接</a></li>
            <li><a data-toggle="modal" data-target="#areDeveloping">访问记录</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户</a>
          <ul class="dropdown-menu" aria-labelledby="userMenu">
            <li><a href="manage-user.jsp">管理用户</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="loginlog.jsp">管理登录日志</a></li>
          </ul>
        </li>
        <li><a class="dropdown-toggle" id="settingMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">设置</a>
          <ul class="dropdown-menu" aria-labelledby="settingMenu">
            <li><a href="setting.jsp">基本设置</a></li>
            <li><a href="readset.jsp">阅读设置</a></li>
            <li role="separator" class="divider"></li>
            <li><a data-toggle="modal" data-target="#areDeveloping">安全配置</a></li>
            <li role="separator" class="divider"></li>
            <li class="disabled"><a>扩展菜单</a></li>
          </ul>
        </li>
      </ul>
    </aside>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
      <h1 class="page-header">信息总览</h1>
      <div class="row placeholders">
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>文章</h4>
          <span class="text-muted" id="articleCount"></span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>评论</h4>
          <span class="text-muted" id="commCount"></span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>友链</h4>
          <span class="text-muted" id="flinkCount"></span> </div>
        <div class="col-xs-6 col-sm-3 placeholder">
          <h4>访问量</h4>
          <span class="text-muted" id="readCount"></span> </div>
      </div>
      <h1 class="page-header">状态</h1>
      <div class="table-responsive">
        <table class="table table-striped table-hover">
          <tbody>
            <tr>
              <td>登录者: <span>${manager.username}</span>，这是您第 <span>${manager.loadCount}</span> 次登录</td>
            </tr>
            <tr>
              <td>上次登录时间:<fmt:formatDate value="${manager.lastLoadTime}" var="time" scope="page" pattern="yyyy年MM月dd日 hh:mm:ss"/><span>&nbsp; ${time}</span> , 上次登录IP: <span>${manager.lastLoadIp}</span></td>
            </tr>
          </tbody>
        </table>
      </div>
      <h1 class="page-header">系统信息</h1>
      <div class="table-responsive">
        <table class="table table-striped table-hover">
          <thead>
            <tr> </tr>
          </thead>
          <tbody>
            <tr>
              <td>管理员个数:</td>
              <td id="managerCount"></td>
              <td>服务器软件:</td>
              <td>Apache Tomcat8.0</td>
            </tr>
            <tr>
              <td>浏览器:</td>
              <td id="browser"></td>
              <td>JDK版本:</td>
              <td>1.8</td>
            </tr>
            <tr>
              <td>登录者IP:</td>
              <td id="loadIp"></td>
              <td>MYSQL版本:</td>
              <td>5.5.40</td>
            </tr>
            <tr>
              <td>程序版本:</td>
              <td class="version">SOFTEEMCMS 1.0 <font size="-6" color="#BBB">(20160108160215)</font></td>
              <td>上传文件:</td>
              <td>可以 <font size="-6" color="#BBB">(最大文件：2M ，表单：8M )</font></td>
            </tr>
            <tr>
              <td>程序编码:</td>
              <td>UTF-8</td>
              <td>当前时间:</td>
              <td><span id="nowTime"> </span> </td>
            </tr>
          </tbody>
          <tfoot>
            <tr></tr>
          </tfoot>
        </table>
      </div>
      <footer>
        <h1 class="page-header">程序信息</h1>
        <div class="table-responsive">
        <table class="table table-striped table-hover">
          <tbody>
            <tr>
              <td><span style="display:inline-block; width:8em">版权所有</span> POWERED BY WY ALL RIGHTS RESERVED</td>
            </tr>
            <tr>
              <td><span style="display:inline-block;width:8em">页面加载时间</span> PROCESSED IN 1.0835s  SECONDS ：<a href="http://www.mycodes.net/" target="_blank">SOFTEEM</a></td>
            </tr>
          </tbody>
        </table>
        </div>
      </footer>
    </div>
  </div>
</section>
<!--个人信息模态框-->
<div class="modal fade" id="seeUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <form action="doUpdate?flag=manager" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" >个人信息</h4>
        </div>
        <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr>
              <th><div style="margin-left:10px;color:#f00;text-align: center;font-size:1.5em">${msg}</div> </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td width="20%">姓名:</td>
                <td width="80%"><input type="text" value="${manager.username }" class="form-control" name="truename" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">用户名:</td>
                <td width="80%"><input type="text" value="${manager.username }" class="form-control" name="username" maxlength="10" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">电话:</td>
                <td width="80%"><input type="text" value="${manager.phone }" class="form-control" name="usertel" maxlength="13" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">旧密码:</td>
                <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">新密码:</td>
                <td width="80%"><input type="password" class="form-control" name="password" maxlength="18" autocomplete="off" /></td>
              </tr>
              <tr>
                <td width="20%">确认密码:</td>
                <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="18" autocomplete="off" /></td>
              </tr>
            </tbody>
            <tfoot>
              <tr></tr>
            </tfoot>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
<!--个人登录记录模态框-->
<div class="modal fade" id="seeUserLoginlog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >登录记录</h4>
      </div>
      <div class="modal-body">
          <table class="table" style="margin-bottom:0px;">
            <thead>
              <tr>
                <th>登录IP</th>
                <th>登录时间</th>
                <th>状态</th>
              </tr>
            </thead>
            <tbody id="loadInfo">
<!--               <tr> -->
<!--                 <td>192.168.46.11</td> -->
<!--                 <td>2016-01-08 15:50:28</td> -->
<!--                 <td>成功</td> -->
<!--               </tr> -->
<!--               <tr> -->
<!--                 <td>192.168.46.12</td> -->
<!--                 <td>2016-01-08 10:27:44</td> -->
<!--                 <td>成功</td> -->
<!--               </tr> -->
<!--               <tr> -->
<!--                 <td>192.168.46.13</td> -->
<!--                 <td>2016-01-08 10:19:25</td> -->
<!--                 <td>成功</td> -->
<!--               </tr> -->
<!--               <tr> -->
<!--                 <td>192.168.46.15</td> -->
<!--                 <td>2016-01-06 10:35:12</td> -->
<!--                 <td>成功</td> -->
<!--               </tr> -->
            </tbody>
          </table>
		<footer class="message_footer" id="paging" style="text-align:center">
           
       	</footer>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--微信二维码模态框-->
<div class="modal fade user-select" id="WeChat" tabindex="-1" role="dialog" aria-labelledby="WeChatModalLabel">
  <div class="modal-dialog" role="document" style="margin-top:120px;max-width:280px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="WeChatModalLabel" style="cursor:default;">微信扫一扫</h4>
      </div>
      <div class="modal-body" style="text-align:center"> <img src="images/weixin.jpg" alt="" style="cursor:pointer"/> </div>
    </div>
  </div>
</div>
<!--提示模态框-->
<div class="modal fade user-select" id="areDeveloping" tabindex="-1" role="dialog" aria-labelledby="areDevelopingModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="areDevelopingModalLabel" style="cursor:default;">该功能正在日以继夜的开发中…</h4>
      </div>
      <div class="modal-body"> <img src="images/baoman/baoman_01.gif" alt="深思熟虑" />
        <p style="padding:15px 15px 15px 100px; position:absolute; top:15px; cursor:default;">很抱歉，程序猿正在日以继夜的开发此功能，本程序将会在以后的版本中持续完善！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">朕已阅</button>
      </div>
    </div>
  </div>
</div>
<!--右键菜单列表-->
<div id="rightClickMenu">
  <ul class="list-group rightClickMenuList">
    <li class="list-group-item disabled">欢迎访问SOFTEEM博客</li>
    <li class="list-group-item"><span>IP：</span>172.16.10.129</li>
    <li class="list-group-item"><span>地址：</span>河南省郑州市</li>
    <li class="list-group-item"><span>系统：</span>Windows10 </li>
    <li class="list-group-item"><span>浏览器：</span>Chrome47</li>
  </ul>
</div>
<script src="js/bootstrap.min.js">
</script> 
<script src="js/admin-scripts.js"></script>
<script>
// 	登陆信息自动加载
// 	$(function(){
<%-- 		var list = '<%=session.getAttribute("list")%>'; --%>
// 		for(var i = 0 ; i < list.length ;i++){
// 			var loadInfo = $('<tr><td>'+list[i].lastLoadIp+'</td> <td>'+list[i].lastLoadTime+'</td> <td>成功</td></tr>');
// 		}
// 		$('loadInfo').append(loadInfo);
// 	})
//异步获取初始化数据
$.get('index',function(data){
	data = JSON.parse(data);
	$('#articleCount').text(data.aticleCount+'条');
	$('#commCount').text(data.commCount+'条');
	$('#flinkCount').text(data.flinkCount+'条');
	$('#readCount').text(data.readCount+'');
	$('#managerCount').text(data.managerCount+'人');
	var nowTime = new Date();
	$('#nowTime').text(nowTime.getFullYear()+'年'+(nowTime.getMonth()+1)+'月'+nowTime.getDate()+'日  '+nowTime.getHours()+':'+nowTime.getMinutes()+':'+nowTime.getSeconds());
	$('#browser').text(data.browser+'');
	$('#loadIp').text(data.loadIp+'');
})
goPageLoginInfo(1);
function goPageLoginInfo(cp){
	$.get('list?flag=loadInfo',{'cp':cp,'mid':'<%=((Manager)session.getAttribute("manager")).getId()%>'},function(data){
	var tr = ''
	for(var i = 0 ; i < data.list.length ; i++){
		tr += '<tr>';
		tr += '<td>'+data.list[i].loadIp+'</td>';
		var lastLoadTime = new Date();
		lastLoadTime.setTime(data.list[i].loadTime);
		var time = lastLoadTime.getFullYear()+'-'+(lastLoadTime.getMonth()+1)+'-'+lastLoadTime.getDate()+'  '+lastLoadTime.getHours()+':'+lastLoadTime.getMinutes()+':'+lastLoadTime.getSeconds();
		tr += '<td>'+time+'</td>';
		tr += '<td>成功</td>';
		tr += '</tr>';
		}
		$('#loadInfo').html($(tr));
		genPageLink(data);
	})
}
//生成分页连接函数
function genPageLink(pd){
	var totalList = 4;//限制最多显示6页
	var cp = pd.currentPage;//当前页
	var total = pd.totalPage;//总页数
	var pre = cp -1;	//上一页
	var next = cp +1;	//下一页
	
	var start = 1;
	var end = totalList;
	//限制总页数显示
	if(cp >= totalList){
		start = cp - 2;
		end = cp + 2;
		if(end >= total){
			end = total;
		}
		if(end > total-2){
			start = total-3;
		}
	}else{
		start = 1;
		if(cp == 3){
			start = cp - 1;
			end = cp + 1;
		}
		if(end >= total){
			end = total;
		}
	}
	var ul = '<ul class="pagination">';
	if(pd.currentPage == 1){
		ul += '<li class="disabled"><a href="javascript:goPageLoginInfo('+pd.pre+')">&laquo;</a></li>'
	}else{
		ul += '<li><a href="javascript:goPageLoginInfo('+pd.pre+')">&laquo;</a></li>'
	}
	for(var i = start ; i <= end ; i++){
		//如果当前遍历到的页码数等于当前页，则当前页码被激活class='active'
		if(pd.currentPage == i){
			ul += '<li class="active"><a href="javascript:goPageLoginInfo('+i+')">'+i+'</li>';
		}else{
			ul += '<li><a href="javascript:goPageLoginInfo('+i+')">'+i+'</li>';
		}
	}
	if(pd.currentPage == pd.totalPage){
		ul += '<li class="disabled"><a href="javascript:goPageLoginInfo('+pd.next+')">&raquo;</a></li>'
	}else{
		ul += '<li><a href="javascript:goPageLoginInfo('+pd.next+')">&raquo;</a></li>'
	}
	ul +='</ul>';
	$('#paging').html($(ul));
}
</script>
</body>
</html>
