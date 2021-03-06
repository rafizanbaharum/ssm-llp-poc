package com.ssm.llp.web.controller.secure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Controller
@RequestMapping("/secure/literature")
public class LiteratureController extends SecureControllerSupport {

    @RequestMapping(value = "/about", method = {RequestMethod.GET})
    public String legal(ModelMap model) {
        return "secure/about";
    }

    @RequestMapping(value = "/faq", method = {RequestMethod.GET})
    public String faq(ModelMap model) {
        return "secure/faq";
    }
}
