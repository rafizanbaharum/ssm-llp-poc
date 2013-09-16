package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmCompanyMember;
import com.ssm.llp.core.model.SsmPrincipal;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
public interface SsmCompanyMemberDao {

    // finders

    SsmCompanyMember findById(Long id);

    List<SsmCompanyMember> find(Integer offset, Integer limit);

    List<SsmCompanyMember> find();

    List<SsmCompanyMember> find(SsmCompany company, Integer offset, Integer limit);

    List<SsmCompanyMember> find(SsmCompany company);

    List<SsmUser> findUsers(SsmCompany company);

    List<SsmPrincipal> findMembers(SsmCompany company);

    List<SsmCompanyMember> find(String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    Integer count(SsmCompany company);

    boolean isExist(SsmCompany company, SsmPrincipal member);

    // cruds

    void save(SsmCompanyMember companyMember, SsmUser user);

    void update(SsmCompanyMember companyMember, SsmUser user);

    void remove(SsmCompanyMember companyMember, SsmUser user);

    SsmCompanyMember addMember(SsmCompany company, SsmPrincipal principal, SsmUser user);

    void removeMember(SsmCompany company, SsmPrincipal principal, SsmUser user);

    void removeMember(SsmCompany company, SsmPrincipal principal);

    void removeMembers(SsmCompany company, List<SsmPrincipal> principal);

    void addMembers(SsmCompany company, List<SsmPrincipal> principals, SsmUser user);

    void removeMembers(SsmCompany company, List<SsmPrincipal> principals, SsmUser user);

}
