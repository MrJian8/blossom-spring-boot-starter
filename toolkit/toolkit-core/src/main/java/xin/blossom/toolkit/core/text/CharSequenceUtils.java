package xin.blossom.toolkit.core.text;

import java.util.Arrays;
import java.util.function.Predicate;

import xin.blossom.toolkit.core.collection.ArrayUtils;

/**
 * @author haojian
 * @version 1.0
 * @date 2025/11/25 21:06
 */
public abstract class CharSequenceUtils {

    abstract boolean isEmpty(CharSequence cs);
    abstract boolean isNotEmpty(CharSequence cs);
    abstract boolean hasEmpty(CharSequence... css);
    abstract boolean isAllEmpty(CharSequence... css);
    abstract boolean isBlank(CharSequence cs);
    abstract boolean isNotBlank(CharSequence cs);
    abstract boolean hasBlank(CharSequence... css);
    abstract boolean isAllBlank(CharSequence... css);
    abstract boolean isNoneBlank(CharSequence... css);
    abstract boolean isNoneEmpty(CharSequence... css);
    abstract String nullToDefault(CharSequence cs, CharSequence defaultValue);
    abstract String emptyToDefault(CharSequence cs, CharSequence defaultValue);
    abstract String blankToDefault(CharSequence cs, CharSequence defaultValue);
    abstract String emptyToNull(CharSequence cs);
    abstract String nullToEmpty(CharSequence cs);
    abstract String emptyIfNull(CharSequence cs);
    abstract boolean isNullOrUndefined(CharSequence cs);
    abstract boolean isNullOrUndefinedStr(CharSequence cs);
    abstract boolean isEmptyOrUndefinedStr(CharSequence cs);
    abstract boolean isBlankOrUndefinedStr(CharSequence cs);
    abstract String trim(CharSequence cs, int mode, Predicate<Character> predicate);
    abstract String trim(CharSequence cs, int mode);
    abstract String trimStart(CharSequence cs);
    abstract String trimEnd(CharSequence cs);
    abstract String trimToEmpty(CharSequence cs);
    abstract String trimToNull(CharSequence cs);
    abstract boolean containsBlank(CharSequence cs);
    abstract boolean containsOnly(CharSequence cs, char... searchCss);

    private abstract class AbstractCharSequenceUtil {
        /**
         * 比较两个字符串
         *
         * @param cs1 字符串1
         * @param cs2 字符串2
         * @return 比较结果
         */
        abstract int compare(CharSequence cs1, CharSequence cs2);
        /**
         * 判断两个字符串是否相等
         *
         * @param cs1 字符串1
         * @param cs2 字符串2
         * @return true:相等 false:不相等
         */
        abstract boolean equals(CharSequence cs1, CharSequence cs2);
        /**
         * 判断两个字符串是否不相等
         * @param cs1 字符1
         * @param cs2 字符2
         * @return true:不相等 false:相等
         */
        public boolean notEquals(CharSequence cs1, CharSequence cs2){
            return !equals(cs1, cs2);
        }

        /**
         * 给定字符串是否与提供的中任一字符串相同，相同则返回{@code true}，没有相同的返回{@code false}<br>
         * 如果参与比对的字符串列表为空，返回{@code false}
         *
         * @param cs       给定需要检查的字符串
         * @param css       需要参与比对的字符串列表
         * @return 是否相同
         */
        public boolean equalsAny(CharSequence cs, CharSequence... css) {
            if (ArrayUtils.isEmpty(css)) {
                return false;
            }
            return Arrays.stream(css).anyMatch(e -> equals(cs, e));
        }
        abstract boolean startWith(CharSequence cs, CharSequence prefix);
        public boolean startWithAny(CharSequence cs, CharSequence... prefixArray){
            if (isEmpty(cs)|| ArrayUtils.isEmpty(prefixArray)) {
                return false;
            }
            return Arrays.stream(prefixArray).anyMatch(prefix -> startWith(cs, prefix));
        }
        abstract boolean endWith(CharSequence cs, CharSequence suffix);
        public boolean endWithAny(CharSequence cs, CharSequence... suffixArray){
            if (isEmpty(cs)||ArrayUtils.isEmpty(suffixArray)) {
                return false;
            }
            return Arrays.stream(suffixArray).anyMatch(suffix -> endWith(cs, suffix));
        }
        abstract boolean contains(CharSequence cs, CharSequence searchCs);
        public boolean containsAny(CharSequence cs, CharSequence... searchCss){
            if (isEmpty(cs)||ArrayUtils.isEmpty(searchCss)) {
                return false;
            }
            return Arrays.stream(searchCss).anyMatch(searchCs -> contains(cs, searchCs));
        }
        public boolean containsAll(CharSequence cs, CharSequence... searchCss){
            if (isEmpty(cs)||ArrayUtils.isEmpty(searchCss)) {
                return false;
            }
            return Arrays.stream(searchCss).allMatch(searchCs -> contains(cs, searchCs));
        }
        abstract int indexOf(CharSequence cs, CharSequence searchCs);
        abstract int lastIndexOf(CharSequence cs, CharSequence searchCs);
        abstract int removeAll(CharSequence cs, CharSequence removeCs);
        abstract int removeAny(CharSequence cs, CharSequence... removeCss);
        abstract int removePrefix(CharSequence cs, CharSequence prefix);
        abstract int removeAllPrefix(CharSequence cs, CharSequence... prefixArray);
        abstract int removeSuffix(CharSequence cs, CharSequence suffix);
        abstract int removeAllSuffix(CharSequence cs, CharSequence... suffixArray);
        abstract int strip(CharSequence str, CharSequence prefix, CharSequence suffix);
        abstract int strip(CharSequence str, CharSequence stripCs);
        abstract int stripAll(CharSequence str, CharSequence prefix, CharSequence suffix);
        abstract int stripAll(CharSequence str, CharSequence stripCs);
    }
}