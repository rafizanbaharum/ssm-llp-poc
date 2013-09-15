package com.ssm.llp.web.controller;

import com.ssm.llp.biz.validation.PoisonValidator;
import com.ssm.llp.biz.validation.SearchValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String validate(@RequestParam("name") String name, ModelMap model) {
        log.debug("validate: " + name);
        boolean poisoned = false;
        boolean existed = false;
        poisoned = !poisonValidator.validate(name);
        log.debug("poisoned?: " + poisoned);
        model.put("valid", !poisoned);
        return "index";
    }
}
