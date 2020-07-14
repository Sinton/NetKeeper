package com.github.constant;

/**
 * @author Yan
 */
public enum CaseEnum {
    /**
     * 驼峰
     */
    CAMEL_CASE(0),
    /**
     * 首字母大写
     */
    PASCAL_CASE(1),
    /**
     * 下划线
     */
    SNAKE_CASE(2),
    /**
     * 短横线
     */
    KEBAB_CASE(3)
    ;
    private int code;

    CaseEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
