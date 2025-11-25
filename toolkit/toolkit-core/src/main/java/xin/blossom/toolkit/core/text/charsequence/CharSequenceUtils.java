package xin.blossom.toolkit.core.text.charsequence;

/**
 * @author haojian
 * @version 1.0
 * @date 2025/11/25 21:06
 */
public abstract class CharSequenceUtils {

    private abstract class AbstractCharSequenceUtil {
        abstract boolean equals(CharSequence cs, CharSequence cs2);
        abstract boolean notEquals(CharSequence cs, CharSequence cs2);
        abstract boolean equalsAny(CharSequence cs, CharSequence... css);
        abstract int compare(CharSequence cs, CharSequence cs2);
    }

    abstract boolean isEmpty();
    abstract boolean isNotEmpty();
    abstract boolean hasEmpty();
    abstract boolean isAllEmpty();
    abstract boolean isBlank();
    abstract boolean isNotBlank();
    abstract boolean hasBlank();
    abstract boolean isAllBlank();
    abstract boolean isNoneBlank();
    abstract boolean isNoneEmpty();
    abstract String nullToDefault();
    abstract String emptyToDefault();
    abstract String blankToDefault();
}