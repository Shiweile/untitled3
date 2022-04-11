<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/4/5
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path", basePath);
%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="${path}css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/2018023211/user/login" id="form" method="post">
        <h1 id="loginMsg">中小企业物资管理系统</h1>
        <div id="errorMsg">${register_msg}${login_msg}</div>
        <p>账号:<input id="username" name="username" value='${cookie.username.value}' type="text"></p>

        <p>密码:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
        <p>记住密码:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="登录">
            <input type="reset" class="button" value="重新输入">&nbsp;&nbsp;&nbsp;
            <a href="/2018023211/register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>