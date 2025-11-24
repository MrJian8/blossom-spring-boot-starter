package xin.blossom.toolkit.core.constant;

import java.math.BigDecimal;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 20:15
 */
public interface Decimals {
    BigDecimal ZERO = BigDecimal.ZERO;
    BigDecimal ONE = BigDecimal.ONE;
    BigDecimal TEN = BigDecimal.TEN;
    BigDecimal HUNDRED = new BigDecimal("100");
    BigDecimal THOUSAND = new BigDecimal("1000");
    BigDecimal MILLION = new BigDecimal("1000000");
    BigDecimal BILLION = new BigDecimal("1000000000");
    BigDecimal ONE_NEGATIVE = BigDecimal.ONE.negate();
}
