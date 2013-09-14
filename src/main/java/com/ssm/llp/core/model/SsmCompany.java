package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmCompany extends SsmMetaObject {

    String getName();

    void setName(String name);

    SsmCompanyStatus getStatus();

    void setStatus(SsmCompanyStatus status);

    SsmCompanyType getCompanyType();

    void setCompanyType(SsmCompanyType companyType);
}
