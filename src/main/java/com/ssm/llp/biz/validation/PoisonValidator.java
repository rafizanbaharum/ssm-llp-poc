package com.ssm.llp.biz.validation;

import com.ssm.llp.biz.validation.script.ScriptManager;
import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmFilterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */
@Component("poisonValidator")
public class PoisonValidator {

    private Logger log = LoggerFactory.getLogger(PoisonValidator.class);

    public static final SsmFilterType FILTER_TYPE = SsmFilterType.POISON;

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private ScriptManager scriptManager;

    public boolean validate(String name) {
        List<SsmFilter> filters = filterDao.find(FILTER_TYPE);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        // NOTE: GRRR! STUPID BOOLEAN LOGIC
        boolean result = true;
        for (SsmFilter filter : filters) {
            result = scriptManager.executePoisonFilter(filter.getScript(), map);
            log.debug(filter.getName() + ":" + result);
            if (!result) break;
        }
        return result;
    }
}
