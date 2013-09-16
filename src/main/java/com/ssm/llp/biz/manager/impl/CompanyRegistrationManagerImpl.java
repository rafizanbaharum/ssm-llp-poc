package com.ssm.llp.biz.manager.impl;

import com.ssm.llp.biz.manager.CompanyRegistrationManager;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmCompanyMemberDao;
import com.ssm.llp.core.dao.SsmUserDao;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.SsmCompanyMemberImpl;
import com.ssm.llp.core.model.impl.SsmLlpCompanyImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Service("companyRegistrationManager")
@Transactional
public class CompanyRegistrationManagerImpl implements CompanyRegistrationManager {

    public static final String ADMIN = "root";
    @Autowired
    private SsmUserDao userDao;

    @Autowired
    private SsmCompanyDao companyDao;

    @Autowired
    private SsmCompanyMemberDao memberDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void register(String name, SsmCompanyType companyType, SsmUser user) {
        // save company
        SsmLlpCompany company = new SsmLlpCompanyImpl();
        company.setCompanyStatus(SsmCompanyStatus.NEW);
        company.setCompanyType(SsmCompanyType.LLP);
        company.setName(name);
        companyDao.save(company, user);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(company);

        // save member
        SsmCompanyMember member = new SsmCompanyMemberImpl();
        member.setCompany(company);
        member.setPrincipal(user);
        member.setRoleType(SsmCompanyRoleType.DIRECTOR);
        memberDao.save(member, user);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().refresh(company);
    }
}
