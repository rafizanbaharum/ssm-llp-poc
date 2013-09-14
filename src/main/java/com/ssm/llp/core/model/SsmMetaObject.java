package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/11/13
 */
public interface SsmMetaObject {

    Long getId();

    SsmMetadata getMetadata();

    void setMetadata(SsmMetadata metadata);
}
