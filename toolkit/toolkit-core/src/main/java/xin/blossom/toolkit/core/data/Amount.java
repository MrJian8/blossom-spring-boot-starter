package xin.blossom.toolkit.core.data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:56
 */
@Data
public class Amount implements Serializable {
    @Serial
    private static final long serialVersionUID = -380174282485503001L;

    private BigDecimal amount;
    private BigDecimal amountNoTax;
    private BigDecimal amountTax;
    private BigDecimal amountLocal;
    private BigDecimal amountLocalNoTax;
    private BigDecimal amountLocalTax;

    private BigDecimal currencyRate;
    private BigDecimal taxRate;
}
