package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmPrincipalRoleDao;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.SsmPrincipalRoleImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.ssm.llp.core.model.SsmPrincipalType.GROUP;
import static com.ssm.llp.core.model.SsmPrincipalType.USER;

/**
 * @author rafizan.baharum
 * @since 9/15/13
 */
@Repository("principalRoleDao")
public class SsmPrincipalRoleDaoImpl implements SsmPrincipalRoleDao {

    private static final Logger log = Logger.getLogger(SsmPrincipalRoleDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public void grant(SsmPrincipal principal, SsmRoleType roleType, SsmUser user) {
        Session session = sessionFactory.getCurrentSession();
        // save principal role
        SsmPrincipalRole principalRole = new SsmPrincipalRoleImpl();
        principalRole = prepareMetadata(principalRole, user);
        principalRole.setRoleType(roleType);
        principalRole.setPrincipal(principal);
        session.save(principalRole);
    }

    @Override
    public void grant(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user) {
        for (SsmRoleType role : roleTypes) {
            grant(principal, role, user);
        }
    }

    private Query getQueryString(SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select r from SsmPrincipalRole r where r.principal = :principal and r.role = :role");
    }

    @Override
    public void revoke(SsmPrincipal principal, SsmRoleType roleType, SsmUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = getQueryString(principal);
        query.setEntity("principal", principal);
        query.setString("role", roleType.name());
        session.delete(query.uniqueResult());
    }

    @Override
    public void revoke(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user) {
        // TODO:

    }

    @Override
    public void revokeAll(SsmPrincipal principal, SsmUser user) {
        if (principal.getPrincipalType().equals(GROUP)) {
            revokeAll(principal);
        } else if (principal.getPrincipalType().equals(USER)) {
            revokeAll(principal);
        } else
            throw new IllegalArgumentException("Unknown principal type");
    }

    @Override
    public void overwrite(SsmPrincipal principal, SsmRoleType roleType, SsmUser user) {
        // TODO:

    }

    @Override
    public void overwrite(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user) {
        // TODO:
    }

    private void update(SsmUser user, SsmRoleType[] roleTypes, SsmUser adminUser) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from SsmPrincipalRole r where r.principal = :principal");
        query.setEntity("principal", user);
        List<SsmPrincipalRole> userRoles = (List<SsmPrincipalRole>) query.list();

        List<SsmPrincipalRole> newUserRoles = new ArrayList<SsmPrincipalRole>();
        for (SsmRoleType roleType : roleTypes) {
            SsmPrincipalRole principalRole = new SsmPrincipalRoleImpl();
            principalRole = prepareMetadata(principalRole, user);
            principalRole.setRoleType(roleType);
            principalRole.setPrincipal(user);
            newUserRoles.add(principalRole);
        }
        for (SsmPrincipalRole userRole : userRoles) {
            if (!newUserRoles.contains(userRole)) {
                System.out.println(userRole.getRoleType() + " removed");
                session.delete(userRole);
            }
        }

        for (SsmPrincipalRole newUserRole : newUserRoles) {
            if (!userRoles.contains(newUserRole)) {
                session.save(newUserRole);
            }
        }
    }

    public void update(SsmPrincipal principal, SsmPrincipalRole[] roles, SsmUser user) {
        if (principal.getPrincipalType().equals(GROUP)) {
            update((SsmGroup) principal, roles, user);
        } else if (principal.getPrincipalType().equals(USER)) {
            update((SsmUser) principal, roles, user);
        } else
            throw new IllegalArgumentException("Unknown principal type");
    }

    private void revokeAll(SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from SsmPrincipalRole r where r.principal = :principal");
        query.setEntity("principal", principal);
        List<SsmPrincipalRole> roles = (List<SsmPrincipalRole>) query.list();
        for (SsmPrincipalRole role : roles) {
            session.delete(role);
        }
    }

    protected SsmPrincipalRole prepareMetadata(SsmPrincipalRole principalRole, SsmUser user) {
        SsmMetadata metadata = new SsmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        metadata.setState(SsmMetaState.ACTIVE);
        principalRole.setMetadata(metadata);
        return principalRole;
    }
}
