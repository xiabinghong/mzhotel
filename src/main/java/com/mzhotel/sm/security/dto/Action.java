package com.mzhotel.sm.security.dto;

import com.alibaba.fastjson.annotation.JSONCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum Action {
    VIEW("VIEW"),
    EDIT("EDIT"),
    DELETE("DELETE"),
    NEW("NEW");

    private final String value;

    Action(String value) {
        this.value = value;
    }

    @JSONCreator
    public static Action build(String value) {
        return Action.valueOf(value);
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
