package com.mzhotel.sm.security.subject;

import com.alibaba.fastjson.annotation.JSONCreator;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Set;

public class MzhotelPrincipalCollection extends SimplePrincipalCollection implements Serializable{

    private static final long serialVersionUID = -5860818524788029613l;

    public MzhotelPrincipalCollection(){super();}

    @JSONCreator
    public MzhotelPrincipalCollection(@JsonProperty("principal") Object principal,@JsonProperty("realmName") String realmName){
        super(principal,realmName);
        this.principal = principal;
        this.realmName = realmName;
    }

    @JsonIgnore
    boolean empty;

    @JsonIgnore
    Set<String> realmNames;

    @JsonIgnore
    Object primaryPrincipal;

    Object principal;

    private String realmName;

    public Object getPrincipal() {
        return principal;
    }

    public void setPrincipal(Object principal) {
        this.principal = principal;
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }
}
