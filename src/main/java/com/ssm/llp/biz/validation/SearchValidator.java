package com.ssm.llp.biz.validation;

import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.impl.SsmFilterImpl;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.biz.validation.script.ScriptManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */
@Component("searchValidator")
public class SearchValidator {

    public static final SsmFilterType FILTER_TYPE = SsmFilterType.SEARCH;

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private ScriptManager scriptManager;

    public List<SsmCompany> validate(String name) {
        List<SsmCompany> names = new ArrayList<SsmCompany>();
        List<SsmFilterImpl> filters = filterDao.findFilters(FILTER_TYPE);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", name);
        for (SsmFilterImpl filter : filters) {
            names.addAll(scriptManager.executeSearchFilter(filter.getScript(), map));
        }
        return names;
    }
}
