package com.mzhotel.sm.security.dto;

import com.alibaba.fastjson.annotation.JSONCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Action {
    VIEW("VIEW","查看"),
    EDIT("EDIT","编辑"),
    DELETE("DELETE","删除"),
    NEW("NEW","新增");

    private final String value;

    private final String desc;

    Action(String value,String desc) {
        this.value = value;
        this.desc = desc;
    }

    @JSONCreator
    public static Action build(String value) {
        return Action.valueOf(value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
