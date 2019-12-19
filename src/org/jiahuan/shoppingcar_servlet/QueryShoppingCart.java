package org.jiahuan.shoppingcar_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jiahuan.shoppingcart_demo.ShoppingCart;

@WebServlet("/queryShoppingCart")
public class QueryShoppingCart extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.获取数据，封装对象
		ShoppingCart cart=(ShoppingCart)req.getSession().getAttribute("CART_IN_SESSION");
		// 2.处理业务逻辑
		if(cart==null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			req.getSession().setAttribute("CART_IN_SESSION", shoppingCart);
		}
		// 3.跳转页面
		resp.sendRedirect(req.getContextPath()+"/shoppingcart/cart_list.jsp");
	}
}
