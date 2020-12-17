package unittest;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import helper.Item;
import helper.ItemRepository;
import helper.ItemRepositoryImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemRepositoryTest {
	private final static String productCode = "xyz";
    private final static String NAME_A = "Item A";
    private final static BigDecimal PRICE_A = BigDecimal.ONE;

    private ItemRepository itemRepository;
    private Item item;

    @Before
    public void setup() {
        itemRepository = new ItemRepositoryImpl();
        item = new Item(productCode, NAME_A, PRICE_A);
    }

    @Test
    public void shouldReturnFalseIfItemDoesNotExist() {
        Boolean actual = itemRepository.exists(productCode);

        assertFalse(actual);
    }

    @Test
    public void shouldAddItem() {
        itemRepository.add(item);

        Boolean actual = itemRepository.exists(productCode);

        assertTrue(actual);
    }

    @Test
    public void shouldGetName() {
        itemRepository.add(item);
        String name = itemRepository.getName(productCode);

        boolean nameEqual = NAME_A.equals(name);

        assertTrue(nameEqual);
    }

    @Test
    public void shouldGetPrice() {
        itemRepository.add(item);
        BigDecimal price = itemRepository.getPrice(productCode);

        boolean priceEqual = PRICE_A.equals(price);

        assertTrue(priceEqual);
    }

}


