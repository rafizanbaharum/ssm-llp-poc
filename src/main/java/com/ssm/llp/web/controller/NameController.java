package com.ssm.llp.web.controller;

import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.integration.springsecurity.SsmUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/secure/name")
public class NameController {

    @Autowired
    private SsmNameDao nameDao;

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("offensives", nameDao.find(SsmNameType.OFFENSIVE));
        model.put("symbols", nameDao.find(SsmNameType.SYMBOL));
        return "secure/name";
    }

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String edit(@PathVariable Long id, ModelMap model) {
        model.put("name", nameDao.findById(id));
        return "secure/name_edit";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String update(@PathVariable Long id, @PathVariable String name, ModelMap model) {
        SsmName n = nameDao.findById(id);
        n.setName(name);
        nameDao.update(n, getCurrentUser());
        return "redirect:secure/name/" + n.getId();
    }


    public SsmUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((SsmUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

}
