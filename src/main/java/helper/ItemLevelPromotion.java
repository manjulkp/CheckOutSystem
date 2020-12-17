package helper;

public class ItemLevelPromotion {
    /*
     * This cover the case where we want to staify the rule 
     * If you buy 2 or more travel card holders then the price drops to £8.50.
     */
	private String productCode;
	private Double discount;
	private DiscountType discountType;
	private int countToAvailDiscount;
	
	public ItemLevelPromotion(String productCode, Double discount,
			int countToAvailDiscount) {
		super();
		this.productCode = productCode;
		this.discount = discount;
		this.countToAvailDiscount = countToAvailDiscount;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public int getCountToAvailDiscount() {
		return countToAvailDiscount;
	}

	public void setCountToAvailDiscount(int countToAvailDiscount) {
		this.countToAvailDiscount = countToAvailDiscount;
	}

}
