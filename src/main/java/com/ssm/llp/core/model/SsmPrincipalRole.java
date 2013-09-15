package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmPrincipalRole extends SsmMetaObject{

    SsmRoleType getRoleType();

    void setRoleType(SsmRoleType roleType);

    SsmPrincipal getPrincipal();

    void setPrincipal(SsmPrincipal principal);

}
