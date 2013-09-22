package com.ssm.llp.biz.manager.impl;

import com.ssm.llp.biz.manager.CompanyRegistrationManager;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmCompanyMemberDao;
import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.dao.SsmUserDao;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.SsmCompanyMemberImpl;
import com.ssm.llp.core.model.impl.SsmLlpCompanyImpl;
import com.ssm.llp.core.model.impl.SsmReservedNameImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Service("companyRegistrationManager")
@Transactional
public class CompanyRegistrationManagerImpl implements CompanyRegistrationManager {

    private static final Logger log = Logger.getLogger(CompanyRegistrationManagerImpl.class);

    private final int RESERVE_DURATION = 3;
    private final int RESERVE_PERIOD = Calendar.MONTH;


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
    private SsmNameDao nameDao;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void register(String name, SsmCompanyType companyType, boolean waived, SsmUser user) {
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

    @Override
    public void reserveName(String name, SsmCompanyType companyType, boolean waived, SsmUser user) {

        SsmReservedName ssmName = new SsmReservedNameImpl();
        ssmName.setName(name);
        ssmName.setStartDate(new Date());

        Calendar cal = new GregorianCalendar();
        cal.add(RESERVE_PERIOD, RESERVE_DURATION);
        ssmName.setEndDate(cal.getTime());
        ssmName.setCompanyType(companyType);
        ssmName.setWaived(waived);

        nameDao.save(ssmName, user);
    }
}
