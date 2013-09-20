package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmCompanyDao {

    // finders
    SsmCompany findById(Long id);

    List<SsmCompany> find();

    List<SsmCompany> find(String filter);

    List<SsmCompany> findByOwner(SsmCompanyType companyType, SsmUser owner);

    // helpers

    boolean hasName(String name);

    boolean isValidWinding(String name);

    // cruds

    void save(SsmCompany company, SsmUser user);

    void update(SsmCompany company, SsmUser user);

    void deactivate(SsmCompany company, SsmUser user);

    void remove(SsmCompany company, SsmUser user);

}
