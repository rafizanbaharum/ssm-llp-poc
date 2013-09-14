package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public interface SsmFlowObject extends SsmMetaObject {

    SsmFlowdata getFlowdata();

    void setFlowdata(SsmFlowdata flowdata);

}
