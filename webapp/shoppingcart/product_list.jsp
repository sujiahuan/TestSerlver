<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>产品列表</h1>
<form action="/addShoppingCart" method="post">
<select name="product">
<option>电脑</option>
<option>手机</option>
<option>纸巾</option>
</select>
购买数量：<input name="buyQuantity" type="number">
<button type="submit">添加至购物车</button>
</form><a href="${pageContext.getServletContext().getContextPath()}/queryShoppingCart">查看购物车</a>
</body>
</html>