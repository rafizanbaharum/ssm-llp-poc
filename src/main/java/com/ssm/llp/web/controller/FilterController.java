package com.ssm.llp.web.controller;

import com.ssm.llp.core.dao.SsmFilterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/secure/filter")
public class FilterController {

    @Autowired
    private SsmFilterDao filterDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("filters", filterDao.find());
        return "secure/filter";
    }
}
