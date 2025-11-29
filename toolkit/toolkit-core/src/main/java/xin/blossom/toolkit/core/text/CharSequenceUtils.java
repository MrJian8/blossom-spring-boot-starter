package xin.blossom.toolkit.core.text;

import xin.blossom.toolkit.core.constant.Ints;

/**
 * @author haojian
 * @version 1.0
 * @date 2025/11/25 21:06
 */
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CharSequenceUtils {
    private static final int TO_STRING_LIMIT = 16;

    /**
     * 在字符序列中查找指定子序列第一次出现的位置索引。
     * 从指定的起始位置开始搜索，支持多种字符序列类型的优化处理。
     *
     * <p>此方法为不同的字符序列类型提供了针对性的实现以优化性能：
     * <ul>
     *   <li>{@link String} - 使用原生 {@link String#indexOf(String, int)} 方法</li>
     *   <li>{@link StringBuilder} - 使用 {@link StringBuilder#indexOf(String, int)} 方法</li>
     *   <li>{@link StringBuffer} - 使用 {@link StringBuffer#indexOf(String, int)} 方法</li>
     *   <li>其他 {@link CharSequence} 实现 - 转换为字符串后使用字符串的查找方法</li>
     * </ul>
     *
     * @param cs         要搜索的字符序列，可以为 {@code null}
     * @param searchChar 要查找的子字符序列，可以为 {@code null}
     * @param start      开始搜索的起始位置索引
     * @return 指定子序列在字符序列中第一次出现的索引位置（从起始位置开始计算），
     * 如果未找到任一输入为 {@code null}，则返回 {@link Ints#INDEX_NOT_FOUND}（通常为-1）
     * @see String#indexOf(String, int)
     * @see StringBuilder#indexOf(String, int)
     * @see StringBuffer#indexOf(String, int)
     */
    public static int indexOf(final CharSequence cs, final CharSequence searchChar, final int start) {
        if (null == cs || null == searchChar) {
            return Ints.INDEX_NOT_FOUND;
        }
        return switch (cs) {
            case String s -> s.indexOf(searchChar.toString(), start);
            case StringBuilder stringBuilder -> stringBuilder.indexOf(searchChar.toString(), start);
            case StringBuffer stringBuffer -> stringBuffer.indexOf(searchChar.toString(), start);
            default -> cs.toString().indexOf(searchChar.toString(), start);
        };
    }

    /**
     * 在字符序列中查找指定Unicode代码点第一次出现的位置索引。
     * 从指定的起始位置开始搜索，支持基本多文种平面（BMP）字符和辅助平面字符。
     *
     * <p>此方法正确处理所有Unicode字符：
     * <ul>
     *   <li>基本多文种平面字符（U+0000 到 U+FFFF）- 使用单个{@code char}表示</li>
     *   <li>辅助平面字符（U+10000 到 U+10FFFF）- 使用UTF-16代理对（两个{@code char}）表示</li>
     * </ul>
     *
     * <p>如果字符序列是{@code String}类型，将委托给{@link String#indexOf(int, int)}以获得更好的性能。
     *
     * @param cs         要搜索的字符序列，可以为{@code null}
     * @param searchChar 要查找的Unicode代码点（字符值）
     * @param start      开始搜索的起始位置索引
     * @return 指定代码点在字符序列中第一次出现的索引位置（从起始位置开始计算），如果未找到或输入为{@code null}，则返回{@link Ints#INDEX_NOT_FOUND}（通常为-1）
     * @see Character#MIN_SUPPLEMENTARY_CODE_POINT
     * @see Character#MAX_CODE_POINT
     * @see Character#toChars(int)
     * @see String#indexOf(int, int)
     */
    public static int indexOf(final CharSequence cs, final int searchChar, int start) {
        if (cs == null) {
            return Ints.INDEX_NOT_FOUND;
        }
        if (cs instanceof String) {
            return ((String) cs).indexOf(searchChar, start);
        }
        final int sz = cs.length();
        if (start < 0) {
            start = 0;
        }
        if (searchChar < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
            for (int i = start; i < sz; i++) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }
            return Ints.INDEX_NOT_FOUND;
        }
        if (searchChar <= Character.MAX_CODE_POINT) {
            final char[] chars = Character.toChars(searchChar);
            for (int i = start; i < sz - 1; i++) {
                final char high = cs.charAt(i);
                final char low = cs.charAt(i + 1);
                if (high == chars[0] && low == chars[1]) {
                    return i;
                }
            }
        }
        return Ints.INDEX_NOT_FOUND;
    }

    /**
     * 在字符序列中从指定位置开始向前搜索，查找指定子序列最后出现的位置索引。
     *
     * <p>此方法实现了从后向前的字符串搜索算法，并针对不同场景进行了多重优化：
     * <ul>
     *   <li><strong>类型优化</strong>：对于{@link String}、{@link StringBuilder}、{@link StringBuffer}
     *       等常见类型，直接调用其原生{@code lastIndexOf}方法以获得最佳性能</li>
     *   <li><strong>短字符串优化</strong>：当搜索字符串较短（长度小于等于{@code TO_STRING_LIMIT}）时，
     *       将其转换为字符串并使用原生方法处理</li>
     *   <li><strong>高效搜索算法</strong>：对于通用字符序列，使用首字符筛选+完全验证的两阶段搜索策略：
     *       <ol>
     *         <li>首先快速定位搜索串首字符的出现位置</li>
     *         <li>然后使用{@link #checkLaterThan1}验证剩余字符是否完全匹配</li>
     *       </ol>
     *   </li>
     * </ul>
     *
     * <p><strong>边界情况处理：</strong>
     * <ul>
     *   <li>如果{@code cs}或{@code searchChar}为{@code null}，返回{@link Ints#INDEX_NOT_FOUND}</li>
     *   <li>如果{@code searchChar}为空串（长度为0），返回{@code start}位置</li>
     *   <li>如果{@code start}超出主串长度，自动调整为字符串末尾</li>
     *   <li>如果搜索串长度大于主串长度，直接返回{@link Ints#INDEX_NOT_FOUND}</li>
     *   <li>如果调整后的起始位置小于0，返回{@link Ints#INDEX_NOT_FOUND}</li>
     * </ul>
     *
     * <p><strong>搜索规则：</strong>
     * <ul>
     *   <li>搜索从{@code start}位置开始向字符串开头方向进行</li>
     *   <li>返回的是完整匹配的子序列的起始位置索引</li>
     *   <li>如果未找到匹配，返回{@link Ints#INDEX_NOT_FOUND}</li>
     * </ul>
     *
     * <p><strong>算法流程：</strong>
     * <ol>
     *   <li>空值检查：任一参数为null立即返回</li>
     *   <li>类型优化：对String类型的searchChar和常见cs类型使用原生方法</li>
     *   <li>参数验证：检查长度和起始位置的有效性</li>
     *   <li>短串优化：对短搜索串使用转换后的原生方法</li>
     *   <li>位置调整：确保有足够空间容纳搜索串</li>
     *   <li>核心搜索：使用首字符筛选和完全验证算法</li>
     * </ol>
     *
     * @param cs         要搜索的主字符序列，可以为{@code null}
     * @param searchChar 要查找的子字符序列，可以为{@code null}
     * @param start      开始搜索的起始位置索引（从该位置向前搜索）
     * @return 指定子序列在字符序列中最后出现的起始索引位置（从前往后计数），
     * 如果未找到或输入为{@code null}，则返回{@link Ints#INDEX_NOT_FOUND}（通常为-1）。
     * 如果搜索串为空串，返回{@code start}参数值。
     * @see #checkLaterThan1(CharSequence, CharSequence, int, int)
     * @see String#lastIndexOf(String, int)
     * @see StringBuilder#lastIndexOf(String, int)
     * @see StringBuffer#lastIndexOf(String, int)
     * @see Ints#INDEX_NOT_FOUND
     */
    public static int lastIndexOf(final CharSequence cs, final CharSequence searchChar, int start) {
        if (searchChar == null || cs == null) {
            return Ints.INDEX_NOT_FOUND;
        }
        if (searchChar instanceof String) {
            switch (cs) {
                case String s -> {
                    return s.lastIndexOf((String) searchChar, start);
                }
                case StringBuilder stringBuilder -> {
                    return stringBuilder.lastIndexOf((String) searchChar, start);
                }
                case StringBuffer stringBuffer -> {
                    return stringBuffer.lastIndexOf((String) searchChar, start);
                }
                default -> {
                }
            }
        }
        final int len1 = cs.length();
        final int len2 = searchChar.length();
        if (start > len1) {
            start = len1;
        }
        if (start < 0 || len2 > len1) {
            return Ints.INDEX_NOT_FOUND;
        }
        if (len2 == 0) {
            return start;
        }
        if (len2 <= TO_STRING_LIMIT) {
            switch (cs) {
                case String s -> {
                    return s.lastIndexOf(searchChar.toString(), start);
                }
                case StringBuilder stringBuilder -> {
                    return stringBuilder.lastIndexOf(searchChar.toString(), start);
                }
                case StringBuffer stringBuffer -> {
                    return stringBuffer.lastIndexOf(searchChar.toString(), start);
                }
                default -> {
                }
            }
        }

        if (start + len2 > len1) {
            start = len1 - len2;
        }

        final char char0 = searchChar.charAt(0);

        int i = start;
        while (true) {
            while (cs.charAt(i) != char0) {
                i--;
                if (i < 0) {
                    return Ints.INDEX_NOT_FOUND;
                }
            }
            if (checkLaterThan1(cs, searchChar, len2, i)) {
                return i;
            }
            i--;
            if (i < 0) {
                return Ints.INDEX_NOT_FOUND;
            }
        }
    }

    /**
     * 在字符序列中从指定位置开始向前搜索，查找指定Unicode代码点最后出现的位置索引。
     *
     * <p>此方法支持所有Unicode字符的搜索，包括基本多文种平面（BMP）字符和辅助平面字符：
     * <ul>
     *   <li><strong>BMP字符</strong>（U+0000 到 U+FFFF）：使用单个{@code char}表示，直接比较</li>
     *   <li><strong>辅助平面字符</strong>（U+10000 到 U+10FFFF）：使用UTF-16代理对表示，需要比较两个连续的{@code char}</li>
     * </ul>
     *
     * <p><strong>性能优化：</strong>
     * <ul>
     *   <li>对{@link String}类型直接委托给原生{@link String#lastIndexOf(int, int)}方法</li>
     *   <li>对BMP字符使用简单循环比较，效率最高</li>
     *   <li>对辅助平面字符使用代理对匹配，确保正确的Unicode处理</li>
     * </ul>
     *
     * <p><strong>搜索规则：</strong>
     * <ul>
     *   <li>搜索从{@code start}位置开始向字符串开头方向进行</li>
     *   <li>如果{@code start}超过字符串长度，自动调整为最后一个字符的位置</li>
     *   <li>如果{@code start}为负数，立即返回{@link Ints#INDEX_NOT_FOUND}</li>
     *   <li>对于辅助平面字符，返回代理对的起始位置（高代理项的位置）</li>
     * </ul>
     *
     * <p><strong>边界情况处理：</strong>
     * <ul>
     *   <li>起始位置调整：{@code start >= sz → start = sz - 1}</li>
     *   <li>无效起始位置：{@code start < 0 → 立即返回NOT_FOUND}</li>
     *   <li>辅助平面字符边界：如果{@code start}在最后一个位置，无法容纳代理对，直接返回NOT_FOUND</li>
     * </ul>
     *
     * @param cs         要搜索的字符序列，不能为{@code null}
     * @param searchChar 要查找的Unicode代码点（字符值）
     * @param start      开始搜索的起始位置索引（从该位置向前搜索）
     * @return 指定代码点在字符序列中最后出现的索引位置，
     * 对于BMP字符返回字符位置，对于辅助平面字符返回代理对的起始位置，
     * 如果未找到或起始位置无效，返回{@link Ints#INDEX_NOT_FOUND}
     * @see Character#MIN_SUPPLEMENTARY_CODE_POINT
     * @see Character#MAX_CODE_POINT
     * @see Character#toChars(int)
     * @see String#lastIndexOf(int, int)
     */
    public static int lastIndexOf(final CharSequence cs, final int searchChar, int start) {
        if (null == cs) {
            return Ints.INDEX_NOT_FOUND;
        }
        if (cs instanceof String) {
            return ((String) cs).lastIndexOf(searchChar, start);
        }
        final int sz = cs.length();
        if (start < 0) {
            return Ints.INDEX_NOT_FOUND;
        }
        if (start >= sz) {
            start = sz - 1;
        }
        if (searchChar < Character.MIN_SUPPLEMENTARY_CODE_POINT) {
            for (int i = start; i >= 0; --i) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }
            return Ints.INDEX_NOT_FOUND;
        }
        if (searchChar <= Character.MAX_CODE_POINT) {
            final char[] chars = Character.toChars(searchChar);
            if (start == sz - 1) {
                return Ints.INDEX_NOT_FOUND;
            }
            for (int i = start; i >= 0; i--) {
                final char high = cs.charAt(i);
                final char low = cs.charAt(i + 1);
                if (chars[0] == high && chars[1] == low) {
                    return i;
                }
            }
        }
        return Ints.INDEX_NOT_FOUND;
    }

    /**
     * 比较两个字符序列的指定区域是否匹配
     *
     * @param cs         第一个字符序列
     * @param ignoreCase 是否忽略大小写
     * @param thisStart  第一个序列的起始位置
     * @param substring  第二个字符序列
     * @param start      第二个序列的起始位置
     * @param length     要比较的长度
     * @return 如果指定区域匹配返回true，否则返回false
     */
    public static boolean regionMatches(final CharSequence cs, final boolean ignoreCase, final int thisStart,
                                        final CharSequence substring, final int start, final int length) {
        if (null == cs || null == substring) {
            return false;
        }
        if (cs instanceof String && substring instanceof String) {
            return ((String) cs).regionMatches(ignoreCase, thisStart, (String) substring, start, length);
        }
        int index1 = thisStart;
        int index2 = start;
        int tmpLen = length;

        final int srcLen = cs.length() - thisStart;
        final int otherLen = substring.length() - start;

        if (thisStart < 0 || start < 0 || length < 0) {
            return false;
        }

        if (srcLen < length || otherLen < length) {
            return false;
        }

        while (tmpLen-- > 0) {
            final char c1 = cs.charAt(index1++);
            final char c2 = substring.charAt(index2++);

            if (c1 == c2) {
                continue;
            }

            if (!ignoreCase) {
                return false;
            }

            final char u1 = Character.toUpperCase(c1);
            final char u2 = Character.toUpperCase(c2);
            if (u1 != u2 && Character.toLowerCase(u1) != Character.toLowerCase(u2)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查字符序列从指定位置开始是否与搜索序列匹配
     * 假设第一个字符已经匹配，检查剩余字符
     *
     * @param cs         主字符序列
     * @param searchChar 搜索序列
     * @param len2       搜索序列长度
     * @param start1     主序列起始位置
     * @return 如果匹配返回true，否则返回false
     */
    private static boolean checkLaterThan1(final CharSequence cs, final CharSequence searchChar, final int len2, final int start1) {
        for (int i = 1, j = len2 - 1; i <= j; i++, j--) {
            if (cs.charAt(start1 + i) != searchChar.charAt(i) || cs.charAt(start1 + j) != searchChar.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}