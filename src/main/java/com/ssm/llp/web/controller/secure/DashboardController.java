package com.ssm.llp.web.controller.secure;

import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.model.SsmCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/secure/dashboard")
public class DashboardController extends SecureControllerSupport {

    @Autowired
    private SsmCompanyDao companyDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String dashboard(ModelMap model) {
        return "secure/dashboard";
    }

    @ModelAttribute("companies")
    public List<SsmCompany> getCompanies() {
        return companyDao.find();
    }
}
