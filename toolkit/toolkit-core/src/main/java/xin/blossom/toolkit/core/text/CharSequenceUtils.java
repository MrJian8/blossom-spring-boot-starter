package xin.blossom.toolkit.core.text;

import java.util.function.Predicate;

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

    private abstract class AbstractCharSequenceUtil {
        abstract int compare(CharSequence cs, CharSequence cs2);
        abstract boolean equals(CharSequence cs, CharSequence cs2);
        abstract boolean notEquals(CharSequence cs, CharSequence cs2);
        abstract boolean equalsAny(CharSequence cs, CharSequence... css);
        abstract boolean startWith(CharSequence cs, CharSequence prefix);
        abstract boolean startWithAny(CharSequence cs, CharSequence... prefixArray);
        abstract boolean endWith(CharSequence cs, CharSequence suffix);
        abstract boolean endWithAny(CharSequence cs, CharSequence... suffixArray);
        abstract boolean contains(CharSequence cs, CharSequence searchCs);
        abstract boolean containsAny(CharSequence cs, CharSequence... searchCss);
        abstract boolean containsAll(CharSequence cs, CharSequence... searchCss);
        abstract boolean containsOnly(CharSequence cs, CharSequence... searchCss);
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