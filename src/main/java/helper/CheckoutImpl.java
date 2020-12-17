package helper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CheckoutImpl {
    private ItemRepositoryImpl itemRepository;
	private PromotionRules promotionRules;
	private BigDecimal total = BigDecimal.ZERO;
	private Map<String, ItemLevelPromotion> mapOfItemPromotions;
	private Map<Item, Integer> mapOfItemCount;
	
	public CheckoutImpl(PromotionRules promotionRules,ItemRepositoryImpl itemRepository) {
		super();
		this.promotionRules = promotionRules;
		this.itemRepository = itemRepository;
		// map of itemCode with its count
		mapOfItemCount = new HashMap<Item, Integer>();

		// map of itemCode with its Promotion
		mapOfItemPromotions = new HashMap<String, ItemLevelPromotion>();
		for (ItemLevelPromotion itemLevelPromotion : promotionRules.getItemLevelPromotions()) {
			mapOfItemPromotions.put(itemLevelPromotion.getProductCode(), itemLevelPromotion);
		}
	}

	public PromotionRules getPromotionRules() {
		return promotionRules;
	}
	
	/*
	 * First check if the item is present in itemDb
	 * if not present dnot process -throw exception
	 * User map concept to store 
	 * increment the count if it already exist
	 */
	public void scan(Item item) {
		if (itemRepository.exists(item.getProductCode())) {
			
			Integer count = mapOfItemCount.get(item);
			if (count != null) {
				mapOfItemCount.put(item, count + 1);
			} else {
				mapOfItemCount.put(item, 1);
			}
        } else {
            throw new IllegalArgumentException();
        }
		
		
	}

	/*
	 * rule 1: If you spend over £60, then you get 10% off your purchase
       rule 2: If you buy 2 or more travel card holders then the price drops to
       £8.50.
	 */
	@SuppressWarnings("deprecation")
	public BigDecimal total() {
		for (Entry<Item, Integer> entry : mapOfItemCount.entrySet()) {
			Item item = entry.getKey();
			Integer count = entry.getValue();
			BigDecimal itemPrice = item.getPrice();
			
			ItemLevelPromotion itemLevelPromotion = mapOfItemPromotions.get(item.getProductCode());

			if (itemLevelPromotion != null && count >= itemLevelPromotion.getCountToAvailDiscount()) {
				
		        
		        BigDecimal discountBigDecimal = BigDecimal.valueOf(itemLevelPromotion.getDiscount());
		        
		        BigDecimal itemCost  = itemPrice.multiply(new BigDecimal(count));
		        BigDecimal totalDiscount  = discountBigDecimal.multiply(new BigDecimal(count));
		        
				//double totalDiscount = count * itemLevelPromotion.getDiscount();
				total = total.add (itemCost.subtract(totalDiscount) );
			} else {
				BigDecimal itemCost  = itemPrice.multiply(new BigDecimal(count));
				total = total.add(itemCost);
				
			}
		}

		
		BigDecimal amountDiscountBigDecimal = new BigDecimal(promotionRules.getAmountToAvailDiscount());
		if (total.compareTo(amountDiscountBigDecimal) == 0 || total.compareTo(amountDiscountBigDecimal) == 1){
			
			BigDecimal discount = (new BigDecimal(promotionRules.getDiscount()).multiply( total) ) .divide(new BigDecimal("100"));
			return total.subtract(discount).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
