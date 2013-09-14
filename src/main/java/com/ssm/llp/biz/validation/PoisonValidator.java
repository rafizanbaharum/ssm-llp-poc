package com.ssm.llp.biz.validation;

import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.impl.SsmFilterImpl;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.biz.validation.script.ScriptManager;
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

    public static final SsmFilterType FILTER_TYPE = SsmFilterType.POISON;

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private ScriptManager scriptManager;

    public boolean validate(String name) {
        List<SsmFilterImpl> filters = filterDao.findFilters(FILTER_TYPE);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        for (SsmFilterImpl filter : filters) {
            if (!scriptManager.executePoisonFilter(filter.getScript(), map))
                return false;
        }
        return true;
    }
}
