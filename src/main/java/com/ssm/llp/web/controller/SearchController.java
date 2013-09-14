package com.ssm.llp.web.controller;

import com.ssm.llp.biz.validation.PoisonValidator;
import com.ssm.llp.biz.validation.SearchValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * @author rafizan.baharum
 * @since 9/9/13
 */
@Controller
@org.springframework.web.bind.annotation.RequestMapping("/search")
public class SearchController {

    private Logger log = LoggerFactory.getLogger(SearchController.class);

    private PoisonValidator poisonValidator;

    private SearchValidator searchValidator;


    @org.springframework.web.bind.annotation.RequestMapping(value = "/validate", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public String validateName(ModelMap model) {
        return "index";
    }
}
