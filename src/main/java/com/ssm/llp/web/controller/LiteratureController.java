package com.ssm.llp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Controller(value = "nonsecureLiteratureController")
@RequestMapping("/literature")
public class LiteratureController {

    @RequestMapping(value = "/about", method = {RequestMethod.GET})
    public String legal(ModelMap model) {
        return "about";
    }

    @RequestMapping(value = "/faq", method = {RequestMethod.GET})
    public String faq(ModelMap model) {
        return "faq";
    }
}
