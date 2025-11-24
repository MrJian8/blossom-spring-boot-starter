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
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:22
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> {
    @Serial
    private static final long serialVersionUID = 7881373702553222780L;
    private final T3 t3;

    public Tuple3(T1 t1, T2 t2, T3 t3) {
        super(t1, t2);
        this.t3 = t3;
    }
}
