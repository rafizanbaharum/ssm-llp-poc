package com.ssm.llp.biz.validation;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.SsmNameDaoTest;
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

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
public class ValidationTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(SsmNameDaoTest.class);

    @Autowired
    private PoisonValidator poisonValidator;

    @Autowired
    private SearchValidator searchValidator;

    @Before
    public void setUp() {
    }

    @Test
    @Rollback(value = true)
    public void testSearch() {
        boolean validate = searchValidator.validate("MALAYSIA RAYA PLT");
        log.debug("valid?: " + validate);
    }

    @Test
    @Rollback(value = true)
    public void testPoison() {
        log.debug("valid?: " + poisonValidator.validate("* RAYA PLT"));
    }
}
