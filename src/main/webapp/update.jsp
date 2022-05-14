<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
</head>
<body>
<h3>修改信息</h3>
<form action="${pageContext.request.contextPath}/updateServlet" method="post">
    <table>
        <tr>
            <td>
                <input type="hidden" name="id" value="${brand.id}">
            </td>
        </tr>
        <tr>
            <td>
                品牌名称：<label><input name="brandName" value="${brand.brandName}"></label>
                <br>
            </td>
        </tr>
        <tr>
            <td>
                企业名称: <label><input name="companyName" value="${brand.companyName}"></label>
                <br>
            </td>
        </tr>
        <tr>
            <td>
                排序大小: <label><input name="ordered" value="${brand.ordered}"></label>
                <br>
            </td>
        </tr>
    </table>

    描述信息:<br>
    <label>
        <textarea rows="5" cols="20" name="description">${brand.description}</textarea>
    </label><br>
    状态:
    <c:if test="${brand.status == 0}">
        <label>
            <input type="radio" name="status" value="0" checked>
        </label>禁用
        <label>
            <input type="radio" name="status" value="1">
        </label>启用<br>
    </c:if>

    <c:if test="${brand.status == 1}">
        <label>
            <input type="radio" name="status" value="0">
        </label>禁用
        <label>
            <input type="radio" name="status" value="1" checked>
        </label>启用<br>
    </c:if>
    <input type="submit" value="提交">
</form>
</body>
</html>
