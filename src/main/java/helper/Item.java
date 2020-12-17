package helper;

import java.math.BigDecimal;

public class Item {
    /*
     * need a pojo in format 001 , Travel Card Holder,9.25
     * Since we are dealing with money we go for BigDecimal as the dataType
     */
	private String productCode;
	private String name;
	private BigDecimal price;

	public Item(String productCode, String name, BigDecimal price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}

	public Item(String productCode, String name, double price) {
		this.productCode = productCode;
		this.name = name;
		this.price = BigDecimal.valueOf(price);
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Item [productCode=" + productCode + ", name=" + name + ", price=" + price + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

}