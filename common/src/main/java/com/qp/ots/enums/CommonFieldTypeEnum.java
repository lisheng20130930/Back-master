package com.qp.ots.enums;

/**
 * @author Listen.Li
 */
public enum CommonFieldTypeEnum {
    REGULAR(1, "普通字段"), EXTEND(2, "扩展字段");

    private Integer id;
    private String text;

    CommonFieldTypeEnum(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public static String getText(int id) {
        for (CommonFieldTypeEnum e : CommonFieldTypeEnum.values()) {
            if (e.getId() == id) {
                return e.getText();
            }
        }
        return "";
    }

    public static Integer getId(String text) {
        for (CommonFieldTypeEnum e : CommonFieldTypeEnum.values()) {
            if (e.getText().equals(text)) {
                return e.getId();
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
