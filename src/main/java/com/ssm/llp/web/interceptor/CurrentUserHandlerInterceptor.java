package com.ssm.llp.web.interceptor;

import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.integration.springsecurity.SsmUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
public class CurrentUserHandlerInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(CurrentUserHandlerInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (null != request.getSession())
            request.getSession().setAttribute("currentUser", getCurrentUser());
    }

    private SsmUser getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) {
            return ((SsmUserDetails) auth.getPrincipal()).getUser();
        } else {
            return null;
        }
    }

}
