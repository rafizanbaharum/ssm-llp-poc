package com.ssm.llp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/register")
public class LoginController {

    @RequestMapping(value = "/validate", method = {RequestMethod.GET})
    public String validateName(ModelMap model) {
        return "index";
    }

}
