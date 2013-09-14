package com.ssm.llp.integration.springsecurity;

/**
 * @author rafizan.baharum
 * @since 9/11/13
 */

import com.ssm.llp.core.dao.SsmPrincipalDao;
import com.ssm.llp.core.model.SsmMetaState;
import com.ssm.llp.core.model.SsmPrincipalRole;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.core.exception.RecursiveGroupException;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 */
@Service("userDetailService")
@Transactional
public class SsmUserDetailService implements UserDetailsService {

    private static final Logger log = Logger.getLogger(SsmUserDetailService.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Autowired
    private SsmPrincipalDao principalDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from SsmUser u where u.name = :username and u.metadata.state = :state");
        query.setString("username", s);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        SsmUser user = (SsmUser) query.uniqueResult();
        if (user == null)
            throw new UsernameNotFoundException("No such user");
        return new SsmUserDetails(user, loadGrantedAuthoritiesFor(user));
    }

    private Set<GrantedAuthority> loadGrantedAuthoritiesFor(SsmUser user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        try {
            //load all roles which ties to user
            for (SsmPrincipalRole role : user.getRoles()) {
                grantedAuthorities.add(new GrantedAuthorityImpl(role.getRoleType().name()));
            }
            log.info("load auth for " + user.getName() + "#" + user.getId());
            grantedAuthorities.addAll(principalDao.loadEffectiveAuthorities(user));
        } catch (RecursiveGroupException e) {
            log.error(e.getMessage());
            grantedAuthorities.clear();
        }
        return grantedAuthorities;
    }
}
