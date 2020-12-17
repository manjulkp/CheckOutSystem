package helper;

import java.math.BigDecimal;
/*
 * Interface to implement Checkout
 */
public interface Checkout {

    void scan(String productCode);
    BigDecimal total();
}
