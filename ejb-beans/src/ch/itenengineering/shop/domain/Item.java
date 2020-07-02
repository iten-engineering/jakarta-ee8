package ch.itenengineering.shop.domain;

import java.io.Serializable;

/**
 * order item
 */
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String isbn;

	private Integer quantity;

	private Double price;

	public Item(String isbn, Integer quantity, Double price) {
		super();
		this.isbn = isbn;
		this.quantity = quantity;
		this.price = price;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(quantity);
		sb.append("x, ");
		sb.append(isbn);
		sb.append(", ");
		sb.append(price);
		
		return sb.toString();
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
} // end
