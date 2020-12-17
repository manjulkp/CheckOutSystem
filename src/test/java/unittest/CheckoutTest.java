package unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import helper.CheckoutImpl;
import helper.Item;
import helper.ItemLevelPromotion;
import helper.ItemRepositoryImpl;
import helper.PromotionRules;
import junit.framework.Assert;

public class CheckoutTest {


	private final ItemRepositoryImpl itemRepository = new ItemRepositoryImpl();
	private final PromotionRules promotionRules = new PromotionRules();
	private final List<ItemLevelPromotion> itemLevelPromotions = new ArrayList<ItemLevelPromotion>();
	private ItemLevelPromotion itemLevelPromotion;
	private CheckoutImpl checkout;

	@Before
	public void setup() {

		Item travelCardHolder = new Item("001", "Travel Card Holder", new BigDecimal(9.25));
		Item personalizedCufflinks = new Item("002", "Personalized Cufflinks", new BigDecimal(45.00));
		Item kidsTShirt = new Item("003", "Kids T-Shirt", new BigDecimal(19.95));
		itemRepository.add(travelCardHolder);
		itemRepository.add(personalizedCufflinks);
		itemRepository.add(kidsTShirt);

		System.out.println(itemRepository.toString());

	}

	/*
	 * Case1:
	 * Basket: 001,002,003
       Total price expected: £66.78
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void scenario1() {

		promotionRules.setAmountToAvailDiscount(60.0);
		promotionRules.setDiscount(10);

		itemLevelPromotion = new ItemLevelPromotion("001", 0.75, 2);
		itemLevelPromotions.add(itemLevelPromotion);
		promotionRules.setItemLevelPromotions(itemLevelPromotions);

		checkout = new CheckoutImpl(promotionRules, itemRepository);

		Assert.assertTrue("The size of the item repository is incorrect ", itemRepository.itemDb.size() == 3);

		System.out.println(itemRepository);

		checkout.scan(itemRepository.itemDb.get("001"));
		checkout.scan(itemRepository.itemDb.get("002"));
		checkout.scan(itemRepository.itemDb.get("003"));
		//System.out.println("---"+checkout.total());

		BigDecimal expected = BigDecimal.valueOf(66.78);
		System.out.println(expected);

		assertEquals(0,expected.compareTo(checkout.total()));

	}
	
	/*
	 * Case2:
	 * Basket: 001,003,001
       Total price expected: £36.95
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void scenario2() {

		promotionRules.setAmountToAvailDiscount(60.0);
		promotionRules.setDiscount(10);

		itemLevelPromotion = new ItemLevelPromotion("001", 0.75, 2);
		itemLevelPromotions.add(itemLevelPromotion);
		promotionRules.setItemLevelPromotions(itemLevelPromotions);

		checkout = new CheckoutImpl(promotionRules, itemRepository);

		Assert.assertTrue("The size of the item repository is incorrect ", itemRepository.itemDb.size() == 3);

		System.out.println(itemRepository);

		checkout.scan(itemRepository.itemDb.get("001"));
		checkout.scan(itemRepository.itemDb.get("001"));
		checkout.scan(itemRepository.itemDb.get("003"));
		//System.out.println("---"+checkout.total());

		BigDecimal expected = BigDecimal.valueOf(36.95);
		System.out.println(expected);

		assertEquals(0,expected.compareTo(checkout.total()));

	}
	

	/*
	 * Case2:
	 * Basket: 001,002,001,003
       Total price expected: £73.76
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void scenario3() {

		promotionRules.setAmountToAvailDiscount(60.0);
		promotionRules.setDiscount(10);

		itemLevelPromotion = new ItemLevelPromotion("001", 0.75, 2);
		itemLevelPromotions.add(itemLevelPromotion);
		promotionRules.setItemLevelPromotions(itemLevelPromotions);

		checkout = new CheckoutImpl(promotionRules, itemRepository);

		Assert.assertTrue("The size of the item repository is incorrect ", itemRepository.itemDb.size() == 3);

		System.out.println(itemRepository);

		checkout.scan(itemRepository.itemDb.get("001"));
		checkout.scan(itemRepository.itemDb.get("001"));
		checkout.scan(itemRepository.itemDb.get("003"));
		checkout.scan(itemRepository.itemDb.get("002"));
		//System.out.println("---"+checkout.total());

		BigDecimal expected = BigDecimal.valueOf(73.75);
		System.out.println(expected);

		assertEquals(0,expected.compareTo(checkout.total()));

	}

}
