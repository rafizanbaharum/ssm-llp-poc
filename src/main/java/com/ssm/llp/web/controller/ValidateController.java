package com.ssm.llp.web.controller;

import com.ssm.llp.biz.validation.PoisonValidator;
import com.ssm.llp.biz.validation.SearchValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/9/13
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

    private Logger log = LoggerFactory.getLogger(ValidateController.class);

    @Autowired
    private PoisonValidator poisonValidator;

    @Autowired
    private SearchValidator searchValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String validate(@RequestParam("name") String name,@RequestParam("from") String from, ModelMap model) {
        log.debug("validate: " + name);
        boolean poisoned = false;
        boolean existed = false;
        poisoned = !poisonValidator.validate(name);
        log.debug("poisoned?: " + poisoned);
        model.put("valid", !poisoned);
        model.put("name", name);
        model.put("from", from);
        return "index";
    }

    @RequestMapping(value = "dashboard", method =  RequestMethod.GET)
    public String validateDashboard(@RequestParam("name") String name,@RequestParam("from") String from, ModelMap model) {
        validate(name,from,model);

        return "secure/dashboard";
    }

    @RequestMapping(value = "/json/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String validateJson(@PathVariable("name") String name, ModelMap model) {
        log.debug("validate: " + name);
        boolean poisoned = false;
        boolean existed = false;
        poisoned = !poisonValidator.validate(name);
        if (poisoned) return "Name not valid";
        else return "Name is valid";
    }
}
