package xin.blossom.toolkit.core.data;

/**
 * 枚举接口定义
 *
 * @author haojian
 * @version 1.0
 * @date 2025/11/24 17:59
 */
public interface IEnum<T> {
    /**
     * 获取枚举值
     *
     * @return 枚举value
     */
    T getValue();

    /**
     * 获取枚举备注
     *
     * @return 枚举备注
     */
    String getDesc();
}