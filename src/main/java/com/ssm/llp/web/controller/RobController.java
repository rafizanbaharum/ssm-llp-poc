package com.ssm.llp.web.controller;

import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.integration.springsecurity.SsmUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/secure/rob")
public class RobController  extends ControllerSupport{

    @Autowired
    private SsmCompanyDao companyDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("robs", companyDao.findByOwner(SsmCompanyType.ROB, getCurrentUser()));
        return "secure/rob";
    }
}

