package xin.blossom.toolkit.core.text;

import java.util.function.Predicate;

import lombok.NonNull;
import xin.blossom.toolkit.core.collection.ArrayUtils;
import xin.blossom.toolkit.core.constant.Strings;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:47
 */
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CharSequenceUtils {

    /**
     * 判断两个字符串是否相等
     *
     * @param cs1        字符串1
     * @param cs2        字符串2
     * @param ignoreCase 是否忽略大小写
     * @return true: 相等 false: 不相等
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2, boolean ignoreCase) {
        if (null == cs1) {
            return cs2 == null;
        }
        if (null == cs2) {
            return false;
        }

        if (ignoreCase) {
            return cs1.toString().equalsIgnoreCase(cs2.toString());
        } else {
            return cs1.toString().contentEquals(cs2);
        }
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return true: 相等 false: 不相等
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return equals(cs1, cs2, false);
    }

    /**
     * 忽略大小写判断两个字符串是否相等
     *
     * @param cs1 字符串1
     * @param cs2 字符串2
     * @return true: 相等 false: 不相等
     */
    public static boolean equalsIgnoreCase(CharSequence cs1, CharSequence cs2) {
        return equals(cs1, cs2, true);
    }

    /**
     * 判断字符串序列是否包含指定字符串
     *
     * @param cs1        字符串1
     * @param ignoreCase 是否忽略大小写
     * @param css        字符串序列
     * @return true: 包含 false: 不包含
     */
    public static boolean equalsAny(CharSequence cs1, boolean ignoreCase, CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return false;
        }

        for (CharSequence str : css) {
            if (equals(cs1, str, ignoreCase)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串序列是否包含指定字符串
     *
     * @param cs  字符串1
     * @param css 字符串序列
     * @return true: 包含 false: 不包含
     */
    public static boolean equalsAny(CharSequence cs, CharSequence... css) {
        return equalsAny(cs, false, css);
    }

    /**
     * 忽略大小写判断字符串序列是否包含指定字符串
     *
     * @param cs  字符串1
     * @param css 字符串序列
     * @return true: 忽略大小写包含 false: 忽略大小写不包含
     */
    public static boolean equalsAnyIgnoreCase(CharSequence cs, CharSequence... css) {
        return equalsAny(cs, true, css);
    }

    /**
     * 判断字符序列是否为空
     *
     * @param cs 字符序列
     * @return true: 空 false: 非空
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (CharUtils.isNotBlank(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符序列是否非空
     *
     * @param cs 字符序列
     * @return true: 非空 false: 空
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    /**
     * 判断字符序列是否包含空白字符
     *
     * @param css 字符序列
     * @return true: 包含 false: 不包含
     */
    public static boolean hasBlank(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        }
        for (CharSequence cs : css) {
            if (isBlank(cs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符序列是否所有字符序列都为空白字符
     *
     * @param css 字符序列
     * @return true: 所有字符序列都为空白字符 false: 不全为空白字符
     */
    public static boolean isAllBlank(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        }
        for (CharSequence cs : css) {
            if (isNotBlank(cs)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符序列是否都为非空白
     *
     * @param css 字符序列
     * @return true: 非空白 false: 空白
     */
    public static boolean isNoneBlank(CharSequence... css) {
        return !hasBlank(css);
    }

    /**
     * 字符串是否为空
     *
     * @param cs 字符序列
     * @return 是否为空
     */
    public static boolean isEmpty(CharSequence cs) {
        return null == cs || cs.isEmpty();
    }

    /**
     * 字符串是否非空
     *
     * @param cs 字符序列
     * @return 是否非空
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 判断字符序列是否包含空字符
     *
     * @param css 字符序列
     * @return 是否为null或者为空
     */
    public static boolean hasEmpty(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        }
        for (CharSequence cs : css) {
            if (isEmpty(cs)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否所有字符序列都为空
     *
     * @param css 字符序列
     * @return 是否为null或者为空
     */
    public static boolean isAllEmpty(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        }
        for (CharSequence cs : css) {
            if (isNotEmpty(cs)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串是否所有字符序列都为空
     *
     * @param css 字符序列
     * @return 是否为null或者为空
     */
    public static boolean isNoneEmpty(CharSequence... css) {
        return !hasEmpty(css);
    }

    /**
     * 字符串为null时返回默认值
     *
     * @param cs           字符串
     * @param defaultValue 默认值
     * @return 字符串
     */
    public static String nullToDefault(CharSequence cs, String defaultValue) {
        return (cs == null) ? defaultValue : cs.toString();
    }

    /**
     * 字符串为空时返回默认值
     *
     * @param cs           字符串
     * @param defaultValue 默认值
     * @return 字符串
     */
    public static String emptyToDefault(CharSequence cs, String defaultValue) {
        return isEmpty(cs) ? defaultValue : cs.toString();
    }

    /**
     * 字符串为空白时返回默认值
     *
     * @param cs           字符串
     * @param defaultValue 默认值
     * @return 字符串
     */
    public static String blankToDefault(CharSequence cs, String defaultValue) {
        return isBlank(cs) ? defaultValue : cs.toString();
    }

    /**
     * 字符串为空时返回空字符串
     *
     * @param cs 字符串
     * @return 字符串
     */
    public static String nullToEmpty(CharSequence cs) {
        return nullToDefault(cs, Strings.EMPTY);
    }

    /**
     * 字符串为空时返回空字符串
     *
     * @param cs 字符串
     * @return 字符串
     */
    public static String emptyIfNull(CharSequence cs) {
        return nullToEmpty(cs);
    }

    /**
     * 字符串为空白时返回null
     *
     * @param cs 字符串
     * @return 字符串
     */
    public static String emptyToNull(CharSequence cs) {
        return emptyToDefault(cs, null);
    }

    /**
     * 判断字符串是否为null或者undefined
     *
     * @param cs 字符串
     * @return 是否为null或者undefined
     */
    public static boolean isNullOrUndefinedStr(@NonNull CharSequence cs) {
        String trim = cs.toString().trim().toLowerCase();
        return Strings.NULL.equals(trim) || Strings.UNDEFINED.equals(trim);
    }

    /**
     * 判断字符串是否为null或者undefined或者空白字符
     *
     * @param cs 字符串
     * @return 是否为null或者undefined或者空白字符
     */
    public static boolean isBlankOrUndefinedStr(CharSequence cs) {
        if (isBlank(cs)) {
            return true;
        }
        return isNullOrUndefinedStr(cs);
    }

    /**
     * 判断字符串是否为null或者undefined或者空字符
     *
     * @param cs 字符串
     * @return 是否为null或者undefined或者空字符
     */
    public static boolean isEmptyOrUndefinedStr(CharSequence cs) {
        if (isEmpty(cs)) {
            return true;
        }
        return isNullOrUndefinedStr(cs);
    }

    /**
     * 判断字符串是否为null或者undefined
     *
     * @param cs 字符串
     * @return 是否为null或者undefined
     */
    public static boolean isNullOrUndefined(CharSequence cs) {
        if (cs == null) {
            return true;
        }
        return isNullOrUndefinedStr(cs);
    }

    /**
     * 按照断言，除去字符串头尾部的断言为真的字符，如果字符串是{@code null}，依然返回{@code null}。
     *
     * @param cs        字符串
     * @param mode      {@code -1}表示trimStart，{@code 0}表示trim全部， {@code 1}表示trimEnd
     * @param predicate 删除条件
     * @return 删除后的字符串
     */
    public static String trim(CharSequence cs, int mode, Predicate<Character> predicate) {
        if (cs == null) {
            return null;
        }
        int length = cs.length();
        int start = 0;
        int end = length;
        if (mode <= 0) {
            while ((start < end) && (predicate.test(cs.charAt(start)))) {
                start++;
            }
        }// 扫描字符串尾部
        if (mode >= 0) {
            while ((start < end) && (predicate.test(cs.charAt(end - 1)))) {
                end--;
            }
        }
        if ((start > 0) || (end < length)) {
            return cs.toString().substring(start, end);
        } else {
            return cs.toString();
        }
    }

    /**
     * 除去字符串头尾部的空白字符，如果字符串是{@code null}，依然返回{@code null}。
     *
     * @param cs   字符串
     * @param mode {@code -1}表示trimStart，{@code 0}表示trim全部， {@code 1}表示trimEnd
     * @return 删除后的字符串
     */
    public static String trim(CharSequence cs, int mode) {
        return trim(cs, mode, CharUtils::isBlank);
    }

    /**
     * 除去字符串头部的空白字符，如果字符串是{@code null}，依然返回{@code null}。
     *
     * @param cs 字符串
     * @return 删除后的字符串
     */
    public static String trimStart(CharSequence cs) {
        return trim(cs, -1);
    }

    /**
     * 除去字符串尾部的空白字符，如果字符串是{@code null}，依然返回{@code null}。
     *
     * @param cs 字符串
     * @return 删除后的字符串
     */
    public static String trimEnd(CharSequence cs) {
        return trim(cs, 1);
    }

    /**
     * 除去字符串头尾部的空白字符，如果字符串是{@code null}，依然返回{@code null}。
     *
     * @param cs 字符串
     * @return 删除后的字符串
     */
    public static String trim(CharSequence cs) {
        return trim(cs, 0);
    }

    /**
     * 除去字符串头尾部的空白字符，如果字符串是{@code null}或者""，返回{@code null}。
     *
     * @param cs 字符串
     * @return 删除后的字符串
     */
    public static String trimToEmpty(CharSequence cs) {
        return (null == cs) ? Strings.EMPTY : trim(cs, 0);
    }

    /**
     * 除去字符串头尾部的空白字符，如果字符串是"{@code ""}"，返回null。
     *
     * @param cs 字符串
     * @return 结果
     */
    public static String trimToNull(CharSequence cs) {
        String trim = trim(cs, 0);
        return equals(Strings.EMPTY, trim) ? null : trim;
    }

    /**
     * 判断字符串是否以指定字符开头
     *
     * @param cs 字符串
     * @param c  字符
     * @return 是否以指定字符开头
     */
    public static boolean startWith(CharSequence cs, char c) {
        if (isEmpty(cs)) {
            return false;
        }
        return c == cs.charAt(0);
    }


}
