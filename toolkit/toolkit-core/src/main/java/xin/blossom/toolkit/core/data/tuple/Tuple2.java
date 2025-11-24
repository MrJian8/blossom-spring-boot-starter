package xin.blossom.toolkit.core.data.tuple;

import java.io.Serial;
import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @param <T1>
 * @param <T2>
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 19:20
 */
@Getter
@EqualsAndHashCode
@ToString
public class Tuple2<T1, T2> implements Serializable {
    @Serial
    private static final long serialVersionUID = 4649298437786159851L;

    private final T1 t1;
    private final T2 t2;

    public Tuple2(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
}
