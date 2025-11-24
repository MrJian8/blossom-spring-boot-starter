package xin.blossom.toolkit.core.collection;

import xin.blossom.toolkit.core.constant.Ints;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.stream.IntStream;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:47
 */
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ArrayUtils {

    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return true:为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否不为空
     *
     * @param array 数组
     * @return true:不为空
     */
    public static <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组为空时返回默认数组
     *
     * @param array        数组
     * @param defaultArray 默认数组
     * @return 数组
     */
    public static <T> T[] defaultIfEmpty(T[] array, T[] defaultArray) {
        return array == null || array.length == 0 ? defaultArray : array;
    }

    /**
     * 判断数组中是否有null元素
     *
     * @param array 数组
     * @return true:有null元素
     */
    @SafeVarargs
    public static <T> boolean hasNull(T... array) {
        if (array == null) {
            return true;
        }
        for (T t : array) {
            if (t == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组中所有元素是否为null
     *
     * @param array 数组
     * @return true:所有元素为null
     */
    @SafeVarargs
    public static <T> boolean isAllNull(T... array) {
        if (array == null) {
            return true;
        }
        for (T t : array) {
            if (t != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取数组中第一个不为null的元素
     *
     * @param array 数组
     * @return 匹配的元素
     */
    @SafeVarargs
    public static <T> T firstNotNull(T... array) {
        return firstMatch(Objects::nonNull, array);
    }

    /**
     * 匹配数组中第一个满足条件的元素
     *
     * @param predicate 匹配条件
     * @param array     数组
     * @return 匹配的元素
     */
    @SafeVarargs
    public static <T> T firstMatch(Predicate<T> predicate, T... array) {
        int index = matchIndex(predicate, array);
        if (index < 0) {
            return null;
        }
        return array[index];
    }

    /**
     * 匹配数组中第一个满足条件的元素索引
     *
     * @param predicate 匹配条件
     * @param array     数组
     * @return 索引
     */
    @SafeVarargs
    public static <T> int matchIndex(Predicate<T> predicate, T... array) {
        return matchIndex(predicate, 0, array);
    }

    /**
     * 匹配数组中第一个满足条件的元素索引
     *
     * @param predicate  匹配条件
     * @param beginIndex 开始索引
     * @param array      数组
     * @return 索引
     */
    @SafeVarargs
    public static <T> int matchIndex(Predicate<T> predicate, int beginIndex, T... array) {
        if (isNotEmpty(array)) {
            return IntStream.range(beginIndex, array.length)
                    .filter(i -> predicate.test(array[i]))
                    .findFirst()
                    .orElse(Ints.INDEX_NOT_FOUND);
        }
        return Ints.INDEX_NOT_FOUND;
    }
}
