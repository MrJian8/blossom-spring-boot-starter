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
 * @param <T8>
 * @param <T9>
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 19:23
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> {
    @Serial
    private static final long serialVersionUID = -6480634091560402639L;
    private final T9 t9;

    public Tuple9(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
        super(t1, t2, t3, t4, t5, t6, t7, t8);
        this.t9 = t9;
    }
}
