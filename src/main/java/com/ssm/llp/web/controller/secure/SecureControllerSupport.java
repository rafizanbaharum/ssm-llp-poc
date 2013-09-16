package com.ssm.llp.web.controller.secure;

import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.integration.springsecurity.SsmUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
public class SecureControllerSupport {

    @ModelAttribute("currentUser")
    protected SsmUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((SsmUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

}
