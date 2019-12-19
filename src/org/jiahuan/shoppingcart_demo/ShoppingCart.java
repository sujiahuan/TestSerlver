package org.jiahuan.shoppingcart_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

public class ShoppingCart {

	private List<Merchandise> inventory = new ArrayList<>();
	
	public List<Merchandise> getInventory() {
		return inventory;
	}

	/**添加到购物车
	 * @param merchandiseItem
	 */
	public void addCartItem(Merchandise merchandiseItem) {
		
		for (Merchandise merchandise : inventory) {
			if(merchandise.getId()==merchandiseItem.getId()) {
				merchandise.setBuyQuantity(merchandise.getBuyQuantity()+merchandiseItem.getBuyQuantity());
				return;
			}
		}
		inventory.add(merchandiseItem);
	}
	
	/**删除商品
	 * @param id
	 */
	public void deleteCarItem(int id) {
		Iterator<Merchandise> iterator = inventory.iterator();
		while (iterator.hasNext()) {
			Merchandise next = iterator.next();
			if(next.getId()==id) {
				iterator.remove();
			}
		}
	}
	
	/**获取总价钱
	 * @return
	 */
	public double getTotalPrice() {
		double totalPrice=0D;
		for (Merchandise merchandise : inventory) {
			totalPrice+=merchandise.getBuyQuantity()*merchandise.getUnivalence();
		}
		return totalPrice;
	}
	
	@Test
	public void testName() throws Exception {
		Merchandise merchandise = new Merchandise();
		merchandise.setId(1);
		merchandise.setName("商品1");
		merchandise.setUnivalence(1000);
		merchandise.setBuyQuantity(10);
		
		ShoppingCart cart = new ShoppingCart();
		cart.addCartItem(merchandise);
		
		System.out.println(cart);
		cart.deleteCarItem(1);
		System.out.println(cart);
	}

	@Override
	public String toString() {
		return "ShoppingCart [inventory=" + inventory + "]";
	}
}
