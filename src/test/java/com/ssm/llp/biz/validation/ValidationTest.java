package com.ssm.llp.biz.validation;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.SsmNameDaoTest;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Before
    public void setUp() {
    }
}
