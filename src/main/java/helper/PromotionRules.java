package helper;

import java.util.List;
/*
 * Implement the Promotion Rules
 */
public class PromotionRules {

	private int discount;
	private DiscountType discountType;
	//this is for total amount criteria to avail the discount
	private Double amountToAvailDiscount;
	private List<ItemLevelPromotion> itemLevelPromotions;


	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Double getAmountToAvailDiscount() {
		return amountToAvailDiscount;
	}

	public void setAmountToAvailDiscount(Double amountToAvailDiscount) {
		this.amountToAvailDiscount = amountToAvailDiscount;
	}

	public List<ItemLevelPromotion> getItemLevelPromotions() {
		return itemLevelPromotions;
	}

	public void setItemLevelPromotions(List<ItemLevelPromotion> itemLevelPromotions) {
		this.itemLevelPromotions = itemLevelPromotions;
	}

}
