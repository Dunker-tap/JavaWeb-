<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册界面</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html {
            height: 100%;
        }

        body {
            height: 100%;
        }

        .container {
            height: 100%;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
        }

        .login-wrapper {
            background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }

        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }

        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }

        .input-item::placeholder {
            text-transform: uppercase;
        }

        .btn input {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 10px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
        }

        a {
            text-decoration-line: none;
            color: #abc1ee;
        }

        .checkCode {
            width: 150px;
            height: 40px;
            border: 1px solid black;
            padding-left: 10px;
        }

        .checkCodeBox li {
            list-style: none;
            float: left;
            margin-left: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">注册</div>
        <div class="form-wrapper">
            <form action="/registerServlet" method="post">
                <span style="color: red">${register_msg}</span>
                <label>
                    <input type="text" name="username" placeholder="用户名" class="input-item" value="${username}">
                </label>
                <label>
                    <input type="password" name="password" placeholder="密码" class="input-item" value="${password}">
                </label>
                <div class="checkCodeBox">
                    <ul>
                        <li>
                            <label>
                                <input type="text" name="checkCode" id="checkCode" placeholder="验证码" class="checkCode">
                            </label>
                        </li>
                        <li><img src="checkCodeServlet" alt="验证码" id="checkCodeImage"></li>
                        <li><a href="#" id="changeImg">换一张</a></li>
                    </ul>
                </div>
                <div class="btn">
                    <input type="submit" name="register" value="注册">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    //实现单击链接更换验证码功能
    document.getElementById("changeImg").onclick = function () {
        let milliseconds = new Date().getMilliseconds();
        //如果你的src写死了，"checkCodeServlet"，浏览器是会缓存你当前生成的验证码的，当你多次点击之后，
        // 浏览器发现你的验证码图片路径相同，就会直接使用缓存的那张图片、
        //我们想实现每次点击生成的图片(也就是图片的路径)不同，那么就需要我们去改变图片路径
        //那么什么样的路径是永远不同的呢？答案是拼接了时间变量的：注意拼接格式，不要漏掉‘?’
        document.getElementById("checkCodeImage").src = "checkCodeServlet?" + milliseconds;
    }
    //实现单击图片更换验证码功能
    document.getElementById("checkCodeImage").onclick = function () {
        let milliseconds = new Date().getMilliseconds();
        document.getElementById("checkCodeImage").src = "checkCodeServlet?" + milliseconds;
    }
</script>
</body>
</html>

