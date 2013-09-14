package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.model.*;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public class DaoSupport<K, I, E> implements InitializingBean {

    private static final Logger log = Logger.getLogger(DaoSupport.class);

    public static final String WILDCARD = "%";

    @Autowired(required = true)
    protected SessionFactory sessionFactory;

    // entity
    private Class<I> interfaceClass;
    private Class<E> entityClass;


    @Override
    public void afterPropertiesSet() throws Exception {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        interfaceClass = (Class<I>) genericSuperclass.getActualTypeArguments()[1];
        entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[2];
    }

    public I refresh(I i) {
        sessionFactory.getCurrentSession().refresh(i);
        return i;
    }

    public I findById(K k) {
        Session session = sessionFactory.getCurrentSession();
        return (I) session.get(entityClass, (Serializable) k);
    }

    /**
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public List<I> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a "
                + " from " + interfaceClass.getName() + "  a");
        return (List<I>) query.list();
    }

    /**
     * @param offset
     * @param limit
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public List<I> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a "
                + " from " + entityClass.getName() + " a");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<I>) query.list();
    }

    protected void prepareMetadata(I i, SsmUser user) {
        if (i instanceof SsmMetaObject) {
            SsmMetadata metadata = null;
            if (((SsmMetaObject) i).getMetadata() != null)
                metadata = ((SsmMetaObject) i).getMetadata();
            else
                metadata = new SsmMetadata();
            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            metadata.setCreator(user.getId());
            metadata.setState(SsmMetaState.ACTIVE);
            ((SsmMetaObject) i).setMetadata(metadata);
        }
    }

    protected void prepareFlowdata(I i, SsmUser user) {
        if (i instanceof SsmFlowObject) {
            SsmFlowdata flowdata = null;
            if (((SsmFlowObject) i).getFlowdata() != null)
                flowdata = ((SsmFlowObject) i).getFlowdata();
            else
                flowdata = new SsmFlowdata();
            flowdata.setState(SsmFlowState.DRAFTED);
            flowdata.setDraftedDate(new Timestamp(System.currentTimeMillis()));
            flowdata.setDrafter(user.getId());
            ((SsmFlowObject) i).setFlowdata(flowdata);
        }
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void save(I entity, SsmUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        try {
            // session
            Session session = sessionFactory.getCurrentSession();

            // prepare metadata
            prepareMetadata(entity, user);
            prepareFlowdata(entity, user);

            // save
            session.save(entity);
        } catch (HibernateException e) {
            log.debug("error occured", e);
        }
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void saveOrUpdate(I entity, SsmUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        try {
            // session
            Session session = sessionFactory.getCurrentSession();

            // prepare metadata
            prepareMetadata(entity, user);
            prepareFlowdata(entity, user);

            // save
            session.saveOrUpdate(entity);
        } catch (HibernateException e) {
            log.debug("error occured", e);
        }
    }

    public void save(Session session, I i, SsmUser user) {

        // sanity check
        // sanity check
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(i, "Object cannot be null");

        // prepare metadata
        prepareMetadata(i, user);
        prepareFlowdata(i, user);

        // save
        session.save(i);
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void update(I entity, SsmUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        SsmMetadata metadata = ((SsmMetaObject) entity).getMetadata();
        if (null == metadata) {
            metadata = new SsmMetadata();
            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            metadata.setCreator(user.getId());
            metadata.setState(SsmMetaState.ACTIVE);
        }
        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        ((SsmMetaObject) entity).setMetadata(metadata);

        // update
        session.update(entity);
    }

    /**
     * @param entity
     * @param user
     * @return
     * @throws org.springframework.dao.DataAccessException
     *
     */
    public void deactivate(I entity, SsmUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        SsmMetadata metadata = ((SsmMetaObject) entity).getMetadata();
        if (null == metadata) {
            metadata = new SsmMetadata();
            metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            metadata.setCreator(user.getId());
        }

        metadata.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setModifier(user.getId());
        metadata.setState(SsmMetaState.INACTIVE);
        ((SsmMetaObject) entity).setMetadata(metadata);

        // update
        session.update(entity);
    }

    /**
     * @param entity
     * @param user
     */
    public void remove(I entity, SsmUser user) {
        Validate.notNull(user, "User cannot be null");
        Validate.notNull(entity, "Object cannot be null");

        // session
        Session session = sessionFactory.getCurrentSession();

        // prepare metadata
        SsmMetadata metadata = ((SsmMetaObject) entity).getMetadata();
        metadata.setState(SsmMetaState.INACTIVE);
        metadata.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setDeleter(user.getId());
        ((SsmMetaObject) entity).setMetadata(metadata);

        // update
        session.update(entity);
    }
}