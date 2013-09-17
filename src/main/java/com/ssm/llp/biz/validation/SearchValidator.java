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
 * Fail fast
 * @author rafizan.baharum
 * @since 9/7/13
 */
@Component("searchValidator")
public class SearchValidator {

    private Logger log = LoggerFactory.getLogger(PoisonValidator.class);

    public static final SsmFilterType FILTER_TYPE = SsmFilterType.SEARCH;

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private ScriptManager scriptManager;

    public boolean isExisted(String name) {
        List<SsmFilter> filters = filterDao.find(FILTER_TYPE);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        boolean result = false;
        for (SsmFilter filter : filters) {
            result = scriptManager.executeSearchFilter(filter.getScript(), map);
            log.debug(filter.getName() + ":" + result);
            if (result) break;
        }
        return false;
    }
}
