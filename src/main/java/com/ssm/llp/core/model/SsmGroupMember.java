package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmGroupMember  extends SsmMetaObject{
    
    SsmGroup getGroup();

    void setGroup(SsmGroup group);

    SsmPrincipal getMember();

    void setMember(SsmPrincipal member);
}
