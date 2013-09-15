package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmActorDao;
import com.ssm.llp.core.model.SsmActor;
import com.ssm.llp.core.model.SsmActorType;
import com.ssm.llp.core.model.SsmMetaState;
import com.ssm.llp.core.model.impl.SsmActorImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/15/13
 */
@Repository("actorDao")
public class SsmActorDaoImpl extends DaoSupport<Long, SsmActor, SsmActorImpl> implements SsmActorDao {

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public SsmActor findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (SsmActor) session.get(SsmActorImpl.class, id);
    }

    @Override
    public SsmActor findByIdentityNo(String identityNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from SsmActor a where " +
                "a.identityNo = :identityNo " +
                "and a.metadata.state = :state ");
        query.setString("identityNo", identityNo);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return (SsmActor) query.uniqueResult();
    }

    @Override
    public SsmActor findByNricNo(String nricNo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from SsmActor a where " +
                "a.nricNo = :nricNo " +
                "and a.metadata.state = :state ");
        query.setString("nricNo", nricNo);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return (SsmActor) query.uniqueResult();
    }

    @Override
    public List<SsmActor> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from SsmActor a where " +
                "a.metadata.state = :state " +
                "order by a.code");
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<SsmActor> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from SsmActor a where " +
                "(a.code like upper(:filter) " +
                "or upper(a.description) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<SsmActor> find(SsmActorType type, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from SsmActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public List<SsmActor> find(SsmActorType type, String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from SsmActor a where " +
                "(a.identityNo like upper(:filter) " +
                "or upper(a.name) like upper(:filter)) " +
                "and a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.list();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from SsmActor a where " +
                "a.metadata.state = :state");
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from SsmActor a where " +
                "(a.name like upper(:filter) " +
                "or upper(a.identityNo) like upper(:filter)) " +
                "and a.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(SsmActorType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(a) from SsmActor a where " +
                "a.actorType = :actorType " +
                "and a.metadata.state = :state");
        query.setInteger("actorType", type.ordinal());
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

}
