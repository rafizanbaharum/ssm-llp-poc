package com.ssm.llp.web.controller.secure;

import com.ssm.llp.biz.manager.CompanyRegistrationManager;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmNameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Controller
@RequestMapping("/secure/company")
public class CompanyController extends SecureControllerSupport {

    @Autowired
    private CompanyRegistrationManager registrationManager;

    @Autowired
    private SsmNameDao nameDao;

    @Autowired
    private SsmCompanyDao companyDao;

    @RequestMapping(value = "/reserve", method = {RequestMethod.GET})
    public String reserve(ModelMap model) {
        model.put("reserves", nameDao.findByOwner(SsmNameType.RESERVED, getCurrentUser()));
        return "secure/reserve";
    }

    @RequestMapping(value = "/llp", method = {RequestMethod.GET})
    public String llp(ModelMap model) {
        model.put("llps", companyDao.findByOwner(SsmCompanyType.LLP, getCurrentUser()));
        return "secure/llp";
    }

    @RequestMapping(value = "/rob", method = {RequestMethod.GET})
    public String rob(ModelMap model) {
        model.put("robs", companyDao.findByOwner(SsmCompanyType.ROB, getCurrentUser()));
        return "secure/rob";
    }

    @RequestMapping(value = "/roc", method = {RequestMethod.GET})
    public String roc(ModelMap model) {
        model.put("rocs", companyDao.findByOwner(SsmCompanyType.ROC, getCurrentUser()));
        return "secure/roc";
    }


    @RequestMapping(value = "/register", method = {RequestMethod.GET})
    public String register(ModelMap model) {
        model.put("name", "TEST NAMA");
        return "secure/register";
    }

    @RequestMapping(value = "/confirm", method = {RequestMethod.POST})
    public String confirm(
            @RequestParam("name") String name,
            @RequestParam("companyType") String companyType,
            @RequestParam("registrar") String registrar,
            @RequestParam("paymentMethod") String paymentMethod,
            ModelMap model) {
        registrationManager.register(name, SsmCompanyType.LLP, getCurrentUser());
        return "confirm";
    }
}
