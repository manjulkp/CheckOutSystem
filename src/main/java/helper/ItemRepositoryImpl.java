package helper;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ItemRepositoryImpl implements ItemRepository {

	/*
	 * Map to hold the items when the item is added 
	 */
    public Map<String, Item> itemDb;

    @Override
	public String toString() {
		return "ItemRepositoryImpl [itemDb=" + itemDb + "]";
	}

	public ItemRepositoryImpl() {
        itemDb = new HashMap<String, Item>();
    }

    /*
     * All the below methods are implemented as the class extends the interface 
     */
	public void add(Item item) {
		itemDb.put(item.getProductCode(), item);		
	}

	public Boolean exists(String productCode) {
		return itemDb.get(productCode) != null;
	}

	public String getName(String productCode) {
		 if (itemDb.get(productCode) == null) {
           throw new IllegalArgumentException();
       }
       return itemDb.get(productCode).getName();
	}

	public BigDecimal getPrice(String productCode) {
		if (itemDb.get(productCode) == null) {
          throw new IllegalArgumentException();
      }
      return itemDb.get(productCode).getPrice();
	}

}