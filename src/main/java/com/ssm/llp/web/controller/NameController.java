package com.ssm.llp.web.controller;

import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmNameType;
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
@RequestMapping("/secure/name")
public class NameController {

    @Autowired
    private SsmNameDao nameDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("offensives", nameDao.find(SsmNameType.OFFENSIVE));
        model.put("symbols", nameDao.find(SsmNameType.SYMBOL));
        return "secure/name";
    }

}
