<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/addServlet" method="post">
    <table>
        <tr>
            <td>
                品牌名称：<label><input name="brandName"></label>
                <br>
            </td>
        </tr>
        <tr>
            <td>
                企业名称: <label><input name="companyName"></label>
                <br>
            </td>
        </tr>
        <tr>
            <td>
                排序大小: <label><input name="ordered"></label>
                <br>
            </td>
        </tr>
    </table>

    描述信息:<br>
    <label>
        <textarea rows="5" cols="20" name="description"></textarea>
    </label><br>
    状态:
    <label>
        <input type="radio" name="status" value="0">
    </label>禁用
    <label>
        <input type="radio" name="status" value="1">
    </label>启用<br>
    <input type="submit" value="提交">
</form>
</body>
</html>
