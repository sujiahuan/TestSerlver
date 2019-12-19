<%@page import="org.jiahuan.shoppingcart_demo.ShoppingCart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>购物车列表</h1>
<table border="1" cellspacing="0" width="500px" style="text-align: center;">
<tr>
<td>编号</td>
<td>商品名称</td>
<td>商品价钱</td>
<td>商品数量</td>
<td>操作</td>
</tr>
<%
ShoppingCart cart=(ShoppingCart)pageContext.findAttribute("CART_IN_SESSION");
for(int i =0;i<cart.getInventory().size();i++){
%>
<tr>
<td><%=cart.getInventory().get(i).getId() %></td>
<td><%=cart.getInventory().get(i).getName() %></td>
<td><%=cart.getInventory().get(i).getUnivalence() %></td>
<td><%=cart.getInventory().get(i).getBuyQuantity() %></td>
<td><a href="${pageContext.getServletContext().getContextPath()}/deleteShoppingCart?id=<%=cart.getInventory().get(i).getId()%>">删除</a></td>
</tr>	
<%
}
if(cart.getInventory().size()==0){
	%>
<tr>
	<td colspan="5" style="text-align: content: ;">亲，没有东西咦</td>
	</tr>
	<%	
}else{
	%>
	<tr>
	<td colspan="5" style="text-align: right;">总价：${CART_IN_SESSION.getTotalPrice()}</td>
	</tr>
	<%
}
%>
</table>
<a href="${pageContext.getServletContext().getContextPath()}/shoppingcart/product_list.jsp">继续购物</a>
</body>
</html>