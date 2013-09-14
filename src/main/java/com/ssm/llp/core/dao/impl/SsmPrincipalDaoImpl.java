package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmPrincipalDao;
import com.ssm.llp.core.dao.SsmRoleDao;
import com.ssm.llp.core.exception.RecursiveGroupException;
import com.ssm.llp.core.model.SsmMetaState;
import com.ssm.llp.core.model.SsmPrincipal;
import com.ssm.llp.core.model.SsmPrincipalType;
import com.ssm.llp.core.model.impl.SsmPrincipalImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/11/13
 */
@Repository("principalDao")
public class SsmPrincipalDaoImpl extends DaoSupport<Long, SsmPrincipal, SsmPrincipalImpl> implements SsmPrincipalDao {

    private static final Logger log = Logger.getLogger(SsmPrincipalDaoImpl.class);

    private SsmRoleDao roleDao;

    private boolean allowRecursiveGroup = false;

    private Set<String> groupName = null;

    //principal

    @Override
    public List<SsmPrincipal> findAllPrincipals() {
        Session session = sessionFactory.getCurrentSession();
        List<SsmPrincipal> results = new ArrayList<SsmPrincipal>();
        Query query = session.createQuery("select p from SsmUser p where p.metadata.state = :state order by p.name");
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        results.addAll((List<SsmPrincipal>) query.list());

        Query queryGroup = session.createQuery("select p from SsmGroup p where p.metadata.state = :state order by p.name ");
        queryGroup.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        results.addAll((List<SsmPrincipal>) queryGroup.list());

        return results;
    }

    @Override
    public List<SsmPrincipal> findPrincipals(String filter) {
        Session session = sessionFactory.getCurrentSession();
        List<SsmPrincipal> results = new ArrayList<SsmPrincipal>();
        Query query = session.createQuery("select p from SsmPrincipal p where p.metadata.state = :state and p.name like :filter order by p.name");
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        results.addAll((List<SsmPrincipal>) query.list());
        return results;
    }

    @Override
    public List<SsmPrincipal> findPrincipals(String filter, SsmPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        List<SsmPrincipal> results = new ArrayList<SsmPrincipal>();
        Query query = session.createQuery("select p from SsmPrincipal p where " +
                "p.metadata.state = :state " +
                "and p.name like :filter " +
                "and p.principalType = :principalType " +
                "order by p.name");
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("principalType", type.ordinal());
        results.addAll((List<SsmPrincipal>) query.list());
        return results;
    }

    /**
     * find principal
     *
     * @param offset offset
     * @param limit  limit
     * @return list of principals
     */
    @Override
    public List<SsmPrincipal> findPrincipals(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from SsmPrincipal p");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmPrincipal>) query.list();
    }

    public Set<GrantedAuthority> loadEffectiveAuthorities(SsmPrincipal principal) throws RecursiveGroupException {
        return new HashSet<GrantedAuthority>(); // todo
    }

    @Override
    public SsmPrincipal findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        log.debug("Searching for principal " + name);
        Query query = session.createQuery("select p from SsmPrincipal p where p.name = :name");
        query.setString("name", name);
        return (SsmPrincipal) query.uniqueResult();
    }
}



