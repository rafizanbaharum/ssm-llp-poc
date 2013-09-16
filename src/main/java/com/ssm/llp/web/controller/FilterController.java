package com.ssm.llp.web.controller;

import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.integration.springsecurity.SsmUserDetails;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/secure/filter")
public class FilterController {

    private Logger log = LoggerFactory.getLogger(FilterController.class);

    @Autowired
    private SessionFactory sessionFactory;

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
        return "secure/filter_edit";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String update(@RequestParam Long id, @RequestParam String name, @RequestParam String script, ModelMap model) {
        SsmFilter n = filterDao.findById(id);
        n.setName(name);
        n.setScript(script);
        filterDao.update(n, getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        return "redirect:/secure/filter/edit/" + n.getId();
    }

    @ModelAttribute
    public SsmUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((SsmUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

}
