package com.ssm.llp.web.controller.secure;

import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;
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
@RequestMapping("/secure/name")
public class NameController extends SecureControllerSupport {

    @Autowired
    private SsmNameDao nameDao;

    @RequestMapping(value = "/all", method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("names", nameDao.find());
        return "secure/name";
    }

    @RequestMapping(value = "/gazetted", method = {RequestMethod.GET})
    public String gazetted(ModelMap model) {
        model.put("names", nameDao.find(SsmNameType.GAZETTED));
        return "secure/gazetted";
    }

    @RequestMapping(value = "/controlled", method = {RequestMethod.GET})
    public String controlled(ModelMap model) {
        model.put("names", nameDao.find(SsmNameType.CONTROLLED));
        return "secure/controlled";
    }

    @RequestMapping(value = "/offensive", method = {RequestMethod.GET})
    public String offensive(ModelMap model) {
        model.put("names", nameDao.find(SsmNameType.OFFENSIVE));
        return "secure/offensive";
    }

    @RequestMapping(value = "/plural", method = {RequestMethod.GET})
    public String plural(ModelMap model) {
        model.put("names", nameDao.find(SsmNameType.PLURAL));
        return "secure/plural";
    }

    @RequestMapping(value = "/similar", method = {RequestMethod.GET})
    public String similar(ModelMap model) {
        model.put("names", nameDao.find(SsmNameType.SIMILAR));
        return "secure/similar";
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
}
