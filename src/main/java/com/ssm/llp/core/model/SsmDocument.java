package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public interface SsmDocument extends SsmFlowObject {

    String getReferenceNo();

    void setReferenceNo(String referenceNo);

    String getSourceNo();

    void setSourceNo(String sourceNo);

}
