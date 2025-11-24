package xin.blossom.toolkit.core.text;

/**
 * @author haojian
 * @version 21.0.0.0
 * @date 2025/11/24 19:47
 */
@lombok.NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CharSequenceUtils {

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
}
