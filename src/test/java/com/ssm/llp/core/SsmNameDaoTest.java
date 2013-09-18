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

    /**
     * delete from SSM_CONTROLLED_NAME;
     * delete from SSM_GAZETTED_NAME;
     * delete from SSM_OFFENSIVE_NAME;
     * delete from SSM_COUNTRY_NAME;
     * delete from SSM_STATE_NAME;
     * delete from SSM_RESERVED_NAME;
     * delete from SSM_SYMBOL_NAME;
     * delete from SSM_PLURAL_NAME;
     * delete from SSM_SIMILAR_NAME;
     * delete from SSM_NAME;
     */

    @Test
    @Rollback(value = false)
    public void createNames() {
        // state
        String[] states = {"JOHOR", "NEGERI SEMBILAN", "MELAKA", "SELANGOR", "KUALA LUMPUR", "WILAYAH PERSEKUTUAN",
                "PERAK", "KEDAH", "PULAU PINANG", "PERLIS", "PAHANG", "KELANTAN", "TERENGGANU", "SABAH", "SARAWAK"};
        for (int i = 0; i < states.length; i++) {
            String state = states[i];
            SsmStateName stateName = new SsmStateNameImpl();
            stateName.setName("MALAYSIA");
            ssmNameDao.save(stateName, root);
            sessionFactory.getCurrentSession().flush();
        }

        // symbols
        String[] symbols = {"\\", "|", "/", "*", "%", "\"", ":", ";"};
        for (String symbol : symbols) {
            SsmSymbolNameImpl name1 = new SsmSymbolNameImpl();
            name1.setName(symbol);
            ssmNameDao.save(name1, root);
            sessionFactory.getCurrentSession().flush();
        }

        // country
        try {
            FileReader reader = new FileReader("C:/Projects/GitHub/ssm-llp-poc/src/test/resources/data/country.txt");
            LineNumberReader lineReader = new LineNumberReader(reader);
            String buff;
            while (null != (buff = lineReader.readLine())) {
                SsmCountryName country = new SsmCountryNameImpl();
                country.setName(buff.split("\t")[1].toUpperCase());
                ssmNameDao.save(country, root);
            }
            sessionFactory.getCurrentSession().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // controlled
        try {
            FileReader reader = new FileReader("C:/Projects/GitHub/ssm-llp-poc/src/test/resources/data/controlled.txt");
            LineNumberReader lineReader = new LineNumberReader(reader);
            String buff;
            while (null != (buff = lineReader.readLine())) {
                SsmControlledName controlled = new SsmControlledNameImpl();
                controlled.setName(buff.split("\t")[1]);
                ssmNameDao.save(controlled, root);
            }
            sessionFactory.getCurrentSession().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // gazetted
        try {
            FileReader reader = new FileReader("C:/Projects/GitHub/ssm-llp-poc/src/test/resources/data/gazetted.txt");
            LineNumberReader lineReader = new LineNumberReader(reader);
            String buff;
            while (null != (buff = lineReader.readLine())) {
                SsmGazettedName gazetted = new SsmGazettedNameImpl();
                gazetted.setName(buff.split("\t")[1]);
                ssmNameDao.save(gazetted, root);
            }
            sessionFactory.getCurrentSession().flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //offensive
        try {
            FileReader reader = new FileReader("C:/Projects/GitHub/ssm-llp-poc/src/test/resources/data/offensive.txt");
            LineNumberReader lineReader = new LineNumberReader(reader);
            String buff;
            while (null != (buff = lineReader.readLine())) {
                SsmOffensiveName offensive = new SsmOffensiveNameImpl();
                offensive.setName(buff.split("\t")[1]);
                ssmNameDao.save(offensive, root);
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
    public void insertReserved() {
        SsmReservedName name1 = new SsmReservedNameImpl();
        name1.setName("ALI MAJU");
        name1.setCompanyType(SsmCompanyType.LLP);
        name1.setStartDate(new Date());
        name1.setEndDate(new Date());
        ssmNameDao.save(name1, root);

        SsmReservedName name2 = new SsmReservedNameImpl();
        name2.setName("AWAL MAJU");
        name2.setCompanyType(SsmCompanyType.LLP);
        name2.setStartDate(new Date());
        name2.setEndDate(new Date());
        ssmNameDao.save(name2, root);
    }

    @Test
    @Rollback(value = false)
    public void insertPlural() {
        SsmPluralName name1 = new SsmPluralNameImpl();
        name1.setName("KUIH");
        name1.setPlural("KUIH-MUIH");
        ssmNameDao.save(name1, root);
    }

    @Test
    @Rollback(value = false)
    public void insertSimilar() {
        SsmSimilarName name1 = new SsmSimilarNameImpl();
        name1.setName("BUILD");
        name1.setSimile("BUILDER");
        ssmNameDao.save(name1, root);

        SsmSimilarName name2 = new SsmSimilarNameImpl();
        name2.setName("BUILDER");
        name2.setSimile("BUILD");
        ssmNameDao.save(name1, root);

        SsmSimilarName name3 = new SsmSimilarNameImpl();
        name3.setName("TECH");
        name3.setSimile("TECHNOLOGIES");
        ssmNameDao.save(name1, root);

        SsmSimilarName name4 = new SsmSimilarNameImpl();
        name4.setName("TECHNOLOGY");
        name4.setSimile("TECHNOLOGIES");
        ssmNameDao.save(name1, root);

        SsmSimilarName name5 = new SsmSimilarNameImpl();
        name5.setName("TECHNOLOGY");
        name5.setSimile("TECH");
        ssmNameDao.save(name1, root);
    }
}

