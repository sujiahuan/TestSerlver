package org.jiahuan.shoppingcar_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jiahuan.shoppingcart_demo.Merchandise;
import org.jiahuan.shoppingcart_demo.ShoppingCart;

@WebServlet(value = "/addShoppingCart")
public class AddShoppingCart extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 1.接受数据，封装对象
		String product = req.getParameter("product");
		String buyQuantity = req.getParameter("buyQuantity");
		System.out.println(product);
		Merchandise merchandise = new Merchandise();
		merchandise.setName(product);
		merchandise.setBuyQuantity(Integer.valueOf(buyQuantity));
		switch (product) {
		case "电脑":
			merchandise.setId(101);
			merchandise.setUnivalence(3000);
			break;
		case "纸巾":
			merchandise.setId(102);
			merchandise.setUnivalence(3);
			break;
		case "手机":
			merchandise.setId(103);
			merchandise.setUnivalence(2000);
			break;
		}

		// 2.处理业务逻辑

		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("CART_IN_SESSION");
		if (cart == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.addCartItem(merchandise);
			req.getSession().setAttribute("CART_IN_SESSION", shoppingCart);
		} else {
			cart.addCartItem(merchandise);
		}

		// 3.跳转页面
		resp.sendRedirect("/shoppingcart/cart_list.jsp");
	}
}
