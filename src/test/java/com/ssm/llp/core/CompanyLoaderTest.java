package com.ssm.llp.core;

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmUserDao;
import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmCompanyStatus;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.core.model.impl.SsmLlpCompanyImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
public class CompanyLoaderTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final Logger log = Logger.getLogger(CompanyLoaderTest.class);

    @Autowired
    private SsmCompanyDao companyDao;

    @Autowired
    private SsmUserDao userDao;

    private SsmUser root;

    @Before
    public void setUp() {
        root = userDao.findByUsername("root");
    }

    @Test
    @Rollback(value = false)
    public void doLoad() {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            SsmCompany company = new SsmLlpCompanyImpl();
            company.setName("ALAM MEKAR");
            company.setCompanyStatus(SsmCompanyStatus.WINDING);
            company.setExpiredDate(dateFormat.parse("31/12/2011"));
            companyDao.save(company, root);

            company = new SsmLlpCompanyImpl();
            company.setName("ALIRAN DATA");
            company.setCompanyStatus(SsmCompanyStatus.WINDING);
            company.setExpiredDate(dateFormat.parse("31/12/2008"));
            companyDao.save(company, root);


        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
