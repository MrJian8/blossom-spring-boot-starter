package xin.blossom.toolkit.core.constant;

import java.io.File;

/**
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 17:26
 */
public interface Strings {
    /**
     * 空字符
     */
    String EMPTY = "";
    /**
     * NULL字符
     */
    String NULL = "null";
    /**
     * 空格
     */
    String SPACE = " ";
    /**
     * 点
     */
    String DOT = ".";
    String DOT_CN = "。";
    /**
     * 逗号
     */
    String COMMA = ",";
    String COMMA_CN = "，";
    /**
     * 冒号
     */
    String COLON = ":";
    String COLON_CN = "：";
    /**
     * 省略号
     */
    String ELLIPSIS = "...";
    /**
     * 制表符
     */
    String TAB = "\t";
    /**
     * 斜杠
     */
    String SLASH = "/";
    /**
     * 反斜杠
     */
    String BACK_SLASH = "\\";
    /**
     * Represents the system-dependent default name-separator Stringacter, as returned by
     * {@link File#separatorChar}. This is used to separate components of a file path.
     */
    String DIR_SEPARATOR = File.separatorChar + "";
    /**
     * 回车
     */
    String CR = "\r";
    /**
     * 换行
     */
    String LF = "\n";
    /**
     * 减号
     */
    String DASHED = "-";
    /**
     * 下划线
     */
    String UNDERLINE = "_";
    /**
     * 花括号（左）
     */
    String DELIM_START = "{";
    /**
     * 花括号（右）
     */
    String DELIM_END = "}";
    /**
     * 中括号（左）
     */
    String BRACKET_START = "[";
    /**
     * 中括号（右）
     */
    String BRACKET_END = "]";
    /**
     * 双引号
     */
    String DOUBLE_QUOTES = "\"";
    /**
     * 单引号
     */
    String SINGLE_QUOTE = "'";
    /**
     * &
     */
    String AMP = "&";
    /**
     * @
     */
    String AT = "@";
    /**
     * #
     */
    String HASH = "#";

}
