package com.mzhotel.sm.actionLog.dto;

public enum ActionLogEnum {

    SAVE("SAVE"),
    UPDATE("UPDATE"),
    DELETE("DELETE"),
    DOWLOAD("DOWLOAD");

    private String actionLogType;

    ActionLogEnum(String actionLogType) {
        this.actionLogType = actionLogType;
    }

    public String getActionLogType() {
        return actionLogType;
    }

    public void setActionLogType(String actionLogType) {
        this.actionLogType = actionLogType;
    }
}
