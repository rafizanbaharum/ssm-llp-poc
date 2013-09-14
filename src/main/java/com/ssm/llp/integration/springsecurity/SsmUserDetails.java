package com.ssm.llp.integration.springsecurity;

import com.ssm.llp.core.model.SsmUser;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 7/12/13
 */
@Component("userDetails")
@Transactional
public class SsmUserDetails implements UserDetails {

    private static final Logger log = Logger.getLogger(SsmUserDetails.class);

    private SsmUser user;
    private Set<GrantedAuthority> grantedAuthorities;

    public SsmUserDetails() {
    }

    public SsmUserDetails(SsmUser user, Set<GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.isLocked();
    }

    public void setUser(SsmUser user) {
        this.user = user;
    }

    public SsmUser getUser() {
        return user;
    }

    public String getRealname() {
        return user.getRealname();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public Long getId() {
        return user.getId();
    }
}
