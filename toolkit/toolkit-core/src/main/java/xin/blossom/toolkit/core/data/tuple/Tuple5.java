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
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:23
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Tuple5<T1, T2, T3, T4, T5> extends Tuple4<T1, T2, T3, T4> {
    @Serial
    private static final long serialVersionUID = -6147429408175183321L;
    private final T5 t5;

    public Tuple5(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5) {
        super(t1, t2, t3, t4);
        this.t5 = t5;
    }
}
