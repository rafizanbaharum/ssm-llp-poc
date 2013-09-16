package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
public interface SsmCompanyMember extends SsmMetaObject {

    /**
     * get principal
     *
     * @return principal
     */
    SsmCompanyRoleType getRoleType();

    void setRoleType(SsmCompanyRoleType roleType);

    /**
     * get principal
     *
     * @return principal
     */
    SsmPrincipal getPrincipal();

    void setPrincipal(SsmPrincipal principal);

    /**
     * get location code
     *
     * @return location code
     */
    SsmCompany getCompany();

    void setCompany(SsmCompany company);


}
