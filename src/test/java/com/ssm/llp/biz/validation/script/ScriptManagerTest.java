package com.ssm.llp.biz.validation.script;

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.SsmNameDaoTest;
import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmFilterType;
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
    private ScriptUtil scriptUtil;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
    }

    @Test
    @Rollback(value = false)
    public void testSearchScript() {
        List<SsmFilter> filters = filterDao.find(SsmFilterType.SEARCH);
        for (SsmFilter filter : filters) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", "MALAYSIA RAYA PLT");
            boolean valid = scriptManager.executeSearchFilter(filter.getScript(), map);
            log.debug("valid?: " + valid);
        }
    }


    @Test
    @Rollback(value = false)
    public void testPoisonScript() {
        List<SsmFilter> filters = filterDao.find(SsmFilterType.POISON);
        for (SsmFilter filter : filters) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", "MALAYSIA MEMBODOH PLT");
            boolean valid = scriptManager.executePoisonFilter(filter.getScript(), map);
            log.debug("Result : " + filter.getName() + " " + valid);
        }
    }

    @Test
    @Rollback(value = false)
    public void testUtils() {
        String[] strings = scriptUtil.makePairs("AL ARABI WAL WAHDI");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void testUtils2() {
        String[] strings = scriptUtil.makePairs("");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void testPermutates() {
        String[] strings = scriptUtil.permutatePairs("AL ARABI WAL WAHDI");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void testPermutates2() {
        String[] strings = scriptUtil.permutatePairs("");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }
}
