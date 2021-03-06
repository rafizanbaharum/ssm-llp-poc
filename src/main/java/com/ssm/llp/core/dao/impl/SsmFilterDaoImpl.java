package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.core.model.impl.SsmFilterImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Repository("FilterDao")
public class SsmFilterDaoImpl extends DaoSupport<Long, SsmFilter, SsmFilterImpl> implements SsmFilterDao, Serializable {

    @Override
    public SsmFilter findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from SsmFilter f where f.id = :id");
        query.setLong("id", id);
        return (SsmFilterImpl) query.uniqueResult();
    }

    @Override
    public SsmFilter findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from SsmFilter f where f.name = :name");
        query.setString("name", name);
        return (SsmFilterImpl) query.uniqueResult();
    }

    @Override
    public List<SsmFilter> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from SsmFilter f");
        return (List<SsmFilter>) query.list();
    }

    @Override
    public List<SsmFilter> find(SsmFilterType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from SsmFilter f where f.filterType = :filterType");
        query.setInteger("filterType", type.ordinal());
        return (List<SsmFilter>) query.list();
    }
}
