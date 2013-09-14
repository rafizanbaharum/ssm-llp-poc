package com.ssm.llp.biz.validation.script;

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.SsmNameDaoTest;
import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.core.model.impl.SsmFilterImpl;
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

import java.util.HashMap;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
public class ScriptManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(SsmNameDaoTest.class);

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private ScriptManager scriptManager;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
    }

    @Test
    @Rollback(value = false)
    public void testSearchScript() {
        List<SsmFilterImpl> filters = filterDao.findFilters(SsmFilterType.SEARCH);
        for (SsmFilterImpl filter : filters) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", "MALAYSIA RAYA PLT");
            List<SsmCompany> list = scriptManager.executeSearchFilter(filter.getScript(), map);
            for (SsmCompany name : list) {
                log.debug("Name: " + name.getName());
            }
        }
    }

    @Test
    @Rollback(value = false)
    public void testPoisonScript() {
        List<SsmFilterImpl> filters = filterDao.findFilters(SsmFilterType.POISON);
        for (SsmFilterImpl filter : filters) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", "MALAYSIA MEMBODOH PLT");
            boolean result = scriptManager.executePoisonFilter(filter.getScript(), map);
            log.debug("Result : " + filter.getName() + " " + result);
        }
    }
}
