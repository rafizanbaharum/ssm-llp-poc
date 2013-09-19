package com.ssm.llp.core.model;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmCompany extends SsmMetaObject {

    String getName();

    void setName(String name);

    SsmCompanyStatus getCompanyStatus();

    void setCompanyStatus(SsmCompanyStatus status);

    SsmCompanyType getCompanyType();

    void setCompanyType(SsmCompanyType companyType);

    String getAddress1();

    void setAddress1(String address1);

    String getAddress2();

    void setAddress2(String address2);

    String getAddress3();

    void setAddress3(String address3);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getFax();

    void setFax(String fax);



    List<SsmCompanyMember> getMembers();

    void setMembers(List<SsmCompanyMember> members);




}
