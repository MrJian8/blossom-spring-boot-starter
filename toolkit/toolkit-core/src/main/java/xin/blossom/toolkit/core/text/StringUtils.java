package xin.blossom.toolkit.core.text;

import java.util.Arrays;

import xin.blossom.toolkit.core.collection.ArrayUtils;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:47
 */
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class StringUtils {

    /**
     * 判断字符序列是否为空白字符串
     *
     * <p>空白字符串的定义：null、空字符串或仅包含空白字符（空格、制表符、换行符等）
     *
     * @param cs 要检查的字符序列，可以为null
     * @return 如果为null、空字符串或仅包含空白字符返回true，否则返回false
     * @see CharUtils#isBlank(int)
     */
    public static boolean isBlank(CharSequence cs) {
        if (cs == null || cs.isEmpty()) {
            return true;
        }
        return cs.chars().allMatch(CharUtils::isBlank);
    }

    /**
     * 判断字符序列是否为非空白字符串
     *
     * <p>与{@link #isBlank(CharSequence)}逻辑相反，当字符串包含至少一个非空白字符时返回true
     *
     * @param cs 要检查的字符序列，可以为null
     * @return 如果不为null且至少包含一个非空白字符返回true，否则返回false
     * @see #isBlank(CharSequence)
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 判断字符序列数组中是否包含空白字符串
     *
     * <p>空白字符串的定义：null、空字符串或仅包含空白字符（空格、制表符、换行符等）
     *
     * @param css 要检查的字符序列数组，可以为null
     * @return 如果数组为空或包含空白字符串返回true，否则返回false
     * @see #isBlank(CharSequence)
     */
    public static boolean hasBlank(CharSequence... css) {
        return ArrayUtils.isEmpty(css) || Arrays.stream(css).anyMatch(StringUtils::isBlank);
    }

    /**
     * 判断字符序列数组中不存在空白字符串
     *
     * <p>空白字符串的定义：null、空字符串或仅包含空白字符（空格、制表符、换行符等）
     *
     * @param css 要检查的字符序列数组，可以为null
     * @return 如果数组不为空且不存在空白字符串返回true，否则返回false
     * @see #hasBlank(CharSequence...)
     */
    public static boolean noneBlank(CharSequence... css) {
        return !hasBlank(css);
    }

    /**
     * 判断字符序列数组中是否全部为空白字符串
     *
     * <p>空白字符串的定义：null、空字符串或仅包含空白字符（空格、制表符、换行符等）
     *
     * @param css 要检查的字符序列数组，可以为null
     * @return 如果数组为空或全部为空白字符串返回true，否则返回false
     * @see #isBlank(CharSequence)
     */
    public static boolean isAllBlank(CharSequence... css) {
        return ArrayUtils.isEmpty(css) || Arrays.stream(css).allMatch(StringUtils::isBlank);
    }

    /**
     * 判断字符序列是否为空
     *
     * <p>为空的条件：null 或 空字符串（长度为0）
     *
     * @param cs 要检查的字符序列，可以为null
     * @return 如果为null或空字符串返回true，否则返回false
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.isEmpty();
    }

    /**
     * 判断字符序列是否为非空
     *
     * <p>与{@link #isEmpty(CharSequence)}逻辑相反，当字符串不为null且长度大于0时返回true
     *
     * @param cs 要检查的字符序列，可以为null
     * @return 如果不为null且长度大于0返回true，否则返回false
     * @see #isEmpty(CharSequence)
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 检查字符序列数组中是否存在空元素
     *
     * <p>当数组本身为空或数组中所有元素都为空（null或空字符串）时返回true
     *
     * @param css 字符序列数组，可以为null或空数组
     * @return 如果数组为空或所有元素都为空返回true，否则返回false
     * @see #isEmpty(CharSequence)
     * @see ArrayUtils#isEmpty(Object[])
     */
    public static boolean hasEmpty(CharSequence... css) {
        return ArrayUtils.isEmpty(css) || Arrays.stream(css).allMatch(StringUtils::isEmpty);
    }

    /**
     * 检查字符序列数组中不存在空元素
     *
     * <p>与{@link #hasEmpty(CharSequence...)}逻辑相反，当数组不为空且所有元素都不为空时返回true
     *
     * @param css 字符序列数组，可以为null或空数组
     * @return 如果数组不为空且所有元素都不为空返回true，否则返回false
     * @see #hasEmpty(CharSequence...)
     * @see ArrayUtils#isEmpty(Object[])
     */
    public static boolean noneEmpty(CharSequence... css) {
        return !hasEmpty(css);
    }

    /**
     * 检查字符序列数组中全部为空
     *
     * <p>当数组本身为空或数组中所有元素都为空（null或空字符串）时返回true
     *
     * @param css 字符序列数组，可以为null或空数组
     * @return 如果数组为空或所有元素都为空返回true，否则返回false
     * @see #isEmpty(CharSequence)
     * @see ArrayUtils#isEmpty(Object[])
     */
    public static boolean isAllEmpty(CharSequence... css) {
        return ArrayUtils.isEmpty(css) || Arrays.stream(css).allMatch(StringUtils::isEmpty);
    }

    /**
     * 获取字符序列的长度
     *
     * <p>如果字符序列为null，则返回0
     *
     * @param cs 要获取长度的字符序列，可以为null
     * @return 字符序列的长度，如果为null则返回0
     */
    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }

    private abstract static class CaseStringUtils {

        abstract boolean equals(CharSequence cs1, CharSequence cs2);

        abstract int compare(CharSequence cs1, CharSequence cs2, boolean nullIsLess);

        abstract boolean startWith(CharSequence cs, CharSequence prefix);

        abstract boolean endWith(CharSequence cs, CharSequence prefix);

        abstract boolean contains(CharSequence cs, CharSequence searchCs);

        public boolean notEquals(CharSequence cs1, CharSequence cs2) {
            return !equals(cs1, cs2);
        }

        public boolean equalsAny(CharSequence cs, CharSequence... css) {
            if (ArrayUtils.isEmpty(css)) {
                return false;
            }
            return Arrays.stream(css).anyMatch(csItem -> equals(cs, csItem));
        }

        public int compare(CharSequence cs1, CharSequence cs2) {
            return compare(cs1, cs2, true);
        }

        public boolean startWithAny(CharSequence cs, CharSequence... prefixArray) {
            if (ArrayUtils.isEmpty(prefixArray) || ArrayUtils.isEmpty(cs)) {
                return false;
            }
            return Arrays.stream(prefixArray).anyMatch(prefix -> startWith(cs, prefix));
        }

        public boolean endWithAny(CharSequence cs, CharSequence... suffixArray) {
            if (ArrayUtils.isEmpty(suffixArray) || ArrayUtils.isEmpty(cs)) {
                return false;
            }
            return Arrays.stream(suffixArray).anyMatch(suffix -> endWith(cs, suffix));
        }

        public boolean containsAny(CharSequence cs, CharSequence... searchCss) {
            if (ArrayUtils.isEmpty(searchCss) || null == cs) {
                return false;
            }
            return Arrays.stream(searchCss).anyMatch(searchCs -> contains(cs, searchCs));
        }
    }
//    private abstract static class CaseStringUtils {
//        abstract int compare(CharSequence cs1, CharSequence cs2);
//        abstract boolean equals(CharSequence cs1, CharSequence cs2);
//        abstract boolean notEquals(CharSequence cs1, CharSequence cs2);
//        abstract boolean equalsAny(CharSequence cs, CharSequence... css);
//        abstract boolean startWith(CharSequence cs, CharSequence prefix);
//        abstract boolean startWithAny(CharSequence cs, CharSequence... prefixArray);
//        abstract boolean endWith(CharSequence cs, CharSequence suffix);
//        abstract boolean endWithAny(CharSequence cs, CharSequence... suffixArray);
//        abstract boolean contains(CharSequence cs, CharSequence searchCs);
//        abstract boolean containsAny(CharSequence cs, CharSequence... searchCss);
//        abstract boolean containsAll(CharSequence cs, CharSequence... searchCss);
//        abstract boolean containsOnly(CharSequence cs, CharSequence... searchCss);
//        abstract int indexOf(CharSequence cs, CharSequence searchCs);
//        abstract int lastIndexOf(CharSequence cs, CharSequence searchCs);
//        abstract int removeAll(CharSequence cs, CharSequence removeCs);
//        abstract int removeAny(CharSequence cs, CharSequence... removeCss);
//        abstract int removePrefix(CharSequence cs, CharSequence prefix);
//        abstract int removeAllPrefix(CharSequence cs, CharSequence... prefixArray);
//        abstract int removeSuffix(CharSequence cs, CharSequence suffix);
//        abstract int removeAllSuffix(CharSequence cs, CharSequence... suffixArray);
//        abstract int strip(CharSequence str, CharSequence prefix, CharSequence suffix);
//        abstract int strip(CharSequence str, CharSequence stripCs);
//        abstract int stripAll(CharSequence str, CharSequence prefix, CharSequence suffix);
//        abstract int stripAll(CharSequence str, CharSequence stripCs);
//    }
}
