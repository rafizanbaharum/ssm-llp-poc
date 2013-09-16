package com.ssm.llp.web.controller;

import com.ssm.llp.biz.manager.UserRegistrationManager;
import com.ssm.llp.core.dao.SsmNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private UserRegistrationManager registrationManager;

    @Autowired
    private SsmNameDao nameDao;

    @RequestMapping(method = {RequestMethod.GET})
    public String go(ModelMap model) {
        model.put("name", "xxx");
        return "register";
    }

    @RequestMapping(method = {RequestMethod.POST})
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("nricNo") String nricNo,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("fax") String fax,
            @RequestParam("address1") String address1,
            @RequestParam("address2") String address2,
            @RequestParam("address3") String address3,
            ModelMap model) {

        registrationManager.register(username, password,
                name, nricNo, email, phone, fax,
                address1, address2, address3);

        return "registered";
    }
}
