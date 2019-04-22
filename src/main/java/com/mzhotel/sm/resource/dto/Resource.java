package com.mzhotel.sm.resource.dto;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.mzhotel.sm.security.dto.Action;
import lombok.Data;

import java.util.*;

@Data
public class Resource {
    private String id;

    private String actionType;

    private String resourceName;

    private String resourceCode;

    private String resourceType;

    private String url;

    private String resourceParent;

    private String state;

    private Long orderNo;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    public static class ActionDescriptor {

        public String action;

        public boolean isActioned;
    }

    public Set<Action> getActionSet() {
        if (!Strings.isNullOrEmpty(actionType)) {
            List<String> strings = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(actionType);
            Set<Action> set = EnumSet.noneOf(Action.class);
            for (String actionString : strings) {
                Action action = Action.build(actionString);
                set.add(action);
            }
            return set;
        }
        return Collections.emptySet();
    }

    public List<ActionDescriptor> getActionEntity() {
        Set<Action> set = getActionSet();
        List<ActionDescriptor> result = new ArrayList<>(Action.values().length);
        for (Action action : Action.values()) {
            ActionDescriptor actionDescriptor = new ActionDescriptor();
            actionDescriptor.action = action.name();
            actionDescriptor.isActioned = set.contains(action);
            if (action == Action.VIEW) {
                actionDescriptor.isActioned = true;
            }
            result.add(actionDescriptor);
        }
        return result;
    }

}