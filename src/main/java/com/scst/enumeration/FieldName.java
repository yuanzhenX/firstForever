package com.scst.enumeration;


public enum FieldName {
    AGE("age", "年龄"),
    CREDIT("credit", "学分"),
    SCORE("score", "分数"),
    CID("cid", "课程编号"),
    SID("sid", "学号");

    private String field;
    private String fieldNameInChinese;

    // 构造器
    FieldName(String field, String fieldNameInChinese) {
        this.field = field;
        this.fieldNameInChinese = fieldNameInChinese;
    }

    // 获取字段名称
    public String getField() {
        return field;
    }

    // 获取中文名称
    public String getFieldNameInChinese() {
        return fieldNameInChinese;
    }

    // 根据字段名获取中文名称
    public static String getChineseName(String field) {
        for (FieldName value : values()) {
            if (value.getField().equals(field)) {
                return value.getFieldNameInChinese();
            }
        }
        return null; // 如果没有找到，返回 null 或者可以返回一个默认值
    }
}
