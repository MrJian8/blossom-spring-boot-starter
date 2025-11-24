package xin.blossom.toolkit.core.constant;

import java.io.File;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 17:26
 */
public interface Chars {
    /**
     * 空格
     */
    char SPACE = ' ';
    /**
     * 点
     */
    char DOT = '.';
    char DOT_CN = '。';
    /**
     * 逗号
     */
    char COMMA = ',';
    char COMMA_CN = '，';
    /**
     * 冒号
     */
    char COLON = ':';
    char COLON_CN = '：';
    /**
     * 制表符
     */
    char TAB = '\t';
    /**
     * 斜杠
     */
    char SLASH = '/';
    /**
     * 反斜杠
     */
    char BACK_SLASH = '\\';
    /**
     * Represents the system-dependent default name-separator character, as returned by
     * {@link File#separatorChar}. This is used to separate components of a file path.
     */
    char DIR_SEPARATOR = File.separatorChar;
    /**
     * 回车
     */
    char CR = '\r';
    /**
     * 换行
     */
    char LF = '\n';
    /**
     * 减号
     */
    char DASHED = '-';
    /**
     * 下划线
     */
    char UNDERLINE = '_';
    /**
     * 花括号（左）
     */
    char DELIM_START = '{';
    /**
     * 花括号（右）
     */
    char DELIM_END = '}';
    /**
     * 中括号（左）
     */
    char BRACKET_START = '[';
    /**
     * 中括号（右）
     */
    char BRACKET_END = ']';
    /**
     * 双引号
     */
    char DOUBLE_QUOTES = '"';
    /**
     * 单引号
     */
    char SINGLE_QUOTE = '\'';
    /**
     * &
     */
    char AMP = '&';
    /**
     * @
     */
    char AT = '@';
    /**
     * #
     */
    char HASH = '#';
}