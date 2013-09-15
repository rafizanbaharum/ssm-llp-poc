package com.ssm.llp.core;

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.dao.SsmUserDao;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.*;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
public class SsmNameDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(SsmNameDaoTest.class);

    @Autowired
    private SsmNameDao ssmNameDao;

    @Autowired
    private SsmCompanyDao ssmCompanyDao;

    @Autowired
    private SsmUserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    private SsmUser root;

    @Before
    public void setUp() {
        root = userDao.findByUsername("root");
    }

    @Test
    @Rollback(value = false)
    public void createCountry() {
        SsmCountryNameImpl countryName = new SsmCountryNameImpl();
        countryName.setName("MALAYSIA");
        ssmNameDao.save(countryName, root);

        countryName = new SsmCountryNameImpl();
        countryName.setName("SINGAPORE");
        ssmNameDao.save(countryName, root);

        countryName = new SsmCountryNameImpl();
        countryName.setName("SINGAPURA");
        ssmNameDao.save(countryName, root);

        countryName = new SsmCountryNameImpl();
        countryName.setName("THAILAND");
        ssmNameDao.save(countryName, root);

        countryName = new SsmCountryNameImpl();
        countryName.setName("FILIPINA");
        ssmNameDao.save(countryName, root);

        countryName = new SsmCountryNameImpl();
        countryName.setName("PHILLIPINE");
        ssmNameDao.save(countryName, root);

        sessionFactory.getCurrentSession().flush();
    }

    @Test
    @Rollback(value = false)
    public void createOffensive() {

        try {
            FileReader reader = new FileReader("C:/Projects/GitHub/ssm-llp-poc/src/test/resources/ControlledWords.txt");
            LineNumberReader lreader = new LineNumberReader(reader);
            String buff;
            while (null != (buff = lreader.readLine())) {
                SsmOffensiveNameImpl offensiveName = new SsmOffensiveNameImpl();
                offensiveName.setName(buff.split("\t")[1]);
                ssmNameDao.save(offensiveName, root);
            }
            sessionFactory.getCurrentSession().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Rollback(value = false)
    public void createCompanies() {
        SsmCompanyImpl name1 = new SsmRocCompanyImpl();
        name1.setName("MAJU JAYA");
        name1.setCompanyStatus(SsmCompanyStatus.ACTIVE);
        ssmCompanyDao.save(name1, root);

        SsmCompanyImpl name2 = new SsmRocCompanyImpl();
        name2.setName("JAYA & MAJU RESTORAN");
        name2.setCompanyStatus(SsmCompanyStatus.ACTIVE);
        ssmCompanyDao.save(name2, root);
        sessionFactory.getCurrentSession().flush();

        SsmCompanyImpl name3 = new SsmLlpCompanyImpl();
        name3.setName("MALAYSIA RAYAS");
        name3.setCompanyStatus(SsmCompanyStatus.ACTIVE);
        ssmCompanyDao.save(name3, root);
        sessionFactory.getCurrentSession().flush();
    }

    @Test
    @Rollback(value = false)
    public void insertOffensive() {
        SsmOffensiveName name1 = new SsmOffensiveNameImpl();
        name1.setName("SYARIKAT");
        ssmNameDao.save(name1, root);

        SsmOffensiveName name2 = new SsmOffensiveNameImpl();
        name2.setName("CORPORATION");
        ssmNameDao.save(name2, root);
        sessionFactory.getCurrentSession().flush();

        SsmOffensiveName name3 = new SsmOffensiveNameImpl();
        name3.setName("COMPANY");
        ssmNameDao.save(name3, root);
        sessionFactory.getCurrentSession().flush();
    }

    @Test
    @Rollback(value = false)
    public void insertReserved() {
        SsmReservedName name1 = new SsmReservedNameImpl();
        name1.setName("ALI MAJU");
        name1.setCompanyType(SsmCompanyType.ROC);
        name1.setStartDate(new Date());
        name1.setEndDate(new Date());
        ssmNameDao.save(name1, root);

        SsmReservedName name2 = new SsmReservedNameImpl();
        name2.setName("ALI JAYA");
        name2.setCompanyType(SsmCompanyType.ROC);
        name2.setStartDate(new Date());
        name2.setEndDate(new Date());
        ssmNameDao.save(name2, root);
    }

    @Test
    @Rollback(value = false)
    public void insertSymbols() {
        String[] symbols = {"\\", "|", "/", "*", "%", "\"", ":", ";"};
        for (String symbol : symbols) {
            SsmSymbolNameImpl name1 = new SsmSymbolNameImpl();
            name1.setName(symbol);
            ssmNameDao.save(name1, root);
            sessionFactory.getCurrentSession().flush();
        }
    }
}

