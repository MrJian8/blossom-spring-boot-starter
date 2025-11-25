package xin.blossom.toolkit.core.text;

import xin.blossom.toolkit.core.constant.Chars;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 23:19
 */
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CharUtils {

    /**
     * 判断字符是否是ascii字符
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isAscii(char ch) {
        return ch < 128;
    }

    /**
     * 判断字符是否是ascii可打印字符
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }

    /**
     * 判断字符是否是ascii控制字符
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isAsciiControl(char ch) {
        return ch < 32 || ch == 127;
    }

    /**
     * 判断字符是否是大写字母
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isLetterUpper(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    /**
     * 判断字符是否是小写字母
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isLetterLower(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    /**
     * 判断字符是否是字母
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isLetter(char ch) {
        return isLetterUpper(ch) || isLetterLower(ch);
    }

    /**
     * 判断字符是否是数字
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 判断字符是否是字母或数字
     *
     * @param ch 字符
     * @return true: 是 false: 否
     */
    public static boolean isLetterOrNumber(char ch) {
        return isLetter(ch) || isNumber(ch);
    }

    /**
     * 16进制字符判断
     *
     * @param ch 16进制字符
     * @return true: 是 false: 否
     */
    public static boolean isHexChar(char ch) {
        return isNumber(ch) || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F');
    }

    /**
     * 中文判断
     *
     * @param ch 中文
     * @return true: 是 false: 否
     */
    public static boolean isChinese(char ch) {
        return ch >= 0x4E00 && ch <= 0x9FFF;
    }

    /**
     * 字符转字符串
     *
     * @param ch 字符
     * @return 字符串
     */
    public static String toString(char ch) {
        return String.valueOf(ch);
    }

    /**
     * 判断对象是否是字符
     *
     * @param value 对象
     * @return true: 是 false: 否
     */
    public static boolean isChar(Object value) {
        if (value == null) {
            return false;
        }
        return value instanceof Character;
    }

    /**
     * 判断字符是否是空白字符
     *
     * @param c 字符
     * @return true: 是 false: 否
     */
    public static boolean isBlank(int c) {
        return Character.isWhitespace(c)
                || Character.isSpaceChar(c)
                || c == '\ufeff'
                || c == '\u202a'
                || c == '\u0000'
                || c == '\u3164'
                || c == '\u2800'
                || c == '\u200c'
                || c == '\u180e';
    }

    /**
     * 判断字符是否是空白字符
     *
     * @param c 字符
     * @return true: 是 false: 否
     */
    public static boolean isBlank(char c) {
        return isBlank((int) c);
    }

    /**
     * 判断字符是否不是空白字符
     *
     * @param c 字符
     * @return true: 是 false: 否
     */
    public static boolean isNotBlank(char c) {
        return !isBlank(c);
    }

    /**
     * 判断字符是否是文件分隔符
     *
     * @param ch 文件分隔符
     * @return true: 是 false: 否
     */
    public static boolean isFileSeparator(char ch) {
        return ch == Chars.SLASH || ch == Chars.BACK_SLASH;
    }

    /**
     * 判断字符是否相等
     *
     * @param c1 字符1
     * @param c2 字符2
     * @return true: 是 false: 否
     */
    public static boolean equals(char c1, char c2) {
        return c1 == c2;
    }

    /**
     * 判断字符是否不相等
     *
     * @param c1 字符1
     * @param c2 字符2
     * @return true: 是 false: 否
     */
    public static boolean notEquals(char c1, char c2) {
        return c1 != c2;
    }

    /**
     * 忽略大小写判断字符是否相等
     *
     * @param c1 字符1
     * @param c2 字符2
     * @return true: 是 false: 否
     */
    public static boolean equalsIgnoreCase(char c1, char c2) {
        return c1 == c2 || Character.toUpperCase(c1) == Character.toUpperCase(c2);
    }

    /**
     * 忽略大小写判断字符是否不相等
     *
     * @param c1 字符1
     * @param c2 字符2
     * @return true: 是 false: 否
     */
    public static boolean notEqualsIgnoreCase(char c1, char c2) {
        return c1 != c2 && Character.toUpperCase(c1) != Character.toUpperCase(c2);
    }
}
