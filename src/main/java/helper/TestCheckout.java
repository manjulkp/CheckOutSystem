package helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestCheckout {

	/*
	 * This is just test case to valid all the class that are mplemented
	 */
	public static void main(String[] args) {
		PromotionRules promotionRules = new PromotionRules();
		promotionRules.setAmountToAvailDiscount(60.0);
		promotionRules.setDiscount(10);
		List<ItemLevelPromotion> itemLevelPromotions = new ArrayList<ItemLevelPromotion>();
		ItemLevelPromotion itemLevelPromotion = new ItemLevelPromotion("001", 0.75, 2);
		itemLevelPromotions.add(itemLevelPromotion);
		promotionRules.setItemLevelPromotions(itemLevelPromotions);
		
		ItemRepositoryImpl itemRepository = new ItemRepositoryImpl();
		Item travelCardHolder = new Item("001", "Travel Card Holder", new BigDecimal(9.25));
		Item personalizedCufflinks = new Item("002", "Personalized Cufflinks", new BigDecimal(45.00));
		Item kidsTShirt = new Item("003", "Kids T-Shirt", new BigDecimal(19.95));
		itemRepository.add(travelCardHolder);
		itemRepository.add(personalizedCufflinks);
		itemRepository.add(kidsTShirt);
		
		CheckoutImpl checkout = new CheckoutImpl(promotionRules,itemRepository);
		checkout.scan(travelCardHolder);
		checkout.scan(travelCardHolder);
		checkout.scan(personalizedCufflinks);
		checkout.scan(kidsTShirt);
		
		System.out.println(checkout.total());
	}
}
