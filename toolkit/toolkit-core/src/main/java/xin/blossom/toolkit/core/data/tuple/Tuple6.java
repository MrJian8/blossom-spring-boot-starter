package xin.blossom.toolkit.core.data.tuple;

import java.io.Serial;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 * @param <T6>
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 19:23
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple5<T1, T2, T3, T4, T5> {
    @Serial
    private static final long serialVersionUID = 4217094020573593990L;
    private final T6 t6;

    public Tuple6(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6) {
        super(t1, t2, t3, t4, t5);
        this.t6 = t6;
    }
}
