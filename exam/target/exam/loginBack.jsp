<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>后台管理登录</title>
    <link rel="stylesheet" href="/exam/static/backpages/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/exam/static/backpages/css/login.css" />
</head>

<body>

    <div class="container">

        <form class="form-signin" action="backTeacherController/login" method="POST">
            <h2 class="form-signin-heading">俄语学习系统后台登录</h2>
            <label for="inputId" >工号:</label>
            <input type="text" id="inputId" class="form-control" placeholder="请输入您的工号" name="teacherNumber">
            <label for="inputPassword" >密码:</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="请输入您的密码" name="teacherPassword">
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>

    </div>
</body>

</html>