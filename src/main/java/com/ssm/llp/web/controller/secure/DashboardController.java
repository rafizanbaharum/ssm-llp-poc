package com.ssm.llp.web.controller.secure;

import com.ssm.llp.biz.validation.ValidatorHelper;
import com.ssm.llp.biz.validation.ValidatorContext;
import com.ssm.llp.biz.validation.script.ScriptUtil;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.model.SsmCompany;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/secure/dashboard")
public class DashboardController extends SecureControllerSupport {

    private Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private SsmCompanyDao companyDao;

    @Autowired
    private ValidatorHelper validator;

    @Autowired
    private ScriptUtil scriptUtil;

    @Transactional
    @RequestMapping(value = "validate", method = RequestMethod.GET)
    public String validateDashboard(@RequestParam("name") String name, @RequestParam("type") String type, ModelMap model) {
        name = scriptUtil.scrubName(name);
        log.debug("validate: " + name);
        ValidatorContext context = validator.validate(name);
        model.put("context", context);
        model.put("name", name);
        model.put("type", type);
        return "secure/dashboard";
    }

    @RequestMapping(method = {RequestMethod.GET})
    public String dashboard(ModelMap model) {
        return "secure/dashboard";
    }

    @ModelAttribute("companies")
    public List<SsmCompany> getCompanies() {
        return companyDao.find();
    }
}
