package com.ssm.llp.biz.manager;

import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmUser;

/**
 * @author rafizan.baharum
 * @since 9/15/13
 */
public interface CompanyRegistrationManager {

    void register(String name, SsmCompanyType companyType, boolean waived, SsmUser user);

    void reserveName(String name, SsmCompanyType companyType, boolean waived, SsmUser user);
}
