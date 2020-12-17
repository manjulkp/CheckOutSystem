package helper;

import java.math.BigDecimal;

public interface ItemRepository {

	void add(Item item);

	Boolean exists(String productCode);

	String getName(String productCod);

	BigDecimal getPrice(String productCod);
}
