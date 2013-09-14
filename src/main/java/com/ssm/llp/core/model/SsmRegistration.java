package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmRegistration extends SsmDocument {

    String getName();

    void setName(String name);

    SsmRegistrationType getType();

    void setType(SsmRegistrationType type);
}
