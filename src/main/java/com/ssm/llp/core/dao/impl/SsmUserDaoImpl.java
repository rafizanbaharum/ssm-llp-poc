package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmPrincipalDao;
import com.ssm.llp.core.dao.SsmUserDao;
import com.ssm.llp.core.model.SsmActor;
import com.ssm.llp.core.model.SsmGroup;
import com.ssm.llp.core.model.SsmMetaState;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.core.model.impl.SsmUserImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public class SsmUserDaoImpl extends DaoSupport<Long, SsmUser, SsmUserImpl> implements SsmUserDao {

    private static final Logger log = Logger.getLogger(SsmUserDaoImpl.class);

    @Autowired
    private SsmPrincipalDao principalDao;


    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public List<SsmGroup> findUserGroups(SsmUser user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select r from SsmGroup r inner join r.groupMembers m where m.principal = :user");
        query.setEntity("user", user);
        return (List<SsmGroup>) query.list();
    }

    @Override
    public boolean isExists(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from SsmUser u where " +
                "u.name = :username");
        query.setString("username", username);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public SsmUser findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (SsmUser) session.get(SsmUserImpl.class, id);
    }

    @Override
    public SsmUser findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from SsmUser u where u.name = :username and u.metadata.state = :state");
        query.setString("username", username);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return (SsmUser) query.uniqueResult();
    }

    @Override
    public SsmUser findByActor(SsmActor actor) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from SsmUser u where u.actor  = :actor");
        query.setEntity("actor", actor);
        return (SsmUser) query.uniqueResult();
    }

    public SsmUser findByRealName(String realname) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select u from SsmUser u where u.realname = :realname");
        query.setString("realname", realname);
        return (SsmUser) query.uniqueResult();
    }

    @Override
    public List<SsmUser> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from SsmUser s");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmUser>) query.list();
    }

    @Override
    public List<SsmUser> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select s from SsmUser s where (s.name like :filter or s.realname like upper(:filter))");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmUser>) query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(u) from SsmUser u");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(s) from SsmUser s where s.name like :filter " +
                "or s.realname like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }
}
