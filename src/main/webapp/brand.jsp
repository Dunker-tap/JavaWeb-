<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
<h1>${user.username},欢迎您 ^_^</h1>
<a href="addBrand.jsp">
    <input type="button" name="新增" id="add" value="新增"></a>
<hr>
<table border="1px" cellspacing="0" align="center" width="70%">
    <tr align="center">
        <td>编号</td>
        <td>品牌名称</td>
        <td>公司名称</td>
        <td>排序</td>
        <td>品牌介绍</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${brands}" var="brand">
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>
                <c:if test="${brand.status == 1}">
                启用
                </c:if>
                <c:if test="${brand.status == 0}">
                禁用
                </c:if>
            <td>
                <a href="/selectByIdServlet?id=${brand.id}">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<script>
    document.getElementById("add").onclick = function () {
        location.href = "/brand.jsp";
    }
</script>
</body>
</html>
