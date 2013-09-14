package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmCompanyDao {

    // finders
    SsmCompany findById(Long id);

    List<SsmCompany> findCompanies(String filter);


    // cruds

    void save(SsmCompany company, SsmUser user);

    void update(SsmCompany company, SsmUser user);

    void deactivate(SsmCompany company, SsmUser user);

    void remove(SsmCompany company, SsmUser user);

}
