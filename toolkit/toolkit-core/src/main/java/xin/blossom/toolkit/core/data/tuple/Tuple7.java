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
 * @param <T7>
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 19:23
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Tuple7<T1, T2, T3, T4, T5, T6, T7> extends Tuple6<T1, T2, T3, T4, T5, T6> {
    @Serial
    private static final long serialVersionUID = 760094980719945007L;
    private final T7 t7;

    public Tuple7(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7) {
        super(t1, t2, t3, t4, t5, t6);
        this.t7 = t7;
    }
}
