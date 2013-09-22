package com.ssm.llp.biz.validation;

import com.ssm.llp.biz.validation.script.ScriptManager;
import com.ssm.llp.core.dao.SsmFilterDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rafizan.baharum
 * @since 9/18/13
 */
public class ValidatorSupport {

    @Autowired
    protected SsmFilterDao filterDao;

    @Autowired
    protected ScriptManager scriptManager;


}
