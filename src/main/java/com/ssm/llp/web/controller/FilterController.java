package com.ssm.llp.web.controller;

import com.ssm.llp.core.dao.SsmFilterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public String all(ModelMap model) {
        model.put("filters", filterDao.find());
        return "secure/filter";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String edit(@PathVariable Long id, ModelMap model) {
        model.put("filter", filterDao.findById(id));
        return "secure/editFilter";
    }
}
