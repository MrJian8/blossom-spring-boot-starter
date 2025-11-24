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
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 19:23
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> {
    @Serial
    private static final long serialVersionUID = 70805373108761709L;
    private final T4 t4;

    public Tuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        super(t1, t2, t3);
        this.t4 = t4;
    }
}
