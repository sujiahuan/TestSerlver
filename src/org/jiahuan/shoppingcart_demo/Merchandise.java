package org.jiahuan.shoppingcart_demo;

public class Merchandise {

	private int id;
	private String name;
	private int buyQuantity;
	private double univalence;
	@Override
	public String toString() {
		return "Merchandise [id=" + id + ", name=" + name + ", buyQuantity=" + buyQuantity + ", univalence="
				+ univalence + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public double getUnivalence() {
		return univalence;
	}
	public void setUnivalence(double univalence) {
		this.univalence = univalence;
	}
}
