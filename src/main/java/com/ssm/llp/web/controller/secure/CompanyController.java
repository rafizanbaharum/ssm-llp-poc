package com.ssm.llp.web.controller.secure;

import com.ssm.llp.biz.manager.CompanyRegistrationManager;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmNameType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
    private SessionFactory sessionFactory;

    @Autowired
    private SsmNameDao nameDao;

    @Autowired
    private SsmCompanyDao companyDao;

    @RequestMapping(value = "/reserve", method = {RequestMethod.GET})
    public String reserve(ModelMap model) {
        model.put("reserves", nameDao.findByOwner(SsmNameType.RESERVED, getCurrentUser()));
        return "secure/reserve";
    }

    @RequestMapping(value = "/reserve/{name}/{type}/{waived}", method = {RequestMethod.GET})
    public String makeReservation(@PathVariable String name, @PathVariable String type, @PathVariable boolean waived, ModelMap model) {
        registrationManager.reserveName(name, SsmCompanyType.valueOf(type), waived, getCurrentUser());
        return "redirect:/secure/company/reserve";
    }

    @RequestMapping(value = "/register/{name}/{type}/{waived}", method = {RequestMethod.GET})
    public String register(@PathVariable String name, @PathVariable String type, @PathVariable boolean waived, ModelMap model) {
        model.put("type", SsmCompanyType.valueOf(type));
        model.put("name", name);
        return "secure/register";
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

    @RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})
    public String edit(@PathVariable Long id, ModelMap model) {
        model.put("company", companyDao.findById(id));
        return "secure/company_edit";
    }

    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String view(@PathVariable Long id, ModelMap model) {
        SsmCompany company = companyDao.findById(id);
        model.put("company", company);
        model.put("members", company.getMembers());
        return "secure/company_view";
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public String update(@RequestParam Long id,
                         @RequestParam String name,
                         @RequestParam String phone,
                         @RequestParam String fax,
                         @RequestParam String address1,
                         @RequestParam String address2,
                         @RequestParam String address3,
                         ModelMap model) {
        SsmCompany n = companyDao.findById(id);
        n.setPhone(phone);
        n.setFax(fax);
        n.setAddress1(address1);
        n.setAddress2(address2);
        n.setAddress3(address3);
        companyDao.update(n, getCurrentUser());
        sessionFactory.getCurrentSession().flush();
        return "redirect:/secure/company/edit/" + n.getId();
    }

    @RequestMapping(value = "/confirm", method = {RequestMethod.POST})
    public String confirm(
            @RequestParam("name") String name,
            @RequestParam("companyType") String companyType,
            @RequestParam("registrar") String registrar,
            @RequestParam("paymentMethod") String paymentMethod,
            @RequestParam("waived") boolean waived,
            ModelMap model) {
        registrationManager.register(name, SsmCompanyType.LLP, waived, getCurrentUser());
        return "confirm";
    }
}
